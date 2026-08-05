package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.platform.LocalContext
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import kotlinx.coroutines.launch
import com.example.model.ExamType
import com.example.ui.theme.*
import com.example.ui.viewmodel.MainViewModel
import com.example.ui.viewmodel.Screen
import com.example.data.supabase.SupabaseConfig

data class PyqPaperItem(
    val year: Int,
    val title: String,
    val subtitle: String,
    val examType: ExamType,
    val questionCount: Int = 10,
    val durationMinutes: Int = 20,
    val totalMarks: Int = 180,
    val highlightTag: String = "Official NTA Paper"
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PyqPapersScreen(viewModel: MainViewModel) {
    var selectedTab by remember { mutableStateOf(ExamType.NEET_UG) }
    val context = LocalContext.current

    val exams = remember { listOf(ExamType.NEET_UG, ExamType.JEE_MAINS) }
    val coroutineScope = rememberCoroutineScope()
    val initialPage = remember { if (selectedTab == ExamType.NEET_UG) 0 else 1 }
    val pagerState = rememberPagerState(initialPage = initialPage, pageCount = { 2 })

    LaunchedEffect(selectedTab) {
        val targetPage = if (selectedTab == ExamType.NEET_UG) 0 else 1
        if (pagerState.currentPage != targetPage && !pagerState.isScrollInProgress) {
            pagerState.animateScrollToPage(targetPage)
        }
    }

    LaunchedEffect(pagerState.currentPage) {
        val targetExam = exams[pagerState.currentPage]
        if (selectedTab != targetExam) {
            selectedTab = targetExam
        }
    }

    // Dynamically fetch current year and compute 10-year range (currentYear down to currentYear - 9)
    val currentYear = remember { java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) }
    val startYear = currentYear - 9

    val neetPyqList = remember(currentYear) {
        (currentYear downTo startYear).map { year ->
            PyqPaperItem(
                year = year,
                title = "NEET UG $year Official Question Paper",
                subtitle = "Physics • Chemistry • Biology (PCB)",
                examType = ExamType.NEET_UG,
                questionCount = 180,
                durationMinutes = 180,
                totalMarks = 720,
                highlightTag = if (year == currentYear) "NTA Standard (Latest)" else "NTA Standard Paper"
            )
        }
    }

    val jeePyqList = remember(currentYear) {
        (currentYear downTo startYear).map { year ->
            PyqPaperItem(
                year = year,
                title = "JEE Main $year Official Question Paper",
                subtitle = "Physics • Chemistry • Mathematics (PCM)",
                examType = ExamType.JEE_MAINS,
                questionCount = 75,
                durationMinutes = 180,
                totalMarks = 300,
                highlightTag = if (year == currentYear) "NTA Standard (Latest)" else "NTA Standard Paper"
            )
        }
    }

    Scaffold(
        containerColor = BentoPurpleBg,
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "10 Years PYQ Papers",
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
                            onClick = { viewModel.navigateToScreen(Screen.HOME) },
                            modifier = Modifier.testTag("back_from_pyq_button")
                        ) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = BentoOnSurface)
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BentoPurpleBg
                )
            )
        },
        bottomBar = {
            ModernBottomNavigationBar(
                currentScreen = Screen.PYQ_PAPERS,
                onNavigate = { viewModel.navigateToScreen(it) }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // --- 1. EXAM FILTER TABS (NEET UG vs JEE MAIN) ---
            Surface(
                color = BentoSurface,
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(1.dp, BentoSurfaceVariant),
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 680.dp)
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Row(
                    modifier = Modifier.padding(6.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    // NEET UG TAB
                    val isNeet = selectedTab == ExamType.NEET_UG
                    Surface(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(16.dp))
                            .clickable {
                                coroutineScope.launch { pagerState.animateScrollToPage(0) }
                            }
                            .testTag("pyq_tab_neet"),
                        color = if (isNeet) BentoPrimaryContainer else Color.Transparent,
                        border = BorderStroke(1.dp, if (isNeet) BentoPrimary else Color.Transparent),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "NEET UG PYQ",
                                fontWeight = if (isNeet) FontWeight.ExtraBold else FontWeight.Bold,
                                fontSize = 13.5.sp,
                                color = if (isNeet) BentoPrimary else BentoOnSurfaceVariant
                            )
                        }
                    }

                    // JEE MAIN TAB
                    val isJee = selectedTab == ExamType.JEE_MAINS
                    Surface(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(16.dp))
                            .clickable {
                                coroutineScope.launch { pagerState.animateScrollToPage(1) }
                            }
                            .testTag("pyq_tab_jee"),
                        color = if (isJee) BentoPrimaryContainer else Color.Transparent,
                        border = BorderStroke(1.dp, if (isJee) BentoPrimary else Color.Transparent),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "JEE Main PYQ",
                                fontWeight = if (isJee) FontWeight.ExtraBold else FontWeight.Bold,
                                fontSize = 13.5.sp,
                                color = if (isJee) BentoPrimary else BentoOnSurfaceVariant
                            )
                        }
                    }
                }
            }

            // --- 2. SLIDING HORIZONTAL PAGER FOR EXAMS ---
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                val activeExam = exams[page]
                val activeList = if (activeExam == ExamType.NEET_UG) neetPyqList else jeePyqList

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .widthIn(max = 680.dp)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    // --- 2. INFORMATIONAL BANNER CARD ---
                    item {
                        Surface(
                            color = BentoPrimaryContainer.copy(alpha = 0.6f),
                            border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.3f)),
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(14.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Text("🎯", fontSize = 28.sp)
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = if (activeExam == ExamType.NEET_UG) "10 Years NEET UG Question Bank" else "10 Years JEE Main Question Bank",
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 14.sp,
                                        color = BentoPrimary
                                    )
                                    Text(
                                        text = "Attempt real 10-year past papers under timed conditions to accurately train your speed and boost AI Selection Probability!",
                                        fontSize = 11.5.sp,
                                        color = BentoOnSurfaceVariant,
                                        fontWeight = FontWeight.Medium,
                                        lineHeight = 16.sp
                                    )
                                }
                            }
                        }
                    }

                    // --- 3. SECTION TITLE ---
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 4.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = if (activeExam == ExamType.NEET_UG) "Available NEET Papers ($startYear - $currentYear)" else "Available JEE Papers ($startYear - $currentYear)",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 15.sp,
                                color = BentoOnSurface,
                                modifier = Modifier.weight(1f)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "10 Years Total",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = BentoOnSurfaceVariant
                            )
                        }
                    }

                    // --- 4. LIST OF 10 YEARS OF PYQ PAPERS ---
                    items(activeList) { pyq ->
                        if (activeExam == ExamType.NEET_UG) {
                            PyqPaperCardItem(
                                pyq = pyq,
                                onAttemptClick = {
                                    viewModel.startPyqTest(pyq.year, pyq.examType, pyq.title)
                                }
                            )
                        } else {
                            JeeMainPyqYearCard(
                                pyq = pyq,
                                onStartTest = { session, shift ->
                                    viewModel.startPyqTest(
                                        year = pyq.year,
                                        examType = ExamType.JEE_MAINS,
                                        title = "JEE Main ${pyq.year}",
                                        session = session,
                                        shift = shift
                                    )
                                }
                            )
                        }
                    }

                    item { Spacer(modifier = Modifier.height(24.dp)) }
                }
            }
        }
    }
}

