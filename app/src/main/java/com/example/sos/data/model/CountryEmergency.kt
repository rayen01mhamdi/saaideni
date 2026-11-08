package com.example.sos.data.model

data class CountryEmergency(
    val code: String, // ISO 2-letter country code (e.g., "US", "FR", "SA", "EG")
    val nameEn: String,
    val nameFr: String,
    val nameAr: String,
    val dialCode: String, // e.g. "+1", "+33"
    val police: String,
    val ambulance: String,
    val fire: String,
    val generalEmergency: String,
    val source: String,
    val lastVerifiedDate: String,
    val note: String? = null
) {
    fun getName(languageCode: String): String {
        return when (languageCode.lowercase()) {
            "fr" -> nameFr
            "ar" -> nameAr
            else -> nameEn
        }
    }
}
