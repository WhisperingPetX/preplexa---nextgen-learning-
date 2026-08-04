package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.ExamType
import com.example.ui.components.ExamEnvironmentBackground
import com.example.ui.components.AdminPanelDialog
import com.example.ui.components.AdminPasswordDialog
import com.example.ui.components.SubscriptionPlanModal
import com.example.ui.theme.*
import com.example.ui.viewmodel.MainViewModel
import com.example.ui.viewmodel.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(viewModel: MainViewModel) {
    val selectedExam by viewModel.selectedExam.collectAsState()
    val attempts by viewModel.allAttempts.collectAsState()
    val bookmarkedQuestions by viewModel.bookmarkedQuestions.collectAsState()
    val studentName by viewModel.studentName.collectAsState()
    val studentAvatar by viewModel.studentAvatar.collectAsState()
    val supabaseStatus by viewModel.supabaseStatus.collectAsState()
    val isSubscribed by viewModel.isSubscribed.collectAsState()
    val trialDaysLeft by viewModel.trialDaysRemaining.collectAsState()
    val isServiceLocked by viewModel.isServiceLocked.collectAsState()
    val isDarkMode by viewModel.isDarkMode.collectAsState()
    val isAutoRotate by viewModel.isAvatarAutoRotating.collectAsState()

    var showEditProfileDialog by remember { mutableStateOf(false) }
    var showSubscriptionModal by remember { mutableStateOf(false) }
    var showAvatarPopoutModal by remember { mutableStateOf(false) }
    
    // --- Admin Secret Tap Gesture ---
    var profileTapCount by remember { mutableStateOf(0) }
    var showAdminPasswordDialog by remember { mutableStateOf(false) }
    var showAdminPanelDialog by remember { mutableStateOf(false) }

    val totalAttempts = attempts.size
    val totalQuestions = attempts.sumOf { it.totalQuestions }
    val avgScore = if (totalAttempts > 0) attempts.map { it.scorePercent }.average().toInt() else 0
    val streakCount by viewModel.currentStreak.collectAsState()

    // Current Month 30 Badges
    val monthlyBadges = remember { com.example.model.MonthlyBadgeManager.getCurrentMonth30Badges() }
    val currentMonthName = remember { monthlyBadges.firstOrNull()?.monthName ?: "Current Month" }

    val earnedBadges = remember(monthlyBadges) {
        monthlyBadges.map { mb ->
            val color = try {
                Color(android.graphics.Color.parseColor(mb.badgeColorHex))
            } catch (e: Exception) {
                BentoPrimary
            }
            BadgeItem(
                title = mb.title,
                subtitle = if (mb.isUnlocked) "Unlocked in $currentMonthName" else "Locked 🔒",
                emoji = mb.emojiIcon,
                isUnlocked = mb.isUnlocked,
                themeColor = color
            )
        }
    }

    if (showEditProfileDialog) {
        EditProfileDialog(
            currentName = studentName,
            currentAvatar = studentAvatar,
            isAutoRotateCurrent = isAutoRotate,
            onDismiss = { showEditProfileDialog = false },
            onSave = { newName, newAvatar, autoRotate ->
                viewModel.updateStudentProfile(newName, newAvatar, autoRotate)
                showEditProfileDialog = false
            }
        )
    }

    if (showAvatarPopoutModal) {
        AlertDialog(
            onDismissRequest = { showAvatarPopoutModal = false },
            title = {
                Text(
                    text = "🌟 Choose Your Avatar",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp,
                    color = BentoOnSurface
                )
            },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Tap any avatar icon to apply instantly:",
                        fontSize = 12.5.sp,
                        color = BentoOnSurfaceVariant
                    )

                    val popoutAvatars = listOf(
                        "🐺" to "Wolf",
                        "🩺" to "Stethoscope",
                        "🚀" to "Rocket",
                        "🦠" to "Bacteria",
                        "🔬" to "Microscope",
                        "🛸" to "Spaceship"
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        popoutAvatars.take(3).forEach { (emoji, label) ->
                            Surface(
                                onClick = {
                                    viewModel.updateStudentProfile(studentName, emoji, isAutoRotate)
                                    showAvatarPopoutModal = false
                                },
                                shape = RoundedCornerShape(16.dp),
                                color = if (studentAvatar == emoji) BentoPrimaryContainer else BentoSurfaceVariant,
                                border = BorderStroke(1.5.dp, if (studentAvatar == emoji) BentoPrimary else Color.Transparent),
                                modifier = Modifier.weight(1f)
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.padding(vertical = 12.dp)
                                ) {
                                    Text(emoji, fontSize = 28.sp)
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(label, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface)
                                }
                            }
                        }
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        popoutAvatars.drop(3).forEach { (emoji, label) ->
                            Surface(
                                onClick = {
                                    viewModel.updateStudentProfile(studentName, emoji, isAutoRotate)
                                    showAvatarPopoutModal = false
                                },
                                shape = RoundedCornerShape(16.dp),
                                color = if (studentAvatar == emoji) BentoPrimaryContainer else BentoSurfaceVariant,
                                border = BorderStroke(1.5.dp, if (studentAvatar == emoji) BentoPrimary else Color.Transparent),
                                modifier = Modifier.weight(1f)
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.padding(vertical = 12.dp)
                                ) {
                                    Text(emoji, fontSize = 28.sp)
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(label, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface)
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showAvatarPopoutModal = false }) {
                    Text("Close", fontWeight = FontWeight.Bold, color = BentoPrimary)
                }
            }
        )
    }

    if (showSubscriptionModal) {
        SubscriptionPlanModal(viewModel = viewModel, onDismiss = { showSubscriptionModal = false })
    }

    if (showAdminPasswordDialog) {
        AdminPasswordDialog(
            onDismiss = { showAdminPasswordDialog = false },
            onSuccess = {
                showAdminPasswordDialog = false
                showAdminPanelDialog = true
            }
        )
    }

    if (showAdminPanelDialog) {
        AdminPanelDialog(
            viewModel = viewModel,
            onDismiss = { showAdminPanelDialog = false }
        )
    }

    Scaffold(
        containerColor = BentoBackground,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "👤 Student Profile",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp,
                        color = BentoOnSurface
                    )
                },
                navigationIcon = {
                    Surface(
                        color = BentoSurfaceVariant,
                        shape = CircleShape,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                    ) {
                        IconButton(
                            onClick = { viewModel.navigateToScreen(Screen.HOME) },
                            modifier = Modifier.testTag("back_from_profile_button")
                        ) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = BentoOnSurface)
                        }
                    }
                },
                actions = {
                    // Empty for now
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BentoBackground)
            )
        },
        bottomBar = {
            ModernBottomNavigationBar(
                currentScreen = Screen.PROFILE,
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
            ExamEnvironmentBackground(selectedExam = selectedExam)

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 680.dp)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
            // --- 1. STYLISH PROFILE HEADER CARD WITH EDIT NAME & AVATAR ---
            item {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.5.dp, Brush.horizontalGradient(listOf(BentoPrimary, Color(0xFFF59E0B)))),
                    shadowElevation = 6.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                        .clickable {
                            profileTapCount++
                            if (profileTapCount >= 7) {
                                profileTapCount = 0
                                showAdminPasswordDialog = true
                            }
                        }
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            // Avatar Box with Gradient Rim
                            Box(contentAlignment = Alignment.BottomEnd) {
                                Surface(
                                    shape = CircleShape,
                                    color = BentoPrimaryContainer,
                                    border = BorderStroke(2.5.dp, BentoPrimary),
                                    shadowElevation = 4.dp,
                                    modifier = Modifier
                                        .size(72.dp)
                                        .clickable { showAvatarPopoutModal = true }
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        val displayAvatar = if (studentAvatar == "👤" || studentAvatar.isBlank()) "🐺" else studentAvatar
                                        Text(
                                            text = displayAvatar,
                                            fontSize = 36.sp
                                        )
                                    }
                                }

                                Surface(
                                    shape = CircleShape,
                                    color = BentoPrimary,
                                    border = BorderStroke(1.5.dp, Color.White),
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clickable { showAvatarPopoutModal = true }
                                        .testTag("edit_avatar_badge")
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Icon(
                                            imageVector = Icons.Outlined.Edit,
                                            contentDescription = "Edit Profile",
                                            tint = Color.White,
                                            modifier = Modifier.size(13.dp)
                                        )
                                    }
                                }
                            }

                            // User Info
                            Column(modifier = Modifier.weight(1f)) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Text(
                                        text = studentName,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 20.sp,
                                        color = BentoOnSurface
                                    )
                                    IconButton(
                                        onClick = { showEditProfileDialog = true },
                                        modifier = Modifier
                                            .size(24.dp)
                                            .testTag("edit_name_button")
                                    ) {
                                        Icon(
                                            imageVector = Icons.Outlined.Edit,
                                            contentDescription = "Edit Name",
                                            tint = BentoPrimary,
                                            modifier = Modifier.size(16.dp)
                                        )
                                    }
                                }
                                
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = if (selectedExam == ExamType.NEET_UG) "NEET Medical Aspirant" else "JEE Engineering Aspirant",
                                    fontSize = 12.sp,
                                    color = BentoOnSurfaceVariant,
                                    fontWeight = FontWeight.Medium
                                )
                                
                                Spacer(modifier = Modifier.height(8.dp))

                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    // Streak Counter
                                    Surface(
                                        color = Color(0xFFFEF3C7),
                                        border = BorderStroke(1.dp, Color(0xFFFDE68A)),
                                        shape = RoundedCornerShape(12.dp)
                                    ) {
                                        Text(
                                            text = "🔥 $streakCount Day Streak",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color(0xFFD97706),
                                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // --- 2. SUBSCRIPTION PLAN CARD ---
            item {
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.5.dp, Color(0xFFF59E0B).copy(alpha = 0.6f)),
                    shadowElevation = 2.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                Text(if (isSubscribed) "👑" else "🎁", fontSize = 20.sp)
                                Column {
                                    Text(
                                        text = if (isSubscribed) "PRO Scholar Pass" else "30-Day Free Trial",
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 15.sp,
                                        color = BentoOnSurface,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = if (isSubscribed) "Unlimited AI Doubts & PYQ Solutions" else if (trialDaysLeft > 0) "$trialDaysLeft Days Remaining in Trial" else "Trial Expired - Services Locked",
                                        fontSize = 11.sp,
                                        color = if (isServiceLocked) Color(0xFFEF4444) else BentoOnSurfaceVariant,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }

                            Surface(
                                color = if (isSubscribed) Color(0xFFFEF3C7) else if (trialDaysLeft > 0) Color(0xFFD1FAE5) else Color(0xFFFEE2E2),
                                border = BorderStroke(1.dp, if (isSubscribed) Color(0xFFFDE68A) else if (trialDaysLeft > 0) Color(0xFFA7F3D0) else Color(0xFFFCA5A5)),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier.padding(start = 8.dp)
                            ) {
                                Text(
                                    text = if (isSubscribed) "PRO ACTIVE" else if (trialDaysLeft > 0) "$trialDaysLeft DAYS LEFT" else "EXPIRED",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isSubscribed) Color(0xFFD97706) else if (trialDaysLeft > 0) Color(0xFF059669) else Color(0xFFDC2626),
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                Icon(Icons.Outlined.CheckCircle, contentDescription = null, tint = Color(0xFF10B981), modifier = Modifier.size(16.dp))
                                Text("AI Tutor", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface, maxLines = 1, softWrap = false)
                            }
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                Icon(Icons.Outlined.CheckCircle, contentDescription = null, tint = Color(0xFF10B981), modifier = Modifier.size(16.dp))
                                Text("10 Yrs Papers", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface, maxLines = 1, softWrap = false)
                            }
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                Icon(Icons.Outlined.CheckCircle, contentDescription = null, tint = Color(0xFF10B981), modifier = Modifier.size(16.dp))
                                Text("Analytics", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface, maxLines = 1, softWrap = false)
                            }
                        }

                        Button(
                            onClick = { showSubscriptionModal = true },
                            colors = ButtonDefaults.buttonColors(containerColor = if (isServiceLocked) Color(0xFFEF4444) else Color(0xFFF59E0B)),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("view_subscription_plan_button")
                        ) {
                            Text(
                                text = if (isServiceLocked) "🔒 Trial Expired • Choose Plan to Unlock" else "View Membership Plans",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }

            // --- 3. TESTS COMPLETED & ACCURACY STATS ---
            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "Tests & Performance Overview",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 15.sp,
                        color = BentoOnSurface
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        ProfileStatCard(
                            modifier = Modifier.weight(1f),
                            title = "Tests Completed",
                            value = "$totalAttempts",
                            subtitle = "Mock papers done",
                            emoji = "",
                            badgeColor = BentoPurpleBadge
                        )
                        ProfileStatCard(
                            modifier = Modifier.weight(1f),
                            title = "Questions Done",
                            value = "$totalQuestions",
                            subtitle = "Solved in practice",
                            emoji = "",
                            badgeColor = BentoBlueBadge
                        )
                        ProfileStatCard(
                            modifier = Modifier.weight(1f),
                            title = "Avg Accuracy",
                            value = if (totalAttempts > 0) "$avgScore%" else "0%",
                            subtitle = "Overall test score",
                            emoji = "",
                            badgeColor = BentoGreenBadge
                        )
                    }
                }
            }

            // --- 5. EXAM GOAL SWITCHER ---
            item {
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Change Target Entrance Exam",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 15.sp,
                            color = BentoOnSurface
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            // NEET UG Card
                            val isNeet = selectedExam == ExamType.NEET_UG
                            Surface(
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(16.dp))
                                    .clickable { viewModel.selectExam(ExamType.NEET_UG) }
                                    .testTag("profile_select_neet_goal"),
                                color = if (isNeet) BentoPrimaryContainer else BentoSurfaceVariant.copy(alpha = 0.4f),
                                border = BorderStroke(1.5.dp, if (isNeet) BentoPrimary else BentoSurfaceVariant),
                                shape = RoundedCornerShape(16.dp)
                            ) {
                                Row(
                                    modifier = Modifier.padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Column {
                                        Text(
                                            text = "NEET UG",
                                            fontWeight = FontWeight.ExtraBold,
                                            fontSize = 13.5.sp,
                                            color = if (isNeet) BentoPrimary else BentoOnSurface
                                        )
                                        Text(
                                            text = "Medical PCB",
                                            fontSize = 10.sp,
                                            color = BentoOnSurfaceVariant
                                        )
                                    }
                                }
                            }

                            // JEE Main Card
                            val isJee = selectedExam == ExamType.JEE_MAINS
                            Surface(
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(16.dp))
                                    .clickable { viewModel.selectExam(ExamType.JEE_MAINS) }
                                    .testTag("profile_select_jee_goal"),
                                color = if (isJee) BentoPrimaryContainer else BentoSurfaceVariant.copy(alpha = 0.4f),
                                border = BorderStroke(1.5.dp, if (isJee) BentoPrimary else BentoSurfaceVariant),
                                shape = RoundedCornerShape(16.dp)
                            ) {
                                Row(
                                    modifier = Modifier.padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Column {
                                        Text(
                                            text = "JEE Main",
                                            fontWeight = FontWeight.ExtraBold,
                                            fontSize = 13.5.sp,
                                            color = if (isJee) BentoPrimary else BentoOnSurface
                                        )
                                        Text(
                                            text = "Engineering PCM",
                                            fontSize = 10.sp,
                                            color = BentoOnSurfaceVariant
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // --- 5.5 ACCOUNT CARD ---
            item {
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Surface(
                                    shape = CircleShape,
                                    color = if (supabaseStatus.isLoggedIn) Color(0xFFEF4444).copy(alpha = 0.1f) else BentoPrimaryContainer,
                                    modifier = Modifier.size(36.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Icon(
                                            imageVector = if (supabaseStatus.isLoggedIn) Icons.Default.Person else Icons.Default.AccountCircle,
                                            contentDescription = null,
                                            tint = if (supabaseStatus.isLoggedIn) Color(0xFFEF4444) else BentoPrimary,
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }
                                }
                                Column {
                                    Text(
                                        text = "Account",
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 15.sp,
                                        color = BentoOnSurface
                                    )
                                    Text(
                                        text = if (supabaseStatus.isLoggedIn) "${supabaseStatus.userEmail}" else "Not signed in",
                                        fontSize = 12.sp,
                                        color = BentoOnSurfaceVariant
                                    )
                                }
                            }
                        }

                        if (supabaseStatus.isLoggedIn) {
                            Button(
                                onClick = {
                                    viewModel.signOutSupabase()
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFEF4444),
                                    contentColor = Color.White
                                ),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(44.dp)
                                    .testTag("profile_logout_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Logout,
                                    contentDescription = "Log Out",
                                    tint = Color.White,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Log Out",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        } else {
                            Button(
                                onClick = { viewModel.navigateToScreen(Screen.AUTH) },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = BentoPrimary
                                ),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(44.dp)
                                    .testTag("profile_manage_account_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Login,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Sign In / Register",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }

            // --- 6. APP GUIDE & TUTORIALS ---
            item {
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "💡 App Guide & Tutorials",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 15.sp,
                            color = BentoOnSurface
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .background(BentoSurfaceVariant.copy(alpha = 0.35f))
                                .clickable { viewModel.openTutorial() }
                                .padding(14.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Surface(
                                    shape = CircleShape,
                                    color = BentoPrimaryContainer,
                                    modifier = Modifier.size(42.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text("💡", fontSize = 22.sp)
                                    }
                                }
                                Column {
                                    Text(
                                        text = "Interactive App Walkthrough",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp,
                                        color = BentoOnSurface
                                    )
                                    Text(
                                        text = "Learn how to use AI Solver, Test Series, and Practice PYQs",
                                        fontSize = 11.5.sp,
                                        color = BentoOnSurfaceVariant
                                    )
                                }
                            }

                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = "Open Guide",
                                tint = BentoPrimary
                            )
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}
}

data class BadgeItem(
    val title: String,
    val subtitle: String,
    val emoji: String,
    val isUnlocked: Boolean,
    val themeColor: Color
)

@Composable
fun BadgeCard(badge: BadgeItem) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = if (badge.isUnlocked) badge.themeColor.copy(alpha = 0.12f) else BentoSurfaceVariant.copy(alpha = 0.3f),
        border = BorderStroke(1.dp, if (badge.isUnlocked) badge.themeColor else BentoSurfaceVariant),
        modifier = Modifier.width(120.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = badge.emoji,
                    fontSize = 28.sp
                )
                if (!badge.isUnlocked) {
                    Surface(
                        color = Color.Black.copy(alpha = 0.5f),
                        shape = CircleShape,
                        modifier = Modifier.size(28.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(Icons.Default.Lock, contentDescription = "Locked", tint = Color.White, modifier = Modifier.size(14.dp))
                        }
                    }
                }
            }

            Text(
                text = badge.title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 11.5.sp,
                color = if (badge.isUnlocked) BentoOnSurface else BentoOnSurfaceVariant
            )

            Text(
                text = badge.subtitle,
                fontSize = 9.5.sp,
                color = BentoOnSurfaceVariant,
                lineHeight = 11.sp
            )
        }
    }
}

