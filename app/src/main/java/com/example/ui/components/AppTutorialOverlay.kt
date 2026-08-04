package com.example.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.ui.theme.*

data class TutorialStep(
    val stepNumber: Int,
    val iconEmoji: String,
    val title: String,
    val subtitle: String,
    val highlights: List<String>,
    val targetSectionName: String,
    val badgeColor: Color
)

@Composable
fun AppTutorialOverlay(
    onDismiss: () -> Unit,
    onNavigateToSection: ((String) -> Unit)? = null
) {
    var currentStepIndex by remember { mutableIntStateOf(0) }

    val steps = remember {
        listOf(
            TutorialStep(
                stepNumber = 1,
                iconEmoji = "🎯",
                title = "Target Exam Selection",
                subtitle = "Switch seamlessly between NEET (UG) & JEE Mains",
                highlights = listOf(
                    "Top bar lets you toggle between NEET & JEE syllabus instantly.",
                    "All practice questions, PYQs, and Mock Tests update automatically.",
                    "Daily streak and avatar badges sync with your active exam target."
                ),
                targetSectionName = "Exam Switcher at Top",
                badgeColor = BentoPrimary
            ),
            TutorialStep(
                stepNumber = 2,
                iconEmoji = "📚",
                title = "Syllabus & Units Library",
                subtitle = "Simplified, clear Unit titles & 10 Mock Tests per topic",
                highlights = listOf(
                    "Tap 'Syllabus' on bottom bar to see all official NTA Units.",
                    "Each Unit includes 10 Mock Tests split into Easy, Medium & Tough.",
                    "Filter by Biology 🧬, Physics ⚡, Chemistry 🧪, or Maths 📐."
                ),
                targetSectionName = "Syllabus Tab",
                badgeColor = BentoPrimary
            ),
            TutorialStep(
                stepNumber = 3,
                iconEmoji = "🪐",
                title = "Perplexa AI 24/7 Doubt Solver",
                subtitle = "Instant step-by-step AI solutions for any question",
                highlights = listOf(
                    "Upload a photo 📷 or PDF 📄 of your textbook question.",
                    "Powered by Gemini Pro for crystal-clear step-by-step guidance.",
                    "Available 24/7 directly from Home screen or Navigation bar."
                ),
                targetSectionName = "AI Doubt Solver",
                badgeColor = BentoPrimary
            ),
            TutorialStep(
                stepNumber = 4,
                iconEmoji = "📝",
                title = "Real NTA PYQs & Time-bound Tests",
                subtitle = "Practice previous years' papers with full solution keys",
                highlights = listOf(
                    "Access authentic Past 10 Years' Question Papers.",
                    "Real NTA exam timer mode with instant scorecards & performance analysis.",
                    "Bookmark tricky questions to review before your exam day."
                ),
                targetSectionName = "PYQs Tab",
                badgeColor = BentoPrimary
            ),
            TutorialStep(
                stepNumber = 5,
                iconEmoji = "📊",
                title = "Analytics & Consistency Streaks",
                subtitle = "Track accuracy, claim daily badges & stay focused",
                highlights = listOf(
                    "Claim your Daily Attendance Badges to build study streaks.",
                    "View accuracy histograms & subject-wise time management stats.",
                    "Re-open this App Guide anytime from top bar 💡 button."
                ),
                targetSectionName = "Analytics & Profile",
                badgeColor = BentoPrimary
            )
        )
    }

    val currentStep = steps[currentStepIndex]
    val totalSteps = steps.size

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            dismissOnBackPress = true,
            dismissOnClickOutside = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.78f))
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            Surface(
                shape = RoundedCornerShape(28.dp),
                color = BentoSurface,
                border = BorderStroke(1.5.dp, currentStep.badgeColor.copy(alpha = 0.6f)),
                shadowElevation = 12.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 520.dp)
                    .testTag("app_tutorial_overlay_card")
            ) {
                Column(
                    modifier = Modifier.padding(22.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Header Bar: Guide Badge + Close/Skip
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = RoundedCornerShape(20.dp),
                            color = currentStep.badgeColor.copy(alpha = 0.15f),
                            border = BorderStroke(1.dp, currentStep.badgeColor.copy(alpha = 0.4f))
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Lightbulb,
                                    contentDescription = null,
                                    tint = currentStep.badgeColor,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = "App Guide • Step ${currentStep.stepNumber} of $totalSteps",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = currentStep.badgeColor
                                )
                            }
                        }

                        // Explicit Skip Button in Header
                        TextButton(
                            onClick = onDismiss,
                            modifier = Modifier.testTag("skip_tutorial_button")
                        ) {
                            Text(
                                text = "Skip ✕",
                                fontSize = 12.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = BentoOnSurfaceVariant,
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    // Linear Progress Indicator
                    LinearProgressIndicator(
                        progress = { (currentStepIndex + 1).toFloat() / totalSteps.toFloat() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(6.dp)
                            .clip(RoundedCornerShape(3.dp)),
                        color = currentStep.badgeColor,
                        trackColor = BentoSurfaceVariant
                    )

                    // Animated Step Content
                    AnimatedContent(
                        targetState = currentStep,
                        transitionSpec = {
                            if (targetState.stepNumber > initialState.stepNumber) {
                                (slideInHorizontally { width -> width } + fadeIn()).togetherWith(
                                    slideOutHorizontally { width -> -width } + fadeOut()
                                )
                            } else {
                                (slideInHorizontally { width -> -width } + fadeIn()).togetherWith(
                                    slideOutHorizontally { width -> width } + fadeOut()
                                )
                            }
                        },
                        label = "tutorial_step_transition"
                    ) { step ->
                        Column(
                            verticalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            // Icon + Title Block
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(14.dp)
                            ) {
                                Surface(
                                    shape = CircleShape,
                                    color = step.badgeColor.copy(alpha = 0.15f),
                                    border = BorderStroke(2.dp, step.badgeColor),
                                    modifier = Modifier.size(56.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text(text = step.iconEmoji, fontSize = 28.sp)
                                    }
                                }

                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = step.title,
                                        fontWeight = FontWeight.Black,
                                        fontSize = 19.sp,
                                        color = BentoOnSurface
                                    )
                                    Text(
                                        text = step.subtitle,
                                        fontSize = 12.5.sp,
                                        color = BentoOnSurfaceVariant,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            }

                            HorizontalDivider(color = BentoSurfaceVariant)

                            // Highlight Points
                            Column(
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                step.highlights.forEach { point ->
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                                        verticalAlignment = Alignment.Top
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.CheckCircle,
                                            contentDescription = null,
                                            tint = step.badgeColor,
                                            modifier = Modifier
                                                .size(18.dp)
                                                .padding(top = 2.dp)
                                        )
                                        Text(
                                            text = point,
                                            fontSize = 13.sp,
                                            color = BentoOnSurface,
                                            lineHeight = 18.sp,
                                            fontWeight = FontWeight.Normal
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    // Step Dots Indicator
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        steps.forEachIndexed { index, _ ->
                            Box(
                                modifier = Modifier
                                    .padding(horizontal = 4.dp)
                                    .size(if (index == currentStepIndex) 10.dp else 7.dp)
                                    .clip(CircleShape)
                                    .background(
                                        if (index == currentStepIndex) currentStep.badgeColor else BentoOnSurfaceVariant.copy(alpha = 0.3f)
                                    )
                                    .clickable { currentStepIndex = index }
                            )
                        }
                    }

                    // Action Controls: Back, Skip, Next / Finish
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Previous / Back Button
                        OutlinedButton(
                            onClick = {
                                if (currentStepIndex > 0) currentStepIndex--
                            },
                            enabled = currentStepIndex > 0,
                            shape = RoundedCornerShape(14.dp),
                            border = BorderStroke(1.dp, BentoSurfaceVariant),
                            modifier = Modifier.testTag("tutorial_prev_button")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Back", fontSize = 12.5.sp, fontWeight = FontWeight.Bold)
                        }

                        // Center Skip text button
                        TextButton(
                            onClick = onDismiss,
                            modifier = Modifier.testTag("skip_guide_bottom_button")
                        ) {
                            Text(
                                text = "Skip",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = BentoOnSurfaceVariant
                            )
                        }

                        // Next or Finish Button
                        Button(
                            onClick = {
                                if (currentStepIndex < totalSteps - 1) {
                                    currentStepIndex++
                                } else {
                                    onDismiss()
                                }
                            },
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (currentStepIndex == totalSteps - 1) Color(0xFF10B981) else currentStep.badgeColor
                            ),
                            modifier = Modifier.testTag("tutorial_next_button")
                        ) {
                            if (currentStepIndex == totalSteps - 1) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Start",
                                    tint = Color.White,
                                    modifier = Modifier.size(20.dp)
                                )
                            } else {
                                Text(
                                    text = "Next",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                    contentDescription = "Next",
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
