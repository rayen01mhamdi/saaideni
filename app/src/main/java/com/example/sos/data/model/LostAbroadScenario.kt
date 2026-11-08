package com.example.sos.data.model

data class ScenarioStep(
    val stepNumber: Int,
    val titleTranslations: Map<String, String>,
    val detailTranslations: Map<String, String>,
    val actionType: String? = null // e.g. "SHOW_CARD", "CALL_POLICE", "SHOW_EMBASSY_MESSAGE"
) {
    fun getTitle(lang: String): String = titleTranslations[lang] ?: titleTranslations["en"] ?: ""
    fun getDetail(lang: String): String = detailTranslations[lang] ?: detailTranslations["en"] ?: ""
}

data class LostAbroadScenario(
    val id: String,
    val iconName: String,
    val titleTranslations: Map<String, String>,
    val subtitleTranslations: Map<String, String>,
    val steps: List<ScenarioStep>,
    val readyMessageTranslations: Map<String, String>
) {
    fun getTitle(lang: String): String = titleTranslations[lang] ?: titleTranslations["en"] ?: ""
    fun getSubtitle(lang: String): String = subtitleTranslations[lang] ?: subtitleTranslations["en"] ?: ""
    fun getReadyMessage(lang: String): String = readyMessageTranslations[lang] ?: readyMessageTranslations["en"] ?: ""
}
