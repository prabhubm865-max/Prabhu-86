@file:OptIn(ExperimentalLayoutApi::class)

package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
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
import com.example.data.GunithaksharaRow
import com.example.data.KannadaRepository
import com.example.data.LetterItem
import com.example.data.Topic
import com.example.ui.components.MatchingGameComponent
import com.example.ui.components.SentenceBuilderGame
import com.example.ui.components.TracingCanvas
import com.example.ui.components.WordBuilderGame
import com.example.ui.theme.KannadaGreen
import com.example.ui.theme.KannadaOrange
import com.example.ui.theme.KannadaRed

@Composable
fun LessonDetailScreen(
    topic: Topic,
    isCompleted: Boolean,
    onMarkCompleted: (String) -> Unit,
    onSpeakRequested: (String) -> Unit,
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedLetter by remember { mutableStateOf("ಅ") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        // Top Navigation Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClicked) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Text(
                text = topic.title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Dynamic Lesson Topic View
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            when (topic.id) {
                "l1_swaragalu" -> {
                    item {
                        Text(
                            text = "🌸 ಕನ್ನಡ ಸ್ವರಗಳು (15 Vowels)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp
                        )
                        Text(
                            text = "ಅಕ್ಷರವನ್ನು ಸ್ಪರ್ಶಿಸಿ ಉಚ್ಚಾರಣೆ ಕೇಳಿ ಹಾಗೂ ಕೆಳಗೆ ಬರೆಯಿರಿ:",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }

                    item {
                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            KannadaRepository.vowels.forEach { vowel ->
                                val isSelected = selectedLetter == vowel.letter
                                Card(
                                    onClick = {
                                        selectedLetter = vowel.letter
                                        onSpeakRequested("${vowel.letter} - ${vowel.exampleWord}")
                                    },
                                    shape = RoundedCornerShape(16.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = if (isSelected) KannadaOrange else MaterialTheme.colorScheme.surfaceVariant
                                    )
                                ) {
                                    Column(
                                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = vowel.letter,
                                            fontSize = 24.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface
                                        )
                                        Text(
                                            text = "${vowel.emoji} ${vowel.exampleWord}",
                                            fontSize = 10.sp,
                                            color = if (isSelected) Color.White else Color.DarkGray
                                        )
                                    }
                                }
                            }
                        }
                    }

                    item {
                        val currentVowel = KannadaRepository.vowels.find { it.letter == selectedLetter } ?: KannadaRepository.vowels.first()
                        TracingCanvas(
                            letter = currentVowel.letter,
                            exampleWord = currentVowel.exampleWord,
                            onSpeakRequested = onSpeakRequested
                        )
                    }
                }

                "l1_vyanjanagalu" -> {
                    item {
                        Text(
                            text = "📚 ಕನ್ನಡ ವ್ಯಂಜನಗಳು (34 Consonants)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp
                        )
                    }

                    items(KannadaRepository.consonants.chunked(3)) { rowItems ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            rowItems.forEach { consonant ->
                                Card(
                                    onClick = {
                                        onSpeakRequested("${consonant.letter} - ${consonant.exampleWord}")
                                    },
                                    modifier = Modifier.weight(1f),
                                    shape = RoundedCornerShape(16.dp),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(12.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(text = consonant.letter, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(text = "${consonant.emoji} ${consonant.exampleWord}", fontSize = 12.sp, fontWeight = FontWeight.Medium)
                                        Text(text = consonant.meaningInEnglish, fontSize = 10.sp, color = Color.Gray)
                                    }
                                }
                            }
                        }
                    }
                }

                "l1_gunithaksharagalu" -> {
                    item {
                        Text(
                            text = "✍️ ಬಳ್ಳಿಗಳು / ಗುಣಿತಾಕ್ಷರಗಳು (Kagunitha)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp
                        )
                    }

                    items(KannadaRepository.gunithaksharaRows) { row ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(18.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Text(
                                    text = "ಅಕ್ಷರ: ' ${row.baseConsonant} ' ಸಾಲು",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                FlowRow(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    row.forms.forEach { form ->
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(Color.White)
                                                .clickable { onSpeakRequested(form) }
                                                .padding(horizontal = 10.dp, vertical = 6.dp)
                                        ) {
                                            Text(text = form, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                "l1_sarala_padagalu" -> {
                    item {
                        Text(text = "🔤 ಸರಳ ಪದಗಳು", fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    }

                    items(KannadaRepository.simpleWords) { wordItem ->
                        Card(
                            onClick = { onSpeakRequested(wordItem.word) },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = wordItem.emoji, fontSize = 32.sp)
                                Spacer(modifier = Modifier.width(16.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(text = wordItem.word, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                                    Text(text = "ಅರ್ಥ: ${wordItem.englishMeaning}", fontSize = 12.sp, color = Color.Gray)
                                    Text(text = "ವಿಂಗಡಣೆ: ${wordItem.breakdown}", fontSize = 11.sp, color = KannadaRed)
                                }
                                Icon(Icons.Default.VolumeUp, contentDescription = "Speak", tint = KannadaOrange)
                            }
                        }
                    }
                }

                "l1_sarala_vakyagalu" -> {
                    item {
                        Text(text = "📖 ಸರಳ ವಾಕ್ಯಗಳು", fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    }

                    items(KannadaRepository.simpleSentences) { sent ->
                        Card(
                            onClick = { onSpeakRequested(sent.sentence) },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(text = sent.sentence, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(text = sent.englishTranslation, fontSize = 12.sp, color = Color.Gray)
                                }
                                Icon(Icons.Default.VolumeUp, contentDescription = "Speak", tint = KannadaOrange)
                            }
                        }
                    }
                }

                "l2_sajaathi_ottakshara", "l2_vijaathi_ottakshara" -> {
                    val filterType = if (topic.id == "l2_sajaathi_ottakshara") "ಸಜಾತಿ" else "ವಿಜಾತಿ"
                    val items = KannadaRepository.ottaksharaItems.filter { it.typeName == filterType }

                    item {
                        Text(text = "🧩 $filterType ಒತ್ತಕ್ಷರಗಳ ಉದಾಹರಣೆಗಳು", fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    }

                    items(items) { item ->
                        Card(
                            onClick = { onSpeakRequested(item.word) },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = item.word, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(KannadaOrange)
                                            .padding(horizontal = 10.dp, vertical = 4.dp)
                                    ) {
                                        Text(text = "ಒತ್ತಕ್ಷರ: ${item.ottaksharaSymbol}", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                                    }
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = "ಅರ್ಥ: ${item.meaning}", fontSize = 13.sp)
                                Text(text = "ವಿಂಗಡಣೆ: ${item.breakdown}", fontSize = 11.sp, color = Color.Gray)
                            }
                        }
                    }
                }

                "l2_gaadhe_mathugalu" -> {
                    item {
                        Text(text = "💡 ಪ್ರಸಿದ್ಧ ಕನ್ನಡ ಗಾದೆಗಳು", fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    }

                    items(KannadaRepository.proverbs) { proverb ->
                        Card(
                            onClick = { onSpeakRequested(proverb.proverb) },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(18.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = "\" ${proverb.proverb} \"", fontWeight = FontWeight.Bold, fontSize = 17.sp, color = MaterialTheme.colorScheme.primary)
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = "ಅರ್ಥ: ${proverb.meaning}", fontSize = 13.sp)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = "ಸಂದೇಶ: ${proverb.moral}", fontSize = 12.sp, color = KannadaGreen, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }

                "l2_nudigattugalu" -> {
                    item {
                        Text(text = "💎 ಕನ್ನಡ ನುಡಿಗಟ್ಟುಗಳು", fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    }

                    items(KannadaRepository.idioms) { idiom ->
                        Card(
                            onClick = { onSpeakRequested(idiom.idiom) },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(18.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = idiom.idiom, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = KannadaOrange)
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = "ಅರ್ಥ: ${idiom.meaning}", fontSize = 13.sp)
                                Text(text = "ವಾಕ್ಯ: ${idiom.exampleSentence}", fontSize = 12.sp, color = Color.Gray)
                            }
                        }
                    }
                }

                "l3_samanarthaka" -> {
                    item {
                        Text(text = "🔄 ಸಮಾನಾರ್ಥಕ ಪದಗಳು", fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    }

                    items(KannadaRepository.synonyms) { item ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = "ಪದ: ${item.word}", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = "ಸಮಾನಾರ್ಥಗಳು: ${item.synonyms.joinToString(", ")}", fontSize = 14.sp, color = KannadaGreen)
                            }
                        }
                    }
                }

                "l3_viruddhaarthaka" -> {
                    item {
                        Text(text = "↔️ ವಿರುದ್ಧಾರ್ಥಕ ಪದಗಳು", fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    }

                    items(KannadaRepository.antonyms) { item ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = item.word, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                                Text(text = "❌ ↔️", fontSize = 16.sp)
                                Text(text = item.opposite, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = KannadaRed)
                            }
                        }
                    }
                }

                "l3_kathe_poornagolisuvike" -> {
                    val story = KannadaRepository.stories.first()

                    item {
                        var selectedChoiceIndex by remember { mutableStateOf<Int?>(null) }

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                        ) {
                            Column(modifier = Modifier.padding(18.dp)) {
                                Text(text = story.title, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = KannadaRed)
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(text = story.introParagraph, fontSize = 14.sp, lineHeight = 20.sp)
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(text = "ಮುಂದಿನ ಭಾಗ ಆಯ್ಕೆ ಮಾಡಿ:", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                                Spacer(modifier = Modifier.height(8.dp))

                                story.choices.forEachIndexed { index, choice ->
                                    Card(
                                        onClick = { selectedChoiceIndex = index },
                                        shape = RoundedCornerShape(12.dp),
                                        colors = CardDefaults.cardColors(
                                            containerColor = if (selectedChoiceIndex == index) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant
                                        ),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 4.dp)
                                    ) {
                                        Text(text = choice.optionText, modifier = Modifier.padding(12.dp), fontSize = 13.sp)
                                    }
                                }

                                if (selectedChoiceIndex != null) {
                                    val choice = story.choices[selectedChoiceIndex!!]
                                    Spacer(modifier = Modifier.height(14.dp))
                                    Text(text = choice.nextParagraph, fontSize = 14.sp, fontWeight = FontWeight.Medium)
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(text = "💡 ನೀತಿ: ${story.moral}", fontSize = 13.sp, color = KannadaGreen, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }

                "l1_chitra_pada_match", "l2_chitra_vakya" -> {
                    item {
                        val matchingPairs = listOf(
                            com.example.data.MatchingPair("1", "ಮನೆ", "🏠 House"),
                            com.example.data.MatchingPair("2", "ಆನೆ", "🐘 Elephant"),
                            com.example.data.MatchingPair("3", "ಕಮಲ", "🪷 Lotus"),
                            com.example.data.MatchingPair("4", "ನವಿಲು", "🦚 Peacock"),
                            com.example.data.MatchingPair("5", "ಸೂರ್ಯ", "☀️ Sun")
                        )
                        MatchingGameComponent(
                            pairs = matchingPairs,
                            onGameCompleted = { onMarkCompleted(topic.id) }
                        )
                    }
                }

                "l1_pada_guruthisuvike", "l2_pada_rachane", "l2_jumbled_words", "l3_kathina_ottakshara" -> {
                    item {
                        WordBuilderGame(
                            wordItems = KannadaRepository.simpleWords,
                            onWordCompleted = { success ->
                                if (success) onMarkCompleted(topic.id)
                            },
                            onSpeakWord = onSpeakRequested
                        )
                    }
                }

                "l2_vakya_rachane", "l2_jumbled_sentences", "l3_sundara_vakya" -> {
                    item {
                        SentenceBuilderGame(
                            sentences = KannadaRepository.simpleSentences,
                            onSentenceCompleted = { success ->
                                if (success) onMarkCompleted(topic.id)
                            },
                            onSpeakSentence = onSpeakRequested
                        )
                    }
                }

                else -> {
                    item {
                        Text(text = "ವಿಷಯ: ${topic.title}", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = topic.description, fontSize = 14.sp)
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }
        }

        // Complete Topic Button Footer
        Button(
            onClick = { onMarkCompleted(topic.id) },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isCompleted) KannadaGreen else KannadaOrange
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        ) {
            Icon(Icons.Default.CheckCircle, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = if (isCompleted) "ವಿಷಯ ಪೂರ್ಣಗೊಂಡಿದೆ ✅ (Completed)" else "ಪಾಠ ಪೂರ್ಣಗೊಳಿಸಿ (+10 ⭐)",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }
    }
}
