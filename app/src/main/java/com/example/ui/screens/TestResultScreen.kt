package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.QuestionResultDetail
import com.example.ui.theme.*
import com.example.ui.viewmodel.MainViewModel
import com.example.ui.viewmodel.Screen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.text.style.TextOverflow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestResultScreen(viewModel: MainViewModel) {
    val result by viewModel.latestResult.collectAsState()
    val aiExplanation by viewModel.aiDoubtExplanation.collectAsState()
    val isLoadingAi by viewModel.isLoadingAiDoubt.collectAsState()

    var activeAiQuestionId by remember { mutableStateOf<String?>(null) }
    var solutionFilter by remember { mutableStateOf("ALL") } // "ALL", "INCORRECT", "CORRECT", "SKIPPED"

    val testRes = result ?: return

    val filteredDetails = remember(testRes, solutionFilter) {
        when (solutionFilter) {
            "INCORRECT" -> testRes.questionDetails.filter { !it.isCorrect && it.selectedOptionIndex != null }
            "CORRECT" -> testRes.questionDetails.filter { it.isCorrect }
            "SKIPPED" -> testRes.questionDetails.filter { it.selectedOptionIndex == null }
            else -> testRes.questionDetails
        }
    }

    Scaffold(
        containerColor = BentoBackground,
        topBar = {
            TopAppBar(
                title = { Text("Scorecard & Solutions", fontWeight = FontWeight.ExtraBold, fontSize = 17.sp, color = BentoOnSurface) },
                navigationIcon = {
                    Surface(
                        color = BentoSurfaceVariant,
                        shape = CircleShape,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                    ) {
                        IconButton(
                            onClick = { viewModel.navigateToScreen(Screen.HOME) },
                            modifier = Modifier.testTag("back_to_dashboard_button")
                        ) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = BentoOnSurface)
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BentoBackground
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // --- 1. Bento Scorecard Hero Card ---
            item {
                Surface(
                    shape = RoundedCornerShape(28.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                    modifier = Modifier.fillMaxWidth().padding(top = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = testRes.topicTitle,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp,
                            color = BentoOnSurface,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )

                        // Bento Circular Score Percentage
                        Box(
                            modifier = Modifier
                                .size(114.dp)
                                .clip(CircleShape)
                                .background(
                                    Brush.sweepGradient(
                                        if (testRes.scorePercent >= 70)
                                            listOf(BentoGreenBadge, Color(0xFF34D399), BentoGreenBadge)
                                        else if (testRes.scorePercent >= 40)
                                            listOf(Color(0xFF825500), Color(0xFFFBBF24), Color(0xFF825500))
                                        else
                                            listOf(BentoPeachBadge, Color(0xFFFB7185), BentoPeachBadge)
                                    )
                                )
                                .padding(6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(CircleShape)
                                    .background(BentoSurface),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = "${testRes.scorePercent}%",
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 26.sp,
                                        color = BentoOnSurface
                                    )
                                    Text(
                                        text = "ACCURACY",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = BentoOnSurfaceVariant
                                    )
                                }
                            }
                        }

                        // Rank Prediction Card
                        RankPredictionCard(testRes = testRes)

                        // Bento Breakdown metrics
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Box(modifier = Modifier.weight(1f)) {
                                ResultMetricItem(
                                    label = "Correct",
                                    value = "${testRes.correctCount}",
                                    color = BentoGreenBadge
                                )
                            }
                            Box(modifier = Modifier.weight(1f)) {
                                ResultMetricItem(
                                    label = "Incorrect",
                                    value = "${testRes.incorrectCount}",
                                    color = BentoPeachBadge
                                )
                            }
                            Box(modifier = Modifier.weight(1f)) {
                                ResultMetricItem(
                                    label = "Skipped",
                                    value = "${testRes.unattemptedCount}",
                                    color = Color(0xFFD97706)
                                )
                            }
                            Box(modifier = Modifier.weight(1f)) {
                                ResultMetricItem(
                                    label = "Time Spent",
                                    value = "${testRes.timeSpentSeconds / 60}m ${testRes.timeSpentSeconds % 60}s",
                                    color = BentoPrimary
                                )
                            }
                        }

                        // Bento Action Buttons Row
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button(
                                onClick = { viewModel.navigateToScreen(Screen.ANALYTICS) },
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                                modifier = Modifier.fillMaxWidth().testTag("view_analytics_button")
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    modifier = Modifier.padding(vertical = 4.dp)
                                ) {
                                    Icon(Icons.Default.Analytics, contentDescription = null, tint = Color.White)
                                    Text("📊 View AI Analysis & Selection Report →", fontWeight = FontWeight.ExtraBold, fontSize = 13.sp)
                                }
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                OutlinedButton(
                                    onClick = {
                                        val test = viewModel.activeTest.value
                                        if (test != null) viewModel.startMockTest(test)
                                    },
                                    shape = RoundedCornerShape(16.dp),
                                    modifier = Modifier.weight(1f).testTag("retake_test_button")
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(16.dp), tint = BentoOnSurface)
                                        Text("Retake Test", fontWeight = FontWeight.Bold, color = BentoOnSurface)
                                    }
                                }

                                OutlinedButton(
                                    onClick = { viewModel.navigateToScreen(Screen.HOME) },
                                    shape = RoundedCornerShape(16.dp),
                                    modifier = Modifier.weight(1f).testTag("done_result_button")
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Icon(Icons.Default.Home, contentDescription = null, modifier = Modifier.size(16.dp), tint = BentoOnSurface)
                                        Text("Dashboard", fontWeight = FontWeight.Bold, color = BentoOnSurface)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // --- 2. Solutions Breakdown Header & Filter Chips ---
            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "Step-by-Step Solutions & Explanations",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp,
                        color = BentoOnSurface
                    )

                    // Scrollable Filter Chips Row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        FilterChip(
                            selected = solutionFilter == "ALL",
                            onClick = { solutionFilter = "ALL" },
                            label = { Text("All (${testRes.questionDetails.size})", fontWeight = FontWeight.Bold, fontSize = 12.sp) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = BentoPrimary,
                                selectedLabelColor = Color.White
                            )
                        )

                        FilterChip(
                            selected = solutionFilter == "INCORRECT",
                            onClick = { solutionFilter = "INCORRECT" },
                            label = { Text("❌ Wrong (${testRes.incorrectCount})", fontWeight = FontWeight.Bold, fontSize = 12.sp) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = BentoPeachBadge,
                                selectedLabelColor = Color.White
                            )
                        )

                        FilterChip(
                            selected = solutionFilter == "CORRECT",
                            onClick = { solutionFilter = "CORRECT" },
                            label = { Text("✅ Right (${testRes.correctCount})", fontWeight = FontWeight.Bold, fontSize = 12.sp) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = BentoGreenBadge,
                                selectedLabelColor = Color.White
                            )
                        )

                        FilterChip(
                            selected = solutionFilter == "SKIPPED",
                            onClick = { solutionFilter = "SKIPPED" },
                            label = { Text("⚪ Skipped (${testRes.unattemptedCount})", fontWeight = FontWeight.Bold, fontSize = 12.sp) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Color(0xFFD97706),
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                }
            }

            // --- 3. Question Solutions List ---
            itemsIndexed(filteredDetails) { qIndex, detail ->
                val q = detail.question
                val isBookmarked by viewModel.isBookmarked(q.id).collectAsState(initial = false)
                val isAiActive = activeAiQuestionId == q.id

                Surface(
                    shape = RoundedCornerShape(28.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                    modifier = Modifier.fillMaxWidth().testTag("solution_card_${qIndex + 1}")
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Surface(
                                    color = if (detail.isCorrect) BentoGreenBg
                                    else if (detail.selectedOptionIndex == null) BentoSurfaceVariant
                                    else BentoPeachBg,
                                    border = BorderStroke(1.dp,
                                        if (detail.isCorrect) BentoGreenBorder
                                        else if (detail.selectedOptionIndex == null) BentoSurfaceVariant
                                        else BentoPeachBorder
                                    ),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Text(
                                        text = if (detail.isCorrect) "✓ Correct"
                                        else if (detail.selectedOptionIndex == null) "⚪ Skipped"
                                        else "✗ Incorrect",
                                        color = if (detail.isCorrect) BentoGreenText
                                        else if (detail.selectedOptionIndex == null) BentoOnSurfaceVariant
                                        else BentoPeachText,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 11.sp,
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                    )
                                }

                                Text(
                                    text = "Q${qIndex + 1}",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 14.sp,
                                    color = BentoOnSurface
                                )
                            }

                            Surface(
                                color = BentoSurfaceVariant,
                                shape = CircleShape
                            ) {
                                IconButton(onClick = { viewModel.toggleBookmark(q) }) {
                                    Icon(
                                        imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Outlined.Bookmark,
                                        contentDescription = "Bookmark",
                                        tint = if (isBookmarked) BentoPeachBadge else BentoOnSurfaceVariant
                                    )
                                }
                            }
                        }

                        Text(
                            text = q.text,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            lineHeight = 22.sp,
                            color = BentoOnSurface
                        )

                        // Bento Options comparison
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            val optionLabels = listOf("A", "B", "C", "D")
                            q.options.forEachIndexed { optIdx, optText ->
                                val isCorrectOpt = optIdx == q.correctOptionIndex
                                val isSelectedOpt = optIdx == detail.selectedOptionIndex

                                val optBg = when {
                                    isCorrectOpt -> BentoGreenBg
                                    isSelectedOpt -> BentoPeachBg
                                    else -> BentoSurface
                                }

                                val optBorder = when {
                                    isCorrectOpt -> BorderStroke(1.5.dp, BentoGreenBadge)
                                    isSelectedOpt -> BorderStroke(1.5.dp, BentoPeachBadge)
                                    else -> BorderStroke(1.dp, BentoSurfaceVariant)
                                }

                                Surface(
                                    shape = RoundedCornerShape(14.dp),
                                    color = optBg,
                                    border = optBorder,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(
                                        modifier = Modifier.padding(12.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Text(
                                            text = "(${optionLabels.getOrElse(optIdx) { "" }})",
                                            fontWeight = FontWeight.ExtraBold,
                                            fontSize = 12.sp,
                                            color = BentoOnSurface
                                        )
                                        Text(
                                            text = optText,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = BentoOnSurface,
                                            modifier = Modifier.weight(1f)
                                        )
                                        if (isCorrectOpt) {
                                            Icon(Icons.Default.Check, contentDescription = null, tint = BentoGreenBadge, modifier = Modifier.size(16.dp))
                                        } else if (isSelectedOpt) {
                                            Icon(Icons.Default.Close, contentDescription = null, tint = BentoPeachBadge, modifier = Modifier.size(16.dp))
                                        }
                                    }
                                }
                            }
                        }

                        // Static Solution Box
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .background(BentoSurfaceVariant)
                                .padding(14.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = "💡 Explanation & Formula:",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = BentoPrimary
                            )
                            Text(
                                text = q.explanation,
                                fontSize = 12.sp,
                                color = BentoOnSurface,
                                lineHeight = 18.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        // Bento Ask AI Doubt Button
                        Button(
                            onClick = {
                                activeAiQuestionId = q.id
                                viewModel.askAiDoubt(q)
                            },
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = BentoPurpleBadge, contentColor = Color.White),
                            modifier = Modifier.fillMaxWidth().testTag("ask_ai_doubt_${qIndex + 1}")
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp),
                                modifier = Modifier.padding(vertical = 2.dp)
                            ) {
                                Icon(Icons.Outlined.AutoAwesome, contentDescription = null, tint = Color.White)
                                Text("Ask Preplexa AI Mentor Live Doubt", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            }
                        }

                        // AI Explanation Output Area
                        if (isAiActive) {
                            AnimatedVisibility(visible = true) {
                                Surface(
                                    shape = RoundedCornerShape(20.dp),
                                    color = BentoPrimaryContainer,
                                    border = BorderStroke(1.dp, BentoBlueBorder),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(
                                        modifier = Modifier.padding(14.dp),
                                        verticalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                                        ) {
                                            Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = BentoPrimary, modifier = Modifier.size(16.dp))
                                            Text("Preplexa AI Mentor Explanation", fontWeight = FontWeight.ExtraBold, fontSize = 13.sp, color = BentoPrimary)
                                        }

                                        if (isLoadingAi) {
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                                modifier = Modifier.padding(vertical = 8.dp)
                                            ) {
                                                CircularProgressIndicator(modifier = Modifier.size(16.dp), strokeWidth = 2.dp, color = BentoPrimary)
                                                Text("Generating step-by-step mentor solution...", fontSize = 12.sp, color = BentoOnSurface)
                                            }
                                        } else if (aiExplanation != null) {
                                            Text(
                                                text = aiExplanation ?: "",
                                                fontSize = 12.sp,
                                                lineHeight = 18.sp,
                                                color = BentoOnSurface,
                                                fontWeight = FontWeight.Medium
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            item {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "🎯 Finished reviewing solutions? Check your AI Selection Probability & Rank Report!",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = BentoOnSurfaceVariant,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Button(
                                onClick = { viewModel.navigateToScreen(Screen.ANALYTICS) },
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Go to Analytics →", fontWeight = FontWeight.Bold)
                            }
                            OutlinedButton(
                                onClick = { viewModel.navigateToScreen(Screen.HOME) },
                                shape = RoundedCornerShape(16.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Dashboard", fontWeight = FontWeight.Bold, color = BentoOnSurface)
                            }
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

@Composable
fun ResultMetricItem(label: String, value: String, color: Color) {
    Surface(
        color = BentoSurfaceVariant.copy(alpha = 0.5f),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
        ) {
            Text(
                text = value,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 14.sp,
                color = color,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = label,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = BentoOnSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun RankPredictionCard(testRes: com.example.model.TestResult) {
    val marksObtained = maxOf(0, (testRes.correctCount * 4) - (testRes.incorrectCount * 1))
    val maxMarks = maxOf(1, testRes.totalQuestions * 4)
    val ratio = marksObtained.toDouble() / maxMarks.toDouble()

    val totalCandidates = 2400000.0

    val percentile = when {
        ratio >= 0.98 -> 99.99
        ratio >= 0.90 -> 99.0 + (ratio - 0.90) * 12.375
        ratio >= 0.80 -> 97.0 + (ratio - 0.80) * 20.0
        ratio >= 0.70 -> 92.0 + (ratio - 0.70) * 50.0
        ratio >= 0.60 -> 82.0 + (ratio - 0.60) * 100.0
        ratio >= 0.50 -> 68.0 + (ratio - 0.50) * 140.0
        ratio >= 0.40 -> 50.0 + (ratio - 0.40) * 180.0
        else -> maxOf(5.0, ratio * 125.0)
    }.coerceIn(1.0, 99.99)

    val unrankedFraction = (100.0 - percentile) / 100.0
    val predictedAir = maxOf(1, (totalCandidates * unrankedFraction).toInt())
    val predictedStateRank = maxOf(1, (predictedAir / 18.5).toInt())

    val formattedAir = java.text.NumberFormat.getIntegerInstance(java.util.Locale.US).format(predictedAir)
    val formattedState = java.text.NumberFormat.getIntegerInstance(java.util.Locale.US).format(predictedStateRank)
    val formattedPercentile = String.format(java.util.Locale.US, "%.2f", percentile)

    val (statusMsg, statusBg, statusText) = when {
        predictedAir <= 1000 -> Triple("🏆 AIR Top 1,000 - AIIMS Delhi / Top GMC Seat", BentoGreenBg, BentoGreenText)
        predictedAir <= 15000 -> Triple("🏥 Govt Medical College (MBBS) Guaranteed!", BentoGreenBg, BentoGreenText)
        predictedAir <= 45000 -> Triple("🩺 State Govt MBBS / Top BDS Seat Eligible", BentoPrimaryContainer, BentoPrimary)
        predictedAir <= 100000 -> Triple("📚 Qualified for NEET All-India & State Counseling", BentoPeachBg, BentoPeachText)
        else -> Triple("💪 Keep Practicing! Retake Test to Boost Rank", BentoPeachBg, BentoPeachText)
    }

    Surface(
        shape = RoundedCornerShape(20.dp),
        color = BentoSurfaceVariant.copy(alpha = 0.4f),
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.EmojiEvents, contentDescription = null, tint = Color(0xFFD97706), modifier = Modifier.size(20.dp))
                    Text(
                        text = "Estimated Rank & NTA Score",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 13.sp,
                        color = BentoOnSurface
                    )
                }
                Surface(
                    color = BentoPrimaryContainer,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "NTA +4 / -1 Scheme",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = BentoPrimary,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }
            }

            // Rank Grid Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                // AIR Rank
                Surface(
                    color = BentoSurface,
                    shape = RoundedCornerShape(14.dp),
                    border = BorderStroke(1.dp, BentoBlueBorder),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("All India Rank", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = BentoOnSurfaceVariant, maxLines = 1, overflow = TextOverflow.Ellipsis)
                        Text("AIR #$formattedAir", fontSize = 13.sp, fontWeight = FontWeight.ExtraBold, color = BentoPrimary, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    }
                }

                // State Rank
                Surface(
                    color = BentoSurface,
                    shape = RoundedCornerShape(14.dp),
                    border = BorderStroke(1.dp, BentoGreenBorder),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("State Rank", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = BentoOnSurfaceVariant, maxLines = 1, overflow = TextOverflow.Ellipsis)
                        Text("#$formattedState", fontSize = 13.sp, fontWeight = FontWeight.ExtraBold, color = BentoGreenBadge, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    }
                }

                // Score / Max Score
                Surface(
                    color = BentoSurface,
                    shape = RoundedCornerShape(14.dp),
                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Marks Scored", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = BentoOnSurfaceVariant, maxLines = 1, overflow = TextOverflow.Ellipsis)
                        Text("$marksObtained/$maxMarks", fontSize = 13.sp, fontWeight = FontWeight.ExtraBold, color = BentoOnSurface, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    }
                }
            }

            // Percentile & Status Banner
            Surface(
                color = statusBg,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = statusMsg,
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
                        color = statusText,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Surface(
                        color = BentoSurface,
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            text = "$formattedPercentile %ile",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 10.sp,
                            color = BentoOnSurface,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }
        }
    }
}

