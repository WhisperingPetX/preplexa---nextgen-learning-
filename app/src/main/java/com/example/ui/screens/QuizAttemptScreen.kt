package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Timer
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
import com.example.model.Question
import com.example.ui.theme.*
import com.example.ui.viewmodel.MainViewModel
import com.example.ui.viewmodel.Screen
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizAttemptScreen(viewModel: MainViewModel) {
    val activeTest by viewModel.activeTest.collectAsState()
    val questions by viewModel.questions.collectAsState()
    val currentIndex by viewModel.currentQuestionIndex.collectAsState()
    val userAnswers by viewModel.userAnswers.collectAsState()
    val timeRemaining by viewModel.timeRemainingSeconds.collectAsState()

    var showPaletteSheet by remember { mutableStateOf(false) }
    var showSubmitConfirmDialog by remember { mutableStateOf(false) }
    var showExitConfirmDialog by remember { mutableStateOf(false) }

    val test = activeTest ?: return
    val currentQuestion = questions.getOrNull(currentIndex) ?: return
    val currentAnswer = userAnswers[currentQuestion.id]

    val minutes = timeRemaining / 60
    val seconds = timeRemaining % 60
    val timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)

    val isBookmarked by viewModel.isBookmarked(currentQuestion.id).collectAsState(initial = false)

    Scaffold(
        containerColor = BentoBackground,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Surface(
                        color = BentoSurfaceVariant,
                        shape = CircleShape,
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        IconButton(
                            onClick = { showExitConfirmDialog = true },
                            modifier = Modifier.testTag("exit_exam_top_button")
                        ) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Exit Exam", tint = BentoOnSurface)
                        }
                    }
                },
                title = {
                    Column {
                        Text(
                            text = test.title,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 15.sp,
                            maxLines = 1,
                            color = BentoOnSurface
                        )
                        Text(
                            text = "Question ${currentIndex + 1} of ${questions.size}",
                            fontSize = 11.sp,
                            color = BentoPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                actions = {
                    // Bento Timer Chip
                    Surface(
                        color = if (timeRemaining < 120) BentoPeachBg else BentoPrimaryContainer,
                        border = BorderStroke(1.dp, if (timeRemaining < 120) BentoPeachBorder else BentoBlueBorder),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Timer,
                                contentDescription = null,
                                tint = if (timeRemaining < 120) BentoPeachBadge else BentoPrimary,
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = timeFormatted,
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 13.sp,
                                color = if (timeRemaining < 120) BentoPeachText else BentoPrimary
                            )
                        }
                    }

                    Surface(
                        color = BentoSurfaceVariant,
                        shape = CircleShape,
                        modifier = Modifier.padding(start = 6.dp, end = 12.dp)
                    ) {
                        IconButton(
                            onClick = { showPaletteSheet = true },
                            modifier = Modifier.testTag("question_palette_button")
                        ) {
                            Icon(Icons.Default.GridView, contentDescription = "Question Grid", tint = BentoOnSurface)
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BentoBackground
                )
            )
        },
        bottomBar = {
            Surface(
                color = BentoSurface,
                border = BorderStroke(1.dp, BentoSurfaceVariant),
                modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Previous Button
                    OutlinedButton(
                        onClick = { viewModel.setCurrentQuestionIndex(currentIndex - 1) },
                        enabled = currentIndex > 0,
                        shape = RoundedCornerShape(16.dp),
                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp),
                        modifier = Modifier.testTag("prev_question_button")
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(2.dp))
                        Text("Prev", fontWeight = FontWeight.Bold, maxLines = 1, fontSize = 12.sp)
                    }

                    // Mark for Review Button
                    OutlinedIconToggleButton(
                        checked = currentAnswer?.isMarkedForReview == true,
                        onCheckedChange = { viewModel.toggleMarkForReview(currentQuestion.id) },
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, if (currentAnswer?.isMarkedForReview == true) Color(0xFF825500) else BentoSurfaceVariant),
                        modifier = Modifier.testTag("mark_review_button")
                    ) {
                        Icon(
                            imageVector = if (currentAnswer?.isMarkedForReview == true) Icons.Default.Bookmark else Icons.Outlined.Bookmark,
                            contentDescription = "Review",
                            tint = if (currentAnswer?.isMarkedForReview == true) Color(0xFF825500) else BentoOnSurface
                        )
                    }

                    // Exit Button (Placed directly to the left of Save & Next / Submit)
                    OutlinedButton(
                        onClick = { showExitConfirmDialog = true },
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.5f)),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFDC2626)),
                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp),
                        modifier = Modifier.testTag("exit_test_button")
                    ) {
                        Icon(Icons.Default.Close, contentDescription = "Exit", modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(2.dp))
                        Text("Exit", fontWeight = FontWeight.Bold, maxLines = 1, fontSize = 12.sp)
                    }

                    // Next / Submit Button
                    if (currentIndex < questions.size - 1) {
                        Button(
                            onClick = { viewModel.setCurrentQuestionIndex(currentIndex + 1) },
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                            modifier = Modifier
                                .weight(1f)
                                .testTag("next_question_button")
                        ) {
                            Text("Save & Next", fontWeight = FontWeight.Bold, maxLines = 1, fontSize = 12.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
                        }
                    } else {
                        Button(
                            onClick = { showSubmitConfirmDialog = true },
                            colors = ButtonDefaults.buttonColors(containerColor = BentoGreenBadge, contentColor = Color.White),
                            shape = RoundedCornerShape(16.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                            modifier = Modifier
                                .weight(1f)
                                .testTag("submit_test_button")
                        ) {
                            Text("Submit", fontWeight = FontWeight.Bold, maxLines = 1, fontSize = 12.sp)
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Bento Question Status Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = BentoSurfaceVariant,
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "Difficulty: ${currentQuestion.difficulty}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = BentoOnSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                    )
                }

                Surface(
                    color = BentoSurfaceVariant,
                    shape = CircleShape
                ) {
                    IconButton(
                        onClick = { viewModel.toggleBookmark(currentQuestion) },
                        modifier = Modifier.testTag("bookmark_question_button")
                    ) {
                        Icon(
                            imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Outlined.Bookmark,
                            contentDescription = "Bookmark Question",
                            tint = if (isBookmarked) BentoPeachBadge else BentoOnSurfaceVariant
                        )
                    }
                }
            }

            // Bento Question Card
            Surface(
                shape = RoundedCornerShape(28.dp),
                color = BentoSurface,
                border = BorderStroke(1.dp, BentoSurfaceVariant),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = currentQuestion.text,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 23.sp,
                        color = BentoOnSurface
                    )

                    if (!currentQuestion.formulaRef.isNullOrBlank()) {
                        Surface(
                            color = BentoPrimaryContainer,
                            border = BorderStroke(1.dp, BentoBlueBorder),
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            Text(
                                text = "Formula Ref: ${currentQuestion.formulaRef}",
                                fontSize = 11.sp,
                                color = BentoPrimary,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                            )
                        }
                    }
                }
            }

            // Bento Options List
            Text(
                text = "Select Correct Option:",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 14.sp,
                color = BentoOnSurfaceVariant
            )

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                val optionLabels = listOf("A", "B", "C", "D")
                currentQuestion.options.forEachIndexed { optIndex, optionText ->
                    val isSelected = currentAnswer?.selectedOptionIndex == optIndex

                    Surface(
                        onClick = { viewModel.selectOption(currentQuestion.id, optIndex) },
                        shape = RoundedCornerShape(20.dp),
                        color = if (isSelected) BentoPrimaryContainer else BentoSurface,
                        border = BorderStroke(
                            width = if (isSelected) 2.dp else 1.dp,
                            color = if (isSelected) BentoPrimary else BentoSurfaceVariant
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("option_${optIndex}")
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(34.dp)
                                    .clip(CircleShape)
                                    .background(
                                        if (isSelected) BentoPrimary
                                        else BentoSurfaceVariant
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = optionLabels.getOrElse(optIndex) { "${optIndex + 1}" },
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 13.sp,
                                    color = if (isSelected) Color.White else BentoOnSurfaceVariant
                                )
                            }

                            Text(
                                text = optionText,
                                fontSize = 14.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                color = BentoOnSurface,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }

    // --- Question Palette Bottom Sheet ---
    if (showPaletteSheet) {
        ModalBottomSheet(
            onDismissRequest = { showPaletteSheet = false },
            containerColor = BentoSurface,
            shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Question Grid Palette",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp,
                    color = BentoOnSurface
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    PaletteLegend(color = BentoGreenBadge, label = "Answered")
                    PaletteLegend(color = Color(0xFF825500), label = "Review")
                    PaletteLegend(color = BentoSurfaceVariant, label = "Unattempted")
                }

                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 48.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.height(220.dp)
                ) {
                    itemsIndexed(questions) { qIdx, q ->
                        val ans = userAnswers[q.id]
                        val isCurrent = qIdx == currentIndex
                        val isAnswered = ans?.selectedOptionIndex != null
                        val isReview = ans?.isMarkedForReview == true

                        val boxBg = when {
                            isReview -> Color(0xFFFEF3C7)
                            isAnswered -> BentoGreenBg
                            else -> BentoSurfaceVariant
                        }

                        val textColor = when {
                            isReview -> Color(0xFF825500)
                            isAnswered -> BentoGreenText
                            else -> BentoOnSurface
                        }

                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(boxBg)
                                .border(
                                    width = if (isCurrent) 2.dp else 0.dp,
                                    color = if (isCurrent) BentoPrimary else Color.Transparent,
                                    shape = RoundedCornerShape(14.dp)
                                )
                                .clickable {
                                    viewModel.setCurrentQuestionIndex(qIdx)
                                    showPaletteSheet = false
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${qIdx + 1}",
                                fontWeight = FontWeight.Bold,
                                color = textColor
                            )
                        }
                    }
                }

                Button(
                    onClick = {
                        showPaletteSheet = false
                        showSubmitConfirmDialog = true
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = BentoGreenBadge, contentColor = Color.White),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Finish & Submit Test", fontWeight = FontWeight.Bold)
                }
            }
        }
    }

    // --- Submit Confirmation Modal ---
    if (showSubmitConfirmDialog) {
        val answeredCount = userAnswers.values.count { it.selectedOptionIndex != null }
        val reviewCount = userAnswers.values.count { it.isMarkedForReview }
        val unattemptedCount = questions.size - answeredCount

        AlertDialog(
            onDismissRequest = { showSubmitConfirmDialog = false },
            containerColor = BentoSurface,
            title = { Text("Submit Mock Test?", fontWeight = FontWeight.ExtraBold, color = BentoOnSurface) },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Are you sure you want to end and submit this test?", color = BentoOnSurfaceVariant)
                    HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp), color = BentoSurfaceVariant)
                    Text("✅ Answered: $answeredCount", fontWeight = FontWeight.Bold, color = BentoGreenBadge)
                    Text("🔖 Marked for Review: $reviewCount", fontWeight = FontWeight.Bold, color = Color(0xFF825500))
                    Text("⚪ Unattempted: $unattemptedCount", fontWeight = FontWeight.Bold, color = BentoOnSurfaceVariant)
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showSubmitConfirmDialog = false
                        viewModel.submitMockTest()
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BentoGreenBadge, contentColor = Color.White)
                ) {
                    Text("Yes, Submit Now", fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { showSubmitConfirmDialog = false }) {
                    Text("Keep Testing", color = BentoPrimary, fontWeight = FontWeight.Bold)
                }
            }
        )
    }

    // --- Exit Confirmation Modal ---
    if (showExitConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showExitConfirmDialog = false },
            containerColor = BentoSurface,
            title = { Text("Exit Mock Test?", fontWeight = FontWeight.ExtraBold, color = BentoOnSurface) },
            text = {
                Text(
                    "Are you sure you want to exit this mock test? Your current attempt will be closed and you will return to the papers list.",
                    color = BentoOnSurfaceVariant
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        showExitConfirmDialog = false
                        viewModel.exitQuizTest()
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626), contentColor = Color.White)
                ) {
                    Text("Exit Exam", fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { showExitConfirmDialog = false }) {
                    Text("Keep Testing", color = BentoPrimary, fontWeight = FontWeight.Bold)
                }
            }
        )
    }
}

@Composable
fun PaletteLegend(color: Color, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .clip(CircleShape)
                .background(color)
        )
        Text(text = label, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface)
    }
}

