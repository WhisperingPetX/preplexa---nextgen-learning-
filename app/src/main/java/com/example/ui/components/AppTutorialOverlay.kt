package com.example.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.ui.theme.*
import kotlinx.coroutines.delay

data class TutorialStep(
    val stepNumber: Int,
    val icon: ImageVector,
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
                icon = Icons.Default.SwapHoriz,
                title = "Target Exam Switcher",
                subtitle = "Switch seamlessly between NEET (UG) & JEE Mains",
                highlights = listOf(
                    "Top header bar lets you toggle NEET & JEE targets instantly.",
                    "All question banks, formulas & mock tests update in real-time.",
                    "Track exam-specific score rank prediction & syllabus progress."
                ),
                targetSectionName = "Exam Switcher",
                badgeColor = BentoPrimary
            ),
            TutorialStep(
                stepNumber = 2,
                icon = Icons.Default.MenuBook,
                title = "Syllabus & Units Library",
                subtitle = "10 Mock Tests per unit with Easy, Medium & Tough difficulty",
                highlights = listOf(
                    "Browse clean NTA Units in the Syllabus tab.",
                    "Filter units by Biology, Physics, Chemistry, or Mathematics.",
                    "Practice 10-question tests with step-by-step AI hints."
                ),
                targetSectionName = "Syllabus Tab",
                badgeColor = BentoPrimary
            ),
            TutorialStep(
                stepNumber = 3,
                icon = Icons.Default.AutoAwesome,
                title = "Perplexa AI 24/7 Solver",
                subtitle = "Snap a photo or type any doubt for instant AI solutions",
                highlights = listOf(
                    "Upload textbook photos or question PDFs directly.",
                    "Powered by Gemini 1.5 Pro for accurate step-by-step explanations.",
                    "Ask follow-up questions anytime from top bar or Bottom Navigation."
                ),
                targetSectionName = "AI Solver",
                badgeColor = BentoPrimary
            ),
            TutorialStep(
                stepNumber = 4,
                icon = Icons.Default.Assignment,
                title = "Real NTA PYQs & Timed Tests",
                subtitle = "10-Year authentic past papers with exam conditions",
                highlights = listOf(
                    "Attempt authentic NEET & JEE papers from last 10 years.",
                    "Timed NTA examination mode with automatic mark sheets.",
                    "Bookmark tricky questions to review before your main exam."
                ),
                targetSectionName = "PYQs Tab",
                badgeColor = BentoPrimary
            ),
            TutorialStep(
                stepNumber = 5,
                icon = Icons.Default.Analytics,
                title = "Analytics & Daily Streaks",
                subtitle = "Track accuracy, claim daily streak badges & rank high",
                highlights = listOf(
                    "Claim daily study attendance badges to build active streaks.",
                    "Detailed accuracy histograms & subject time-management stats.",
                    "Re-open this Guide anytime using the Lightbulb icon in top bar."
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
                .background(Color.Black.copy(alpha = 0.82f))
                .padding(horizontal = 16.dp, vertical = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Surface(
                shape = RoundedCornerShape(28.dp),
                color = BentoSurface,
                border = BorderStroke(1.5.dp, BentoPrimary.copy(alpha = 0.5f)),
                shadowElevation = 16.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 520.dp)
                    .testTag("app_tutorial_overlay_card")
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    // --- 1. HEADER BAR: Step Badge & Skip Button ---
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = RoundedCornerShape(20.dp),
                            color = BentoPrimaryContainer,
                            border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.4f))
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Lightbulb,
                                    contentDescription = null,
                                    tint = BentoPrimary,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = "App Guide • Step ${currentStep.stepNumber} of $totalSteps",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = BentoPrimary
                                )
                            }
                        }

                        TextButton(
                            onClick = onDismiss,
                            modifier = Modifier.testTag("skip_tutorial_button")
                        ) {
                            Text(
                                text = "Skip",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = BentoOnSurfaceVariant
                            )
                        }
                    }

                    // --- 2. PROGRESS BAR ---
                    LinearProgressIndicator(
                        progress = { (currentStepIndex + 1).toFloat() / totalSteps.toFloat() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(6.dp)
                            .clip(RoundedCornerShape(3.dp)),
                        color = BentoPrimary,
                        trackColor = BentoSurfaceVariant
                    )

                    // --- 3. ANIMATED STEP CONTENT CONTAINER ---
                    AnimatedContent(
                        targetState = currentStepIndex,
                        transitionSpec = {
                            if (targetState > initialState) {
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
                    ) { stepIdx ->
                        val step = steps[stepIdx]
                        Column(
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            // --- ANIMATED FEATURE PREVIEW CARD ---
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(130.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(
                                        Brush.verticalGradient(
                                            colors = listOf(
                                                BentoPrimaryContainer.copy(alpha = 0.8f),
                                                BentoSurfaceVariant.copy(alpha = 0.4f)
                                            )
                                        )
                                    )
                                    .border(1.dp, BentoPrimary.copy(alpha = 0.3f), RoundedCornerShape(20.dp))
                                    .padding(12.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                when (step.stepNumber) {
                                    1 -> Step1AnimatedExamPreview()
                                    2 -> Step2AnimatedSyllabusPreview()
                                    3 -> Step3AnimatedAiPreview()
                                    4 -> Step4AnimatedPyqPreview()
                                    5 -> Step5AnimatedStreakPreview()
                                }
                            }

                            // --- TITLE & SUBTITLE ---
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Surface(
                                    shape = CircleShape,
                                    color = BentoPrimaryContainer,
                                    border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.3f)),
                                    modifier = Modifier.size(42.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Icon(
                                            imageVector = step.icon,
                                            contentDescription = null,
                                            tint = BentoPrimary,
                                            modifier = Modifier.size(22.dp)
                                        )
                                    }
                                }

                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = step.title,
                                        fontWeight = FontWeight.Black,
                                        fontSize = 17.sp,
                                        color = BentoOnSurface
                                    )
                                    Text(
                                        text = step.subtitle,
                                        fontSize = 12.sp,
                                        color = BentoOnSurfaceVariant,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            }

                            HorizontalDivider(color = BentoSurfaceVariant)

                            // --- HIGHLIGHT POINTS ---
                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                step.highlights.forEach { point ->
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                                        verticalAlignment = Alignment.Top
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.CheckCircle,
                                            contentDescription = null,
                                            tint = BentoPrimary,
                                            modifier = Modifier
                                                .size(18.dp)
                                                .padding(top = 2.dp)
                                        )
                                        Text(
                                            text = point,
                                            fontSize = 12.5.sp,
                                            color = BentoOnSurface,
                                            lineHeight = 17.sp,
                                            fontWeight = FontWeight.Normal
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // --- 4. STEP INDICATOR PILLS ---
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        steps.forEachIndexed { index, _ ->
                            val isSelected = index == currentStepIndex
                            val pillWidth by animateDpAsState(
                                targetValue = if (isSelected) 26.dp else 8.dp,
                                animationSpec = spring(dampingRatio = 0.7f),
                                label = "pill_width"
                            )
                            Box(
                                modifier = Modifier
                                    .padding(horizontal = 3.dp)
                                    .height(8.dp)
                                    .width(pillWidth)
                                    .clip(CircleShape)
                                    .background(
                                        if (isSelected) BentoPrimary else BentoOnSurfaceVariant.copy(alpha = 0.3f)
                                    )
                                    .clickable { currentStepIndex = index }
                            )
                        }
                    }

                    // --- 5. BOTTOM NAVIGATION ACTION BUTTONS ---
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Back Button
                        OutlinedButton(
                            onClick = {
                                if (currentStepIndex > 0) currentStepIndex--
                            },
                            enabled = currentStepIndex > 0,
                            shape = RoundedCornerShape(14.dp),
                            border = BorderStroke(1.dp, if (currentStepIndex > 0) BentoPrimary.copy(alpha = 0.5f) else BentoSurfaceVariant),
                            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp),
                            modifier = Modifier.testTag("tutorial_prev_button")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Back", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        }

                        // Next / Start Practicing Button
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
                                containerColor = if (currentStepIndex == totalSteps - 1) Color(0xFF059669) else BentoPrimary
                            ),
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                            modifier = Modifier.testTag("tutorial_next_button")
                        ) {
                            if (currentStepIndex == totalSteps - 1) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Start",
                                    tint = Color.White,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Start Learning",
                                    fontSize = 13.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                            } else {
                                Text(
                                    text = "Next",
                                    fontSize = 13.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.width(6.dp))
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

// ==========================================
// ANIMATED PREVIEW SHOWCASES FOR EACH STEP
// ==========================================

@Composable
fun Step1AnimatedExamPreview() {
    var isNeet by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(2000)
            isNeet = !isNeet
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "LIVE INTERACTIVE PREVIEW",
            fontSize = 10.sp,
            fontWeight = FontWeight.Black,
            color = BentoPrimary,
            letterSpacing = 1.sp
        )

        // Animated Switcher Bar
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = BentoSurface,
            border = BorderStroke(1.5.dp, BentoPrimary)
        ) {
            Row(
                modifier = Modifier.padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = if (isNeet) BentoPrimary else Color.Transparent,
                    modifier = Modifier.clickable { isNeet = true }
                ) {
                    Text(
                        text = "NEET (UG)",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isNeet) Color.White else BentoOnSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = if (!isNeet) BentoPrimary else Color.Transparent,
                    modifier = Modifier.clickable { isNeet = false }
                ) {
                    Text(
                        text = "JEE Mains",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (!isNeet) Color.White else BentoOnSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }
            }
        }

        // Active Exam Badge Preview
        AnimatedContent(targetState = isNeet, label = "exam_badge_preview") { neet ->
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = BentoPrimaryContainer,
                border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.3f))
            ) {
                Text(
                    text = if (neet) "Active Target: NEET (720 Marks • Bio, Phy, Chem)" else "Active Target: JEE Main (300 Marks • Math, Phy, Chem)",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = BentoPrimary,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
            }
        }
    }
}

