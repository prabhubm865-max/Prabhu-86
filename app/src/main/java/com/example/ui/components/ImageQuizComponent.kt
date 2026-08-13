package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.ImageQuizQuestion
import com.example.ui.theme.VibrantAmber
import com.example.ui.theme.VibrantBorderLight
import com.example.ui.theme.VibrantEmerald
import com.example.ui.theme.VibrantHeaderPink
import com.example.ui.theme.VibrantOrange
import com.example.ui.theme.VibrantPurple
import com.example.ui.theme.VibrantRose
import com.example.ui.theme.VibrantTextDark
import com.example.ui.theme.VibrantTextMuted

@Composable
fun ImageQuizComponent(
    questions: List<ImageQuizQuestion>,
    onStarsAwarded: (Int) -> Unit,
    onSpeakRequested: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var currentIndex by remember { mutableStateOf(0) }
    var selectedOptionIndex by remember { mutableStateOf<Int?>(null) }
    var isAnswered by remember { mutableStateOf(false) }
    var totalCorrect by remember { mutableStateOf(0) }
    var isQuizCompleted by remember { mutableStateOf(false) }

    val currentQ = questions.getOrNull(currentIndex)

    if (isQuizCompleted || currentQ == null) {
        // Completion Card
        Card(
            modifier = modifier
                .fillMaxWidth()
                .border(1.5.dp, VibrantBorderLight, RoundedCornerShape(24.dp))
                .testTag("image_quiz_completion_card"),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "🎉 ರಸಪ್ರಶ್ನೆ ಪೂರ್ಣಗೊಂಡಿದೆ! 🏆",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = VibrantHeaderPink
                )

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                        .background(
                            Brush.radialGradient(
                                listOf(VibrantAmber.copy(alpha = 0.3f), VibrantAmber.copy(alpha = 0.05f))
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "🌟", fontSize = 48.sp)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "ನಿಮ್ಮ ಅಂಕಗಳು: $totalCorrect / ${questions.size}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = VibrantTextDark
                )

                Text(
                    text = "ಗಳಿಸಿದ ನಕ್ಷತ್ರಗಳು: +${totalCorrect * 10} ⭐",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = VibrantEmerald,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        currentIndex = 0
                        selectedOptionIndex = null
                        isAnswered = false
                        totalCorrect = 0
                        isQuizCompleted = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = VibrantOrange),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .testTag("quiz_restart_button")
                ) {
                    Icon(Icons.Default.Refresh, contentDescription = "Restart Quiz")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "ಮತ್ತೆ ಆಡಿ (Play Again)", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
        }
        return
    }

    val optionLabels = listOf("೧", "೨", "೩", "೪")

    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(1.5.dp, VibrantBorderLight, RoundedCornerShape(24.dp))
            .testTag("image_quiz_main_card"),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header Bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(VibrantPurple.copy(alpha = 0.12f))
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "🖼️ ಚಿತ್ರ ರಸಪ್ರಶ್ನೆ",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = VibrantPurple
                        )
                    }
                }

                Text(
                    text = "ಪ್ರಶ್ನೆ ${currentIndex + 1} / ${questions.size}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = VibrantTextDark
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Progress Bar
            LinearProgressIndicator(
                progress = { (currentIndex + 1).toFloat() / questions.size },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp)),
                color = VibrantOrange,
                trackColor = VibrantBorderLight
            )

            Spacer(modifier = Modifier.height(18.dp))

            // Image Banner Container
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color(0xFFFFF7ED),
                                Color(0xFFFFEDD5)
                            )
                        )
                    )
                    .border(1.dp, VibrantOrange.copy(alpha = 0.3f), RoundedCornerShape(20.dp))
                    .padding(vertical = 20.dp, horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = currentQ.imageEmoji,
                        fontSize = 72.sp
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "English: ${currentQ.englishMeaning}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = VibrantTextMuted
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        IconButton(
                            onClick = { onSpeakRequested(currentQ.englishMeaning) },
                            modifier = Modifier.size(28.dp)
                        ) {
                            Icon(
                                Icons.Default.VolumeUp,
                                contentDescription = "Listen English Hint",
                                tint = VibrantOrange,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Question Prompt
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "ಚಿತ್ರವನ್ನು ನೋಡಿ ಸರಿಯಾದ ಕನ್ನಡ ಪದ ಆಯ್ಕೆ ಮಾಡಿ:",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = VibrantTextDark,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )

                IconButton(
                    onClick = { onSpeakRequested("ಚಿತ್ರವನ್ನು ನೋಡಿ ಸರಿಯಾದ ಕನ್ನಡ ಪದವನ್ನು ಆಯ್ಕೆ ಮಾಡಿ") },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        Icons.Default.VolumeUp,
                        contentDescription = "Read Prompt",
                        tint = VibrantPurple,
                        modifier = Modifier.size(22.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 4 Multiple Choice Options
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                currentQ.options.forEachIndexed { index, optionText ->
                    val isSelected = selectedOptionIndex == index
                    val isCorrect = index == currentQ.correctIndex

                    val optionBg = when {
                        isAnswered && isCorrect -> VibrantEmerald.copy(alpha = 0.18f)
                        isAnswered && isSelected && !isCorrect -> VibrantRose.copy(alpha = 0.18f)
                        isSelected -> VibrantOrange.copy(alpha = 0.15f)
                        else -> Color(0xFFF8FAFC)
                    }

                    val optionBorderColor = when {
                        isAnswered && isCorrect -> VibrantEmerald
                        isAnswered && isSelected && !isCorrect -> VibrantRose
                        isSelected -> VibrantOrange
                        else -> VibrantBorderLight
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(optionBg)
                            .border(1.5.dp, optionBorderColor, RoundedCornerShape(16.dp))
                            .clickable(enabled = !isAnswered) {
                                selectedOptionIndex = index
                                isAnswered = true

                                if (index == currentQ.correctIndex) {
                                    totalCorrect++
                                    onStarsAwarded(10)
                                    onSpeakRequested("ಸರಿಯಾದ ಉತ್ತರ! $optionText")
                                } else {
                                    onSpeakRequested("ತಪ್ಪಾಗಿದೆ. ಸರಿಯಾದ ಪದ $optionText")
                                }
                            }
                            .padding(horizontal = 14.dp, vertical = 12.dp)
                            .testTag("quiz_option_$index")
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Label Badge (೧, ೨, ೩, ೪)
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(
                                        when {
                                            isAnswered && isCorrect -> VibrantEmerald
                                            isAnswered && isSelected && !isCorrect -> VibrantRose
                                            isSelected -> VibrantOrange
                                            else -> Color(0xFFE2E8F0)
                                        }
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = optionLabels.getOrElse(index) { "${index + 1}" },
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isAnswered || isSelected) Color.White else VibrantTextDark
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            // Option Kannada Text
                            Text(
                                text = optionText,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = VibrantTextDark,
                                modifier = Modifier.weight(1f)
                            )

                            // Speaker icon to pronounce option
                            IconButton(
                                onClick = { onSpeakRequested(optionText) },
                                modifier = Modifier.size(32.dp)
                            ) {
                                Icon(
                                    Icons.Default.VolumeUp,
                                    contentDescription = "Speak $optionText",
                                    tint = VibrantTextMuted,
                                    modifier = Modifier.size(20.dp)
                                )
                            }

                            // Result Icon
                            if (isAnswered) {
                                if (isCorrect) {
                                    Icon(
                                        Icons.Default.Check,
                                        contentDescription = "Correct",
                                        tint = VibrantEmerald,
                                        modifier = Modifier.size(24.dp)
                                    )
                                } else if (isSelected) {
                                    Icon(
                                        Icons.Default.Close,
                                        contentDescription = "Incorrect",
                                        tint = VibrantRose,
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Answer Explanation Box
            AnimatedVisibility(
                visible = isAnswered,
                enter = fadeIn() + scaleIn()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(
                            if (selectedOptionIndex == currentQ.correctIndex) VibrantEmerald.copy(alpha = 0.1f)
                            else VibrantRose.copy(alpha = 0.1f)
                        )
                        .padding(14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = if (selectedOptionIndex == currentQ.correctIndex)
                            "🎉 ಅದ್ಭುತ! ಸರಿಯಾದ ಉತ್ತರ (+10 ⭐)"
                        else
                            "❌ ತಪ್ಪಾಗಿದೆ. ಸರಿಯಾದ ಪದ: ${currentQ.options[currentQ.correctIndex]}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = if (selectedOptionIndex == currentQ.correctIndex) VibrantEmerald else VibrantRose
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = currentQ.explanation,
                        fontSize = 13.sp,
                        color = VibrantTextMuted,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Action Button
            if (isAnswered) {
                Button(
                    onClick = {
                        if (currentIndex < questions.size - 1) {
                            currentIndex++
                            selectedOptionIndex = null
                            isAnswered = false
                        } else {
                            isQuizCompleted = true
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = VibrantOrange),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("quiz_next_button")
                ) {
                    Text(
                        text = if (currentIndex < questions.size - 1) "ಮುಂದಿನ ಚಿತ್ರ ➡️" else "ರಸಪ್ರಶ್ನೆ ಮುಗಿಸಿ 🏆",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}
