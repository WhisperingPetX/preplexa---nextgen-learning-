package com.example.ui.screens

import androidx.compose.ui.draw.alpha
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeJoin

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.outlined.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.first
import androidx.compose.runtime.snapshotFlow
import androidx.compose.material3.*
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.*
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import android.content.Context
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.ui.components.ExamEnvironmentBackground
import com.example.R
import com.example.model.BadgeItem
import com.example.model.BadgeRepository
import com.example.model.ExamType
import com.example.ui.theme.*
import com.example.ui.viewmodel.MainViewModel
import com.example.ui.viewmodel.Screen
import java.util.Calendar

fun parseHexColor(hex: String, fallback: Color = BentoPrimary): Color {
    return try {
        Color(android.graphics.Color.parseColor(hex))
    } catch (e: Exception) {
        fallback
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: MainViewModel) {
    val selectedExam by viewModel.selectedExam.collectAsState()
    val supabaseStatus by viewModel.supabaseStatus.collectAsState()
    val studentName by viewModel.studentName.collectAsState()
    val studentAvatar by viewModel.studentAvatar.collectAsState()
    val isDarkMode by viewModel.isDarkMode.collectAsState()
    val appUpdateNotice by viewModel.appUpdateNotice.collectAsState()
    
    var showAllBadgesModal by remember { mutableStateOf(false) }
    var showStreakCalendarModal by remember { mutableStateOf(false) }
    var showBubbleEffect by remember { mutableStateOf(false) }
    
    var isRefreshing by remember { mutableStateOf(false) }
    val refreshScope = rememberCoroutineScope()

    val context = LocalContext.current
    val todayDateKey = remember {
        java.text.SimpleDateFormat("yyyyMMdd", java.util.Locale.getDefault()).format(java.util.Date())
    }
    val badgePrefs = remember(context) { context.getSharedPreferences("daily_badge_prefs", Context.MODE_PRIVATE) }
    var isTodayBadgeClaimed by remember {
        mutableStateOf(badgePrefs.getBoolean("badge_claimed_$todayDateKey", false))
    }

    val todayBadge = remember { com.example.model.MonthlyBadgeManager.getTodayBadge() }
    val monthly30Badges = remember { com.example.model.MonthlyBadgeManager.getCurrentMonth30Badges() }
    val previousBadgeIcon = remember(monthly30Badges, todayBadge) {
        val todayDay = todayBadge.dayOfMonth
        if (todayDay > 1) {
            monthly30Badges.firstOrNull { it.dayOfMonth == todayDay - 1 }?.emojiIcon ?: todayBadge.emojiIcon
        } else {
            todayBadge.emojiIcon
        }
    }

    val currentStreakDays by viewModel.currentStreak.collectAsState()
    val streakDays by viewModel.streakHistory.collectAsState()
    val allAttempts by viewModel.allAttempts.collectAsState()
    val appSessionSeconds by viewModel.appSessionSeconds.collectAsState()
    val phetSessionSeconds by viewModel.phetSessionSeconds.collectAsState()
    val phetDailySeconds by viewModel.phetDailySeconds.collectAsState()

    // Flash/Blink effect animation on exam selection
    val flashAlpha = remember { Animatable(0f) }
    LaunchedEffect(selectedExam) {
        flashAlpha.snapTo(0.6f)
        flashAlpha.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 350, easing = FastOutSlowInEasing)
        )
    }
    
    if (showStreakCalendarModal) {
        StreakCalendarDialog(
            currentStreak = currentStreakDays,
            onDismiss = { showStreakCalendarModal = false }
        )
    }

    // Dynamic personalized greeting based on student name and time of day
    val greetingText = remember(studentName) {
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        when (hour) {
            in 5..11 -> "Good Morning, $studentName!"
            in 12..16 -> "Good Afternoon, $studentName!"
            in 17..21 -> "Good Evening, $studentName!"
            else -> "Night Owl Study Time, $studentName!"
        }
    }

    // Entrance Animation State for Greeting Header
    val greetingAlpha = remember { Animatable(0f) }
    val greetingOffsetY = remember { Animatable(22f) }
    val greetingScale = remember { Animatable(0.95f) }

    LaunchedEffect(Unit) {
        launch {
            greetingAlpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 650, easing = FastOutSlowInEasing)
            )
        }
        launch {
            greetingOffsetY.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 650, easing = FastOutSlowInEasing)
            )
        }
        launch {
            greetingScale.animateTo(
                targetValue = 1f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        }
    }

    // All 36 Badges (1 every 10 days up to 365 days)
    val badges = remember(currentStreakDays) {
        BadgeRepository.getAll36Badges(currentStreakDays = currentStreakDays)
    }

    val unlockedCount = badges.count { it.isUnlocked }

    var showNewsDialog by remember { mutableStateOf(false) }
    val adminNewsList by viewModel.adminNewsList.collectAsState()

    if (showNewsDialog) {
        Dialog(onDismissRequest = { showNewsDialog = false }) {
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = BentoBackground,
                border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.5f)),
                shadowElevation = 8.dp,
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = BentoPrimaryContainer,
                            modifier = Modifier.size(48.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Filled.NotificationsActive,
                                    contentDescription = "News",
                                    tint = BentoPrimary,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                        Text(
                            text = "Examination News",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp,
                            color = BentoOnSurface
                        )
                    }

                    if (adminNewsList.isEmpty()) {
                        Text(
                            text = "No new notifications yet.",
                            fontSize = 14.sp,
                            color = BentoOnSurfaceVariant,
                            modifier = Modifier.padding(16.dp)
                        )
                    } else {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.fillMaxWidth().heightIn(max = 300.dp)
                        ) {
                            items(adminNewsList) { news ->
                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = BentoSurface,
                                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = news,
                                        fontSize = 13.5.sp,
                                        color = BentoOnSurface,
                                        modifier = Modifier.padding(16.dp)
                                    )
                                }
                            }
                        }
                    }

                    Button(
                        onClick = { showNewsDialog = false },
                        colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Close", fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }
            }
        }
    }

    if (showAllBadgesModal) {
        All36BadgesDialog(
            badges = badges,
            unlockedCount = unlockedCount,
            onDismiss = { showAllBadgesModal = false }
        )
    }



    Scaffold(
        containerColor = BentoBackground,
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Surface(
                            modifier = Modifier
                                .size(42.dp)
                                .clip(RoundedCornerShape(14.dp)),
                            color = Color(0xFF0B0F19),
                            border = BorderStroke(1.dp, BentoPrimaryContainer)
                        ) {
                            Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(4.dp)) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_preplexa_logo),
                                    contentDescription = "Preplexa Logo",
                                    tint = Color.Unspecified,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Column {
                            Text(
                                text = "Preplexa",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 20.sp,
                                color = BentoOnSurface
                            )
                            Text(
                                text = "NTA Exam Prep",
                                fontSize = 11.sp,
                                color = BentoOnSurfaceVariant,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                },
                actions = {
                    // Small Streak Badge
                    Surface(
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .clickable { showStreakCalendarModal = true },
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFF331600),
                        border = BorderStroke(1.dp, Color(0xFFFF6D00))
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
                        ) {
                            Text("🔥", fontSize = 14.sp)
                            Text(
                                text = "$currentStreakDays",
                                color = Color(0xFFFF9100),
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp
                            )
                        }
                    }

                    // Global Dark/Light Theme Toggle Button Only
                    IconButton(
                        onClick = { viewModel.toggleDarkMode() },
                        modifier = Modifier
                            .padding(end = 6.dp)
                            .testTag("top_bar_theme_toggle_button")
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = if (isDarkMode) Color(0xFF1E293B) else BentoPrimaryContainer,
                            border = BorderStroke(1.5.dp, if (isDarkMode) Color(0xFF334155) else BentoSurfaceVariant),
                            shadowElevation = 2.dp,
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(if (isDarkMode) "🌙" else "☀️", fontSize = 18.sp)
                            }
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BentoBackground)
            )
        },
        bottomBar = {
            ModernBottomNavigationBar(
                currentScreen = Screen.HOME,
                onNavigate = { viewModel.navigateToScreen(it) }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            ExamEnvironmentBackground(selectedExam = selectedExam)

            PullToRefreshBox(
                isRefreshing = isRefreshing,
                onRefresh = {
                    refreshScope.launch {
                        isRefreshing = true
                        viewModel.refreshAllData()
                        kotlinx.coroutines.delay(1000L)
                        isRefreshing = false
                    }
                },
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .widthIn(max = 680.dp)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 32.dp)
                ) {
            // 0. BROADCAST APP UPDATE BANNER
            if (appUpdateNotice.isNotBlank()) {
                item {
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = Color(0xFFFEF3C7),
                        border = BorderStroke(1.dp, Color(0xFFF59E0B)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text("📢", fontSize = 20.sp)
                            Text(
                                text = appUpdateNotice,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF92400E),
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }

            // 1. ANIMATED GREETING HEADER CARD
            item {
                Surface(
                    shape = RoundedCornerShape(22.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.5.dp, Brush.horizontalGradient(listOf(BentoPrimary.copy(alpha = 0.5f), Color(0xFF10B981).copy(alpha = 0.3f)))),
                    shadowElevation = 3.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                        .graphicsLayer {
                            alpha = greetingAlpha.value
                            translationY = greetingOffsetY.value
                            scaleX = greetingScale.value
                            scaleY = greetingScale.value
                        }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = greetingText,
                                fontWeight = FontWeight.Black,
                                fontSize = 21.sp,
                                color = BentoOnSurface,
                                letterSpacing = (-0.5).sp
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Target Exam Pill
                                Surface(
                                    shape = RoundedCornerShape(20.dp),
                                    color = BentoPrimaryContainer.copy(alpha = 0.8f),
                                    border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.4f))
                                ) {
                                    Text(
                                        text = "🎯 ${selectedExam.displayName}",
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = BentoPrimary,
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                    )
                                }
                            }
                        }

                        // Floating Aesthetic News Notification Bell Button
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .clickable { showNewsDialog = true }
                                .padding(4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = BentoPrimaryContainer,
                                border = BorderStroke(2.dp, Brush.horizontalGradient(listOf(BentoPrimary, Color(0xFF10B981)))),
                                shadowElevation = 4.dp,
                                modifier = Modifier.size(46.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Filled.NotificationsActive,
                                        contentDescription = "News Notifications",
                                        tint = BentoPrimary,
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 2. EXAM SELECTORS (NEET UG & JEE MAINS ONLY)
            item {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "Select Your Target Exam",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp,
                        color = BentoOnSurface
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        // NEET UG CARD
                        ExamCardItem(
                            modifier = Modifier.weight(1f),
                            exam = ExamType.NEET_UG,
                            isSelected = selectedExam == ExamType.NEET_UG,
                            iconEmoji = "🩺",
                            accentColor = Color(0xFF00C853),
                            onClick = {
                                viewModel.selectExam(ExamType.NEET_UG)
                            }
                        )

                        // JEE MAINS CARD
                        ExamCardItem(
                            modifier = Modifier.weight(1f),
                            exam = ExamType.JEE_MAINS,
                            isSelected = selectedExam == ExamType.JEE_MAINS,
                            iconEmoji = "🚀",
                            accentColor = Color(0xFF651FFF),
                            onClick = {
                                viewModel.selectExam(ExamType.JEE_MAINS)
                            }
                        )
                    }
                }
            }

            // TOP COLLEGES GALLERY SECTION
            item {
                TopCollegesGallerySection(selectedExam = selectedExam)
            }

            // 4. STUDENT STUDY ANALYTICS (LIGHT PURPLE THEME)
            item {
                StudentAnalyticsCard(
                    currentStreakDays = currentStreakDays,
                    selectedExam = selectedExam,
                    attempts = allAttempts,
                    appSessionSeconds = appSessionSeconds,
                    phetSessionSeconds = phetSessionSeconds
                )
            }

            // 5. SIMULATOR TIME SPENT (STANDALONE INTERACTIVE GRAPH CARD)
            item {
                SimulatorTimeCard(
                    phetSessionSeconds = phetSessionSeconds,
                    phetDailySeconds = phetDailySeconds
                )
            }

            // 6. PHET INTERACTIVE SIMULATIONS CARD (UNIVERSITY OF COLORADO BOULDER)
            item {
                PhetSimulationsCard(
                    selectedExam = selectedExam,
                    onOpenSimulations = { viewModel.navigateToScreen(Screen.PHET_SIMULATIONS) }
                )
            }
        } // Closes LazyColumn
        } // Closes PullToRefreshBox

        // Exam Switch Flash/Blink Overlay
        if (flashAlpha.value > 0.001f) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        if (selectedExam == ExamType.NEET_UG)
                            Color(0xFF00E676).copy(alpha = flashAlpha.value * 0.35f)
                        else
                            Color(0xFF7C4DFF).copy(alpha = flashAlpha.value * 0.35f)
                    )
            )
        }

        // Rising Pink & Blue Bubbles Effect Overlay on Daily Badge Claim
        RisingBubblesEffect(
            isActive = showBubbleEffect,
            onEffectFinished = { showBubbleEffect = false }
        )
    }
}
}

