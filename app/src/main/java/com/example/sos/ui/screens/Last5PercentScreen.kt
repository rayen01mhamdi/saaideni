package com.example.sos.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sos.core.location.UserLocationData
import com.example.sos.data.model.CountryEmergency
import com.example.sos.data.model.UserTravelCard
import com.example.sos.ui.theme.OledBlack
import com.example.sos.ui.theme.OledCard
import com.example.sos.ui.theme.OledText
import com.example.sos.ui.theme.OledYellow

@Composable
fun Last5PercentScreen(
    targetLang: String,
    currentCountry: CountryEmergency,
    locationData: UserLocationData?,
    userTravelCard: UserTravelCard,
    onExitMode: () -> Unit
) {
    val context = LocalContext.current
    var showFullDialog by remember { mutableStateOf(false) }

    val locString = locationData?.getFormattedCoordinates() ?: "GPS Unavailable"
    val lowBatteryMessage = when (targetLang.lowercase()) {
        "fr" -> "URGENCE : Ma batterie s'éteint. GPS: $locString. Hôtel: ${userTravelCard.accommodationAddress}. Aidez-moi s'il vous plaît !"
        "ar" -> "طوارئ: هاتفي سينطفئ. موقعي: $locString. فندقي: ${userTravelCard.accommodationAddress}. ساعدني من فضلك!"
        else -> "EMERGENCY: Low battery. GPS: $locString. Hotel: ${userTravelCard.accommodationAddress}. Please help me!"
    }

    if (showFullDialog) {
        FullScreenMessageDialog(
            message = lowBatteryMessage,
            targetLanguageCode = targetLang,
            onDismiss = { showFullDialog = false },
            onSpeak = {},
            onCopy = {}
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(OledBlack)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.BatteryAlert, contentDescription = null, tint = OledYellow)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "LAST 5% EMERGENCY MODE", color = OledYellow, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }

                    OutlinedButton(onClick = onExitMode) {
                        Text(text = "EXIT", color = OledText, fontSize = 12.sp)
                    }
                }
            }

            // LOCATION & TIMESTAMP
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = OledCard),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(text = "LOCATION", color = OledYellow, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        Text(text = locString, color = OledText, fontSize = 22.sp, fontWeight = FontWeight.Black)
                        if (locationData != null) {
                            Text(text = "Time: ${locationData.getFormattedTimestamp()}", color = Color.Gray, fontSize = 11.sp)
                        }
                    }
                }
            }

            // ACCOMMODATION / HOTEL ADDRESS
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = OledCard),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(text = "MY HOTEL / ACCOMMODATION ADDRESS", color = OledYellow, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        Text(
                            text = if (userTravelCard.accommodationAddress.isNotBlank()) userTravelCard.accommodationAddress else "No accommodation saved",
                            color = OledText,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // PRIMARY EMERGENCY CONTACT
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = OledCard),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(text = "EMERGENCY CONTACT", color = OledYellow, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        if (userTravelCard.emergencyContactPhone.isNotBlank()) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(text = userTravelCard.emergencyContactName, color = OledText, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                    Text(text = userTravelCard.emergencyContactPhone, color = Color.Gray, fontSize = 13.sp)
                                }

                                Button(
                                    onClick = {
                                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${userTravelCard.emergencyContactPhone}"))
                                        context.startActivity(intent)
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = OledYellow)
                                ) {
                                    Text(text = "CALL", color = Color.Black, fontWeight = FontWeight.Bold)
                                }
                            }
                        } else {
                            Text(text = "No emergency contact saved", color = Color.Gray, fontSize = 14.sp)
                        }
                    }
                }
            }

            // LOCAL EMERGENCY CALLS
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {
                            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${currentCountry.police}"))
                            context.startActivity(intent)
                        },
                        modifier = Modifier.weight(1f).height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB71C1C))
                    ) {
                        Text(text = "POLICE ${currentCountry.police}", fontWeight = FontWeight.Bold, color = Color.White)
                    }

                    Button(
                        onClick = {
                            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${currentCountry.ambulance}"))
                            context.startActivity(intent)
                        },
                        modifier = Modifier.weight(1f).height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D47A1))
                    ) {
                        Text(text = "MEDIC ${currentCountry.ambulance}", fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }
            }

            // FAST EMERGENCY MESSAGE DISPLAY
            item {
                Button(
                    onClick = { showFullDialog = true },
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = OledYellow)
                ) {
                    Text(text = "SHOW FULL SCREEN EMERGENCY CARD", color = Color.Black, fontWeight = FontWeight.Black)
                }
            }
        }
    }
}
