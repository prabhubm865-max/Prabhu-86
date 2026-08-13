package com.example.data

object KannadaRepository {

    val levels = listOf(
        LearningLevel(
            id = LearningLevelId.LEVEL_1,
            title = "🟢 ಮೂಲಭೂತ ಕನ್ನಡ",
            description = "ಸ್ವರಗಳು, ವ್ಯಂಜನಗಳು, ಬಳ್ಳಿಗಳು, ಸರಳ ಪದಗಳು ಮತ್ತು ಚಿತ್ರ–ಪದ ಹೊಂದಾಣಿಕೆ",
            iconEmoji = "🌱",
            topics = listOf(
                Topic("l1_swaragalu", LearningLevelId.LEVEL_1, "1. ಸ್ವರಗಳು", "ಅ ನಿಂದ ಅಃ ವರೆಗಿನ ೧೫ ಸ್ವರಗಳು", "🌸"),
                Topic("l1_vyanjanagalu", LearningLevelId.LEVEL_1, "2. ವ್ಯಂಜನಗಳು", "ಕ ನಿಂದ ಳ ವರೆಗಿನ ೩೪ ವ್ಯಂಜನಗಳು", "📚"),
                Topic("l1_gunithaksharagalu", LearningLevelId.LEVEL_1, "3. ಬಳ್ಳಿಗಳು / ಗುಣಿತಾಕ್ಷರಗಳು", "ಕಾಗುಣಿತಾಕ್ಷರಗಳ ಪಟ್ಟಿ (ಕಾ, ಕಿ, ಕೀ...)", "✍️"),
                Topic("l1_sarala_padagalu", LearningLevelId.LEVEL_1, "4. ಸರಳ ಪದಗಳು", "ಎರಡು ಮತ್ತು ಮೂರು ಅಕ್ಷರಗಳ ಸರಳ ಪದಗಳು", "🔤"),
                Topic("l1_pada_guruthisuvike", LearningLevelId.LEVEL_1, "5. ಪದ ಗುರುತಿಸುವಿಕೆ", "ಅಕ್ಷರಗಳನ್ನು ನೋಡಿ ಪದ ಗುರುತಿಸಿ", "🎯"),
                Topic("l1_chitra_pada_match", LearningLevelId.LEVEL_1, "6. ಚಿತ್ರ–ಪದ ಹೊಂದಾಣಿಕೆ", "ಚಿತ್ರಗಳನ್ನು ನೋಡಿ ಸರಿಯಾದ ಪದ ಜೋಡಿಸಿ", "🖼️"),
                Topic("l1_sarala_vakyagalu", LearningLevelId.LEVEL_1, "7. ಸರಳ ವಾಕ್ಯಗಳು", "ದೈನಂದಿನ ಸರಳ ಕನ್ನಡ ವಾಕ್ಯಗಳು", "📖")
            )
        ),
        LearningLevel(
            id = LearningLevelId.LEVEL_2,
            title = "🟡 ಮಧ್ಯಮ ಕನ್ನಡ",
            description = "ಒತ್ತಕ್ಷರಗಳು, ಸಜಾತಿ-ವಿಜಾತಿ, Jumbled Words & Sentences, ಗಾದೆಗಳು",
            iconEmoji = "🌿",
            topics = listOf(
                Topic("l2_ottakshara_intro", LearningLevelId.LEVEL_2, "1. ಒತ್ತಕ್ಷರಗಳ ಪರಿಚಯ", "ಒತ್ತಕ್ಷರ ಎಂದರೇನು ಮತ್ತು ಅದರ ಮೂಲ ಪರಿಕಲ್ಪನೆ", "🧩"),
                Topic("l2_sajaathi_ottakshara", LearningLevelId.LEVEL_2, "2. ಸಜಾತಿ ಒತ್ತಕ್ಷರಗಳು", "ಅಕ್ಕ, ಅಜ್ಜ, ಅಮ್ಮ, ಕಪ್ಪ - ಒಂದೇ ರೀತಿಯ ಒತ್ತಕ್ಷರ", "👯"),
                Topic("l2_vijaathi_ottakshara", LearningLevelId.LEVEL_2, "3. ವಿಜಾತಿ ಒತ್ತಕ್ಷರಗಳು", "ರಕ್ತ, ಸೂರ್ಯ, ಪುಸ್ತಕ, ವಿದ್ಯಾ - ವಿಭಿನ್ನ ಒತ್ತಕ್ಷರ", "🔀"),
                Topic("l2_pada_rachane", LearningLevelId.LEVEL_2, "4. ಪದ ರಚನೆ", "ಅಕ್ಷರಗಳನ್ನ ಬಳಸಿ ಹೊಸ ಪದಗಳನ್ನು ನಿರ್ಮಿಸಿ", "🧱"),
                Topic("l2_vakya_rachane", LearningLevelId.LEVEL_2, "5. ವಾಕ್ಯ ರಚನೆ", "ಪದಗಳನ್ನು ಸರಿಯಾಗಿ ಜೋಡಿಸಿ ವಾಕ್ಯ ಮಾಡಿ", "📝"),
                Topic("l2_jumbled_words", LearningLevelId.LEVEL_2, "6. Jumbled Words", "ಅಕ್ಷರ ಜೋಡಣೆ ಆಟ", "🎮"),
                Topic("l2_jumbled_sentences", LearningLevelId.LEVEL_2, "7. Jumbled Sentences", "ವಾಕ್ಯ ಜೋಡಣೆ ಆಟ", "🧩"),
                Topic("l2_chitra_vakya", LearningLevelId.LEVEL_2, "8. ಚಿತ್ರ ನೋಡಿ ವಾಕ್ಯ ರಚನೆ", "ಚಿತ್ರವನ್ನು ವೀಕ್ಷಿಸಿ ಸೂಕ್ತ ವಾಕ್ಯ ಆಯ್ಕೆ ಮಾಡಿ", "🎨"),
                Topic("l2_gaadhe_mathugalu", LearningLevelId.LEVEL_2, "9. ಗಾದೆ ಮಾತುಗಳು", "ಜನಪ್ರಿಯ ಕನ್ನಡ ಗಾದೆಗಳು ಮತ್ತು ಅರ್ಥ", "💡"),
                Topic("l2_nudigattugalu", LearningLevelId.LEVEL_2, "10. ನುಡಿಗಟ್ಟುಗಳು", "ವಿಶೇಷ ನುಡಿಗಟ್ಟುಗಳು ಮತ್ತು ಉದಾಹರಣೆಗಳು", "💎")
            )
        ),
        LearningLevel(
            id = LearningLevelId.LEVEL_3,
            title = "🔴 ಉನ್ನತ ಕನ್ನಡ",
            description = "ಕಠಿಣ ಒತ್ತಕ್ಷರ, ಸಮಾನಾರ್ಥಕ, ವಿರುದ್ಧಾರ್ಥಕ, ಕಥೆ ಪೂರ್ಣಗೊಳಿಸುವಿಕೆ",
            iconEmoji = "🌳",
            topics = listOf(
                Topic("l3_kathina_ottakshara", LearningLevelId.LEVEL_3, "1. ಕಠಿಣ ಒತ್ತಕ್ಷರಗಳು", "ಸ್ವಾತಂತ್ರ್ಯ, ಸೌಂದರ್ಯ, ರಾಷ್ಟ್ರಧ್ವಜ ಮುಂತಾದ ಕಠಿಣ ಪದಗಳು", "🏛️"),
                Topic("l3_samanarthaka", LearningLevelId.LEVEL_3, "2. ಸಮಾನಾರ್ಥಕ ಪದಗಳು", "ಒಂದೇ ಅರ್ಥ ತರುವ ವಿಭಿನ್ನ ಪದಗಳು", "🔄"),
                Topic("l3_viruddhaarthaka", LearningLevelId.LEVEL_3, "3. ವಿರುದ್ಧಾರ್ಥಕ ಪದಗಳು", "ಪರಸ್ಪರ ವಿರುದ್ಧ ಅರ್ಥ ಕೊಡುವ ಪದಗಳು", "↔️"),
                Topic("l3_advanced_nudigattu_gaadhe", LearningLevelId.LEVEL_3, "4. ನುಡಿಗಟ್ಟು ಹಾಗೂ ಗಾದೆ ಆಟ", "ಉನ್ನತ ಮಟ್ಟದ ರಸಪ್ರಶ್ನೆ", "🎯"),
                Topic("l3_sundara_vakya", LearningLevelId.LEVEL_3, "5. ಸುಂದರ ವಾಕ್ಯ ರಚನೆ", "ಅಲಂಕಾರಿಕ ಮತ್ತು ಸ್ಪಷ್ಟ ವಾಕ್ಯ ನಿರ್ಮಾಣ", "✨"),
                Topic("l3_kathe_poornagolisuvike", LearningLevelId.LEVEL_3, "6. ಕಥೆ ಪೂರ್ಣಗೊಳಿಸುವಿಕೆ", "ಚಿಂತನೆ ನಡೆಸಿ ಕಥೆಯ ಮುಂದಿನ ಭಾಗ ಆಯ್ಕೆ ಮಾಡಿ", "📜")
            )
        ),
        LearningLevel(
            id = LearningLevelId.KANNADA_GRAMMAR,
            title = "📖 ಕನ್ನಡ ವ್ಯಾಕರಣ (Kannada Grammar)",
            description = "ನಾಮಪದ, ಸರ್ವನಾಮ, ಕ್ರಿಯಾಪದ, ಲಿಂಗ-ವಚನ, ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯ, ಸಮಾಸ ಮತ್ತು ಸಂಧಿಗಳು",
            iconEmoji = "📘",
            topics = listOf(
                Topic("gram_namapada", LearningLevelId.KANNADA_GRAMMAR, "1. ನಾಮಪದಗಳು (Nouns)", "ರೂಢನಾಮ, ಅಂಕಿತನಾಮ, ಅನ್ವರ್ಥನಾಮಗಳ ವಿವರಣೆ", "🏷️"),
                Topic("gram_sarvanama", LearningLevelId.KANNADA_GRAMMAR, "2. ಸರ್ವನಾಮಗಳು (Pronouns)", "ನಾನು, ನೀನು, ಅವನು, ಅವಳು, ನಾವು ಮುಂತಾದ ಪದಗಳು", "👤"),
                Topic("gram_kriyapada", LearningLevelId.KANNADA_GRAMMAR, "3. ಕ್ರಿಯಾಪದ & ಕಾಲಗಳು (Verbs & Tenses)", "ಭೂತಕಾಲ, ವರ್ತಮಾನಕಾಲ, ಭವಿಷ್ಯತ್ಕಾಲಗಳ ವಿವರಣೆ", "⏳"),
                Topic("gram_linga_vachana", LearningLevelId.KANNADA_GRAMMAR, "4. ಲಿಂಗ ಮತ್ತು ವಚನ (Gender & Number)", "ಪುಲ್ಲಿಂಗ, ಸ್ತ್ರೀಲಿಂಗ, ನಪುಂಸಕಲಿಂಗ; ಏಕವಚನ & ಬಹುವಚನ", "👫"),
                Topic("gram_vibhakti", LearningLevelId.KANNADA_GRAMMAR, "5. ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯಗಳು (7 Cases & Endings)", "ಪ್ರಥಮಾ ಉ, ದ್ವಿತೀಯಾ ಅನ್ನು, ತೃತೀಯಾ ಇಂದ...", "📜"),
                Topic("gram_samasagalu", LearningLevelId.KANNADA_GRAMMAR, "6. ಸಮಾಸಗಳು (Compound Words)", "ತತ್ಪುರುಷ, ಕರ್ಮಧಾರಯ, ದ್ವಂದ್ವ, ದ್ವಿಗು, ಬಹುವ್ರಹಿ", "🧩"),
                Topic("gram_sandhigalu", LearningLevelId.KANNADA_GRAMMAR, "7. ಸಂಧಿಗಳು (Sandhi Rules)", "ಲೋಪ, ಆಗಮ, ಆದೇಶ ಹಾಗೂ ಸಂಸ್ಕೃತ ಸಂಧಿಗಳು", "🔗")
            )
        ),
        LearningLevel(
            id = LearningLevelId.ENGLISH_BILINGUAL,
            title = "🇬🇧 🇮🇳 ಇಂಗ್ಲಿಷ್ ಕಲಿಕೆ & Grammar",
            description = "ದ್ವಿಭಾಷಾ ವಿಧಾನದ ಮೂಲಕ ಇಂಗ್ಲಿಷ್ ಸಂಭಾಷಣೆ, Parts of Speech, Tenses & Grammar",
            iconEmoji = "🌐",
            topics = listOf(
                Topic("eng_greetings", LearningLevelId.ENGLISH_BILINGUAL, "1. ದೈನಂದಿನ ಸಂಭಾಷಣೆ (Daily Conversations)", "ಇಂಗ್ಲಿಷ್ ಶುಭಾಶಯಗಳು, ವಾಕ್ಯಗಳು & ಕನ್ನಡ ಅರ್ಥ", "💬"),
                Topic("eng_parts_of_speech", LearningLevelId.ENGLISH_BILINGUAL, "2. English Parts of Speech", "Noun, Pronoun, Verb, Adjective with Kannada Explanations", "🏷️"),
                Topic("eng_tenses", LearningLevelId.ENGLISH_BILINGUAL, "3. English Tenses (ಕಾಲಗಳು)", "Present, Past & Future Tense with Kannada Translation", "🕒"),
                Topic("eng_sentence_structure", LearningLevelId.ENGLISH_BILINGUAL, "4. Sentence Structure (S+V+O)", "ಇಂಗ್ಲಿಷ್ ಮತ್ತು ಕನ್ನಡ ವಾಕ್ಯ ರಚನೆಯ ಹೋಲಿಕೆ", "📐"),
                Topic("eng_daily_vocabulary", LearningLevelId.ENGLISH_BILINGUAL, "5. Duality Vocabulary (ದ್ವಿಭಾಷಾ ಶಬ್ದಕೋಶ)", "ಶಾಲೆ, ಮನೆ, ಪ್ರಯಾಣಕ್ಕೆ ಅಗತ್ಯವಾದ ಇಂಗ್ಲಿಷ್ ಪದಗಳು", "📚"),
                Topic("eng_bilingual_quiz", LearningLevelId.ENGLISH_BILINGUAL, "6. ದ್ವಿಭಾಷಾ ಇಂಗ್ಲಿಷ್ ರಸಪ್ರಶ್ನೆ (Grammar Quiz)", "ಇಂಗ್ಲಿಷ್-ಕನ್ನಡ ವ್ಯಾಕರಣ ಪರೀಕ್ಷೆ", "🏆")
            )
        )
    )

