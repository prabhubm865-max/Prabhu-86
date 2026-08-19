package com.example.data

enum class LearningLevelId {
    LEVEL_1, LEVEL_2, LEVEL_3
}

data class LearningLevel(
    val id: LearningLevelId,
    val title: String,
    val description: String,
    val iconEmoji: String,
    val topics: List<Topic>
)

data class Topic(
    val id: String,
    val levelId: LearningLevelId,
    val title: String,
    val description: String,
    val iconEmoji: String,
    val isInteractive: Boolean = true
)

data class LetterItem(
    val letter: String,
    val exampleWord: String,
    val meaningInEnglish: String,
    val emoji: String
)

data class GunithaksharaRow(
    val baseConsonant: String,
    val forms: List<String>
)

data class WordItem(
    val word: String,
    val englishMeaning: String,
    val emoji: String,
    val breakdown: String = ""
)

data class SentenceItem(
    val sentence: String,
    val englishTranslation: String,
    val jumbledWords: List<String>
)

data class OttaksharaItem(
    val word: String,
    val ottaksharaSymbol: String,
    val typeName: String, // "ಸಜಾತಿ" or "ವಿಜಾತಿ"
    val meaning: String,
    val breakdown: String
)

data class ProverbItem(
    val proverb: String,
    val meaning: String,
    val moral: String,
    val missingWordIndex: Int = -1,
    val options: List<String> = emptyList()
)

data class IdiomItem(
    val idiom: String,
    val meaning: String,
    val exampleSentence: String
)

data class SynonymItem(
    val word: String,
    val synonyms: List<String>
)

data class AntonymItem(
    val word: String,
    val opposite: String
)

data class StoryChoice(
    val optionText: String,
    val nextParagraph: String,
    val isCorrectMoralChoice: Boolean
)

data class StoryLesson(
    val id: String,
    val title: String,
    val introParagraph: String,
    val choices: List<StoryChoice>,
    val moral: String
)

data class MatchingPair(
    val id: String,
    val leftText: String,
    val rightText: String
)

data class QuizQuestion(
    val id: String,
    val questionText: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
)

data class BadgeInfo(
    val id: String,
    val title: String,
    val description: String,
    val iconEmoji: String,
    val requiredStars: Int
)

data class StudentNote(
    val id: String,
    val date: String,
    val noteText: String,
    val author: String
)
