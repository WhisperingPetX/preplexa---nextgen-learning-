package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.local.BookmarkedQuestionEntity
import com.example.model.Question
import com.example.ui.theme.*
import com.example.ui.viewmodel.MainViewModel
import com.example.ui.viewmodel.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookmarksScreen(viewModel: MainViewModel) {
    val bookmarks by viewModel.bookmarkedQuestions.collectAsState()

    Scaffold(
        containerColor = BentoBackground,
        topBar = {
            TopAppBar(
                title = { Text("Bookmarked Questions (${bookmarks.size})", fontWeight = FontWeight.ExtraBold, fontSize = 18.sp, color = BentoOnSurface) },
                navigationIcon = {
                    Surface(
                        color = BentoSurfaceVariant,
                        shape = CircleShape,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                    ) {
                        IconButton(
                            onClick = { viewModel.navigateToScreen(Screen.HOME) },
                            modifier = Modifier.testTag("back_from_bookmarks_button")
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
        if (bookmarks.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(28.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                    modifier = Modifier.padding(24.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.BookmarkBorder,
                            contentDescription = null,
                            modifier = Modifier.size(56.dp),
                            tint = BentoPeachBadge
                        )
                        Text(
                            text = "No Bookmarks Saved Yet",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp,
                            color = BentoOnSurface
                        )
                        Text(
                            text = "Bookmark tricky questions during mock tests to review them later.",
                            fontSize = 12.sp,
                            color = BentoOnSurfaceVariant,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(bookmarks) { item ->
                    BookmarkCardItem(
                        item = item,
                        onRemove = {
                            viewModel.toggleBookmark(
                                Question(
                                    id = item.questionId,
                                    topicId = item.topicId,
                                    text = item.questionText,
                                    options = listOf(item.optionA, item.optionB, item.optionC, item.optionD),
                                    correctOptionIndex = item.correctOptionIndex,
                                    explanation = item.explanation
                                )
                            )
                        }
                    )
                }
                item { Spacer(modifier = Modifier.height(20.dp)) }
            }
        }
    }
}

@Composable
fun BookmarkCardItem(
    item: BookmarkedQuestionEntity,
    onRemove: () -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    Surface(
        shape = RoundedCornerShape(28.dp),
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        modifier = Modifier.fillMaxWidth().testTag("bookmark_item_${item.questionId}")
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
                    color = BentoPrimaryContainer,
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "Topic: ${item.topicId}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = BentoPrimary,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                    )
                }

                Surface(
                    color = BentoPeachBg,
                    border = BorderStroke(1.dp, BentoPeachBorder),
                    shape = CircleShape
                ) {
                    IconButton(onClick = onRemove, modifier = Modifier.size(36.dp)) {
                        Icon(Icons.Default.DeleteOutline, contentDescription = "Remove", tint = BentoPeachBadge, modifier = Modifier.size(18.dp))
                    }
                }
            }

            Text(
                text = item.questionText,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                lineHeight = 22.sp,
                color = BentoOnSurface
            )

            val options = listOf(item.optionA, item.optionB, item.optionC, item.optionD)
            val correctOptionText = options.getOrElse(item.correctOptionIndex) { "" }

            Button(
                onClick = { isExpanded = !isExpanded },
                colors = ButtonDefaults.buttonColors(containerColor = BentoSurfaceVariant, contentColor = BentoOnSurface),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = if (isExpanded) "Hide Solution" else "Show Solution & Answer",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            AnimatedVisibility(visible = isExpanded) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp))
                        .background(BentoGreenBg)
                        .border(1.dp, BentoGreenBorder, RoundedCornerShape(18.dp))
                        .padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = "✓ Correct Answer: $correctOptionText",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 13.sp,
                        color = BentoGreenText
                    )
                    Text(
                        text = item.explanation,
                        fontSize = 12.sp,
                        color = BentoOnSurface,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