    // Swaragalu (Vowels)
    val vowels = listOf(
        LetterItem("ಅ", "ಅಮ್ಮ", "Mother", "👩‍👦"),
        LetterItem("ಆ", "ಆನೆ", "Elephant", "🐘"),
        LetterItem("ಇ", "ಇಲಿ", "Mouse", "🐭"),
        LetterItem("ಈ", "ಈಶ", "God / Lord Shiva", "✨"),
        LetterItem("ಉ", "ಉಟ", "Lunch / Food", "🍲"),
        LetterItem("ಊ", "ಊಟ", "Feast / Meal", "🍛"),
        LetterItem("ಋ", "ಋಷಿ", "Sage / Saint", "🧘‍♂️"),
        LetterItem("ಎ", "ಎಲೆ", "Leaf", "🍃"),
        LetterItem("ಏ", "ಏಣಿ", "Ladder", "🪜"),
        LetterItem("ಐ", "ಐದು", "Number Five", "5️⃣"),
        LetterItem("ಒ", "ಒಂಟೆ", "Camel", "🐪"),
        LetterItem("ಓ", "ಓದು", "Read / Study", "📖"),
        LetterItem("ಔ", "ಔಷಧ", "Medicine", "💊"),
        LetterItem("ಅಂ", "ಅಂಬಾರಿ", "Elephant Howdah", "👑"),
        LetterItem("ಅಃ", "ಅಂತಃಕರಣ", "Compassion", "❤️")
    )

    // Vyanjanagalu (Consonants)
    val consonants = listOf(
        LetterItem("ಕ", "ಕಮಲ", "Lotus", "🪷"),
        LetterItem("ಖ", "ಖಡ್ಗ", "Sword", "🗡️"),
        LetterItem("ಗ", "ಗಜ", "Elephant", "🐘"),
        LetterItem("ಘ", "ಘಂಟೆ", "Bell", "🔔"),
        LetterItem("ಙ", "ಙ", "Nasal Sound", "🎵"),
        LetterItem("ಚ", "ಚಮಚ", "Spoon", "🥄"),
        LetterItem("ಛ", "ಛತ್ರಿ", "Umbrella", "☂️"),
        LetterItem("ಜ", "ಜನ", "People", "👥"),
        LetterItem("ಝ", "ಝರಿ", "Water Stream", "🌊"),
        LetterItem("ಞ", "ಞ", "Nasal Sound", "🎵"),
        LetterItem("ತ", "ತಬಲ", "Tabla Drum", "🥁"),
        LetterItem("ಥ", "ಥರಥರ", "Shivering", "🥶"),
        LetterItem("ದ", "ದೀಪ", "Lamp / Light", "🪔"),
        LetterItem("ಧ", "ಧನುಸ್ಸು", "Bow (Weapon)", "🏹"),
        LetterItem("ನ", "ನವಿಲು", "Peacock", "🦚"),
        LetterItem("ಪ", "ಪಟ", "Kite", "🪁"),
        LetterItem("ಫ", "ಫಲ", "Fruit", "🍎"),
        LetterItem("ಬ", "ಬಸ್", "Bus", "🚌"),
        LetterItem("ಭ", "ಭಾರತ", "India", "🇮🇳"),
        LetterItem("ಮ", "ಮರ", "Tree", "🌳"),
        LetterItem("ಯ", "ಯಜ್ಞ", "Sacred Fire", "🔥"),
        LetterItem("ರ", "ರಥ", "Chariot", "🛞"),
        LetterItem("ಲ", "ಲತಾ", "Creeper Plant", "🌱"),
        LetterItem("ವ", "ವನ", "Forest", "🌲"),
        LetterItem("ಶ", "ಶಂಖ", "Conch Shell", "🐚"),
        LetterItem("ಷ", "ಷಟ್ಕೋನ", "Hexagon", "🛑"),
        LetterItem("ಸ", "ಸೂರ್ಯ", "Sun", "☀️"),
        LetterItem("ಹ", "ಹೂವು", "Flower", "🌸"),
        LetterItem("ಳ", "ನಾಳ", "Pipe / Tube", "🧪")
    )