@Composable
fun Step2AnimatedSyllabusPreview() {
    var progress by remember { mutableFloatStateOf(0.2f) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(100)
            if (progress < 0.85f) {
                progress += 0.05f
            } else {
                delay(1200)
                progress = 0.2f
            }
        }
    }

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(150),
        label = "progress"
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Unit 1: Mechanics & Electrostatics",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = BentoOnSurface
            )
            Text(
                text = "${(animatedProgress * 100).toInt()}% Done",
                fontSize = 11.sp,
                fontWeight = FontWeight.ExtraBold,
                color = BentoPrimary
            )
        }

        LinearProgressIndicator(
            progress = { animatedProgress },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = BentoPrimary,
            trackColor = BentoSurfaceVariant
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            listOf("10 Mock Tests", "Easy", "Medium", "Tough").forEach { label ->
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = BentoPrimaryContainer,
                    border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.3f))
                ) {
                    Text(
                        text = label,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = BentoPrimary,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Step3AnimatedAiPreview() {
    val infiniteTransition = rememberInfiniteTransition(label = "ai_scan")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 0.95f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse_scale"
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Surface(
            shape = CircleShape,
            color = BentoPrimary,
            modifier = Modifier
                .size(44.dp)
                .scale(pulseScale)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Default.AutoAwesome,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = BentoSurface,
                border = BorderStroke(1.dp, BentoPrimary)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(text = "Gemini 1.5 Pro AI", fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, color = BentoPrimary)
                    Text(text = "Active 24/7", fontSize = 10.sp, color = Color(0xFF059669), fontWeight = FontWeight.Bold)
                }
            }

            Text(
                text = "\"Step 1: Apply NTA Physics Formula F = qE...\"",
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Medium,
                color = BentoOnSurfaceVariant
            )
        }
    }
}

