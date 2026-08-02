package com.example.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
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
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
            in 5..11 -> "Good Morning, $studentName! 🌅"
            in 12..16 -> "Good Afternoon, $studentName! 🚀"
            in 17..21 -> "Good Evening, $studentName! ✨"
            else -> "Night Owl Study Time, $studentName! 🌙"
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
                    // Global Dark/Light Theme Toggle Button
                    IconButton(
                        onClick = { viewModel.toggleDarkMode() },
                        modifier = Modifier.testTag("top_bar_theme_toggle_button")
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

                    // Profile Avatar Icon Button
                    IconButton(
                        onClick = { viewModel.navigateToScreen(Screen.PROFILE) },
                        modifier = Modifier
                            .padding(end = 4.dp)
                            .testTag("top_bar_profile_button")
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = BentoPrimaryContainer,
                            border = BorderStroke(1.5.dp, Brush.horizontalGradient(listOf(BentoPrimary, Color(0xFFF59E0B)))),
                            shadowElevation = 2.dp,
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(studentAvatar, fontSize = 18.sp)
                            }
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BentoBackground)
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            ExamEnvironmentBackground(selectedExam = selectedExam)

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 18.dp),
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
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
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

            // 1. GREETING BANNER
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    shape = RoundedCornerShape(24.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.dp, BentoSurfaceVariant)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        BentoPrimaryContainer.copy(alpha = 0.5f),
                                        BentoSurface
                                    )
                                )
                            )
                            .padding(20.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = greetingText,
                                    fontWeight = FontWeight.Black,
                                    fontSize = 18.sp,
                                    color = BentoOnSurface
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Targeting ${selectedExam.displayName} • Keep pushing daily!",
                                    fontSize = 12.sp,
                                    color = BentoOnSurfaceVariant,
                                    fontWeight = FontWeight.Medium
                                )
                            }

                            // News / Notification Icon
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(4.dp),
                                modifier = Modifier
                                    .clickable { showNewsDialog = true }
                                    .padding(4.dp)
                            ) {
                                Surface(
                                    shape = CircleShape,
                                    color = BentoPrimaryContainer,
                                    border = BorderStroke(2.dp, Brush.horizontalGradient(listOf(BentoPrimary, Color(0xFF10B981)))),
                                    shadowElevation = 3.dp,
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
                                Text(
                                    text = "News",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = BentoPrimary
                                )
                            }
                        }
                    }
                }
            }

            // 2. EXAM SELECTORS (NEET UG & JEE MAINS ONLY)
            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
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

            // 2.5 LIVE COMPETITION ARENA & REAL-TIME LEADERBOARD
            item {
                LiveCompetitionCard(viewModel = viewModel, studentName = studentName)
            }

            // 3. SNAPCHAT-STYLE STREAK CARD (CLEAN & COMPACT)
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth().clickable { showStreakCalendarModal = true },
                    shape = RoundedCornerShape(18.dp),
                    color = Color(0xFF121829), // Rich Dark Canvas
                    border = BorderStroke(1.dp, Color(0xFF2E3856))
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // Compact Streak Header Row
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
                                    shape = CircleShape,
                                    color = Color(0xFF331600),
                                    border = BorderStroke(1.dp, Color(0xFFFF6D00)),
                                    modifier = Modifier.size(34.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text("🔥", fontSize = 18.sp)
                                    }
                                }

                                Text(
                                    text = "$currentStreakDays Days Streak",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 14.sp,
                                    color = Color(0xFFFF9100),
                                    maxLines = 1
                                )
                                Surface(
                                    color = Color(0xFF003B00),
                                    shape = RoundedCornerShape(6.dp),
                                    border = BorderStroke(1.dp, Color(0xFF00E676))
                                ) {
                                    Text(
                                        text = "ACTIVE",
                                        fontSize = 8.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color(0xFF00E676),
                                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                    )
                                }
                            }

                            Text(
                                text = "Calendar 📅",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFFB74D)
                            )
                        }

                        // Compact Days Tracker Row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            streakDays.forEach { (dayLetter, isActive, dayName) ->
                                Column(
                                    modifier = Modifier.weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(3.dp)
                                ) {
                                    Surface(
                                        shape = CircleShape,
                                        color = if (isActive) Color(0xFFFF6D00).copy(alpha = 0.2f) else Color(0xFF1E293B),
                                        border = BorderStroke(
                                            1.dp,
                                            if (isActive) Color(0xFFFF9100) else Color(0xFF334155)
                                        ),
                                        modifier = Modifier.size(28.dp)
                                    ) {
                                        Box(contentAlignment = Alignment.Center) {
                                            if (isActive) {
                                                Text("🔥", fontSize = 12.sp)
                                            } else {
                                                Text(dayLetter, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF64748B))
                                            }
                                        }
                                    }

                                    Text(
                                        text = dayName,
                                        fontSize = 8.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isActive) Color(0xFFFFB74D) else Color(0xFF64748B),
                                        maxLines = 1,
                                        softWrap = false
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 4. DAILY BADGES & ACHIEVEMENTS (365-DAY ROADMAP OF 36 BADGES)
            item {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text("🏆", fontSize = 20.sp)
                            Column {
                                Text(
                                    text = "365-Day Badges",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 16.sp,
                                    color = BentoOnSurface
                                )
                                Text(
                                    text = "1 Badge Every 10 Days • 36 Total",
                                    fontSize = 10.sp,
                                    color = BentoOnSurfaceVariant,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }

                        Surface(
                            color = BentoPurpleBg,
                            shape = RoundedCornerShape(14.dp),
                            border = BorderStroke(1.dp, BentoPurpleBorder),
                            modifier = Modifier
                                .clickable { showAllBadgesModal = true }
                                .testTag("view_all_36_badges_button")
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text(
                                    text = "$unlockedCount/36 Unlocked",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = BentoPurpleBadge
                                )
                                Text("➔", fontSize = 10.sp, color = BentoPurpleBadge)
                            }
                        }
                    }

                    // Horizontal Scrollable Badge Row for Dashboard Quick View
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(14.dp),
                        contentPadding = PaddingValues(end = 12.dp)
                    ) {
                        items(badges) { badge ->
                            BadgeCard(badge = badge, onClick = { showAllBadgesModal = true })
                        }
                    }
                }
            }

            // 5. DASHBOARD NAVIGATION BAR (QUICK NAV CARDS BELOW BADGES)
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.dp, BentoSurfaceVariant)
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
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
                                Text("🧩", fontSize = 20.sp)
                                Column {
                                    Text(
                                        text = "App Navigation Bar",
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 16.sp,
                                        color = BentoOnSurface
                                    )
                                    Text(
                                        text = "Quickly switch between main pages",
                                        fontSize = 11.sp,
                                        color = BentoOnSurfaceVariant,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            }
                        }

                        // Grid of Navigation Tiles
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            DashboardNavTile(
                                modifier = Modifier.weight(1f),
                                title = "Home",
                                subtitle = "Dashboard",
                                iconEmoji = "⚡",
                                isActive = true,
                                onClick = { viewModel.navigateToScreen(Screen.HOME) }
                            )

                            DashboardNavTile(
                                modifier = Modifier.weight(1f),
                                title = "Syllabus",
                                subtitle = "Library",
                                iconEmoji = "📚",
                                isActive = false,
                                onClick = { viewModel.navigateToScreen(Screen.TOPIC_LIST) }
                            )

                            DashboardNavTile(
                                modifier = Modifier.weight(1f),
                                title = "Analytics",
                                subtitle = "Reports",
                                iconEmoji = "📈",
                                isActive = false,
                                onClick = { viewModel.navigateToScreen(Screen.ANALYTICS) }
                            )

                            DashboardNavTile(
                                modifier = Modifier.weight(1f),
                                title = "PYQ Papers",
                                subtitle = "10 Years",
                                iconEmoji = "📜",
                                isActive = false,
                                onClick = { viewModel.navigateToScreen(Screen.PYQ_PAPERS) }
                            )

                            DashboardNavTile(
                                modifier = Modifier.weight(1f),
                                title = "Profile",
                                subtitle = "Account",
                                iconEmoji = "👤",
                                isActive = false,
                                onClick = { viewModel.navigateToScreen(Screen.PROFILE) }
                            )
                        }
                    }
                }
            }
        } // Closes LazyColumn

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
            verticalArrangement = Arrangement.spacedBy(10.dp)
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
                    maxLines = 2,
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
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
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

