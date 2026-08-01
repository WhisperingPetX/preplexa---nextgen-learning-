package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.data.local.TestAttemptEntity
import com.example.ui.theme.*
import com.example.ui.viewmodel.MainViewModel
import com.example.ui.viewmodel.Screen
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnalyticsScreen(viewModel: MainViewModel) {
    val attempts by viewModel.allAttempts.collectAsState()

    val totalAttempts = attempts.size
    val avgScore = if (totalAttempts > 0) attempts.map { it.scorePercent }.average().toInt() else 0
    val totalQuestions = attempts.sumOf { it.totalQuestions }

    // Selection Probability Calculation Logic
    // > 70% -> STRONG (Green)
    // 50% - 70% -> MEDIUM (Orange)
    // < 50% -> WEAK (Red)
    val selectionStatus: String
    val statusEmoji: String
    val statusColor: Color
    val statusBg: Color
    val statusBorder: Color
    val probabilityRange: String
    val aiAdvice: String

    if (totalAttempts == 0) {
        selectionStatus = "NOT AVAILABLE"
        statusEmoji = "🔍"
        statusColor = BentoOnSurfaceVariant
        statusBg = BentoSurfaceVariant.copy(alpha = 0.5f)
        statusBorder = BentoSurfaceVariant
        probabilityRange = "Take 1 Test to Unlock"
        aiAdvice = "Complete your first topic or mock test series to generate your real-time AI Selection Probability prediction!"
    } else if (avgScore > 70) {
        selectionStatus = "STRONG"
        statusEmoji = "🟢"
        statusColor = Color(0xFF10B981) // Green
        statusBg = Color(0xFFECFDF5)
        statusBorder = Color(0xFFA7F3D0)
        probabilityRange = "High (85% - 98% Selection Chance)"
        aiAdvice = "🔥 Outstanding performance! Your accuracy is >70%. Maintain your daily revision to secure a top merit rank!"
    } else if (avgScore >= 50) {
        selectionStatus = "MEDIUM"
        statusEmoji = "🟠"
        statusColor = Color(0xFFD97706) // Orange
        statusBg = Color(0xFFFEF3C7)
        statusBorder = Color(0xFFFDE68A)
        probabilityRange = "Moderate (55% - 72% Selection Chance)"
        aiAdvice = "⚡ Good progress! Your accuracy is between 50%-70%. Attempt 5 more medium/tough mock tests to enter the Strong zone!"
    } else {
        selectionStatus = "WEAK"
        statusEmoji = "🔴"
        statusColor = Color(0xFFEF4444) // Red
        statusBg = Color(0xFFFEE2E2)
        statusBorder = Color(0xFFFCA5A5)
        probabilityRange = "Weak (< 45% Selection Chance)"
        aiAdvice = "⚠️ Focus needed! Your current test score is below 50%. Review weak topic notes and re-attempt practice quizzes."
    }

    Scaffold(
        containerColor = BentoBackground,
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("📊 AI Analytics & Report", fontWeight = FontWeight.ExtraBold, fontSize = 18.sp, color = BentoOnSurface)
                    }
                },
                navigationIcon = {
                    Surface(
                        color = BentoSurfaceVariant,
                        shape = CircleShape,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                    ) {
                        IconButton(
                            onClick = { viewModel.navigateToScreen(Screen.HOME) },
                            modifier = Modifier.testTag("back_from_analytics_button")
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
            // --- 1. FUTURISTIC AI PROBABILITY OF SELECTION CARD ---
            item {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.5.dp, if (totalAttempts > 0) statusColor.copy(alpha = 0.5f) else BentoSurfaceVariant),
                    shadowElevation = 6.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        // Header Chip
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                color = BentoPrimaryContainer,
                                border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.3f)),
                                shape = RoundedCornerShape(20.dp)
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("⚡ AI SELECTION PREDICTOR", fontSize = 10.sp, fontWeight = FontWeight.ExtraBold, color = BentoPrimary)
                                }
                            }

                            Text(
                                text = "Real-time Meter",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = BentoOnSurfaceVariant
                            )
                        }

                        // Main Probability Status Display
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Probability of Selection",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = BentoOnSurfaceVariant
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = probabilityRange,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = BentoOnSurface
                                )
                            }
                            
                            Spacer(modifier = Modifier.width(8.dp))

                            // Status Pill (STRONG / MEDIUM / WEAK)
                            Surface(
                                color = statusBg,
                                border = BorderStroke(1.5.dp, statusBorder),
                                shape = RoundedCornerShape(16.dp)
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Text(text = statusEmoji, fontSize = 14.sp)
                                    Text(
                                        text = selectionStatus,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 15.sp,
                                        color = statusColor,
                                        maxLines = 1,
                                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }

                        // Futuristic 3-Zone Probability Meter Bar
                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "🔴 Weak (<50%)",
                                    fontSize = 10.sp,
                                    fontWeight = if (avgScore in 1..49) FontWeight.ExtraBold else FontWeight.Medium,
                                    color = if (avgScore in 1..49) Color(0xFFEF4444) else BentoOnSurfaceVariant
                                )
                                Text(
                                    text = "🟠 Medium (50-70%)",
                                    fontSize = 10.sp,
                                    fontWeight = if (avgScore in 50..70) FontWeight.ExtraBold else FontWeight.Medium,
                                    color = if (avgScore in 50..70) Color(0xFFD97706) else BentoOnSurfaceVariant
                                )
                                Text(
                                    text = "🟢 Strong (>70%)",
                                    fontSize = 10.sp,
                                    fontWeight = if (avgScore > 70) FontWeight.ExtraBold else FontWeight.Medium,
                                    color = if (avgScore > 70) Color(0xFF10B981) else BentoOnSurfaceVariant
                                )
                            }

                            // Colored Zone Bar
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(10.dp)
                                    .clip(RoundedCornerShape(5.dp))
                                    .background(BentoSurfaceVariant)
                            ) {
                                // Red Zone (0-50%)
                                Box(
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .fillMaxHeight()
                                        .background(Color(0xFFEF4444).copy(alpha = if (avgScore < 50 && totalAttempts > 0) 1f else 0.3f))
                                )
                                Spacer(modifier = Modifier.width(2.dp))
                                // Orange Zone (50-70%)
                                Box(
                                    modifier = Modifier
                                        .weight(0.2f)
                                        .fillMaxHeight()
                                        .background(Color(0xFFF59E0B).copy(alpha = if (avgScore in 50..70) 1f else 0.3f))
                                )
                                Spacer(modifier = Modifier.width(2.dp))
                                // Green Zone (70-100%)
                                Box(
                                    modifier = Modifier
                                        .weight(0.3f)
                                        .fillMaxHeight()
                                        .background(Color(0xFF10B981).copy(alpha = if (avgScore > 70) 1f else 0.3f))
                                )
                            }
                        }

                        // AI Futuristic Insight Recommendation Box
                        Surface(
                            color = BentoSurfaceVariant.copy(alpha = 0.4f),
                            border = BorderStroke(1.dp, BentoSurfaceVariant),
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.Top,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Text("💡", fontSize = 16.sp)
                                Text(
                                    text = aiAdvice,
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = BentoOnSurface,
                                    lineHeight = 16.sp
                                )
                            }
                        }
                    }
                }
            }

            // --- 2. FUTURISTIC METRICS GRID ---
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FuturisticMetricTile(
                        modifier = Modifier.weight(1f),
                        title = "Avg. Accuracy",
                        value = if (totalAttempts > 0) "$avgScore%" else "--",
                        subtitle = "Target: >70%",
                        iconEmoji = "🎯",
                        accentColor = BentoGreenBadge
                    )

                    FuturisticMetricTile(
                        modifier = Modifier.weight(1f),
                        title = "Tests Done",
                        value = "$totalAttempts",
                        subtitle = "Mock Tests",
                        iconEmoji = "📝",
                        accentColor = BentoPurpleBadge
                    )

                    FuturisticMetricTile(
                        modifier = Modifier.weight(1f),
                        title = "Questions Solved",
                        value = "$totalQuestions",
                        subtitle = "Total Qs",
                        iconEmoji = "⚡",
                        accentColor = BentoBlueBadge
                    )
                }
            }

            // --- 3. RECENT MOCK TEST LOG TITLE ---
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "📋 Recent Mock Test History",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp,
                        color = BentoOnSurface
                    )
                    Text(
                        text = "$totalAttempts Attempts Logged",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = BentoOnSurfaceVariant
                    )
                }
            }

            // --- 4. ATTEMPTS LOG LIST ---
            if (attempts.isEmpty()) {
                item {
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = BentoSurface,
                        border = BorderStroke(1.dp, BentoSurfaceVariant),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text("📑", fontSize = 32.sp)
                            Text(
                                text = "No Tests Attempted Yet",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 15.sp,
                                color = BentoOnSurface
                            )
                            Text(
                                text = "Go to Library or Home screen to start a practice test and build your AI Selection Probability report!",
                                color = BentoOnSurfaceVariant,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            } else {
                items(attempts) { attempt ->
                    FuturisticAttemptCardItem(attempt = attempt)
                }
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

@Composable
fun FuturisticMetricTile(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    subtitle: String,
    iconEmoji: String,
    accentColor: Color
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(accentColor.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Text(iconEmoji, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = value, fontWeight = FontWeight.ExtraBold, fontSize = 18.sp, color = BentoOnSurface, maxLines = 1, overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis)
            Text(text = title, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface, maxLines = 1, overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis)
            Text(text = subtitle, fontSize = 9.5.sp, fontWeight = FontWeight.Medium, color = BentoOnSurfaceVariant, maxLines = 1, overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis)
        }
    }
}

@Composable
fun FuturisticAttemptCardItem(attempt: TestAttemptEntity) {
    val dateStr = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault()).format(Date(attempt.timestamp))
    
    val (statusLabel, statusColor, statusBg, statusBorder) = when {
        attempt.scorePercent > 70 -> Quadruple("🟢 Strong Impact", Color(0xFF10B981), Color(0xFFECFDF5), Color(0xFFA7F3D0))
        attempt.scorePercent >= 50 -> Quadruple("🟠 Medium Impact", Color(0xFFD97706), Color(0xFFFEF3C7), Color(0xFFFDE68A))
        else -> Quadruple("🔴 Needs Revision", Color(0xFFEF4444), Color(0xFFFEE2E2), Color(0xFFFCA5A5))
    }

    Surface(
        shape = RoundedCornerShape(20.dp),
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        modifier = Modifier
            .fillMaxWidth()
            .testTag("attempt_log_${attempt.id}")
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
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Surface(
                        color = BentoPrimaryContainer,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = attempt.examType,
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = BentoPrimary,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }

                    Surface(
                        color = statusBg,
                        border = BorderStroke(1.dp, statusBorder),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = statusLabel,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = statusColor,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                }

                Text(
                    text = dateStr,
                    fontSize = 10.5.sp,
                    color = BentoOnSurfaceVariant,
                    fontWeight = FontWeight.Medium
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Topic Test #${attempt.testId.takeLast(2)}",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 15.sp,
                        color = BentoOnSurface
                    )
                    Text(
                        text = "Correct: ${attempt.correctCount} / ${attempt.totalQuestions} Questions",
                        fontSize = 11.5.sp,
                        color = BentoOnSurfaceVariant,
                        fontWeight = FontWeight.Medium
                    )
                }

                Surface(
                    color = statusBg,
                    border = BorderStroke(1.dp, statusBorder),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = "${attempt.scorePercent}%",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp,
                        color = statusColor,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}

private data class Quadruple<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)