@Composable
fun PyqPaperCardItem(
    pyq: PyqPaperItem,
    onAttemptClick: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        shadowElevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .testTag("pyq_paper_item_${pyq.year}")
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Header Row: Year Badge & Highlight Tag
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = BentoPrimaryContainer,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "${pyq.year} PAPER",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = BentoPrimary,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }

                Surface(
                    color = BentoSurfaceVariant.copy(alpha = 0.6f),
                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = pyq.highlightTag,
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = BentoOnSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
            }

            // Paper Title & Subtitle
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = pyq.title,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 15.5.sp,
                    color = BentoOnSurface,
                    maxLines = 2,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
                Text(
                    text = pyq.subtitle,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = BentoOnSurfaceVariant,
                    maxLines = 1,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
            }

            // Details Badges Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = BentoPrimaryContainer,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Answer Key",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = BentoPrimary,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
            }

            HorizontalDivider(color = BentoSurfaceVariant.copy(alpha = 0.5f), thickness = 1.dp)

            // Start Button
            Button(
                onClick = onAttemptClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = BentoPrimary,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("start_pyq_button_${pyq.year}")
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Start ${pyq.year} Official Mock Test",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 13.sp
                    )
                }
            }
        }
    }
}

@Composable
fun JeeMainPyqYearCard(
    pyq: PyqPaperItem,
    onStartTest: (session: Int, shift: Int) -> Unit
) {
    var isExpanded by remember { mutableStateOf(true) }

    Surface(
        shape = RoundedCornerShape(20.dp),
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        shadowElevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .testTag("jee_pyq_item_${pyq.year}")
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Top Clickable Header Area (Tap to expand / collapse)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isExpanded = !isExpanded },
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Header Row: Year Badge & Highlight Tag
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
                            color = BentoPrimaryContainer,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(
                                text = "JEE MAIN ${pyq.year}",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = BentoPrimary,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }

                        Surface(
                            color = BentoSurfaceVariant.copy(alpha = 0.6f),
                            border = BorderStroke(1.dp, BentoSurfaceVariant),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(
                                text = pyq.highlightTag,
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = BentoOnSurfaceVariant,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }
                    }
                }

                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(
                        text = "JEE Main ${pyq.year} Official Papers",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 15.5.sp,
                        color = BentoOnSurface
                    )
                    Text(
                        text = "Sessions 1 & 2 • Shift 1 (Morning) & Shift 2 (Evening) • NTA Pattern (75 Qs / 300 Marks)",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Medium,
                        color = BentoOnSurfaceVariant
                    )
                }
            }

            if (isExpanded) {
                HorizontalDivider(color = BentoSurfaceVariant.copy(alpha = 0.5f), thickness = 1.dp)

                // --- SESSION 1 ---
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BentoSurfaceVariant.copy(alpha = 0.3f), shape = RoundedCornerShape(14.dp))
                        .padding(12.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Icon(
                                imageVector = Icons.Default.Event,
                                contentDescription = null,
                                tint = BentoOnSurfaceVariant,
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = "Session 1 (Jan / Feb)",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 13.sp,
                                color = BentoOnSurface
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { onStartTest(1, 1) },
                            colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Bolt,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Column(horizontalAlignment = Alignment.Start) {
                                    Text("Shift 1", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, lineHeight = 14.sp)
                                    Text("Morning", fontSize = 10.sp, fontWeight = FontWeight.Medium, lineHeight = 12.sp)
                                }
                            }
                        }

                        Button(
                            onClick = { onStartTest(1, 2) },
                            colors = ButtonDefaults.buttonColors(containerColor = BentoPrimaryContainer, contentColor = BentoPrimary),
                            border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.5f)),
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Bolt,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Column(horizontalAlignment = Alignment.Start) {
                                    Text("Shift 2", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, lineHeight = 14.sp)
                                    Text("Evening", fontSize = 10.sp, fontWeight = FontWeight.Medium, lineHeight = 12.sp)
                                }
                            }
                        }
                    }
                }

                // --- SESSION 2 ---
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BentoSurfaceVariant.copy(alpha = 0.3f), shape = RoundedCornerShape(14.dp))
                        .padding(12.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Icon(
                                imageVector = Icons.Default.Event,
                                contentDescription = null,
                                tint = BentoOnSurfaceVariant,
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = "Session 2 (April)",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 13.sp,
                                color = BentoOnSurface
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { onStartTest(2, 1) },
                            colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Bolt,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Column(horizontalAlignment = Alignment.Start) {
                                    Text("Shift 1", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, lineHeight = 14.sp)
                                    Text("Morning", fontSize = 10.sp, fontWeight = FontWeight.Medium, lineHeight = 12.sp)
                                }
                            }
                        }

                        Button(
                            onClick = { onStartTest(2, 2) },
                            colors = ButtonDefaults.buttonColors(containerColor = BentoPrimaryContainer, contentColor = BentoPrimary),
                            border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.5f)),
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Bolt,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Column(horizontalAlignment = Alignment.Start) {
                                    Text("Shift 2", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, lineHeight = 14.sp)
                                    Text("Evening", fontSize = 10.sp, fontWeight = FontWeight.Medium, lineHeight = 12.sp)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
