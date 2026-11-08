package com.example.sos.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = RedAccent,
    onPrimary = Color.White,
    primaryContainer = RedDark,
    onPrimaryContainer = Color.White,
    secondary = SafetyBlue,
    onSecondary = Color.White,
    tertiary = MedicalTeal,
    background = DarkBackground,
    onBackground = TextPrimaryDark,
    surface = DarkSurface,
    onSurface = TextPrimaryDark,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = TextSecondaryDark
)

private val LightColorScheme = lightColorScheme(
    primary = RedPrimary,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFDAD6),
    onPrimaryContainer = Color(0xFF410002),
    secondary = SafetyBlue,
    onSecondary = Color.White,
    tertiary = MedicalTeal,
    background = LightBackground,
    onBackground = TextPrimaryLight,
    surface = LightSurface,
    onSurface = TextPrimaryLight,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = TextSecondaryLight
)

private val OledColorScheme = darkColorScheme(
    primary = OledYellow,
    onPrimary = Color.Black,
    primaryContainer = Color(0xFF332E00),
    onPrimaryContainer = OledYellow,
    secondary = Color(0xFF40C4FF),
    onSecondary = Color.Black,
    background = OledBlack,
    onBackground = OledText,
    surface = OledCard,
    onSurface = OledText,
    surfaceVariant = Color(0xFF1E1E1E),
    onSurfaceVariant = Color(0xFFB0B0B0)
)

@Composable
fun SilentSignalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    last5PercentMode: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        last5PercentMode -> OledColorScheme
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
