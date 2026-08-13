package com.example.ui.components

import android.graphics.Path
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.KannadaGreen
import com.example.ui.theme.KannadaOrange
import com.example.ui.theme.KannadaRed

data class LinePath(
    val points: List<Offset>,
    val color: Color,
    val strokeWidth: Float = 18f
)

@Composable
fun TracingCanvas(
    letter: String,
    exampleWord: String,
    onSpeakRequested: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var paths = remember { mutableStateListOf<LinePath>() }
    var currentPoints = remember { mutableStateListOf<Offset>() }
    var currentColor by remember { mutableStateOf(KannadaRed) }

    val colorOptions = listOf(
        KannadaRed,
        KannadaOrange,
        KannadaGreen,
        Color(0xFF0288D1),
        Color(0xFF7B1FA2)
    )

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "✍️ ಅಕ್ಷರ ಬರೆಯಿರಿ (Trace Letter)",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "ಬೆರಳಿನಿಂದ ' $letter ' ಅಕ್ಷರವನ್ನು ಬರೆಯಿರಿ",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                IconButton(
                    onClick = { onSpeakRequested(letter) },
                    modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer, CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.VolumeUp,
                        contentDescription = "Pronounce",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Canvas Drawing Area
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFFFFDE7))
                    .pointerInput(currentColor) {
                        detectDragGestures(
                            onDragStart = { offset ->
                                currentPoints.clear()
                                currentPoints.add(offset)
                            },
                            onDrag = { change, _ ->
                                currentPoints.add(change.position)
                            },
                            onDragEnd = {
                                if (currentPoints.isNotEmpty()) {
                                    paths.add(LinePath(currentPoints.toList(), currentColor))
                                    currentPoints.clear()
                                }
                            }
                        )
                    },
                contentAlignment = Alignment.Center
            ) {
                // Background faint letter watermark guide
                Text(
                    text = letter,
                    fontSize = 160.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.LightGray.copy(alpha = 0.35f)
                )

                // Canvas to render user paths
                Canvas(modifier = Modifier.fillMaxSize()) {
                    paths.forEach { linePath ->
                        if (linePath.points.size > 1) {
                            for (i in 0 until linePath.points.size - 1) {
                                drawLine(
                                    color = linePath.color,
                                    start = linePath.points[i],
                                    end = linePath.points[i + 1],
                                    strokeWidth = linePath.strokeWidth,
                                    cap = StrokeCap.Round
                                )
                            }
                        }
                    }

                    if (currentPoints.size > 1) {
                        for (i in 0 until currentPoints.size - 1) {
                            drawLine(
                                color = currentColor,
                                start = currentPoints[i],
                                end = currentPoints[i + 1],
                                strokeWidth = 18f,
                                cap = StrokeCap.Round
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Color palette & Controls
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    colorOptions.forEach { color ->
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(color)
                                .clickable { currentColor = color }
                                .padding(3.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            if (currentColor == color) {
                                Box(
                                    modifier = Modifier
                                        .size(12.dp)
                                        .clip(CircleShape)
                                        .background(Color.White)
                                )
                            }
                        }
                    }
                }

                OutlinedButton(
                    onClick = {
                        paths.clear()
                        currentPoints.clear()
                    },
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = KannadaRed)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Clear",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("ಅಳಿಸಿ (Clear)", fontSize = 12.sp)
                }
            }
        }
    }
}
