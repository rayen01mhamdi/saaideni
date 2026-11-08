package com.example.sos.data.repository

import com.example.sos.data.model.EmergencyFacility
import com.example.sos.data.model.FacilityType
import kotlin.math.*

object FacilityRepository {

    val facilities: List<EmergencyFacility> = listOf(
        // UNITED STATES
        EmergencyFacility(
            id = "us_ny_hosp_1",
            nameEn = "NYC Health + Hospitals / Bellevue",
            nameFr = "Hôpital Bellevue New York",
            nameAr = "مستشفى بيليفيو نيويورك",
            type = FacilityType.HOSPITAL,
            countryCode = "US",
            city = "New York",
            latitude = 40.7388,
            longitude = -73.9754,
            phone = "911",
            address = "462 1st Ave, New York, NY 10016"
        ),
        EmergencyFacility(
            id = "us_ny_pol_1",
            nameEn = "NYPD 13th Precinct Police Station",
            nameFr = "Commissariat 13e District New York",
            nameAr = "مركز شرطة الدائرة 13 نيويورك",
            type = FacilityType.POLICE,
            countryCode = "US",
            city = "New York",
            latitude = 40.7371,
            longitude = -73.9822,
            phone = "911",
            address = "230 E 21st St, New York, NY 10010"
        ),

        // FRANCE
        EmergencyFacility(
            id = "fr_paris_hosp_1",
            nameEn = "Hôtel-Dieu Hospital Paris",
            nameFr = "Hôpital Hôtel-Dieu de Paris",
            nameAr = "مستشفى أوتيل ديو باريس",
            type = FacilityType.HOSPITAL,
            countryCode = "FR",
            city = "Paris",
            latitude = 48.8548,
            longitude = 2.3486,
            phone = "15",
            address = "1 Place du Parvis de Notre-Dame, 75004 Paris"
        ),
        EmergencyFacility(
            id = "fr_paris_pol_1",
            nameEn = "Central Police Commissariat Paris 4th",
            nameFr = "Commissariat Central du 4e Arrondissement",
            nameAr = "مركز الشرطة الرئيسي الدائرة الرابعة باريس",
            type = FacilityType.POLICE,
            countryCode = "FR",
            city = "Paris",
            latitude = 48.8552,
            longitude = 2.3585,
            phone = "17",
            address = "27 Boulevard Place de la Bastille, 75004 Paris"
        ),

        // SAUDI ARABIA
        EmergencyFacility(
            id = "sa_riy_hosp_1",
            nameEn = "King Faisal Specialist Hospital Riyadh",
            nameFr = "Hôpital Spécialisé Roi Faisal Riyad",
            nameAr = "مستشفى الملك فيصل التخصصي الرياض",
            type = FacilityType.HOSPITAL,
            countryCode = "SA",
            city = "Riyadh",
            latitude = 24.6712,
            longitude = 46.6775,
            phone = "997",
            address = "Zahrat Al Shamal, Riyadh 12713"
        ),
        EmergencyFacility(
            id = "sa_riy_pol_1",
            nameEn = "Al Olaya Police Station Riyadh",
            nameFr = "Poste de Police Al Olaya Riyad",
            nameAr = "مركز شرطة العليا الرياض",
            type = FacilityType.POLICE,
            countryCode = "SA",
            city = "Riyadh",
            latitude = 24.6980,
            longitude = 46.6852,
            phone = "999",
            address = "King Fahd Rd, Al Olaya, Riyadh"
        ),

        // EGYPT
        EmergencyFacility(
            id = "eg_cai_hosp_1",
            nameEn = "Kasr El Ayni Emergency Hospital Cairo",
            nameFr = "Hôpital d'Urgence Kasr El Ayni Le Caire",
            nameAr = "مستشفى القصر العيني للطوارئ القاهرة",
            type = FacilityType.HOSPITAL,
            countryCode = "EG",
            city = "Cairo",
            latitude = 30.0315,
            longitude = 31.2281,
            phone = "123",
            address = "El-Manial, Cairo"
        ),
        EmergencyFacility(
            id = "eg_cai_pol_1",
            nameEn = "Qasr El Nil Police Station Cairo",
            nameFr = "Poste de Police Qasr El Nil Le Caire",
            nameAr = "قسم شرطة قصر النيل القاهرة",
            type = FacilityType.POLICE,
            countryCode = "EG",
            city = "Cairo",
            latitude = 30.0444,
            longitude = 31.2357,
            phone = "122",
            address = "Qasr El Nil St, Downtown Cairo"
        ),

        // UAE
        EmergencyFacility(
            id = "ae_dxb_hosp_1",
            nameEn = "Rashid Hospital Dubai",
            nameFr = "Hôpital Rashid Dubaï",
            nameAr = "مستشفى راشد دبي",
            type = FacilityType.HOSPITAL,
            countryCode = "AE",
            city = "Dubai",
            latitude = 25.2635,
            longitude = 55.3184,
            phone = "998",
            address = "Oud Metha Road, Dubai"
        ),
        EmergencyFacility(
            id = "ae_dxb_pol_1",
            nameEn = "Bur Dubai Police Station",
            nameFr = "Commissariat Bur Dubaï",
            nameAr = "مركز شرطة بر دبي",
            type = FacilityType.POLICE,
            countryCode = "AE",
            city = "Dubai",
            latitude = 25.2520,
            longitude = 55.2970,
            phone = "999",
            address = "Al Shindagha, Dubai"
        ),

        // UNITED KINGDOM
        EmergencyFacility(
            id = "gb_lon_hosp_1",
            nameEn = "St Thomas' Hospital London",
            nameFr = "Hôpital St Thomas Londres",
            nameAr = "مستشفى سانت توماس لندن",
            type = FacilityType.HOSPITAL,
            countryCode = "GB",
            city = "London",
            latitude = 51.4988,
            longitude = -0.1185,
            phone = "999",
            address = "Westminster Bridge Rd, London SE1 7EH"
        ),
        EmergencyFacility(
            id = "gb_lon_pol_1",
            nameEn = "Charing Cross Police Station London",
            nameFr = "Commissariat Charing Cross Londres",
            nameAr = "مركز شرطة تشارينغ كروس لندن",
            type = FacilityType.POLICE,
            countryCode = "GB",
            city = "London",
            latitude = 51.5085,
            longitude = -0.1246,
            phone = "999",
            address = "Agar St, London WC2N 4JP"
        )
    )

