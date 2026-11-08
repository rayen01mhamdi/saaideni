package com.example.sos.ui.screens

import android.content.Intent
import android.net.Uri
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sos.data.model.CountryEmergency
import com.example.sos.data.repository.CountryRepository

@Composable
fun CountryDatabaseScreen(
    appLang: String,
    selectedCountryCode: String,
    onSelectCountry: (String) -> Unit
) {
    val context = LocalContext.current
    var searchQuery by remember { mutableStateOf("") }

    val filteredCountries = CountryRepository.countries.filter { country ->
        searchQuery.isBlank() ||
                country.nameEn.contains(searchQuery, ignoreCase = true) ||
                country.nameFr.contains(searchQuery, ignoreCase = true) ||
                country.nameAr.contains(searchQuery, ignoreCase = true) ||
                country.code.contains(searchQuery, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search country name or code...") },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
            shape = RoundedCornerShape(16.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(filteredCountries) { country ->
                val isSelected = country.code.equals(selectedCountryCode, ignoreCase = true)

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
                    ),
                    shape = RoundedCornerShape(16.dp),
                    border = if (isSelected) androidx.compose.foundation.BorderStroke(2.dp, MaterialTheme.colorScheme.primary) else null
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = country.getName(appLang),
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Code: ${country.code} • Calling code: ${country.dialCode}",
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            if (!isSelected) {
                                Button(onClick = { onSelectCountry(country.code) }) {
                                    Text(text = "Select", fontSize = 12.sp)
                                }
                            } else {
                                Text(text = "✓ SELECTED", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary, fontSize = 12.sp)
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            CountryDialChip(label = "Police (${country.police})", number = country.police, context = context, modifier = Modifier.weight(1f))
                            CountryDialChip(label = "Medic (${country.ambulance})", number = country.ambulance, context = context, modifier = Modifier.weight(1f))
                            CountryDialChip(label = "Fire (${country.fire})", number = country.fire, context = context, modifier = Modifier.weight(1f))
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Verified: ${country.lastVerifiedDate} • Source: ${country.source}",
                            fontSize = 10.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CountryDialChip(
    label: String,
    number: String,
    context: android.content.Context,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = {
            if (number.isNotBlank()) {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                context.startActivity(intent)
            }
        },
        modifier = modifier,
        contentPadding = PaddingValues(4.dp)
    ) {
        Text(text = label, fontSize = 11.sp, fontWeight = FontWeight.Bold)
    }
}
