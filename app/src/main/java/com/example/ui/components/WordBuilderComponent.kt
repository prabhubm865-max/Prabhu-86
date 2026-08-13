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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.data.WordItem
import com.example.ui.theme.KannadaGreen
import com.example.ui.theme.KannadaOrange
import com.example.ui.theme.KannadaRed

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WordBuilderGame(
    wordItems: List<WordItem>,
    onWordCompleted: (Boolean) -> Unit,
    onSpeakWord: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var currentIndex by remember { mutableStateOf(0) }
    val currentItem = wordItems.getOrNull(currentIndex) ?: return

    // Target letters (complete Kannada syllables/aksharas)
    val targetWord = currentItem.word
    val targetChars = remember(currentIndex) {
        if (currentItem.breakdown.contains("+")) {
            val parts = currentItem.breakdown.split("+").map { it.trim() }.filter { it.isNotEmpty() }
            if (parts.joinToString("") == targetWord) parts else extractKannadaSyllables(targetWord)
        } else {
            extractKannadaSyllables(targetWord)
        }
    }

    // Scrambled letters with IDs to keep track
    data class Tile(val id: Int, val char: String)

    val tiles = remember(currentIndex) {
        targetChars.mapIndexed { i, c -> Tile(i, c) }.shuffled()
    }

    val selectedTiles = remember(currentIndex) { mutableStateListOf<Tile>() }
    var isCorrect by remember { mutableStateOf<Boolean?>(null) }

    fun checkAnswer() {
        val constructed = selectedTiles.joinToString("") { it.char }
        if (constructed == targetWord) {
            isCorrect = true
            onWordCompleted(true)
            onSpeakWord(targetWord)
        } else {
            isCorrect = false
            onWordCompleted(false)
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
                    text = "🧩 ಅಕ್ಷರ ಜೋಡಣೆ (Word Builder)",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "${currentIndex + 1} / ${wordItems.size}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Picture / Hint Display
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(text = currentItem.emoji, fontSize = 48.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "ಅರ್ಥ: ${currentItem.englishMeaning}",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Construction Slot Box
            Text(text = "ನಿಮ್ಮ ಪದ (Your Answer):", fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(6.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (i in 0 until targetChars.size) {
                    val tile = selectedTiles.getOrNull(i)
                    Box(
                        modifier = Modifier
                            .size(54.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                when (isCorrect) {
                                    true -> KannadaGreen.copy(alpha = 0.2f)
                                    false -> KannadaRed.copy(alpha = 0.2f)
                                    null -> if (tile != null) MaterialTheme.colorScheme.surfaceVariant else Color(0xFFEEEEEE)
                                }
                            )
                            .clickable(enabled = tile != null) {
                                if (tile != null && isCorrect == null) {
                                    selectedTiles.remove(tile)
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = tile?.char ?: "",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = when (isCorrect) {
                                true -> KannadaGreen
                                false -> KannadaRed
                                null -> MaterialTheme.colorScheme.onSurface
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Available Scrambled Letter Tiles
            Text(text = "ಅಕ್ಷರಗಳನ್ನು ಸ್ಪರ್ಶಿಸಿ (Tap tiles):", fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                tiles.forEach { tile ->
                    val isUsed = selectedTiles.contains(tile)
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(
                                if (isUsed) Color.LightGray.copy(alpha = 0.4f)
                                else KannadaOrange
                            )
                            .clickable(enabled = !isUsed && isCorrect == null) {
                                selectedTiles.add(tile)
                                isCorrect = null
                                if (selectedTiles.size == targetChars.size) {
                                    checkAnswer()
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = tile.char,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isUsed) Color.Gray else Color.White
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Feedback & Controls
            AnimatedVisibility(visible = isCorrect != null) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    if (isCorrect == true) {
                        Text(
                            text = "🎉 ಅದ್ಭುತ! ಸರಿಯಾದ ಪದ: $targetWord ⭐+5",
                            color = KannadaGreen,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 16.sp
                        )
                    } else {
                        Text(
                            text = "❌ ತಪ್ಪಾಗಿದೆ. ಮತ್ತೆ ಪ್ರಯತ್ನಿಸಿ!",
                            color = KannadaRed,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
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
                    Text("ಮತ್ತೆ ಜೋಡಿಸಿ")
                }

                Button(
                    onClick = {
                        currentIndex = (currentIndex + 1) % wordItems.size
                        selectedTiles.clear()
                        isCorrect = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = KannadaOrange)
                ) {
                    Text("ಮುಂದಿನ ಪದ ➡️")
                }
            }
        }
    }
}

fun extractKannadaSyllables(word: String): List<String> {
    val syllables = mutableListOf<String>()
    var current = ""
    for (char in word) {
        val type = Character.getType(char)
        if (current.isNotEmpty() && (type == Character.NON_SPACING_MARK.toInt() || type == Character.COMBINING_SPACING_MARK.toInt())) {
            current += char
        } else {
            if (current.isNotEmpty()) syllables.add(current)
            current = char.toString()
        }
    }
    if (current.isNotEmpty()) syllables.add(current)
    return if (syllables.isNotEmpty()) syllables else word.map { it.toString() }
}
