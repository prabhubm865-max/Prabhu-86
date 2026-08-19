package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.KannadaRepository
import com.example.data.LearningLevelId
import com.example.data.Topic
import com.example.ui.theme.VibrantAmber
import com.example.ui.theme.VibrantBorderLight
import com.example.ui.theme.VibrantEmerald
import com.example.ui.theme.VibrantHeaderPink
import com.example.ui.theme.VibrantRose
import com.example.ui.theme.VibrantTextDark
import com.example.ui.theme.VibrantTextMuted

@Composable
fun LearningLevelsScreen(
    completedTopics: Set<String>,
    initialLevelId: LearningLevelId = LearningLevelId.LEVEL_1,
    onTopicSelected: (Topic) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedLevelId by remember { mutableStateOf(initialLevelId) }
    val currentLevel = KannadaRepository.levels.find { it.id == selectedLevelId } ?: KannadaRepository.levels.first()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "📚 ಕಲಿಯುವ ವಿಷಯಗಳು (Topics)",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            color = VibrantTextDark
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Level selector tabs
        TabRow(
            selectedTabIndex = selectedLevelId.ordinal,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)),
            containerColor = Color.White
        ) {
            KannadaRepository.levels.forEach { level ->
                val isSelected = level.id == selectedLevelId
                Tab(
                    selected = isSelected,
                    onClick = { selectedLevelId = level.id },
                    text = {
                        Text(
                            text = level.title.split(" ").firstOrNull() ?: level.title,
                            fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Medium,
                            fontSize = 13.sp,
                            color = if (isSelected) VibrantHeaderPink else VibrantTextMuted
                        )
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Selected Level Description Header Card
        val levelAccentColor = when (selectedLevelId) {
            LearningLevelId.LEVEL_1 -> VibrantEmerald
            LearningLevelId.LEVEL_2 -> VibrantAmber
            LearningLevelId.LEVEL_3 -> VibrantRose
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, VibrantBorderLight, RoundedCornerShape(20.dp)),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(54.dp)
                        .clip(CircleShape)
                        .background(levelAccentColor.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = currentLevel.iconEmoji, fontSize = 32.sp)
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = currentLevel.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = VibrantTextDark
                    )
                    Text(
                        text = currentLevel.description,
                        fontSize = 12.sp,
                        color = VibrantTextMuted
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // List of Topics for the selected Level
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(currentLevel.topics) { topic ->
                val isDone = completedTopics.contains(topic.id)
                Card(
                    onClick = { onTopicSelected(topic) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, VibrantBorderLight, RoundedCornerShape(18.dp)),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(46.dp)
                                .clip(CircleShape)
                                .background(
                                    if (isDone) VibrantEmerald.copy(alpha = 0.15f)
                                    else levelAccentColor.copy(alpha = 0.1f)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = topic.iconEmoji, fontSize = 24.sp)
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = topic.title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = VibrantTextDark
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = topic.description,
                                fontSize = 12.sp,
                                color = VibrantTextMuted
                            )
                        }

                        if (isDone) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("ಪೂರ್ಣಗೊಂಡಿದೆ", fontSize = 11.sp, color = VibrantEmerald, fontWeight = FontWeight.Bold)
                                Spacer(modifier = Modifier.width(4.dp))
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = "Completed",
                                    tint = VibrantEmerald,
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                        } else {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = "Start",
                                tint = levelAccentColor,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(20.dp)) }
        }
    }
}