@Composable
fun LiveCompetitionCard(
    viewModel: MainViewModel,
    studentName: String
) {
    var isExpanded by remember { mutableStateOf(false) }
    var activeTab by remember { mutableStateOf("battle") } // "battle" or "leaderboard"

    val liveArenaStats by viewModel.liveArenaStats.collectAsState()
    val formattedTotal = remember(liveArenaStats.totalActiveAspirants) {
        java.text.NumberFormat.getInstance().format(liveArenaStats.totalActiveAspirants)
    }
    val formattedNeet = remember(liveArenaStats.neetLiveAspirants) {
        java.text.NumberFormat.getInstance().format(liveArenaStats.neetLiveAspirants)
    }
    val formattedJee = remember(liveArenaStats.jeeLiveAspirants) {
        java.text.NumberFormat.getInstance().format(liveArenaStats.jeeLiveAspirants)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable { isExpanded = !isExpanded },
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFF0F172A), // Dark Midnight Competition Canvas
        border = BorderStroke(1.dp, Color(0xFF334155))
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Header Row with Live Pulse Indicator & Toggle Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("⚡", fontSize = 18.sp)
                    Text(
                        text = "NTA Live Arena",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 13.5.sp,
                        color = Color.White
                    )
                    Surface(
                        color = Color(0xFF991B1B),
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            text = "LIVE",
                            fontSize = 8.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                    }
                }

                Surface(
                    color = Color(0xFF1E293B),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color(0xFF38BDF8))
                ) {
                    Text(
                        text = if (isExpanded) "Hide 🔼" else "🔴 $formattedTotal Active ⚔️",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF38BDF8),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            if (isExpanded) {
                Spacer(modifier = Modifier.height(2.dp))

                // Tab Selector: Live Battles vs Real-time Leaderboard
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Surface(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .clickable { activeTab = "battle" },
                        color = if (activeTab == "battle") Color(0xFF1E293B) else Color.Transparent,
                        border = BorderStroke(1.dp, if (activeTab == "battle") Color(0xFF38BDF8) else Color(0xFF334155)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "⚔️ Live Battles",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = if (activeTab == "battle") Color(0xFF38BDF8) else Color(0xFF94A3B8),
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }

                    Surface(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .clickable { activeTab = "leaderboard" },
                        color = if (activeTab == "leaderboard") Color(0xFF1E293B) else Color.Transparent,
                        border = BorderStroke(1.dp, if (activeTab == "leaderboard") Color(0xFF38BDF8) else Color(0xFF334155)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "🏆 All-India Leaderboard",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = if (activeTab == "leaderboard") Color(0xFF38BDF8) else Color(0xFF94A3B8),
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }

                if (activeTab == "battle") {
                    // Battle Cards
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        // Challenge 1: Grand PYQ Paper Live Battle
                        Surface(
                            color = Color(0xFF1E293B),
                            shape = RoundedCornerShape(16.dp),
                            border = BorderStroke(1.dp, Color(0xFF3B82F6))
                        ) {
                            Column(
                                modifier = Modifier.padding(12.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
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
                                        Text("🔥", fontSize = 16.sp)
                                        Text(
                                            text = "NEET UG 2024 Live Official Battle",
                                            fontWeight = FontWeight.ExtraBold,
                                            fontSize = 13.sp,
                                            color = Color.White
                                        )
                                    }
                                    Surface(
                                        color = Color(0xFF1E3A8A),
                                        shape = RoundedCornerShape(8.dp)
                                    ) {
                                        Text(
                                            text = "$formattedNeet Live Aspirants",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF60A5FA),
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                                        )
                                    }
                                }

                                Text(
                                    text = "Official NTA Pattern • 200 Questions • Real-Time AIR",
                                    fontSize = 11.sp,
                                    color = Color(0xFF94A3B8)
                                )

                                Button(
                                    onClick = { viewModel.navigateToScreen(Screen.PYQ_PAPERS) },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB)),
                                    shape = RoundedCornerShape(10.dp),
                                    modifier = Modifier.fillMaxWidth(),
                                    contentPadding = PaddingValues(vertical = 8.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Icon(Icons.Default.Star, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                                        Text("Enter NEET UG Live Battle ⚔️", fontWeight = FontWeight.ExtraBold, fontSize = 12.sp, color = Color.White)
                                    }
                                }
                            }
                        }

                        // Challenge 2: JEE Main 2024 Speed Battle
                        Surface(
                            color = Color(0xFF1E293B),
                            shape = RoundedCornerShape(16.dp),
                            border = BorderStroke(1.dp, Color(0xFF8B5CF6))
                        ) {
                            Column(
                                modifier = Modifier.padding(12.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
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
                                        Text("🚀", fontSize = 16.sp)
                                        Text(
                                            text = "JEE Main 2024 Live Speed Challenge",
                                            fontWeight = FontWeight.ExtraBold,
                                            fontSize = 13.sp,
                                            color = Color.White
                                        )
                                    }
                                    Surface(
                                        color = Color(0xFF4C1D95),
                                        shape = RoundedCornerShape(8.dp)
                                    ) {
                                        Text(
                                            text = "$formattedJee Live Aspirants",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFFC084FC),
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                                        )
                                    }
                                }

                                Text(
                                    text = "Official NTA CBT Pattern • PCM Focus • Real-Time Percentile",
                                    fontSize = 11.sp,
                                    color = Color(0xFF94A3B8)
                                )

                                Button(
                                    onClick = { viewModel.navigateToScreen(Screen.PYQ_PAPERS) },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C3AED)),
                                    shape = RoundedCornerShape(10.dp),
                                    modifier = Modifier.fillMaxWidth(),
                                    contentPadding = PaddingValues(vertical = 8.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Icon(Icons.Default.Star, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                                        Text("Enter JEE Main Live Battle 🚀", fontWeight = FontWeight.ExtraBold, fontSize = 12.sp, color = Color.White)
                                    }
                                }
                            }
                        }
                    }
                } else {
                    // Real-Time Live Competitor Feed
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        val liveFeed = remember {
                            listOf(
                                Triple("🥇 Aarav Sharma (Delhi)", "715/720 (AIR #3)", "NEET UG 2024 • 2m ago"),
                                Triple("🥈 Priya Patel (Kota)", "705/720 (AIR #8)", "NEET UG 2023 • 5m ago"),
                                Triple("🥉 Devansh Verma (Lucknow)", "692/720 (AIR #19)", "NEET UG 2022 • 8m ago"),
                                Triple("🎖️ Kavya Nair (Kerala)", "680/720 (AIR #34)", "NEET UG 2021 • 12m ago"),
                                Triple("⚡ You ($studentName)", "Top 5% All-India Rank", "Active Competitor")
                            )
                        }

                        liveFeed.forEach { (student, score, detail) ->
                            Surface(
                                color = Color(0xFF1E293B),
                                shape = RoundedCornerShape(12.dp),
                                border = BorderStroke(1.dp, Color(0xFF334155))
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 12.dp, vertical = 8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = student,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp,
                                            color = Color.White
                                        )
                                        Text(
                                            text = detail,
                                            fontSize = 10.sp,
                                            color = Color(0xFF94A3B8)
                                        )
                                    }

                                    Surface(
                                        color = Color(0xFF065F46),
                                        shape = RoundedCornerShape(6.dp)
                                    ) {
                                        Text(
                                            text = score,
                                            fontWeight = FontWeight.ExtraBold,
                                            fontSize = 11.sp,
                                            color = Color(0xFF34D399),
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