    // Kagunitha Samples
    val gunithaksharaRows = listOf(
        GunithaksharaRow("ಕ", listOf("ಕ", "ಕಾ", "ಕಿ", "ಕೀ", "ಕು", "ಕೂ", "ಕೃ", "ಕೆ", "ಕೇ", "ಕೈ", "ಕೊ", "ಕೋ", "ಕೌ", "ಕಂ", "ಕಃ")),
        GunithaksharaRow("ಗ", listOf("ಗ", "ಗಾ", "ಗಿ", "ಗೀ", "ಗು", "ಗೂ", "ಗೃ", "ಗೆ", "ಗೇ", "ಗೈ", "ಗೊ", "ಗೋ", "ಗೌ", "ಗಂ", "ಗಃ")),
        GunithaksharaRow("ಚ", listOf("ಚ", "ಚಾ", "ಚಿ", "ಚೀ", "ಚು", "ಚೂ", "ಚೃ", "ಚೆ", "ಚೇ", "ಚೈ", "ಚೊ", "ಚೋ", "ಚೌ", "ಚಂ", "ಚಃ")),
        GunithaksharaRow("ತ", listOf("ತ", "ತಾ", "ತಿ", "ತೀ", "ತು", "ತೂ", "ತೃ", "ತೆ", "ತೇ", "ತೈ", "ತೊ", "ತೋ", "ತೌ", "ತಂ", "ತಃ")),
        GunithaksharaRow("ನ", listOf("ನ", "ನಾ", "ನಿ", "ನೀ", "ನು", "ನೂ", "ನೃ", "ನೆ", "ನೇ", "ನೈ", "ನೊ", "ನೋ", "ನೌ", "ನಂ", "ನಃ")),
        GunithaksharaRow("ಪ", listOf("ಪ", "ಪಾ", "ಪಿ", "ಪೀ", "ಪು", "ಪೂ", "ಪೃ", "ಪೆ", "ಪೇ", "ಪೈ", "ಪೊ", "ಪೋ", "ಪೌ", "ಪಂ", "ಪಃ")),
        GunithaksharaRow("ಮ", listOf("ಮ", "ಮಾ", "ಮಿ", "ಮೀ", "ಮು", "ಮೂ", "ಮೃ", "ಮೆ", "ಮೇ", "ಮೈ", "ಮೊ", "ಮೋ", "ಮೌ", "ಮಂ", "ಮಃ")),
        GunithaksharaRow("ರ", listOf("ರ", "ರಾ", "ರಿ", "ರೀ", "ರು", "ರೂ", "ರೃ", "ರೆ", "ರೇ", "ರೈ", "ರೊ", "ರೋ", "ರೌ", "ರಂ", "ರಃ")),
        GunithaksharaRow("ಸ", listOf("ಸ", "ಸಾ", "ಸಿ", "ಸೀ", "ಸು", "ಸೂ", "ಸೃ", "ಸೆ", "ಸೇ", "ಸೈ", "ಸೊ", "ಸೋ", "ಸೌ", "ಸಂ", "ಸಃ"))
    )

    // Simple Words
    val simpleWords = listOf(
        WordItem("ಮನೆ", "House", "🏠", "ಮ + ನೆ"),
        WordItem("ಮರ", "Tree", "🌳", "ಮ + ರ"),
        WordItem("ಆನೆ", "Elephant", "🐘", "ಆ + ನೆ"),
        WordItem("ಕಮಲ", "Lotus", "🪷", "ಕ + ಮ + ಲ"),
        WordItem("ಸರ", "Necklace", "📿", "ಸ + ರ"),
        WordItem("ಗಿಡ", "Plant", "🌱", "ಗಿ + ಡ"),
        WordItem("ಹೂವು", "Flower", "🌸", "ಹೂ + ವು"),
        WordItem("ನವಿಲು", "Peacock", "🦚", "ನ + ವಿ + లు"),
        WordItem("ದೀಪ", "Lamp", "🪔", "ದೀ + ಪ"),
        WordItem("ಫಲ", "Fruit", "🍎", "ಫ + ಲ"),
        WordItem("ಬಸ್", "Bus", "🚌", "ಬ + ಸ್"),
        WordItem("ರಥ", "Chariot", "🛞", "ರ + ಥ")
    )

    // Simple Sentences
    val simpleSentences = listOf(
        SentenceItem("ಇದು ನನ್ನ ಮನೆ.", "This is my house.", listOf("ಮನೆ", "ಇದು", "ನನ್ನ")),
        SentenceItem("ನವಿಲು ಸುಂದರ ಪಕ್ಷಿ.", "Peacock is a beautiful bird.", listOf("ಪಕ್ಷಿ", "ನವಿಲು", "ಸುಂದರ")),
        SentenceItem("ಆನೆ ದೊಡ್ಡ ಪ್ರಾಣಿ.", "Elephant is a big animal.", listOf("ಪ್ರಾಣಿ", "ದೊಡ್ಡ", "ಆನೆ")),
        SentenceItem("ಕಮಲ ನೀರಿನಲ್ಲಿ ಅರಳುತ್ತದೆ.", "Lotus blooms in water.", listOf("ಅರಳುತ್ತದೆ", "ನೀರಿನಲ್ಲಿ", "ಕಮಲ")),
        SentenceItem("ಸೂರ್ಯ ಮೂಡಣದಲ್ಲಿ ಉದಯಿಸುತ್ತಾನೆ.", "Sun rises in the east.", listOf("ಉದಯಿಸುತ್ತಾನೆ", "ಸೂರ್ಯ", "ಮೂಡಣದಲ್ಲಿ")),
        SentenceItem("ನಾವು ದಿನವೂ ಶಾಲೆಗೆ ಹೋಗುತ್ತೇವೆ.", "We go to school daily.", listOf("ಹೋಗುತ್ತೇವೆ", "ಶಾಲೆಗೆ", "ನಾವು", "ದಿನವೂ"))
    )

    // Sajaathi & Vijaathi Ottakshara Items
    val ottaksharaItems = listOf(
        OttaksharaItem("ಅಕ್ಕ", "ಕ್ಕ", "ಸಜಾತಿ", "Elder Sister", "ಅ + ಕ + ್ + ಕ"),
        OttaksharaItem("ಅಜ್ಜ", "ಜ್ಜ", "ಸಜಾತಿ", "Grandfather", "ಅ + ಜ + ್ + ಜ"),
        OttaksharaItem("ಅಮ್ಮ", "ಮ್ಮ", "ಸಜಾತಿ", "Mother", "ಅ + ಮ + ್ + ಮ"),
        OttaksharaItem("ಕಪ್ಪ", "ಪ್ಪ", "ಸಜಾತಿ", "Frog / Dark", "ಕ + ಪ + ್ + ಪ"),
        OttaksharaItem("ಅಣ್ಣ", "ಣ್ಣ", "ಸಜಾತಿ", "Elder Brother", "ಅ + ಣ + ್ + ಣ"),
        OttaksharaItem("ಹದ್ದು", "ದ್ದು", "ಸಜಾತಿ", "Eagle / Vulture", "ಹ + ದ + ್ + ದ + ು"),
        OttaksharaItem("ರಕ್ತ", "ಕ್ತ", "ವಿಜಾತಿ", "Blood", "ರ + ಕ + ್ + ತ"),
        OttaksharaItem("ಸೂರ್ಯ", "ರ್ಯ", "ವಿಜಾತಿ", "Sun", "ಸ + ೂ + ರ + ್ + ಯ"),
        OttaksharaItem("ಪುಸ್ತಕ", "ಸ್ತ", "ವಿಜಾತಿ", "Book", "ಪು + ಸ + ್ + ತ + ಕ"),
        OttaksharaItem("ವಿದ್ಯಾ", "ದ್ಯ", "ವಿಜಾತಿ", "Education", "ವಿ + ದ + ್ + ಯ + ಾ"),
        OttaksharaItem("ಸತ್ಯ", "ತ್ಯ", "ವಿಜಾತಿ", "Truth", "ಸ + ತ + ್ + ಯ"),
        OttaksharaItem("ಚಂದ್ರ", "ಂದ", "ವಿಜಾತಿ", "Moon", "ಚ + ಂ + ದ + ್ + ರ")
    )

