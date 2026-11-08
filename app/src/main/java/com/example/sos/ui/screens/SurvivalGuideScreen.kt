package com.example.sos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import com.example.sos.core.localization.StringsLocalizer
import com.example.sos.data.model.SurvivalCategory
import com.example.sos.data.model.SurvivalGuideCard
import com.example.sos.data.repository.SurvivalRepository
import com.example.sos.ui.components.IconMapper

@Composable
fun SurvivalGuideScreen(
    appLang: String,
    targetLang: String,
    onSpeakMessage: (String, String) -> Unit,
    onCopyMessage: (String) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf<SurvivalCategory?>(null) }
    var selectedCard by remember { mutableStateOf<SurvivalGuideCard?>(null) }
    var showFullDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    val filteredGuides = SurvivalRepository.guides.filter { guide ->
        val matchesCategory = selectedCategory == null || guide.category == selectedCategory
        val matchesSearch = searchQuery.isBlank() ||
                guide.getTitle(appLang).contains(searchQuery, ignoreCase = true) ||
                guide.getDescription(appLang).contains(searchQuery, ignoreCase = true)
        matchesCategory && matchesSearch
    }

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
        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search emergency guides...") },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { searchQuery = "" }) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                    }
                }
            },
            shape = RoundedCornerShape(16.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Category Filter Chips
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                FilterChip(
                    selected = selectedCategory == null,
                    onClick = { selectedCategory = null },
                    label = { Text("All Cards") }
                )
            }
            items(SurvivalCategory.entries.toTypedArray()) { category ->
                val title = when (appLang.lowercase()) {
                    "fr" -> category.titleFr
                    "ar" -> category.titleAr
                    else -> category.titleEn
                }
                FilterChip(
                    selected = selectedCategory == category,
                    onClick = { selectedCategory = if (selectedCategory == category) null else category },
                    label = { Text(title) }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Guides List
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(filteredGuides) { guide ->
                val title = guide.getTitle(appLang)
                val desc = guide.getDescription(appLang)
                val firstSteps = guide.getFirstSteps(appLang)
                val avoidSteps = guide.getWhatToAvoid(appLang)
                val whenToCall = guide.getWhenToCall(appLang)
                val readyMsg = guide.getReadyMessage(targetLang)

                val isExpanded = selectedCard == guide

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selectedCard = if (isExpanded) null else guide },
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = IconMapper.getIcon(guide.iconName),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(32.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = title,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = desc,
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    maxLines = if (isExpanded) Int.MAX_VALUE else 2
                                )
                            }
                            Icon(
                                imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                contentDescription = null
                            )
                        }

                        if (isExpanded) {
                            Spacer(modifier = Modifier.height(16.dp))

                            Text(text = "1. FIRST STEPS TO TAKE:", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary, fontSize = 13.sp)
                            firstSteps.forEachIndexed { idx, step ->
                                Text(text = "• $step", fontSize = 13.sp, modifier = Modifier.padding(vertical = 2.dp))
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(text = "2. WHAT TO AVOID:", fontWeight = FontWeight.Bold, color = Color(0xFFD32F2F), fontSize = 13.sp)
                            avoidSteps.forEach { step ->
                                Text(text = "❌ $step", fontSize = 13.sp, modifier = Modifier.padding(vertical = 2.dp))
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(text = "3. WHEN TO CONTACT EMERGENCY SERVICES:", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                            Text(text = whenToCall, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)

                            Spacer(modifier = Modifier.height(12.dp))

                            // Localized Ready Message Box
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                            ) {
                                Column(modifier = Modifier.padding(12.dp)) {
                                    Text(
                                        text = "READY MESSAGE TO SHOW LOCALS (${targetLang.uppercase()}):",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.secondary
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = readyMsg,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                        Button(
                                            onClick = {
                                                dialogMessage = readyMsg
                                                showFullDialog = true
                                            },
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            Text(text = "SHOW FULL SCREEN", fontSize = 11.sp)
                                        }
                                        IconButton(onClick = { onSpeakMessage(readyMsg, targetLang) }) {
                                            Icon(imageVector = Icons.Default.VolumeUp, contentDescription = "Speak")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
