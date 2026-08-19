package com.example.data

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class UserProgressState(
    val starsEarned: Int = 0,
    val completedTopics: Set<String> = emptySet(),
    val unlockedBadgeIds: Set<String> = emptySet(),
    val streakDays: Int = 3,
    val lastCheckInDate: String = "",
    val totalQuizzesAttempted: Int = 0,
    val totalCorrectAnswers: Int = 0,
    val studentName: String = "ವಿದ್ಯಾರ್ಥಿ (Student)",
    val notes: List<StudentNote> = emptyList()
)

class UserProgressManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("kps_kannada_progress", Context.MODE_PRIVATE)

    private val _progressState = MutableStateFlow(loadState())
    val progressState: StateFlow<UserProgressState> = _progressState.asStateFlow()

    private fun loadState(): UserProgressState {
        val stars = prefs.getInt("stars_earned", 10)
        val completedTopics = prefs.getStringSet("completed_topics", emptySet()) ?: emptySet()
        val unlockedBadges = prefs.getStringSet("unlocked_badges", setOf("b1")) ?: setOf("b1")
        val streak = prefs.getInt("streak_days", 3)
        val lastCheckIn = prefs.getString("last_checkin_date", "") ?: ""
        val quizzes = prefs.getInt("quizzes_attempted", 5)
        val correct = prefs.getInt("correct_answers", 18)
        val name = prefs.getString("student_name", "ಕನ್ನಡ ಕಲಿತ್ (Student)") ?: "ಕನ್ನಡ ಕಲಿತ್"

        val notesJsonStr = prefs.getString("student_notes", "[]") ?: "[]"
        val notesList = mutableListOf<StudentNote>()
        try {
            val jsonArray = JSONArray(notesJsonStr)
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                notesList.add(
                    StudentNote(
                        id = obj.getString("id"),
                        date = obj.getString("date"),
                        noteText = obj.getString("noteText"),
                        author = obj.getString("author")
                    )
                )
            }
        } catch (e: Exception) {
            // ignore
        }

        if (notesList.isEmpty()) {
            notesList.add(
                StudentNote(
                    id = "n1",
                    date = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date()),
                    noteText = "ಸ್ವರಗಳು ಮತ್ತು ವ್ಯಂಜನಗಳ ಅಭ್ಯಾಸವನ್ನು ಅತ್ಯುತ್ತಮವಾಗಿ ಪೂರ್ಣಗೊಳಿಸಿದ್ದೀರಿ! ಅಭಿನಂದನೆಗಳು.",
                    author = "ಶಿಕ್ಷಕರು (Teacher)"
                )
            )
        }

        return UserProgressState(
            starsEarned = stars,
            completedTopics = completedTopics,
            unlockedBadgeIds = unlockedBadges,
            streakDays = streak,
            lastCheckInDate = lastCheckIn,
            totalQuizzesAttempted = quizzes,
            totalCorrectAnswers = correct,
            studentName = name,
            notes = notesList
        )
    }

    fun recordDailyCheckIn(): Boolean {
        val todayStr = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        if (_progressState.value.lastCheckInDate == todayStr) {
            return false // Already checked in today
        }

        val newStreak = _progressState.value.streakDays + 1
        val newStars = _progressState.value.starsEarned + 10

        prefs.edit()
            .putInt("streak_days", newStreak)
            .putString("last_checkin_date", todayStr)
            .putInt("stars_earned", newStars)
            .apply()

        checkBadgeUnlocks(newStars)
        updateState()
        return true
    }

    fun addStars(count: Int) {
        val newStars = _progressState.value.starsEarned + count
        prefs.edit().putInt("stars_earned", newStars).apply()
        checkBadgeUnlocks(newStars)
        updateState()
    }

    fun markTopicCompleted(topicId: String) {
        val newSet = _progressState.value.completedTopics.toMutableSet().apply { add(topicId) }
        prefs.edit().putStringSet("completed_topics", newSet).apply()
        addStars(10)
        updateState()
    }

    fun recordQuizResult(correctCount: Int, total: Int) {
        val curQuizzes = _progressState.value.totalQuizzesAttempted + 1
        val curCorrect = _progressState.value.totalCorrectAnswers + correctCount
        val addedStars = correctCount * 5
        val newStars = _progressState.value.starsEarned + addedStars

        prefs.edit()
            .putInt("quizzes_attempted", curQuizzes)
            .putInt("correct_answers", curCorrect)
            .putInt("stars_earned", newStars)
            .apply()

        checkBadgeUnlocks(newStars)
        updateState()
    }

    private fun checkBadgeUnlocks(currentStars: Int) {
        val unlocked = _progressState.value.unlockedBadgeIds.toMutableSet()
        KannadaRepository.defaultBadges.forEach { badge ->
            if (currentStars >= badge.requiredStars) {
                unlocked.add(badge.id)
            }
        }
        prefs.edit().putStringSet("unlocked_badges", unlocked).apply()
    }

    fun updateStudentName(name: String) {
        prefs.edit().putString("student_name", name).apply()
        updateState()
    }

    fun addTeacherNote(text: String, author: String = "ಶಿಕ್ಷಕರು") {
        val currentNotes = _progressState.value.notes.toMutableList()
        val dateStr = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        val newNote = StudentNote(
            id = "note_${System.currentTimeMillis()}",
            date = dateStr,
            noteText = text,
            author = author
        )
        currentNotes.add(0, newNote)

        val jsonArray = JSONArray()
        currentNotes.forEach { note ->
            val obj = JSONObject()
            obj.put("id", note.id)
            obj.put("date", note.date)
            obj.put("noteText", note.noteText)
            obj.put("author", note.author)
            jsonArray.put(obj)
        }

        prefs.edit().putString("student_notes", jsonArray.toString()).apply()
        updateState()
    }

    fun resetProgress() {
        prefs.edit().clear().apply()
        updateState()
    }

    private fun updateState() {
        _progressState.value = loadState()
    }
}