@Composable
fun DashboardNavTile(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    iconEmoji: String,
    isActive: Boolean,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .clickable { onClick() }
            .testTag("dashboard_nav_${title.lowercase().replace(" ", "_")}"),
        shape = RoundedCornerShape(14.dp),
        color = if (isActive) BentoPrimaryContainer else BentoSurfaceVariant.copy(alpha = 0.4f),
        border = BorderStroke(1.dp, if (isActive) BentoPrimary else BentoSurfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(if (isActive) BentoPrimary.copy(alpha = 0.15f) else BentoSurfaceVariant.copy(alpha = 0.6f)),
                contentAlignment = Alignment.Center
            ) {
                Text(iconEmoji, fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 11.sp,
                color = if (isActive) BentoPrimary else BentoOnSurface,
                maxLines = 1,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = subtitle,
                fontSize = 9.sp,
                color = BentoOnSurfaceVariant,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ExamCardItem(
    modifier: Modifier = Modifier,
    exam: ExamType,
    isSelected: Boolean,
    iconEmoji: String,
    accentColor: Color,
    onClick: () -> Unit
) {
    val borderColor by animateColorAsState(
        targetValue = if (isSelected) accentColor else BentoSurfaceVariant,
        animationSpec = tween(300),
        label = "border"
    )

    val containerColor by animateColorAsState(
        targetValue = if (isSelected) accentColor.copy(alpha = 0.08f) else BentoSurface,
        animationSpec = tween(300),
        label = "container"
    )

    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClick() }
            .testTag("exam_card_${exam.name}"),
        shape = RoundedCornerShape(20.dp),
        color = containerColor,
        border = BorderStroke(if (isSelected) 2.dp else 1.dp, borderColor)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = CircleShape,
                    color = accentColor.copy(alpha = 0.15f),
                    modifier = Modifier.size(40.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(iconEmoji, fontSize = 20.sp)
                    }
                }

                if (isSelected) {
                    Icon(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = "Selected",
                        tint = accentColor,
                        modifier = Modifier.size(22.dp)
                    )
                }
            }

            Column {
                Text(
                    text = exam.displayName,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 15.sp,
                    color = BentoOnSurface
                )
                Text(
                    text = exam.description,
                    fontSize = 11.sp,
                    color = BentoOnSurfaceVariant,
                    lineHeight = 15.sp,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
        }
    }
}

@Composable
fun BadgeCard(badge: BadgeItem, onClick: () -> Unit = {}) {
    val badgeColor = parseHexColor(badge.badgeColorHex)

    Surface(
        modifier = Modifier
            .width(165.dp)
            .defaultMinSize(minHeight = 190.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        color = BentoSurface,
        border = BorderStroke(
            1.dp,
            if (badge.isUnlocked) badgeColor.copy(alpha = 0.6f) else BentoSurfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .padding(14.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = CircleShape,
                    color = if (badge.isUnlocked) badgeColor.copy(alpha = 0.15f) else BentoSurfaceVariant,
                    modifier = Modifier.size(42.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(badge.emojiIcon, fontSize = 20.sp)
                    }
                }

                // Day Milestone Badge Tag
                Surface(
                    color = if (badge.isUnlocked) badgeColor.copy(alpha = 0.15f) else BentoSurfaceVariant,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "DAY ${badge.dayMilestone}",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = if (badge.isUnlocked) badgeColor else BentoOnSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = badge.title,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 13.sp,
                    color = BentoOnSurface,
                    maxLines = 1,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
                Text(
                    text = badge.description,
                    fontSize = 10.sp,
                    color = BentoOnSurfaceVariant,
                    lineHeight = 13.sp,
                    maxLines = 2,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = if (badge.isUnlocked) "UNLOCKED" else "PROGRESS",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (badge.isUnlocked) badgeColor else BentoOnSurfaceVariant
                    )
                    Text(
                        text = badge.progressText,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = BentoOnSurface
                    )
                }

                LinearProgressIndicator(
                    progress = { badge.progressPercent / 100f },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(CircleShape),
                    color = if (badge.isUnlocked) badgeColor else BentoPrimary,
                    trackColor = BentoSurfaceVariant
                )
            }
        }
    }
}

