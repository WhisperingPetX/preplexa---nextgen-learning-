package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
    val rawAvgScore = if (totalAttempts > 0) attempts.map { it.scorePercent }.average().toInt() else 0
    val totalQuestions = attempts.sumOf { it.totalQuestions }

    // --- ANIMATED COUNTERS & PROGRESS ---
    var isLoaded by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        isLoaded = true
    }

    val animatedAvgScore by animateIntAsState(
        targetValue = if (isLoaded) rawAvgScore else 0,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
        label = "avg_score_anim"
    )

    val animatedMeterProgress by animateFloatAsState(
        targetValue = if (isLoaded && totalAttempts > 0) (rawAvgScore / 100f).coerceIn(0f, 1f) else 0f,
        animationSpec = tween(durationMillis = 1200, easing = FastOutSlowInEasing),
        label = "meter_progress_anim"
    )

    // --- MULTI-SELECTION STATE ---
    var isSelectionMode by remember { mutableStateOf(false) }
    val selectedAttemptIds = remember { mutableStateListOf<Long>() }

    // Dialog state
    var showDeleteConfirmDialog by remember { mutableStateOf(false) }
    var singleItemToDelete by remember { mutableStateOf<Long?>(null) }
    var showClearAllDialog by remember { mutableStateOf(false) }

    // Clean Professional Status Colors & Specs (Light Palette)
    val selectionStatus: String
    val statusIcon: ImageVector
    val statusColor: Color
    val statusBg: Color
    val statusBorder: Color
    val probabilityRange: String
    val aiAdvice: String

    if (totalAttempts == 0) {
        selectionStatus = "NOT AVAILABLE"
        statusIcon = Icons.Default.Info
        statusColor = BentoOnSurfaceVariant
        statusBg = BentoSurfaceVariant.copy(alpha = 0.5f)
        statusBorder = BentoSurfaceVariant
        probabilityRange = "Take 1 Test to Unlock Prediction"
        aiAdvice = "Complete your first topic or mock test to generate your AI Selection Probability analysis."
    } else if (rawAvgScore > 70) {
        selectionStatus = "STRONG"
        statusIcon = Icons.Default.CheckCircle
        statusColor = Color(0xFF059669) // Emerald
        statusBg = Color(0xFFECFDF5)
        statusBorder = Color(0xFFA7F3D0)
        probabilityRange = "High (85% - 98% Selection Chance)"
        aiAdvice = "Outstanding performance! Your accuracy is above 70%. Maintain daily topic revision to secure a top merit rank."
    } else if (rawAvgScore >= 50) {
        selectionStatus = "MEDIUM"
        statusIcon = Icons.Default.TrendingUp
        statusColor = Color(0xFFD97706) // Amber
        statusBg = Color(0xFFFFFBEB)
        statusBorder = Color(0xFFFDE68A)
        probabilityRange = "Moderate (55% - 72% Selection Chance)"
        aiAdvice = "Good progress! Accuracy is between 50%-70%. Attempt 5 more medium and tough mock tests to enter the Strong zone."
    } else {
        selectionStatus = "WEAK"
        statusIcon = Icons.Default.Warning
        statusColor = Color(0xFFE11D48) // Soft Rose
        statusBg = Color(0xFFFEF2F2)
        statusBorder = Color(0xFFFCA5A5)
        probabilityRange = "Weak (< 45% Selection Chance)"
        aiAdvice = "Focus needed! Your overall test score is below 50%. Review weak unit notes and re-attempt practice quizzes."
    }

    Scaffold(
        containerColor = BentoBackground,
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Analytics,
                            contentDescription = null,
                            tint = BentoPrimary,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (isSelectionMode) "${selectedAttemptIds.size} Selected" else "AI Analytics & Performance",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp,
                            color = BentoOnSurface
                        )
                    }
                },
                navigationIcon = {
                    Surface(
                        color = BentoSurfaceVariant,
                        shape = CircleShape,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                    ) {
                        IconButton(
                            onClick = {
                                if (isSelectionMode) {
                                    isSelectionMode = false
                                    selectedAttemptIds.clear()
                                } else {
                                    viewModel.navigateToScreen(Screen.HOME)
                                }
                            },
                            modifier = Modifier.testTag("back_from_analytics_button")
                        ) {
                            Icon(
                                imageVector = if (isSelectionMode) Icons.Default.Close else Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = BentoOnSurface
                            )
                        }
                    }
                },
                actions = {
                    if (totalAttempts > 0) {
                        if (isSelectionMode) {
                            // Select All / Deselect All
                            IconButton(
                                onClick = {
                                    if (selectedAttemptIds.size == attempts.size) {
                                        selectedAttemptIds.clear()
                                    } else {
                                        selectedAttemptIds.clear()
                                        selectedAttemptIds.addAll(attempts.map { it.id })
                                    }
                                },
                                modifier = Modifier.testTag("select_all_attempts_button")
                            ) {
                                Icon(
                                    imageVector = if (selectedAttemptIds.size == attempts.size) Icons.Default.Deselect else Icons.Default.SelectAll,
                                    contentDescription = "Select All",
                                    tint = BentoPrimary
                                )
                            }

                            // Delete Selected Button
                            IconButton(
                                onClick = {
                                    if (selectedAttemptIds.isNotEmpty()) {
                                        showDeleteConfirmDialog = true
                                    }
                                },
                                enabled = selectedAttemptIds.isNotEmpty(),
                                modifier = Modifier.testTag("delete_selected_attempts_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete Selected",
                                    tint = if (selectedAttemptIds.isNotEmpty()) Color(0xFFE11D48) else BentoOnSurfaceVariant.copy(alpha = 0.4f)
                                )
                            }
                        } else {
                            // Enable Selection Mode
                            IconButton(
                                onClick = { isSelectionMode = true },
                                modifier = Modifier.testTag("enable_selection_mode_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Checklist,
                                    contentDescription = "Select Attempts",
                                    tint = BentoPrimary
                                )
                            }

                            // Clear All History Button
                            IconButton(
                                onClick = { showClearAllDialog = true },
                                modifier = Modifier.testTag("clear_all_attempts_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.DeleteSweep,
                                    contentDescription = "Clear History",
                                    tint = BentoOnSurfaceVariant
                                )
                            }
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BentoBackground
                )
            )
        },
        bottomBar = {
            ModernBottomNavigationBar(
                currentScreen = Screen.ANALYTICS,
                onNavigate = { viewModel.navigateToScreen(it) }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.TopCenter
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 680.dp)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // --- 1. CLEAN PROFESSIONAL AI SELECTION PREDICTOR CARD ---
                item {
                    Surface(
                        shape = RoundedCornerShape(24.dp),
                        color = BentoSurface,
                        border = BorderStroke(1.dp, if (totalAttempts > 0) statusBorder else BentoSurfaceVariant),
                        shadowElevation = 2.dp,
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
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.AutoAwesome,
                                            contentDescription = null,
                                            tint = BentoPrimary,
                                            modifier = Modifier.size(14.dp)
                                        )
                                        Text(
                                            text = "AI SELECTION PREDICTOR",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = BentoPrimary
                                        )
                                    }
                                }

                                Text(
                                    text = "Real-time Metrics",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = BentoOnSurface
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
                                        fontSize = 13.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = BentoOnSurface
                                    )
                                    Spacer(modifier = Modifier.height(3.dp))
                                    Text(
                                        text = probabilityRange,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Black,
                                        color = if (totalAttempts > 0) statusColor else BentoPrimary
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
                                        Icon(
                                            imageVector = statusIcon,
                                            contentDescription = null,
                                            tint = statusColor,
                                            modifier = Modifier.size(18.dp)
                                        )
                                        Text(
                                            text = selectionStatus,
                                            fontWeight = FontWeight.Black,
                                            fontSize = 15.sp,
                                            color = statusColor
                                        )
                                    }
                                }
                            }

                            // Clean 3-Zone Animated Meter
                            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Weak (<50%)",
                                        fontSize = 11.5.sp,
                                        fontWeight = if (rawAvgScore in 1..49) FontWeight.Black else FontWeight.ExtraBold,
                                        color = if (rawAvgScore in 1..49) Color(0xFFE11D48) else BentoOnSurfaceVariant
                                    )
                                    Text(
                                        text = "Medium (50-70%)",
                                        fontSize = 11.5.sp,
                                        fontWeight = if (rawAvgScore in 50..70) FontWeight.Black else FontWeight.ExtraBold,
                                        color = if (rawAvgScore in 50..70) Color(0xFFD97706) else BentoOnSurfaceVariant
                                    )
                                    Text(
                                        text = "Strong (>70%)",
                                        fontSize = 11.5.sp,
                                        fontWeight = if (rawAvgScore > 70) FontWeight.Black else FontWeight.ExtraBold,
                                        color = if (rawAvgScore > 70) Color(0xFF059669) else BentoOnSurfaceVariant
                                    )
                                }

                                // Animated Smooth Fill Bar
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(10.dp)
                                        .clip(RoundedCornerShape(5.dp))
                                        .background(BentoSurfaceVariant)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .fillMaxWidth(fraction = animatedMeterProgress)
                                            .clip(RoundedCornerShape(5.dp))
                                            .background(statusColor)
                                    )
                                }
                            }

                            // AI Recommendation Card
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
                                    Icon(
                                        imageVector = Icons.Default.Lightbulb,
                                        contentDescription = null,
                                        tint = BentoPrimary,
                                        modifier = Modifier
                                            .size(18.dp)
                                            .padding(top = 1.dp)
                                    )
                                    Text(
                                        text = aiAdvice,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Normal,
                                        color = BentoOnSurface,
                                        lineHeight = 17.sp
                                    )
                                }
                            }
                        }
                    }
                }

                // --- 2. METRICS TILES (Animated Counters & Clean Icons) ---
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        ProfessionalMetricTile(
                            modifier = Modifier.weight(1f),
                            title = "Avg Accuracy",
                            value = if (totalAttempts > 0) "$animatedAvgScore%" else "--",
                            subtitle = "Target: >70%",
                            icon = Icons.Default.Speed,
                            accentColor = Color(0xFF059669)
                        )

                        ProfessionalMetricTile(
                            modifier = Modifier.weight(1f),
                            title = "Tests Done",
                            value = "$totalAttempts",
                            subtitle = "Mock Papers",
                            icon = Icons.Default.Assessment,
                            accentColor = BentoPrimary
                        )

                        ProfessionalMetricTile(
                            modifier = Modifier.weight(1f),
                            title = "Questions",
                            value = "$totalQuestions",
                            subtitle = "Solved Qs",
                            icon = Icons.Default.TaskAlt,
                            accentColor = Color(0xFF2563EB)
                        )
                    }
                }

                // --- 3. RECENT MOCK TEST LOG TITLE BAR ---
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.History,
                                contentDescription = null,
                                tint = BentoPrimary,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Test Attempt History",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 16.sp,
                                color = BentoOnSurface
                            )
                        }

                        if (totalAttempts > 0) {
                            TextButton(
                                onClick = { isSelectionMode = !isSelectionMode },
                                modifier = Modifier.testTag("toggle_selection_mode_button")
                            ) {
                                Text(
                                    text = if (isSelectionMode) "Done" else "Select & Delete",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = BentoPrimary
                                )
                            }
                        }
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
                                modifier = Modifier.padding(28.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Surface(
                                    shape = CircleShape,
                                    color = BentoSurfaceVariant,
                                    modifier = Modifier.size(56.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Icon(
                                            imageVector = Icons.Default.AssignmentLate,
                                            contentDescription = null,
                                            tint = BentoOnSurfaceVariant,
                                            modifier = Modifier.size(28.dp)
                                        )
                                    }
                                }
                                Text(
                                    text = "No Tests Attempted Yet",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 15.sp,
                                    color = BentoOnSurface
                                )
                                Text(
                                    text = "Attempt practice tests from Syllabus or Past Papers to log performance and build your AI report.",
                                    color = BentoOnSurfaceVariant,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                } else {
                    items(attempts, key = { it.id }) { attempt ->
                        val isSelected = selectedAttemptIds.contains(attempt.id)
                        ProfessionalAttemptCardItem(
                            attempt = attempt,
                            isSelectionMode = isSelectionMode,
                            isSelected = isSelected,
                            onToggleSelect = {
                                if (isSelected) {
                                    selectedAttemptIds.remove(attempt.id)
                                } else {
                                    selectedAttemptIds.add(attempt.id)
                                }
                            },
                            onDeleteSingle = {
                                singleItemToDelete = attempt.id
                            }
                        )
                    }
                }

                item { Spacer(modifier = Modifier.height(24.dp)) }
            }
        }
    }

    // --- CONFIRMATION DIALOG FOR DELETING SELECTED ITEMS ---
    if (showDeleteConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteConfirmDialog = false },
            icon = {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = Color(0xFFE11D48)
                )
            },
            title = {
                Text(
                    text = "Delete Selected History?",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            },
            text = {
                Text(
                    text = "Are you sure you want to delete ${selectedAttemptIds.size} selected test attempt record(s)? This action cannot be undone.",
                    fontSize = 13.sp,
                    color = BentoOnSurfaceVariant
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.deleteAttempts(selectedAttemptIds.toSet())
                        selectedAttemptIds.clear()
                        isSelectionMode = false
                        showDeleteConfirmDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE11D48))
                ) {
                    Text("Delete", fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { showDeleteConfirmDialog = false }) {
                    Text("Cancel", fontWeight = FontWeight.Bold)
                }
            }
        )
    }

    // --- CONFIRMATION DIALOG FOR SINGLE ITEM DELETE ---
    singleItemToDelete?.let { attemptId ->
        AlertDialog(
            onDismissRequest = { singleItemToDelete = null },
            icon = {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = Color(0xFFE11D48)
                )
            },
            title = {
                Text(
                    text = "Delete Test Record?",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            },
            text = {
                Text(
                    text = "Do you want to delete this test attempt record from your history?",
                    fontSize = 13.sp,
                    color = BentoOnSurfaceVariant
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.deleteAttempt(attemptId)
                        singleItemToDelete = null
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE11D48))
                ) {
                    Text("Delete", fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { singleItemToDelete = null }) {
                    Text("Cancel", fontWeight = FontWeight.Bold)
                }
            }
        )
    }

    // --- CONFIRMATION DIALOG FOR CLEAR ALL HISTORY ---
    if (showClearAllDialog) {
        AlertDialog(
            onDismissRequest = { showClearAllDialog = false },
            icon = {
                Icon(
                    imageVector = Icons.Default.DeleteSweep,
                    contentDescription = null,
                    tint = Color(0xFFE11D48)
                )
            },
            title = {
                Text(
                    text = "Clear Entire Attempt History?",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            },
            text = {
                Text(
                    text = "This will permanently delete all logged test attempts and reset your accuracy metrics. Are you sure?",
                    fontSize = 13.sp,
                    color = BentoOnSurfaceVariant
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.clearAllAttemptsHistory()
                        selectedAttemptIds.clear()
                        isSelectionMode = false
                        showClearAllDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE11D48))
                ) {
                    Text("Clear All", fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { showClearAllDialog = false }) {
                    Text("Cancel", fontWeight = FontWeight.Bold)
                }
            }
        )
    }
}

