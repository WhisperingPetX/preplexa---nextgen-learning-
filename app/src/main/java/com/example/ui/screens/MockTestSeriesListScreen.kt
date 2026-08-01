package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import com.example.model.MockTest
import com.example.model.Subject
import com.example.ui.theme.*
import com.example.ui.viewmodel.MainViewModel
import com.example.ui.viewmodel.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MockTestSeriesListScreen(viewModel: MainViewModel) {
    val topic by viewModel.selectedTopic.collectAsState()
    val testSeries by viewModel.mockTestSeries.collectAsState()
    var showFormulaSheet by remember { mutableStateOf(false) }

    val activeTopic = topic ?: return

    val themeColor = when (activeTopic.subject) {
        Subject.PHYSICS -> BentoBlueBadge
        Subject.CHEMISTRY -> BentoPeachBadge
        Subject.MATHEMATICS -> BentoPurpleBadge
        Subject.BIOLOGY -> BentoGreenBadge
    }

    Scaffold(
        containerColor = BentoBackground,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = activeTopic.title,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 17.sp,
                            maxLines = 1,
                            color = BentoOnSurface
                        )
                        Text(
                            text = "10 Topic Mock Test Series • NTA Pattern",
                            fontSize = 11.sp,
                            color = themeColor,
                            fontWeight = FontWeight.Bold
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
                            onClick = { viewModel.navigateToScreen(Screen.TOPIC_LIST) },
                            modifier = Modifier.testTag("back_to_topics_button")
                        ) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = BentoOnSurface)
                        }
                    }
                },
                actions = {
                    Surface(
                        color = BentoSurfaceVariant,
                        shape = CircleShape,
                        modifier = Modifier.padding(end = 12.dp)
                    ) {
                        IconButton(
                            onClick = { showFormulaSheet = !showFormulaSheet },
                            modifier = Modifier.testTag("toggle_formula_sheet_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.MenuBook,
                                contentDescription = "Formulas",
                                tint = themeColor
                            )
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
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // --- 1. Bento Topic Revision Banner & Formula Sheet ---
            item {
                Surface(
                    shape = RoundedCornerShape(28.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Surface(
                                color = themeColor.copy(alpha = 0.12f),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text(
                                    text = "Unit ${activeTopic.unitNumber} • ${activeTopic.subject.displayName}",
                                    color = themeColor,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.sp,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                                )
                            }

                            Surface(
                                color = BentoSurfaceVariant,
                                shape = RoundedCornerShape(14.dp),
                                modifier = Modifier.clickable { showFormulaSheet = !showFormulaSheet }
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Icon(Icons.Default.Functions, contentDescription = null, tint = themeColor, modifier = Modifier.size(16.dp))
                                    Text(
                                        text = if (showFormulaSheet) "Hide Formulas" else "Key Formulas",
                                        fontSize = 11.sp,
                                        color = themeColor,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }

                        Text(
                            text = activeTopic.description,
                            fontSize = 12.sp,
                            color = BentoOnSurfaceVariant,
                            lineHeight = 17.sp,
                            fontWeight = FontWeight.Medium
                        )

                        // --- Animated Formula / Key Notes Dropdown ---
                        AnimatedVisibility(visible = showFormulaSheet) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(BentoPrimaryContainer)
                                    .border(1.dp, BentoBlueBorder, RoundedCornerShape(20.dp))
                                    .padding(14.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = "⚡ Key Formulas & Exam Notes",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = BentoPrimary
                                )
                                activeTopic.keyFormulae.forEach { formula ->
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                                        verticalAlignment = Alignment.Top
                                    ) {
                                        Text("•", color = BentoPrimary, fontWeight = FontWeight.Bold)
                                        Text(
                                            text = formula,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = BentoOnSurface
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // --- 2. Bento Header Title & Count ---
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "10 Topic Mock Test Series",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp,
                            color = BentoOnSurface
                        )
                        Surface(
                            color = BentoSurfaceVariant,
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "${testSeries.count { it.isCompleted }}/10 Completed",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = BentoOnSurfaceVariant,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }
                    }

                    // Level Distribution Badge Strip (3 Easy, 4 Medium, 3 Tough)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Surface(
                            color = BentoGreenBg,
                            border = BorderStroke(1.dp, BentoGreenBorder),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "🟢 1-3 Easy • 20 min",
                                color = BentoGreenText,
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                maxLines = 1,
                                modifier = Modifier.padding(vertical = 6.dp, horizontal = 2.dp),
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )
                        }

                        Surface(
                            color = BentoBlueBg,
                            border = BorderStroke(1.dp, BentoBlueBorder),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "🟡 4-7 Med • 25 min",
                                color = BentoPrimary,
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                maxLines = 1,
                                modifier = Modifier.padding(vertical = 6.dp, horizontal = 2.dp),
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )
                        }

                        Surface(
                            color = BentoPeachBg,
                            border = BorderStroke(1.dp, BentoPeachBorder),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "🔴 8-10 Tough • 30 min",
                                color = BentoPeachBadge,
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                maxLines = 1,
                                modifier = Modifier.padding(vertical = 6.dp, horizontal = 2.dp),
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )
                        }
                    }
                }
            }

            // --- 3. The 10 Bento Mock Test Cards ---
            items(testSeries) { test ->
                BentoMockTestCardItem(
                    mockTest = test,
                    themeColor = themeColor,
                    onStartTest = { viewModel.startMockTest(test) }
                )
            }

            // --- 4. Extra Spacing ---
            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