@Composable
fun ProfileStatCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    subtitle: String,
    emoji: String,
    badgeColor: Color
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = value,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 17.sp,
                color = BentoOnSurface,
                maxLines = 1,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
            )
            Text(
                text = title,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = BentoOnSurface,
                maxLines = 1,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
            Text(
                text = subtitle,
                fontSize = 9.5.sp,
                color = BentoOnSurfaceVariant,
                maxLines = 1,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        }
    }
}

// --- EDIT NAME & 7 DAILY AVATARS DIALOG ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileDialog(
    currentName: String,
    currentAvatar: String,
    isAutoRotateCurrent: Boolean,
    onDismiss: () -> Unit,
    onSave: (newName: String, newAvatar: String, autoRotate: Boolean) -> Unit
) {
    var nameText by remember { mutableStateOf(currentName) }
    var selectedAvatar by remember { mutableStateOf(currentAvatar) }

    val studentAvatars = listOf(
        "👨‍🎓" to "Student",
        "👩‍🎓" to "Scholar",
        "👨‍⚕️" to "Doctor",
        "👩‍⚕️" to "Med Pro",
        "👨‍🔬" to "Scientist",
        "👩‍🔬" to "Bio Lead",
        "🧑‍💻" to "Techie",
        "🎓" to "Graduate",
        "👤" to "Default",
        "🩺" to "Stethoscope",
        "🔬" to "Microscope",
        "🧬" to "Genetics",
        "🚀" to "Rocket",
        "💡" to "Genius",
        "📚" to "Reader",
        "✍️" to "Aspirant",
        "🌟" to "Star"
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "✏️ Customize Profile & Avatar",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 17.sp,
                color = BentoOnSurface
            )
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Name Field
                OutlinedTextField(
                    value = nameText,
                    onValueChange = { nameText = it },
                    label = { Text("Your Name / Nickname") },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("profile_name_input_field")
                )

                Text(
                    text = "Choose Your Profile Icon / Avatar:",
                    fontSize = 12.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = BentoOnSurface
                )

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(studentAvatars) { (emoji, title) ->
                        val isSelected = selectedAvatar == emoji

                        Surface(
                            onClick = {
                                selectedAvatar = emoji
                            },
                            shape = RoundedCornerShape(14.dp),
                            color = if (isSelected) BentoPrimaryContainer else BentoSurfaceVariant,
                            border = BorderStroke(
                                1.5.dp,
                                if (isSelected) BentoPrimary else Color.Transparent
                            ),
                            modifier = Modifier.width(82.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(vertical = 10.dp, horizontal = 4.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text(
                                    text = emoji,
                                    fontSize = 26.sp
                                )
                                Text(
                                    text = title,
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = BentoOnSurface,
                                    maxLines = 1,
                                    textAlign = TextAlign.Center
                                )
                                if (isSelected) {
                                    Surface(
                                        color = BentoPrimary,
                                        shape = RoundedCornerShape(4.dp)
                                    ) {
                                        Text(
                                            text = "SELECTED",
                                            fontSize = 7.5.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White,
                                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = { onSave(nameText, selectedAvatar, false) },
                colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.testTag("save_profile_button")
            ) {
                Text("Save Profile", fontWeight = FontWeight.Bold)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel", color = BentoOnSurfaceVariant)
            }
        }
    )
}