    // Proverbs
    val proverbs = listOf(
        ProverbItem(
            proverb = "ಉಪ್ಪಿಗಿಂತ ರುಚಿಯಿಲ್ಲ, ತಾಯಿಗಿಂತ ಬಂಧುವಿಲ್ಲ.",
            meaning = "ಉಪ್ಪು ಆಹಾರಕ್ಕೆ ಅತ್ಯಗತ್ಯ, ತಾಯಿಯ ಪ್ರೀತಿಯು ಜಗತ್ತಿನ ಎಲ್ಲ ಸಂಬಂಧಗಳಿಗಿಂತ ಮಿಗಿಲಾದುದು.",
            moral = "ತಾಯಿಯನ್ನು ಹಾಗೂ ಆಹಾರವನ್ನು ಸದಾ ಗೌರವಿಸಿ.",
            missingWordIndex = 0,
            options = listOf("ಉಪ್ಪಿಗಿಂತ", "ಸಕ್ಕರೆಗಿಂತ", "ಹಾಲಿಗಿಂತ", "ತುಪ್ಪಕ್ಕಿಂತ")
        ),
        ProverbItem(
            proverb = "ಕಾಯಕವೇ ಕೈಲಾಸ.",
            meaning = "ನಾವು ಮಾಡುವ ಪ್ರಾಮಾಣಿಕ ಕೆಲಸವೇ ನಮಗೆ ಮೋಕ್ಷ ಮತ್ತು ನೆಮ್ಮದಿ ನೀಡುತ್ತದೆ.",
            moral = "ಶ್ರಮ ಮತ್ತು ದುಡಿಮೆಗೆ ಅಗ್ರ ಆದ್ಯತೆ ನೀಡಿ.",
            missingWordIndex = 0,
            options = listOf("ಕಾಯಕವೇ", "ಜ್ಞಾನವೇ", "ಹಣವೇ", "ಮಾತೇ")
        ),
        ProverbItem(
            proverb = "ಹಾಸಿಗೆ ಇದ್ದಷ್ಟು ಕಾಲು ಚಾಚು.",
            meaning = "ನಮ್ಮ ಆದಾಯ ಮತ್ತು ಸಾಮರ್ಥ್ಯಕ್ಕೆ ತಕ್ಕಂತೆ ವೆಚ್ಚ ಮಾಡಬೇಕು.",
            moral = "ಮಿತವ್ಯಯ ಹಾಗೂ ಯೋಜನಾಬದ್ಧ ಜೀವನ ನಡೆಸಿ.",
            missingWordIndex = 1,
            options = listOf("ಕೈ", "ಕಾಲು", "ಬೆರಳು", "ತಲೆ")
        ),
        ProverbItem(
            proverb = "ಮಾತು ಬೆಳ್ಳಿ, ಮೌನ ಬಂಗಾರ.",
            meaning = "ಅಗತ್ಯವಿರುವಷ್ಟು ಮಾತ್ರ ಮಾತನಾಡಬೇಕು, ಅನಗತ್ಯ ಮಾತಿಗಿಂತ ಮೌನವೇ ಶ್ರೇಷ್ಠ.",
            moral = "ಯೋಚಿಸಿ ಮಾತನಾಡುವುದು ಜಾಣತನ.",
            missingWordIndex = 2,
            options = listOf("ವಜ್ರ", "ಬಂಗಾರ", "ತಾಮ್ರ", "ಕಬ್ಬಿಣ")
        ),
        ProverbItem(
            proverb = "ಕೈ ಕೆಸರಾದರೆ ಬಾಯಿ ಮೊಸರು.",
            meaning = "ಕಷ್ಟಪಟ್ಟು ಕೆಲಸ ಮಾಡಿದರೆ ಫಲ ಸಿಗುತ್ತದೆ.",
            moral = "ಶ್ರಮವಿಲ್ಲದೆ ಯಾವುದೇ ಯಶಸ್ಸು ಸಿಗುವುದಿಲ್ಲ.",
            missingWordIndex = 1,
            options = listOf("ಕೈ", "ಕೆಸರಾದರೆ", "ನೀರಾ ದರೆ", "ಕಲ್ಲಾದರೆ")
        )
    )

    // Idioms (ನುಡಿಗಟ್ಟುಗಳು)
    val idioms = listOf(
        IdiomItem("ಕಣ್ಣಿಗೆ ಎಣ್ಣೆ ಬಿಟ್ಟುಕೊಳ್ಳು", "ಬಹಳ ಜಾಗರೂಕರಾಗಿ ಮತ್ತು ಗಮನವಿಟ್ಟು ನೋಡುವುದು", "ಪರೀಕ್ಷೆಯ ಸಮಯದಲ್ಲಿ ವಿದ್ಯಾರ್ಥಿಗಳು ಕಣ್ಣಿಗೆ ಎಣ್ಣೆ ಬಿಟ್ಟುಕೊಂಡು ಓದಬೇಕು."),
        IdiomItem("ಬೆನ್ನಿಗೆ ಚೂರಿ ಹಾಕು", "ನಂಬಿಕೆ ದ್ರೋಹ ಮಾಡುವುದು ಅಥವಾ ಬೆನ್ನ ಹಿಂದೆ ಕೇಡು ಬಯಸುವುದು", "ನಿಜವಾದ ಸ್ನೇಹಿತರು ಎಂದಿಗೂ ಬೆನ್ನಿಗೆ ಚೂರಿ ಹಾಕುವುದಿಲ್ಲ."),
        IdiomItem("ಆಗಸಕ್ಕೆ ಏರು", "ಬಹಳ ಸಂತೋಷಪಡುವುದು ಅಥವಾ ಹಿಗ್ಗುವುದು", "ಪರೀಕ್ಷೆಯಲ್ಲಿ ಪ್ರಥಮ ಸ್ಥಾನ ಬಂದಾಗ ರಮೇಶನ ಮನಸ್ಸು ಆಗಸಕ್ಕೆ ಏರಿತು."),
        IdiomItem("ತಲೆ ಬಾಗು", "ಗೌರವ ನೀಡುವುದು ಅಥವಾ ಶರಣಾಗುವುದು", "ಹಿರಿಯರು ಮತ್ತು ಗುರುಗಳ ಮುಂದೆ ನಾವು ತಲೆ ಬಾಗಬೇಕು.")
    )

    // Synonyms (ಸಮಾನಾರ್ಥಕ ಪದಗಳು)
    val synonyms = listOf(
        SynonymItem("ನೀರು", listOf("ಜಲ", "ಉದಕ", "ವಾರಿ", "ಸಲಿಲ")),
        SynonymItem("ಸೂರ್ಯ", listOf("ರವಿ", "ಭಾನು", "ಅರ್ಕ", "ದಿನಕರ")),
        SynonymItem("ತಾಯಿ", listOf("ಅಮ್ಮ", "ಜನನಿ", "ಮಾತೆ", "ಹೆತ್ತವಳು")),
        SynonymItem("ಆಕಾಶ", listOf("ಗಗನ", "ನಭ", "ಬಾನು", "ಅಂಬರ")),
        SynonymItem("ಮರ", listOf("ವೃಕ್ಷ", "ತರು", "ಧರಜ", "ಪಾದಪ")),
        SynonymItem("ಕಾಡು", listOf("ಅರಣ್ಯ", "ವನ", "ಕಾನನ", "ಅಟವಿ"))
    )

    // Antonyms (ವಿರುದ್ಧಾರ್ಥಕ ಪದಗಳು)
    val antonyms = listOf(
        AntonymItem("ಬೆಳಕು", "ಕತ್ತಲೆ"),
        AntonymItem("ಎತ್ತರ", "ಗಿಡ್ಡ"),
        AntonymItem("ಒಳ್ಳೆಯ", "ಕೆಟ್ಟ"),
        AntonymItem("ಸತ್ಯ", "ಅಸತ್ಯ"),
        AntonymItem("ಜಯ", "ಅಪಜಯ"),
        AntonymItem("ಆರಂಭ", "ಅಂತ್ಯ"),
        AntonymItem("ಸುಖ", "ದುಃಖ"),
        AntonymItem("ಧರ್ಮ", "ಅಧರ್ಮ")
    )

    // Interactive Stories (ಕಥೆ ಪೂರ್ಣಗೊಳಿಸುವಿಕೆ)
    val stories = listOf(
        StoryLesson(
            id = "story_lion_mouse",
            title = "🦁 ಸಿಂಹ ಮತ್ತು ಇಲಿ",
            introParagraph = "ಒಂದಾನೊಂದು ಕಾಲದಲ್ಲಿ ದಟ್ಟವಾದ ಅರಣ್ಯದಲ್ಲಿ ಒಂದು ಬಲಶಾಲಿಯಾದ ಸಿಂಹವಿತ್ತು. ಒಂದು ದಿನ ಸಿಂಹ ಮಲಗಿದ್ದಾಗ ಸಣ್ಣ ಇಲಿಯೊಂದು ಅದರ ಮೈಮೇಲೆ ಆಟವಾಡತೊಡಗಿತು. ಸಿಂಹ ಎಚ್ಚರಗೊಂಡು ಇಲಿಯನ್ನು ಕೋಪದಿಂದ ಹಿಡಿಯಿತು. ಇಲಿ, 'ದಯವಿಟ್ಟು ನನ್ನನ್ನು ಕ್ಷಮಿಸಿ, ಎಂದಾದರೂ ನಿಮಗೂ ನನ್ನಿಂದ ನೆರವಾಗಬಹುದು' ಎಂದು ವಿನಂತಿಸಿತು.",
            choices = listOf(
                StoryChoice("ಸಿಂಹ ನಕ್ಕು ಇಲಿಯನ್ನು ದಯೆಯಿಂದ ಬಿಟ್ಟುಕೊಟ್ಟಿತು.", "ಕೆಲವು ದಿನಗಳ ನಂತರ ಬೇಟೆಗಾರನ ಬಲೆಯಲ್ಲಿ ಸಿಂಹ ಸಿಲುಕಿಕೊಂಡಿತು. ಸಿಂಹ ಗರ್ಜಿಸುವುದನ್ನು ಕೇಳಿ ಬಂದ ಇಲಿ ಬಲೆಯನ್ನು ಕಡಿದು ಸಿಂಹವನ್ನು ರಕ್ಷಿಸಿತು!", true),
                StoryChoice("ಸಿಂಹ ಇಲಿಯನ್ನು ದೂಷಿಸಿ ಓಡಿಸಿತು.", "ಸಿಂಹವು ಯಾರಿಗೂ ದಯೆ ತೋರಲಿಲ್ಲ. ತೊಂದರೆ ಬಂದಾಗ ಅದಕ್ಕೆ ಯಾರ ನೆರವೂ ಸಿಗಲಿಲ್ಲ.", false)
            ),
            moral = "ಉಪಕಾರಕ್ಕೆ ಪ್ರತ್ಯುಪಕಾರ ಮತ್ತು ದಯೆ ಸದಾ ಯಶಸ್ಸು ತರುತ್ತದೆ."
        )
    )

