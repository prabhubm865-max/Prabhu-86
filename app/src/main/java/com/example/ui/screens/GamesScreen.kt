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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
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
import com.example.data.MatchingPair
import com.example.data.QuizQuestion
import com.example.ui.components.ImageQuizComponent
import com.example.ui.components.MatchingGameComponent
import com.example.ui.components.SentenceBuilderGame
import com.example.ui.components.WordBuilderGame
import com.example.ui.theme.VibrantAmber
import com.example.ui.theme.VibrantBlue
import com.example.ui.theme.VibrantBorderLight
import com.example.ui.theme.VibrantEmerald
import com.example.ui.theme.VibrantHeaderPink
import com.example.ui.theme.VibrantOrange
import com.example.ui.theme.VibrantPurple
import com.example.ui.theme.VibrantRose
import com.example.ui.theme.VibrantTextDark
import com.example.ui.theme.VibrantTextMuted

enum class GameMode {
    HUB, IMAGE_QUIZ, WORD_BUILDER, SENTENCE_BUILDER, MATCHING, PROVERB_QUIZ, SPEED_QUIZ, BILINGUAL_QUIZ
}

@Composable
fun GamesScreen(
    onStarsAwarded: (Int) -> Unit,
    onSpeakRequested: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var activeMode by remember { mutableStateOf(GameMode.HUB) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        if (activeMode != GameMode.HUB) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { activeMode = GameMode.HUB }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back to Game Hub", tint = VibrantHeaderPink)
                }
                Text(
                    text = "🎮 ಆಟಗಳ ಸಭಾಂಗಣಕ್ಕೆ ಹಿಂತಿರುಗಿ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = VibrantHeaderPink
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        when (activeMode) {
            GameMode.HUB -> GameHubSelector(onSelectGame = { activeMode = it })

            GameMode.IMAGE_QUIZ -> ImageQuizComponent(
                questions = KannadaRepository.imageQuizQuestions,
                onStarsAwarded = onStarsAwarded,
                onSpeakRequested = onSpeakRequested
            )

            GameMode.WORD_BUILDER -> WordBuilderGame(
                wordItems = KannadaRepository.simpleWords,
                onWordCompleted = { success ->
                    if (success) onStarsAwarded(5)
                },
                onSpeakWord = onSpeakRequested
            )

            GameMode.SENTENCE_BUILDER -> SentenceBuilderGame(
                sentences = KannadaRepository.simpleSentences,
                onSentenceCompleted = { success ->
                    if (success) onStarsAwarded(10)
                },
                onSpeakSentence = onSpeakRequested
            )

            GameMode.MATCHING -> {
                val matchingPairs = listOf(
                    MatchingPair("1", "ಮನೆ", "🏠 House"),
                    MatchingPair("2", "ಆನೆ", "🐘 Elephant"),
                    MatchingPair("3", "ಕಮಲ", "🪷 Lotus"),
                    MatchingPair("4", "ನವಿಲು", "🦚 Peacock"),
                    MatchingPair("5", "ಸೂರ್ಯ", "☀️ Sun")
                )
                MatchingGameComponent(
                    pairs = matchingPairs,
                    onGameCompleted = { stars -> onStarsAwarded(stars) }
                )
            }

            GameMode.PROVERB_QUIZ -> ProverbQuizGame(
                onStarsAwarded = onStarsAwarded
            )

            GameMode.SPEED_QUIZ -> SpeedQuizGame(
                questions = KannadaRepository.quizQuestions,
                onQuizFinished = { score -> onStarsAwarded(score * 10) }
            )

            GameMode.BILINGUAL_QUIZ -> ImageQuizComponent(
                questions = KannadaRepository.bilingualQuizQuestions.map { q ->
                    com.example.data.ImageQuizQuestion(
                        id = q.id,
                        imageEmoji = "🇬🇧 🇮🇳",
                        englishMeaning = q.questionText,
                        options = q.options,
                        correctIndex = q.correctIndex,
                        explanation = q.explanation
                    )
                },
                onStarsAwarded = onStarsAwarded,
                onSpeakRequested = onSpeakRequested
            )
        }
    }
}

