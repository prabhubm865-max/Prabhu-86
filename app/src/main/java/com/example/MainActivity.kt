package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.audio.KannadaAudioPlayer
import com.example.data.LearningLevelId
import com.example.data.Topic
import com.example.data.UserProgressManager
import com.example.ui.components.AppNavTab
import com.example.ui.components.BottomNavBar
import com.example.ui.components.ConfettiOverlay
import com.example.ui.components.TopHeaderBar
import com.example.ui.screens.AchievementsScreen
import com.example.ui.screens.GamesScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LearningLevelsScreen
import com.example.ui.screens.LessonDetailScreen
import com.example.ui.screens.ProgressScreen
import com.example.ui.screens.WelcomeScreen
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    private lateinit var audioPlayer: KannadaAudioPlayer
    private lateinit var progressManager: UserProgressManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        audioPlayer = KannadaAudioPlayer(this)
        progressManager = UserProgressManager(this)

        setContent {
            MyApplicationTheme {
                MainContent(
                    audioPlayer = audioPlayer,
                    progressManager = progressManager
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        audioPlayer.shutdown()
    }
}

@Composable
fun MainContent(
    audioPlayer: KannadaAudioPlayer,
    progressManager: UserProgressManager
) {
    val progressState by progressManager.progressState.collectAsState()

    var showWelcomeScreen by remember { mutableStateOf(true) }
    var activeTab by remember { mutableStateOf(AppNavTab.HOME) }
    var selectedTopic by remember { mutableStateOf<Topic?>(null) }
    var selectedLevelIdForTab by remember { mutableStateOf(LearningLevelId.LEVEL_1) }
    var showConfetti by remember { mutableStateOf(false) }

    if (showWelcomeScreen) {
        WelcomeScreen(
            onStartLearningClicked = {
                audioPlayer.playSuccessSound()
                showWelcomeScreen = false
            }
        )
    } else {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopHeaderBar(
                    starsCount = progressState.starsEarned,
                    streakDays = progressState.streakDays
                )
            },
            bottomBar = {
                if (selectedTopic == null) {
                    BottomNavBar(
                        selectedTab = activeTab,
                        onTabSelected = {
                            activeTab = it
                            selectedTopic = null
                        }
                    )
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                if (selectedTopic != null) {
                    LessonDetailScreen(
                        topic = selectedTopic!!,
                        isCompleted = progressState.completedTopics.contains(selectedTopic!!.id),
                        onMarkCompleted = { topicId ->
                            progressManager.markTopicCompleted(topicId)
                            audioPlayer.playSuccessSound()
                            showConfetti = true
                        },
                        onSpeakRequested = { text ->
                            audioPlayer.speak(text)
                        },
                        onBackClicked = {
                            selectedTopic = null
                        }
                    )
                } else {
                    when (activeTab) {
                        AppNavTab.HOME -> {
                            HomeScreen(
                                progressState = progressState,
                                onStartLearningClicked = {
                                    selectedLevelIdForTab = LearningLevelId.LEVEL_1
                                    activeTab = AppNavTab.LEARN
                                },
                                onStartGamesClicked = {
                                    activeTab = AppNavTab.GAMES
                                },
                                onLevelSelected = { levelId ->
                                    selectedLevelIdForTab = levelId
                                    activeTab = AppNavTab.LEARN
                                },
                                onDailyCheckIn = {
                                    val checkedIn = progressManager.recordDailyCheckIn()
                                    if (checkedIn) {
                                        audioPlayer.playSuccessSound()
                                        showConfetti = true
                                    }
                                }
                            )
                        }

                        AppNavTab.LEARN -> {
                            LearningLevelsScreen(
                                completedTopics = progressState.completedTopics,
                                initialLevelId = selectedLevelIdForTab,
                                onTopicSelected = { topic ->
                                    selectedTopic = topic
                                }
                            )
                        }

                        AppNavTab.GAMES -> {
                            GamesScreen(
                                onStarsAwarded = { stars ->
                                    progressManager.addStars(stars)
                                    audioPlayer.playSuccessSound()
                                    showConfetti = true
                                },
                                onSpeakRequested = { text ->
                                    audioPlayer.speak(text)
                                }
                            )
                        }

                        AppNavTab.ACHIEVEMENTS -> {
                            AchievementsScreen(
                                unlockedBadgeIds = progressState.unlockedBadgeIds,
                                currentStars = progressState.starsEarned
                            )
                        }

                        AppNavTab.PROGRESS -> {
                            ProgressScreen(
                                progressState = progressState,
                                onAddTeacherNote = { note ->
                                    progressManager.addTeacherNote(note)
                                    audioPlayer.playSuccessSound()
                                },
                                onAddTeacherResource = { title, category, content, teacherName ->
                                    progressManager.addTeacherResource(title, category, content, teacherName)
                                    audioPlayer.playSuccessSound()
                                },
                                onDeleteTeacherResource = { id ->
                                    progressManager.deleteTeacherResource(id)
                                },
                                onSpeakRequested = { text ->
                                    audioPlayer.speak(text)
                                },
                                onResetProgress = {
                                    progressManager.resetProgress()
                                }
                            )
                        }
                    }
                }

                // Celebration Confetti particle animation
                ConfettiOverlay(
                    isVisible = showConfetti,
                    onAnimationEnd = { showConfetti = false }
                )
            }
        }
    }
}
