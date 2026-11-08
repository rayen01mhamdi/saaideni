package com.example.sos.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

object IconMapper {
    fun getIcon(iconName: String): ImageVector {
        return when (iconName) {
            "Healing" -> Icons.Default.Healing
            "SentimentVeryDissatisfied" -> Icons.Default.SentimentVeryDissatisfied
            "Air" -> Icons.Default.Air
            "LocalHospital" -> Icons.Default.LocalHospital
            "Medication" -> Icons.Default.Medication
            "Warning" -> Icons.Default.Warning
            "MedicalServices" -> Icons.Default.MedicalServices
            "ShieldMoon" -> Icons.Default.ShieldMoon
            "DirectionsRun" -> Icons.Default.DirectionsRun
            "LocalPolice" -> Icons.Default.LocalPolice
            "Explore" -> Icons.Default.Explore
            "Security" -> Icons.Default.Security
            "Translate" -> Icons.Default.Translate
            "RecordVoiceOver" -> Icons.Default.RecordVoiceOver
            "PhoneInTalk" -> Icons.Default.PhoneInTalk
            "PhonelinkRing" -> Icons.Default.PhonelinkRing
            "Luggage" -> Icons.Default.Luggage
            "Hotel" -> Icons.Default.Hotel
            "Badge" -> Icons.Default.Badge
            "AccountBalance" -> Icons.Default.AccountBalance
            "WaterDrop" -> Icons.Default.WaterDrop
            "Restaurant" -> Icons.Default.Restaurant
            "Wc" -> Icons.Default.Wc
            "Chair" -> Icons.Default.Chair
            "Favorite" -> Icons.Default.Favorite
            "MoodBad" -> Icons.Default.MoodBad
            "Whatshot" -> Icons.Default.Whatshot
            "MinorCrash" -> Icons.Default.MinorCrash
            "PhonelinkErase" -> Icons.Default.PhonelinkErase
            else -> Icons.Default.Emergency
        }
    }
}