@Composable
fun GameHubSelector(
    onSelectGame: (GameMode) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Text(
                text = "🎮 ಕನ್ನಡ ಆಟಗಳ ಜಗತ್ತು (Games Hub)",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                color = VibrantTextDark
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "ಆಟವಾಡುತ್ತಾ ನಕ್ಷತ್ರಗಳನ್ನು ಗಳಿಸಿ ಮತ್ತು ಪದ ಕೌಶಲ್ಯ ಬೆಳೆಸಿಕೊಳ್ಳಿ!",
                fontSize = 13.sp,
                color = VibrantTextMuted
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            GameCard(
                title = "🖼️ ಚಿತ್ರ ರಸಪ್ರಶ್ನೆ (Image Word Quiz)",
                description = "ಚಿತ್ರ ನೋಡಿ ೪ ಆಯ್ಕೆಗಳಿಂದ ಸರಿಯಾದ ಕನ್ನಡ ಪದ ಗುರುತಿಸಿ",
                iconEmoji = "🖼️",
                accentColor = VibrantPurple,
                onClick = { onSelectGame(GameMode.IMAGE_QUIZ) }
            )
        }

        item {
            GameCard(
                title = "🧩 ಅಕ್ಷರ ಜೋಡಣೆ (Word Builder)",
                description = "ಅಸ್ತವ್ಯಸ್ತವಾಗಿರುವ ಅಕ್ಷರಗಳನ್ನು ಜೋಡಿಸಿ ಹೊಸ ಪದ ನಿರ್ಮಿಸಿ",
                iconEmoji = "🧩",
                accentColor = VibrantOrange,
                onClick = { onSelectGame(GameMode.WORD_BUILDER) }
            )
        }

        item {
            GameCard(
                title = "✍️ ವಾಕ್ಯ ಜೋಡಣೆ (Sentence Builder)",
                description = "ಪದಗಳನ್ನು ಸರಿಯಾದ ಅನುಕ್ರಮದಲ್ಲಿರಿಸಿ ಅರ್ಥಪೂರ್ಣ ವಾಕ್ಯ ಮಾಡಿ",
                iconEmoji = "✍️",
                accentColor = VibrantBlue,
                onClick = { onSelectGame(GameMode.SENTENCE_BUILDER) }
            )
        }

        item {
            GameCard(
                title = "🖼️ ಚಿತ್ರ–ಪದ ಹೊಂದಾಣಿಕೆ (Image Match)",
                description = "ಕನ್ನಡ ಪದಗಳನ್ನು ಸರಿಯಾದ ಚಿತ್ರ ಹಾಗೂ ಅರ್ಥಕ್ಕೆ ಜೋಡಿಸಿ",
                iconEmoji = "🖼️",
                accentColor = VibrantEmerald,
                onClick = { onSelectGame(GameMode.MATCHING) }
            )
        }

        item {
            GameCard(
                title = "💡 ಗಾದೆ ಮಾತು ಪೂರ್ಣಗೊಳಿಸಿ (Proverb Quiz)",
                description = "ಜನಪ್ರಿಯ ಗಾದೆಗಳಲ್ಲಿ ಬಿಟ್ಟುಹೋದ ಪದವನ್ನು ಗುರುತಿಸಿ",
                iconEmoji = "💡",
                accentColor = VibrantPurple,
                onClick = { onSelectGame(GameMode.PROVERB_QUIZ) }
            )
        }

        item {
            GameCard(
                title = "⚡ ಕ್ಷಿಪ್ರ ರಸಪ್ರಶ್ನೆ (Speed Quiz)",
                description = "ಸಮಯದ ಮಿತಿಯಲ್ಲಿ ಕನ್ನಡದ ವರ್ಣಮಾಲೆ ಮತ್ತು ವ್ಯಾಕರಣ ಪ್ರಶ್ನೆಗಳಿಗೆ ಉತ್ತರಿಸಿ",
                iconEmoji = "⚡",
                accentColor = VibrantRose,
                onClick = { onSelectGame(GameMode.SPEED_QUIZ) }
            )
        }

        item {
            GameCard(
                title = "🇬🇧 🇮🇳 ದ್ವಿಭಾಷಾ ಇಂಗ್ಲಿಷ್ ರಸಪ್ರಶ್ನೆ (Bilingual Quiz)",
                description = "ಇಂಗ್ಲಿಷ್-ಕನ್ನಡ ವ್ಯಾಕರಣ, Parts of Speech ಮತ್ತು Tenses ಪರೀಕ್ಷಿಸಿ",
                iconEmoji = "🌐",
                accentColor = VibrantBlue,
                onClick = { onSelectGame(GameMode.BILINGUAL_QUIZ) }
            )
        }

        item { Spacer(modifier = Modifier.height(20.dp)) }
    }
}

@Composable
fun GameCard(
    title: String,
    description: String,
    iconEmoji: String,
    accentColor: Color,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, VibrantBorderLight, RoundedCornerShape(22.dp)),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .clip(CircleShape)
                    .background(accentColor.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = iconEmoji, fontSize = 28.sp)
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = VibrantTextDark
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    fontSize = 12.sp,
                    color = VibrantTextMuted,
                    lineHeight = 16.sp
                )
            }
        }
    }
}

