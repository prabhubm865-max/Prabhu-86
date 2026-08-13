package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import com.example.data.MatchingPair
import com.example.ui.theme.KannadaGreen
import com.example.ui.theme.KannadaOrange
import com.example.ui.theme.KannadaRed

@Composable
fun MatchingGameComponent(
    pairs: List<MatchingPair>,
    onGameCompleted: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val leftItems = remember(pairs) { pairs.map { it.leftText }.shuffled() }
    val rightItems = remember(pairs) { pairs.map { it.rightText }.shuffled() }

    var selectedLeft by remember { mutableStateOf<String?>(null) }
    var selectedRight by remember { mutableStateOf<String?>(null) }

    val matchedIds = remember { mutableStateListOf<String>() }
    var matchStatus by remember { mutableStateOf<Boolean?>(null) }

    fun checkMatch(left: String, right: String) {
        val foundPair = pairs.find { it.leftText == left && it.rightText == right }
        if (foundPair != null) {
            matchedIds.add(foundPair.id)
            matchStatus = true
            if (matchedIds.size == pairs.size) {
                onGameCompleted(pairs.size * 10)
            }
        } else {
            matchStatus = false
        }
        selectedLeft = null
        selectedRight = null
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
                    text = "🖼️ ಚಿತ್ರ–ಪದ ಹೊಂದಾಣಿಕೆ",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "ಹೊಂದಿಕೆಯಾದವು: ${matchedIds.size} / ${pairs.size}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "ಎಡಭಾಗದ ಪದ ಮತ್ತು ಬಲಭಾಗದ ಸೂಕ್ತ ಅರ್ಥ/ಚಿತ್ರವನ್ನು ಆಯ್ಕೆ ಮಾಡಿ:",
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Grid or Parallel columns
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Left Column
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    leftItems.forEach { leftText ->
                        val pair = pairs.find { it.leftText == leftText }
                        val isMatched = pair != null && matchedIds.contains(pair.id)
                        val isSelected = selectedLeft == leftText

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(
                                    when {
                                        isMatched -> KannadaGreen.copy(alpha = 0.2f)
                                        isSelected -> KannadaOrange
                                        else -> MaterialTheme.colorScheme.surfaceVariant
                                    }
                                )
                                .clickable(enabled = !isMatched) {
                                    selectedLeft = leftText
                                    matchStatus = null
                                    if (selectedRight != null) {
                                        checkMatch(leftText, selectedRight!!)
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = leftText,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = if (isSelected) Color.White else if (isMatched) KannadaGreen else MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                // Right Column
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    rightItems.forEach { rightText ->
                        val pair = pairs.find { it.rightText == rightText }
                        val isMatched = pair != null && matchedIds.contains(pair.id)
                        val isSelected = selectedRight == rightText

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(
                                    when {
                                        isMatched -> KannadaGreen.copy(alpha = 0.2f)
                                        isSelected -> KannadaOrange
                                        else -> MaterialTheme.colorScheme.surfaceVariant
                                    }
                                )
                                .clickable(enabled = !isMatched) {
                                    selectedRight = rightText
                                    matchStatus = null
                                    if (selectedLeft != null) {
                                        checkMatch(selectedLeft!!, rightText)
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = rightText,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = if (isSelected) Color.White else if (isMatched) KannadaGreen else MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            AnimatedVisibility(visible = matchStatus != null) {
                Text(
                    text = if (matchStatus == true) "🎉 ಸರಿಯಾದ ಹೊಂದಾಣಿಕೆ! ⭐+10" else "❌ ತಪ್ಪಾದ ಜೋಡಿ, ಮತ್ತೆ ಪ್ರಯತ್ನಿಸಿ!",
                    color = if (matchStatus == true) KannadaGreen else KannadaRed,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 15.sp
                )
            }

            if (matchedIds.size == pairs.size) {
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = {
                        matchedIds.clear()
                        matchStatus = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = KannadaOrange)
                ) {
                    Text("ಮತ್ತೆ ಆಟವಾಡಿ (Restart)")
                }
            }
        }
    }
}
