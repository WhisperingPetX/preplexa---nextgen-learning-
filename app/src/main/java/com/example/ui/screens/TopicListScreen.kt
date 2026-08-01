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

    Scaffold(
        containerColor = BentoBackground,
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
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BentoBackground
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // --- 1. TWO MAIN EXAM TABS: NEET (UG) Topics vs JEE Mains Topics ---
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp),
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
                        accentColor = Color(0xFF00C853),
                        onClick = { viewModel.selectExam(ExamType.NEET_UG) }
                    )

                    // JEE Mains Tab
                    ExamTabPill(
                        modifier = Modifier.weight(1f),
                        title = "JEE Mains Topics",
                        emoji = "🚀",
                        isSelected = selectedExam == ExamType.JEE_MAINS,
                        accentColor = Color(0xFF651FFF),
                        onClick = { viewModel.selectExam(ExamType.JEE_MAINS) }
                    )
                }
            }

            // --- 2. Bento Search Input ---
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

            // --- 3. Subject Filter Pills Row ---
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

            // --- 4. Topic Count Header ---
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

            // --- 5. Topics Bento Cards List ---
            if (topics.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
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
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(topics) { topic ->
                        BentoTopicCardItem(
                            topic = topic,
                            onTopicClick = { viewModel.selectTopic(topic) }
                        )
                    }
                    item { Spacer(modifier = Modifier.height(24.dp)) }
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
    val colorSet = when (topic.subject) {
        Subject.BIOLOGY -> BentoColorSet(BentoGreenBg, BentoGreenBorder, BentoGreenText, BentoGreenBadge)
        Subject.PHYSICS -> BentoColorSet(BentoBlueBg, BentoBlueBorder, BentoBlueText, BentoBlueBadge)
        Subject.CHEMISTRY -> BentoColorSet(BentoPeachBg, BentoPeachBorder, BentoPeachText, BentoPeachBadge)
        Subject.MATHEMATICS -> BentoColorSet(BentoPurpleBg, BentoPurpleBorder, BentoPurpleText, BentoPurpleBadge)
    }

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
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = colorSet.bg,
                    border = BorderStroke(1.dp, colorSet.border),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.weight(1f, fill = false)
                ) {
                    Text(
                        text = "${topic.subject.displayName} • Unit ${topic.unitNumber}",
                        color = colorSet.text,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 11.sp,
                        maxLines = 1,
                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }
                
                Spacer(modifier = Modifier.width(8.dp))

                Surface(
                    color = BentoPrimaryContainer,
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Quiz,
                            contentDescription = null,
                            tint = BentoPrimary,
                            modifier = Modifier.size(13.dp)
                        )
                        Text(
                            text = "10 Mock Tests",
                            color = BentoPrimary,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }
            }

            Text(
                text = topic.title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 17.sp,
                color = BentoOnSurface
            )

            // 10 Mock Tests Difficulty Breakdown Badges
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = BentoGreenBg,
                    border = BorderStroke(1.dp, BentoGreenBorder),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "🟢 3 Easy • 20m",
                        color = BentoGreenText,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 6.dp)
                    )
                }

                Surface(
                    color = BentoBlueBg,
                    border = BorderStroke(1.dp, BentoBlueBorder),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "🟡 4 Med • 25m",
                        color = BentoPrimary,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 6.dp)
                    )
                }

                Surface(
                    color = BentoPeachBg,
                    border = BorderStroke(1.dp, BentoPeachBorder),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "🔴 3 Tough • 30m",
                        color = BentoPeachBadge,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 6.dp)
                    )
                }
            }

            // Subtopic pills preview
            if (topic.subtopics.isNotEmpty()) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.Tag,
                        contentDescription = null,
                        tint = BentoOnSurfaceVariant,
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        text = topic.subtopics.take(3).joinToString(" • "),
                        fontSize = 11.sp,
                        color = BentoOnSurfaceVariant,
                        fontWeight = FontWeight.Medium,
                        maxLines = 1,
                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

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
