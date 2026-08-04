package com.example.ui.screens

import androidx.compose.ui.draw.alpha

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.outlined.*
import kotlinx.coroutines.launch
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
                Text(
                    text = "Examination News",
                color = BentoBackground,
                border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.5f)),
                shadowElevation = 8.dp,
                Text(
                    text = "No new notifications yet.",
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Column(
                    Text(
                        text = news,
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
                            Text(
                                text = "Preplexa",
                            color = BentoPrimaryContainer,
                            Text(
                                text = "NTA Exam Prep",
                            modifier = Modifier.size(48.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Filled.NotificationsActive,
                                    contentDescription = "News",
                                    tint = BentoPrimary,
                                    Text(
                                        text = appUpdateNotice,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                            Text(
                                text = greetingText,
                            fontWeight = FontWeight.ExtraBold,
                            Text(
                                text = "${selectedExam.displayName}",
                            fontSize = 18.sp,
                            Text(
                                text = "${currentStreakDays}d Streak",
                            color = BentoOnSurface
                        )
                    }

                    if (adminNewsList.isEmpty()) {
                            Text(
                                text = "Select Your Target Exam",
                            fontSize = 14.sp,
                            Text(
                                text = "$currentStreakDays Days Streak",
                            color = BentoOnSurfaceVariant,
                            Text(
                                text = "ACTIVE",
                            modifier = Modifier.padding(16.dp)
                        )
                    } else {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            Text(
                                text = "Calendar",
                            modifier = Modifier.fillMaxWidth().heightIn(max = 300.dp)
                        ) {
                            items(adminNewsList) { news ->
                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    Text(
                                        text = dayName,
                                    color = BentoSurface,
                                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                                    Text(
                                        text = title,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                        Text(
                                            text = subtitle,
                                        fontSize = 13.5.sp,
                                        Text(
                                            text = exam.displayName,
                                        color = BentoOnSurface,
                                        Text(
                                            text = exam.description,
                                        modifier = Modifier.padding(16.dp)
                                    )
                                }
                            }
                        }
                    }

                    Button(
                        onClick = { showNewsDialog = false },
                        colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                        Text(
                            text = "DAY ${badge.dayMilestone}",
                        modifier = Modifier.fillMaxWidth()
                    ) {
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
                            Text(
                                text = badge.title,
                            modifier = Modifier
                                .size(42.dp)
                                .clip(RoundedCornerShape(14.dp)),
                            Text(
                                text = badge.description,
                            color = Color(0xFF0B0F19),
                            border = BorderStroke(1.dp, BentoPrimaryContainer)
                        ) {
                            Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(4.dp)) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_preplexa_logo),
                                    contentDescription = "Preplexa Logo",
                                    tint = Color.Unspecified,
                                    Text(
                                        text = if (badge.isUnlocked) "UNLOCKED" else "PROGRESS",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Column {
                                Text(
                                    text = badge.progressText,
                                fontWeight = FontWeight.ExtraBold,
                                Text(
                                    text = "365-Day Badges Roadmap",
                                fontSize = 20.sp,
                                Text(
                                    text = "36 Milestones • $unlockedCount/36 Unlocked",
                                color = BentoOnSurface
                            )
                                Text(
                                    text = label,
                                fontSize = 11.sp,
                                Text(
                                    text = "30-Day Streak Journey",
                                color = BentoOnSurfaceVariant,
                                Text(
                                    text = "Keep going! You have $currentStreak days active.",
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                },
                actions = {
                    // Global Dark/Light Theme Toggle Button
                    IconButton(
                        onClick = { viewModel.toggleDarkMode() },
                        Text(
                            text = "Day $dayNumber",
                        modifier = Modifier.testTag("top_bar_theme_toggle_button")
                    ) {
                        Surface(
                            shape = CircleShape,
                            Text(
                                text = "Day $dayNumber",
                            color = if (isDarkMode) Color(0xFF1E293B) else BentoPrimaryContainer,
                            border = BorderStroke(1.5.dp, if (isDarkMode) Color(0xFF334155) else BentoSurfaceVariant),
                            shadowElevation = 2.dp,
                            Text(
                                text = "NTA Live Arena",
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                        }
                    }

                    // Small App Guide / Tutorial Icon Button (Between theme & profile, icon only)
                    IconButton(
                        onClick = { viewModel.openTutorial() },
                        Text(
                            text = "LIVE",
                        modifier = Modifier.testTag("top_bar_guide_icon_button")
                    ) {
                        Surface(
                            shape = CircleShape,
                            Text(
                                text = "$formattedTotal Active",
                            color = BentoPrimaryContainer,
                            border = BorderStroke(1.5.dp, BentoPrimary.copy(alpha = 0.5f)),
                            shadowElevation = 2.dp,
                            Text(
                                text = "$currentMonthName Badges",
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                        }
                    }

                    // Profile Avatar Icon Button (Shows Previous Day Badge Icon)
                    IconButton(
                        onClick = { viewModel.navigateToScreen(Screen.PROFILE) },
                        Text(
                            text = "$unlockedCount / 30 Days Unlocked • Tap badge to set avatar",
                        modifier = Modifier
                            .padding(end = 4.dp)
                            .testTag("top_bar_profile_button")
                    ) {
                        Surface(
                            shape = CircleShape,
                            Text(
                                text = "Claim Day ${todayBadge.dayOfMonth}",
                            color = BentoPrimaryContainer,
                            border = BorderStroke(1.5.dp, BentoPrimary),
                            shadowElevation = 2.dp,
                            Text(
                                text = "$unlockedCount Earned",
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
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
            Text(
                text = badge.emojiIcon,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            ExamEnvironmentBackground(selectedExam = selectedExam)

            LazyColumn(
                Text(
                    text = "Day ${badge.dayOfMonth}",
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
                        Text(
                            text = if (badge.isToday) "TODAY" else if (badge.isUnlocked) "UNLOCKED" else "LOCKED",
                        color = Color(0xFFFEF3C7),
                        border = BorderStroke(1.dp, Color(0xFFF59E0B)),
                        Text(
                            text = "Student Study Analytics",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp)
                    ) {
                        Row(
                            Text(
                                text = "Real-time activity & time tracking",
                            modifier = Modifier.padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                                text = appUpdateNotice,
                                fontSize = 12.sp,
                                Text(
                                    text = "42.5 hrs Total",
                                fontWeight = FontWeight.Bold,
                                Text(
                                    text = "Subject Split",
                                color = Color(0xFF92400E),
                                Text(
                                    text = "Daily Activity",
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
                    Text(
                        text = "${hours}h",
                    color = BentoSurface,
                    border = BorderStroke(1.5.dp, Brush.horizontalGradient(listOf(BentoPrimary.copy(alpha = 0.5f), Color(0xFF10B981).copy(alpha = 0.3f)))),
                    shadowElevation = 3.dp,
                    Text(
                        text = day,
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
                        Text(
                            text = "42.5h",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Total Time",
                                fontWeight = FontWeight.Black,
                                Text(
                                    text = pair.first,
                                fontSize = 21.sp,
                                Text(
                                    text = "${(pair.second * 100).toInt()}%",
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
                                    Text(
                                        text = value,
                                    color = BentoPrimaryContainer.copy(alpha = 0.8f),
                                    border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.4f))
                                ) {
                                        Text(
                                            text = label,
                                        fontSize = 11.5.sp,
                                        Text(
                                            text = iconEmoji,
                                        fontWeight = FontWeight.Bold,
                                        Text(
                                            text = title,
                                        color = BentoPrimary,
                                        Text(
                                            text = "Perplexa AI Solver",
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                    )
                                }

                                // Daily Streak Pill
                                Surface(
                                    shape = RoundedCornerShape(20.dp),
                                    Text(
                                        text = "Instant 24/7 AI Mentor for ${selectedExam.displayName}",
                                    color = Color(0xFFFEF3C7),
                                    border = BorderStroke(1.dp, Color(0xFFF59E0B).copy(alpha = 0.4f))
                                ) {
                                        Text(
                                            text = "GEMINI PRO",
                                        fontSize = 11.5.sp,
                                        Text(
                                            text = "Stuck on a problem? Upload a photo or PDF of any question for a step-by-step clear solution!",
                                        fontWeight = FontWeight.ExtraBold,
                                        Text(
                                            text = "Launch AI Mentor",
                                        color = Color(0xFFD97706),
                                        Text(
                                            text = "Missing Text",
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                    )
                                }
                            }
                        }

                        // Floating Aesthetic News Notification Bell Button
                        Box(
                            Text(
                                text = "Missing Text",
                            modifier = Modifier
                                .clip(CircleShape)
                                .clickable { showNewsDialog = true }
                                .padding(4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Surface(
                                shape = CircleShape,
                                Text(
                                    text = "Missing Text",
                                color = BentoPrimaryContainer,
                                border = BorderStroke(2.dp, Brush.horizontalGradient(listOf(BentoPrimary, Color(0xFF10B981)))),
                                shadowElevation = 4.dp,
                                Text(
                                    text = "Missing Text",
                                modifier = Modifier.size(46.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Filled.NotificationsActive,
                                        contentDescription = "News Notifications",
                                        tint = BentoPrimary,
                                        Text(
                                            text = "Missing Text",
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
                            text = "Missing Text",
                        fontWeight = FontWeight.ExtraBold,
                        Text(
                            text = "Missing Text",
                        fontSize = 16.sp,
                        Text(
                            text = "Missing Text",
                        color = BentoOnSurface
                    )

                    Row(
                        Text(
                            text = "Missing Text",
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        // NEET UG CARD
                        ExamCardItem(
                            Text(
                                text = "Missing Text",
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
                            Text(
                                text = "Missing Text",
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

            // 3. SNAPCHAT-STYLE STREAK CARD (CLEAN & COMPACT)
            item {
                Surface(
                    Text(
                        text = "Missing Text",
                    modifier = Modifier.fillMaxWidth().clickable { showStreakCalendarModal = true },
                    shape = RoundedCornerShape(18.dp),
                    Text(
                        text = "Missing Text",
                    color = Color(0xFF121829), // Rich Dark Canvas
                    border = BorderStroke(1.dp, Color(0xFF2E3856))
                ) {
                    Column(
                        Text(
                            text = "Missing Text",
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Compact Streak Header Row
                        Row(
                            Text(
                                text = "Missing Text",
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Surface(
                                    shape = CircleShape,
                                    Text(
                                        text = "Missing Text",
                                    color = Color(0xFF331600),
                                    border = BorderStroke(1.dp, Color(0xFFFF6D00)),
                                    Text(
                                        text = "Missing Text",
                                    modifier = Modifier.size(34.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                    }
                                }

                                    Text(
                                        text = "Missing Text",
                                    fontWeight = FontWeight.ExtraBold,
                                    Text(
                                        text = "Missing Text",
                                    fontSize = 14.sp,
                                    Text(
                                        text = "Missing Text",
                                    color = Color(0xFFFF9100),
                                    Text(
                                        text = "Missing Text",
                                    maxLines = 1
                                )
                                Surface(
                                    Text(
                                        text = "Missing Text",
                                    color = Color(0xFF003B00),
                                    shape = RoundedCornerShape(6.dp),
                                    border = BorderStroke(1.dp, Color(0xFF00E676))
                                ) {
                                        Text(
                                            text = "Missing Text",
                                        fontSize = 8.5.sp,
                                        Text(
                                            text = "Missing Text",
                                        fontWeight = FontWeight.ExtraBold,
                                        Text(
                                            text = "Missing Text",
                                        color = Color(0xFF00E676),
                                        Text(
                                            text = "Missing Text",
                                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                    )
                                }
                            }

                                Text(
                                    text = "Missing Text",
                                fontSize = 11.sp,
                                Text(
                                    text = "Missing Text",
                                fontWeight = FontWeight.Bold,
                                Text(
                                    text = "Missing Text",
                                color = Color(0xFFFFB74D)
                            )
                        }

                        // Compact Days Tracker Row
                        Row(
                            Text(
                                text = "Missing Text",
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            streakDays.forEach { (dayLetter, isActive, dayName) ->
                                Column(
                                    Text(
                                        text = "Missing Text",
                                    modifier = Modifier.weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(3.dp)
                                ) {
                                    Surface(
                                        shape = CircleShape,
                                        Text(
                                            text = "Missing Text",
                                        color = if (isActive) Color(0xFFFF6D00).copy(alpha = 0.2f) else Color(0xFF1E293B),
                                        border = BorderStroke(
                                            1.dp,
                                            if (isActive) Color(0xFFFF9100) else Color(0xFF334155)
                                        ),
                                        Text(
                                            text = "Missing Text",
                                        modifier = Modifier.size(28.dp)
                                    ) {
                                        Box(contentAlignment = Alignment.Center) {
                                            if (isActive) {
                                            } else {
                                        }
                                    }

                                        Text(
                                            text = "Missing Text",
                                        fontSize = 8.5.sp,
                                        Text(
                                            text = "Missing Text",
                                        fontWeight = FontWeight.Bold,
                                        Text(
                                            text = "Missing Text",
                                        color = if (isActive) Color(0xFFFFB74D) else Color(0xFF64748B),
                                        Text(
                                            text = "Missing Text",
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 3.5 MONTHLY 30-DAY DAILY BADGE SPRINT
            item {
                Monthly30DayBadgeSection(
                    monthlyBadges = monthly30Badges,
                    todayBadge = todayBadge,
                    isTodayBadgeClaimed = isTodayBadgeClaimed,
                    onClaimTodayBadge = {
                        isTodayBadgeClaimed = true
                        badgePrefs.edit().putBoolean("badge_claimed_$todayDateKey", true).apply()
                        showBubbleEffect = true
                    },
                    onSelectBadgeAvatar = { emoji ->
                        viewModel.selectBadgeAvatar(emoji)
                    }
                )
            }

            // 4. STUDENT STUDY ANALYTICS (HISTOGRAM & PIE CHART THEME)
            item {
                StudentAnalyticsCard(
                    currentStreakDays = currentStreakDays,
                    selectedExam = selectedExam
                )
            }

            // 4.5 LIVE COMPETITION ARENA & REAL-TIME LEADERBOARD
            item {
                LiveCompetitionCard(viewModel = viewModel, studentName = studentName)
            }

            // 5. PREPLEXA AI 24/7 DOUBT SOLVER & STUDY CHAT CARD (LAUNCHES FULL DEDICATED SCREEN)
            item {
                PreplexaAiDoubtCard(
                    selectedExam = selectedExam,
                    onOpenAiSolver = { viewModel.navigateToScreen(Screen.PERPLEXA_AI_SOLVER) }
                )
            }
        } // Closes LazyColumn

        // Exam Switch Flash/Blink Overlay
        if (flashAlpha.value > 0.001f) {
            Box(
                Text(
                    text = "Missing Text",
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
        Text(
            text = "Missing Text",
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .clickable { onClick() }
            .testTag("dashboard_nav_${title.lowercase().replace(" ", "_")}"),
        shape = RoundedCornerShape(14.dp),
        Text(
            text = "Missing Text",
        color = if (isActive) BentoPrimaryContainer else BentoSurfaceVariant.copy(alpha = 0.4f),
        border = BorderStroke(1.dp, if (isActive) BentoPrimary else BentoSurfaceVariant)
    ) {
        Column(
            Text(
                text = "Missing Text",
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                Text(
                    text = "Missing Text",
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(if (isActive) BentoPrimary.copy(alpha = 0.15f) else BentoSurfaceVariant.copy(alpha = 0.6f)),
                contentAlignment = Alignment.Center
            ) {
            Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Missing Text",
                fontWeight = FontWeight.ExtraBold,
                Text(
                    text = "Missing Text",
                fontSize = 11.sp,
                Text(
                    text = "Missing Text",
                color = if (isActive) BentoPrimary else BentoOnSurface,
                Text(
                    text = "Missing Text",
                maxLines = 1,
                Text(
                    text = "Missing Text",
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                Text(
                    text = "Missing Text",
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Missing Text",
                fontSize = 9.sp,
                Text(
                    text = "Missing Text",
                color = BentoOnSurfaceVariant,
                Text(
                    text = "Missing Text",
                fontWeight = FontWeight.SemiBold,
                Text(
                    text = "Missing Text",
                maxLines = 1,
                Text(
                    text = "Missing Text",
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                Text(
                    text = "Missing Text",
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
        Text(
            text = "Missing Text",
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClick() }
            .testTag("exam_card_${exam.name}"),
        shape = RoundedCornerShape(20.dp),
        Text(
            text = "Missing Text",
        color = containerColor,
        border = BorderStroke(if (isSelected) 2.dp else 1.dp, borderColor)
    ) {
        Column(
            Text(
                text = "Missing Text",
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                Text(
                    text = "Missing Text",
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = CircleShape,
                    Text(
                        text = "Missing Text",
                    color = accentColor.copy(alpha = 0.15f),
                    Text(
                        text = "Missing Text",
                    modifier = Modifier.size(40.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                }

                if (isSelected) {
                    Icon(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = "Selected",
                        tint = accentColor,
                        Text(
                            text = "Missing Text",
                        modifier = Modifier.size(22.dp)
                    )
                }
            }

            Column {
                    Text(
                        text = "Missing Text",
                    fontWeight = FontWeight.ExtraBold,
                    Text(
                        text = "Missing Text",
                    fontSize = 15.sp,
                    Text(
                        text = "Missing Text",
                    color = BentoOnSurface
                )
                    Text(
                        text = "Missing Text",
                    fontSize = 11.sp,
                    Text(
                        text = "Missing Text",
                    color = BentoOnSurfaceVariant,
                    Text(
                        text = "Missing Text",
                    lineHeight = 15.sp,
                    Text(
                        text = "Missing Text",
                    maxLines = 2,
                    Text(
                        text = "Missing Text",
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
        Text(
            text = "Missing Text",
        modifier = Modifier
            .width(165.dp)
            .defaultMinSize(minHeight = 190.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        Text(
            text = "Missing Text",
        color = BentoSurface,
        border = BorderStroke(
            1.dp,
            if (badge.isUnlocked) badgeColor.copy(alpha = 0.6f) else BentoSurfaceVariant
        )
    ) {
        Column(
            Text(
                text = "Missing Text",
            modifier = Modifier
                .padding(14.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                Text(
                    text = "Missing Text",
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = CircleShape,
                    Text(
                        text = "Missing Text",
                    color = if (badge.isUnlocked) badgeColor.copy(alpha = 0.15f) else BentoSurfaceVariant,
                    Text(
                        text = "Missing Text",
                    modifier = Modifier.size(42.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                }

                // Day Milestone Badge Tag
                Surface(
                    Text(
                        text = "Missing Text",
                    color = if (badge.isUnlocked) badgeColor.copy(alpha = 0.15f) else BentoSurfaceVariant,
                    shape = RoundedCornerShape(8.dp)
                ) {
                        Text(
                            text = "Missing Text",
                        fontSize = 9.sp,
                        Text(
                            text = "Missing Text",
                        fontWeight = FontWeight.ExtraBold,
                        Text(
                            text = "Missing Text",
                        color = if (badge.isUnlocked) badgeColor else BentoOnSurfaceVariant,
                        Text(
                            text = "Missing Text",
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(
                        text = "Missing Text",
                    fontWeight = FontWeight.ExtraBold,
                    Text(
                        text = "Missing Text",
                    fontSize = 13.sp,
                    Text(
                        text = "Missing Text",
                    color = BentoOnSurface,
                    Text(
                        text = "Missing Text",
                    maxLines = 1,
                    Text(
                        text = "Missing Text",
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
                    Text(
                        text = "Missing Text",
                    fontSize = 10.sp,
                    Text(
                        text = "Missing Text",
                    color = BentoOnSurfaceVariant,
                    Text(
                        text = "Missing Text",
                    lineHeight = 13.sp,
                    Text(
                        text = "Missing Text",
                    maxLines = 2,
                    Text(
                        text = "Missing Text",
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(
                    Text(
                        text = "Missing Text",
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                        Text(
                            text = "Missing Text",
                        fontSize = 9.sp,
                        Text(
                            text = "Missing Text",
                        fontWeight = FontWeight.Bold,
                        Text(
                            text = "Missing Text",
                        color = if (badge.isUnlocked) badgeColor else BentoOnSurfaceVariant
                    )
                        Text(
                            text = "Missing Text",
                        fontSize = 9.sp,
                        Text(
                            text = "Missing Text",
                        fontWeight = FontWeight.ExtraBold,
                        Text(
                            text = "Missing Text",
                        color = BentoOnSurface
                    )
                }

                LinearProgressIndicator(
                    progress = { badge.progressPercent / 100f },
                    Text(
                        text = "Missing Text",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(CircleShape),
                    Text(
                        text = "Missing Text",
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
            Text(
                text = "Missing Text",
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.88f),
            shape = RoundedCornerShape(28.dp),
            Text(
                text = "Missing Text",
            color = BentoBackground,
            border = BorderStroke(1.dp, BentoSurfaceVariant)
        ) {
            Column(
                Text(
                    text = "Missing Text",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                // Header
                Row(
                    Text(
                        text = "Missing Text",
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Column {
                                Text(
                                    text = "Missing Text",
                                fontWeight = FontWeight.Black,
                                Text(
                                    text = "Missing Text",
                                fontSize = 18.sp,
                                Text(
                                    text = "Missing Text",
                                color = BentoOnSurface
                            )
                                Text(
                                    text = "Missing Text",
                                fontSize = 12.sp,
                                Text(
                                    text = "Missing Text",
                                color = BentoOnSurfaceVariant,
                                Text(
                                    text = "Missing Text",
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    IconButton(
                        onClick = onDismiss,
                        Text(
                            text = "Missing Text",
                        modifier = Modifier
                            .size(36.dp)
                            .background(BentoSurfaceVariant, CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = BentoOnSurface,
                            Text(
                                text = "Missing Text",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Filter Tabs
                Row(
                    Text(
                        text = "Missing Text",
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("ALL" to "All (36)", "UNLOCKED" to "Unlocked ($unlockedCount)", "LOCKED" to "Locked (${36 - unlockedCount})").forEach { (key, label) ->
                        val isSelected = selectedFilter == key
                        Surface(
                            Text(
                                text = "Missing Text",
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(12.dp))
                                .clickable { selectedFilter = key },
                            Text(
                                text = "Missing Text",
                            color = if (isSelected) BentoPrimary else BentoSurface,
                            border = BorderStroke(1.dp, if (isSelected) BentoPrimary else BentoSurfaceVariant)
                        ) {
                                Text(
                                    text = "Missing Text",
                                fontSize = 11.sp,
                                Text(
                                    text = "Missing Text",
                                fontWeight = FontWeight.Bold,
                                Text(
                                    text = "Missing Text",
                                color = if (isSelected) Color.White else BentoOnSurface,
                                Text(
                                    text = "Missing Text",
                                textAlign = TextAlign.Center,
                                Text(
                                    text = "Missing Text",
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
                    Text(
                        text = "Missing Text",
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
            Text(
                text = "Missing Text",
            color = BentoBackground,
            border = BorderStroke(1.dp, BentoSurfaceVariant),
            Text(
                text = "Missing Text",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
        ) {
            Column(
                Text(
                    text = "Missing Text",
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                    Text(
                        text = "Missing Text",
                    fontWeight = FontWeight.ExtraBold,
                    Text(
                        text = "Missing Text",
                    fontSize = 18.sp,
                    Text(
                        text = "Missing Text",
                    color = BentoOnSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Missing Text",
                    fontSize = 12.sp,
                    Text(
                        text = "Missing Text",
                    color = BentoOnSurfaceVariant
                )
                
                Spacer(modifier = Modifier.height(20.dp))
                
                // Calendar Grid for 30 Days
                LazyVerticalGrid(
                    columns = GridCells.Fixed(5), // 5 columns x 6 rows = 30 days
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    Text(
                        text = "Missing Text",
                    modifier = Modifier.height(300.dp)
                ) {
                    items(totalDaysInView) { index ->
                        val dayNumber = index + 1
                        val isUnlocked = dayNumber <= currentStreak
                        
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            Text(
                                text = "Missing Text",
                            color = if (isUnlocked) Color(0xFFFFE0B2) else BentoSurfaceVariant.copy(alpha = 0.3f),
                            border = BorderStroke(1.dp, if (isUnlocked) Color(0xFFFF9800) else BentoSurfaceVariant),
                            Text(
                                text = "Missing Text",
                            modifier = Modifier.aspectRatio(1f)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                if (isUnlocked) {
                                        Text(
                                            text = "Missing Text",
                                        fontSize = 10.sp,
                                        Text(
                                            text = "Missing Text",
                                        fontWeight = FontWeight.Bold,
                                        Text(
                                            text = "Missing Text",
                                        color = Color(0xFFE65100)
                                    )
                                } else {
                                    Icon(
                                        imageVector = Icons.Default.Lock,
                                        contentDescription = "Locked",
                                        tint = BentoOnSurfaceVariant,
                                        Text(
                                            text = "Missing Text",
                                        modifier = Modifier.size(16.dp)
                                    )
                                        Text(
                                            text = "Missing Text",
                                        fontSize = 10.sp,
                                        Text(
                                            text = "Missing Text",
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
                    Text(
                        text = "Missing Text",
                    modifier = Modifier.fillMaxWidth()
                ) {
            }
        }
    }
}

@Composable
fun LiveCompetitionCard(
    viewModel: MainViewModel,
    studentName: String
) {
    val liveArenaStats by viewModel.liveArenaStats.collectAsState()
    val formattedTotal = remember(liveArenaStats.totalActiveAspirants) {
        java.text.NumberFormat.getInstance().format(liveArenaStats.totalActiveAspirants)
    }

    Surface(
        Text(
            text = "Missing Text",
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable { viewModel.navigateToScreen(Screen.MOCK_TEST_SERIES_LIST) },
        shape = RoundedCornerShape(16.dp),
        Text(
            text = "Missing Text",
        color = Color(0xFF0F172A), // Dark Midnight Competition Canvas
        border = BorderStroke(1.dp, Color(0xFF334155))
    ) {
        Column(
            Text(
                text = "Missing Text",
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Header Row with Live Pulse Indicator & Toggle Button
            Row(
                Text(
                    text = "Missing Text",
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    Text(
                        text = "Missing Text",
                    modifier = Modifier.weight(1f)
                ) {
                        text = "NTA Live Arena",
                        fontWeight = FontWeight.ExtraBold,
                        Text(
                            text = "Missing Text",
                        fontSize = 13.5.sp,
                        Text(
                            text = "Missing Text",
                        color = Color.White
                    )
                    Surface(
                        Text(
                            text = "Missing Text",
                        color = Color(0xFF991B1B),
                        shape = RoundedCornerShape(6.dp)
                    ) {
                            Text(
                                text = "Missing Text",
                            fontSize = 8.5.sp,
                            Text(
                                text = "Missing Text",
                            fontWeight = FontWeight.ExtraBold,
                            Text(
                                text = "Missing Text",
                            color = Color.White,
                            Text(
                                text = "Missing Text",
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp),
                            Text(
                                text = "Missing Text",
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }

                Surface(
                    Text(
                        text = "Missing Text",
                    color = Color(0xFF1E293B),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color(0xFF38BDF8))
                ) {
                        Text(
                            text = "Missing Text",
                        fontSize = 10.5.sp,
                        Text(
                            text = "Missing Text",
                        fontWeight = FontWeight.Bold,
                        Text(
                            text = "Missing Text",
                        color = Color(0xFF38BDF8),
                        Text(
                            text = "Missing Text",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        Text(
                            text = "Missing Text",
                        maxLines = 1,
                        softWrap = false
                    )
                }
            }
        }
    }
}


// --- 30-DAY MONTHLY BADGE SECTION ON DASHBOARD ---
@Composable
fun Monthly30DayBadgeSection(
    monthlyBadges: List<com.example.model.MonthlyDailyBadge>,
    todayBadge: com.example.model.MonthlyDailyBadge,
    isTodayBadgeClaimed: Boolean,
    onClaimTodayBadge: () -> Unit,
    onSelectBadgeAvatar: (String) -> Unit = {}
) {
    val currentMonthName = monthlyBadges.firstOrNull()?.monthName ?: "Current Month"
    val unlockedCount = monthlyBadges.count { it.isUnlocked }

    Surface(
        shape = RoundedCornerShape(16.dp),
        Text(
            text = "Missing Text",
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        Text(
            text = "Missing Text",
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            Text(
                text = "Missing Text",
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header & Claim Button in one line
            Row(
                Text(
                    text = "Missing Text",
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Missing Text",
                        fontWeight = FontWeight.ExtraBold,
                        Text(
                            text = "Missing Text",
                        fontSize = 14.sp,
                        Text(
                            text = "Missing Text",
                        color = BentoOnSurface
                    )
                        Text(
                            text = "Missing Text",
                        fontSize = 11.sp,
                        Text(
                            text = "Missing Text",
                        color = BentoOnSurfaceVariant
                    )
                }

                if (!isTodayBadgeClaimed) {
                    val infiniteTransition = rememberInfiniteTransition(label = "today_badge_pulse")
                    val pulseScale by infiniteTransition.animateFloat(
                        initialValue = 0.95f,
                        targetValue = 1.05f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(800, easing = FastOutSlowInEasing),
                            repeatMode = RepeatMode.Reverse
                        ),
                        label = "pulse"
                    )

                    Button(
                        onClick = onClaimTodayBadge,
                        colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                        Text(
                            text = "Missing Text",
                        modifier = Modifier.graphicsLayer {
                            scaleX = pulseScale
                            scaleY = pulseScale
                        }
                    ) {
                            Text(
                                text = "Missing Text",
                            fontSize = 11.sp,
                            Text(
                                text = "Missing Text",
                            fontWeight = FontWeight.ExtraBold,
                            Text(
                                text = "Missing Text",
                            color = Color.White
                        )
                    }
                } else {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        Text(
                            text = "Missing Text",
                        color = BentoPrimaryContainer,
                        border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.3f))
                    ) {
                            Text(
                                text = "Missing Text",
                            fontSize = 11.sp,
                            Text(
                                text = "Missing Text",
                            fontWeight = FontWeight.ExtraBold,
                            Text(
                                text = "Missing Text",
                            color = BentoPrimary,
                            Text(
                                text = "Missing Text",
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            // Badges Row
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 0.dp)
            ) {
                items(monthlyBadges) { badge ->
                    val badgeColor = parseHexColor(badge.badgeColorHex)

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        Text(
                            text = "Missing Text",
                        color = if (badge.isUnlocked) badgeColor.copy(alpha = 0.12f) else BentoSurfaceVariant.copy(alpha = 0.25f),
                        border = BorderStroke(
                            if (badge.isToday) 2.dp else 1.dp,
                            if (badge.isToday) badgeColor else if (badge.isUnlocked) badgeColor.copy(alpha = 0.6f) else BentoSurfaceVariant
                        ),
                        Text(
                            text = "Missing Text",
                        modifier = Modifier
                            .width(76.dp)
                            .then(
                                if (badge.isUnlocked) Modifier.clickable { onSelectBadgeAvatar(badge.emojiIcon) } else Modifier
                            )
                    ) {
                        Column(
                            Text(
                                text = "Missing Text",
                            modifier = Modifier.padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                    Text(
                                        text = "Missing Text",
                                    fontSize = 24.sp,
                                    Text(
                                        text = "Missing Text",
                                    modifier = Modifier.then(
                                        if (!badge.isUnlocked) Modifier.graphicsLayer { alpha = 0.35f } else Modifier
                                    )
                                )

                                if (!badge.isUnlocked) {
                                    Surface(
                                        Text(
                                            text = "Missing Text",
                                        color = Color.Black.copy(alpha = 0.65f),
                                        shape = CircleShape,
                                        Text(
                                            text = "Missing Text",
                                        modifier = Modifier.size(20.dp)
                                    ) {
                                        Box(contentAlignment = Alignment.Center) {
                                            Icon(
                                                Icons.Default.Lock,
                                                contentDescription = "Locked",
                                                tint = Color.White,
                                                Text(
                                                    text = "Missing Text",
                                                modifier = Modifier.size(11.dp)
                                            )
                                        }
                                    }
                                }
                            }

                                Text(
                                    text = "Missing Text",
                                fontWeight = FontWeight.ExtraBold,
                                Text(
                                    text = "Missing Text",
                                fontSize = 10.5.sp,
                                Text(
                                    text = "Missing Text",
                                color = if (badge.isUnlocked) BentoOnSurface else BentoOnSurfaceVariant
                            )

                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                Text(
                                    text = "Missing Text",
                                color = if (badge.isToday) Color(0xFFFF6D00) else if (badge.isUnlocked) badgeColor else BentoSurfaceVariant
                            ) {
                                    Text(
                                        text = "Missing Text",
                                    fontSize = 7.5.sp,
                                    Text(
                                        text = "Missing Text",
                                    fontWeight = FontWeight.ExtraBold,
                                    Text(
                                        text = "Missing Text",
                                    color = Color.White,
                                    Text(
                                        text = "Missing Text",
                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
// --- STUDENT ANALYTICS CARD WITH PIE CHART & HISTOGRAM ---
@Composable
fun StudentAnalyticsCard(
    currentStreakDays: Int,
    selectedExam: ExamType
) {
    var selectedTab by remember { mutableStateOf(0) } // 0: Histogram, 1: Pie Chart

    Surface(
        shape = RoundedCornerShape(22.dp),
        Text(
            text = "Missing Text",
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        Text(
            text = "Missing Text",
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            Text(
                text = "Missing Text",
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header Row
            Row(
                Text(
                    text = "Missing Text",
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                        Text(
                            text = "Missing Text",
                        fontWeight = FontWeight.ExtraBold,
                        Text(
                            text = "Missing Text",
                        fontSize = 15.sp,
                        Text(
                            text = "Missing Text",
                        color = BentoOnSurface
                    )
                        Text(
                            text = "Missing Text",
                        fontSize = 11.sp,
                        Text(
                            text = "Missing Text",
                        color = BentoOnSurfaceVariant
                    )
                }

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    Text(
                        text = "Missing Text",
                    color = BentoPrimaryContainer,
                    border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.3f))
                ) {
                        Text(
                            text = "Missing Text",
                        fontSize = 11.sp,
                        Text(
                            text = "Missing Text",
                        fontWeight = FontWeight.ExtraBold,
                        Text(
                            text = "Missing Text",
                        color = BentoPrimary,
                        Text(
                            text = "Missing Text",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            // Tab Selector Switch
            Row(
                Text(
                    text = "Missing Text",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(BentoSurfaceVariant.copy(alpha = 0.35f))
                    .padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Surface(
                    Text(
                        text = "Missing Text",
                    modifier = Modifier
                        .weight(1f)
                        .clickable { selectedTab = 0 },
                    shape = RoundedCornerShape(10.dp),
                    Text(
                        text = "Missing Text",
                    color = if (selectedTab == 0) BentoSurface else Color.Transparent,
                    shadowElevation = if (selectedTab == 0) 2.dp else 0.dp
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        Text(
                            text = "Missing Text",
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                            Text(
                                text = "Missing Text",
                            fontSize = 11.5.sp,
                            Text(
                                text = "Missing Text",
                            fontWeight = if (selectedTab == 0) FontWeight.ExtraBold else FontWeight.Medium,
                            Text(
                                text = "Missing Text",
                            color = if (selectedTab == 0) BentoPrimary else BentoOnSurfaceVariant
                        )
                    }
                }

                Surface(
                    Text(
                        text = "Missing Text",
                    modifier = Modifier
                        .weight(1f)
                        .clickable { selectedTab = 1 },
                    shape = RoundedCornerShape(10.dp),
                    Text(
                        text = "Missing Text",
                    color = if (selectedTab == 1) BentoSurface else Color.Transparent,
                    shadowElevation = if (selectedTab == 1) 2.dp else 0.dp
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        Text(
                            text = "Missing Text",
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                            Text(
                                text = "Missing Text",
                            fontSize = 11.5.sp,
                            Text(
                                text = "Missing Text",
                            fontWeight = if (selectedTab == 1) FontWeight.ExtraBold else FontWeight.Medium,
                            Text(
                                text = "Missing Text",
                            color = if (selectedTab == 1) BentoPrimary else BentoOnSurfaceVariant
                        )
                    }
                }
            }

            if (selectedTab == 0) {
                PieChartContent(selectedExam = selectedExam)
            } else {
                HistogramChartContent()
            }

            Divider(color = BentoSurfaceVariant.copy(alpha = 0.5f), thickness = 1.dp)

            // Metrics Summary
            Row(
                Text(
                    text = "Missing Text",
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                MetricPill(icon = "⚡", label = "Daily Avg", value = "3.4 hrs/day")
                MetricPill(icon = "🎯", label = "Accuracy", value = "86.4%")
                MetricPill(icon = "📝", label = "Qs Solved", value = "1,240 Qs")
            }
        }
    }
}

@Composable
fun HistogramChartContent() {
    val weekDays = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    val studyHours = listOf(2.5f, 3.8f, 1.8f, 4.2f, 2.9f, 5.1f, 3.5f)
    val maxHours = 6.0f

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
        verticalArrangement = Arrangement.spacedBy(12.dp),
        Text(
            text = "Missing Text",
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            Text(
                text = "Missing Text",
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .padding(horizontal = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            weekDays.forEachIndexed { index, day ->
                val hours = studyHours[index]
                val barFraction = (hours / maxHours) * animatedProgress

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom,
                    Text(
                        text = "Missing Text",
                    modifier = Modifier.weight(1f)
                ) {
                        Text(
                            text = "Missing Text",
                        fontSize = 10.sp,
                        Text(
                            text = "Missing Text",
                        fontWeight = FontWeight.Bold,
                        Text(
                            text = "Missing Text",
                        color = BentoPrimary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        Text(
                            text = "Missing Text",
                        modifier = Modifier
                            .width(20.dp)
                            .fillMaxHeight(barFraction.coerceIn(0.08f, 1f))
                            .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        BentoPrimary,
                                        Color(0xFF3B82F6).copy(alpha = 0.6f)
                                    )
                                )
                            )
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Missing Text",
                        fontSize = 11.sp,
                        Text(
                            text = "Missing Text",
                        fontWeight = FontWeight.Bold,
                        Text(
                            text = "Missing Text",
                        color = BentoOnSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
fun PieChartContent(selectedExam: ExamType) {
    val subjects = if (selectedExam == ExamType.NEET_UG) {
        listOf("Biology 🧬" to 0.45f, "Physics ⚡" to 0.28f, "Chemistry 🧪" to 0.27f)
    } else {
        listOf("Maths 📐" to 0.38f, "Physics ⚡" to 0.32f, "Chemistry 🧪" to 0.30f)
    }

    val colors = listOf(
        Color(0xFFEF4444), // Vibrant Red
        Color(0xFF10B981), // Vibrant Green
        Color(0xFF3B82F6)  // Vibrant Blue
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

    Row(
        Text(
            text = "Missing Text",
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Donut Canvas
        Box(
            contentAlignment = Alignment.Center,
            Text(
                text = "Missing Text",
            modifier = Modifier.size(125.dp)
        ) {
            Canvas(modifier = Modifier.size(115.dp)) {
                var startAngle = -90f
                subjects.forEachIndexed { index, pair ->
                    val sweepAngle = pair.second * 360f * animatedSweep
                    drawArc(
                        Text(
                            text = "Missing Text",
                        color = colors[index % colors.size],
                        startAngle = startAngle,
                        sweepAngle = sweepAngle,
                        useCenter = false,
                        style = Stroke(width = 22.dp.toPx(), cap = StrokeCap.Round)
                    )
                    startAngle += pair.second * 360f
                }
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Missing Text",
                    fontWeight = FontWeight.Black,
                    Text(
                        text = "Missing Text",
                    fontSize = 15.sp,
                    Text(
                        text = "Missing Text",
                    color = BentoOnSurface
                )
                    Text(
                        text = "Missing Text",
                    fontSize = 9.5.sp,
                    Text(
                        text = "Missing Text",
                    fontWeight = FontWeight.Bold,
                    Text(
                        text = "Missing Text",
                    color = BentoOnSurfaceVariant
                )
            }
        }

        // Legend Column
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            Text(
                text = "Missing Text",
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        ) {
            subjects.forEachIndexed { index, pair ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    Text(
                        text = "Missing Text",
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Box(
                            Text(
                                text = "Missing Text",
                            modifier = Modifier
                                .size(10.dp)
                                .clip(CircleShape)
                                .background(colors[index % colors.size])
                        )
                            Text(
                                text = "Missing Text",
                            fontSize = 12.sp,
                            Text(
                                text = "Missing Text",
                            fontWeight = FontWeight.Bold,
                            Text(
                                text = "Missing Text",
                            color = BentoOnSurface
                        )
                    }

                        Text(
                            text = "Missing Text",
                        fontSize = 12.sp,
                        Text(
                            text = "Missing Text",
                        fontWeight = FontWeight.ExtraBold,
                        Text(
                            text = "Missing Text",
                        color = colors[index % colors.size]
                    )
                }
            }
        }
    }
}

@Composable
fun MetricPill(icon: String, label: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
                text = value,
                fontSize = 12.sp,
                Text(
                    text = "Missing Text",
                fontWeight = FontWeight.ExtraBold,
                Text(
                    text = "Missing Text",
                color = BentoOnSurface
            )
        }
            Text(
                text = "Missing Text",
            fontSize = 9.5.sp,
            Text(
                text = "Missing Text",
            color = BentoOnSurfaceVariant,
            Text(
                text = "Missing Text",
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
        Text(
            text = "Missing Text",
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        shadowElevation = 8.dp,
        Text(
            text = "Missing Text",
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            Text(
                text = "Missing Text",
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(horizontal = 4.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavBottomItem(
                Text(
                    text = "Missing Text",
                modifier = Modifier.weight(1f),
                title = "Home",
                iconEmoji = "⚡",
                isSelected = currentScreen == Screen.HOME,
                onClick = { onNavigate(Screen.HOME) }
            )
            NavBottomItem(
                Text(
                    text = "Missing Text",
                modifier = Modifier.weight(1f),
                title = "Syllabus",
                iconEmoji = "📚",
                isSelected = currentScreen == Screen.TOPIC_LIST,
                onClick = { onNavigate(Screen.TOPIC_LIST) }
            )
            NavBottomItem(
                Text(
                    text = "Missing Text",
                modifier = Modifier.weight(1f),
                title = "Analytics",
                iconEmoji = "📊",
                isSelected = currentScreen == Screen.ANALYTICS,
                onClick = { onNavigate(Screen.ANALYTICS) }
            )
            NavBottomItem(
                Text(
                    text = "Missing Text",
                modifier = Modifier.weight(1f),
                title = "PYQs",
                iconEmoji = "📜",
                isSelected = currentScreen == Screen.PYQ_PAPERS,
                onClick = { onNavigate(Screen.PYQ_PAPERS) }
            )
            NavBottomItem(
                Text(
                    text = "Missing Text",
                modifier = Modifier.weight(1f),
                title = "Profile",
                iconEmoji = "👤",
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
    iconEmoji: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val activeColor = BentoPrimary
    val inactiveColor = BentoOnSurfaceVariant

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        Text(
            text = "Missing Text",
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .padding(horizontal = 2.dp, vertical = 4.dp)
            .testTag("nav_bottom_${title.lowercase()}")
    ) {
        Surface(
            shape = CircleShape,
            Text(
                text = "Missing Text",
            color = if (isSelected) activeColor.copy(alpha = 0.16f) else Color.Transparent,
            Text(
                text = "Missing Text",
            modifier = Modifier.size(32.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = "Missing Text",
                    fontSize = 17.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Missing Text",
            fontSize = 10.5.sp,
            Text(
                text = "Missing Text",
            fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Bold,
            Text(
                text = "Missing Text",
            color = if (isSelected) activeColor else inactiveColor,
            Text(
                text = "Missing Text",
            maxLines = 1,
            Text(
                text = "Missing Text",
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun PreplexaAiDoubtCard(
    selectedExam: ExamType,
    onOpenAiSolver: () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "ai_card_pulse")
    val glowScale by infiniteTransition.animateFloat(
        initialValue = 0.98f,
        targetValue = 1.02f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse"
    )

    val floatY by infiniteTransition.animateFloat(
        initialValue = -12f,
        targetValue = 12f,
        animationSpec = infiniteRepeatable(
            animation = tween(2500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "float"
    )

    Surface(
        onClick = onOpenAiSolver,
        Text(
            text = "Missing Text",
        modifier = Modifier
            .fillMaxWidth()
            .testTag("open_perplexa_ai_solver_card"),
        shape = RoundedCornerShape(22.dp),
        Text(
            text = "Missing Text",
        color = BentoSurface,
        border = BorderStroke(1.5.dp, BentoPrimary.copy(alpha = 0.5f)),
        shadowElevation = 3.dp
    ) {
        Box(
            Text(
                text = "Missing Text",
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(22.dp))
        ) {
            // Background Animation Graphics
            if (selectedExam == ExamType.NEET_UG) {
                // NEET: Biology
                    Text(
                        text = "Missing Text",
                    fontSize = 72.sp, 
                    Text(
                        text = "Missing Text",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = (20).dp, y = floatY.dp)
                        .alpha(0.12f)
                )
                    Text(
                        text = "Missing Text",
                    fontSize = 48.sp, 
                    Text(
                        text = "Missing Text",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = (-40).dp, y = (floatY * 0.5f).dp)
                        .alpha(0.1f)
                )
                    Text(
                        text = "Missing Text",
                    fontSize = 54.sp, 
                    Text(
                        text = "Missing Text",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(x = (-50).dp, y = (-floatY * 0.8f).dp)
                        .alpha(0.1f)
                )
            } else {
                // JEE: Rocket & Physics
                    Text(
                        text = "Missing Text",
                    fontSize = 72.sp, 
                    Text(
                        text = "Missing Text",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset(x = (20).dp, y = floatY.dp)
                        .alpha(0.12f)
                )
                    Text(
                        text = "Missing Text",
                    fontSize = 40.sp, 
                    Text(
                        text = "Missing Text",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = (-50).dp, y = (-floatY * 0.6f).dp)
                        .alpha(0.1f)
                )
                    Text(
                        text = "Missing Text",
                    fontSize = 54.sp, 
                    Text(
                        text = "Missing Text",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(x = (-60).dp, y = (floatY * 0.7f).dp)
                        .alpha(0.1f)
                )
            }

            Column(
                Text(
                    text = "Missing Text",
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Header: Perplexa Icon + Title + Gemini Badge
                Row(
                    Text(
                        text = "Missing Text",
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Row(
                        Text(
                            text = "Missing Text",
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Surface(
                            shape = CircleShape,
                            Text(
                                text = "Missing Text",
                            color = BentoPrimaryContainer,
                            border = BorderStroke(1.5.dp, BentoPrimary),
                            Text(
                                text = "Missing Text",
                            modifier = Modifier
                                .size(44.dp)
                                .graphicsLayer {
                                    scaleX = glowScale
                                    scaleY = glowScale
                                }
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                            }
                        }

                        Column(modifier = Modifier.weight(1f)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                    Text(
                                        text = "Missing Text",
                                    fontWeight = FontWeight.ExtraBold,
                                    Text(
                                        text = "Missing Text",
                                    fontSize = 15.sp,
                                    Text(
                                        text = "Missing Text",
                                    color = BentoOnSurface,
                                    Text(
                                        text = "Missing Text",
                                    maxLines = 1,
                                    Text(
                                        text = "Missing Text",
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                                Text(
                                    text = "Missing Text",
                                fontSize = 11.5.sp,
                                Text(
                                    text = "Missing Text",
                                color = BentoOnSurfaceVariant,
                                Text(
                                    text = "Missing Text",
                                maxLines = 1,
                                Text(
                                    text = "Missing Text",
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        Text(
                            text = "Missing Text",
                        color = Color(0xFF10B981).copy(alpha = 0.15f),
                        border = BorderStroke(1.dp, Color(0xFF10B981)),
                        Text(
                            text = "Missing Text",
                        modifier = Modifier.padding(start = 6.dp)
                    ) {
                            Text(
                                text = "Missing Text",
                            fontSize = 9.sp,
                            Text(
                                text = "Missing Text",
                            fontWeight = FontWeight.ExtraBold,
                            Text(
                                text = "Missing Text",
                            color = Color(0xFF10B981),
                            Text(
                                text = "Missing Text",
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                        )
                    }
                }

                // Description Text
                    Text(
                        text = "Missing Text",
                    fontSize = 12.sp,
                    Text(
                        text = "Missing Text",
                    color = BentoOnSurfaceVariant,
                    Text(
                        text = "Missing Text",
                    lineHeight = 16.sp,
                    Text(
                        text = "Missing Text",
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(start = 4.dp, bottom = 4.dp)
                )

                // Action Launch Button
                Button(
                    onClick = onOpenAiSolver,
                    colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                    shape = RoundedCornerShape(14.dp),
                    Text(
                        text = "Missing Text",
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("launch_ai_solver_button")
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        Text(
                            text = "Missing Text",
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                            Text(
                                text = "Missing Text",
                            fontWeight = FontWeight.ExtraBold,
                            Text(
                                text = "Missing Text",
                            fontSize = 14.sp,
                            Text(
                                text = "Missing Text",
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            tint = Color.White,
                            Text(
                                text = "Missing Text",
                            modifier = Modifier.size(16.dp)
                        )
                    }
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
        Text(
            text = "Missing Text",
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
                    Text(
                        text = "Missing Text",
                    color = baseColor.copy(alpha = alpha * 0.7f),
                    center = androidx.compose.ui.geometry.Offset(currentX, currentY),
                    radius = radius
                )

                // White Specular Highlight
                drawCircle(
                    Text(
                        text = "Missing Text",
                    color = Color.White.copy(alpha = alpha * 0.85f),
                    center = androidx.compose.ui.geometry.Offset(currentX - radius * 0.32f, currentY - radius * 0.32f),
                    radius = radius * 0.26f
                )
            }
        }
    }
}