    /**
     * Calculates distance between two coordinates in kilometers using Haversine formula.
     */
    fun calculateDistanceKm(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val earthRadiusKm = 6371.0
        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(lon2 - lon1)
        val a = sin(dLat / 2).pow(2) +
                cos(Math.toRadians(lat1)) * cos(Math.toRadians(lat2)) *
                sin(dLon / 2).pow(2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))
        return earthRadiusKm * c
    }

    /**
     * Returns nearest facility of a given type relative to user's location.
     */
    fun getNearestFacility(userLat: Double, userLon: Double, type: FacilityType, countryCode: String? = null): Pair<EmergencyFacility, Double>? {
        val matches = facilities.filter {
            it.type == type && (countryCode == null || it.countryCode.equals(countryCode, ignoreCase = true))
        }

        if (matches.isEmpty()) {
            val fallbackMatches = facilities.filter { it.type == type }
            if (fallbackMatches.isEmpty()) return null
            val nearest = fallbackMatches.minByOrNull { calculateDistanceKm(userLat, userLon, it.latitude, it.longitude) }!!
            val dist = calculateDistanceKm(userLat, userLon, nearest.latitude, nearest.longitude)
            return Pair(nearest, dist)
        }

        val nearest = matches.minByOrNull { calculateDistanceKm(userLat, userLon, it.latitude, it.longitude) }!!
        val dist = calculateDistanceKm(userLat, userLon, nearest.latitude, nearest.longitude)
        return Pair(nearest, dist)
    }
}
