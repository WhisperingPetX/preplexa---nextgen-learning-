package com.example.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import kotlinx.coroutines.launch
import com.example.model.ExamType
import com.example.model.Subject
import com.example.model.Topic
import com.example.ui.theme.*
import com.example.ui.viewmodel.MainViewModel
import com.example.ui.viewmodel.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopicListScreen(viewModel: MainViewModel) {
    val selectedExam by viewModel.selectedExam.collectAsState()
    val selectedSubject by viewModel.selectedSubject.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val topics by viewModel.filteredTopics.collectAsState()

    val exams = remember { listOf(ExamType.NEET_UG, ExamType.JEE_MAINS) }
    val coroutineScope = rememberCoroutineScope()
    val initialPage = remember { if (selectedExam == ExamType.NEET_UG) 0 else 1 }
    val pagerState = rememberPagerState(initialPage = initialPage, pageCount = { 2 })

    LaunchedEffect(selectedExam) {
        val targetPage = if (selectedExam == ExamType.NEET_UG) 0 else 1
        if (pagerState.currentPage != targetPage && !pagerState.isScrollInProgress) {
            pagerState.animateScrollToPage(targetPage)
        }
    }

    LaunchedEffect(pagerState.currentPage) {
        val newExam = exams[pagerState.currentPage]
        if (selectedExam != newExam) {
            viewModel.selectExam(newExam)
        }
    }

    Scaffold(
        containerColor = BentoPurpleBg,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Syllabus Library",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 19.sp,
                            color = BentoOnSurface
                        )
                        Text(
                            text = "NTA Official Syllabus & Topic Practice",
                            fontSize = 11.sp,
                            color = BentoOnSurfaceVariant,
                            fontWeight = FontWeight.Medium
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
                            modifier = Modifier.testTag("back_to_home_button")
                        ) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = BentoOnSurface)
                        }
                    }
                },
                actions = {
                    // Top App Bar Actions (Empty for now)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BentoPurpleBg
                )
            )
        },
        bottomBar = {
            ModernBottomNavigationBar(
                currentScreen = Screen.TOPIC_LIST,
                onNavigate = { viewModel.navigateToScreen(it) }
            )
        }
    ) { paddingValues ->
        val topicListState = rememberLazyListState()

        LaunchedEffect(selectedExam, selectedSubject, searchQuery) {
            topicListState.scrollToItem(0)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // --- 1. TWO MAIN EXAM TABS (NEET (UG) vs JEE Mains) ---
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 680.dp)
                    .padding(horizontal = 16.dp, vertical = 6.dp),
                shape = RoundedCornerShape(20.dp),
                color = BentoSurface,
                border = BorderStroke(1.dp, BentoSurfaceVariant)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    // NEET (UG) Tab
                    ExamTabPill(
                        modifier = Modifier.weight(1f),
                        title = "NEET (UG) Topics",
                        emoji = "🩺",
                        isSelected = selectedExam == ExamType.NEET_UG,
                        accentColor = BentoPrimary,
                        onClick = {
                            coroutineScope.launch { pagerState.animateScrollToPage(0) }
                        }
                    )

                    // JEE Mains Tab
                    ExamTabPill(
                        modifier = Modifier.weight(1f),
                        title = "JEE Mains Topics",
                        emoji = "🚀",
                        isSelected = selectedExam == ExamType.JEE_MAINS,
                        accentColor = BentoPrimary,
                        onClick = {
                            coroutineScope.launch { pagerState.animateScrollToPage(1) }
                        }
                    )
                }
            }

            // --- 2. SLIDING HORIZONTAL PAGER FOR EXAMS ---
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                LazyColumn(
                    state = topicListState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .widthIn(max = 680.dp)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    // --- 2. Bento Search Input ---
                    item {
                        OutlinedTextField(
                            value = searchQuery,
                            onValueChange = { viewModel.updateSearchQuery(it) },
                            placeholder = { Text("Search topics, units or formulas...", color = BentoOnSurfaceVariant) },
                            leadingIcon = { Icon(Icons.Outlined.Search, contentDescription = null, tint = BentoPrimary) },
                            trailingIcon = {
                                if (searchQuery.isNotEmpty()) {
                                    IconButton(onClick = { viewModel.updateSearchQuery("") }) {
                                        Icon(Icons.Default.Close, contentDescription = "Clear", tint = BentoOnSurface)
                                    }
                                }
                            },
                            shape = RoundedCornerShape(20.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = BentoSurface,
                                unfocusedContainerColor = BentoSurface,
                                focusedBorderColor = BentoPrimary,
                                unfocusedBorderColor = BentoSurfaceVariant,
                                focusedTextColor = BentoOnSurface,
                                unfocusedTextColor = BentoOnSurface
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("topic_search_input"),
                            singleLine = true
                        )
                    }

                    // --- 3. Subject Filter Pills Row ---
                    item {
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            item {
                                val isSelected = selectedSubject == null
                                Surface(
                                    onClick = { viewModel.selectSubject(null) },
                                    shape = RoundedCornerShape(18.dp),
                                    color = if (isSelected) BentoPrimary else BentoSurfaceVariant,
                                    border = BorderStroke(1.dp, if (isSelected) BentoPrimary else BentoSurfaceVariant),
                                    modifier = Modifier.testTag("filter_all_subjects")
                                ) {
                                    Text(
                                        text = "All Subjects",
                                        color = if (isSelected) Color.White else BentoOnSurface,
                                        fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.SemiBold,
                                        fontSize = 12.sp,
                                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                                    )
                                }
                            }

                            val activeSubjects = if (selectedExam == ExamType.NEET_UG) {
                                listOf(
                                    Subject.BIOLOGY to "Biology 🧬",
                                    Subject.PHYSICS to "Physics ⚡",
                                    Subject.CHEMISTRY to "Chemistry 🧪"
                                )
                            } else {
                                listOf(
                                    Subject.MATHEMATICS to "Mathematics 📐",
                                    Subject.PHYSICS to "Physics ⚡",
                                    Subject.CHEMISTRY to "Chemistry 🧪"
                                )
                            }

                            items(activeSubjects) { (subject, label) ->
                                val isSelected = selectedSubject == subject
                                Surface(
                                    onClick = { viewModel.selectSubject(subject) },
                                    shape = RoundedCornerShape(18.dp),
                                    color = if (isSelected) BentoPrimary else BentoSurfaceVariant,
                                    border = BorderStroke(1.dp, if (isSelected) BentoPrimary else BentoSurfaceVariant),
                                    modifier = Modifier.testTag("filter_subject_${subject.id}")
                                ) {
                                    Text(
                                        text = label,
                                        color = if (isSelected) Color.White else BentoOnSurface,
                                        fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.SemiBold,
                                        fontSize = 12.sp,
                                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                                    )
                                }
                            }
                        }
                    }

                    // --- 4. Topic Count Header ---
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${selectedExam.displayName} Units (${topics.size} Topics)",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 14.sp,
                                color = BentoOnSurface,
                                modifier = Modifier.weight(1f)
                            )

                            if (selectedSubject != null) {
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Filtered by ${selectedSubject?.displayName}",
                                    fontSize = 11.sp,
                                    color = BentoPrimary,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = androidx.compose.ui.text.style.TextAlign.End,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }

                    // --- 5. Topics Bento Cards List OR Empty State ---
                    if (topics.isEmpty()) {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 40.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.SearchOff,
                                        contentDescription = null,
                                        modifier = Modifier.size(48.dp),
                                        tint = BentoOnSurfaceVariant
                                    )
                                    Text(
                                        text = "No topics found",
                                        fontWeight = FontWeight.Bold,
                                        color = BentoOnSurface
                                    )
                                    Text(
                                        text = "Try adjusting your search query or subject filter.",
                                        fontSize = 12.sp,
                                        color = BentoOnSurfaceVariant
                                    )
                                }
                            }
                        }
                    } else {
                        items(topics, key = { it.id }) { topic ->
                            BentoTopicCardItem(
                                topic = topic,
                                onTopicClick = { viewModel.selectTopic(topic) }
                            )
                        }
                    }

                    item { Spacer(modifier = Modifier.height(28.dp)) }
                }
            }
        }
    }
}

