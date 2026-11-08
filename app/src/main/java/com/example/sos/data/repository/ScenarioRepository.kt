package com.example.sos.data.repository

import com.example.sos.data.model.LostAbroadScenario
import com.example.sos.data.model.ScenarioStep

object ScenarioRepository {

    val scenarios: List<LostAbroadScenario> = listOf(
        LostAbroadScenario(
            id = "scn_passport",
            iconName = "Badge",
            titleTranslations = mapOf(
                "en" to "I lost my passport / ID",
                "fr" to "J'ai perdu mon passeport",
                "ar" to "فقدت جواز السفر / الهوية"
            ),
            subtitleTranslations = mapOf(
                "en" to "Step-by-step emergency instructions to get official travel replacement.",
                "fr" to "Instructions étape par étape pour obtenir un titre de voyage d'urgence.",
                "ar" to "إرشادات خطوة بخطوة للحصول على وثيقة سفر اضطرارية رسمية."
            ),
            steps = listOf(
                ScenarioStep(
                    stepNumber = 1,
                    titleTranslations = mapOf("en" to "Search last known places", "fr" to "Vérifiez vos derniers lieux", "ar" to "افحص أخر أماكن تواجدت فيها"),
                    detailTranslations = mapOf(
                        "en" to "Check hotel room, bags, safe, and recent places visited before assuming stolen.",
                        "fr" to "Vérifiez votre chambre, sac et derniers lieux visités avant de déclarer le vol.",
                        "ar" to "تأكد من غرفة الفندق، الحقائب، الخزنة والمكان الأخير قبل تأكيد السرقة."
                    )
                ),
                ScenarioStep(
                    stepNumber = 2,
                    titleTranslations = mapOf("en" to "File official police report", "fr" to "Déclaration de perte/vol à la police", "ar" to "تحرير محضر في مركز الشرطة"),
                    detailTranslations = mapOf(
                        "en" to "Visit the nearest police station. Show the ready-made message below to police officers.",
                        "fr" to "Rendez-vous au commissariat le plus proche. Montrez le message ci-dessous aux policiers.",
                        "ar" to "توجه لأقرب مركز شرطة. اعرض الرسالة المجهزة بالأسفل على رجال الشرطة."
                    ),
                    actionType = "SHOW_POLICE_MESSAGE"
                ),
                ScenarioStep(
                    stepNumber = 3,
                    titleTranslations = mapOf("en" to "Contact Embassy / Consulate", "fr" to "Contactez votre ambassade", "ar" to "التواصل مع السفارة / القنصلية"),
                    detailTranslations = mapOf(
                        "en" to "Provide the police report copy and photo ID to obtain an Emergency Travel Document (ETD).",
                        "fr" to "Fournissez la déclaration de police et une pièce d'identité pour obtenir un laissez-passer.",
                        "ar" to "قدّم نسخة محضر الشرطة وصورة إثبات شخصية للحصول على وثيقة مرور اضطرارية."
                    )
                )
            ),
            readyMessageTranslations = mapOf(
                "en" to "Hello, I lost my passport and wallet. I need to file an official police report.",
                "fr" to "Bonjour, j'ai perdu mon passeport et portefeuille. Je dois faire une déclaration officielle.",
                "ar" to "مرحباً، فقدت جواز سفري ومحفظتي. أحتاج لكتابة محضر رسمي لدى الشرطة."
            )
        ),
        LostAbroadScenario(
            id = "scn_phone",
            iconName = "PhonelinkErase",
            titleTranslations = mapOf(
                "en" to "I lost my phone / battery died",
                "fr" to "J'ai perdu mon téléphone / batterie vide",
                "ar" to "فقدت هاتفي / نفاذ البطارية"
            ),
            subtitleTranslations = mapOf(
                "en" to "What to do when disconnected from digital maps and banking.",
                "fr" to "Que faire sans accès à vos cartes et données bancaires.",
                "ar" to "ماذا تفعل عند انقطاعك عن الخرائط والتطبيقات البنكية."
            ),
            steps = listOf(
                ScenarioStep(
                    stepNumber = 1,
                    titleTranslations = mapOf("en" to "Locate hotel or safe hub", "fr" to "Rejoignez un lieu sûr / hôtel", "ar" to "التوجه لفندق أو مكان آمن"),
                    detailTranslations = mapOf(
                        "en" to "Ask a local shop, cafe, or hotel reception to help call a taxi or display directions.",
                        "fr" to "Demandez à une réception d'hôtel ou un commerce de vous aider.",
                        "ar" to "اطلب من الاستقبال في الفندق أو المقهى مساعدتك في طلب سيارة أو الإرشاد."
                    )
                ),
                ScenarioStep(
                    stepNumber = 2,
                    titleTranslations = mapOf("en" to "Show physical Emergency Travel Card", "fr" to "Montrez votre carte d'urgence", "ar" to "إظهار بطاقة السفر الطارئة"),
                    detailTranslations = mapOf(
                        "en" to "If your device is still on Last 5% mode, switch to Travel Card screen immediately.",
                        "fr" to "Si le téléphone a encore de la batterie, affichez votre carte d'urgence.",
                        "ar" to "إذا كان في الهاتف بعض الشحن، افتح شاشة بطاقة طوارئ السفر فوراً."
                    ),
                    actionType = "SHOW_CARD"
                )
            ),
            readyMessageTranslations = mapOf(
                "en" to "My phone battery is dead and I am lost. Can you help me locate this hotel address?",
                "fr" to "Mon téléphone n'a plus de batterie et je suis perdu(e). Pouvez-vous m'aider ?",
                "ar" to "هاتفي منطفئ البطارية وأنا تائه. هل يمكنك مساعدتي في الوصول لهذا العنوان؟"
            )
        ),
        LostAbroadScenario(
            id = "scn_lost_city",
            iconName = "Explore",
            titleTranslations = mapOf(
                "en" to "I am lost in an unfamiliar area",
                "fr" to "Je suis perdu(e) dans la ville",
                "ar" to "أنا تائه في منطقة غير معروفة"
            ),
            subtitleTranslations = mapOf(
                "en" to "Quick guidance to navigate back safely without cellular data.",
                "fr" to "Guide rapide pour retrouver votre chemin sans réseau.",
                "ar" to "إرشادات للعودة بأمان ودون الحاجة لإنترنت."
            ),
            steps = listOf(
                ScenarioStep(
                    stepNumber = 1,
                    titleTranslations = mapOf("en" to "Seek public landmarks", "fr" to "Cherchez un repère public", "ar" to "ابحث عن معالم بارزة"),
                    detailTranslations = mapOf(
                        "en" to "Move towards train stations, metro entrances, major plazas, or hotels.",
                        "fr" to "Rapprochez-vous d'une gare, station de métro, grande place ou hôtel.",
                        "ar" to "توجه نحو محطات القطار، المترو، الميادين الكبيرة أو الفنادق."
                    )
                ),
                ScenarioStep(
                    stepNumber = 2,
                    titleTranslations = mapOf("en" to "Show target destination message", "fr" to "Montrez votre destination", "ar" to "إظهار رسالة الوجهة للآخرين"),
                    detailTranslations = mapOf(
                        "en" to "Show the translation message to a driver or police officer.",
                        "fr" to "Montrez le message de traduction à un chauffeur ou un agent.",
                        "ar" to "اعرض رسالة الترجمة المجهزة لسائق أو لشرطي."
                    )
                )
            ),
            readyMessageTranslations = mapOf(
                "en" to "I am a tourist and I am lost. Please point me towards the nearest transit station or hotel.",
                "fr" to "Je suis un touriste et je suis perdu. Pouvez-vous m'indiquer la station ou l'hôtel ?",
                "ar" to "أنا سائح وأنا تائه. من فضلك دلني على أقرب محطة أو فندق."
            )
        ),
        LostAbroadScenario(
            id = "scn_hospital",
            iconName = "LocalHospital",
            titleTranslations = mapOf(
                "en" to "I need urgent medical care / hospital",
                "fr" to "J'ai besoin d'un hôpital d'urgence",
                "ar" to "أحتاج مستشفى أو رعاية طبية عاجلة"
            ),
            subtitleTranslations = mapOf(
                "en" to "Locate healthcare facilities and explain medical condition instantly.",
                "fr" to "Trouver des soins et expliquer son état sans barrière de la langue.",
                "ar" to "الوصول للمستشفى وإظهار حالتك الصحية بدون عائق اللغة."
            ),
            steps = listOf(
                ScenarioStep(
                    stepNumber = 1,
                    titleTranslations = mapOf("en" to "Trigger Emergency Board", "fr" to "Ouvrez le tableau d'urgence", "ar" to "افتح لوحة الطوارئ الطبية"),
                    detailTranslations = mapOf(
                        "en" to "Use Silent Signal board to combine symptoms (pain, injury, allergic reaction).",
                        "fr" to "Utilisez le tableau Silent Signal pour composer vos symptômes.",
                        "ar" to "استخدم لوحة الإشارات لتأليف أعراضك (ألم، إصابة، حساسية)."
                    ),
                    actionType = "OPEN_BOARD"
                ),
                ScenarioStep(
                    stepNumber = 2,
                    titleTranslations = mapOf("en" to "Show medical notes to doctor", "fr" to "Présentez votre fiche médicale", "ar" to "اعرض ملاحظاتك الطبية للطبيب"),
                    detailTranslations = mapOf(
                        "en" to "Display blood type, allergies, and emergency contact from My Travel Card.",
                        "fr" to "Affichez votre groupe sanguin et allergies depuis votre carte.",
                        "ar" to "اعرض فصيلة الدم، الحساسية، ورقم الطوارئ من بطاقة السفر."
                    )
                )
            ),
            readyMessageTranslations = mapOf(
                "en" to "URGENT MEDICAL: I feel very unwell and need immediate medical assistance or hospital!",
                "fr" to "URGENCE MÉDICALE : Je me sens très mal et j'ai besoin d'un hôpital immédiatement !",
                "ar" to "طوارئ طبية: أشعر بتعب شديد وأحتاج نقل للمستشفى فوراً!"
            )
        )
    )

    fun getById(id: String): LostAbroadScenario? {
        return scenarios.firstOrNull { it.id == id }
    }
}