@Composable
fun ProverbQuizGame(
    onStarsAwarded: (Int) -> Unit
) {
    var currentIndex by remember { mutableStateOf(0) }
    val proverbs = KannadaRepository.proverbs
    val current = proverbs.getOrNull(currentIndex) ?: return

    var selectedOption by remember { mutableStateOf<String?>(null) }
    var isSubmitted by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, VibrantBorderLight, RoundedCornerShape(24.dp)),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "💡 ಗಾದೆ ಮಾತು ಪೂರ್ಣಗೊಳಿಸಿ",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                color = VibrantHeaderPink
            )

            Spacer(modifier = Modifier.height(16.dp))

            val parts = current.proverb.split(" ")
            val maskedProverb = parts.mapIndexed { index, s ->
                if (index == current.missingWordIndex) "_______" else s
            }.joinToString(" ")

            Text(
                text = "\" $maskedProverb \"",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = VibrantTextDark
            )

            Spacer(modifier = Modifier.height(16.dp))

            current.options.forEach { option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            if (selectedOption == option) VibrantPurple.copy(alpha = 0.15f)
                            else Color(0xFFF8FAFC)
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedOption == option,
                        onClick = {
                            selectedOption = option
                            isSubmitted = false
                        }
                    )
                    Text(text = option, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = VibrantTextDark)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (isSubmitted) {
                val correctWord = current.options[0]
                if (selectedOption == correctWord) {
                    Text("🎉 ಅದ್ಭುತ! ಸರಿಯಾದ ಉತ್ತರ ⭐+10", color = VibrantEmerald, fontWeight = FontWeight.Bold)
                } else {
                    Text("❌ ತಪ್ಪಾಗಿದೆ. ಸರಿಯಾದ ಪದ: $correctWord", color = VibrantRose, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text("ಅರ್ಥ: ${current.meaning}", fontSize = 12.sp, color = VibrantTextMuted)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (!isSubmitted) {
                        isSubmitted = true
                        if (selectedOption == current.options[0]) {
                            onStarsAwarded(10)
                        }
                    } else {
                        currentIndex = (currentIndex + 1) % proverbs.size
                        selectedOption = null
                        isSubmitted = false
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = VibrantOrange),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(if (!isSubmitted) "ಉತ್ತರ ಪರಿಶೀಲಿಸಿ" else "ಮುಂದಿನ ಗಾದೆ ➡️", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun SpeedQuizGame(
    questions: List<QuizQuestion>,
    onQuizFinished: (Int) -> Unit
) {
    var currentIndex by remember { mutableStateOf(0) }
    val currentQ = questions.getOrNull(currentIndex) ?: return

    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    var score by remember { mutableStateOf(0) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, VibrantBorderLight, RoundedCornerShape(24.dp)),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("⚡ ಕ್ಷಿಪ್ರ ರಸಪ್ರಶ್ನೆ", fontWeight = FontWeight.Bold, color = VibrantRose)
                Text("${currentIndex + 1} / ${questions.size}", fontWeight = FontWeight.Bold, color = VibrantTextDark)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = currentQ.questionText,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = VibrantTextDark
            )

            Spacer(modifier = Modifier.height(16.dp))

            currentQ.options.forEachIndexed { i, opt ->
                val isSelected = selectedIndex == i
                val isCorrect = i == currentQ.correctIndex

                val containerColor = when {
                    selectedIndex != null && isCorrect -> VibrantEmerald.copy(alpha = 0.2f)
                    selectedIndex == i && !isCorrect -> VibrantRose.copy(alpha = 0.2f)
                    else -> Color(0xFFF8FAFC)
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(containerColor)
                        .clickable(enabled = selectedIndex == null) {
                            selectedIndex = i
                            if (i == currentQ.correctIndex) {
                                score++
                            }
                        }
                        .padding(horizontal = 14.dp, vertical = 12.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = "${i + 1}. $opt",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = VibrantTextDark
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            if (selectedIndex != null) {
                Spacer(modifier = Modifier.height(8.dp))
                val wasCorrect = selectedIndex == currentQ.correctIndex
                Text(
                    text = if (wasCorrect) "🎉 ಸರಿಯಾದ ಉತ್ತರ!" else "❌ ತಪ್ಪಾಗಿದೆ. ಸರಿಯಾದ ಉತ್ತರ: ${currentQ.options[currentQ.correctIndex]}",
                    color = if (wasCorrect) VibrantEmerald else VibrantRose,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    text = currentQ.explanation,
                    fontSize = 12.sp,
                    color = VibrantTextMuted,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (currentIndex < questions.size - 1) {
                        currentIndex++
                        selectedIndex = null
                    } else {
                        onQuizFinished(score)
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = VibrantRose),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    if (currentIndex < questions.size - 1) "ಮುಂದಿನ ಪ್ರಶ್ನೆ ➡️" else "ರಸಪ್ರಶ್ನೆ ಮುಗಿಸಿ 🏆",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