@Composable
fun Step4AnimatedPyqPreview() {
    var secondsLeft by remember { mutableIntStateOf(10800) } // 3 hours

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            secondsLeft--
        }
    }

    val hours = secondsLeft / 3600
    val minutes = (secondsLeft % 3600) / 60
    val seconds = secondsLeft % 60
    val timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Timer,
                contentDescription = null,
                tint = Color(0xFFE11D48),
                modifier = Modifier.size(18.dp)
            )
            Text(
                text = "NTA EXAM TIMER: $timeString",
                fontSize = 12.5.sp,
                fontWeight = FontWeight.Black,
                color = BentoOnSurface
            )
        }

        Surface(
            shape = RoundedCornerShape(14.dp),
            color = BentoPrimaryContainer,
            border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.4f))
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Past 10-Year Papers", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = BentoPrimary)
                Text("•", fontSize = 11.sp, color = BentoPrimary)
                Text("Instant Scorecard", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = BentoPrimary)
            }
        }
    }
}

@Composable
fun Step5AnimatedStreakPreview() {
    val infiniteTransition = rememberInfiniteTransition(label = "flame_scale")
    val flameScale by infiniteTransition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.25f,
        animationSpec = infiniteRepeatable(
            animation = tween(600, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "flame"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Icon(
                imageVector = Icons.Default.LocalFireDepartment,
                contentDescription = null,
                tint = Color(0xFFD97706),
                modifier = Modifier
                    .size(24.dp)
                    .scale(flameScale)
            )
            Text(
                text = "7-Day Attendance Streak Active!",
                fontSize = 12.5.sp,
                fontWeight = FontWeight.Black,
                color = BentoPrimary
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            listOf("M", "T", "W", "T", "F", "S", "S").forEach { day ->
                Surface(
                    shape = CircleShape,
                    color = BentoPrimary,
                    modifier = Modifier.size(26.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = day,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
