package com.example.sos.data.repository

import com.example.sos.data.model.CountryEmergency

object CountryRepository {

    val countries: List<CountryEmergency> = listOf(
        CountryEmergency(
            code = "US",
            nameEn = "United States",
            nameFr = "États-Unis",
            nameAr = "الولايات المتحدة",
            dialCode = "+1",
            police = "911",
            ambulance = "911",
            fire = "911",
            generalEmergency = "911",
            source = "U.S. Federal Communications Commission (FCC)",
            lastVerifiedDate = "2024-01-15"
        ),
        CountryEmergency(
            code = "FR",
            nameEn = "France",
            nameFr = "France",
            nameAr = "فرنسا",
            dialCode = "+33",
            police = "17",
            ambulance = "15",
            fire = "18",
            generalEmergency = "112",
            source = "Ministère de l'Intérieur (France)",
            lastVerifiedDate = "2024-01-10"
        ),
        CountryEmergency(
            code = "SA",
            nameEn = "Saudi Arabia",
            nameFr = "Arabie Saoudite",
            nameAr = "المملكة العربية السعودية",
            dialCode = "+966",
            police = "999",
            ambulance = "997",
            fire = "998",
            generalEmergency = "911",
            source = "Saudi General Directorate of Civil Defense",
            lastVerifiedDate = "2024-02-01"
        ),
        CountryEmergency(
            code = "EG",
            nameEn = "Egypt",
            nameFr = "Égypte",
            nameAr = "مصر",
            dialCode = "+20",
            police = "122",
            ambulance = "123",
            fire = "180",
            generalEmergency = "112",
            source = "Egyptian Ministry of Health & Interior",
            lastVerifiedDate = "2024-01-20"
        ),
        CountryEmergency(
            code = "AE",
            nameEn = "United Arab Emirates",
            nameFr = "Émirats Arabes Unis",
            nameAr = "الإمارات العربية المتحدة",
            dialCode = "+971",
            police = "999",
            ambulance = "998",
            fire = "997",
            generalEmergency = "112",
            source = "UAE Government Portal",
            lastVerifiedDate = "2024-02-05"
        ),
        CountryEmergency(
            code = "GB",
            nameEn = "United Kingdom",
            nameFr = "Royaume-Uni",
            nameAr = "المملكة المتحدة",
            dialCode = "+44",
            police = "999",
            ambulance = "999",
            fire = "999",
            generalEmergency = "112",
            source = "UK Home Office & NHS",
            lastVerifiedDate = "2024-01-12"
        ),
        CountryEmergency(
            code = "DE",
            nameEn = "Germany",
            nameFr = "Allemagne",
            nameAr = "ألمانيا",
            dialCode = "+49",
            police = "110",
            ambulance = "112",
            fire = "112",
            generalEmergency = "112",
            source = "Federal Ministry of the Interior (Germany)",
            lastVerifiedDate = "2024-01-18"
        ),
        CountryEmergency(
            code = "JP",
            nameEn = "Japan",
            nameFr = "Japon",
            nameAr = "اليابان",
            dialCode = "+81",
            police = "110",
            ambulance = "119",
            fire = "119",
            generalEmergency = "110 / 119",
            source = "National Police Agency Japan & Fire Department",
            lastVerifiedDate = "2024-01-25"
        ),
        CountryEmergency(
            code = "ES",
            nameEn = "Spain",
            nameFr = "Espagne",
            nameAr = "إسبانيا",
            dialCode = "+34",
            police = "091",
            ambulance = "061",
            fire = "080",
            generalEmergency = "112",
            source = "Ministerio del Interior (España)",
            lastVerifiedDate = "2024-01-14"
        ),
        CountryEmergency(
            code = "IT",
            nameEn = "Italy",
            nameFr = "Italie",
            nameAr = "إيطاليا",
            dialCode = "+39",
            police = "113",
            ambulance = "118",
            fire = "115",
            generalEmergency = "112",
            source = "Ministero dell'Interno (Italia)",
            lastVerifiedDate = "2024-01-16"
        ),
        CountryEmergency(
            code = "TR",
            nameEn = "Turkey",
            nameFr = "Turquie",
            nameAr = "تركيا",
            dialCode = "+90",
            police = "112",
            ambulance = "112",
            fire = "112",
            generalEmergency = "112",
            source = "AFAD & Ministry of Health Turkey",
            lastVerifiedDate = "2024-02-02"
        ),
        CountryEmergency(
            code = "CA",
            nameEn = "Canada",
            nameFr = "Canada",
            nameAr = "كندا",
            dialCode = "+1",
            police = "911",
            ambulance = "911",
            fire = "911",
            generalEmergency = "911",
            source = "Public Safety Canada",
            lastVerifiedDate = "2024-01-11"
        ),
        CountryEmergency(
            code = "AU",
            nameEn = "Australia",
            nameFr = "Australie",
            nameAr = "أستراليا",
            dialCode = "+61",
            police = "000",
            ambulance = "000",
            fire = "000",
            generalEmergency = "000 (112 mobile)",
            source = "Australian Government Emergency Portal",
            lastVerifiedDate = "2024-01-15"
        ),
        CountryEmergency(
            code = "MA",
            nameEn = "Morocco",
            nameFr = "Maroc",
            nameAr = "المغرب",
            dialCode = "+212",
            police = "19",
            ambulance = "15",
            fire = "15",
            generalEmergency = "112",
            source = "Ministère de l'Intérieur du Maroc",
            lastVerifiedDate = "2024-01-22"
        ),
        CountryEmergency(
            code = "TH",
            nameEn = "Thailand",
            nameFr = "Thaïlande",
            nameAr = "تايلاند",
            dialCode = "+66",
            police = "191",
            ambulance = "1669",
            fire = "199",
            generalEmergency = "1155 (Tourist Police)",
            source = "Tourism Authority of Thailand",
            lastVerifiedDate = "2024-02-03"
        ),
        CountryEmergency(
            code = "KR",
            nameEn = "South Korea",
            nameFr = "Corée du Sud",
            nameAr = "كوريا الجنوبية",
            dialCode = "+82",
            police = "112",
            ambulance = "119",
            fire = "119",
            generalEmergency = "112 / 119",
            source = "Korean National Police Agency & NFA",
            lastVerifiedDate = "2024-01-28"
        ),
        CountryEmergency(
            code = "CN",
            nameEn = "China",
            nameFr = "Chine",
            nameAr = "الصين",
            dialCode = "+86",
            police = "110",
            ambulance = "120",
            fire = "119",
            generalEmergency = "110",
            source = "Ministry of Public Security PRC",
            lastVerifiedDate = "2024-01-30"
        ),
        CountryEmergency(
            code = "BR",
            nameEn = "Brazil",
            nameFr = "Brésil",
            nameAr = "البرازيل",
            dialCode = "+55",
            police = "190",
            ambulance = "192",
            fire = "193",
            generalEmergency = "190",
            source = "Ministério da Justiça (Brasil)",
            lastVerifiedDate = "2024-01-19"
        ),
        CountryEmergency(
            code = "MX",
            nameEn = "Mexico",
            nameFr = "Mexique",
            nameAr = "المكسيك",
            dialCode = "+52",
            police = "911",
            ambulance = "911",
            fire = "911",
            generalEmergency = "911",
            source = "Secretaría de Gobernación México",
            lastVerifiedDate = "2024-01-17"
        ),
        CountryEmergency(
            code = "CH",
            nameEn = "Switzerland",
            nameFr = "Suisse",
            nameAr = "سويسرا",
            dialCode = "+41",
            police = "117",
            ambulance = "144",
            fire = "118",
            generalEmergency = "112",
            source = "Federal Authorities of the Swiss Confederation",
            lastVerifiedDate = "2024-01-21"
        )
    )

