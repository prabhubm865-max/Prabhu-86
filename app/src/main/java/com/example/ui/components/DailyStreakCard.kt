package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.VibrantAmber
import com.example.ui.theme.VibrantBorderLight
import com.example.ui.theme.VibrantEmerald
import com.example.ui.theme.VibrantOrange
import com.example.ui.theme.VibrantRose
import com.example.ui.theme.VibrantTextDark
import com.example.ui.theme.VibrantTextMuted

@Composable
fun DailyStreakCard(
    streakDays: Int,
    isCheckedInToday: Boolean,
    onCheckInClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Pulse animation for fire icon
    val infiniteTransition = rememberInfiniteTransition(label = "fire_pulse")
    val fireScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.15f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, VibrantBorderLight, RoundedCornerShape(24.dp))
            .testTag("daily_streak_card"),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            // Header Row with Fire Badge & Streak Count
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.radialGradient(
                                    colors = listOf(
                                        Color(0xFFFFF7ED),
                                        Color(0xFFFFEDD5)
                                    )
                                )
                            )
                            .border(1.dp, Color(0xFFFED7AA), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "🔥",
                            fontSize = 28.sp,
                            modifier = Modifier.scale(if (isCheckedInToday) fireScale else 1f)
                        )
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column {
                        Text(
                            text = "ದಿನನಿತ್ಯದ ಸರಣಿ (Daily Streak)",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = VibrantTextMuted
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "$streakDays",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = VibrantRose
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "ದಿನಗಳು (Days)",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = VibrantTextDark
                            )
                        }
                    }
                }

                // Active Streak Badge Pill
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(
                            if (isCheckedInToday) Color(0xFFD1FAE5) else Color(0xFFFFE4E6)
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = if (isCheckedInToday) "ಇಂದು ಪೂರ್ಣವಾಗಿದೆ ⚡" else "ಇಂದಿನ ಅಭ್ಯಾಸ ಕಾದಿದೆ 🔥",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = if (isCheckedInToday) VibrantEmerald else VibrantRose
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 7 Days Weekly Streak Tracker Row
            Text(
                text = "ಈ ವಾರದ ಹಾಜರಾತಿ (Weekly Attendance)",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = VibrantTextMuted
            )

            Spacer(modifier = Modifier.height(10.dp))

            val kannadaDays = listOf("ಸೋಮ", "ಮಂಗಳ", "ಬುಧ", "ಗುರು", "ಶುಕ್ರ", "ಶನಿ", "ಭಾನು")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                kannadaDays.forEachIndexed { index, day ->
                    // Simulate completed days for current streak (e.g. last N days completed)
                    val isDayActive = index < (streakDays % 7).let { if (it == 0 && streakDays > 0) 7 else it }
                    val isToday = index == ((streakDays - 1) % 7)

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(38.dp)
                                .clip(CircleShape)
                                .background(
                                    when {
                                        isToday && isCheckedInToday -> VibrantEmerald
                                        isToday -> VibrantOrange
                                        isDayActive -> Color(0xFFFEF3C7)
                                        else -> Color(0xFFF1F5F9)
                                    }
                                )
                                .border(
                                    width = if (isToday) 2.dp else 1.dp,
                                    color = when {
                                        isToday -> VibrantRose
                                        isDayActive -> VibrantAmber
                                        else -> Color(0xFFE2E8F0)
                                    },
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            if (isDayActive || (isToday && isCheckedInToday)) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Done",
                                    tint = if (isToday && isCheckedInToday) Color.White else VibrantOrange,
                                    modifier = Modifier.size(20.dp)
                                )
                            } else {
                                Text(
                                    text = "${index + 1}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = VibrantTextMuted
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = day,
                            fontSize = 10.sp,
                            fontWeight = if (isToday) FontWeight.ExtraBold else FontWeight.Medium,
                            color = if (isToday) VibrantRose else VibrantTextMuted
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Check-in Button or Success Banner
            if (!isCheckedInToday) {
                Button(
                    onClick = onCheckInClicked,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("check_in_button"),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = VibrantRose),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("🔥", fontSize = 18.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "ಇಂದಿನ ಹಾಜರಾತಿ ದಾಖಲಿಸಿ (+10 ⭐)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                }
            } else {
                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn() + expandVertically()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFFECFDF5))
                            .border(1.dp, Color(0xFFA7F3D0), RoundedCornerShape(16.dp))
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("🎉", fontSize = 18.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "ಅದ್ಭುತ! ಇಂದಿನ $streakDays ನೇ ದಿನದ ಕಲಿಕಾ ಹಾಜರಾತಿ ದಾಖಲಾಗಿದೆ! ⭐+10",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                color = Color(0xFF065F46),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Motivational quote
            Text(
                text = "💡 \"ದಿನವೂ ಕಲಿಯೋಣ – ಹೊಸ ದಾಖಲೆ ಬರೆಯೋಣ! ನಿರಂತರ ಅಭ್ಯಾಸವೇ ಯಶಸ್ಸಿನ ಕೀಲಿ ಕೈ.\"",
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = VibrantTextMuted,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
