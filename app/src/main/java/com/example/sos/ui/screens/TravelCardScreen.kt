package com.example.sos.ui.screens

import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.sos.core.localization.StringsLocalizer
import com.example.sos.data.model.UserTravelCard

@Composable
fun TravelCardScreen(
    appLang: String,
    userTravelCard: UserTravelCard,
    onSaveCard: (UserTravelCard) -> Unit,
    onClearCard: () -> Unit
) {
    var isEditing by remember { mutableStateOf(userTravelCard.isEmpty()) }

    var fullName by remember(userTravelCard) { mutableStateOf(userTravelCard.fullName) }
    var nationality by remember(userTravelCard) { mutableStateOf(userTravelCard.nationality) }
    var emergencyName by remember(userTravelCard) { mutableStateOf(userTravelCard.emergencyContactName) }
    var emergencyPhone by remember(userTravelCard) { mutableStateOf(userTravelCard.emergencyContactPhone) }
    var accommodation by remember(userTravelCard) { mutableStateOf(userTravelCard.accommodationAddress) }
    var bloodType by remember(userTravelCard) { mutableStateOf(userTravelCard.bloodType) }
    var allergies by remember(userTravelCard) { mutableStateOf(userTravelCard.allergies) }
    var medicalNotes by remember(userTravelCard) { mutableStateOf(userTravelCard.medicalNotes) }
    var photoUri by remember(userTravelCard) { mutableStateOf(userTravelCard.photoUri) }

    var showLandscapeDialog by remember { mutableStateOf(false) }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            photoUri = uri.toString()
        }
    }

    if (showLandscapeDialog) {
        LandscapeEmergencyCardDialog(
            userTravelCard = userTravelCard,
            appLang = appLang,
            onDismiss = { showLandscapeDialog = false }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = StringsLocalizer.get("card_title", appLang),
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colorScheme.primary
            )

            TextButton(onClick = { isEditing = !isEditing }) {
                Text(text = if (isEditing) "View Card" else "Edit Card")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (!isEditing) {
            // VIEW CARD MODE
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Profile Photo
                    LocalImageFromUri(
                        uriString = userTravelCard.photoUri,
                        modifier = Modifier.size(100.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = userTravelCard.fullName.ifBlank { "NO NAME SAVED" },
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Black,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Column(modifier = Modifier.fillMaxWidth()) {
                        CardDetailItem(label = StringsLocalizer.get("nationality", appLang), value = userTravelCard.nationality, icon = Icons.Default.Flag)
                        CardDetailItem(
                            label = StringsLocalizer.get("emergency_contact", appLang),
                            value = "${userTravelCard.emergencyContactName} (${userTravelCard.emergencyContactPhone})",
                            icon = Icons.Default.ContactPhone
                        )
                        CardDetailItem(label = StringsLocalizer.get("accommodation", appLang), value = userTravelCard.accommodationAddress, icon = Icons.Default.Hotel)
                        CardDetailItem(label = "Blood Type", value = userTravelCard.bloodType, icon = Icons.Default.Bloodtype)
                        CardDetailItem(label = StringsLocalizer.get("allergies", appLang), value = userTravelCard.allergies, icon = Icons.Default.Warning)
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = { showLandscapeDialog = true },
                        modifier = Modifier.fillMaxWidth().height(52.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                    ) {
                        Icon(imageVector = Icons.Default.ScreenRotation, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "FULL SCREEN FLIP PRESENTATION CARD", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedButton(
                onClick = onClearCard,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFD32F2F))
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = StringsLocalizer.get("card_delete", appLang))
            }
        } else {
            // EDIT FORM MODE
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Profile Photo Selector
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clickable { photoPickerLauncher.launch("image/*") },
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        LocalImageFromUri(uriString = photoUri, modifier = Modifier.fillMaxSize())
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(imageVector = Icons.Default.AddAPhoto, contentDescription = "Add Photo", tint = Color.White, modifier = Modifier.size(18.dp))
                        }
                    }

                    Text(text = "Tap circle to choose Profile / ID photo", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)

                    OutlinedTextField(
                        value = fullName,
                        onValueChange = { fullName = it },
                        label = { Text(text = StringsLocalizer.get("full_name", appLang)) },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = nationality,
                        onValueChange = { nationality = it },
                        label = { Text(text = StringsLocalizer.get("nationality", appLang)) },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = emergencyName,
                        onValueChange = { emergencyName = it },
                        label = { Text(text = StringsLocalizer.get("emergency_contact", appLang)) },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = emergencyPhone,
                        onValueChange = { emergencyPhone = it },
                        label = { Text(text = StringsLocalizer.get("emergency_phone", appLang)) },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = accommodation,
                        onValueChange = { accommodation = it },
                        label = { Text(text = StringsLocalizer.get("accommodation", appLang)) },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = bloodType,
                        onValueChange = { bloodType = it },
                        label = { Text(text = "Blood Type (e.g. O+, A-)") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = allergies,
                        onValueChange = { allergies = it },
                        label = { Text(text = StringsLocalizer.get("allergies", appLang)) },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Button(
                        onClick = {
                            val updated = UserTravelCard(
                                fullName = fullName,
                                nationality = nationality,
                                emergencyContactName = emergencyName,
                                emergencyContactPhone = emergencyPhone,
                                accommodationAddress = accommodation,
                                bloodType = bloodType,
                                allergies = allergies,
                                medicalNotes = medicalNotes,
                                photoUri = photoUri
                            )
                            onSaveCard(updated)
                            isEditing = false
                        },
                        modifier = Modifier.fillMaxWidth().height(50.dp)
                    ) {
                        Text(text = StringsLocalizer.get("save", appLang), fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun CardDetailItem(
    label: String,
    value: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector
) {
    if (value.isNotBlank()) {
        Row(
            modifier = Modifier.padding(vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(text = label, fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text(text = value, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
            }
        }
    }
}

@Composable
fun LocalImageFromUri(uriString: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val imageBitmap = remember(uriString) {
        if (uriString.isNotBlank()) {
            try {
                val uri = Uri.parse(uriString)
                val inputStream = context.contentResolver.openInputStream(uri)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                bitmap?.asImageBitmap()
            } catch (e: Exception) {
                null
            }
        } else null
    }

    if (imageBitmap != null) {
        Image(
            bitmap = imageBitmap,
            contentDescription = "Profile Photo",
            modifier = modifier.clip(CircleShape).border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
            contentScale = ContentScale.Crop
        )
    } else {
        Box(
            modifier = modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.fillMaxSize(0.7f)
            )
        }
    }
}

@Composable
fun LandscapeEmergencyCardDialog(
    userTravelCard: UserTravelCard,
    appLang: String,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "EMERGENCY IDENTITY & MEDICAL CARD",
                        color = Color(0xFFFFD600),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Black
                    )

                    IconButton(onClick = onDismiss) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close", tint = Color.White)
                    }
                }

                Row(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(vertical = 12.dp)
                        .background(Color(0xFF161B22), RoundedCornerShape(16.dp))
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LocalImageFromUri(uriString = userTravelCard.photoUri, modifier = Modifier.size(110.dp))

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(text = userTravelCard.fullName.ifBlank { "PASSENGER" }, color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
                        Text(text = "Nationality: ${userTravelCard.nationality}", color = Color.LightGray, fontSize = 14.sp)
                        Text(text = "Contact: ${userTravelCard.emergencyContactName} (${userTravelCard.emergencyContactPhone})", color = Color.LightGray, fontSize = 13.sp)
                        Text(text = "Hotel: ${userTravelCard.accommodationAddress}", color = Color.LightGray, fontSize = 13.sp)
                        Text(text = "Blood: ${userTravelCard.bloodType} • Allergies: ${userTravelCard.allergies}", color = Color(0xFFFF5252), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }
                }

                Text(
                    text = "PLEASE ASSIST THIS PERSON • CONTACT POLICE / DOCTOR IF NEEDED",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
