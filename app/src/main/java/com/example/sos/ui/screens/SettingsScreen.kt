package com.example.sos.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sos.core.localization.StringsLocalizer

@Composable
fun SettingsScreen(
    appLang: String,
    targetLang: String,
    onSetAppLanguage: (String) -> Unit,
    onSetTargetLanguage: (String) -> Unit,
    onResetOnboarding: () -> Unit,
    onClearData: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = StringsLocalizer.get("nav_settings", appLang),
            fontSize = 22.sp,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colorScheme.primary
        )

        // APP INTERFACE LANGUAGE PICKER
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "App Interface Language", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FilterChip(
                        selected = appLang == "en",
                        onClick = { onSetAppLanguage("en") },
                        label = { Text("English 🇬🇧") }
                    )
                    FilterChip(
                        selected = appLang == "fr",
                        onClick = { onSetAppLanguage("fr") },
                        label = { Text("Français 🇫🇷") }
                    )
                    FilterChip(
                        selected = appLang == "ar",
                        onClick = { onSetAppLanguage("ar") },
                        label = { Text("العربية 🇸🇦") }
                    )
                }
            }
        }

        // PRIVACY & OFFLINE GUARANTEE
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Default.Security, contentDescription = null, tint = MaterialTheme.colorScheme.secondary)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Privacy & Offline Guarantee", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "• 100% Offline operation\n• No server, no account, no tracking\n• All personal information is saved locally on your device only.",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // DANGER ZONE / DATA RESET
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Data Management", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color(0xFFD32F2F))
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedButton(
                    onClick = onClearData,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFD32F2F))
                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Erase All Personal Data")
                }
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedButton(
                    onClick = onResetOnboarding,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Re-run App Onboarding Setup")
                }
            }
        }
    }
}