@Composable
fun ExamTabPill(
    modifier: Modifier = Modifier,
    title: String,
    emoji: String,
    isSelected: Boolean,
    accentColor: Color,
    onClick: () -> Unit
) {
    val containerColor by animateColorAsState(
        targetValue = if (isSelected) accentColor else Color.Transparent,
        animationSpec = tween(250),
        label = "tab_bg"
    )

    val textColor by animateColorAsState(
        targetValue = if (isSelected) Color.White else BentoOnSurfaceVariant,
        animationSpec = tween(250),
        label = "tab_text"
    )

    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .testTag("exam_tab_${title.replace(" ", "_").lowercase()}"),
        shape = RoundedCornerShape(16.dp),
        color = containerColor
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(emoji, fontSize = 16.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 13.sp,
                color = textColor
            )
        }
    }
}

@Composable
fun BentoTopicCardItem(
    topic: Topic,
    onTopicClick: () -> Unit
) {
    Surface(
        onClick = onTopicClick,
        shape = RoundedCornerShape(24.dp),
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        modifier = Modifier
            .fillMaxWidth()
            .testTag("topic_item_${topic.id}")
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // --- HERO TITLE: Prominent Unit Title ---
            Text(
                text = "Unit ${topic.unitNumber}: ${topic.title}",
                fontWeight = FontWeight.Black,
                fontSize = 18.sp,
                color = BentoOnSurface,
                lineHeight = 24.sp,
                modifier = Modifier.padding(vertical = 2.dp)
            )

            HorizontalDivider(color = BentoSurfaceVariant)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Tap to open 10 Mock Test Series",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = BentoPrimary
                )
                Surface(
                    color = BentoPrimaryContainer,
                    shape = CircleShape
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = BentoPrimary,
                        modifier = Modifier
                            .padding(6.dp)
                            .size(14.dp)
                    )
                }
            }
        }
    }
}