    fun getByCode(code: String): CountryEmergency? {
        return countries.firstOrNull { it.code.equals(code, ignoreCase = true) }
    }

    fun getDefaultCountry(): CountryEmergency {
        return countries.first { it.code == "US" }
    }

    fun detectCountryCode(lat: Double, lon: Double): String {
        return when {
            lat in 24.0..50.0 && lon in -125.0..-66.0 -> "US"
            lat in 41.0..51.5 && lon in -5.0..10.0 -> "FR"
            lat in 49.9..60.9 && lon in -8.2..1.8 -> "GB"
            lat in 16.0..32.5 && lon in 34.5..55.7 -> "SA"
            lat in 22.0..31.8 && lon in 24.7..37.0 -> "EG"
            lat in 22.5..26.3 && lon in 51.5..56.5 -> "AE"
            lat in 47.2..55.1 && lon in 5.8..15.0 -> "DE"
            lat in 24.0..45.5 && lon in 122.9..153.9 -> "JP"
            lat in 36.0..43.8 && lon in -9.3..3.4 -> "ES"
            lat in 35.5..47.1 && lon in 6.6..18.5 -> "IT"
            lat in 35.8..42.1 && lon in 25.6..44.8 -> "TR"
            lat in 41.7..83.1 && lon in -141.0..-52.6 -> "CA"
            lat in -43.7..-10.6 && lon in 113.3..153.6 -> "AU"
            lat in 27.6..35.9 && lon in -13.2..-1.0 -> "MA"
            lat in 5.6..20.5 && lon in 97.3..105.6 -> "TH"
            lat in 33.0..38.6 && lon in 124.6..131.0 -> "KR"
            lat in 18.0..53.5 && lon in 73.5..135.0 -> "CN"
            lat in -33.8..5.3 && lon in -74.0..-34.8 -> "BR"
            lat in 14.5..32.7 && lon in -118.4..-86.7 -> "MX"
            lat in 45.8..47.8 && lon in 5.9..10.5 -> "CH"
            else -> "US"
        }
    }
}
