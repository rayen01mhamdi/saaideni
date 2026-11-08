package com.example.sos.data.model

enum class FacilityType(val labelEn: String, val labelFr: String, val labelAr: String) {
    POLICE("Police Station", "Poste de Police", "مركز شرطة"),
    HOSPITAL("Hospital / Emergency Room", "Hôpital / Urgences", "مستشفى / طوارئ طبية"),
    FIRE("Fire Station", "Caserne de Pompiers", "مركز إطفاء"),
    EMBASSY("Consulate / Embassy", "Ambassade / Consulat", "سفارة / قنصلية")
}

data class EmergencyFacility(
    val id: String,
    val nameEn: String,
    val nameFr: String,
    val nameAr: String,
    val type: FacilityType,
    val countryCode: String,
    val city: String,
    val latitude: Double,
    val longitude: Double,
    val phone: String,
    val address: String
) {
    fun getName(lang: String): String {
        return when (lang.lowercase()) {
            "fr" -> nameFr
            "ar" -> nameAr
            else -> nameEn
        }
    }
}
