package com.example.sos.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sos.core.localization.StringsLocalizer
import com.example.sos.ui.screens.*
import com.example.sos.ui.theme.SilentSignalTheme
import com.example.sos.ui.viewmodel.MainViewModel

sealed class Screen(val route: String, val titleKey: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    object Home : Screen("home", "nav_home", Icons.Default.Home)
    object Board : Screen("board", "nav_board", Icons.Default.TouchApp)
    object Panic : Screen("panic", "nav_panic", Icons.Default.Sos)
    object Survival : Screen("survival", "nav_survival", Icons.Default.ImportContacts)
    object Assistant : Screen("assistant", "nav_assistant", Icons.Default.Assistant)
    object TravelCard : Screen("travel_card", "nav_travel_card", Icons.Default.Badge)
    object CountryDb : Screen("country_db", "country_numbers", Icons.Default.Public)
    object Settings : Screen("settings", "nav_settings", Icons.Default.Settings)
    object Onboarding : Screen("onboarding", "app_name", Icons.Default.Shield)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SilentSignalApp(viewModel: MainViewModel) {
    val appLang by viewModel.appLanguage.collectAsState()
    val targetLang by viewModel.targetLanguage.collectAsState()
    val currentCountry by viewModel.currentCountry.collectAsState()
    val locationData by viewModel.locationData.collectAsState()
    val last5PercentMode by viewModel.last5PercentMode.collectAsState()
    val onboardingCompleted by viewModel.onboardingCompleted.collectAsState()
    val userTravelCard by viewModel.userTravelCard.collectAsState()
    val selectedPictograms by viewModel.selectedPictograms.collectAsState()
    val composedSentence by viewModel.composedSentence.collectAsState()
    val selectedCountryCode by viewModel.selectedCountryCode.collectAsState()

    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route ?: Screen.Home.route

    val layoutDirection = if (appLang == "ar") LayoutDirection.Rtl else LayoutDirection.Ltr

    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
        SilentSignalTheme(last5PercentMode = last5PercentMode) {
            if (last5PercentMode) {
                Last5PercentScreen(
                    targetLang = targetLang,
                    currentCountry = currentCountry,
                    locationData = locationData,
                    userTravelCard = userTravelCard,
                    onExitMode = { viewModel.setLast5PercentMode(false) }
                )
            } else if (!onboardingCompleted) {
                OnboardingScreen(
                    currentAppLang = appLang,
                    onSetAppLanguage = { viewModel.setAppLanguage(it) },
                    onCompleteOnboarding = { viewModel.setOnboardingCompleted(true) }
                )
            } else {
                Scaffold(
                    topBar = {
                        if (currentRoute != Screen.Home.route) {
                            TopAppBar(
                                title = {
                                    val currentScreen = listOf(
                                        Screen.Home, Screen.Board, Screen.Panic, Screen.Survival,
                                        Screen.Assistant, Screen.TravelCard, Screen.CountryDb, Screen.Settings
                                    ).firstOrNull { it.route == currentRoute }

                                    Text(
                                        text = currentScreen?.let { StringsLocalizer.get(it.titleKey, appLang) } ?: StringsLocalizer.get("app_name", appLang)
                                    )
                                },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        navController.navigate(Screen.Home.route) {
                                            popUpTo(Screen.Home.route) { inclusive = true }
                                            launchSingleTop = true
                                        }
                                    }) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                            contentDescription = "Back to Home"
                                        )
                                    }
                                }
                            )
                        }
                    },
                    bottomBar = {
                        NavigationBar {
                            val items = listOf(
                                Screen.Home,
                                Screen.Board,
                                Screen.Panic,
                                Screen.Survival,
                                Screen.TravelCard
                            )
                            items.forEach { screen ->
                                NavigationBarItem(
                                    selected = currentRoute == screen.route,
                                    onClick = {
                                        if (screen.route == Screen.Home.route) {
                                            navController.navigate(Screen.Home.route) {
                                                popUpTo(Screen.Home.route) { inclusive = true }
                                                launchSingleTop = true
                                            }
                                        } else {
                                            navController.navigate(screen.route) {
                                                popUpTo(navController.graph.findStartDestination().id) {
                                                    saveState = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    },
                                    icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                                    label = { Text(text = StringsLocalizer.get(screen.titleKey, appLang)) }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.Home.route) {
                            HomeScreen(
                                appLang = appLang,
                                targetLang = targetLang,
                                currentCountry = currentCountry,
                                locationData = locationData,
                                last5PercentMode = last5PercentMode,
                                onNavigateToBoard = {
                                    navController.navigate(Screen.Board.route) {
                                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onNavigateToPanic = {
                                    navController.navigate(Screen.Panic.route) {
                                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onNavigateToSurvival = {
                                    navController.navigate(Screen.Survival.route) {
                                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onNavigateToAssistant = {
                                    navController.navigate(Screen.Assistant.route)
                                },
                                onNavigateToCountryDb = {
                                    navController.navigate(Screen.CountryDb.route)
                                },
                                onNavigateToSettings = {
                                    navController.navigate(Screen.Settings.route)
                                },
                                onToggleLast5PercentMode = { viewModel.setLast5PercentMode(it) },
                                onCopyLocation = { viewModel.copyToClipboard(it) }
                            )
                        }

                        composable(Screen.Board.route) {
                            SignalBoardScreen(
                                appLang = appLang,
                                targetLang = targetLang,
                                selectedPictograms = selectedPictograms,
                                composedSentence = composedSentence,
                                onTogglePictogram = { viewModel.togglePictogram(it) },
                                onClearPictograms = { viewModel.clearPictograms() },
                                onSetTargetLanguage = { viewModel.setTargetLanguage(it) },
                                onSpeakMessage = { msg, lang -> viewModel.speakMessage(msg, lang) },
                                onCopyMessage = { viewModel.copyToClipboard(it) }
                            )
                        }

                        composable(Screen.Panic.route) {
                            PanicScreen(
                                appLang = appLang,
                                targetLang = targetLang,
                                currentCountry = currentCountry,
                                locationData = locationData,
                                userTravelCard = userTravelCard,
                                onSpeakMessage = { msg, lang -> viewModel.speakMessage(msg, lang) },
                                onCopyMessage = { viewModel.copyToClipboard(it) }
                            )
                        }

                        composable(Screen.Survival.route) {
                            SurvivalGuideScreen(
                                appLang = appLang,
                                targetLang = targetLang,
                                onSpeakMessage = { msg, lang -> viewModel.speakMessage(msg, lang) },
                                onCopyMessage = { viewModel.copyToClipboard(it) }
                            )
                        }

                        composable(Screen.Assistant.route) {
                            LostAbroadScreen(
                                appLang = appLang,
                                targetLang = targetLang,
                                onNavigateToBoard = {
                                    navController.navigate(Screen.Board.route) {
                                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onNavigateToTravelCard = {
                                    navController.navigate(Screen.TravelCard.route) {
                                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onSpeakMessage = { msg, lang -> viewModel.speakMessage(msg, lang) },
                                onCopyMessage = { viewModel.copyToClipboard(it) }
                            )
                        }

                        composable(Screen.TravelCard.route) {
                            TravelCardScreen(
                                appLang = appLang,
                                userTravelCard = userTravelCard,
                                onSaveCard = { viewModel.saveTravelCard(it) },
                                onClearCard = { viewModel.clearTravelCard() }
                            )
                        }

                        composable(Screen.CountryDb.route) {
                            CountryDatabaseScreen(
                                appLang = appLang,
                                selectedCountryCode = selectedCountryCode,
                                onSelectCountry = { viewModel.setSelectedCountryCode(it) }
                            )
                        }

                        composable(Screen.Settings.route) {
                            SettingsScreen(
                                appLang = appLang,
                                targetLang = targetLang,
                                onSetAppLanguage = { viewModel.setAppLanguage(it) },
                                onSetTargetLanguage = { viewModel.setTargetLanguage(it) },
                                onResetOnboarding = { viewModel.setOnboardingCompleted(false) },
                                onClearData = { viewModel.clearTravelCard() }
                            )
                        }
                    }
                }
            }
        }
    }
}
