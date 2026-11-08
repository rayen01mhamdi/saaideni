package com.example.sos.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sos.data.model.LostAbroadScenario
import com.example.sos.data.repository.ScenarioRepository
import com.example.sos.ui.components.IconMapper

@Composable
fun LostAbroadScreen(
    appLang: String,
    targetLang: String,
    onNavigateToBoard: () -> Unit,
    onNavigateToTravelCard: () -> Unit,
    onSpeakMessage: (String, String) -> Unit,
    onCopyMessage: (String) -> Unit
) {
    var selectedScenario by remember { mutableStateOf<LostAbroadScenario?>(null) }
    var showFullDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    if (showFullDialog) {
        FullScreenMessageDialog(
            message = dialogMessage,
            targetLanguageCode = targetLang,
            onDismiss = { showFullDialog = false },
            onSpeak = { onSpeakMessage(dialogMessage, targetLang) },
            onCopy = { onCopyMessage(dialogMessage) }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "LOST ABROAD ASSISTANT",
            fontSize = 20.sp,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Select your current emergency situation for immediate offline steps.",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (selectedScenario == null) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(ScenarioRepository.scenarios) { scenario ->
                    val title = scenario.getTitle(appLang)
                    val sub = scenario.getSubtitle(appLang)

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { selectedScenario = scenario },
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = IconMapper.getIcon(scenario.iconName),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(36.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                Text(text = sub, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                            Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null)
                        }
                    }
                }
            }
        } else {
            val scenario = selectedScenario!!
            val title = scenario.getTitle(appLang)
            val readyMsg = scenario.getReadyMessage(targetLang)

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                        TextButton(onClick = { selectedScenario = null }) {
                            Text(text = "Back")
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    scenario.steps.forEach { step ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = "Step ${step.stepNumber}: ${step.getTitle(appLang)}",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = step.getDetail(appLang),
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurface
                                )

                                if (step.actionType == "SHOW_CARD") {
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Button(onClick = onNavigateToTravelCard) {
                                        Text("Open Travel Card", fontSize = 11.sp)
                                    }
                                } else if (step.actionType == "OPEN_BOARD") {
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Button(onClick = onNavigateToBoard) {
                                        Text("Open Signal Board", fontSize = 11.sp)
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = "READY MESSAGE TO SHOW LOCALS (${targetLang.uppercase()}):",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = readyMsg,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                Button(
                                    onClick = {
                                        dialogMessage = readyMsg
                                        showFullDialog = true
                                    },
                                    modifier = Modifier.weight(1f),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                                ) {
                                    Text(text = "FULL SCREEN", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 11.sp)
                                }
                                IconButton(onClick = { onSpeakMessage(readyMsg, targetLang) }) {
                                    Icon(imageVector = Icons.Default.VolumeUp, contentDescription = null, tint = Color.White)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
