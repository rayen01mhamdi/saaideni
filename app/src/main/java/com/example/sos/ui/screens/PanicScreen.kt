package com.example.sos.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sos.core.localization.StringsLocalizer
import com.example.sos.core.location.UserLocationData
import com.example.sos.data.model.CountryEmergency
import com.example.sos.data.model.UserTravelCard

@Composable
fun PanicScreen(
    appLang: String,
    targetLang: String,
    currentCountry: CountryEmergency,
    locationData: UserLocationData?,
    userTravelCard: UserTravelCard,
    onSpeakMessage: (String, String) -> Unit,
    onCopyMessage: (String) -> Unit
) {
    val context = LocalContext.current
    var showFullDialog by remember { mutableStateOf(false) }

    val formattedLoc = locationData?.getFormattedCoordinates() ?: "GPS Unavailable"
    val panicMessage = when (targetLang.lowercase()) {
        "fr" -> "URGENCE ABSOLUE : J'ai besoin d'aide immédiatement ! Ma position GPS est : $formattedLoc. Veuillez contacter la police ou l'ambulance !"
        "ar" -> "طوارئ قصوى: أحتاج مساعدة عاجلة فورا! موقعي الجغرافي هو: $formattedLoc. الرجاء الاتصال بالإسعاف أو الشرطة!"
        "es" -> "¡EMERGENCIA: Necesito ayuda inmediatamente! Mi ubicación GPS es: $formattedLoc. ¡Llame a emergencias!"
        else -> "EMERGENCY: I need help immediately! My GPS location is: $formattedLoc. Please call emergency services!"
    }

    if (showFullDialog) {
        FullScreenMessageDialog(
            message = panicMessage,
            targetLanguageCode = targetLang,
            onDismiss = { showFullDialog = false },
            onSpeak = { onSpeakMessage(panicMessage, targetLang) },
            onCopy = { onCopyMessage(panicMessage) }
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Big SOS Glowing Header Badge
        item {
            Box(
                modifier = Modifier
                    .size(140.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.Sos,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(60.dp)
                    )
                    Text(
                        text = "PANIC MODE",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Black
                    )
                }
            }
        }

        // Location & Timestamp Card
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.MyLocation, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = StringsLocalizer.get("location_title", appLang), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = formattedLoc,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Black,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    if (locationData != null) {
                        Text(
                            text = "Timestamp: ${locationData.getFormattedTimestamp()}",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // EMERGENCY CALL ACTIONS
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "OFFICIAL EMERGENCY NUMBERS (${currentCountry.getName(appLang)})",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        PanicDialButton(
                            title = "${StringsLocalizer.get("call_police", appLang)} (${currentCountry.police})",
                            number = currentCountry.police,
                            icon = Icons.Default.LocalPolice,
                            context = context
                        )
                        PanicDialButton(
                            title = "${StringsLocalizer.get("call_ambulance", appLang)} (${currentCountry.ambulance})",
                            number = currentCountry.ambulance,
                            icon = Icons.Default.MedicalServices,
                            context = context
                        )
                        PanicDialButton(
                            title = "${StringsLocalizer.get("call_fire", appLang)} (${currentCountry.fire})",
                            number = currentCountry.fire,
                            icon = Icons.Default.Whatshot,
                            context = context
                        )

                        if (userTravelCard.emergencyContactPhone.isNotBlank()) {
                            PanicDialButton(
                                title = "Call Contact (${userTravelCard.emergencyContactName})",
                                number = userTravelCard.emergencyContactPhone,
                                icon = Icons.Default.ContactPhone,
                                context = context
                            )
                        }
                    }
                }
            }
        }

        // EMERGENCY MESSAGE CARD FOR LOCALS
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "TARGET LANGUAGE MESSAGE (${targetLang.uppercase()})",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = panicMessage,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { showFullDialog = true },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                        ) {
                            Text(text = StringsLocalizer.get("full_screen_show", appLang), color = Color.Black, fontWeight = FontWeight.Bold)
                        }

                        IconButton(onClick = { onSpeakMessage(panicMessage, targetLang) }) {
                            Icon(imageVector = Icons.Default.VolumeUp, contentDescription = "Speak", tint = Color.White)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PanicDialButton(
    title: String,
    number: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    context: android.content.Context
) {
    Button(
        onClick = {
            if (number.isNotBlank()) {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                context.startActivity(intent)
            }
        },
        modifier = Modifier.fillMaxWidth().height(52.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = icon, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimaryContainer)
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Icon(imageVector = Icons.Default.Call, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimaryContainer)
        }
    }
}
