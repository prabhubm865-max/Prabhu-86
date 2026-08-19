package com.example.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import com.example.data.UserProgressState
import com.example.ui.theme.KannadaGreen
import com.example.ui.theme.KannadaOrange
import com.example.ui.theme.KannadaRed

@Composable
fun ProgressScreen(
    progressState: UserProgressState,
    onAddTeacherNote: (String) -> Unit,
    onResetProgress: () -> Unit,
    modifier: Modifier = Modifier
) {
    var newNoteText by remember { mutableStateOf("") }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { Spacer(modifier = Modifier.height(8.dp)) }

        item {
            Text(
                text = "📊 ನನ್ನ ಪ್ರಗತಿ ಮತ್ತು ವಿವರಗಳು (Progress Report)",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        // Student Profile Header Card
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Row(
                    modifier = Modifier.padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "🎓", fontSize = 32.sp)
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = progressState.studentName,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "KPS Kakol ಕನ್ನಡ ಕಲಿತ್ ಸಂಕಲ್ಪ",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
        }

        // Summary Statistics Box
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "📈 ಶೈಕ್ಷಣಿಕ ಸಾಧನೆಯ ಅಂಕಿಅಂಶಗಳು",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("ಒಟ್ಟು ನಕ್ಷತ್ರಗಳು", fontSize = 12.sp, color = Color.Gray)
                            Text("⭐ ${progressState.starsEarned}", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        }

                        Column {
                            Text("ರಸಪ್ರಶ್ನೆ ಭಾಗವಹಿಸುವಿಕೆ", fontSize = 12.sp, color = Color.Gray)
                            Text("🎯 ${progressState.totalQuizzesAttempted} ಬಾರಿ", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        }

                        Column {
                            Text("ಸರಿಯಾದ ಉತ್ತರಗಳು", fontSize = 12.sp, color = Color.Gray)
                            Text("✅ ${progressState.totalCorrectAnswers}", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        }
                    }
                }
            }
        }

        // Teacher / Parent Dashboard Section
        item {
            Text(
                text = "👨‍🏫 ಶಿಕ್ಷಕರ / ಪೋಷಕರ ವಿಭಾಗ (Teacher & Parent Portal)",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        // Add Note Input Box
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "✍️ ವಿದ್ಯಾರ್ಥಿಗೆ ಶಿಕ್ಷಕರ ಸಲಹೆ / ಮಾರ್ಗದರ್ಶನ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = newNoteText,
                        onValueChange = { newNoteText = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("ಉದಾಹರಣೆಗೆ: ದಿನವೂ ಸ್ವರಗಳನ್ನು ಬರೆದು ಅಭ್ಯಾಸ ಮಾಡಿ...", fontSize = 13.sp) },
                        maxLines = 3
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {
                            if (newNoteText.isNotBlank()) {
                                onAddTeacherNote(newNoteText)
                                newNoteText = ""
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = KannadaGreen),
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("ಸಲಹೆ ಸೇರಿಸಿ (Add Note)")
                    }
                }
            }
        }

        // List of Teacher/Parent Notes
        items(progressState.notes) { note ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF8E1))
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "📌 ${note.author}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                            color = KannadaOrange
                        )
                        Text(
                            text = note.date,
                            fontSize = 11.sp,
                            color = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = note.noteText,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        lineHeight = 18.sp
                    )
                }
            }
        }

        item {
            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))
            Button(
                onClick = onResetProgress,
                colors = ButtonDefaults.buttonColors(containerColor = KannadaRed),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("ಪ್ರಗತಿ ಮರುಹೊಂದಿಸಿ (Reset Progress)")
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
