package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.AppTutorialOverlay
import com.example.ui.components.TrialExpiredPaywallModal
import com.example.ui.screens.*
import com.example.ui.theme.PreplexaTheme
import com.example.ui.viewmodel.MainViewModel
import com.example.ui.viewmodel.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreplexaApp()
        }
    }
}

@Composable
fun PreplexaApp(viewModel: MainViewModel = viewModel()) {
    val isDarkMode by viewModel.isDarkMode.collectAsState()
    val currentScreen by viewModel.currentScreen.collectAsState()
    val showPaywallModal by viewModel.showPaywallModal.collectAsState()
    val showTutorialOverlay by viewModel.showTutorialOverlay.collectAsState()

    PreplexaTheme(darkTheme = isDarkMode) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .widthIn(max = 600.dp)
                ) {
                    androidx.compose.animation.AnimatedVisibility(
                        visible = showTutorialOverlay && currentScreen != Screen.AUTH,
                        enter = androidx.compose.animation.fadeIn(animationSpec = tween(300)) + androidx.compose.animation.scaleIn(initialScale = 0.95f),
                        exit = androidx.compose.animation.fadeOut(animationSpec = tween(300)) + androidx.compose.animation.scaleOut(targetScale = 0.95f)
                    ) {
                        AppTutorialOverlay(
                            onDismiss = { viewModel.dismissTutorial() }
                        )
                    }

                    if (showPaywallModal) {
                        TrialExpiredPaywallModal(
                            viewModel = viewModel,
                            onDismiss = { viewModel.dismissPaywallModal() }
                        )
                    }

                    // Handle back button presses logically
                    BackHandler(enabled = currentScreen != Screen.HOME && currentScreen != Screen.AUTH) {
                        when (currentScreen) {
                            Screen.TOPIC_LIST -> viewModel.navigateToScreen(Screen.HOME)
                            Screen.MOCK_TEST_SERIES_LIST -> viewModel.navigateToScreen(Screen.TOPIC_LIST)
                            Screen.QUIZ_ATTEMPT -> viewModel.navigateToScreen(Screen.MOCK_TEST_SERIES_LIST)
                            Screen.TEST_RESULT -> viewModel.navigateToScreen(Screen.HOME)
                            Screen.BOOKMARKS -> viewModel.navigateToScreen(Screen.HOME)
                            Screen.ANALYTICS -> viewModel.navigateToScreen(Screen.HOME)
                            Screen.PYQ_PAPERS -> viewModel.navigateToScreen(Screen.HOME)
                            Screen.PROFILE -> viewModel.navigateToScreen(Screen.HOME)
                            Screen.PERPLEXA_AI_SOLVER -> viewModel.navigateToScreen(Screen.HOME)
                            Screen.AUTH -> { /* Stay on Auth */ }
                            Screen.HOME -> { /* Exit */ }
                        }
                    }

                    AnimatedContent(
                        targetState = currentScreen,
                        label = "screen_transition"
                    ) { screen ->
                        when (screen) {
                            Screen.HOME -> HomeScreen(viewModel = viewModel)
                            Screen.TOPIC_LIST -> TopicListScreen(viewModel = viewModel)
                            Screen.MOCK_TEST_SERIES_LIST -> MockTestSeriesListScreen(viewModel = viewModel)
                            Screen.QUIZ_ATTEMPT -> QuizAttemptScreen(viewModel = viewModel)
                            Screen.TEST_RESULT -> TestResultScreen(viewModel = viewModel)
                            Screen.BOOKMARKS -> BookmarksScreen(viewModel = viewModel)
                            Screen.ANALYTICS -> AnalyticsScreen(viewModel = viewModel)
                            Screen.PYQ_PAPERS -> PyqPapersScreen(viewModel = viewModel)
                            Screen.PROFILE -> ProfileScreen(viewModel = viewModel)
                            Screen.PERPLEXA_AI_SOLVER -> PerplexaAiSolverScreen(viewModel = viewModel)
                            Screen.AUTH -> AuthScreen(viewModel = viewModel)
                        }
                    }
                }
            }
        }
    }
}
