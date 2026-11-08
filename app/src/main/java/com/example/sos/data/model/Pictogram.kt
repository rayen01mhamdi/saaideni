package com.example.sos.data.model

enum class PictogramCategory(val id: String, val titleEn: String, val titleFr: String, val titleAr: String) {
    MEDICAL("medical", "Medical", "Médical", "طبي"),
    SAFETY("safety", "Safety", "Sécurité", "أمان"),
    COMMUNICATION("communication", "Communication", "Communication", "تواصل"),
    TRAVEL("travel", "Travel", "Voyage", "سفر"),
    PERSONAL("personal", "Personal Needs", "Besoins Personnels", "احتياجات شخصية")
}

data class Pictogram(
    val id: String,
    val category: PictogramCategory,
    val iconName: String,
    // Translations map: languageCode -> translated text phrase
    val translations: Map<String, String>
) {
    fun getText(languageCode: String): String {
        return translations[languageCode.lowercase()]
            ?: translations["en"]
            ?: translations.values.firstOrNull()
            ?: ""
    }
}
