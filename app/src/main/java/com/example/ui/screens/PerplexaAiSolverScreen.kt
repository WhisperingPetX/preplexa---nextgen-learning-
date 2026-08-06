package com.example.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.model.ExamType
import com.example.ui.theme.*
import com.example.ui.viewmodel.MainViewModel
import com.example.ui.viewmodel.Screen
import kotlinx.coroutines.launch

data class ChatMessage(
    val id: String = java.util.UUID.randomUUID().toString(),
    val sender: String, // "USER" or "AI"
    val text: String,
    val attachedImageUri: Uri? = null,
    val attachedPdfName: String? = null,
    val timestamp: String = java.text.SimpleDateFormat("hh:mm a", java.util.Locale.getDefault()).format(java.util.Date())
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerplexaAiSolverScreen(viewModel: MainViewModel) {
    val selectedExam by viewModel.selectedExam.collectAsState()
    val studentName by viewModel.studentName.collectAsState()
    val studentAvatar by viewModel.studentAvatar.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val clipboardManager = LocalClipboardManager.current
    val context = LocalContext.current

    // Chat Input & State
    var userQuery by remember { mutableStateOf("") }
    var attachedImageUri by remember { mutableStateOf<Uri?>(null) }
    var attachedPdfName by remember { mutableStateOf<String?>(null) }
    var isVoiceListening by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    // Conversation List (Starts empty so we show Gemini-like welcome screen first)
    var chatMessages by remember { mutableStateOf<List<ChatMessage>>(emptyList()) }

    val listState = rememberLazyListState()

    // Scroll to bottom whenever messages or loading state changes
    LaunchedEffect(chatMessages.size, isLoading) {
        if (chatMessages.isNotEmpty()) {
            listState.animateScrollToItem(chatMessages.size - 1)
        }
    }

    // Pickers
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) attachedImageUri = uri
    }

    val pdfPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            val fileName = uri.lastPathSegment?.substringAfterLast("/") ?: "Document.pdf"
            attachedPdfName = if (fileName.contains(".pdf")) fileName else "$fileName.pdf"
        }
    }

    val quickPrompts = remember(selectedExam) {
        if (selectedExam == ExamType.NEET_UG) {
            listOf(
                "🧬 NCERT Biology Diagram Explanation",
                "⚡ Physics Numerical Formula Shortcuts",
                "🧪 Organic Chemistry Reaction Mechanism",
                "🎯 NEET 680+ Score Preparation Strategy"
            )
        } else {
            listOf(
                "⚡ Physics Rotation & Mechanics Formulas",
                "📐 JEE Calculus & Integration Shortcuts",
                "🧪 Physical Chemistry Thermodynamics",
                "🚀 JEE Mains 99 Percentile Target Plan"
            )
        }
    }

    val sendMessageHandler: (String) -> Unit = { queryText ->
        val textToSend = queryText.trim()
        if ((textToSend.isNotEmpty() || attachedImageUri != null || attachedPdfName != null) && !isLoading) {
            val userMsg = ChatMessage(
                sender = "USER",
                text = textToSend.ifEmpty { "Analyze attached document / diagram" },
                attachedImageUri = attachedImageUri,
                attachedPdfName = attachedPdfName
            )

            chatMessages = chatMessages + userMsg

            val currentImgUri = attachedImageUri
            val currentPdfName = attachedPdfName

            userQuery = ""
            attachedImageUri = null
            attachedPdfName = null
            isLoading = true

            coroutineScope.launch {
                val fullPrompt = buildString {
                    append(textToSend)
                    if (currentImgUri != null) append(" [Attached Image/Diagram]")
                    if (currentPdfName != null) append(" [Attached Document: $currentPdfName]")
                }

                val aiResponseText = com.example.data.ai.GeminiService.askDoubtOrChat(
                    userMessage = fullPrompt,
                    selectedExam = selectedExam.displayName
                )

                chatMessages = chatMessages + ChatMessage(
                    sender = "AI",
                    text = aiResponseText
                )
                isLoading = false
            }
        }
    }

    Scaffold(
        contentWindowInsets = WindowInsets.statusBars,
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = BentoPrimaryContainer,
                            border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.5f)),
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text("✨", fontSize = 18.sp)
                            }
                        }
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = "Preplexa AI",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = BentoOnSurface
                                )
                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = BentoPrimaryContainer,
                                    border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.3f))
                                ) {
                                    Text(
                                        text = "Gemini 2.5",
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = BentoPrimary,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }
                            Text(
                                text = "${selectedExam.displayName} Mentor",
                                fontSize = 11.sp,
                                color = BentoOnSurfaceVariant
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateToScreen(Screen.HOME) },
                        modifier = Modifier.testTag("ai_solver_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = BentoOnSurface
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { chatMessages = emptyList() }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.AddComment,
                            contentDescription = "New Chat",
                            tint = BentoOnSurface
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BentoSurface)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(BentoBackground)
                .navigationBarsPadding()
                .imePadding()
        ) {
            // Main Chat Area / Empty Welcome State
            if (chatMessages.isEmpty()) {
                // --- GEMINI STYLE WELCOME SCREEN ---
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Hello, $studentName ✨",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = BentoPrimary,
                        lineHeight = 34.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "How can I help with your ${selectedExam.displayName} preparation today?",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = BentoOnSurfaceVariant,
                        lineHeight = 22.sp
                    )

                    Spacer(modifier = Modifier.height(28.dp))

                    Text(
                        text = "Suggested Questions",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = BentoOnSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        quickPrompts.forEach { prompt ->
                            Surface(
                                onClick = { sendMessageHandler(prompt) },
                                shape = RoundedCornerShape(16.dp),
                                color = BentoSurface,
                                border = BorderStroke(1.dp, BentoSurfaceVariant),
                                shadowElevation = 1.dp,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = prompt,
                                        fontSize = 13.5.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = BentoOnSurface,
                                        modifier = Modifier.weight(1f)
                                    )
                                    Icon(
                                        imageVector = Icons.Outlined.ArrowForward,
                                        contentDescription = null,
                                        tint = BentoPrimary,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            } else {
                // --- CHAT MESSAGES STREAM ---
                LazyColumn(
                    state = listState,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(18.dp),
                    contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp)
                ) {
                    items(chatMessages, key = { it.id }) { message ->
                        val isUser = message.sender == "USER"

                        if (isUser) {
                            // User Message Bubble (Right aligned pill)
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Surface(
                                    shape = RoundedCornerShape(20.dp),
                                    color = BentoPrimary,
                                    shadowElevation = 1.dp,
                                    modifier = Modifier.widthIn(max = 300.dp)
                                ) {
                                    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
                                        if (message.attachedImageUri != null) {
                                            AsyncImage(
                                                model = message.attachedImageUri,
                                                contentDescription = "Attached Image",
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .heightIn(max = 180.dp)
                                                    .clip(RoundedCornerShape(12.dp))
                                                    .padding(bottom = 8.dp)
                                            )
                                        }

                                        if (message.attachedPdfName != null) {
                                            Surface(
                                                shape = RoundedCornerShape(10.dp),
                                                color = Color.White.copy(alpha = 0.2f),
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(bottom = 8.dp)
                                            ) {
                                                Row(
                                                    modifier = Modifier.padding(8.dp),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                                ) {
                                                    Text("📄", fontSize = 16.sp)
                                                    Text(
                                                        text = message.attachedPdfName,
                                                        fontSize = 12.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        color = Color.White
                                                    )
                                                }
                                            }
                                        }

                                        Text(
                                            text = message.text,
                                            fontSize = 14.5.sp,
                                            lineHeight = 20.sp,
                                            color = Color.White
                                        )
                                    }
                                }
                            }
                        } else {
                            // AI Message Response (Full Width Gemini Style)
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                // AI Header
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Surface(
                                        shape = CircleShape,
                                        color = BentoPrimaryContainer,
                                        modifier = Modifier.size(26.dp)
                                    ) {
                                        Box(contentAlignment = Alignment.Center) {
                                            Text("✨", fontSize = 14.sp)
                                        }
                                    }
                                    Text(
                                        text = "Preplexa AI",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.sp,
                                        color = BentoPrimary
                                    )
                                    Text(
                                        text = message.timestamp,
                                        fontSize = 10.sp,
                                        color = BentoOnSurfaceVariant
                                    )
                                }

                                // Formatted Response Body
                                Surface(
                                    shape = RoundedCornerShape(16.dp),
                                    color = BentoSurface,
                                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                                    shadowElevation = 0.5.dp,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(modifier = Modifier.padding(16.dp)) {
                                        FormattedAiResponseText(text = message.text)

                                        Spacer(modifier = Modifier.height(12.dp))

                                        // Action Row
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.End,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Surface(
                                                onClick = {
                                                    clipboardManager.setText(AnnotatedString(message.text))
                                                    android.widget.Toast.makeText(context, "Copied response!", android.widget.Toast.LENGTH_SHORT).show()
                                                },
                                                shape = RoundedCornerShape(8.dp),
                                                color = BentoSurfaceVariant
                                            ) {
                                                Row(
                                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                                ) {
                                                    Icon(
                                                        imageVector = Icons.Outlined.ContentCopy,
                                                        contentDescription = "Copy",
                                                        tint = BentoOnSurfaceVariant,
                                                        modifier = Modifier.size(13.dp)
                                                    )
                                                    Text(
                                                        text = "Copy",
                                                        fontSize = 11.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        color = BentoOnSurfaceVariant
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (isLoading) {
                        item {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                modifier = Modifier.padding(vertical = 8.dp)
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(18.dp),
                                    strokeWidth = 2.dp,
                                    color = BentoPrimary
                                )
                                Text(
                                    text = "Preplexa AI is thinking...",
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = BentoOnSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }

            // Attached Item Dock Preview
            if (attachedImageUri != null || attachedPdfName != null || isVoiceListening) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.4f))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            if (attachedImageUri != null) {
                                AsyncImage(
                                    model = attachedImageUri,
                                    contentDescription = "Attached",
                                    modifier = Modifier
                                        .size(36.dp)
                                        .clip(RoundedCornerShape(6.dp))
                                )
                                Text("📷 Image attached", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface)
                            } else if (attachedPdfName != null) {
                                Text("📄", fontSize = 20.sp)
                                Text(attachedPdfName!!, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface)
                            } else if (isVoiceListening) {
                                Icon(Icons.Default.Mic, contentDescription = null, tint = Color(0xFFEF4444))
                                Text("🎙️ Listening to voice query...", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFFEF4444))
                            }
                        }

                        IconButton(
                            onClick = {
                                attachedImageUri = null
                                attachedPdfName = null
                                isVoiceListening = false
                            },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(Icons.Default.Close, contentDescription = "Remove", tint = BentoOnSurfaceVariant)
                        }
                    }
                }
            }

            // --- GEMINI STYLE BOTTOM INPUT BAR ---
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                shape = RoundedCornerShape(28.dp),
                color = BentoSurface,
                border = BorderStroke(1.dp, BentoSurfaceVariant),
                shadowElevation = 2.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    // Attachment Action Menu Button (+)
                    IconButton(
                        onClick = { imagePickerLauncher.launch("image/*") },
                        modifier = Modifier.size(38.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.AddCircleOutline,
                            contentDescription = "Attach Media",
                            tint = BentoPrimary,
                            modifier = Modifier.size(22.dp)
                        )
                    }

                    // PDF Button
                    IconButton(
                        onClick = { pdfPickerLauncher.launch("application/pdf") },
                        modifier = Modifier.size(38.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.PictureAsPdf,
                            contentDescription = "Attach PDF",
                            tint = Color(0xFFE11D48),
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    // Text Field Input
                    OutlinedTextField(
                        value = userQuery,
                        onValueChange = { userQuery = it },
                        placeholder = {
                            Text(
                                text = "Ask Preplexa AI anything...",
                                fontSize = 13.5.sp,
                                color = BentoOnSurfaceVariant
                            )
                        },
                        modifier = Modifier
                            .weight(1f)
                            .testTag("ai_solver_text_input"),
                        shape = RoundedCornerShape(22.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent
                        ),
                        maxLines = 4
                    )

                    // Mic Voice Action Button
                    IconButton(
                        onClick = {
                            isVoiceListening = !isVoiceListening
                            if (isVoiceListening) {
                                userQuery = "Explain NCERT reaction mechanism for $selectedExam"
                            }
                        },
                        modifier = Modifier.size(38.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Mic,
                            contentDescription = "Voice Input",
                            tint = if (isVoiceListening) Color(0xFFEF4444) else BentoOnSurfaceVariant,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    // Send Button
                    IconButton(
                        onClick = { sendMessageHandler(userQuery) },
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(
                                if ((userQuery.isNotBlank() || attachedImageUri != null || attachedPdfName != null) && !isLoading)
                                    BentoPrimary
                                else
                                    BentoSurfaceVariant
                            )
                            .testTag("ai_solver_send_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Send,
                            contentDescription = "Send",
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }
    }
}

// Clean, spacious, formatted AI response parser
@Composable
fun FormattedAiResponseText(
    text: String,
    modifier: Modifier = Modifier
) {
    val paragraphs = remember(text) { text.split("\n\n") }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        paragraphs.forEach { paragraph ->
            val cleanParagraph = paragraph.trim()
            if (cleanParagraph.isBlank()) return@forEach

            // Check if paragraph is a code/formula block
            if (cleanParagraph.startsWith("```") || cleanParagraph.contains("```")) {
                val cleanCode = cleanParagraph.replace("```", "").trim()
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color(0xFF0F172A),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Text(
                        text = cleanCode,
                        fontSize = 12.5.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily.Monospace,
                        color = Color(0xFF38BDF8),
                        modifier = Modifier.padding(12.dp)
                    )
                }
            } else {
                Text(
                    text = parseMarkdownToAnnotatedString(cleanParagraph),
                    fontSize = 14.5.sp,
                    lineHeight = 22.sp,
                    color = BentoOnSurface
                )
            }
        }
    }
}

@Composable
private fun parseMarkdownToAnnotatedString(text: String): AnnotatedString {
    val textColor = BentoOnSurface
    val builder = AnnotatedString.Builder()
    val parts = text.split("**")
    for (i in parts.indices) {
        if (i % 2 == 1) {
            builder.pushStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, color = textColor))
            builder.append(parts[i])
            builder.pop()
        } else {
            builder.append(parts[i])
        }
    }
    return builder.toAnnotatedString()
}