    // Quizzes for Games
    val quizQuestions = listOf(
        QuizQuestion("q1", "'ಅಮ್ಮ' ಪದದಲ್ಲಿ ಬರುವ ಒತ್ತಕ್ಷರ ಯಾವುದು?", listOf("ಕ್ಕ", "ಮ್ಮ", "ಜ್ಜ", "ಪ್ಪ"), 1, "'ಅಮ್ಮ' ಪದದಲ್ಲಿ ಮ್ + ಮ = 'ಮ್ಮ' ಸಜಾತಿ ಒತ್ತಕ್ಷರ ಇದೆ."),
        QuizQuestion("q2", "ಕನ್ನಡದ ಪ್ರಥಮ ಸ್ವರ ಅಕ್ಷರ ಯಾವುದು?", listOf("ಆ", "ಇ", "ಅ", "ಈ"), 2, "ಕನ್ನಡ ವರ್ಣಮಾಲೆಯ ಮೊದಲ ಸ್ವರ 'ಅ'."),
        QuizQuestion("q3", "'ಸೂರ್ಯ' ಪದಕ್ಕೆ ಸಮಾನಾರ್ಥಕ ಪದ ಯಾವುದು?", listOf("ಚಂದ್ರ", "ರವಿ", "ನಕ್ಷತ್ರ", "ಆಕಾಶ"), 1, "ಸೂರ್ಯನಿಗೆ ರವಿ, ಭಾನು, ಅರ್ಕ ಎಂಬ ಸಮಾನಾರ್ಥಕ ಹೆಸರುಗಳಿವೆ."),
        QuizQuestion("q4", "'ಬೆಳಕು' ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?", listOf("ಕತ್ತಲೆ", "ಹಗಲು", "ದೀಪ", "ಬಿಸಿಲು"), 0, "ಬೆಳಕು ಪದದ ವಿರುದ್ಧ ಪದ 'ಕತ್ತಲೆ'."),
        QuizQuestion("q5", "'ಕಾಯಕವೇ...' ಗಾದೆ ಮಾತನ್ನು ಪೂರ್ಣಗೊಳಿಸಿ:", listOf("ಧರ್ಮ", "ಕೈಲಾಸ", "ದೇವಸ್ಥಾನ", "ಬಂಗಾರ"), 1, "ಪ್ರಸಿದ್ಧ ವಚನಕಾರರ ಗಾದೆ: 'ಕಾಯಕವೇ ಕೈಲಾಸ'.")
    )

    // Image Word Multiple Choice Quiz Questions
    val imageQuizQuestions = listOf(
        ImageQuizQuestion(
            id = "iq1",
            imageEmoji = "🐘",
            englishMeaning = "Elephant",
            options = listOf("ಮರ", "ಆನೆ", "ನವಿಲು", "ಮನೆ"),
            correctIndex = 1,
            explanation = "🐘 ಎಂದರೆ 'ಆನೆ' (Elephant)."
        ),
        ImageQuizQuestion(
            id = "iq2",
            imageEmoji = "🪷",
            englishMeaning = "Lotus",
            options = listOf("ಕಮಲ", "ಸೂರ್ಯ", "ಹೂವು", "ದೀಪ"),
            correctIndex = 0,
            explanation = "🪷 ಎಂದರೆ 'ಕಮಲ' (Lotus)."
        ),
        ImageQuizQuestion(
            id = "iq3",
            imageEmoji = "🦚",
            englishMeaning = "Peacock",
            options = listOf("ಗಿಡ", "ಬಸ್", "ನವಿಲು", "ಇಲಿ"),
            correctIndex = 2,
            explanation = "🦚 ಎಂದರೆ 'ನವಿಲು' (Peacock)."
        ),
        ImageQuizQuestion(
            id = "iq4",
            imageEmoji = "🏠",
            englishMeaning = "House",
            options = listOf("ಕಮಲ", "ಮನೆ", "ರಥ", "ಆನೆ"),
            correctIndex = 1,
            explanation = "🏠 ಎಂದರೆ 'ಮನೆ' (House)."
        ),
        ImageQuizQuestion(
            id = "iq5",
            imageEmoji = "🌳",
            englishMeaning = "Tree",
            options = listOf("ಮರ", "ಮನೆ", "ಸರ", "ಫಲ"),
            correctIndex = 0,
            explanation = "🌳 ಎಂದರೆ 'ಮರ' (Tree)."
        ),
        ImageQuizQuestion(
            id = "iq6",
            imageEmoji = "☀️",
            englishMeaning = "Sun",
            options = listOf("ಚಂದ್ರ", "ಸೂರ್ಯ", "ದೀಪ", "ನಕ್ಷತ್ರ"),
            correctIndex = 1,
            explanation = "☀️ ಎಂದರೆ 'ಸೂರ್ಯ' (Sun)."
        ),
        ImageQuizQuestion(
            id = "iq7",
            imageEmoji = "🪔",
            englishMeaning = "Lamp",
            options = listOf("ದೀಪ", "ಹೂವು", "ಛತ್ರಿ", "ಚಮಚ"),
            correctIndex = 0,
            explanation = "🪔 ಎಂದರೆ 'ದೀಪ' (Lamp)."
        ),
        ImageQuizQuestion(
            id = "iq8",
            imageEmoji = "🚌",
            englishMeaning = "Bus",
            options = listOf("ರಥ", "ಬಸ್", "ಪಟ", "ಸರ"),
            correctIndex = 1,
            explanation = "🚌 ಎಂದರೆ 'ಬಸ್' (Bus)."
        ),
        ImageQuizQuestion(
            id = "iq9",
            imageEmoji = "☂️",
            englishMeaning = "Umbrella",
            options = listOf("ಛತ್ರಿ", "ಪಟ", "ಕಮಲ", "ಗಿಡ"),
            correctIndex = 0,
            explanation = "☂️ ಎಂದರೆ 'ಛತ್ರಿ' (Umbrella)."
        ),
        ImageQuizQuestion(
            id = "iq10",
            imageEmoji = "🪁",
            englishMeaning = "Kite",
            options = listOf("ಬಸ್", "ಪಟ", "ಚಮಚ", "ಮರ"),
            correctIndex = 1,
            explanation = "🪁 ಎಂದರೆ 'ಪಟ' (Kite)."
        )
    )

    // Achievements Badges
    val defaultBadges = listOf(
        BadgeInfo("b1", "ಪ್ರಥಮ ಹೆಜ್ಜೆ", "ಮೊದಲ ಪಾಠವನ್ನು ವೀಕ್ಷಿಸಿದ್ದೀರಿ", "🌱", 5),
        BadgeInfo("b2", "ಸ್ವರ ಸಾಮ್ರಾಟ", "ಸ್ವರಗಳ ವಿಭಾಗ ಪೂರ್ಣಗೊಳಿಸಿದ್ದೀರಿ", "🌟", 15),
        BadgeInfo("b3", "ವ್ಯಂಜನ ಚತುರ", "ವ್ಯಂಜನಗಳ ಪರೀಕ್ಷೆಯಲ್ಲಿ ಉತ್ತೀರ್ಣರಾಗಿದ್ದೀರಿ", "🎯", 30),
        BadgeInfo("b4", "ಪದ ನಿರ್ಮಾತೃ", "೧೦ Jumbled Words ಆಟ ಗೆದ್ದಿದ್ದೀರಿ", "🧩", 50),
        BadgeInfo("b5", "ರಸಪ್ರಶ್ನೆ ವೀರ", "ಸ್ಪೀಡ್ ರಸಪ್ರಶ್ನೆ ಪೂರ್ಣಗೊಳಿಸಿದ್ದೀರಿ", "⚡", 75),
        BadgeInfo("b6", "೭ ದಿನದ ಕಲಿಕಾ ಸರಣಿ", "ಸತತ ಕಲಿಕೆಯಲ್ಲಿ ನಿರತರಾಗಿದ್ದೀರಿ", "🔥", 100)
    )