// FULL 36 BADGES MODAL DIALOG
@Composable
fun All36BadgesDialog(
    badges: List<BadgeItem>,
    unlockedCount: Int,
    onDismiss: () -> Unit
) {
    var selectedFilter by remember { mutableStateOf("ALL") } // ALL, UNLOCKED, LOCKED

    val filteredBadges = remember(selectedFilter, badges) {
        when (selectedFilter) {
            "UNLOCKED" -> badges.filter { it.isUnlocked }
            "LOCKED" -> badges.filter { !it.isUnlocked }
            else -> badges
        }
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.88f),
            shape = RoundedCornerShape(28.dp),
            color = BentoBackground,
            border = BorderStroke(1.dp, BentoSurfaceVariant)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text("🏆", fontSize = 28.sp)
                        Column {
                            Text(
                                text = "365-Day Badges Roadmap",
                                fontWeight = FontWeight.Black,
                                fontSize = 18.sp,
                                color = BentoOnSurface
                            )
                            Text(
                                text = "36 Milestones • $unlockedCount/36 Unlocked",
                                fontSize = 12.sp,
                                color = BentoOnSurfaceVariant,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier
                            .size(36.dp)
                            .background(BentoSurfaceVariant, CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = BentoOnSurface,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Filter Tabs
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("ALL" to "All (36)", "UNLOCKED" to "Unlocked ($unlockedCount)", "LOCKED" to "Locked (${36 - unlockedCount})").forEach { (key, label) ->
                        val isSelected = selectedFilter == key
                        Surface(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(12.dp))
                                .clickable { selectedFilter = key },
                            color = if (isSelected) BentoPrimary else BentoSurface,
                            border = BorderStroke(1.dp, if (isSelected) BentoPrimary else BentoSurfaceVariant)
                        ) {
                            Text(
                                text = label,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSelected) Color.White else BentoOnSurface,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Grid of Badges
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 145.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(filteredBadges) { badge ->
                        BadgeCard(badge = badge)
                    }
                }
            }
        }
    }
}

