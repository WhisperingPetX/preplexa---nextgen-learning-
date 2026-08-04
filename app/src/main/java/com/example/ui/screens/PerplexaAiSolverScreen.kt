package com.example.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.animation.core.*
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.model.ExamType
import com.example.ui.theme.*
import com.example.ui.viewmodel.MainViewModel
import com.example.ui.viewmodel.Screen
import kotlinx.coroutines.delay
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

    // Entrance Fusion Animation State
    var showSplashAnimation by remember { mutableStateOf(true) }

    // Chat States
    var userQuery by remember { mutableStateOf("") }
    var attachedImageUri by remember { mutableStateOf<Uri?>(null) }
    var attachedPdfName by remember { mutableStateOf<String?>(null) }
    var isVoiceListening by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    // Conversation List
    var chatMessages by remember {
        mutableStateOf(
            listOf(
                ChatMessage(
                    sender = "AI",
                    text = "Namaste $studentName! 👋 Main Gemini hu — aapka AI assistant ✨\n\nPhysics, Chemistry, Biology, ya Maths ka koi bhi question pucho, Diagram ki photo 📷 upload karo, ya PDF document 📄 attach karo. Aaiye bilkul naturally discuss karke step-by-step solve karte hain!"
                )
            )
        )
    }

    val listState = rememberLazyListState()

    // Auto scroll chat to bottom when new message arrives
    LaunchedEffect(chatMessages.size, isLoading) {
        if (chatMessages.isNotEmpty()) {
            listState.animateScrollToItem(chatMessages.size - 1)
        }
    }

    // Splash animation timer
    LaunchedEffect(Unit) {
        delay(1400)
        showSplashAnimation = false
    }

    // Image Picker Launcher
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            attachedImageUri = uri
        }
    }

    // PDF / Document Picker Launcher
    val pdfPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            // Get file name or display fallback
            val fileName = uri.lastPathSegment?.substringAfterLast("/") ?: "Attached_Document.pdf"
            attachedPdfName = if (fileName.contains(".pdf")) fileName else "$fileName.pdf"
        }
    }

    // Quick Prompts list based on NEET vs JEE
    val quickPrompts = remember(selectedExam) {
        if (selectedExam == ExamType.NEET_UG) {
            listOf(
                "🧬 NCERT Biology Diagram Explanation",
                "⚡ Physics Numerical Shortcut Tricks",
                "🧪 Organic Chemistry Mechanism Steps",
                "🎯 NEET 680+ Score Strategy"
            )
        } else {
            listOf(
                "⚡ Physics Rotation Motion Formula",
                "📐 JEE Calculus Integration Trick",
                "🧪 Thermodynamics Work Equations",
                "🚀 JEE Mains 99 Percentile Strategy"
            )
        }
    }

    val sendMessageHandler: (String) -> Unit = { queryText ->
        val textToSend = queryText.trim()
        if ((textToSend.isNotEmpty() || attachedImageUri != null || attachedPdfName != null) && !isLoading) {
            val userMsg = ChatMessage(
                sender = "USER",
                text = textToSend.ifEmpty { "Analyze attached file/image" },
                attachedImageUri = attachedImageUri,
                attachedPdfName = attachedPdfName
            )

            chatMessages = chatMessages + userMsg

            // Store copy of attachments for API call
            val currentImgUri = attachedImageUri
            val currentPdfName = attachedPdfName

            // Clear input bar
            userQuery = ""
            attachedImageUri = null
            attachedPdfName = null
            isLoading = true

            coroutineScope.launch {
                val fullPrompt = buildString {
                    append(textToSend)
                    if (currentImgUri != null) append(" [Student attached an image/diagram]")
                    if (currentPdfName != null) append(" [Student attached document: $currentPdfName]")
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
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = BentoPrimaryContainer,
                            border = BorderStroke(1.5.dp, BentoPrimary),
                            modifier = Modifier.size(38.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text("🪐", fontSize = 20.sp)
                            }
                        }
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = "Perplexa AI Solver",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 16.sp,
                                    color = BentoOnSurface
                                )
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = Color(0xFF10B981).copy(alpha = 0.15f),
                                    border = BorderStroke(1.dp, Color(0xFF10B981))
                                ) {
                                    Text(
                                        text = "GEMINI PRO ✨",
                                        fontSize = 8.5.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color(0xFF10B981),
                                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                    )
                                }
                            }
                            Text(
                                text = "${selectedExam.displayName} • 24/7 AI Doubt Mentor",
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
                            contentDescription = "Back to Home",
                            tint = BentoOnSurface
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            chatMessages = listOf(
                                ChatMessage(
                                    sender = "AI",
                                    text = "Chat reset. Ask any new doubt for ${selectedExam.displayName}!"
                                )
                            )
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Delete,
                            contentDescription = "Clear Chat",
                            tint = BentoOnSurfaceVariant
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BentoSurface)
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(BentoBackground),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .widthIn(max = 720.dp)
            ) {
                // --- QUICK SUGGESTION PROMPTS ROW ---
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(quickPrompts) { prompt ->
                        Surface(
                            onClick = { sendMessageHandler(prompt) },
                            shape = RoundedCornerShape(16.dp),
                            color = BentoSurface,
                            border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.4f)),
                            shadowElevation = 1.dp
                        ) {
                            Text(
                                text = prompt,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = BentoPrimary,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                            )
                        }
                    }
                }

                Divider(color = BentoSurfaceVariant, thickness = 1.dp)

                // --- CHAT MESSAGES LIST ---
                LazyColumn(
                    state = listState,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(top = 12.dp, bottom = 16.dp)
                ) {
                    items(chatMessages, key = { it.id }) { message ->
                        val isUser = message.sender == "USER"

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start,
                            verticalAlignment = Alignment.Top
                        ) {
                            if (!isUser) {
                                Surface(
                                    shape = CircleShape,
                                    color = BentoPrimaryContainer,
                                    border = BorderStroke(1.dp, BentoPrimary),
                                    modifier = Modifier
                                        .size(34.dp)
                                        .padding(top = 2.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text("🪐", fontSize = 16.sp)
                                    }
                                }
                                Spacer(modifier = Modifier.width(8.dp))
                            }

                            Column(
                                horizontalAlignment = if (isUser) Alignment.End else Alignment.Start,
                                modifier = Modifier.widthIn(max = 320.dp)
                            ) {
                                // Sender name & timestamp
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                                    modifier = Modifier.padding(bottom = 3.dp)
                                ) {
                                    Text(
                                        text = if (isUser) "$studentName $studentAvatar" else "Perplexa AI Gemini",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 11.sp,
                                        color = if (isUser) BentoPrimary else Color(0xFF0284C7)
                                    )
                                    Text(
                                        text = message.timestamp,
                                        fontSize = 9.5.sp,
                                        color = BentoOnSurfaceVariant
                                    )
                                }

                                // Message Bubble
                                Surface(
                                    shape = RoundedCornerShape(
                                        topStart = 16.dp,
                                        topEnd = 16.dp,
                                        bottomStart = if (isUser) 16.dp else 4.dp,
                                        bottomEnd = if (isUser) 4.dp else 16.dp
                                    ),
                                    color = if (isUser) BentoPrimary else BentoSurface,
                                    border = BorderStroke(
                                        1.dp,
                                        if (isUser) BentoPrimary else BentoSurfaceVariant
                                    ),
                                    shadowElevation = 1.dp
                                ) {
                                    Column(modifier = Modifier.padding(12.dp)) {
                                        // Display attached image thumbnail if present
                                        if (message.attachedImageUri != null) {
                                            AsyncImage(
                                                model = message.attachedImageUri,
                                                contentDescription = "Attached Doubt Image",
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .heightIn(max = 180.dp)
                                                    .clip(RoundedCornerShape(10.dp))
                                                    .padding(bottom = 8.dp)
                                            )
                                        }

                                        // Display attached PDF badge if present
                                        if (message.attachedPdfName != null) {
                                            Surface(
                                                shape = RoundedCornerShape(8.dp),
                                                color = if (isUser) Color.White.copy(alpha = 0.2f) else BentoPrimaryContainer,
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
                                                        fontSize = 11.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        color = if (isUser) Color.White else BentoOnSurface
                                                    )
                                                }
                                            }
                                        }

                                        Text(
                                            text = message.text,
                                            fontSize = 13.5.sp,
                                            lineHeight = 19.sp,
                                            color = if (isUser) Color.White else BentoOnSurface
                                        )

                                        // Copy text option for AI messages
                                        if (!isUser) {
                                            Spacer(modifier = Modifier.height(8.dp))
                                            Row(
                                                modifier = Modifier
                                                    .clip(RoundedCornerShape(6.dp))
                                                    .clickable {
                                                        clipboardManager.setText(AnnotatedString(message.text))
                                                        android.widget.Toast.makeText(context, "Copied AI Answer!", android.widget.Toast.LENGTH_SHORT).show()
                                                    }
                                                    .padding(horizontal = 6.dp, vertical = 3.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Outlined.ContentCopy,
                                                    contentDescription = "Copy Text",
                                                    tint = BentoPrimary,
                                                    modifier = Modifier.size(12.dp)
                                                )
                                                Text(
                                                    text = "Copy Answer",
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = BentoPrimary
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // Loading State Indicator
                    if (isLoading) {
                        item {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                modifier = Modifier.padding(vertical = 8.dp)
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(20.dp),
                                    strokeWidth = 2.5.dp,
                                    color = BentoPrimary
                                )
                                Text(
                                    text = "Google Gemini AI is formulating solution...",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = BentoOnSurfaceVariant
                                )
                            }
                        }
                    }
                }

                // --- ATTACHMENT PREVIEW DOCK (If student picked image or PDF) ---
                if (attachedImageUri != null || attachedPdfName != null || isVoiceListening) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 4.dp),
                        shape = RoundedCornerShape(12.dp),
                        color = BentoSurface,
                        border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.5f))
                    ) {
                        Row(
                            modifier = Modifier.padding(8.dp),
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
                                        contentDescription = "Preview Image",
                                        modifier = Modifier
                                            .size(40.dp)
                                            .clip(RoundedCornerShape(6.dp))
                                    )
                                    Column {
                                        Text("📷 Photo Attached", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface)
                                        Text("Tap Send to analyze diagram", fontSize = 9.5.sp, color = BentoOnSurfaceVariant)
                                    }
                                } else if (attachedPdfName != null) {
                                    Text("📄", fontSize = 24.sp)
                                    Column {
                                        Text(attachedPdfName!!, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface)
                                        Text("PDF Document attached", fontSize = 9.5.sp, color = BentoOnSurfaceVariant)
                                    }
                                } else if (isVoiceListening) {
                                    val pulseInfinite = rememberInfiniteTransition(label = "voice_pulse")
                                    val voiceScale by pulseInfinite.animateFloat(
                                        initialValue = 0.9f,
                                        targetValue = 1.15f,
                                        animationSpec = infiniteRepeatable(
                                            animation = tween(600, easing = FastOutSlowInEasing),
                                            repeatMode = RepeatMode.Reverse
                                        ),
                                        label = "voice_scale"
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Mic,
                                        contentDescription = "Mic",
                                        tint = Color(0xFFEF4444),
                                        modifier = Modifier.graphicsLayer {
                                            scaleX = voiceScale
                                            scaleY = voiceScale
                                        }
                                    )
                                    Column {
                                        Text("🎙️ Listening to your voice...", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFEF4444))
                                        Text("Speak your question clearly", fontSize = 9.5.sp, color = BentoOnSurfaceVariant)
                                    }
                                }
                            }

                            IconButton(
                                onClick = {
                                    attachedImageUri = null
                                    attachedPdfName = null
                                    isVoiceListening = false
                                }
                            ) {
                                Icon(Icons.Default.Close, contentDescription = "Remove", tint = BentoOnSurfaceVariant)
                            }
                        }
                    }
                }

                // --- MULTI-MODAL INPUT & ATTACHMENT BAR ---
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = BentoSurface,
                    shadowElevation = 8.dp
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                            .navigationBarsPadding()
                            .imePadding(),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        // Attachment Action Chips Row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // 📷 Image Pick Button
                            Surface(
                                onClick = { imagePickerLauncher.launch("image/*") },
                                shape = RoundedCornerShape(12.dp),
                                color = BentoSurfaceVariant,
                                border = BorderStroke(1.dp, BentoSurfaceVariant),
                                modifier = Modifier.testTag("ai_attach_image_button")
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Icon(Icons.Outlined.AddPhotoAlternate, contentDescription = null, tint = BentoPrimary, modifier = Modifier.size(16.dp))
                                    Text("Photo 📷", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface)
                                }
                            }

                            // 📄 PDF Pick Button
                            Surface(
                                onClick = { pdfPickerLauncher.launch("application/pdf") },
                                shape = RoundedCornerShape(12.dp),
                                color = BentoSurfaceVariant,
                                border = BorderStroke(1.dp, BentoSurfaceVariant),
                                modifier = Modifier.testTag("ai_attach_pdf_button")
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Icon(Icons.Outlined.PictureAsPdf, contentDescription = null, tint = Color(0xFFE11D48), modifier = Modifier.size(16.dp))
                                    Text("PDF 📄", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface)
                                }
                            }

                            // 🎙️ Voice Button
                            Surface(
                                onClick = {
                                    isVoiceListening = !isVoiceListening
                                    if (isVoiceListening) {
                                        userQuery = "Explain NCERT reaction mechanism for $selectedExam"
                                    }
                                },
                                shape = RoundedCornerShape(12.dp),
                                color = if (isVoiceListening) Color(0xFFFEE2E2) else BentoSurfaceVariant,
                                border = BorderStroke(1.dp, if (isVoiceListening) Color(0xFFEF4444) else BentoSurfaceVariant),
                                modifier = Modifier.testTag("ai_voice_button")
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Icon(
                                        Icons.Outlined.Mic,
                                        contentDescription = null,
                                        tint = if (isVoiceListening) Color(0xFFEF4444) else BentoPrimary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Text("Voice 🎙️", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface)
                                }
                            }
                        }

                        // Text Field & Send Button Row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            OutlinedTextField(
                                value = userQuery,
                                onValueChange = { userQuery = it },
                                placeholder = {
                                    Text(
                                        text = "Ask doubt in Physics, Chem, Bio or Math...",
                                        fontSize = 12.sp,
                                        color = BentoOnSurfaceVariant
                                    )
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .testTag("ai_solver_text_input"),
                                shape = RoundedCornerShape(16.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = BentoPrimary,
                                    unfocusedBorderColor = BentoSurfaceVariant,
                                    focusedContainerColor = BentoBackground,
                                    unfocusedContainerColor = BentoBackground
                                ),
                                maxLines = 3
                            )

                            IconButton(
                                onClick = { sendMessageHandler(userQuery) },
                                modifier = Modifier
                                    .size(48.dp)
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
                                    contentDescription = "Send Question",
                                    tint = Color.White,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                }
            }

            // --- SPLASH TRANSITION ANIMATION OVERLAY (APP ICON + GOOGLE GEMINI) ---
            AnimatedVisibility(
                visible = showSplashAnimation,
                enter = fadeIn(),
                exit = fadeOut(animationSpec = tween(400))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(BentoBackground)
                        .clickable { showSplashAnimation = false },
                    contentAlignment = Alignment.Center
                ) {
                    val infiniteTransition = rememberInfiniteTransition(label = "splash_fusion")
                    val pulseScale by infiniteTransition.animateFloat(
                        initialValue = 0.92f,
                        targetValue = 1.08f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(600, easing = FastOutSlowInEasing),
                            repeatMode = RepeatMode.Reverse
                        ),
                        label = "fusion_pulse"
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                        modifier = Modifier.padding(24.dp)
                    ) {
                        // App Icon + Link Sparkle + Google Gemini Logo
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            // 1. App Icon Badge
                            Surface(
                                shape = RoundedCornerShape(22.dp),
                                color = BentoPrimaryContainer,
                                border = BorderStroke(2.dp, BentoPrimary),
                                shadowElevation = 6.dp,
                                modifier = Modifier
                                    .size(76.dp)
                                    .graphicsLayer {
                                        scaleX = pulseScale
                                        scaleY = pulseScale
                                    }
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text("🎓", fontSize = 38.sp)
                                }
                            }

                            // 2. Fusion Sparkles & Link
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("⚡", fontSize = 24.sp)
                                Text("LINKING", fontSize = 9.sp, fontWeight = FontWeight.ExtraBold, color = BentoPrimary)
                            }

                            // 3. Google Gemini Icon Badge
                            Surface(
                                shape = RoundedCornerShape(22.dp),
                                color = Color(0xFF0F172A),
                                border = BorderStroke(2.dp, Color(0xFF38BDF8)),
                                shadowElevation = 6.dp,
                                modifier = Modifier
                                    .size(76.dp)
                                    .graphicsLayer {
                                        scaleX = pulseScale
                                        scaleY = pulseScale
                                    }
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text("✨", fontSize = 38.sp)
                                }
                            }
                        }

                        Text(
                            text = "Perplexa AI × Google Gemini",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = BentoOnSurface
                        )

                        Surface(
                            shape = RoundedCornerShape(20.dp),
                            color = BentoPrimaryContainer,
                            border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.4f))
                        ) {
                            Text(
                                text = "Initializing Live AI Doubt Solver Workspace...",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = BentoPrimary,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                            )
                        }

                        Text(
                            text = "Tap anywhere to skip",
                            fontSize = 11.sp,
                            color = BentoOnSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}