    // ಕನ್ನಡ ವ್ಯಾಕರಣ ವಿವರಣೆಗಳು (Kannada Grammar Concepts)
    val kannadaGrammarConcepts = listOf(
        GrammarConcept(
            topicId = "gram_namapada",
            ruleTitle = "🏷️ ನಾಮಪದ (Nouns)",
            ruleDefinitionKannada = "ವಸ್ತು, ವ್ಯಕ್ತಿ, ಸ್ಥಳ, ಪ್ರಾಣಿ ಅಥವಾ ಭಾವನೆಗಳ ಹೆಸರನ್ನು ಸೂಚಿಸುವ ಪದಗಳಿಗೆ 'ನಾಮಪದ' ಎನ್ನುತ್ತಾರೆ. ಇವುಗಳನ್ನು ಮುಖ್ಯವಾಗಿ ೩ ಭಾಗಗಳಾಗಿ ವಿಂಗಡಿಸಬಹುದು:",
            ruleFormula = "ನಾಮಪದ = ವಸ್ತುವಿನ ಹೆಸರು (ಅಂಕಿತ, ರೂಢ, ಅನ್ವರ್ಥ)",
            examples = listOf(
                GrammarExample("ಅಂಕಿತನಾಮ (Proper Noun)", "ಬೆಂಗಳೂರು, ರಮೇಶ, ಕಾವೇರಿ", "ನಿರ್ದಿಷ್ಟ ಹೆಸರು", "ವಿಶೇಷವಾಗಿ ಇಟ್ಟ ಹೆಸರು (ಬೆಂಗಳೂರು, ಭಾರತ)."),
                GrammarExample("ರೂಢನಾಮ (Common Noun)", "ಮರ, ನದಿ, ಹುಡುಗ, ದೇಶ", "ಸಾಮಾನ್ಯ ಹೆಸರು", "ರೂಢಿಯಿಂದ ಬಂದ ಹೆಸರುಗಳು (ಮನೆ, ನದಿ)."),
                GrammarExample("ಅನ್ವರ್ಥನಾಮ (Attributive Noun)", "ವೈದ್ಯ, ಶಿಕ್ಷಕ, ಕುಂಟ, ವ್ಯಾಪಾರಿ", "ಗುಣ/ವೃತ್ತಿ ಹೆಸರು", "ಗುಣ ಅಥವಾ ಕಾಯಕಕ್ಕೆ ತಕ್ಕಂತೆ ಬರುವ ಹೆಸರು.")
            )
        ),
        GrammarConcept(
            topicId = "gram_sarvanama",
            ruleTitle = "👤 ಸರ್ವನಾಮ (Pronouns)",
            ruleDefinitionKannada = "ನಾಮಪದದ ಬದಲಾಗಿ ಬಳಸುವ ಪದಗಳಿಗೆ 'ಸರ್ವನಾಮ' ಎನ್ನಲಾಗುತ್ತದೆ. ಇದರಿಂದ ವಾಕ್ಯದಲ್ಲಿ ಪುನರಾವೃತ್ತಿ ತಪ್ಪುತ್ತದೆ.",
            ruleFormula = "ಸರ್ವನಾಮ = ನಾಮಪದದ ಬದಲಾಗಿ ಬರುವ ಪದ (ನಾನು, ನೀನು, ಅವನು...)",
            examples = listOf(
                GrammarExample("ಉತ್ತಮ ಪುರುಷ (First Person)", "ನಾನು, ನಾವು", "I, We", "ಮಾತನಾಡುವ ವ್ಯಕ್ತಿಯನ್ನು ಸೂಚಿಸುತ್ತದೆ."),
                GrammarExample("ಮಧ್ಯಮ ಪುರುಷ (Second Person)", "ನೀನು, ನೀವು", "You", "ಎದುರಿಗಿರುವ ವ್ಯಕ್ತಿಯನ್ನು ಸೂಚಿಸುತ್ತದೆ."),
                GrammarExample("ಪ್ರಥಮ ಪುರುಷ (Third Person)", "ಅವನು, ಅವಳು, ಅದು, ಅವರು", "He, She, It, They", "ಬೇರೊಬ್ಬ ವ್ಯಕ್ತಿ ಅಥವಾ ವಸ್ತುವನ್ನು ಸೂಚಿಸುತ್ತದೆ.")
            )
        ),
        GrammarConcept(
            topicId = "gram_kriyapada",
            ruleTitle = "⏳ ಕ್ರಿಯಾಪದ & ಕಾಲಗಳು (Verbs & Tenses)",
            ruleDefinitionKannada = "ವಾಕ್ಯದ ಅರ್ಥವನ್ನು ಪೂರ್ಣಗೊಳಿಸುವ ಮತ್ತು ಕೆಲಸ ನಡೆಯುವುದನ್ನು ಸೂಚಿಸುವ ಪದವೇ 'ಕ್ರಿಯಾಪದ'. ಇದು ೩ ಕಾಲಗಳನ್ನು ಹೊಂದಿದೆ:",
            ruleFormula = "ಧಾತು + ಕಾಲಸೂಚಕ ಪ್ರತ್ಯಯ + ಆಖ್ಯಾತ ಪ್ರತ್ಯಯ = ಕ್ರಿಯಾಪದ",
            examples = listOf(
                GrammarExample("ಭೂತಕಾಲ (Past Tense)", "ಮಾಡಿದನು, ಹೋದಳು, ತಿಂದರು", "Did / Ate / Went", "ಕೆಲಸ ಈಗಾಗಲೇ ಮುಗಿದಿರುವುದನ್ನು ಸೂಚಿಸುತ್ತದೆ."),
                GrammarExample("ವರ್ತಮಾನಕಾಲ (Present Tense)", "ಮಾಡುತ್ತಿದ್ದಾನೆ, ತಿನ್ನುತ್ತಿದ್ದಾಳೆ", "Is doing / Eating", "ಕೆಲಸ ಈಗ ನಡೆಯುತ್ತಿರುವುದನ್ನು ಸೂಚಿಸುತ್ತದೆ."),
                GrammarExample("ಭವಿಷ್ಯತ್ಕಾಲ (Future Tense)", "ಮಾಡುವನು, ಹೋಗುವಳು, ಬರುವರು", "Will do / Will go", "ಕೆಲಸ ಮುಂದೆ ನಡೆಯುವುದನ್ನು ಸೂಚಿಸುತ್ತದೆ.")
            )
        ),
        GrammarConcept(
            topicId = "gram_linga_vachana",
            ruleTitle = "👫 ಲಿಂಗ ಮತ್ತು ವಚನ (Gender & Number)",
            ruleDefinitionKannada = "ನಾಮಪದಗಳು ಗಂಡು, ಹೆಣ್ಣು ಅಥವಾ ನಿರ್ಜೀವ ವಸ್ತುವೇ ಎಂಬುದನ್ನು 'ಲಿಂಗ' ಮತ್ತು ಪ್ರಮಾಣವನ್ನು 'ವಚನ' ಸೂಚಿಸುತ್ತದೆ.",
            ruleFormula = "ಪುಲ್ಲಿಂಗ / ಸ್ತ್ರೀಲಿಂಗ / ನಪುಂಸಕಲಿಂಗ | ಏಕವಚನ / ಬಹುವಚನ",
            examples = listOf(
                GrammarExample("ಪುಲ್ಲಿಂಗ (Masculine)", "ಹುಡುಗ, ಅಣ್ಣ, ರಾಜ, ತಂದೆ", "Boy, Brother, King", "ಗಂಡು ಜಾತಿಯನ್ನು ಸೂಚಿಸುವ ಪದಗಳು."),
                GrammarExample("ಸ್ತ್ರೀಲಿಂಗ (Feminine)", "ಹುಡುಗಿ, ಅಕ್ಕ, ರಾಣಿ, ತಾಯಿ", "Girl, Sister, Queen", "ಹೆಣ್ಣು ಜಾತಿಯನ್ನು ಸೂಚಿಸುವ ಪದಗಳು."),
                GrammarExample("ನಪುಂಸಕಲಿಂಗ (Neuter)", "ಮರ, ಮನೆ, ಹೂವು, ಕಲ್ಲು", "Tree, House, Flower", "ನಿರ್ಜೀವ ಹಾಗೂ ಇತರ ಜೀವಿಗಳು."),
                GrammarExample("ಏಕವಚನ -> ಬಹುವಚನ", "ಮರ -> ಮರಗಳು, ಮಗು -> ಮಕ್ಕಳು", "Single to Plural", "ಒಂದು ವಸ್ತು ಹಾಗೂ ಒಂದಕ್ಕಿಂತ ಹೆಚ್ಚು ವಸ್ತುಗಳು.")
            )
        ),
        GrammarConcept(
            topicId = "gram_vibhakti",
            ruleTitle = "📜 ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯಗಳು (7 Cases & Endings)",
            ruleDefinitionKannada = "ನಾಮಪದ ಮತ್ತು ಕ್ರಿಯಾಪದದ ನಡುವೆ ಸಂಬಂಧವನ್ನು ಕಲ್ಪಿಸಲು ಸೇರುವ ಪ್ರತ್ಯಯಗಳೇ 'ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯಗಳು' (೭ ವಿಭಕ್ತಿಗಳು):",
            ruleFormula = "ನಾಮಪ್ರಕೃತಿ + ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯ = ನಾಮಪದ ರೂಪ",
            examples = listOf(
                GrammarExample("೧. ಪ್ರಥಮಾ (ಉ)", "ರಾಮನು, ಮರವು", "Nominative Case", "ಕರ್ತೃ ಸ್ಥಾನ (ಉದಾ: ರಾಮನು ಬಂದನು)"),
                GrammarExample("೨. ದ್ವಿತೀಯಾ (ಅನ್ನು)", "ಮರವನ್ನು, ಪುಸ್ತಕವನ್ನು", "Accusative Case", "ಕರ್ಮ ಸ್ಥಾನ (ಉದಾ: ಮರವನ್ನು ಕಡಿದನು)"),
                GrammarExample("೩. ತೃತೀಯಾ (ಇಂದ)", "ಕೈಯಿಂದ, ಮರದಿಂದ", "Instrumental Case", "ಸಾಧನ (ಉದಾ: ಪೆನ್ನಿನಿಂದ ಬರೆದನು)"),
                GrammarExample("೪. ಚತುರ್ಥೀ (ಗೆ/ಗೆ/ಕೆ)", "ಮನೆಗೆ, ಶಾಲೆಗೆ, ಮಗುವಿಗೆ", "Dative Case", "ಉದ್ದೇಶ/ಸ್ಥಳ (ಉದಾ: ಶಾಲೆಗೆ ಹೋದನು)"),
                GrammarExample("೫. ಪಂಚಮೀ (ದೆಸೆಯಿಂದ)", "ಬಟ್ಟೆಯ ದೆಸೆಯಿಂದ, ಊರಿನ ದೆಸೆಯಿಂದ", "Ablative Case", "ಕಾರಣ/ಮೂಲ"),
                GrammarExample("೬. ಷಷ್ಠೀ (ಅ)", "ನನ್ನ, ರಾಮನ, ಶಾಲೆಯ", "Genitive Case", "ಸಂಬಂಧ (ಉದಾ: ರಾಮನ ಪುಸ್ತಕ)"),
                GrammarExample("೭. ಸಪ್ತಮೀ (ಅಲ್ಲಿ)", "ಮನೆಯಲ್ಲಿ, ಕಾಡಿನಲ್ಲಿ", "Locative Case", "ಸ್ಥಳ/ಆಧಾರ (ಉದಾ: ಮನೆಯಲ್ಲಿದ್ದಾನೆ)")
            )
        ),
        GrammarConcept(
            topicId = "gram_samasagalu",
            ruleTitle = "🧩 ಸಮಾಸಗಳು (Compound Words)",
            ruleDefinitionKannada = "ಎರಡು ಅಥವಾ ಎರಡಕ್ಕಿಂತ ಹೆಚ್ಚು ಪದಗಳು ಸೇರಿ, ನಡುವಿನ ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯ ಲೋಪವಾಗಿ ಒಂದು ಹೊಸ ಪದವಾಗುವುದೇ 'ಸಮಾಸ'.",
            ruleFormula = "ಪೂರ್ವಪದ + ಉತ್ತರಪದ = ಸಮಸ್ತಪದ",
            examples = listOf(
                GrammarExample("ತತ್ಪುರುಷ ಸಮಾಸ", "ಮರದ + ಕಟ್ಟು = ಮರಕಟ್ಟು, ದೇವರ + ಮನೆ = ದೇವಸ್ಥಾನ", "ಉತ್ತರಪದ ಪ್ರಧಾನ", "ಉತ್ತರಪದದ ಅರ್ಥ ಪ್ರಧಾನವಾಗಿರುತ್ತದೆ."),
                GrammarExample("ಕರ್ಮಧಾರಯ ಸಮಾಸ", "ಹಿರಿದಾದ + ಮರ = ಹೆಮ್ಮರ, ಬಿಳಿದಾದ + ಕಮಲ = ಬಿಳಿಕಮಲ", "ವಿಶೇಷಣ-ವಿಶೇಷ್ಯ", "ವಿಶೇಷಣ ಮತ್ತು ವಿಶೇಷ್ಯಗಳಿಂದ ಕೂಡಿರುತ್ತದೆ."),
                GrammarExample("ದ್ವಂದ್ವ ಸಮಾಸ", "ಗಿಡವೂ + ಮರವೂ = ಗಿಡಮರಗಳು, ತಾಯಿಯೂ + ತಂದೆಯೂ = ತಾಯಿ ತಂದೆಯರು", "ಎರಡೂ ಪದ ಪ್ರಧಾನ", "ಎಲ್ಲ ಪದಗಳ ಅರ್ಥವೂ ಸಮಾನವಾಗಿರುತ್ತದೆ."),
                GrammarExample("ದ್ವಿಗು ಸಮಾಸ", "ಮೂರು + ಕಣ್ಣು = ಮುಕ್ಕಣ್ಣ, ನಾಲ್ಕು + ಮಡಿ = ನಾಲ್ಮಡಿ", "ಸಂಖ್ಯಾ ವಾಚಕ", "ಪೂರ್ವಪದವು ಸಂಖ್ಯಾವಾಚಕವಾಗಿರುತ್ತದೆ."),
                GrammarExample("ಬಹುವ್ರಹಿ ಸಮಾಸ", "ಮುಕ್ಕಣ್ಣು ಉಳ್ಳವನು ಯಾರೋ ಅವನು = ಶಿವ", "ಅನ್ಯಪದ ಪ್ರಧಾನ", "ಬೇರೊಂದು ಮೂರನೇ ಪದದ ಅರ್ಥ ಪ್ರಧಾನವಾಗಿರುತ್ತದೆ.")
            )
        ),
        GrammarConcept(
            topicId = "gram_sandhigalu",
            ruleTitle = "🔗 ಸಂಧಿಗಳು (Sandhi Rules)",
            ruleDefinitionKannada = "ಎರಡು ಅಕ್ಷರಗಳು ಕಾಲವಿಳಂಬವಿಲ್ಲದೆ ಒಂದಕ್ಕೊಂದು ಸೇರುವುದಕ್ಕೆ 'ಸಂಧಿ' ಎನ್ನಲಾಗುತ್ತದೆ. ಕನ್ನಡದಲ್ಲಿ ೩ ಮುಖ್ಯ ಸಂಧಿಗಳಿವೆ:",
            ruleFormula = "ಪೂರ್ವಪದಾಂತ್ಯ ಅಕ್ಷರ + ಉತ್ತರಪದಾದಿ ಅಕ್ಷರ = ಸಂಧಿ ಪದ",
            examples = listOf(
                GrammarExample("ಲೋಪ ಸಂಧಿ (Elision)", "ಮಾತು + ಇಲ್ಲ = ಮಾತಿಲ್ಲ, ಊರು + ಅಲ್ಲಿ = ಊರಲ್ಲಿ", "ಸ್ವರ ಲೋಪ", "ಪೂರ್ವಪದದ ಕೊನೆಯ ಸ್ವರ ಬಿಟ್ಟುಹೋಗುತ್ತದೆ (ಉ + ಇ = ಇ)."),
                GrammarExample("ಆಗಮ ಸಂಧಿ (Insertion)", "ಮಳೆ + ಅಲ್ಲಿ = ಮಳೆಯಲ್ಲಿ (ಯ-ಕಾರ), ಗುರು + ಅನ್ನು = ಗುರುವನ್ನು (ವ-ಕಾರ)", "ಹೊಸ ಅಕ್ಷರ ಆಗಮ", "ಯ ಅಥವಾ ವ ಕಾರ ಹೊಸದಾಗಿ ಸೇರುತ್ತದೆ."),
                GrammarExample("ಆದೇಶ ಸಂಧಿ (Substitution)", "ಹಳೆ + ಕನ್ನಡ = ಹಳೆಗನ್ನಡ (ಕ-ಗ), ಮೈ + ತೊಳೆ = ಮೈದೊಳೆ (ತ-ದ)", "ಉತ್ತರಪದ ವ್ಯಂಜನ ಬದಲಾವಣೆ", "ಕ, ತ, ಪ ಗಳಿಗೆ ಗ, ದ, ಬ ಗಳು ಆದೇಶವಾಗಿ ಬರುತ್ತವೆ.")
            )
        )
    )

