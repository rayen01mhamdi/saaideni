package com.example.sos.data.model

data class UserTravelCard(
    val fullName: String = "",
    val nationality: String = "",
    val nativeLanguage: String = "en", // "en", "fr", "ar"
    val emergencyContactName: String = "",
    val emergencyContactPhone: String = "",
    val emergencyContactRelation: String = "",
    val accommodationAddress: String = "",
    val passportNumber: String = "",
    val bloodType: String = "",
    val allergies: String = "",
    val medicalNotes: String = "",
    val photoUri: String = ""
) {
    fun isEmpty(): Boolean {
        return fullName.isBlank() &&
                emergencyContactName.isBlank() &&
                emergencyContactPhone.isBlank() &&
                accommodationAddress.isBlank() &&
                photoUri.isBlank()
    }
}