@Composable
fun BentoMockTestCardItem(
    mockTest: MockTest,
    themeColor: Color,
    onStartTest: () -> Unit
) {
    val diffColor = when {
        mockTest.difficulty.contains("Easy", ignoreCase = true) -> BentoGreenBadge
        mockTest.difficulty.contains("Medium", ignoreCase = true) -> BentoPrimary
        mockTest.difficulty.contains("Tough", ignoreCase = true) || mockTest.difficulty.contains("Hard", ignoreCase = true) -> BentoPeachBadge
        else -> themeColor
    }

    val diffBg = when {
        mockTest.difficulty.contains("Easy", ignoreCase = true) -> BentoGreenBg
        mockTest.difficulty.contains("Medium", ignoreCase = true) -> BentoBlueBg
        else -> BentoPeachBg
    }

    val diffBorder = when {
        mockTest.difficulty.contains("Easy", ignoreCase = true) -> BentoGreenBorder
        mockTest.difficulty.contains("Medium", ignoreCase = true) -> BentoBlueBorder
        else -> BentoPeachBorder
    }

    Surface(
        shape = RoundedCornerShape(28.dp),
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        modifier = Modifier
            .fillMaxWidth()
            .testTag("mock_test_card_${mockTest.testNumber}")
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
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
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(themeColor.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "#${mockTest.testNumber}",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 12.sp,
                            color = themeColor
                        )
                    }

                    Surface(
                        color = diffBg,
                        border = BorderStroke(1.dp, diffBorder),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = mockTest.difficulty,
                            color = diffColor,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                }

                if (mockTest.isCompleted && mockTest.bestScorePercent != null) {
                    Surface(
                        color = BentoGreenBg,
                        border = BorderStroke(1.dp, BentoGreenBorder),
                        shape = CircleShape
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Icon(Icons.Default.CheckCircle, contentDescription = null, tint = BentoGreenBadge, modifier = Modifier.size(12.dp))
                            Text(
                                text = "Best: ${mockTest.bestScorePercent}%",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = BentoGreenText
                            )
                        }
                    }
                }
            }

            Text(
                text = mockTest.title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp,
                color = BentoOnSurface
            )

            Text(
                text = mockTest.subtitle,
                fontSize = 12.sp,
                color = BentoOnSurfaceVariant,
                fontWeight = FontWeight.Medium
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(Icons.Default.HelpOutline, contentDescription = null, tint = BentoOnSurfaceVariant, modifier = Modifier.size(14.dp))
                        Text(
                            text = "${mockTest.questionCount} Qs",
                            fontSize = 11.sp,
                            color = BentoOnSurfaceVariant,
                            fontWeight = FontWeight.Medium,
                            maxLines = 1
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(Icons.Outlined.Timer, contentDescription = null, tint = BentoOnSurfaceVariant, modifier = Modifier.size(14.dp))
                        Text(
                            text = "${mockTest.durationMinutes} Mins",
                            fontSize = 11.sp,
                            color = BentoOnSurfaceVariant,
                            fontWeight = FontWeight.Medium,
                            maxLines = 1
                        )
                    }
                }

                Button(
                    onClick = onStartTest,
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (mockTest.isCompleted) BentoSurfaceVariant else BentoPrimary,
                        contentColor = if (mockTest.isCompleted) BentoOnSurfaceVariant else Color.White
                    ),
                    modifier = Modifier.testTag("start_test_button_${mockTest.testNumber}")
                ) {
                    Text(
                        text = if (mockTest.isCompleted) "Re-Take" else "Start Test",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