@Composable
fun ProfessionalMetricTile(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    subtitle: String,
    icon: ImageVector,
    accentColor: Color
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        shadowElevation = 1.dp
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .clip(CircleShape)
                    .background(accentColor.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = accentColor,
                    modifier = Modifier.size(18.dp)
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = value,
                fontWeight = FontWeight.Black,
                fontSize = 18.sp,
                color = BentoOnSurface,
                maxLines = 1
            )
            Text(
                text = title,
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Bold,
                color = BentoOnSurface,
                maxLines = 1
            )
            Text(
                text = subtitle,
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                color = BentoOnSurfaceVariant,
                maxLines = 1
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfessionalAttemptCardItem(
    attempt: TestAttemptEntity,
    isSelectionMode: Boolean,
    isSelected: Boolean,
    onToggleSelect: () -> Unit,
    onDeleteSingle: () -> Unit
) {
    val dateStr = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault()).format(Date(attempt.timestamp))

    val (statusLabel, statusColor, statusBg, statusBorder) = when {
        attempt.scorePercent > 70 -> AttemptStatusSpec("Strong Impact", Color(0xFF059669), Color(0xFFECFDF5), Color(0xFFA7F3D0))
        attempt.scorePercent >= 50 -> AttemptStatusSpec("Medium Impact", Color(0xFFD97706), Color(0xFFFFFBEB), Color(0xFFFDE68A))
        else -> AttemptStatusSpec("Needs Revision", Color(0xFFE11D48), Color(0xFFFEF2F2), Color(0xFFFCA5A5))
    }

    Surface(
        shape = RoundedCornerShape(20.dp),
        color = if (isSelected) BentoPrimaryContainer.copy(alpha = 0.5f) else BentoSurface,
        border = BorderStroke(1.dp, if (isSelected) BentoPrimary else BentoSurfaceVariant),
        shadowElevation = 1.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .combinedClickable(
                onClick = {
                    if (isSelectionMode) {
                        onToggleSelect()
                    }
                },
                onLongClick = {
                    if (!isSelectionMode) {
                        onToggleSelect()
                    }
                }
            )
            .testTag("attempt_log_${attempt.id}")
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Checkbox when in Selection Mode
            AnimatedVisibility(visible = isSelectionMode) {
                Row {
                    Checkbox(
                        checked = isSelected,
                        onCheckedChange = { onToggleSelect() },
                        colors = CheckboxDefaults.colors(checkedColor = BentoPrimary)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
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
                            text = "Topic Test #${attempt.testId.takeLast(4).uppercase()}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.5.sp,
                            color = BentoOnSurface
                        )
                        Text(
                            text = "Score: ${attempt.correctCount} / ${attempt.totalQuestions} Questions Correct",
                            fontSize = 11.5.sp,
                            color = BentoOnSurfaceVariant,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Surface(
                            color = statusBg,
                            border = BorderStroke(1.dp, statusBorder),
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            Text(
                                text = "${attempt.scorePercent}%",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 16.sp,
                                color = statusColor,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                            )
                        }

                        if (!isSelectionMode) {
                            IconButton(
                                onClick = onDeleteSingle,
                                modifier = Modifier.size(32.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.DeleteOutline,
                                    contentDescription = "Delete Attempt",
                                    tint = BentoOnSurfaceVariant.copy(alpha = 0.6f),
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

private data class AttemptStatusSpec(
    val label: String,
    val color: Color,
    val bg: Color,
    val border: Color
)