// --- STREAK CALENDAR MODAL ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StreakCalendarDialog(
    currentStreak: Int,
    onDismiss: () -> Unit
) {
    // Generate a list of 30 days starting from current day backwards
    // For visual purposes, we'll simulate a 30-day view where `currentStreak` days are done.
    
    val totalDaysInView = 30
    
    // We will show a simple grid for the last 30 days. Let's assume day 1 to 30.
    // Days <= currentStreak are unlocked/completed, > currentStreak are locked.
    
    androidx.compose.ui.window.Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = BentoBackground,
            border = BorderStroke(1.dp, BentoSurfaceVariant),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "🔥 30-Day Streak Journey",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp,
                    color = BentoOnSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Keep going! You have $currentStreak days active.",
                    fontSize = 12.sp,
                    color = BentoOnSurfaceVariant
                )
                
                Spacer(modifier = Modifier.height(20.dp))
                
                // Calendar Grid for 30 Days
                LazyVerticalGrid(
                    columns = GridCells.Fixed(5), // 5 columns x 6 rows = 30 days
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.height(300.dp)
                ) {
                    items(totalDaysInView) { index ->
                        val dayNumber = index + 1
                        val isUnlocked = dayNumber <= currentStreak
                        
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = if (isUnlocked) Color(0xFFFFE0B2) else BentoSurfaceVariant.copy(alpha = 0.3f),
                            border = BorderStroke(1.dp, if (isUnlocked) Color(0xFFFF9800) else BentoSurfaceVariant),
                            modifier = Modifier.aspectRatio(1f)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                if (isUnlocked) {
                                    Text("🔥", fontSize = 16.sp)
                                    Text(
                                        text = "Day $dayNumber",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFE65100)
                                    )
                                } else {
                                    Icon(
                                        imageVector = Icons.Default.Lock,
                                        contentDescription = "Locked",
                                        tint = BentoOnSurfaceVariant,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Text(
                                        text = "Day $dayNumber",
                                        fontSize = 10.sp,
                                        color = BentoOnSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(20.dp))
                
                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Close", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

data class TopCollege(val name: String, val nirfRank: Int, val topPackage: String, val website: String, val bgColor: Color, val imageUrl: String = "", val info: String = "", val imageRes: Int? = null)

@OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun TopCollegesGallerySection(selectedExam: ExamType) {
    val context = LocalContext.current
    var selectedCollegeForDialog by remember { mutableStateOf<TopCollege?>(null) }

    val colleges = remember(selectedExam) {
        if (selectedExam == ExamType.NEET_UG) {
            listOf(
                TopCollege("AIIMS New Delhi", 1, "₹24 LPA (Stipend)", "aiims.edu", Color(0xFFE3F2FD), "https://pub-3bd144a409f940998afd367af1dcde44.r2.dev/migrated/colleges/1765993682434-65208607-jz9a7qql10hvqwosu6kl.jpg", "All India Institute of Medical Sciences (AIIMS) New Delhi is the premier medical college and hospital in India, globally recognized for its excellence in medical research and education."),
                TopCollege("PGIMER", 2, "₹12 LPA (Stipend)", "pgimer.edu.in", Color(0xFFF3E5F5), "https://dfhe5ze0n4pxu.cloudfront.net/College/Background-Images/Background-Image-1740394040412.jpg", "Postgraduate Institute of Medical Education and Research (PGIMER) in Chandigarh is a premier medical research institute and hospital of national importance."),
                TopCollege("CMC Vellore", 3, "₹10 LPA", "cmch-vellore.edu", Color(0xFFE8F5E9), "https://www.edufever.com/wp-content/uploads/2021/12/CMC-Vellore-.webp", "Christian Medical College (CMC) Vellore is one of India's top medical institutes, renowned for community care and medical excellence."),
                TopCollege("JIPMER", 4, "₹12 LPA", "jipmer.edu.in", Color(0xFFFFEBEE), "https://www.edufever.com/wp-content/uploads/2023/12/JIPMER-Karaikal.webp", "Jawaharlal Institute of Postgraduate Medical Education & Research (JIPMER) Puducherry is an Institute of National Importance."),
                TopCollege("SGPGIMS", 5, "₹12 LPA", "sgpgims.org.in", Color(0xFFE0F7FA), "https://sgpgims.org.in/Home/images/slider/2.jpg", "Sanjay Gandhi Postgraduate Institute of Medical Sciences (SGPGIMS) in Lucknow is a premier tertiary medical institute."),
                TopCollege("IMS BHU", 6, "₹12 LPA", "bhu.ac.in", Color(0xFFFFF8E1), "https://s7ap1.scene7.com/is/image/incredibleindia/banaras-hindu-university-varanasi-uttar-pradesh-6-attr-hero?qlt=82&ts=1727353280305", "Institute of Medical Sciences (IMS-BHU) is a prestigious medical college of Banaras Hindu University in Varanasi."),
                TopCollege("NIMHANS", 7, "₹10 LPA", "nimhans.ac.in", Color(0xFFFFF3E0), "https://i.ytimg.com/vi/1iOoQsQ1Hvk/hqdefault.jpg", "National Institute of Mental Health and Neuro-Sciences (NIMHANS) in Bengaluru is the apex centre for mental health and neuroscience education."),
                TopCollege("KGMU", 8, "₹12 LPA", "kgmu.org", Color(0xFFFCE4EC), "https://media.licdn.com/dms/image/v2/C4E1BAQH8gmbo5vr2Jw/company-background_10000/company-background_10000/0/1599238567129/kgmu_cover?e=2147483647&v=beta&t=uXkIE-5lskd2HYi7ZzgTy810E-6A4x36xo5TS0tfLkc", "King George's Medical University (KGMU) in Lucknow is one of Northern India's most prestigious medical universities."),
                TopCollege("Amrita Vishwa Vidyapeetham", 9, "₹14 LPA", "amrita.edu", Color(0xFFF1F8E9), "https://scontent.fdel27-8.fna.fbcdn.net/v/t39.30808-6/477567621_1117039413551763_2489722169848691977_n.jpg?stp=dst-jpg_tt6&cstp=mx2048x1365&ctp=s960x960&_nc_cat=104&_nc_map=urlgen_bucketless&ccb=1-7&_nc_sid=cc71e4&_nc_ohc=FA5MPDGIfnUQ7kNvwHFlrgK&_nc_oc=AdqGphkTsrBg7ivg_q6Wh0PvE9IJB01S3t6DBiKdPTY4qc8I9F_ldUv749_iS3PvI9oWfrGYQAAfQqpLQyWJC0OQ&_nc_zt=23&_nc_ht=scontent.fdel27-8.fna&_nc_gid=DvO1m_zXGR2m3yj4kcdxvA&_nc_ss=78289&oh=00_AQGFlgFFjDC5IOAF3Y26MPCTmhjJp-JVXd23dJskYdOdUg&oe=6A787238", "Amrita Institute of Medical Sciences (Amrita Vishwa Vidyapeetham) in Coimbatore/Kochin is renowned for advanced clinical care."),
                TopCollege("Kasturba Medical College (KMC)", 10, "₹15 LPA", "manipal.edu", Color(0xFFEFEBE9), "https://blog.rmgoe.org/wp-content/uploads/2022/09/Kasturba-Medical-College-Manipal.webp", "Kasturba Medical College (KMC Manipal) is a premier private medical college in India, affiliated with MAHE.")
            )
        } else {
            listOf(
                TopCollege("IIT Madras", 1, "₹1.98 Cr PA", "iitm.ac.in", Color(0xFFFFF3E0), "https://skilloutlook.com/wp-content/uploads/2023/09/A-view-of-the-IIT-Madras-Campus.jpeg", "Indian Institute of Technology (IIT) Madras is the top-ranked engineering institute in India, known for its green campus and cutting-edge research."),
                TopCollege("IIT Delhi", 2, "₹2.05 Cr PA", "iitd.ac.in", Color(0xFFE3F2FD), "https://home.iitd.ac.in/images/for-faculty/camp8.jpg", "IIT Delhi is located in the heart of the national capital, offering premier research, startup ecosystem, and stellar placements."),
                TopCollege("IIT Bombay", 3, "₹3.67 Cr PA", "iitb.ac.in", Color(0xFFF3E5F5), "https://i.ytimg.com/vi/0xbEHK_nqLc/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLCMC9RKonKwK0T8aevgNI4-7-uy7A", "IIT Bombay in Powai, Mumbai, offers world-class technical education, top tier placements, and vibrant campus culture."),
                TopCollege("IIT Kanpur", 4, "₹1.90 Cr PA", "iitk.ac.in", Color(0xFFE8F5E9), "https://media.licdn.com/dms/image/v2/D4E05AQFCCdYvtT2RMQ/feedshare-thumbnail_720_1280/B4EZcRPm2ZH0As-/0/1748340995008?e=2147483647&v=beta&t=DW44OB8ea9iUySsCqtYz9NTzSJYEC-EKhzHeOR7oP3M", "IIT Kanpur is globally acclaimed for its pioneer scientific research, aerospace engineering, and faculty excellence."),
                TopCollege("IIT Kharagpur", 5, "₹2.60 Cr PA", "iitkgp.ac.in", Color(0xFFE0F7FA), "https://i.ytimg.com/vi/Jbfr6wHEN8Y/hqdefault.jpg", "IIT Kharagpur is the first IIT established in India, boasting the largest campus and landmark engineering achievements."),
                TopCollege("NIT Tiruchirappalli (NIT Trichy)", 9, "₹40 LPA", "nitt.edu", Color(0xFFF1F8E9), "https://media.licdn.com/dms/image/v2/D5612AQFpX4lkPRMDDA/article-cover_image-shrink_720_1280/B56ZYjIxf9H0AQ-/0/1744346224871?e=2147483647&v=beta&t=qmD0uXujeJ7Ir5R75T7J7owSZsPNdYqmqrYMq8GzAzg", "NIT Tiruchirappalli is the top-ranked National Institute of Technology in India, producing outstanding engineering talent."),
                TopCollege("BITS Pilani (Pilani Campus)", 11, "₹60 LPA", "bits-pilani.ac.in", Color(0xFFFFF3E0), "https://akm-img-a-in.tosshub.com/businesstoday/images/story/202303/bits-pilani-sixteen_nine.jpg?size=948:533", "Birla Institute of Technology & Science (BITS) Pilani is India's top private engineering institute with zero-attendance policy and entrepreneurship focus."),
                TopCollege("NIT Rourkela", 13, "₹48 LPA", "nitrkl.ac.in", Color(0xFFFFEBEE), "https://i.ytimg.com/vi/bWoVqHpxzho/hqdefault.jpg", "NIT Rourkela in Odisha is a premier institute of national importance known for advanced research and infrastructure."),
                TopCollege("NIT Surathkal", 17, "₹54 LPA", "nitk.ac.in", Color(0xFFFCE4EC), "https://myexams.ai/wp-content/uploads/2025/10/college-NIT.webp", "National Institute of Technology Karnataka (NITK) Surathkal features a private beach campus and top placement records."),
                TopCollege("NIT Calicut", 21, "₹47 LPA", "nitc.ac.in", Color(0xFFEFEBE9), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0AzuR7_m68AlExuBua78BimIE6wENP5CB2A&s", "NIT Calicut in Kerala is renowned for academic rigor, lush green campus, and vibrant technical student community.")
            )
        }
    }

    val pagerState = androidx.compose.foundation.pager.rememberPagerState(pageCount = { colleges.size })

    LaunchedEffect(pagerState, colleges.size) {
        if (colleges.isEmpty()) return@LaunchedEffect
        while (true) {
            kotlinx.coroutines.delay(3000L)
            if (pagerState.isScrollInProgress) {
                snapshotFlow { pagerState.isScrollInProgress }.first { !it }
                kotlinx.coroutines.delay(3000L)
            }
            if (colleges.isNotEmpty()) {
                val nextPage = (pagerState.currentPage + 1) % colleges.size
                pagerState.animateScrollToPage(
                    page = nextPage,
                    animationSpec = androidx.compose.animation.core.tween(
                        durationMillis = 800,
                        easing = androidx.compose.animation.core.FastOutSlowInEasing
                    )
                )
            }
        }
    }

    Column(
        modifier = Modifier.padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                text = "Dream Colleges Showcase",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp,
                color = BentoOnSurface
            )
        }

        androidx.compose.foundation.pager.HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 32.dp),
            pageSpacing = 16.dp
        ) { page ->
            val college = colleges[page]
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectedCollegeForDialog = college },
                shape = RoundedCornerShape(16.dp),
                color = BentoSurface,
                border = BorderStroke(1.dp, college.bgColor.copy(alpha = 0.8f))
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                    ) {
                        coil.compose.SubcomposeAsyncImage(
                            model = coil.request.ImageRequest.Builder(context)
                                .data(college.imageUrl)
                                .addHeader("User-Agent", "PreplexaPrepApp/1.0 (Android; support@preplexa.app)")
                                .crossfade(true)
                                .build(),
                            contentDescription = "${college.name} Campus Front View",
                            contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                            modifier = Modifier.fillMaxSize(),
                            loading = {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(college.bgColor.copy(alpha = 0.5f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CircularProgressIndicator(modifier = Modifier.size(24.dp), color = BentoPrimary, strokeWidth = 2.dp)
                                }
                            },
                            error = {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(
                                            androidx.compose.ui.graphics.Brush.verticalGradient(
                                                colors = listOf(college.bgColor, BentoPrimary.copy(alpha = 0.15f))
                                            )
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.padding(12.dp)
                                    ) {
                                        Icon(
                                            Icons.Filled.School,
                                            contentDescription = null,
                                            modifier = Modifier.size(48.dp),
                                            tint = BentoPrimary
                                        )
                                        Spacer(modifier = Modifier.height(6.dp))
                                        Text(
                                            text = "CAMPUS FRONT VIEW",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 10.sp,
                                            color = BentoPrimary,
                                            letterSpacing = 1.sp
                                        )
                                        Text(
                                            text = college.name,
                                            fontWeight = FontWeight.ExtraBold,
                                            fontSize = 14.sp,
                                            color = BentoOnSurface,
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                            }
                        )
                        // Gradient Overlay for text readability
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    androidx.compose.ui.graphics.Brush.verticalGradient(
                                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f))
                                    )
                                )
                        )
                        // Campus Badge Overlay (Top Left)
                        Surface(
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(10.dp),
                            shape = RoundedCornerShape(20.dp),
                            color = Color.Black.copy(alpha = 0.65f),
                            contentColor = Color.White
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(Icons.Filled.School, contentDescription = null, modifier = Modifier.size(12.dp), tint = Color.White)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Campus Building",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                        // NIRF Badge Overlay (Top Right)
                        Surface(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(10.dp),
                            shape = RoundedCornerShape(20.dp),
                            color = BentoPrimary,
                            contentColor = Color.White
                        ) {
                            Text(
                                text = "NIRF #${college.nirfRank}",
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        // College Name Banner Overlay (Bottom)
                        Text(
                            text = college.name,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(12.dp)
                        )
                    }
                    
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = college.name,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp,
                            color = BentoOnSurface
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "NIRF Rank: #${college.nirfRank}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = BentoOnSurfaceVariant
                            )
                            Text(
                                text = "Explore Now",
                                color = Color(0xFF9C27B0), // Purple color requested
                                fontSize = 14.sp,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                    }
                }
            }
        }
        
        // Pager indicators
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(colleges.size) { iteration ->
                val color = if (pagerState.currentPage == iteration) BentoPrimary else BentoSurfaceVariant
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
    }

    if (selectedCollegeForDialog != null) {
        CollegeDetailsDialog(college = selectedCollegeForDialog!!, onDismiss = { selectedCollegeForDialog = null }, context = context)
    }
}

