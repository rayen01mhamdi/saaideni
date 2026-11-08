package com.example.sos.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.example.sos.data.model.UserTravelCard
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "silent_signal_prefs")

class UserPreferencesRepository(private val context: Context) {

    companion object {
        val APP_LANGUAGE = stringPreferencesKey("app_language")
        val TARGET_LANGUAGE = stringPreferencesKey("target_language")
        val SELECTED_COUNTRY_CODE = stringPreferencesKey("selected_country_code")
        val ONBOARDING_COMPLETED = booleanPreferencesKey("onboarding_completed")
        val LAST_5_PERCENT_MODE = booleanPreferencesKey("last_5_percent_mode")

        // Travel Card fields
        val CARD_FULL_NAME = stringPreferencesKey("card_full_name")
        val CARD_NATIONALITY = stringPreferencesKey("card_nationality")
        val CARD_EMERGENCY_NAME = stringPreferencesKey("card_emergency_name")
        val CARD_EMERGENCY_PHONE = stringPreferencesKey("card_emergency_phone")
        val CARD_EMERGENCY_RELATION = stringPreferencesKey("card_emergency_relation")
        val CARD_ACCOMMODATION = stringPreferencesKey("card_accommodation")
        val CARD_PASSPORT = stringPreferencesKey("card_passport")
        val CARD_BLOOD_TYPE = stringPreferencesKey("card_blood_type")
        val CARD_ALLERGIES = stringPreferencesKey("card_allergies")
        val CARD_MEDICAL_NOTES = stringPreferencesKey("card_medical_notes")
        val CARD_PHOTO_URI = stringPreferencesKey("card_photo_uri")
    }

    val appLanguageFlow: Flow<String> = context.dataStore.data.map { prefs ->
        prefs[APP_LANGUAGE] ?: "en"
    }

    val targetLanguageFlow: Flow<String> = context.dataStore.data.map { prefs ->
        prefs[TARGET_LANGUAGE] ?: "fr"
    }

    val selectedCountryCodeFlow: Flow<String> = context.dataStore.data.map { prefs ->
        prefs[SELECTED_COUNTRY_CODE] ?: "US"
    }

    val onboardingCompletedFlow: Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[ONBOARDING_COMPLETED] ?: false
    }

    val last5PercentModeFlow: Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[LAST_5_PERCENT_MODE] ?: false
    }

    val userTravelCardFlow: Flow<UserTravelCard> = context.dataStore.data.map { prefs ->
        UserTravelCard(
            fullName = prefs[CARD_FULL_NAME] ?: "",
            nationality = prefs[CARD_NATIONALITY] ?: "",
            nativeLanguage = prefs[APP_LANGUAGE] ?: "en",
            emergencyContactName = prefs[CARD_EMERGENCY_NAME] ?: "",
            emergencyContactPhone = prefs[CARD_EMERGENCY_PHONE] ?: "",
            emergencyContactRelation = prefs[CARD_EMERGENCY_RELATION] ?: "",
            accommodationAddress = prefs[CARD_ACCOMMODATION] ?: "",
            passportNumber = prefs[CARD_PASSPORT] ?: "",
            bloodType = prefs[CARD_BLOOD_TYPE] ?: "",
            allergies = prefs[CARD_ALLERGIES] ?: "",
            medicalNotes = prefs[CARD_MEDICAL_NOTES] ?: "",
            photoUri = prefs[CARD_PHOTO_URI] ?: ""
        )
    }

    suspend fun setAppLanguage(lang: String) {
        context.dataStore.edit { prefs ->
            prefs[APP_LANGUAGE] = lang
        }
    }

    suspend fun setTargetLanguage(lang: String) {
        context.dataStore.edit { prefs ->
            prefs[TARGET_LANGUAGE] = lang
        }
    }

    suspend fun setSelectedCountryCode(code: String) {
        context.dataStore.edit { prefs ->
            prefs[SELECTED_COUNTRY_CODE] = code
        }
    }

    suspend fun setOnboardingCompleted(completed: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[ONBOARDING_COMPLETED] = completed
        }
    }

    suspend fun setLast5PercentMode(enabled: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[LAST_5_PERCENT_MODE] = enabled
        }
    }

    suspend fun saveTravelCard(card: UserTravelCard) {
        context.dataStore.edit { prefs ->
            prefs[CARD_FULL_NAME] = card.fullName
            prefs[CARD_NATIONALITY] = card.nationality
            prefs[CARD_EMERGENCY_NAME] = card.emergencyContactName
            prefs[CARD_EMERGENCY_PHONE] = card.emergencyContactPhone
            prefs[CARD_EMERGENCY_RELATION] = card.emergencyContactRelation
            prefs[CARD_ACCOMMODATION] = card.accommodationAddress
            prefs[CARD_PASSPORT] = card.passportNumber
            prefs[CARD_BLOOD_TYPE] = card.bloodType
            prefs[CARD_ALLERGIES] = card.allergies
            prefs[CARD_MEDICAL_NOTES] = card.medicalNotes
            prefs[CARD_PHOTO_URI] = card.photoUri
        }
    }

    suspend fun clearTravelCard() {
        context.dataStore.edit { prefs ->
            prefs.remove(CARD_FULL_NAME)
            prefs.remove(CARD_NATIONALITY)
            prefs.remove(CARD_EMERGENCY_NAME)
            prefs.remove(CARD_EMERGENCY_PHONE)
            prefs.remove(CARD_EMERGENCY_RELATION)
            prefs.remove(CARD_ACCOMMODATION)
            prefs.remove(CARD_PASSPORT)
            prefs.remove(CARD_BLOOD_TYPE)
            prefs.remove(CARD_ALLERGIES)
            prefs.remove(CARD_MEDICAL_NOTES)
            prefs.remove(CARD_PHOTO_URI)
        }
    }
}