    // Bilingual English Phrases (ದ್ವಿಭಾಷಾ ಇಂಗ್ಲಿಷ್ ಸಂಭಾಷಣೆ)
    val bilingualPhrases = listOf(
        BilingualPhrase("Good morning!", "ಶುಭೋದಯ!", "ಗುಡ್ ಮಾರ್ನಿಂಗ್!", "Greetings"),
        BilingualPhrase("How are you?", "ನೀವು ಹೇಗಿದ್ದೀರಿ?", "ಹೌ ಆರ್ ಯೂ?", "Greetings"),
        BilingualPhrase("I am fine, thank you.", "ನಾನು ಚೆನ್ನಾಗಿದ್ದೇನೆ, ಧನ್ಯವಾದಗಳು.", "ಐ ಆಮ್ ಫೈನ್, ಥ್ಯಾಂಕ್ ಯೂ.", "Greetings"),
        BilingualPhrase("What is your name?", "ನಿಮ್ಮ ಹೆಸರೇನು?", "ವಾಟ್ ಈಸ್ ಯುವರ್ ನೇಮ್?", "Questions"),
        BilingualPhrase("My name is Raju.", "ನನ್ನ ಹೆಸರು ರಾಜು.", "ಮೈ ನೇಮ್ ಈಸ್ ರಾಜು.", "General"),
        BilingualPhrase("Where is your school?", "ನಿಮ್ಮ ಶಾಲೆ ಎಲ್ಲಿದೆ?", "ವೇರ್ ಈಸ್ ಯುವರ್ ಸ್ಕೂಲ್?", "School"),
        BilingualPhrase("I am going to school.", "ನಾನು ಶಾಲೆಗೆ ಹೋಗುತ್ತಿದ್ದೇನೆ.", "ಐ ಆಮ್ ಗೋಯಿಂಗ್ ಟು ಸ್ಕೂಲ್.", "School"),
        BilingualPhrase("Please open your book.", "ದಯವಿಟ್ಟು ನಿಮ್ಮ ಪುಸ್ತಕ ತೆರೆಯಿರಿ.", "ಪ್ಲೀಸ್ ಓಪನ್ ಯುವರ್ ಬುಕ್.", "Classroom"),
        BilingualPhrase("Can I help you?", "ನಾನು ನಿಮಗೆ ಸಹಾಯ ಮಾಡಲೇ?", "ಕ್ಯಾನ್ ಐ ಹೆಲ್ಪ್ ಯೂ?", "Help"),
        BilingualPhrase("Have a nice day!", "ನಿಮ್ಮ ದಿನ ಶುಭವಾಗಿರಲಿ!", "ಹ್ಯಾವ್ ಎ ನೈಸ್ ಡೇ!", "Greetings")
    )