// --- TIME FORMATTING UTILITY ---
fun formatTimeInSeconds(seconds: Long): String {
    if (seconds <= 0) return "0s"
    val hours = seconds / 3600
    val mins = (seconds % 3600) / 60
    val secs = seconds % 60
    return when {
        hours > 0 -> "${hours}h ${mins}m ${secs}s"
        mins > 0 -> "${mins}m ${secs}s"
        else -> "${secs}s"
    }
}

// --- STUDENT ANALYTICS CARD WITH LIGHT PURPLE THEME & SIMULATOR LINE GRAPH ---
@Composable
fun StudentAnalyticsCard(
    currentStreakDays: Int,
    selectedExam: ExamType,
    attempts: List<com.example.data.local.TestAttemptEntity> = emptyList(),
    appSessionSeconds: Long = 0L,
    phetSessionSeconds: Long = 0L,
    phetDailySeconds: Map<String, Long> = emptyMap()
) {
    var selectedTab by remember { mutableStateOf(0) } // 0: Subject Split / Pie, 1: Daily Activity / Histogram

    val totalAttemptSeconds = attempts.sumOf { it.timeSpentSeconds.toLong() }
    val totalTimeFormatted = if (attempts.isEmpty() || totalAttemptSeconds == 0L) "0s" else formatTimeInSeconds(totalAttemptSeconds)

    val totalQsSolved = attempts.sumOf { it.totalQuestions }
    val avgAccuracy = if (attempts.isNotEmpty()) attempts.map { it.scorePercent }.average().toInt() else 0

    val uniqueDaysCount = attempts.map {
        val cal = java.util.Calendar.getInstance()
        cal.timeInMillis = it.timestamp
        "${cal.get(java.util.Calendar.YEAR)}-${cal.get(java.util.Calendar.DAY_OF_YEAR)}"
    }.distinct().size.coerceAtLeast(1)

    val dailyAvgSec = if (attempts.isNotEmpty() && totalAttemptSeconds > 0) (totalAttemptSeconds / uniqueDaysCount) else 0L
    val dailyAvgText = formatTimeInSeconds(dailyAvgSec)

    Surface(
        shape = RoundedCornerShape(20.dp),
        color = BentoSurface,
        border = BorderStroke(1.dp, Color(0xFFDDD6FE)), // Soft Light Purple Border
        shadowElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f).padding(end = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    Text(
                        text = "Student Study Analytics",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 13.5.sp,
                        color = BentoOnSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = if (attempts.isEmpty()) "Test time tracking • Solve mock tests to update" else "Real-time mock test & paper analytics",
                        fontSize = 10.sp,
                        color = BentoOnSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color(0xFFF3E8FF),
                    border = BorderStroke(1.dp, Color(0xFFC084FC))
                ) {
                    Text(
                        text = if (attempts.isEmpty()) "⏱️ Test Time: 0s" else "⏱️ Test Time: $totalTimeFormatted",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF7C3AED),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            // Tab Selector Switch
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFF3E8FF))
                    .padding(3.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { selectedTab = 0 },
                    shape = RoundedCornerShape(9.dp),
                    color = if (selectedTab == 0) BentoSurface else Color.Transparent,
                    shadowElevation = if (selectedTab == 0) 1.5.dp else 0.dp
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.padding(vertical = 5.dp)
                    ) {
                        Text(
                            text = "Subject Split",
                            fontSize = 10.5.sp,
                            fontWeight = if (selectedTab == 0) FontWeight.ExtraBold else FontWeight.Medium,
                            color = if (selectedTab == 0) Color(0xFF7C3AED) else BentoOnSurfaceVariant
                        )
                    }
                }

                Surface(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { selectedTab = 1 },
                    shape = RoundedCornerShape(9.dp),
                    color = if (selectedTab == 1) BentoSurface else Color.Transparent,
                    shadowElevation = if (selectedTab == 1) 1.5.dp else 0.dp
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.padding(vertical = 5.dp)
                    ) {
                        Text(
                            text = "Daily Activity",
                            fontSize = 10.5.sp,
                            fontWeight = if (selectedTab == 1) FontWeight.ExtraBold else FontWeight.Medium,
                            color = if (selectedTab == 1) Color(0xFF7C3AED) else BentoOnSurfaceVariant
                        )
                    }
                }
            }

            if (selectedTab == 0) {
                PieChartContent(selectedExam = selectedExam, attempts = attempts, appSessionSeconds = totalAttemptSeconds)
            } else {
                HistogramChartContent(attempts = attempts)
            }

            Divider(color = Color(0xFFEDE9FE), thickness = 1.dp)

            // Metrics Summary Pill Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                MetricPill(label = "Daily Avg", value = dailyAvgText)
                MetricPill(label = "Accuracy", value = "$avgAccuracy%")
                MetricPill(label = "Qs Solved", value = "$totalQsSolved Qs")
                MetricPill(label = "Sim Time", value = formatTimeInSeconds(phetSessionSeconds))
            }
        }
    }
}

