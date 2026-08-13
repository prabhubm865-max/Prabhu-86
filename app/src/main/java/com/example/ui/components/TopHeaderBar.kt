package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.VibrantHeaderPink
import com.example.ui.theme.VibrantRoseBadgeBg
import com.example.ui.theme.VibrantRoseBadgeText

@Composable
fun TopHeaderBar(
    starsCount: Int,
    streakDays: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shadowElevation = 2.dp,
        color = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Brand Logo & Title
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "🌸",
                    fontSize = 22.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "KPS Kakol ಕನ್ನಡ",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = VibrantHeaderPink,
                    fontSize = 19.sp,
                    letterSpacing = (-0.5).sp
                )
            }

            // Stats Pill Badges
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Stars Badge Pill
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(VibrantRoseBadgeBg)
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("⭐", fontSize = 15.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "$starsCount",
                            fontWeight = FontWeight.Bold,
                            color = VibrantRoseBadgeText,
                            fontSize = 14.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Streak Badge Pill
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(VibrantRoseBadgeBg)
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("🔥", fontSize = 15.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "$streakDays",
                            fontWeight = FontWeight.Bold,
                            color = VibrantRoseBadgeText,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}

