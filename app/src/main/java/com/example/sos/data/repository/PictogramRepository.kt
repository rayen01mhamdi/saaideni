package com.example.sos.data.repository

import com.example.sos.data.model.Pictogram
import com.example.sos.data.model.PictogramCategory

object PictogramRepository {

    val pictograms: List<Pictogram> = listOf(
        // MEDICAL
        Pictogram(
            id = "med_injured",
            category = PictogramCategory.MEDICAL,
            iconName = "Healing",
            translations = mapOf(
                "en" to "I am injured",
                "fr" to "Je suis blessé(e)",
                "ar" to "أنا مصاب",
                "es" to "Estoy herido/a",
                "de" to "Ich bin verletzt",
                "it" to "Sono ferito/a",
                "tr" to "Yaralıyım",
                "ja" to "怪我をしています",
                "zh" to "我 has 受伤了",
                "ru" to "Я ранен"
            )
        ),
        Pictogram(
            id = "med_pain",
            category = PictogramCategory.MEDICAL,
            iconName = "SentimentVeryDissatisfied",
            translations = mapOf(
                "en" to "I am in severe pain",
                "fr" to "J'ai une forte douleur",
                "ar" to "أشعر بألم شديد",
                "es" to "Tengo dolor fuerte",
                "de" to "Ich habe starke Schmerzen",
                "it" to "Ho forte dolore",
                "tr" to "Ciddi ağrım var",
                "ja" to "激しい痛みがあります",
                "zh" to "我很痛",
                "ru" to "У меня сильная боль"
            )
        ),
        Pictogram(
            id = "med_breathe",
            category = PictogramCategory.MEDICAL,
            iconName = "Air",
            translations = mapOf(
                "en" to "I cannot breathe well",
                "fr" to "Je n'arrive pas à bien respirer",
                "ar" to "لا أستطيع التنفس بشكل جيد",
                "es" to "No puedo respirar bien",
                "de" to "Ich kann schwer atmen",
                "it" to "Non riesco a respirare bene",
                "tr" to "Nefes alamıyorum",
                "ja" to "息が苦しいです",
                "zh" to "我呼吸困难",
                "ru" to "Мне трудно дышать"
            )
        ),
        Pictogram(
            id = "med_doctor",
            category = PictogramCategory.MEDICAL,
            iconName = "LocalHospital",
            translations = mapOf(
                "en" to "I need a doctor urgently",
                "fr" to "J'ai besoin d'un médecin en urgence",
                "ar" to "أحتاج طبيباً بشكل عاجل",
                "es" to "Necesito un médico urgentemente",
                "de" to "Ich brauche dringend einen Arzt",
                "it" to "Ho bisogno urgentemente di un medico",
                "tr" to "Acil doktora ihtiyacım var",
                "ja" to "至急、医師が必要です",
                "zh" to "我急需看医生",
                "ru" to "Мне срочно нужен врач"
            )
        ),
        Pictogram(
            id = "med_medicine",
            category = PictogramCategory.MEDICAL,
            iconName = "Medication",
            translations = mapOf(
                "en" to "I need my medication",
                "fr" to "J'ai besoin de mes médicaments",
                "ar" to "أحتاج إلى دوائي",
                "es" to "Necesito mi medicina",
                "de" to "Ich brauche meine Medikamente",
                "it" to "Ho bisogno dei miei farmaci",
                "tr" to "İlacıma ihtiyacım var",
                "ja" to "薬が必要です",
                "zh" to "我需要吃药",
                "ru" to "Мне нужны мои лекарства"
            )
        ),
        Pictogram(
            id = "med_allergy",
            category = PictogramCategory.MEDICAL,
            iconName = "Warning",
            translations = mapOf(
                "en" to "I am allergic",
                "fr" to "Je suis allergique",
                "ar" to "عندي حساسية شديدة",
                "es" to "Tengo una alergia grave",
                "de" to "Ich bin allergisch",
                "it" to "Sono allergico/a",
                "tr" to "Alerjim var",
                "ja" to "アレルギーがあります",
                "zh" to "我有过敏症",
                "ru" to "У меня аллергия"
            )
        ),
        Pictogram(
            id = "med_ambulance",
            category = PictogramCategory.MEDICAL,
            iconName = "MedicalServices",
            translations = mapOf(
                "en" to "Please call an ambulance",
                "fr" to "Veuillez appeler une ambulance",
                "ar" to "الرجاء الاتصال ببرج الإسعاف",
                "es" to "Por favor llame a una ambulancia",
                "de" to "Bitte rufen Sie einen Krankenwagen",
                "it" to "Per favore chiamate un'ambulanza",
                "tr" to "Lütfen ambulans çağırın",
                "ja" to "救急車を呼んでください",
                "zh" to "请叫救护车",
                "ru" to "Пожалуйста, вызовите скорую"
            )
        ),

        // SAFETY
        Pictogram(
            id = "safe_danger",
            category = PictogramCategory.SAFETY,
            iconName = "ShieldMoon",
            translations = mapOf(
                "en" to "I am in danger",
                "fr" to "Je suis en danger",
                "ar" to "أنا في خطر",
                "es" to "Estoy en peligro",
                "de" to "Ich bin in Gefahr",
                "it" to "Sono in pericolo",
                "tr" to "Tehlikedeyim",
                "ja" to "危険にさらされています",
                "zh" to "我有危险",
                "ru" to "Я в опасности"
            )
        ),
        Pictogram(
            id = "safe_followed",
            category = PictogramCategory.SAFETY,
            iconName = "DirectionsRun",
            translations = mapOf(
                "en" to "Someone is following me",
                "fr" to "Quelqu'un me suit",
                "ar" to "هناك من يتبعني",
                "es" to "Alguien me está siguiendo",
                "de" to "Jemand folgt mir",
                "it" to "Qualcuno mi sta seguendo",
                "tr" to "Biri beni takip ediyor",
                "ja" to "誰かにつけられています",
                "zh" to "有人在跟踪我",
                "ru" to "За мной кто-то следит"
            )
        ),
        Pictogram(
            id = "safe_police",
            category = PictogramCategory.SAFETY,
            iconName = "LocalPolice",
            translations = mapOf(
                "en" to "I need the police",
                "fr" to "J'ai besoin de la police",
                "ar" to "أحتاج للشرطة",
                "es" to "Necesito a la policía",
                "de" to "Ich brauche die Polizei",
                "it" to "Ho bisogno della polizia",
                "tr" to "Polise ihtiyacım var",
                "ja" to "警察が必要です",
                "zh" to "我需要报警",
                "ru" to "Мне нужна полиция"
            )
        ),
        Pictogram(
            id = "safe_lost",
            category = PictogramCategory.SAFETY,
            iconName = "Explore",
            translations = mapOf(
                "en" to "I am lost",
                "fr" to "Je suis perdu(e)",
                "ar" to "أنا تائه",
                "es" to "Estoy perdido/a",
                "de" to "Ich habe mich verlaufen",
                "it" to "Mi sono perso/a",
                "tr" to "Kayboldum",
                "ja" to "道に迷いました",
                "zh" to "我迷路了",
                "ru" to "Я заблудился"
            )
        ),
        Pictogram(
            id = "safe_protection",
            category = PictogramCategory.SAFETY,
            iconName = "Security",
            translations = mapOf(
                "en" to "I need a safe place to stay",
                "fr" to "J'ai besoin d'un endroit sûr",
                "ar" to "أحتاج لمكان آمن للإقامة",
                "es" to "Necesito un lugar seguro",
                "de" to "Ich brauche einen sicheren Ort",
                "it" to "Ho bisogno di un posto sicuro",
                "tr" to "Güvenli bir yere ihtiyacım var",
                "ja" to "安全な場所が必要です",
                "zh" to "我需要一个安全的地方",
                "ru" to "Мне нужно безопасное место"
            )
        ),

        // COMMUNICATION
        Pictogram(
            id = "comm_language",
            category = PictogramCategory.COMMUNICATION,
            iconName = "Translate",
            translations = mapOf(
                "en" to "I do not speak this language",
                "fr" to "Je ne parle pas cette langue",
                "ar" to "لا أتحدث هذه اللغة",
                "es" to "No hablo este idioma",
                "de" to "Ich spreche diese Sprache nicht",
                "it" to "Non parlo questa lingua",
                "tr" to "Bu dili konuşamıyorum",
                "ja" to "この言語が話せません",
                "zh" to "我不会说这种语言",
                "ru" to "Я не говорю на этом языке"
            )
        ),
        Pictogram(
            id = "comm_slowly",
            category = PictogramCategory.COMMUNICATION,
            iconName = "RecordVoiceOver",
            translations = mapOf(
                "en" to "Please speak slowly",
                "fr" to "Parlez lentement s'il vous plaît",
                "ar" to "تحدث ببطء من فضلك",
                "es" to "Por favor hable despacio",
                "de" to "Bitte sprechen Sie langsam",
                "it" to "Parla lentamente per favore",
                "tr" to "Lütfen yavaş konuşun",
                "ja" to "ゆっくり話してください",
                "zh" to "请说慢一点",
                "ru" to "Говорите медленнее, пожалуйста"
            )
        ),
        Pictogram(
            id = "comm_call",
            category = PictogramCategory.COMMUNICATION,
            iconName = "PhoneInTalk",
            translations = mapOf(
                "en" to "Please call my emergency contact",
                "fr" to "Veuillez appeler mon contact d'urgence",
                "ar" to "الرجاء الاتصال برقم طوارئي",
                "es" to "Por favor llame a mi contacto de emergencia",
                "de" to "Bitte rufen Sie meinen Notfallkontakt an",
                "it" to "Per favore chiama il mio contatto di emergenza",
                "tr" to "Acil durum kişimi arayın lütfen",
                "ja" to "緊急連絡先に電話してください",
                "zh" to "请给我的紧急联系人打电话",
                "ru" to "Позвоните моему контактному лицу"
            )
        ),
        Pictogram(
            id = "comm_read",
            category = PictogramCategory.COMMUNICATION,
            iconName = "PhonelinkRing",
            translations = mapOf(
                "en" to "Please read this message on my phone",
                "fr" to "Veuillez lire ce message sur mon téléphone",
                "ar" to "الرجاء قراءة هذه الرسالة على هاتفي",
                "es" to "Por favor lea este mensaje en mi teléfono",
                "de" to "Bitte lesen Sie diese Nachricht auf meinem Telefon",
                "it" to "Per favore leggi questo messaggio sul mio telefono",
                "tr" to "Telefonumdaki bu mesajı okuyun",
                "ja" to "このメッセージをお読みください",
                "zh" to "请阅读我手机上的信息",
                "ru" to "Прочтите сообщение на моем телефоне"
            )
        ),

        // TRAVEL
        Pictogram(
            id = "trv_tourist",
            category = PictogramCategory.TRAVEL,
            iconName = "Luggage",
            translations = mapOf(
                "en" to "I am a foreign tourist",
                "fr" to "Je suis un(e) touriste étranger(ère)",
                "ar" to "أنا سائح أجنبي",
                "es" to "Soy un/a turista extranjero/a",
                "de" to "Ich bin ein ausländischer Tourist",
                "it" to "Sono un/a turista straniero/a",
                "tr" to "Yabancı bir turistim",
                "ja" to "外国人旅行者です",
                "zh" to "我是外国游客",
                "ru" to "Я иностранный турист"
            )
        ),
        Pictogram(
            id = "trv_hotel",
            category = PictogramCategory.TRAVEL,
            iconName = "Hotel",
            translations = mapOf(
                "en" to "Help me find my hotel / address",
                "fr" to "Aidez-moi à trouver mon hôtel / adresse",
                "ar" to "ساعدني في العثور على فندقي / عنواني",
                "es" to "Ayúdeme a encontrar mi hotel / dirección",
                "de" to "Helfen Sie mir mein Hotel / Adresse zu finden",
                "it" to "Aiutami a trovare il mio hotel / indirizzo",
                "tr" to "Otelimi / adresimi bulmama yardım edin",
                "ja" to "ホテル／住所を探すのを手伝ってください",
                "zh" to "请帮我找我的酒店/地址",
                "ru" to "Помогите найти мой отель / адрес"
            )
        ),
        Pictogram(
            id = "trv_passport",
            category = PictogramCategory.TRAVEL,
            iconName = "Badge",
            translations = mapOf(
                "en" to "I lost my passport / documents",
                "fr" to "J'ai perdu mon passeport / mes documents",
                "ar" to "فقدت جواز السفر / وثائقي",
                "es" to "Perdí mi pasaporte / documentos",
                "de" to "Ich habe meinen Pass / Dokumente verloren",
                "it" to "Ho perso il passaporto / i documenti",
                "tr" to "Pasaportumu / belgelerimi kaybettim",
                "ja" to "パスポート／書類を紛失しました",
                "zh" to "我的护照/文件丢失了",
                "ru" to "Я потерял паспорт / документы"
            )
        ),
        Pictogram(
            id = "trv_embassy",
            category = PictogramCategory.TRAVEL,
            iconName = "AccountBalance",
            translations = mapOf(
                "en" to "I need to reach my embassy",
                "fr" to "J'ai besoin de contacter mon ambassade",
                "ar" to "أحتاج للوصول إلى سفارة بلدي",
                "es" to "Necesito contactar a mi embajada",
                "de" to "Ich muss meine Botschaft erreichen",
                "it" to "Devo contattare la mia ambasciata",
                "tr" to "Elçiliğime ulaşmam gerekiyor",
                "ja" to "大使館に連絡する必要があります",
                "zh" to "我需要联系使馆",
                "ru" to "Мне нужно связаться с посольством"
            )
        ),

        // PERSONAL NEEDS
        Pictogram(
            id = "prs_water",
            category = PictogramCategory.PERSONAL,
            iconName = "WaterDrop",
            translations = mapOf(
                "en" to "I need drinking water",
                "fr" to "J'ai besoin d'eau potable",
                "ar" to "أحتاج ماء شرب",
                "es" to "Necesito agua para beber",
                "de" to "Ich brauche Trinkwasser",
                "it" to "Ho bisogno di acqua da bere",
                "tr" to "İçme suyuna ihtiyacım var",
                "ja" to "飲み水が必要です",
                "zh" to "我需要饮用水",
                "ru" to "Мне нужна питьевая вода"
            )
        ),
        Pictogram(
            id = "prs_food",
            category = PictogramCategory.PERSONAL,
            iconName = "Restaurant",
            translations = mapOf(
                "en" to "I need food / something to eat",
                "fr" to "J'ai besoin de nourriture",
                "ar" to "أحتاج طعاماً",
                "es" to "Necesito comida",
                "de" to "Ich brauche etwas zu essen",
                "it" to "Ho bisogno di cibo",
                "tr" to "Yiyeceğe ihtiyacım var",
                "ja" to "食べ物が必要です",
                "zh" to "我需要食物",
                "ru" to "Мне нужна еда"
            )
        ),
        Pictogram(
            id = "prs_restroom",
            category = PictogramCategory.PERSONAL,
            iconName = "Wc",
            translations = mapOf(
                "en" to "Where is the restroom / bathroom?",
                "fr" to "Où sont les toilettes ?",
                "ar" to "أين دورة المياه / الحمام؟",
                "es" to "¿Dónde está el baño?",
                "de" to "Wo ist die Toilette?",
                "it" to "Dov'è il bagno?",
                "tr" to "Tuvalet nerededir?",
                "ja" to "お手洗いはどこですか？",
                "zh" to "洗手间在哪里？",
                "ru" to "Где находится туалет?"
            )
        ),
        Pictogram(
            id = "prs_sit",
            category = PictogramCategory.PERSONAL,
            iconName = "Chair",
            translations = mapOf(
                "en" to "I need to sit down and rest",
                "fr" to "J'ai besoin de m'asseoir et me reposer",
                "ar" to "أحتاج للجلوس والراحة قليلاً",
                "es" to "Necesito sentarme y descansar",
                "de" to "Ich muss mich hinsetzen und ausruhen",
                "it" to "Ho bisogno di sedermi e riposare",
                "tr" to "Oturup dinlenmem gerekiyor",
                "ja" to "座って休みたいです",
                "zh" to "我需要坐下休息",
                "ru" to "Мне нужно присесть и отдохнуть"
            )
        )
    )

    fun getByCategory(category: PictogramCategory): List<Pictogram> {
        return pictograms.filter { it.category == category }
    }

    /**
     * Combines multiple selected pictograms into a smooth sentence string.
     */
    fun composeSentence(selectedPictograms: List<Pictogram>, targetLangCode: String): String {
        if (selectedPictograms.isEmpty()) return ""

        val phrases = selectedPictograms.map { it.getText(targetLangCode) }
        
        return when (targetLangCode.lowercase()) {
            "ar" -> phrases.joinToString(separator = " • ")
            "fr" -> phrases.joinToString(separator = ". ") + "."
            else -> phrases.joinToString(separator = ". ") + "."
        }
    }
}
