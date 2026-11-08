package com.example.sos.ui.viewmodel

import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.sos.core.location.LocationHelper
import com.example.sos.core.location.UserLocationData
import com.example.sos.core.tts.TextToSpeechHelper
import com.example.sos.data.model.CountryEmergency
import com.example.sos.data.model.Pictogram
import com.example.sos.data.model.UserTravelCard
import com.example.sos.data.repository.CountryRepository
import com.example.sos.data.repository.PictogramRepository
import com.example.sos.data.repository.UserPreferencesRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val userPrefsRepo = UserPreferencesRepository(application)
    private val locationHelper = LocationHelper(application)
    private val ttsHelper = TextToSpeechHelper(application)

    val appLanguage: StateFlow<String> = userPrefsRepo.appLanguageFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = "en"
    )

    val targetLanguage: StateFlow<String> = userPrefsRepo.targetLanguageFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = "fr"
    )

    val selectedCountryCode: StateFlow<String> = userPrefsRepo.selectedCountryCodeFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = "US"
    )

    val last5PercentMode: StateFlow<Boolean> = userPrefsRepo.last5PercentModeFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )

    val onboardingCompleted: StateFlow<Boolean> = userPrefsRepo.onboardingCompletedFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )

    val userTravelCard: StateFlow<UserTravelCard> = userPrefsRepo.userTravelCardFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = UserTravelCard()
    )

    // Default sample fallback location (e.g. NYC 40.7128, -74.0060) if real GPS hasn't emitted fix yet
    private val _locationData = MutableStateFlow<UserLocationData?>(
        UserLocationData(
            latitude = 40.7128,
            longitude = -74.0060,
            accuracyMeters = 15f,
            timestamp = System.currentTimeMillis(),
            isAvailable = true
        )
    )
    val locationData: StateFlow<UserLocationData?> = _locationData.asStateFlow()

    private val _selectedPictograms = MutableStateFlow<List<Pictogram>>(emptyList())
    val selectedPictograms: StateFlow<List<Pictogram>> = _selectedPictograms.asStateFlow()

    val currentCountry: StateFlow<CountryEmergency> = selectedCountryCode.map { code ->
        CountryRepository.getByCode(code) ?: CountryRepository.getDefaultCountry()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = CountryRepository.getDefaultCountry()
    )

    val composedSentence: StateFlow<String> = combine(selectedPictograms, targetLanguage) { pictograms, lang ->
        PictogramRepository.composeSentence(pictograms, lang)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ""
    )

    init {
        refreshLocation()
    }

    fun refreshLocation() {
        viewModelScope.launch {
            val lastLoc = locationHelper.getLastKnownLocation()
            if (lastLoc != null) {
                _locationData.value = lastLoc
                val detected = CountryRepository.detectCountryCode(lastLoc.latitude, lastLoc.longitude)
                userPrefsRepo.setSelectedCountryCode(detected)
            }

            try {
                locationHelper.requestLocationUpdates().collect { loc ->
                    _locationData.value = loc
                    val detected = CountryRepository.detectCountryCode(loc.latitude, loc.longitude)
                    userPrefsRepo.setSelectedCountryCode(detected)
                }
            } catch (e: Exception) {}
        }
    }

    fun togglePictogram(pictogram: Pictogram) {
        val current = _selectedPictograms.value.toMutableList()
        if (current.contains(pictogram)) {
            current.remove(pictogram)
        } else {
            current.add(pictogram)
        }
        _selectedPictograms.value = current
    }

    fun clearPictograms() {
        _selectedPictograms.value = emptyList()
    }

    fun setAppLanguage(lang: String) {
        viewModelScope.launch {
            userPrefsRepo.setAppLanguage(lang)
        }
    }

    fun setTargetLanguage(lang: String) {
        viewModelScope.launch {
            userPrefsRepo.setTargetLanguage(lang)
        }
    }

    fun setSelectedCountryCode(code: String) {
        viewModelScope.launch {
            userPrefsRepo.setSelectedCountryCode(code)
            // Update fallback coordinates according to selected country so nearest facilities update immediately
            when (code.uppercase()) {
                "FR" -> _locationData.value = UserLocationData(48.8566, 2.3522, 10f, System.currentTimeMillis())
                "SA" -> _locationData.value = UserLocationData(24.7136, 46.6753, 10f, System.currentTimeMillis())
                "EG" -> _locationData.value = UserLocationData(30.0444, 31.2357, 10f, System.currentTimeMillis())
                "AE" -> _locationData.value = UserLocationData(25.2048, 55.2708, 10f, System.currentTimeMillis())
                "GB" -> _locationData.value = UserLocationData(51.5074, -0.1278, 10f, System.currentTimeMillis())
                else -> _locationData.value = UserLocationData(40.7128, -74.0060, 10f, System.currentTimeMillis())
            }
        }
    }

    fun setLast5PercentMode(enabled: Boolean) {
        viewModelScope.launch {
            userPrefsRepo.setLast5PercentMode(enabled)
        }
    }

    fun setOnboardingCompleted(completed: Boolean) {
        viewModelScope.launch {
            userPrefsRepo.setOnboardingCompleted(completed)
        }
    }

    fun saveTravelCard(card: UserTravelCard) {
        viewModelScope.launch {
            userPrefsRepo.saveTravelCard(card)
        }
    }

    fun clearTravelCard() {
        viewModelScope.launch {
            userPrefsRepo.clearTravelCard()
        }
    }

    fun speakMessage(text: String, lang: String) {
        ttsHelper.speak(text, lang)
    }

    fun copyToClipboard(text: String) {
        val clipboard = getApplication<Application>().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("SilentSignalText", text)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(getApplication(), "Copied to clipboard", Toast.LENGTH_SHORT).show()
    }

    override fun onCleared() {
        super.onCleared()
        ttsHelper.shutdown()
    }
}