    // English Parts of Speech (ದ್ವಿಭಾಷಾ ವಿವರಣೆ)
    val englishPartsOfSpeech = listOf(
        PartsOfSpeechItem(
            englishTerm = "Noun",
            kannadaTerm = "ನಾಮಪದ",
            definitionKannada = "ವ್ಯಕ್ತಿ, ಸ್ಥಳ, ವಸ್ತು ಅಥವಾ ಆಲೋಚನೆಯ ಹೆಸರು (Name of person, place, thing).",
            exampleEnglish = "Ramesh, Bengaluru, Book, Apple",
            exampleKannada = "ರಮೇಶ, ಬೆಂಗಳೂರು, ಪುಸ್ತಕ, ಸೇಬು"
        ),
        PartsOfSpeechItem(
            englishTerm = "Pronoun",
            kannadaTerm = "ಸರ್ವನಾಮ",
            definitionKannada = "ನಾಮಪದದ ಬದಲಾಗಿ ಬಳಸುವ ಪದ (Replaces a Noun).",
            exampleEnglish = "I, We, You, He, She, It, They",
            exampleKannada = "ನಾನು, ನಾವು, ನೀನು, ಅವನು, ಅವಳು, ಅದು"
        ),
        PartsOfSpeechItem(
            englishTerm = "Verb",
            kannadaTerm = "ಕ್ರಿಯಾಪದ",
            definitionKannada = "ಕೆಲಸ ಅಥವಾ ಸ್ಥಿತಿಯನ್ನು ಸೂಚಿಸುವ ಪದ (Action or state of being).",
            exampleEnglish = "Run, Eat, Read, Write, Speak",
            exampleKannada = "ಓಡು, ತಿನ್ನು, ಓದು, ಬರೆ, ಮಾತನಾಡು"
        ),
        PartsOfSpeechItem(
            englishTerm = "Adjective",
            kannadaTerm = "ಗುಣವಾಚಕ",
            definitionKannada = "ನಾಮಪದದ ಗುಣ ಅಥವಾ ವೈಶಿಷ್ಟ್ಯವನ್ನು ವಿವರಿಸುವ ಪದ (Describes a Noun).",
            exampleEnglish = "Beautiful, Big, Sweet, Tall, Good",
            exampleKannada = "ಸುಂದರ, ದೊಡ್ಡ, ಸಿಹಿ, ಎತ್ತರ, ಒಳ್ಳೆಯ"
        ),
        PartsOfSpeechItem(
            englishTerm = "Adverb",
            kannadaTerm = "ಕ್ರಿಯಾ ವಿಶೇಷಣ",
            definitionKannada = "ಕ್ರಿಯಾಪದವು ಹೇಗೆ ನಡೆಯಿತು ಎಂಬುದನ್ನು ವಿವರಿಸುವ ಪದ (Modifies a Verb).",
            exampleEnglish = "Quickly, Slowly, Loudly, Yesterday",
            exampleKannada = "ವೇಗವಾಗಿ, ಮೆಲ್ಲಗೆ, ಗಟ್ಟಿಯಾಗಿ, ನಿನ್ನೆ"
        ),
        PartsOfSpeechItem(
            englishTerm = "Preposition",
            kannadaTerm = "ಸಂಬಂಧಸೂಚಕ ಪದ",
            definitionKannada = "ಸ್ಥಳ, ಸಮಯ ಅಥವಾ ದಿಕ್ಕನ್ನು ಸೂಚಿಸುವ ಪದ (Shows relationship).",
            exampleEnglish = "In, On, At, Under, To, From",
            exampleKannada = "ಒಳಗೆ, ಮೇಲೆ, ಕೆಳಗೆ, ಗೆ, ಇಂದ"
        )
    )

    // English Tenses Rules with Kannada Translations
    val englishTenseItems = listOf(
        EnglishTenseItem(
            tenseName = "Simple Present Tense",
            kannadaName = "ಸಾಮಾನ್ಯ ವರ್ತಮಾನಕಾಲ",
            englishStructure = "Subject + Verb(s/es) + Object",
            exampleEnglish = "I eat an apple. / He reads a book.",
            exampleKannada = "ನಾನು ಸೇಬು ತಿನ್ನುತ್ತೇನೆ. / ಅವನು ಪುಸ್ತಕ ಓದುತ್ತಾನೆ.",
            usageNote = "ದೈನಂದಿನ ರೂಢಿ ಮತ್ತು ನಿತ್ಯ ಸತ್ಯಗಳಿಗೆ ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        EnglishTenseItem(
            tenseName = "Present Continuous Tense",
            kannadaName = "ಅಪೂರ್ಣ ವರ್ತಮಾನಕಾಲ",
            englishStructure = "Subject + is/am/are + Verb(-ing) + Object",
            exampleEnglish = "I am writing a letter. / She is singing.",
            exampleKannada = "ನಾನು ಪತ್ರ ಬರೆಯುತ್ತಿದ್ದೇನೆ. / ಅವಳು ಹಾಡುತ್ತಿದ್ದಾಳೆ.",
            usageNote = "ಈಗ ಪ್ರಸ್ತುತ ನಡೆಯುತ್ತಿರುವ ಕೆಲಸಕ್ಕೆ ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        EnglishTenseItem(
            tenseName = "Simple Past Tense",
            kannadaName = "ಸಾಮಾನ್ಯ ಭೂತಕಾಲ",
            englishStructure = "Subject + Past Verb (V2) + Object",
            exampleEnglish = "I went to Bengaluru yesterday.",
            exampleKannada = "ನಾನು ನಿನ್ನೆ ಬೆಂಗಳೂರಿಗೆ ಹೋದೆನು.",
            usageNote = "ಈಗಾಗಲೇ ಮುಗಿದ ಕೆಲಸವನ್ನು ಸೂಚಿಸಲು ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        EnglishTenseItem(
            tenseName = "Past Continuous Tense",
            kannadaName = "ಅಪೂರ್ಣ ಭೂತಕಾಲ",
            englishStructure = "Subject + was/were + Verb(-ing) + Object",
            exampleEnglish = "He was playing cricket.",
            exampleKannada = "ಅವನು ಕ್ರಿಕೆಟ್ ಆಡುತ್ತಿದ್ದನು.",
            usageNote = "ಗತಕಾಲದಲ್ಲಿ ನಡೆಯುತ್ತಿದ್ದ ಕೆಲಸಕ್ಕೆ ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        EnglishTenseItem(
            tenseName = "Simple Future Tense",
            kannadaName = "ಸಾಮಾನ್ಯ ಭವಿಷ್ಯತ್ಕಾಲ",
            englishStructure = "Subject + will/shall + Verb(V1) + Object",
            exampleEnglish = "We will visit the park tomorrow.",
            exampleKannada = "ನಾವು ನಾಳೆ ಪಾರ್ಕಿಗೆ ಹೋಗುತ್ತೇವೆ.",
            usageNote = "ಮುಂದೆ ನಡೆಯಲಿರುವ ಕೆಲಸವನ್ನು ಸೂಚಿಸುತ್ತದೆ."
        )
    )

    // Bilingual English Quiz Questions
    val bilingualQuizQuestions = listOf(
        QuizQuestion("bq1", "'ಬೆಂಗಾಳೂರು ದೊಡ್ಡ ನಗರ' - Choose the correct English Noun:", listOf("Bengaluru", "Big", "City", "Is"), 0, "Bengaluru (ಬೆಂಗಳೂರು) ನಿರ್ದಿಷ್ಟ ಸ್ಥಳದ ಹೆಸರು - Proper Noun."),
        QuizQuestion("bq2", "What is the English translation of 'ನಾನು ಪ್ರತಿದಿನ ಓದುತ್ತೇನೆ'?", listOf("I read every day.", "I am reading tomorrow.", "I went yesterday.", "I will read."), 0, "Simple Present Tense: I read every day."),
        QuizQuestion("bq3", "'She is singing nicely' - In this sentence, 'singing' is a:", listOf("Noun", "Verb (ಕ್ರಿಯಾಪದ)", "Adjective", "Preposition"), 1, "Singing ಎಂದರೆ ಹಾಡುತ್ತಿರುವುದು - Action (Verb)."),
        QuizQuestion("bq4", "'ಉಪ್ಪಿಗಿಂತ ರುಚಿಯಿಲ್ಲ' - What is the English word for 'Salt'?", listOf("Sugar", "Salt", "Milk", "Water"), 1, "Salt ಎಂದರೆ 'ಉಪ್ಪು'."),
        QuizQuestion("bq5", "Choose the correct Past Tense of 'Go':", listOf("Goes", "Going", "Went", "Will go"), 2, "Go ನ Past Tense ರೂಪ 'Went' (ಹೋದನು).")
    )
}

