package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import com.example.data.SentenceItem
import com.example.ui.theme.KannadaGreen
import com.example.ui.theme.KannadaOrange
import com.example.ui.theme.KannadaRed

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SentenceBuilderGame(
    sentences: List<SentenceItem>,
    onSentenceCompleted: (Boolean) -> Unit,
    onSpeakSentence: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var currentIndex by remember { mutableStateOf(0) }
    val currentSentence = sentences.getOrNull(currentIndex) ?: return

    val targetWords = remember(currentIndex) { currentSentence.sentence.trimEnd('.').split(" ") }

    data class WordTile(val id: Int, val word: String)

    val tiles = remember(currentIndex) {
        targetWords.mapIndexed { i, w -> WordTile(i, w) }.shuffled()
    }

    val selectedTiles = remember(currentIndex) { mutableStateListOf<WordTile>() }
    var isCorrect by remember { mutableStateOf<Boolean?>(null) }

    fun checkAnswer() {
        val constructed = selectedTiles.joinToString(" ") { it.word }
        if (constructed == targetWords.joinToString(" ")) {
            isCorrect = true
            onSentenceCompleted(true)
            onSpeakSentence(currentSentence.sentence)
        } else {
            isCorrect = false
            onSentenceCompleted(false)
        }
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "✍️ ವಾಕ್ಯ ಜೋಡಣೆ (Sentence Builder)",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "${currentIndex + 1} / ${sentences.size}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "ಆಂಗ್ಲ ಅರ್ಥ: ${currentSentence.englishTranslation}",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Constructed Sentence Drop Container
            Text(text = "ನಿಮ್ಮ ವಾಕ್ಯ (Your Sentence):", fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        when (isCorrect) {
                            true -> KannadaGreen.copy(alpha = 0.15f)
                            false -> KannadaRed.copy(alpha = 0.15f)
                            null -> MaterialTheme.colorScheme.surfaceVariant
                        }
                    )
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                if (selectedTiles.isEmpty()) {
                    Text(text = "ಕೆಳಗಿನ ಪದಗಳನ್ನು ಸ್ಪರ್ಶಿಸಿ...", color = Color.Gray, fontSize = 14.sp)
                } else {
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        selectedTiles.forEach { tile ->
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(MaterialTheme.colorScheme.primary)
                                    .clickable {
                                        if (isCorrect == null) {
                                            selectedTiles.remove(tile)
                                        }
                                    }
                                    .padding(horizontal = 10.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = tile.word,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Scrambled Words Source
            Text(text = "ಪದಗಳನ್ನು ಆಯ್ಕೆ ಮಾಡಿ:", fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                tiles.forEach { tile ->
                    val isUsed = selectedTiles.contains(tile)
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(14.dp))
                            .background(
                                if (isUsed) Color.LightGray.copy(alpha = 0.4f)
                                else KannadaOrange
                            )
                            .clickable(enabled = !isUsed && isCorrect == null) {
                                selectedTiles.add(tile)
                                isCorrect = null
                                if (selectedTiles.size == targetWords.size) {
                                    checkAnswer()
                                }
                            }
                            .padding(horizontal = 14.dp, vertical = 10.dp)
                    ) {
                        Text(
                            text = tile.word,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isUsed) Color.Gray else Color.White
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            AnimatedVisibility(visible = isCorrect != null) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    if (isCorrect == true) {
                        Text(
                            text = "🎉 ಅದ್ಭುತ! ಸರಿಯಾದ ವಾಕ್ಯ: ${currentSentence.sentence} ⭐+10",
                            color = KannadaGreen,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 15.sp
                        )
                    } else {
                        Text(
                            text = "❌ ವಾಕ್ಯ ಜೋಡಣೆ ತಪ್ಪಾಗಿದೆ. ಮತ್ತೆ ಪ್ರಯತ್ನಿಸಿ!",
                            color = KannadaRed,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedButton(
                    onClick = {
                        selectedTiles.clear()
                        isCorrect = null
                    }
                ) {
                    Text("ಪುನಃ ಪ್ರಯತ್ನಿಸಿ")
                }

                Button(
                    onClick = {
                        currentIndex = (currentIndex + 1) % sentences.size
                        selectedTiles.clear()
                        isCorrect = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = KannadaOrange)
                ) {
                    Text("ಮುಂದಿನ ವಾಕ್ಯ ➡️")
                }
            }
        }
    }
}
