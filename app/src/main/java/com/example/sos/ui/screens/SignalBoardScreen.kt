package com.example.sos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sos.core.localization.StringsLocalizer
import com.example.sos.data.model.Pictogram
import com.example.sos.data.model.PictogramCategory
import com.example.sos.data.repository.PictogramRepository
import com.example.sos.ui.components.IconMapper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignalBoardScreen(
    appLang: String,
    targetLang: String,
    selectedPictograms: List<Pictogram>,
    composedSentence: String,
    onTogglePictogram: (Pictogram) -> Unit,
    onClearPictograms: () -> Unit,
    onSetTargetLanguage: (String) -> Unit,
    onSpeakMessage: (String, String) -> Unit,
    onCopyMessage: (String) -> Unit
) {
    var selectedCategory by remember { mutableStateOf(PictogramCategory.MEDICAL) }
    var showFullScreenDialog by remember { mutableStateOf(false) }

    val availableTargetLangs = listOf(
        "en" to "English 🇬🇧",
        "fr" to "Français 🇫🇷",
        "ar" to "العربية 🇸🇦",
        "es" to "Español 🇪🇸",
        "de" to "Deutsch 🇩🇪",
        "it" to "Italiano 🇮🇹",
        "tr" to "Türkçe 🇹🇷",
        "ja" to "日本語 🇯🇵",
        "zh" to "中文 🇨🇳",
        "ru" to "Русский 🇷🇺"
    )

    if (showFullScreenDialog) {
        FullScreenMessageDialog(
            message = composedSentence,
            targetLanguageCode = targetLang,
            onDismiss = { showFullScreenDialog = false },
            onSpeak = { onSpeakMessage(composedSentence, targetLang) },
            onCopy = { onCopyMessage(composedSentence) }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Target Language Selector Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = StringsLocalizer.get("target_language", appLang),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            var expanded by remember { mutableStateOf(false) }
            Box {
                FilterChip(
                    selected = true,
                    onClick = { expanded = true },
                    label = {
                        Text(
                            text = availableTargetLangs.firstOrNull { it.first == targetLang }?.second ?: targetLang.uppercase(),
                            fontWeight = FontWeight.Bold
                        )
                    },
                    trailingIcon = {
                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                    }
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    availableTargetLangs.forEach { (code, label) ->
                        DropdownMenuItem(
                            text = { Text(text = label) },
                            onClick = {
                                onSetTargetLanguage(code)
                                expanded = false
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // COMPOSED MESSAGE DISPLAY BOX
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = StringsLocalizer.get("composed_message", appLang),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    if (selectedPictograms.isNotEmpty()) {
                        TextButton(onClick = onClearPictograms) {
                            Text(text = StringsLocalizer.get("reset_board", appLang), fontSize = 12.sp)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = if (composedSentence.isNotBlank()) composedSentence else StringsLocalizer.get("empty_board_hint", appLang),
                    fontSize = if (composedSentence.isNotBlank()) 18.sp else 13.sp,
                    fontWeight = if (composedSentence.isNotBlank()) FontWeight.Bold else FontWeight.Normal,
                    color = if (composedSentence.isNotBlank()) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant,
                    minLines = 2,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Action Bar: Full screen, Speak, Copy
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { showFullScreenDialog = true },
                        enabled = composedSentence.isNotBlank(),
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                    ) {
                        Icon(imageVector = Icons.Default.Fullscreen, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = StringsLocalizer.get("full_screen_show", appLang), fontSize = 11.sp)
                    }

                    IconButton(
                        onClick = { onSpeakMessage(composedSentence, targetLang) },
                        enabled = composedSentence.isNotBlank()
                    ) {
                        Icon(imageVector = Icons.Default.VolumeUp, contentDescription = "Speak")
                    }

                    IconButton(
                        onClick = { onCopyMessage(composedSentence) },
                        enabled = composedSentence.isNotBlank()
                    ) {
                        Icon(imageVector = Icons.Default.ContentCopy, contentDescription = "Copy")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // CATEGORY SELECTION SCROLLABLE TABS
        ScrollableTabRow(
            selectedTabIndex = PictogramCategory.entries.indexOf(selectedCategory),
            edgePadding = 0.dp,
            divider = {}
        ) {
            PictogramCategory.entries.forEach { category ->
                val title = when (appLang.lowercase()) {
                    "fr" -> category.titleFr
                    "ar" -> category.titleAr
                    else -> category.titleEn
                }
                Tab(
                    selected = selectedCategory == category,
                    onClick = { selectedCategory = category },
                    text = {
                        Text(
                            text = title,
                            fontWeight = if (selectedCategory == category) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // PICTOGRAM GRID
        val categoryPictograms = PictogramRepository.getByCategory(selectedCategory)

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(categoryPictograms) { pictogram ->
                val isSelected = selectedPictograms.contains(pictogram)
                val text = pictogram.getText(appLang)

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .clickable { onTogglePictogram(pictogram) },
                    colors = CardDefaults.cardColors(
                        containerColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
                    ),
                    shape = RoundedCornerShape(16.dp),
                    border = if (isSelected) androidx.compose.foundation.BorderStroke(2.dp, MaterialTheme.colorScheme.primary) else null
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = IconMapper.getIcon(pictogram.iconName),
                            contentDescription = null,
                            tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(36.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = text,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}
