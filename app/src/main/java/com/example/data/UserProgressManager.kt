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
    val notes: List<StudentNote> = emptyList(),
    val teacherResources: List<TeacherResource> = emptyList()
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

        val resourcesJsonStr = prefs.getString("teacher_resources", "[]") ?: "[]"
        val resourcesList = mutableListOf<TeacherResource>()
        try {
            val jsonArray = JSONArray(resourcesJsonStr)
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                resourcesList.add(
                    TeacherResource(
                        id = obj.getString("id"),
                        title = obj.getString("title"),
                        category = obj.optString("category", "ಮನೆಗೆಲಸ (Homework)"),
                        content = obj.getString("content"),
                        date = obj.getString("date"),
                        teacherName = obj.optString("teacherName", "ಶಿಕ್ಷಕರು (KPS Kakol)"),
                        linkUrl = obj.optString("linkUrl", "")
                    )
                )
            }
        } catch (e: Exception) {
            // ignore
        }

        if (resourcesList.isEmpty()) {
            val dateToday = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
            resourcesList.add(
                TeacherResource(
                    id = "tr1",
                    title = "ಅಕ್ಷರ ಅಭ್ಯಾಸ ಮತ್ತು ದಿನನಿತ್ಯದ ಬರವಣಿಗೆ",
                    category = "ಮನೆಗೆಲಸ (Homework)",
                    content = "ದಿನವೂ ೫ ಬಾರಿ ಸ್ವರಗಳು (ಅ-ಅಃ) ಹಾಗೂ ಕ-ವರ್ಗದ ವ್ಯಂಜನಗಳನ್ನು ನೋಟ್‌ಬುಕ್‌ನಲ್ಲಿ ಬರೆದು ಅಭ್ಯಾಸ ಮಾಡಿ.",
                    date = dateToday,
                    teacherName = "ಶ್ರೀಮತಿ ಶಾರದಮ್ಮ (KPS Kakol)"
                )
            )
            resourcesList.add(
                TeacherResource(
                    id = "tr2",
                    title = "ದ್ವಿಭಾಷಾ ಇಂಗ್ಲಿಷ್ ಸಂಭಾಷಣೆ - ದಿನ ಬಳಕೆಯ ವಾಕ್ಯಗಳು",
                    category = "ಪಾಠ ಟಿಪ್ಪಣಿ (Lesson Notes)",
                    content = "ಮನೆಯಲ್ಲಿ ಪೋಷಕರೊಂದಿಗೆ ೫ ಸರಳ ಇಂಗ್ಲಿಷ್ ವಾಕ್ಯಗಳನ್ನು ಬಳಸಿ ಮಾತನಾಡಿ (Good morning, Open your book, Thank you, How are you?).",
                    date = dateToday,
                    teacherName = "ಪ್ರಭು ಬಿ.ಎಮ್. (KPS Kakol)"
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
            notes = notesList,
            teacherResources = resourcesList
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

    fun addTeacherResource(
        title: String,
        category: String,
        content: String,
        teacherName: String = "ಶಿಕ್ಷಕರು (KPS Kakol)",
        linkUrl: String = ""
    ) {
        val currentResources = _progressState.value.teacherResources.toMutableList()
        val dateStr = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        val newResource = TeacherResource(
            id = "res_${System.currentTimeMillis()}",
            title = title,
            category = category,
            content = content,
            date = dateStr,
            teacherName = teacherName,
            linkUrl = linkUrl
        )
        currentResources.add(0, newResource)

        saveTeacherResources(currentResources)
        updateState()
    }

    fun deleteTeacherResource(id: String) {
        val filtered = _progressState.value.teacherResources.filter { it.id != id }
        saveTeacherResources(filtered)
        updateState()
    }

    private fun saveTeacherResources(list: List<TeacherResource>) {
        val jsonArray = JSONArray()
        list.forEach { res ->
            val obj = JSONObject()
            obj.put("id", res.id)
            obj.put("title", res.title)
            obj.put("category", res.category)
            obj.put("content", res.content)
            obj.put("date", res.date)
            obj.put("teacherName", res.teacherName)
            obj.put("linkUrl", res.linkUrl)
            jsonArray.put(obj)
        }
        prefs.edit().putString("teacher_resources", jsonArray.toString()).apply()
    }

    fun resetProgress() {
        prefs.edit().clear().apply()
        updateState()
    }

    private fun updateState() {
        _progressState.value = loadState()
    }
}
