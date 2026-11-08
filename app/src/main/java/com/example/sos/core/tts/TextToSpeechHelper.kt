package com.example.sos.core.tts

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.*

class TextToSpeechHelper(context: Context) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = TextToSpeech(context.applicationContext, this)
    private var isInitialized = false

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            isInitialized = true
        } else {
            isInitialized = false
        }
    }

    fun speak(text: String, languageCode: String, onComplete: () -> Unit = {}) {
        if (!isInitialized || tts == null || text.isBlank()) {
            onComplete()
            return
        }

        val locale = when (languageCode.lowercase()) {
            "fr" -> Locale.FRENCH
            "ar" -> Locale("ar")
            "es" -> Locale("es", "ES")
            "de" -> Locale.GERMAN
            "it" -> Locale.ITALIAN
            "tr" -> Locale("tr")
            "ja" -> Locale.JAPANESE
            "zh" -> Locale.CHINESE
            "ru" -> Locale("ru")
            else -> Locale.ENGLISH
        }

        val result = tts?.setLanguage(locale)
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            // Fallback to English if target locale not supported offline
            tts?.setLanguage(Locale.ENGLISH)
        }

        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "SilentSignalTTS")
    }

    fun stop() {
        tts?.stop()
    }

    fun shutdown() {
        try {
            tts?.stop()
            tts?.shutdown()
        } catch (e: Exception) {}
        tts = null
    }
}
