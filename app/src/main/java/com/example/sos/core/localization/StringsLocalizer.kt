package com.example.sos.core.localization

object StringsLocalizer {

    private val strings = mapOf(
        "app_name" to mapOf("en" to "SILENT SIGNAL", "fr" to "SILENT SIGNAL", "ar" to "الإشارة الصامتة"),
        "tagline" to mapOf("en" to "When words fail, help speaks.", "fr" to "Quand les mots manquent, l'aide parle.", "ar" to "عندما تعجز الكلمات، يتحدث الأمل."),
        
        // Navigation
        "nav_home" to mapOf("en" to "Home", "fr" to "Accueil", "ar" to "الرئيسية"),
        "nav_board" to mapOf("en" to "Signal Board", "fr" to "Tableau", "ar" to "لوحة الإشارات"),
        "nav_panic" to mapOf("en" to "Panic Mode", "fr" to "Mode Panique", "ar" to "وضع الذعر"),
        "nav_survival" to mapOf("en" to "Survival Guide", "fr" to "Guide de Survie", "ar" to "دليل البقاء"),
        "nav_assistant" to mapOf("en" to "Lost Abroad", "fr" to "Assistant Voyage", "ar" to "مساعد السفر"),
        "nav_travel_card" to mapOf("en" to "Travel Card", "fr" to "Fiche Voyage", "ar" to "بطاقة السفر"),
        "nav_settings" to mapOf("en" to "Settings", "fr" to "Paramètres", "ar" to "الإعدادات"),
        
        // Dashboard / Home
        "quick_emergency" to mapOf("en" to "Emergency SOS", "fr" to "SOS Urgence", "ar" to "طوارئ SOS"),
        "signal_board_title" to mapOf("en" to "Visual Board", "fr" to "Tableau Visuel", "ar" to "اللوحة البصرية"),
        "signal_board_sub" to mapOf("en" to "Tap symbols to build a localized message", "fr" to "Touchez des symboles pour composer un message", "ar" to "انقر الرموز لإنشاء رسالة مترجمة"),
        "panic_button" to mapOf("en" to "PANIC MODE", "fr" to "MODE PANIQUE", "ar" to "وضع الذعر والطوارئ"),
        "panic_sub" to mapOf("en" to "High-stress one-tap emergency numbers & location", "fr" to "Numéros d'urgence et localisation instantanée", "ar" to "أرقام الطوارئ والموقع بنقرة واحدة"),
        "last_5_percent" to mapOf("en" to "Last 5% Mode", "fr" to "Mode Derniers 5%", "ar" to "وضع 5% متبقية"),
        "last_5_percent_sub" to mapOf("en" to "Ultra low-power dark emergency mode", "fr" to "Mode sombre ultra-économique", "ar" to "وضع شاشة سوداء منخفض الطاقة"),
        "country_numbers" to mapOf("en" to "Emergency Numbers", "fr" to "Numéros d'Urgence", "ar" to "أرقام الطوارئ في البلد"),
        "current_country" to mapOf("en" to "Current Destination", "fr" to "Destination Actuelle", "ar" to "الوجهة الحالية"),
        "change_country" to mapOf("en" to "Change Country", "fr" to "Changer de Pays", "ar" to "تغيير الدولة"),
        
        // Location
        "location_title" to mapOf("en" to "GPS Location", "fr" to "Position GPS", "ar" to "موقع GPS"),
        "location_loading" to mapOf("en" to "Acquiring offline GPS location...", "fr" to "Recherche de la position GPS...", "ar" to "جاري البحث عن موقع GPS..."),
        "location_unavailable" to mapOf("en" to "Location unavailable (GPS disabled)", "fr" to "Position indisponible (GPS désactivé)", "ar" to "الموقع غير متاح (GPS معطل)"),
        "copy_location" to mapOf("en" to "Copy Location", "fr" to "Copier la position", "ar" to "نسخ الموقع"),
        
        // Board & Composer
        "composed_message" to mapOf("en" to "Composed Message", "fr" to "Message Composé", "ar" to "الرسالة المجمّعة"),
        "target_language" to mapOf("en" to "Target Language", "fr" to "Langue Cible", "ar" to "اللغة الهدف"),
        "user_language" to mapOf("en" to "My Language", "fr" to "Ma Langue", "ar" to "لغتي"),
        "full_screen_show" to mapOf("en" to "Show Full Screen", "fr" to "Plein Écran", "ar" to "عرض ملء الشاشة"),
        "speak_tts" to mapOf("en" to "Speak Out Loud", "fr" to "Lire à voix haute", "ar" to "قراءة صوتية"),
        "reset_board" to mapOf("en" to "Reset Message", "fr" to "Réinitialiser", "ar" to "مسح الرسالة"),
        "empty_board_hint" to mapOf("en" to "Select pictograms above to build an emergency message.", "fr" to "Sélectionnez des pictogrammes ci-dessus.", "ar" to "اختر الرموز التوضيحية أعلاه لإنشاء رسالة."),

        // Emergency Actions
        "call_police" to mapOf("en" to "Call Police", "fr" to "Appeler la Police", "ar" to "اتصل بالشرطة"),
        "call_ambulance" to mapOf("en" to "Call Ambulance", "fr" to "Appeler l'Ambulance", "ar" to "اتصل بالإسعاف"),
        "call_fire" to mapOf("en" to "Call Fire", "fr" to "Appeler les Pompiers", "ar" to "اتصل بالمطافئ"),
        "call_general" to mapOf("en" to "Call SOS 112", "fr" to "Appeler le 112", "ar" to "اتصل بالرقم 112"),
        "call_contact" to mapOf("en" to "Call Emergency Contact", "fr" to "Appeler le Contact", "ar" to "اتصل بجهة الطوارئ"),
        
        // Travel Card
        "card_title" to mapOf("en" to "My Emergency Travel Card", "fr" to "Ma Fiche Urgence Voyage", "ar" to "بطاقة طوارئ السفر"),
        "card_edit" to mapOf("en" to "Edit Personal Info", "fr" to "Modifier mes infos", "ar" to "تعديل البيانات"),
        "card_delete" to mapOf("en" to "Erase All Personal Data", "fr" to "Effacer toutes mes données", "ar" to "مسح جميع البيانات الشخصية"),
        "full_name" to mapOf("en" to "Full Name", "fr" to "Nom Complet", "ar" to "الاسم الكامل"),
        "nationality" to mapOf("en" to "Nationality", "fr" to "Nationalité", "ar" to "الجنسية"),
        "emergency_contact" to mapOf("en" to "Emergency Contact Name", "fr" to "Nom Contact d'Urgence", "ar" to "اسم جهة الطوارئ"),
        "emergency_phone" to mapOf("en" to "Emergency Phone Number", "fr" to "Téléphone Contact d'Urgence", "ar" to "رقم هاتف الطوارئ"),
        "accommodation" to mapOf("en" to "Hotel / Accommodation Address", "fr" to "Adresse Hôtel / Logement", "ar" to "عنوان الفندق / الإقامة"),
        "allergies" to mapOf("en" to "Allergies / Medical Notes", "fr" to "Allergies / Notes Médicales", "ar" to "الحساسية / ملاحظات طبية"),
        "save" to mapOf("en" to "Save Card", "fr" to "Enregistrer", "ar" to "حفظ البطاقة"),

        // Offline Guarantee
        "offline_notice" to mapOf("en" to "100% Offline • No tracking • No internet required", "fr" to "100% Hors-Ligne • Sans suivi • Sans internet", "ar" to "100% بدون إنترنت • بدون تتبع • حماية كاملة")
    )

    fun get(key: String, lang: String): String {
        val keyMap = strings[key] ?: return key
        return keyMap[lang.lowercase()] ?: keyMap["en"] ?: key
    }
}
