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

    // Achievements Badges
    val defaultBadges = listOf(
        BadgeInfo("b1", "ಪ್ರಥಮ ಹೆಜ್ಜೆ", "ಮೊದಲ ಪಾಠವನ್ನು ವೀಕ್ಷಿಸಿದ್ದೀರಿ", "🌱", 5),
        BadgeInfo("b2", "ಸ್ವರ ಸಾಮ್ರಾಟ", "ಸ್ವರಗಳ ವಿಭಾಗ ಪೂರ್ಣಗೊಳಿಸಿದ್ದೀರಿ", "🌟", 15),
        BadgeInfo("b3", "ವ್ಯಂಜನ ಚತುರ", "ವ್ಯಂಜನಗಳ ಪರೀಕ್ಷೆಯಲ್ಲಿ ಉತ್ತೀರ್ಣರಾಗಿದ್ದೀರಿ", "🎯", 30),
        BadgeInfo("b4", "ಪದ ನಿರ್ಮಾತೃ", "೧೦ Jumbled Words ಆಟ ಗೆದ್ದಿದ್ದೀರಿ", "🧩", 50),
        BadgeInfo("b5", "ರಸಪ್ರಶ್ನೆ ವೀರ", "ಸ್ಪೀಡ್ ರಸಪ್ರಶ್ನೆ ಪೂರ್ಣಗೊಳಿಸಿದ್ದೀರಿ", "⚡", 75),
        BadgeInfo("b6", "೭ ದಿನದ ಕಲಿಕಾ ಸರಣಿ", "ಸತತ ಕಲಿಕೆಯಲ್ಲಿ ನಿರತರಾಗಿದ್ದೀರಿ", "🔥", 100)
    )
}
