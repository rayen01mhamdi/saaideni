package com.example.sos.data.model

enum class SurvivalCategory(val id: String, val titleEn: String, val titleFr: String, val titleAr: String) {
    MEDICAL("medical", "Medical Emergencies", "Urgences Médicales", "طوارئ طبية"),
    SAFETY("safety", "Personal Safety", "Sécurité Personnelle", "السلامة الشخصية"),
    ACCIDENT("accident", "Road Accidents", "Accidents de la Route", "حوادث الطرق"),
    FIRE("fire", "Fire & Evacuation", "Incendie et Évacuation", "الحرائق والإخلاء"),
    DOCUMENTS("documents", "Lost Passport & Theft", "Passeport & Vol", "جواز السفر والسرقة"),
    DISASTER("disaster", "Natural Disasters", "Catastrophes Naturelles", "الكوارث الطبيعية"),
    TRANSPORT("transport", "Transport & Lost", "Transport & Égaré", "النقل والتوهان")
}

data class SurvivalGuideCard(
    val id: String,
    val category: SurvivalCategory,
    val iconName: String,
    val titleTranslations: Map<String, String>,
    val descriptionTranslations: Map<String, String>,
    val firstStepsTranslations: Map<String, List<String>>,
    val whatToAvoidTranslations: Map<String, List<String>>,
    val whenToCallTranslations: Map<String, String>,
    val readyMessageTranslations: Map<String, String>
) {
    fun getTitle(lang: String): String = titleTranslations[lang] ?: titleTranslations["en"] ?: ""
    fun getDescription(lang: String): String = descriptionTranslations[lang] ?: descriptionTranslations["en"] ?: ""
    fun getFirstSteps(lang: String): List<String> = firstStepsTranslations[lang] ?: firstStepsTranslations["en"] ?: emptyList()
    fun getWhatToAvoid(lang: String): List<String> = whatToAvoidTranslations[lang] ?: whatToAvoidTranslations["en"] ?: emptyList()
    fun getWhenToCall(lang: String): String = whenToCallTranslations[lang] ?: whenToCallTranslations["en"] ?: ""
    fun getReadyMessage(lang: String): String = readyMessageTranslations[lang] ?: readyMessageTranslations["en"] ?: ""
}
