package com.example.ui.screens

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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.data.TeacherResource
import com.example.data.UserProgressState
import com.example.ui.theme.KannadaGreen
import com.example.ui.theme.KannadaOrange
import com.example.ui.theme.KannadaRed
import com.example.ui.theme.VibrantBlue
import com.example.ui.theme.VibrantBorderLight
import com.example.ui.theme.VibrantEmerald
import com.example.ui.theme.VibrantHeaderPink
import com.example.ui.theme.VibrantOrange
import com.example.ui.theme.VibrantPurple
import com.example.ui.theme.VibrantRose
import com.example.ui.theme.VibrantTextDark
import com.example.ui.theme.VibrantTextMuted

@Composable
fun ProgressScreen(
    progressState: UserProgressState,
    onAddTeacherNote: (String) -> Unit,
    onAddTeacherResource: (title: String, category: String, content: String, teacherName: String) -> Unit = { _, _, _, _ -> },
    onDeleteTeacherResource: (id: String) -> Unit = {},
    onSpeakRequested: (String) -> Unit = {},
    onResetProgress: () -> Unit,
    modifier: Modifier = Modifier
) {
    var newNoteText by remember { mutableStateOf("") }

    // Teacher Source Form States
    var resTitle by remember { mutableStateOf("") }
    var resCategory by remember { mutableStateOf("ಮನೆಗೆಲಸ (Homework)") }
    var resTeacherName by remember { mutableStateOf("ಪ್ರಭು ಬಿ.ಎಮ್. (KPS Kakol)") }
    var resContent by remember { mutableStateOf("") }
    var isFormExpanded by remember { mutableStateOf(false) }

    val categories = listOf(
        "ಮನೆಗೆಲಸ (Homework)",
        "ಪಾಠ ಟಿಪ್ಪಣಿ (Notes)",
        "ಪ್ರಕಟಣೆ (Announcement)",
        "ಅಧ್ಯಯನ ಮೂಲ (Resource)"
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { Spacer(modifier = Modifier.height(8.dp)) }

        item {
            Text(
                text = "📊 ನನ್ನ ಪ್ರಗತಿ ಮತ್ತು ಶಿಕ್ಷಕರ ಸಂಪನ್ಮೂಲಗಳು (Progress Report)",
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

        // Teacher Portal Section
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "👨‍🏫 ಶಿಕ್ಷಕರ ಸಂಪನ್ಮೂಲ ಸೇರ್ಪಡೆ (Teacher Source Portal)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Button(
                    onClick = { isFormExpanded = !isFormExpanded },
                    colors = ButtonDefaults.buttonColors(containerColor = VibrantPurple),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(
                        if (isFormExpanded) Icons.Default.MenuBook else Icons.Default.Add,
                        contentDescription = "Toggle Form",
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = if (isFormExpanded) "ಮುಚ್ಚಿ" else "+ ಹೊಸ ಮೂಲ",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // Add Teacher Source Card (Form)
        if (isFormExpanded) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.5.dp, VibrantPurple.copy(alpha = 0.3f), RoundedCornerShape(22.dp)),
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFAF5FF)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Text(
                            text = "📝 ಹೊಸ ಶಾಲಾ ಸಂಪನ್ಮೂಲ / ಮನೆಗೆಲಸ ಸೇರ್ಪಡೆ",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = VibrantPurple
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        // Title Field
                        OutlinedTextField(
                            value = resTitle,
                            onValueChange = { resTitle = it },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text("ಸಂಪನ್ಮೂಲದ ಶೀರ್ಷಿಕೆ (Title)") },
                            placeholder = { Text("ಉದಾ: ಕಡ್ಡಾಯ ಮನೆಗೆಲಸ - ವರ್ಣಮಾಲೆ", fontSize = 13.sp) },
                            singleLine = true
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        // Category Chips
                        Text(text = "ವರ್ಗ ಆಯ್ಕೆ ಮಾಡಿ (Category):", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = VibrantTextMuted)
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            categories.take(2).forEach { cat ->
                                FilterChip(
                                    selected = resCategory == cat,
                                    onClick = { resCategory = cat },
                                    label = { Text(cat.split(" ").firstOrNull() ?: cat, fontSize = 12.sp) }
                                )
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            categories.drop(2).forEach { cat ->
                                FilterChip(
                                    selected = resCategory == cat,
                                    onClick = { resCategory = cat },
                                    label = { Text(cat.split(" ").firstOrNull() ?: cat, fontSize = 12.sp) }
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Teacher Name
                        OutlinedTextField(
                            value = resTeacherName,
                            onValueChange = { resTeacherName = it },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text("ಶಿಕ್ಷಕರ ಹೆಸರು (Teacher Name)") },
                            singleLine = true
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        // Detailed Content
                        OutlinedTextField(
                            value = resContent,
                            onValueChange = { resContent = it },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text("ವಿವರಣೆ / ಮನೆಗೆಲಸದ ಪಠ್ಯ (Content)") },
                            placeholder = { Text("ಉದಾ: ದಿನವೂ ೫ ಬಾರಿ ಸ್ವರಗಳನ್ನು ನೋಟ್‌ಬುಕ್‌ನಲ್ಲಿ ಬರೆದು ಅಭ್ಯಾಸ ಮಾಡಿ...", fontSize = 13.sp) },
                            minLines = 3,
                            maxLines = 5
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Button(
                            onClick = {
                                if (resTitle.isNotBlank() && resContent.isNotBlank()) {
                                    onAddTeacherResource(resTitle, resCategory, resContent, resTeacherName)
                                    resTitle = ""
                                    resContent = ""
                                    isFormExpanded = false
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = VibrantEmerald),
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("📢 ಪ್ರಕಟಿಸಿ ಮತ್ತು ವಿದ್ಯಾರ್ಥಿಗಳಿಗೆ ತಲುಪಿಸಿ (Publish Resource)", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }

        // List of Teacher Resources
        item {
            Text(
                text = "📚 ಶಾಲಾ ಶಿಕ್ಷಕರಿಂದ ಪ್ರಕಟಿತ ಸಂಪನ್ಮೂಲಗಳು (${progressState.teacherResources.size})",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }

        items(progressState.teacherResources) { res ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, VibrantBorderLight, RoundedCornerShape(18.dp)),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
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
                                .background(
                                    when {
                                        res.category.contains("ಮನೆಗೆಲಸ") -> VibrantOrange.copy(alpha = 0.15f)
                                        res.category.contains("ಪಾಠ") -> VibrantBlue.copy(alpha = 0.15f)
                                        else -> VibrantPurple.copy(alpha = 0.15f)
                                    }
                                )
                                .padding(horizontal = 8.dp, vertical = 3.dp)
                        ) {
                            Text(
                                text = res.category,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = when {
                                    res.category.contains("ಮನೆಗೆಲಸ") -> VibrantOrange
                                    res.category.contains("ಪಾಠ") -> VibrantBlue
                                    else -> VibrantPurple
                                }
                            )
                        }

                        Text(
                            text = res.date,
                            fontSize = 11.sp,
                            color = VibrantTextMuted
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = res.title,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 17.sp,
                        color = VibrantTextDark
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "✍️ ಶಿಕ್ಷಕರು: ${res.teacherName}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = VibrantHeaderPink
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = res.content,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        lineHeight = 20.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = { onSpeakRequested("${res.title}. ${res.content}") },
                            colors = ButtonDefaults.buttonColors(containerColor = VibrantOrange.copy(alpha = 0.12f)),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Icon(Icons.Default.VolumeUp, contentDescription = "Listen", tint = VibrantOrange, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("🔊 ಆಲಿಸಿ (Listen)", color = VibrantOrange, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        }

                        IconButton(onClick = { onDeleteTeacherResource(res.id) }) {
                            Icon(Icons.Default.Delete, contentDescription = "Delete Resource", tint = VibrantRose.copy(alpha = 0.7f))
                        }
                    }
                }
            }
        }

        // Add Quick Student Feedback Note Input Box
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "✍️ ವಿದ್ಯಾರ್ಥಿಗೆ ಶಿಕ್ಷಕರ ಪ್ರತ್ಯೇಕ ಸಲಹೆ (Personal Note)",
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