@Composable
fun SimulatorTimeCard(
    phetSessionSeconds: Long,
    phetDailySeconds: Map<String, Long>
) {
    val weekDays = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

    val totalTimeSpent = remember(phetDailySeconds, phetSessionSeconds) {
        (phetDailySeconds.values.sum() + phetSessionSeconds).coerceAtLeast(0L)
    }
    val hasActiveData = totalTimeSpent > 0L

    // Get real daily seconds array or flat zero baseline if not used yet
    val dailyValues = remember(phetDailySeconds, phetSessionSeconds, hasActiveData) {
        val list = weekDays.map { day -> phetDailySeconds[day] ?: 0L }.toMutableList()
        if (!hasActiveData) {
            listOf(0L, 0L, 0L, 0L, 0L, 0L, 0L)
        } else {
            val cal = java.util.Calendar.getInstance()
            val currentDayKey = when (cal.get(java.util.Calendar.DAY_OF_WEEK)) {
                java.util.Calendar.MONDAY -> "Mon"
                java.util.Calendar.TUESDAY -> "Tue"
                java.util.Calendar.WEDNESDAY -> "Wed"
                java.util.Calendar.THURSDAY -> "Thu"
                java.util.Calendar.FRIDAY -> "Fri"
                java.util.Calendar.SATURDAY -> "Sat"
                java.util.Calendar.SUNDAY -> "Sun"
                else -> "Mon"
            }
            if (phetSessionSeconds > 0L) {
                val idx = weekDays.indexOf(currentDayKey)
                if (idx in list.indices) {
                    list[idx] = (list[idx]).coerceAtLeast(phetSessionSeconds)
                }
            }
            list
        }
    }

    val maxVal = (dailyValues.maxOrNull() ?: 0L)
    val minVal = (dailyValues.minOrNull() ?: 0L)

    val maxIdx = if (hasActiveData && maxVal > 0L) dailyValues.indexOfFirst { it == maxVal }.coerceAtLeast(0) else -1
    val minIdx = if (hasActiveData && maxVal > 0L && maxVal != minVal) dailyValues.indexOfFirst { it == minVal }.coerceAtLeast(0) else -1

    var touchedDayIdx by remember { mutableStateOf<Int?>(null) }

    // Pulsing/Blinking animations for Max (Green) and Min (Red) points when graph is active
    val infiniteTransition = rememberInfiniteTransition(label = "simBlink")
    val blinkAlpha by infiniteTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 650, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "blinkAlpha"
    )
    val blinkScale by infiniteTransition.animateFloat(
        initialValue = 1.0f,
        targetValue = 1.6f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 650, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "blinkScale"
    )

    Surface(
        shape = RoundedCornerShape(20.dp),
        color = BentoSurface,
        border = BorderStroke(1.dp, Color(0xFFDDD6FE)),
        shadowElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f).padding(end = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF8B5CF6)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🧪", fontSize = 11.sp)
                    }
                    Column {
                        Text(
                            text = "Simulator Time Spent",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 12.sp,
                            color = Color(0xFF4C1D95),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = if (hasActiveData) "Live tracker in seconds • Touch points for details" else "Graph inactive • Use simulator to activate tracking",
                            fontSize = 9.sp,
                            color = if (hasActiveData) Color(0xFF6D28D9) else Color(0xFF8B5CF6),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = if (hasActiveData) Color(0xFFDDD6FE) else Color(0xFFF3E8FF),
                    border = BorderStroke(1.dp, Color(0xFFC084FC))
                ) {
                    Text(
                        text = if (hasActiveData) "⏳ Total: ${formatTimeInSeconds(totalTimeSpent)}" else "⏸️ Inactive (0s)",
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF5B21B6),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            // Interactive Line Graph Canvas
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White.copy(alpha = 0.9f))
                    .border(1.dp, Color(0xFFEDE9FE), RoundedCornerShape(12.dp))
                    .pointerInput(Unit) {
                        detectTapGestures { offset ->
                            val width = size.width
                            val stepX = width / (weekDays.size - 1)
                            val idx = ((offset.x + stepX / 2) / stepX).toInt().coerceIn(0, weekDays.size - 1)
                            touchedDayIdx = idx
                        }
                    }
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val w = size.width
                    val h = size.height
                    val paddingX = 24.dp.toPx()
                    val paddingY = 20.dp.toPx()

                    val graphW = w - (paddingX * 2)
                    val graphH = h - (paddingY * 2)

                    val stepX = graphW / (weekDays.size - 1)

                    // Draw Horizontal Grid Lines
                    for (i in 0..2) {
                        val gridY = paddingY + (graphH * (i / 2f))
                        drawLine(
                            color = Color(0xFFEDE9FE),
                            start = Offset(paddingX, gridY),
                            end = Offset(w - paddingX, gridY),
                            strokeWidth = 1.dp.toPx(),
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(8f, 8f), 0f)
                        )
                    }

                    // Compute Point Coordinates
                    val effectiveMax = if (maxVal > 0L) maxVal.toFloat() else 10f
                    val points = dailyValues.mapIndexed { i, valSec ->
                        val norm = if (!hasActiveData || maxVal == 0L) 0.05f else (valSec.toFloat() / effectiveMax).coerceIn(0.05f, 1.0f)
                        val x = paddingX + (i * stepX)
                        val y = h - paddingY - (norm * graphH)
                        Offset(x, y)
                    }

                    // Smooth Bezier Curve Path or Straight Line
                    val path = Path().apply {
                        if (points.isNotEmpty()) {
                            moveTo(points[0].x, points[0].y)
                            if (!hasActiveData || maxVal == 0L) {
                                for (i in 1 until points.size) {
                                    lineTo(points[i].x, points[i].y)
                                }
                            } else {
                                for (i in 0 until points.size - 1) {
                                    val p1 = points[i]
                                    val p2 = points[i + 1]
                                    val cx1 = p1.x + (p2.x - p1.x) / 2
                                    val cy1 = p1.y
                                    val cx2 = p1.x + (p2.x - p1.x) / 2
                                    val cy2 = p2.y
                                    cubicTo(cx1, cy1, cx2, cy2, p2.x, p2.y)
                                }
                            }
                        }
                    }

                    // Fill Gradient Path under curve
                    val fillPath = Path().apply {
                        addPath(path)
                        lineTo(points.last().x, h - paddingY)
                        lineTo(points.first().x, h - paddingY)
                        close()
                    }

                    drawPath(
                        path = fillPath,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF8B5CF6).copy(alpha = if (hasActiveData) 0.25f else 0.05f),
                                Color(0xFFC084FC).copy(alpha = 0.01f)
                            )
                        )
                    )

                    // Draw Stroke Line
                    drawPath(
                        path = path,
                        color = if (hasActiveData) Color(0xFF7C3AED) else Color(0xFFA78BFA),
                        style = Stroke(
                            width = (if (hasActiveData) 3.dp else 2.dp).toPx(),
                            cap = StrokeCap.Round,
                            join = StrokeJoin.Round,
                            pathEffect = if (!hasActiveData) PathEffect.dashPathEffect(floatArrayOf(12f, 6f), 0f) else null
                        )
                    )

                    // Draw Dots on Points
                    points.forEachIndexed { i, pt ->
                        val isMax = (i == maxIdx && maxIdx != -1)
                        val isMin = (i == minIdx && minIdx != -1)
                        val isTouched = (touchedDayIdx == i)

                        if (isMax) {
                            // Blinking Green Light Indicator for Maximum Time Point
                            drawCircle(
                                color = Color(0xFF22C55E).copy(alpha = 0.45f * blinkAlpha),
                                radius = 11.dp.toPx() * blinkScale,
                                center = pt
                            )
                            drawCircle(
                                color = Color(0xFF15803D),
                                radius = 6.dp.toPx(),
                                center = pt
                            )
                            drawCircle(
                                color = Color(0xFF22C55E),
                                radius = 4.5.dp.toPx(),
                                center = pt
                            )
                        } else if (isMin) {
                            // Blinking Red Light Indicator for Minimum Time Point
                            drawCircle(
                                color = Color(0xFFEF4444).copy(alpha = 0.45f * blinkAlpha),
                                radius = 11.dp.toPx() * blinkScale,
                                center = pt
                            )
                            drawCircle(
                                color = Color(0xFFB91C1C),
                                radius = 6.dp.toPx(),
                                center = pt
                            )
                            drawCircle(
                                color = Color(0xFFEF4444),
                                radius = 4.5.dp.toPx(),
                                center = pt
                            )
                        } else {
                            // Standard Light Purple Point
                            drawCircle(
                                color = Color(0xFF7C3AED),
                                radius = if (isTouched) 6.dp.toPx() else 4.dp.toPx(),
                                center = pt
                            )
                            drawCircle(
                                color = Color.White,
                                radius = if (isTouched) 3.dp.toPx() else 2.dp.toPx(),
                                center = pt
                            )
                        }

                        // Touch Vertical Guide Line
                        if (isTouched) {
                            drawLine(
                                color = Color(0xFF7C3AED).copy(alpha = 0.7f),
                                start = Offset(pt.x, paddingY),
                                end = Offset(pt.x, h - paddingY),
                                strokeWidth = 1.5.dp.toPx(),
                                pathEffect = PathEffect.dashPathEffect(floatArrayOf(6f, 6f), 0f)
                            )
                        }
                    }
                }

                // Touched Tooltip Callout
                if (touchedDayIdx != null) {
                    val idx = touchedDayIdx!!
                    val dayName = weekDays[idx]
                    val secs = dailyValues[idx]
                    val formatted = formatTimeInSeconds(secs)

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF4C1D95),
                        shadowElevation = 4.dp,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = 6.dp)
                    ) {
                        Text(
                            text = if (hasActiveData) "📍 $dayName: $formatted (${secs}s)" else "📍 $dayName: 0s (Simulator not used yet)",
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            // Bottom X-Axis Days & Light Indicator Badges
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                weekDays.forEachIndexed { i, day ->
                    val isMax = (i == maxIdx && maxIdx != -1)
                    val isMin = (i == minIdx && minIdx != -1)

                    Text(
                        text = day,
                        fontSize = 10.sp,
                        fontWeight = if (isMax || isMin) FontWeight.Black else FontWeight.Bold,
                        color = when {
                            isMax -> Color(0xFF15803D)
                            isMin -> Color(0xFFB91C1C)
                            else -> Color(0xFF6B21A8)
                        }
                    )
                }
            }

            // Light Indicator Legend Row (Only shown when graph is active with data)
            if (hasActiveData && maxVal > 0L) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (maxIdx != -1) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF22C55E))
                            )
                            Text(
                                text = "🟢 Max: ${weekDays[maxIdx]} (${formatTimeInSeconds(dailyValues[maxIdx])})",
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF15803D)
                            )
                        }
                    }

                    if (minIdx != -1) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFEF4444))
                            )
                            Text(
                                text = "🔴 Min: ${weekDays[minIdx]} (${formatTimeInSeconds(dailyValues[minIdx])})",
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFB91C1C)
                            )
                        }
                    }
                }
            } else {
                Text(
                    text = "💡 Open PhET Simulations to start tracking daily time in seconds!",
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF7C3AED),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Composable
fun HistogramChartContent(attempts: List<com.example.data.local.TestAttemptEntity> = emptyList()) {
    val weekDays = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    
    val studyMinutes = remember(attempts) {
        val map = mutableMapOf(
            java.util.Calendar.MONDAY to 0,
            java.util.Calendar.TUESDAY to 0,
            java.util.Calendar.WEDNESDAY to 0,
            java.util.Calendar.THURSDAY to 0,
            java.util.Calendar.FRIDAY to 0,
            java.util.Calendar.SATURDAY to 0,
            java.util.Calendar.SUNDAY to 0
        )
        attempts.forEach { att ->
            val cal = java.util.Calendar.getInstance()
            cal.timeInMillis = att.timestamp
            val dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK)
            map[dayOfWeek] = (map[dayOfWeek] ?: 0) + (att.timeSpentSeconds / 60)
        }
        listOf(
            map[java.util.Calendar.MONDAY] ?: 0,
            map[java.util.Calendar.TUESDAY] ?: 0,
            map[java.util.Calendar.WEDNESDAY] ?: 0,
            map[java.util.Calendar.THURSDAY] ?: 0,
            map[java.util.Calendar.FRIDAY] ?: 0,
            map[java.util.Calendar.SATURDAY] ?: 0,
            map[java.util.Calendar.SUNDAY] ?: 0
        )
    }

    val maxMinutes = (studyMinutes.maxOrNull() ?: 60).coerceAtLeast(10)

    var animateBars by remember { mutableStateOf(false) }
    val animatedProgress by animateFloatAsState(
        targetValue = if (animateBars) 1f else 0f,
        animationSpec = tween(durationMillis = 900, easing = FastOutSlowInEasing),
        label = "barAnimation"
    )

    LaunchedEffect(Unit) {
        animateBars = true
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        if (attempts.isEmpty()) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(BentoSurfaceVariant.copy(alpha = 0.2f))
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.BarChart,
                        contentDescription = null,
                        tint = BentoOnSurfaceVariant,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "No test attempts recorded yet",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = BentoOnSurfaceVariant
                    )
                    Text(
                        text = "Solve tests to track your daily minute breakdown",
                        fontSize = 9.5.sp,
                        color = BentoOnSurfaceVariant.copy(alpha = 0.7f)
                    )
                }
            }
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                weekDays.forEachIndexed { index, day ->
                    val mins = studyMinutes[index]
                    val minsFormatted = "${mins}m"
                    val barFraction = (mins.toFloat() / maxMinutes.toFloat()) * animatedProgress

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = minsFormatted,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (mins > 0) BentoPrimary else BentoOnSurfaceVariant.copy(alpha = 0.5f)
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Box(
                            modifier = Modifier
                                .width(18.dp)
                                .fillMaxHeight(barFraction.coerceIn(0.08f, 1f))
                                .clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp))
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(
                                            BentoPrimary,
                                            Color(0xFF3B82F6).copy(alpha = 0.6f)
                                        )
                                    )
                                )
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = day,
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = BentoOnSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PieChartContent(
    selectedExam: ExamType,
    attempts: List<com.example.data.local.TestAttemptEntity> = emptyList(),
    appSessionSeconds: Long = 0L
) {
    val defaultSubjectNames = if (selectedExam == ExamType.NEET_UG) {
        listOf("Biology", "Physics", "Chemistry")
    } else {
        listOf("Maths", "Physics", "Chemistry")
    }

    val subjects = remember(attempts, selectedExam) {
        if (attempts.isEmpty()) {
            defaultSubjectNames.map { it to 0.333f }
        } else {
            defaultSubjectNames.mapIndexed { idx, name ->
                val fraction = when(idx) {
                    0 -> 0.45f
                    1 -> 0.30f
                    else -> 0.25f
                }
                name to fraction
            }
        }
    }

    val colors = listOf(
        Color(0xFF818CF8), // Soft Light Indigo
        Color(0xFFF59E0B), // Vibrant Amber Yellow
        Color(0xFF06B6D4)  // Bright Cyan Light
    )

    var animateChart by remember { mutableStateOf(false) }
    val animatedSweep by animateFloatAsState(
        targetValue = if (animateChart) 1f else 0f,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
        label = "pieAnimation"
    )

    LaunchedEffect(Unit) {
        animateChart = true
    }

    val totalTimeSeconds = attempts.sumOf { it.timeSpentSeconds }
    val timeToDisplay = if (attempts.isEmpty() || totalTimeSeconds == 0) "0s" else formatTimeInSeconds(totalTimeSeconds.toLong())

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Donut Canvas
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(115.dp)
        ) {
            Canvas(modifier = Modifier.size(105.dp)) {
                if (attempts.isEmpty()) {
                    drawArc(
                        color = Color.LightGray.copy(alpha = 0.3f),
                        startAngle = 0f,
                        sweepAngle = 360f,
                        useCenter = false,
                        style = Stroke(width = 20.dp.toPx(), cap = StrokeCap.Round)
                    )
                } else {
                    var startAngle = -90f
                    subjects.forEachIndexed { index, pair ->
                        val sweepAngle = pair.second * 360f * animatedSweep
                        drawArc(
                            color = colors[index % colors.size],
                            startAngle = startAngle,
                            sweepAngle = sweepAngle,
                            useCenter = false,
                            style = Stroke(width = 20.dp.toPx(), cap = StrokeCap.Round)
                        )
                        startAngle += pair.second * 360f
                    }
                }
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = timeToDisplay,
                    fontWeight = FontWeight.Black,
                    fontSize = 12.sp,
                    color = BentoOnSurface
                )
                Text(
                    text = if (attempts.isEmpty()) "No Data" else "Total Time",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = BentoOnSurfaceVariant
                )
            }
        }

        // Legend Column
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier
                .weight(1f)
                .padding(start = 14.dp)
        ) {
            subjects.forEachIndexed { index, pair ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(9.dp)
                                .clip(CircleShape)
                                .background(if (attempts.isEmpty()) Color.Gray.copy(alpha = 0.4f) else colors[index % colors.size])
                        )
                        Text(
                            text = pair.first,
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = BentoOnSurface
                        )
                    }

                    Text(
                        text = if (attempts.isEmpty()) "0%" else "${(pair.second * 100).toInt()}%",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = BentoPrimary
                    )
                }
            }
        }
    }
}

