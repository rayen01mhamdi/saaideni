package com.example.sos.data.repository

import com.example.sos.data.model.SurvivalCategory
import com.example.sos.data.model.SurvivalGuideCard

object SurvivalRepository {

    val guides: List<SurvivalGuideCard> = listOf(
        SurvivalGuideCard(
            id = "surv_heart_medical",
            category = SurvivalCategory.MEDICAL,
            iconName = "Favorite",
            titleTranslations = mapOf(
                "en" to "Chest Pain / Heart Attack Emergency",
                "fr" to "Douleur Thoracique / Crise Cardiaque",
                "ar" to "ألم الصدر / الذبحة الصدرية"
            ),
            descriptionTranslations = mapOf(
                "en" to "Sudden crushing chest pain, tightness, radiating pain down left arm or jaw, difficulty breathing.",
                "fr" to "Douleur oppressante au thorax, irradiation dans le bras gauche ou la mâchoire, difficulté à respirer.",
                "ar" to "ألم ضاغط مفاجئ في الصدر، يمتد للذراع الأيسر أو الفك، مع صعوبة في التنفس."
            ),
            firstStepsTranslations = mapOf(
                "en" to listOf(
                    "Call emergency ambulance immediately.",
                    "Have the person sit down in a comfortable semi-upright position.",
                    "Loosen tight clothing around neck and waist.",
                    "Stay calm and reassure the victim."
                ),
                "fr" to listOf(
                    "Appelez immédiatement les secours (ambulance).",
                    "Faites asseoir la personne en position demi-assise.",
                    "Desserrez les vêtements serrés au cou et à la taille.",
                    "Rassurez la personne et évitez tout effort."
                ),
                "ar" to listOf(
                    "اتصل برقم الإسعاف فوراً.",
                    "اجعل المصاب يجلس في وضعية مريحة (نصف جالس).",
                    "فك الملابس الضيقة حول الرقبة والخصر.",
                    "حافظ على الهدوء وطمأنة المصاب."
                )
            ),
            whatToAvoidTranslations = mapOf(
                "en" to listOf(
                    "Do NOT allow the person to walk or exert effort.",
                    "Do NOT leave the person alone if possible.",
                    "Do NOT give food or drink."
                ),
                "fr" to listOf(
                    "Ne laissez PAS la personne faire d'effort ou marcher.",
                    "Ne la laissez PAS seule si possible.",
                    "Ne lui donnez NI à boire NI à manger."
                ),
                "ar" to listOf(
                    "لا تسمح للمصاب بالمشي أو بذل أي مجهود.",
                    "لا تترك المصاب بمفرده إن أمكن.",
                    "لا تمنحه أي طعام أو شراب."
                )
            ),
            whenToCallTranslations = mapOf(
                "en" to "Call immediately if pain lasts more than 2 minutes or occurs with shortness of breath/cold sweat.",
                "fr" to "Appelez immédiatement si la douleur dure plus de 2 minutes ou s'accompagne de sueurs froides.",
                "ar" to "اتصل فوراً إذا استمر الألم أكثر من دقيقتين أو صاحبه ضيق تنفس أو تعرق بارد."
            ),
            readyMessageTranslations = mapOf(
                "en" to "EMERGENCY: Chest pain & breathing difficulty! Please call an ambulance right now!",
                "fr" to "URGENCE : Douleur thoracique et difficulté respiratoire ! Appelez une ambulance immédiatement !",
                "ar" to "طوارئ: ألم شديد بالصدر وصعوبة تنفس! اتصل بالإسعاف فوراً من فضلك!"
            )
        ),
        SurvivalGuideCard(
            id = "surv_choking",
            category = SurvivalCategory.MEDICAL,
            iconName = "MoodBad",
            titleTranslations = mapOf(
                "en" to "Choking Emergency",
                "fr" to "Étouffement / Obstruction",
                "ar" to "الغصة والانسداد التنفسي"
            ),
            descriptionTranslations = mapOf(
                "en" to "Person cannot speak, cough, or breathe due to a blocked airway.",
                "fr" to "La personne ne peut ni parler, ni tousser, ni respirer.",
                "ar" to "المصاب لا يستطيع الكلام أو السعال أو التنفس بسبب انسداد مجرى الهواء."
            ),
            firstStepsTranslations = mapOf(
                "en" to listOf(
                    "Encourage coughing if the person can cough.",
                    "If unable to cough/speak: Give up to 5 sharp back blows between shoulder blades.",
                    "If blows fail: Perform Heimlich maneuver (abdominal thrusts) inwards and upwards.",
                    "Call emergency services if blockage persists."
                ),
                "fr" to listOf(
                    "Encouragez la personne à tousser si elle le peut.",
                    "Si impossible : donnez 5 claques dans le dos entre les omoplates.",
                    "Si inefficace : effectuez 5 compressions abdominales (méthode de Heimlich).",
                    "Appelez les secours si l'obstruction persiste."
                ),
                "ar" to listOf(
                    "شجع المصاب على السعال إذا كان يملك القدرة.",
                    "إذا عجز عن السعال: اضرب 5 ضربات قوية على الظهر بين الكتفين.",
                    "إذا لم تنجح: قم بمناورة هيمليخ (ضغطات سريعة على البطن للداخل ولأعلى).",
                    "اتصل بالطوارئ فوراً إذا استمر الانسداد."
                )
            ),
            whatToAvoidTranslations = mapOf(
                "en" to listOf(
                    "Do NOT slap back if the person is coughing strongly.",
                    "Do NOT try blind finger sweeps in the mouth."
                ),
                "fr" to listOf(
                    "Ne tapez pas dans le dos si la personne tousse avec force.",
                    "Ne mettez pas vos doigts à l'aveugle dans la bouche."
                ),
                "ar" to listOf(
                    "لا تضرب على الظهر إذا كان المصاب يسعل بقوة.",
                    "لا تدخل أصابعك بشكل عشوائي في الفم."
                )
            ),
            whenToCallTranslations = mapOf(
                "en" to "Call emergency immediately if the person turns blue or loses consciousness.",
                "fr" to "Appelez immédiatement si la personne devient bleue ou perd connaissance.",
                "ar" to "اتصل فوراً بالطوارئ إذا تغير لون المصاب للأزرق أو فقد الوعي."
            ),
            readyMessageTranslations = mapOf(
                "en" to "URGENT: Someone is choking and cannot breathe! Need emergency medical help!",
                "fr" to "URGENT : Une personne s'étouffe et ne peut plus respirer ! Aide médicale requise !",
                "ar" to "عاجل: شخص يختنق ولا يستطيع التنفس! أحتاج مساعدة طبية عاجلة!"
            )
        ),
        SurvivalGuideCard(
            id = "surv_fire",
            category = SurvivalCategory.FIRE,
            iconName = "Whatshot",
            titleTranslations = mapOf(
                "en" to "Building Fire Evacuation",
                "fr" to "Incendie et Évacuation de Bâtiment",
                "ar" to "حريق وتصرف عند الإخلاء"
            ),
            descriptionTranslations = mapOf(
                "en" to "Smoke, flames, or fire alarm sounding inside a hotel or building.",
                "fr" to "Fumée, flammes ou alarme incendie dans un hôtel ou bâtiment.",
                "ar" to "دخان أو ألسنة لهب أو إنذار حريق داخل فندق أو مبنى."
            ),
            firstStepsTranslations = mapOf(
                "en" to listOf(
                    "Stay low to the floor beneath smoke.",
                    "Feel door handles before opening: if hot, do NOT open.",
                    "Use stairs ONLY, never elevators.",
                    "Cover nose and mouth with a wet cloth if possible.",
                    "Call emergency fire services as soon as outside."
                ),
                "fr" to listOf(
                    "Restez près du sol sous la fumée.",
                    "Touchez la poignée avant d'ouvrir : si elle est chaude, n'ouvrez pas.",
                    "Prenez UNIQUEMENT les escaliers, jamais l'ascenseur.",
                    "Couvrez le nez et la bouche avec un linge humide si possible.",
                    "Appelez les pompiers dès que vous êtes dehors."
                ),
                "ar" to listOf(
                    "انخفض نحو الأرض لتجنب استنشاق الدخان.",
                    "افحص مقبض الباب قبل فتحه: إذا كان ساخناً، لا تفتحه.",
                    "استخدم السلالم فقط، ولا تستخدم المصاعد إطلاقاً.",
                    "غطِّ أنفك وفمك بقطعة قماش رطبة إن أمكن.",
                    "اتصل بالإطفاء فور خروجك للمكان الآمن."
                )
            ),
            whatToAvoidTranslations = mapOf(
                "en" to listOf(
                    "Do NOT use elevators during a fire.",
                    "Do NOT go back inside for personal belongings."
                ),
                "fr" to listOf(
                    "N'utilisez PAS les ascenseurs en cas d'incendie.",
                    "Ne retournez PAS à l'intérieur pour récupérer des objets."
                ),
                "ar" to listOf(
                    "لا تستخدم المصاعد الكهربائية أبداً أثناء الحريق.",
                    "لا تعد للمبنى مجدداً لجلب أغراض شخصية."
                )
            ),
            whenToCallTranslations = mapOf(
                "en" to "Call fire department immediately upon detecting smoke or fire.",
                "fr" to "Appelez les pompiers immédiatement dès la détection de fumée ou feu.",
                "ar" to "اتصل بالمطافئ فوراً عند تصاعد الدخان أو رؤية النار."
            ),
            readyMessageTranslations = mapOf(
                "en" to "FIRE EMERGENCY! There is a fire in this building. Call the Fire Department!",
                "fr" to "URGENCE INCENDIE ! Il y a un feu dans ce bâtiment. Appelez les pompiers !",
                "ar" to "طوارئ حريق! يوجد حريق في المبنى. اتصل بالمطافئ فوراً!"
            )
        ),
        SurvivalGuideCard(
            id = "surv_road_accident",
            category = SurvivalCategory.ACCIDENT,
            iconName = "MinorCrash",
            titleTranslations = mapOf(
                "en" to "Road Traffic Accident",
                "fr" to "Accident de la Route",
                "ar" to "حادث سير مروري"
            ),
            descriptionTranslations = mapOf(
                "en" to "Vehicle collision, pedestrian struck, or vehicle crash.",
                "fr" to "Collision de véhicule, piéton renversé ou accident de la route.",
                "ar" to "اصطدام سيارة، دهس مارة، أو حادث مروري."
            ),
            firstStepsTranslations = mapOf(
                "en" to listOf(
                    "Ensure your own safety first (hazard lights, step away from moving traffic).",
                    "Call emergency police and ambulance.",
                    "Do NOT move injured victims unless there is immediate threat of fire/explosion.",
                    "Turn off ignition of involved vehicles if safe."
                ),
                "fr" to listOf(
                    "Assurez votre propre sécurité (feux de détresse, écartez-vous de la circulation).",
                    "Appelez la police et l'ambulance.",
                    "Ne déplacez PAS les blessés sauf danger imminent (feu, explosion).",
                    "Coupez le contact des véhicules accidentés si possible."
                ),
                "ar" to listOf(
                    "تأكد من سلامتك الشخصية أولاً (أنوار التحذير، الابتعاد عن الطريق).",
                    "اتصل بالشرطة والإسعاف.",
                    "لا تحرك المصابين إلا في حالة الخطر الداهم كالإنفجار أو الحريق.",
                    "إيقاف محرك السيارات المتضررة إن أمكن."
                )
            ),
            whatToAvoidTranslations = mapOf(
                "en" to listOf(
                    "Do NOT remove a motorcyclist's helmet.",
                    "Do NOT leave the scene until emergency responders arrive."
                ),
                "fr" to listOf(
                    "Ne retirez PAS le casque d'un motard.",
                    "Ne quittez pas les lieux avant l'arrivée des secours."
                ),
                "ar" to listOf(
                    "لا تخلع خوذة سائق الدراجة النارية.",
                    "لا تغادر موقع الحادث قبل وصول الجهات المختصة."
                )
            ),
            whenToCallTranslations = mapOf(
                "en" to "Call immediately if anyone is injured or traffic is blocked.",
                "fr" to "Appelez immédiatement si quelqu'un est blessé ou si la voie est bloquée.",
                "ar" to "اتصل فوراً إذا كان هناك مصابون أو تم انسداد الطريق."
            ),
            readyMessageTranslations = mapOf(
                "en" to "ACCIDENT EMERGENCY: Car crash with injuries! Call police and ambulance immediately!",
                "fr" to "URGENCE ACCIDENT : Accident de voiture avec blessés ! Appelez la police et l'ambulance !",
                "ar" to "طوارئ حادث: حادث سيارة يوجد مصابون! اتصل بالشرطة والإسعاف فوراً!"
            )
        ),
        SurvivalGuideCard(
            id = "surv_lost_passport",
            category = SurvivalCategory.DOCUMENTS,
            iconName = "Badge",
            titleTranslations = mapOf(
                "en" to "Lost or Stolen Passport Abroad",
                "fr" to "Perte ou Vol de Passeport à l'Étranger",
                "ar" to "فقدان أو سرقة جواز السفر بالخارج"
            ),
            descriptionTranslations = mapOf(
                "en" to "Missing passport, wallet, visa, or essential identity documents while traveling.",
                "fr" to "Passeport, portefeuille ou documents d'identité perdus ou volés.",
                "ar" to "فقدان أو سرقة جواز السفر أو محفظة الهوية في بلد غريب."
            ),
            firstStepsTranslations = mapOf(
                "en" to listOf(
                    "File an official police report at the nearest local police station.",
                    "Obtain a copy of the police report (needed for embassy and replacement).",
                    "Contact your country's local embassy or consulate.",
                    "Request an Emergency Travel Document (ETD) for returning home."
                ),
                "fr" to listOf(
                    "Faites une déclaration de vol ou perte au commissariat de police le plus proche.",
                    "Demandez un récépissé de police (nécessaire pour l'ambassade).",
                    "Contactez l'ambassade ou le consulat de votre pays.",
                    "Demandez un laissez-passer d'urgence pour rentrer."
                ),
                "ar" to listOf(
                    "قم بعمل بلاغ رسمى لدى أقرب مركز شرطة محلي.",
                    "احصل على نسخة رسمية من محضر الشرطة.",
                    "تواصل مع سفارة أو قنصلية بلدك في الدولة التي تتواجد فيها.",
                    "اطلب إصدار وثيقة سفر اضطرارية للعودة للوطن."
                )
            ),
            whatToAvoidTranslations = mapOf(
                "en" to listOf(
                    "Do NOT delay filing a police report.",
                    "Do NOT pay unauthorized third parties claiming to issue official passports."
                ),
                "fr" to listOf(
                    "Ne tardez pas à faire votre déclaration de police.",
                    "Ne payez pas de tiers non officiels."
                ),
                "ar" to listOf(
                    "لا تتأخر في إبلاغ الشرطة السريع.",
                    "لا تدفع مبالغ لأي سماسرة يدعون إصدار وثائق رسمية."
                )
            ),
            whenToCallTranslations = mapOf(
                "en" to "Contact police immediately upon discovering loss, and embassy during business hours.",
                "fr" to "Contactez la police immédiatement après la perte, puis l'ambassade.",
                "ar" to "تواصل مع الشرطة فور اكتشاف الفقد ثم تواصل مع السفارة."
            ),
            readyMessageTranslations = mapOf(
                "en" to "I lost my passport and documents. Where is the police station or my country's embassy?",
                "fr" to "J'ai perdu mon passeport et mes papiers. Où est le commissariat ou l'ambassade de mon pays ?",
                "ar" to "فقدت جواز سفري ووثائقي. أين أقرب مركز شرطة أو سفارة لبلدي؟"
            )
        )
    )

    fun getByCategory(category: SurvivalCategory): List<SurvivalGuideCard> {
        return guides.filter { it.category == category }
    }
}
