package com.example.sos.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sos.core.localization.StringsLocalizer
import com.example.sos.core.location.UserLocationData
import com.example.sos.data.model.CountryEmergency

@Composable
fun HomeScreen(
    appLang: String,
    targetLang: String,
    currentCountry: CountryEmergency,
    locationData: UserLocationData?,
    last5PercentMode: Boolean,
    onNavigateToBoard: () -> Unit,
    onNavigateToPanic: () -> Unit,
    onNavigateToSurvival: () -> Unit,
    onNavigateToAssistant: () -> Unit,
    onNavigateToCountryDb: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onToggleLast5PercentMode: (Boolean) -> Unit,
    onCopyLocation: (String) -> Unit
) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // App Header Banner
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = StringsLocalizer.get("app_name", appLang),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Black,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = StringsLocalizer.get("offline_notice", appLang),
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Last 5% Mode Toggle Button
                        FilterChip(
                            selected = last5PercentMode,
                            onClick = { onToggleLast5PercentMode(!last5PercentMode) },
                            label = {
                                Text(
                                    text = "5% Mode",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.BatteryAlert,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        )

                        IconButton(onClick = onNavigateToSettings) {
                            Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
                        }
                    }
                }
            }
        }

        // PANIC MODE HERO BUTTON
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onNavigateToPanic() },
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = StringsLocalizer.get("panic_button", appLang),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = StringsLocalizer.get("panic_sub", appLang),
                            fontSize = 13.sp,
                            color = Color.White.copy(alpha = 0.9f)
                        )
                    }

                    Icon(
                        imageVector = Icons.Default.Sos,
                        contentDescription = "Panic SOS",
                        tint = Color.White,
                        modifier = Modifier.size(54.dp)
                    )
                }
            }
        }

        // SILENT SIGNAL BOARD SHORTCUT CARD
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onNavigateToBoard() },
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary),
                shape = RoundedCornerShape(20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.TouchApp,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = StringsLocalizer.get("signal_board_title", appLang),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = StringsLocalizer.get("signal_board_sub", appLang),
                            fontSize = 12.sp,
                            color = Color.White.copy(alpha = 0.9f)
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }

        // CURRENT DESTINATION & EMERGENCY NUMBERS SUMMARY
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Public,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = currentCountry.getName(appLang),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        TextButton(onClick = onNavigateToCountryDb) {
                            Text(text = StringsLocalizer.get("change_country", appLang))
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        EmergencyCallButton(
                            label = "Police (${currentCountry.police})",
                            number = currentCountry.police,
                            modifier = Modifier.weight(1f),
                            context = context
                        )
                        EmergencyCallButton(
                            label = "Medic (${currentCountry.ambulance})",
                            number = currentCountry.ambulance,
                            modifier = Modifier.weight(1f),
                            context = context
                        )
                        EmergencyCallButton(
                            label = "Fire (${currentCountry.fire})",
                            number = currentCountry.fire,
                            modifier = Modifier.weight(1f),
                            context = context
                        )
                    }
                }
            }
        }

        // GPS LOCATION & NEAREST FACILITIES CARD
        item {
            val nearestHospital = locationData?.let {
                com.example.sos.data.repository.FacilityRepository.getNearestFacility(it.latitude, it.longitude, com.example.sos.data.model.FacilityType.HOSPITAL, currentCountry.code)
            }
            val nearestPolice = locationData?.let {
                com.example.sos.data.repository.FacilityRepository.getNearestFacility(it.latitude, it.longitude, com.example.sos.data.model.FacilityType.POLICE, currentCountry.code)
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.MyLocation,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = StringsLocalizer.get("location_title", appLang),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        if (locationData != null) {
                            IconButton(onClick = {
                                onCopyLocation("${locationData.latitude}, ${locationData.longitude}")
                            }) {
                                Icon(
                                    imageVector = Icons.Default.ContentCopy,
                                    contentDescription = "Copy GPS"
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    if (locationData != null) {
                        Text(
                            text = locationData.getFormattedCoordinates(),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Timestamp: ${locationData.getFormattedTimestamp()} • Accuracy: ~${locationData.accuracyMeters.toInt()}m",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "NEAREST EMERGENCY CENTERS (Auto-detected)",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        if (nearestHospital != null) {
                            val (facility, distKm) = nearestHospital
                            FacilityItemRow(
                                name = facility.getName(appLang),
                                distanceStr = "~${String.format(java.util.Locale.US, "%.1f", distKm)} km",
                                phone = facility.phone,
                                icon = Icons.Default.LocalHospital,
                                context = context
                            )
                        }

                        if (nearestPolice != null) {
                            val (facility, distKm) = nearestPolice
                            FacilityItemRow(
                                name = facility.getName(appLang),
                                distanceStr = "~${String.format(java.util.Locale.US, "%.1f", distKm)} km",
                                phone = facility.phone,
                                icon = Icons.Default.LocalPolice,
                                context = context
                            )
                        }
                    } else {
                        Text(
                            text = StringsLocalizer.get("location_loading", appLang),
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // ASSISTANT & SURVIVAL GUIDE GRID
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onNavigateToAssistant() },
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.Assistant,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.size(36.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = StringsLocalizer.get("nav_assistant", appLang),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onNavigateToSurvival() },
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.MenuBook,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier.size(36.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = StringsLocalizer.get("nav_survival", appLang),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun EmergencyCallButton(
    label: String,
    number: String,
    modifier: Modifier = Modifier,
    context: android.content.Context
) {
    Button(
        onClick = {
            if (number.isNotBlank()) {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                context.startActivity(intent)
            }
        },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = label,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Composable
fun FacilityItemRow(
    name: String,
    distanceStr: String,
    phone: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    context: android.content.Context
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Icon(imageVector = icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = name, fontSize = 13.sp, fontWeight = FontWeight.Bold, maxLines = 1)
                Text(text = "Distance: $distanceStr", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }

        IconButton(onClick = {
            if (phone.isNotBlank()) {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
                context.startActivity(intent)
            }
        }) {
            Icon(imageVector = Icons.Default.Phone, contentDescription = "Call", tint = MaterialTheme.colorScheme.primary)
        }
    }
}