@Composable
fun MetricPill(label: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = value,
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraBold,
                color = BentoOnSurface
            )
        }
        Text(
            text = label,
            fontSize = 9.5.sp,
            color = BentoOnSurfaceVariant,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun ModernBottomNavigationBar(
    currentScreen: Screen,
    onNavigate: (Screen) -> Unit
) {
    Surface(
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        shadowElevation = 8.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(horizontal = 4.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavBottomItem(
                modifier = Modifier.weight(1f),
                title = "Home",
                icon = Icons.Filled.Home,
                isSelected = currentScreen == Screen.HOME,
                onClick = { onNavigate(Screen.HOME) }
            )
            NavBottomItem(
                modifier = Modifier.weight(1f),
                title = "Syllabus",
                icon = Icons.AutoMirrored.Filled.MenuBook,
                isSelected = currentScreen == Screen.TOPIC_LIST,
                onClick = { onNavigate(Screen.TOPIC_LIST) }
            )
            NavBottomItem(
                modifier = Modifier.weight(1f),
                title = "Analytics",
                icon = Icons.Filled.PieChart,
                isSelected = currentScreen == Screen.ANALYTICS,
                onClick = { onNavigate(Screen.ANALYTICS) }
            )
            NavBottomItem(
                modifier = Modifier.weight(1f),
                title = "PYQs",
                icon = Icons.AutoMirrored.Filled.Article,
                isSelected = currentScreen == Screen.PYQ_PAPERS,
                onClick = { onNavigate(Screen.PYQ_PAPERS) }
            )
            NavBottomItem(
                modifier = Modifier.weight(1f),
                title = "Profile",
                icon = Icons.Filled.Person,
                isSelected = currentScreen == Screen.PROFILE,
                onClick = { onNavigate(Screen.PROFILE) }
            )
        }
    }
}

@Composable
private fun NavBottomItem(
    modifier: Modifier = Modifier,
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val activeColor = BentoPrimary
    val inactiveColor = BentoOnSurfaceVariant

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .padding(horizontal = 2.dp, vertical = 4.dp)
            .testTag("nav_bottom_${title.lowercase()}")
    ) {
        Surface(
            shape = CircleShape,
            color = if (isSelected) activeColor.copy(alpha = 0.16f) else Color.Transparent,
            modifier = Modifier.size(32.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = if (isSelected) activeColor else inactiveColor,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = title,
            fontSize = 10.5.sp,
            fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Bold,
            color = if (isSelected) activeColor else inactiveColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun PhetSimulationsCard(
    selectedExam: ExamType,
    onOpenSimulations: () -> Unit
) {
    Surface(
        onClick = onOpenSimulations,
        modifier = Modifier
            .fillMaxWidth()
            .testTag("open_phet_simulations_card"),
        shape = RoundedCornerShape(18.dp),
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        shadowElevation = 1.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Official PhET Logo Badge
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color.White,
                border = BorderStroke(1.dp, Color(0xFF0284C7).copy(alpha = 0.25f)),
                shadowElevation = 1.dp,
                modifier = Modifier
                    .width(52.dp)
                    .height(36.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                ) {
                    AsyncImage(
                        model = OFFICIAL_PHET_LOGO_URL,
                        contentDescription = "PhET Interactive Sims Logo",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            // Info
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = "PhET 3D Sims",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.5.sp,
                        color = BentoOnSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFFE0F2FE)
                    ) {
                        Text(
                            text = "25+ LABS",
                            fontSize = 8.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF0284C7),
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                    }
                }
                Text(
                    text = "CU Boulder • Physics, Chem & Math HTML5",
                    fontSize = 11.5.sp,
                    color = BentoOnSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Arrow button
            Surface(
                shape = CircleShape,
                color = BentoPrimaryContainer,
                modifier = Modifier.size(36.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Explore PhET Labs",
                        tint = BentoPrimary,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}

// --- RISING PINK & BLUE BUBBLES ANIMATION ON BADGE CLAIM ---
@Composable
fun RisingBubblesEffect(
    isActive: Boolean,
    onEffectFinished: () -> Unit
) {
    if (!isActive) return

    val animProgress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        animProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 3200, easing = LinearEasing)
        )
        onEffectFinished()
    }

    data class BubbleData(
        val xPercent: Float,
        val sizeDp: Float,
        val speedFactor: Float,
        val delayFactor: Float,
        val swayAmplitude: Float,
        val swayFrequency: Float,
        val isPink: Boolean
    )

    val bubbles = remember {
        val random = java.util.Random(101)
        List(45) {
            BubbleData(
                xPercent = random.nextFloat() * 0.92f + 0.04f,
                sizeDp = random.nextFloat() * 24f + 12f,
                speedFactor = random.nextFloat() * 0.45f + 0.85f,
                delayFactor = random.nextFloat() * 0.35f,
                swayAmplitude = random.nextFloat() * 28f + 10f,
                swayFrequency = random.nextFloat() * 3f + 2f,
                isPink = random.nextBoolean()
            )
        }
    }

    val pinkShades = remember {
        listOf(
            Color(0xFFEC4899),
            Color(0xFFF472B6),
            Color(0xFFFF80BF),
            Color(0xFFE879F9),
            Color(0xFFF43F5E)
        )
    }

    val blueShades = remember {
        listOf(
            Color(0xFF3B82F6),
            Color(0xFF38BDF8),
            Color(0xFF60A5FA),
            Color(0xFF06B6D4),
            Color(0xFF2563EB)
        )
    }

    val progress = animProgress.value

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        bubbles.forEachIndexed { index, bubble ->
            val adjustedProgress = ((progress - bubble.delayFactor) / (1f - bubble.delayFactor)).coerceIn(0f, 1f)

            if (adjustedProgress > 0f && adjustedProgress < 1f) {
                val travelDistance = canvasHeight + 160f
                val currentY = (canvasHeight + 80f) - (adjustedProgress * bubble.speedFactor * travelDistance)
                val sway = kotlin.math.sin(adjustedProgress * bubble.swayFrequency * Math.PI.toFloat()) * bubble.swayAmplitude * density
                val currentX = (bubble.xPercent * canvasWidth) + sway

                val alpha = when {
                    adjustedProgress < 0.12f -> adjustedProgress / 0.12f
                    adjustedProgress > 0.75f -> (1f - adjustedProgress) / 0.25f
                    else -> 1f
                }.coerceIn(0f, 0.85f)

                val radius = (bubble.sizeDp / 2f) * density
                val colorList = if (bubble.isPink) pinkShades else blueShades
                val baseColor = colorList[index % colorList.size]

                // Glow radial shadow
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            baseColor.copy(alpha = alpha * 0.85f),
                            baseColor.copy(alpha = alpha * 0.35f),
                            Color.Transparent
                        ),
                        center = androidx.compose.ui.geometry.Offset(currentX, currentY),
                        radius = radius * 1.35f
                    ),
                    center = androidx.compose.ui.geometry.Offset(currentX, currentY),
                    radius = radius * 1.35f
                )

                // Main Bubble Body
                drawCircle(
                    color = baseColor.copy(alpha = alpha * 0.7f),
                    center = androidx.compose.ui.geometry.Offset(currentX, currentY),
                    radius = radius
                )

                // White Specular Highlight
                drawCircle(
                    color = Color.White.copy(alpha = alpha * 0.85f),
                    center = androidx.compose.ui.geometry.Offset(currentX - radius * 0.32f, currentY - radius * 0.32f),
                    radius = radius * 0.26f
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollegeDetailsDialog(college: TopCollege, onDismiss: () -> Unit, context: Context) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = BentoSurface,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            ) {
                SubcomposeAsyncImage(
                    model = coil.request.ImageRequest.Builder(context)
                        .data(college.imageUrl)
                        .addHeader("User-Agent", "PreplexaPrepApp/1.0 (Android; support@preplexa.app)")
                        .crossfade(true)
                        .build(),
                    contentDescription = "${college.name} Campus Front View",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                    loading = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(college.bgColor.copy(alpha = 0.5f)),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(modifier = Modifier.size(32.dp), color = BentoPrimary, strokeWidth = 3.dp)
                        }
                    },
                    error = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    androidx.compose.ui.graphics.Brush.verticalGradient(
                                        colors = listOf(college.bgColor, BentoPrimary.copy(alpha = 0.2f))
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(Icons.Filled.School, contentDescription = null, modifier = Modifier.size(64.dp), tint = BentoPrimary)
                                Spacer(modifier = Modifier.height(8.dp))
                                Text("CAMPUS BUILDING FRONT VIEW", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = BentoPrimary, letterSpacing = 1.sp)
                                Text(college.name, fontWeight = FontWeight.ExtraBold, fontSize = 18.sp, color = BentoOnSurface)
                            }
                        }
                    }
                )
                // Gradient Overlay
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            androidx.compose.ui.graphics.Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.65f))
                            )
                        )
                )
                // Badge Overlay
                Surface(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(12.dp),
                    shape = RoundedCornerShape(20.dp),
                    color = Color.Black.copy(alpha = 0.7f),
                    contentColor = Color.White
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Filled.School, contentDescription = null, modifier = Modifier.size(14.dp), tint = Color.White)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Campus Building Front View",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = college.name,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                color = BentoOnSurface,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("NIRF Rank", fontSize = 12.sp, color = BentoOnSurfaceVariant)
                    Text("#${college.nirfRank}", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = BentoPrimary)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Top Package", fontSize = 12.sp, color = BentoOnSurfaceVariant)
                    Text(college.topPackage, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF00C853))
                }
            }
            
            if (college.info.isNotEmpty()) {
                Spacer(modifier = Modifier.height(16.dp))
                Surface(
                    color = BentoSurfaceVariant.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.padding(horizontal = 24.dp).fillMaxWidth()
                ) {
                    Text(
                        text = college.info,
                        fontSize = 14.sp,
                        color = BentoOnSurfaceVariant,
                        lineHeight = 20.sp,
                        modifier = Modifier.padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Button(
                onClick = {
                    val rawUrl = college.website.trim()
                    val formattedUrl = if (!rawUrl.startsWith("http://") && !rawUrl.startsWith("https://")) {
                        "https://$rawUrl"
                    } else {
                        rawUrl
                    }
                    try {
                        val intent = android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse(formattedUrl)).apply {
                            addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK)
                        }
                        context.startActivity(intent)
                    } catch (e: Exception) {
                        try {
                            val searchUrl = "https://www.google.com/search?q=" + java.net.URLEncoder.encode("${college.name} official website", "UTF-8")
                            val searchIntent = android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse(searchUrl)).apply {
                                addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK)
                            }
                            context.startActivity(searchIntent)
                        } catch (ex: Exception) {
                            android.widget.Toast.makeText(context, "Could not open website link", android.widget.Toast.LENGTH_SHORT).show()
                        }
                    }
                    onDismiss()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9C27B0)), // Purple color
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Explore Now", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}
