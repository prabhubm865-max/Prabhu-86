package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.KannadaRepository
import com.example.data.LearningLevelId
import com.example.data.UserProgressState
import com.example.ui.theme.VibrantAmber
import com.example.ui.theme.VibrantBlue
import com.example.ui.theme.VibrantBorderLight
import com.example.ui.theme.VibrantEmerald
import com.example.ui.theme.VibrantIndigo
import com.example.ui.theme.VibrantPink
import com.example.ui.theme.VibrantPurple
import com.example.ui.theme.VibrantRose
import com.example.ui.theme.VibrantTextDark
import com.example.ui.theme.VibrantTextMuted

import com.example.ui.components.DailyStreakCard
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreen(
    progressState: UserProgressState,
    onStartLearningClicked: () -> Unit,
    onStartGamesClicked: () -> Unit,
    onLevelSelected: (LearningLevelId) -> Unit,
    onDailyCheckIn: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val totalTopicsCount = KannadaRepository.levels.sumOf { it.topics.size }
    val completedCount = progressState.completedTopics.size
    val progressPercent = if (totalTopicsCount > 0) (completedCount * 100 / totalTopicsCount) else 0

    val todayStr = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    val isCheckedInToday = progressState.lastCheckInDate == todayStr

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { Spacer(modifier = Modifier.height(4.dp)) }

        // Government School Hero Image at the Start
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, VibrantBorderLight, RoundedCornerShape(24.dp)),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.img_govt_school_hero),
                        contentDescription = "ಸರ್ಕಾರಿ ಶಾಲೆ - KPS ಕಾಕೋಳು",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(185.dp)
                            .clip(RoundedCornerShape(24.dp)),
                        contentScale = ContentScale.Crop
                    )

                    // School Title Overlay Badge
                    Box(
                        modifier = Modifier
                            .padding(12.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color.Black.copy(alpha = 0.65f))
                            .padding(horizontal = 14.dp, vertical = 6.dp)
                            .align(Alignment.BottomStart)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("🏫", fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "ಸರ್ಕಾರಿ ಹಿರಿಯ ಪ್ರಾಥಮಿಕ ಶಾಲೆ, ಕಾಕೋಳು (KPS)",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }

        // Hero Gradient Banner
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.linearGradient(
                                colors = listOf(
                                    VibrantIndigo,
                                    VibrantPurple,
                                    VibrantPink
                                )
                            )
                        )
                        .padding(22.dp)
                ) {
                    Column {
                        Text(
                            text = "ನಮಸ್ಕಾರ, ವಿದ್ಯಾರ್ಥಿ! 👋",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White.copy(alpha = 0.9f)
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "ಆಟದ ಮೂಲಕ ಕನ್ನಡ ಕಲಿಯೋಣ!",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            fontSize = 24.sp
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "ಕಲಿಯೋಣ, ಆಡೋಣ, ಗೆಲ್ಲೋಣ! ಪ್ರತಿದಿನ ಹೊಸ ಹೊಸ ಕನ್ನಡ ಪದಗಳನ್ನು ಕಲಿಯಿರಿ.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White.copy(alpha = 0.92f),
                            lineHeight = 20.sp
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        // Banner Progress Pill
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.White.copy(alpha = 0.2f))
                                .padding(horizontal = 14.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = "ಪ್ರಗತಿ: $completedCount/$totalTopicsCount ಪಾಠಗಳು",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            LinearProgressIndicator(
                                progress = { (progressPercent / 100f).coerceIn(0f, 1f) },
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(8.dp)
                                    .clip(CircleShape),
                                color = VibrantEmerald,
                                trackColor = Color.White.copy(alpha = 0.4f)
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        // Quick Call to Action Buttons
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Button(
                                onClick = onStartLearningClicked,
                                colors = ButtonDefaults.buttonColors(containerColor = VibrantEmerald),
                                shape = RoundedCornerShape(16.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("📖 ಕಲಿಕೆ ಪ್ರಾರಂಭಿಸಿ", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                            }

                            Button(
                                onClick = onStartGamesClicked,
                                colors = ButtonDefaults.buttonColors(containerColor = VibrantBlue),
                                shape = RoundedCornerShape(16.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("🎮 ಆಟ ಪ್ರಾರಂಭಿಸಿ", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                            }
                        }
                    }
                }
            }
        }

        // Daily Streak Counter Component
        item {
            DailyStreakCard(
                streakDays = progressState.streakDays,
                isCheckedInToday = isCheckedInToday,
                onCheckInClicked = onDailyCheckIn
            )
        }

        // Recent Teacher Announcements & Homework Section
        if (progressState.teacherResources.isNotEmpty()) {
            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "📢 ಶಾಲಾ ಶಿಕ್ಷಕರ ಇತ್ತೀಚಿನ ಮನೆಗೆಲಸ & ಸೂಚನೆಗಳು",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = VibrantTextDark
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    val latestRes = progressState.teacherResources.first()
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, VibrantPurple.copy(alpha = 0.3f), RoundedCornerShape(20.dp)),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFAF5FF)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(VibrantPurple.copy(alpha = 0.15f))
                                        .padding(horizontal = 8.dp, vertical = 3.dp)
                                ) {
                                    Text(
                                        text = latestRes.category,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = VibrantPurple
                                    )
                                }

                                Text(
                                    text = latestRes.date,
                                    fontSize = 11.sp,
                                    color = VibrantTextMuted
                                )
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = latestRes.title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = VibrantTextDark
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "✍️ ${latestRes.teacherName}: ${latestRes.content}",
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.onSurface,
                                lineHeight = 18.sp
                            )
                        }
                    }
                }
            }
        }

        // Stats Overview Title
        item {
            Text(
                text = "📊 ಸದ್ಯದ ಪ್ರಗತಿ (Dashboard)",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold,
                color = VibrantTextDark
            )
        }

        // Dashboard Stat Grid Cards
        item {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Topics Stat
                    DashboardStatCard(
                        title = "ವಿಷಯಗಳು (TOPICS)",
                        value = "$completedCount / $totalTopicsCount",
                        iconEmoji = "📚",
                        badgeBg = Color(0xFFD1FAE5),
                        accentColor = VibrantEmerald,
                        modifier = Modifier.weight(1f)
                    )

                    // Badges Stat
                    DashboardStatCard(
                        title = "ಬ್ಯಾಡ್ಜ್‌ಗಳು (BADGES)",
                        value = "${progressState.unlockedBadgeIds.size} / ${KannadaRepository.defaultBadges.size}",
                        iconEmoji = "🏆",
                        badgeBg = Color(0xFFFEF3C7),
                        accentColor = VibrantAmber,
                        modifier = Modifier.weight(1f)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Stars Stat
                    DashboardStatCard(
                        title = "ನಕ್ಷತ್ರಗಳು (STARS)",
                        value = "${progressState.starsEarned}",
                        iconEmoji = "⭐",
                        badgeBg = Color(0xFFFCE7F3),
                        accentColor = VibrantPink,
                        modifier = Modifier.weight(1f)
                    )

                    // Streak Stat
                    DashboardStatCard(
                        title = "ಸರಣಿ (STREAK)",
                        value = "${progressState.streakDays} ದಿನಗಳು",
                        iconEmoji = "🔥",
                        badgeBg = Color(0xFFFFE4E6),
                        accentColor = VibrantRose,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        // Learning Levels Section
        item {
            Text(
                text = "📚 ಕಲಿಯುವ ಹಂತಗಳು (Learning Levels)",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold,
                color = VibrantTextDark
            )
        }

        items(KannadaRepository.levels.size) { index ->
            val level = KannadaRepository.levels[index]
            val levelColor = when (level.id) {
                LearningLevelId.LEVEL_1 -> VibrantEmerald
                LearningLevelId.LEVEL_2 -> VibrantAmber
                LearningLevelId.LEVEL_3 -> VibrantRose
                LearningLevelId.KANNADA_GRAMMAR -> VibrantPurple
                LearningLevelId.ENGLISH_BILINGUAL -> VibrantBlue
            }

            Card(
                onClick = { onLevelSelected(level.id) },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, VibrantBorderLight, RoundedCornerShape(20.dp)),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .background(levelColor.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = level.iconEmoji, fontSize = 28.sp)
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = level.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp,
                            color = VibrantTextDark
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = level.description,
                            fontSize = 12.sp,
                            color = VibrantTextMuted,
                            lineHeight = 16.sp
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(levelColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Go",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }

        item { Spacer(modifier = Modifier.height(24.dp)) }
    }
}

@Composable
fun DashboardStatCard(
    title: String,
    value: String,
    iconEmoji: String,
    badgeBg: Color,
    accentColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.border(1.dp, VibrantBorderLight, RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(badgeBg),
                contentAlignment = Alignment.Center
            ) {
                Text(text = iconEmoji, fontSize = 22.sp)
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column {
                Text(
                    text = title,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = VibrantTextMuted
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = value,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 16.sp,
                    color = VibrantTextDark
                )
            }
        }
    }
}

