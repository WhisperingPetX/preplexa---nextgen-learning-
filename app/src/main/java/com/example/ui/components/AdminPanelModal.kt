package com.example.ui.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.data.local.CustomQuestionEntity
import com.example.data.repository.SyllabusRepository
import com.example.model.ExamType
import com.example.model.Subject
import com.example.ui.theme.*
import com.example.ui.viewmodel.MainViewModel
import java.util.UUID

// --- 1. ADMIN PASSWORD AUTHENTICATION DIALOG ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminPasswordDialog(
    onDismiss: () -> Unit,
    onSuccess: () -> Unit
) {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = BentoBackground,
            border = BorderStroke(1.5.dp, BentoPrimary),
            shadowElevation = 8.dp,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Surface(
                    shape = CircleShape,
                    color = BentoPrimaryContainer,
                    modifier = Modifier.size(56.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Admin Lock",
                            tint = BentoPrimary,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "🔒 Admin Security Gate",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp,
                        color = BentoOnSurface
                    )
                    Text(
                        text = "Enter master admin password to unlock control panel",
                        fontSize = 11.5.sp,
                        color = BentoOnSurfaceVariant
                    )
                }

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        errorMessage = null
                    },
                    label = { Text("Admin Password") },
                    singleLine = true,
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                contentDescription = "Toggle Password",
                                tint = BentoOnSurfaceVariant
                            )
                        }
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = BentoPrimary,
                        unfocusedBorderColor = BentoSurfaceVariant
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                if (errorMessage != null) {
                    Text(
                        text = errorMessage!!,
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = onDismiss,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Cancel")
                    }

                    Button(
                        onClick = {
                            if (password.trim() == "Dolphin") {
                                onSuccess()
                            } else {
                                errorMessage = "❌ Incorrect Password! Hardcoded is 'Dolphin'"
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Unlock", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

// --- 2. MAIN ADMIN PANEL MODAL ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminPanelDialog(
    viewModel: MainViewModel,
    onDismiss: () -> Unit
) {
    val customQuestions by viewModel.customQuestions.collectAsState()
    val appNotice by viewModel.appUpdateNotice.collectAsState()
    val mPrice by viewModel.monthlyPrice.collectAsState()
    val sPrice by viewModel.sixMonthPrice.collectAsState()
    val yPrice by viewModel.yearlyPrice.collectAsState()

    var activeTab by remember { mutableStateOf(0) } // 0=PDF Extractor, 1=Question Bank, 2=Subscriptions, 3=App Updates

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = BentoBackground,
            border = BorderStroke(1.dp, BentoSurfaceVariant),
            modifier = Modifier
                .fillMaxSize(0.95f)
                .padding(vertical = 12.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                // Top Admin Header
                Surface(
                    color = BentoSurface,
                    shadowElevation = 2.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Surface(
                                color = BentoPrimaryContainer,
                                shape = CircleShape,
                                modifier = Modifier.size(36.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text("🛡️", fontSize = 18.sp)
                                }
                            }
                            Column {
                                Text(
                                    text = "Preplexa Admin Panel",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 16.sp,
                                    color = BentoOnSurface
                                )
                                Text(
                                    text = "Master Question Extractor & App Controls",
                                    fontSize = 10.5.sp,
                                    color = BentoOnSurfaceVariant
                                )
                            }
                        }

                        IconButton(onClick = onDismiss) {
                            Icon(Icons.Default.Close, contentDescription = "Close", tint = BentoOnSurface)
                        }
                    }
                }

                // Tab Bar
                ScrollableTabRow(
                    selectedTabIndex = activeTab,
                    containerColor = BentoSurface,
                    contentColor = BentoPrimary,
                    edgePadding = 12.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Tab(
                        selected = activeTab == 0,
                        onClick = { activeTab = 0 },
                        text = { Text("📥 PDF Extractor", fontWeight = FontWeight.Bold) }
                    )
                    Tab(
                        selected = activeTab == 1,
                        onClick = { activeTab = 1 },
                        text = { Text("🗄️ Questions (${customQuestions.size})", fontWeight = FontWeight.Bold) }
                    )
                    Tab(
                        selected = activeTab == 2,
                        onClick = { activeTab = 2 },
                        text = { Text("💳 Subscriptions", fontWeight = FontWeight.Bold) }
                    )
                    Tab(
                        selected = activeTab == 3,
                        onClick = { activeTab = 3 },
                        text = { Text("📢 App Updates", fontWeight = FontWeight.Bold) }
                    )
                    Tab(
                        selected = activeTab == 4,
                        onClick = { activeTab = 4 },
                        text = { Text("🔔 News Push", fontWeight = FontWeight.Bold) }
                    )
                }

                // Tab Content
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                ) {
                    when (activeTab) {
                        0 -> PdfExtractorTab(viewModel = viewModel)
                        1 -> QuestionBankManagerTab(viewModel = viewModel, customQuestions = customQuestions)
                        2 -> SubscriptionManagerTab(viewModel = viewModel, currentM = mPrice, current6M = sPrice, currentY = yPrice)
                        3 -> AppUpdatesTab(viewModel = viewModel, currentNotice = appNotice)
                        4 -> NewsPushManagerTab(viewModel = viewModel)
                    }
                }
            }
        }
    }
}

// --- TAB 1: PDF QUESTION EXTRACTOR ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PdfExtractorTab(viewModel: MainViewModel) {
    val context = LocalContext.current

    var uploadType by remember { mutableStateOf("LIBRARY_TOPIC") } // "LIBRARY_TOPIC" or "PYQ"
    
    // Topic Wise Fields
    var selectedSubject by remember { mutableStateOf(Subject.BIOLOGY) }
    var selectedTopicId by remember { mutableStateOf("phy_units_and_measurements") }

    // PYQ Fields
    var selectedExam by remember { mutableStateOf(ExamType.NEET_UG) }
    var selectedYear by remember { mutableStateOf("2026") }

    // Selected File & Extracted Text
    var selectedFileName by remember { mutableStateOf<String?>(null) }
    var rawText by remember { mutableStateOf("") }
    var parsedList by remember { mutableStateOf<List<CustomQuestionEntity>>(emptyList()) }
    var isExtracting by remember { mutableStateOf(false) }
    var statusMessage by remember { mutableStateOf<String?>(null) }

    val allTopics = SyllabusRepository.allTopics

    // File Picker Launcher for PDF & Document files
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            isExtracting = true
            selectedFileName = uri.lastPathSegment?.substringAfterLast('/') ?: "PDF Document"
            try {
                val extractedText = readTextFromUri(context, uri)
                if (extractedText.startsWith("ERROR_FILE_TOO_LARGE")) {
                    statusMessage = "❌ " + extractedText.substringAfter("ERROR_FILE_TOO_LARGE:").trim()
                    rawText = ""
                } else if (extractedText.isNotBlank()) {
                    rawText = extractedText
                    statusMessage = "📄 PDF File read successfully! Ready to extract questions."
                } else {
                    statusMessage = "⚠️ Could not read plain text from file. Try pasting text directly."
                }
            } catch (e: Exception) {
                statusMessage = "❌ Error reading file: ${e.localizedMessage}"
            } finally {
                isExtracting = false
            }
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Text(
                text = "1. Select Target Category & Syllabus Module",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = BentoPrimary
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChip(
                    selected = uploadType == "LIBRARY_TOPIC",
                    onClick = { uploadType = "LIBRARY_TOPIC"; parsedList = emptyList() },
                    label = { Text("📚 Library Topic Wise", fontSize = 12.sp) },
                    modifier = Modifier.weight(1f)
                )
                FilterChip(
                    selected = uploadType == "PYQ",
                    onClick = { uploadType = "PYQ"; parsedList = emptyList() },
                    label = { Text("📜 PYQ Paper Wise", fontSize = 12.sp) },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        if (uploadType == "LIBRARY_TOPIC") {
            item {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Select Subject:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface)
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Subject.values().forEach { sub ->
                            FilterChip(
                                selected = selectedSubject == sub,
                                onClick = { selectedSubject = sub },
                                label = { Text(sub.displayName, fontSize = 11.sp) }
                            )
                        }
                    }

                    Text("Target Topic:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface)
                    val matchingTopics = allTopics.filter { it.subject == selectedSubject }
                    ScrollableTabRow(
                        selectedTabIndex = matchingTopics.indexOfFirst { it.id == selectedTopicId }.coerceAtLeast(0),
                        edgePadding = 0.dp
                    ) {
                        matchingTopics.forEach { topic ->
                            Tab(
                                selected = selectedTopicId == topic.id,
                                onClick = { selectedTopicId = topic.id },
                                text = { Text(topic.title, fontSize = 11.sp) }
                            )
                        }
                    }
                }
            }
        } else {
            item {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Select Exam:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface)
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        ExamType.values().forEach { exam ->
                            FilterChip(
                                selected = selectedExam == exam,
                                onClick = { selectedExam = exam },
                                label = { Text(exam.displayName, fontSize = 12.sp) }
                            )
                        }
                    }

                    Text("Select Paper Year:", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface)
                    val years = listOf("2026", "2025", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017")
                    ScrollableTabRow(
                        selectedTabIndex = years.indexOf(selectedYear).coerceAtLeast(0),
                        edgePadding = 0.dp
                    ) {
                        years.forEach { yr ->
                            Tab(
                                selected = selectedYear == yr,
                                onClick = { selectedYear = yr },
                                text = { Text("$yr Paper", fontSize = 11.sp) }
                            )
                        }
                    }
                }
            }
        }

        item {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = BentoPrimaryContainer.copy(alpha = 0.3f),
                border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.4f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Icon(Icons.Default.UploadFile, contentDescription = "Upload", tint = BentoPrimary)
                            Text(
                                text = "2. Upload PDF / Document File",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.5.sp,
                                color = BentoOnSurface
                            )
                        }

                        TextButton(
                            onClick = {
                                rawText = getSamplePdfText(uploadType, if (uploadType == "LIBRARY_TOPIC") selectedSubject.displayName else selectedExam.displayName)
                                selectedFileName = "NTA_Official_Sample_Question_Paper.pdf"
                                statusMessage = "Loaded official NTA PDF questions text!"
                            }
                        ) {
                            Text("⚡ Load NTA PDF Sample", fontSize = 11.sp, fontWeight = FontWeight.ExtraBold)
                        }
                    }

                    Button(
                        onClick = { filePickerLauncher.launch("*/*") },
                        colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.AttachFile, contentDescription = "Select File", modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (selectedFileName != null) "📄 Change PDF File: $selectedFileName" else "📁 Select PDF File from Device",
                            fontWeight = FontWeight.Bold
                        )
                    }

                    if (selectedFileName != null) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = BentoSurface,
                            border = BorderStroke(1.dp, BentoSurfaceVariant)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text("✅ Selected File:", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFF10B981))
                                Text(selectedFileName!!, fontSize = 10.5.sp, color = BentoOnSurface)
                            }
                        }
                    }
                }
            }
        }

        item {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "Text Content Preview (Editable):",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = BentoOnSurfaceVariant
                )

                OutlinedTextField(
                    value = rawText,
                    onValueChange = { rawText = it },
                    placeholder = { Text("Or paste PDF text here e.g:\n\nQ1: What is the unit of force?\nA) Joule\nB) Newton\nC) Watt\nD) Pascal\nAnswer: B\nExplanation: SI unit of force is Newton (N).") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp),
                    shape = RoundedCornerShape(12.dp)
                )
            }
        }

        item {
            Button(
                onClick = {
                    if (rawText.isBlank()) {
                        statusMessage = "⚠️ Please select a PDF file or paste question text first."
                        return@Button
                    }
                    val targetKey = if (uploadType == "LIBRARY_TOPIC") selectedTopicId else "${selectedExam.name.lowercase()}_$selectedYear"
                    val subjectName = if (uploadType == "LIBRARY_TOPIC") selectedSubject.displayName else selectedExam.displayName
                    
                    val extracted = parseRawQuestionsText(
                        text = rawText,
                        category = uploadType,
                        subject = subjectName,
                        topicOrYear = targetKey
                    )

                    parsedList = extracted
                    statusMessage = if (extracted.isNotEmpty()) {
                        "✨ Successfully extracted ${extracted.size} questions with full options & answers!"
                    } else {
                        "⚠️ No questions detected in standard format. Check preview text."
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Default.AutoFixHigh, contentDescription = "Parse", modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("⚡ Extract & Separate Questions Automatically", fontWeight = FontWeight.Bold)
            }
        }

        if (statusMessage != null) {
            item {
                Surface(
                    color = BentoPrimaryContainer.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = statusMessage!!,
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = BentoPrimary,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }

        if (parsedList.isNotEmpty()) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Extracted Questions (${parsedList.size}):",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = BentoOnSurface
                    )

                    Button(
                        onClick = {
                            viewModel.insertCustomQuestions(parsedList)
                            statusMessage = "🎉 Successfully Saved ${parsedList.size} Questions to DB & Generated Tests!"
                            parsedList = emptyList()
                            rawText = ""
                            selectedFileName = null
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981))
                    ) {
                        Text("💾 Save All to DB", fontWeight = FontWeight.Bold, fontSize = 11.5.sp)
                    }
                }
            }

            items(parsedList.size) { index ->
                val q = parsedList[index]
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(
                            text = "Q${index + 1}: ${q.questionText}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.5.sp,
                            color = BentoOnSurface
                        )
                        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                            listOf(q.optionA, q.optionB, q.optionC, q.optionD).forEachIndexed { oIdx, opt ->
                                val isCorrect = oIdx == q.correctOptionIndex
                                Text(
                                    text = "${('A' + oIdx)}) $opt ${if (isCorrect) "✅ (Correct Answer)" else ""}",
                                    fontSize = 11.sp,
                                    color = if (isCorrect) Color(0xFF10B981) else BentoOnSurfaceVariant,
                                    fontWeight = if (isCorrect) FontWeight.Bold else FontWeight.Normal
                                )
                            }
                        }
                        if (q.explanation.isNotBlank()) {
                            Text(
                                text = "💡 Solution: ${q.explanation}",
                                fontSize = 10.5.sp,
                                color = BentoPrimary
                            )
                        }
                    }
                }
            }
        }
    }
}

// --- TAB 2: QUESTION BANK MANAGER ---
@Composable
fun QuestionBankManagerTab(
    viewModel: MainViewModel,
    customQuestions: List<CustomQuestionEntity>
) {
    var filterCategory by remember { mutableStateOf("ALL") }

    val filteredList = when (filterCategory) {
        "PYQ" -> customQuestions.filter { it.category == "PYQ" }
        "LIBRARY_TOPIC" -> customQuestions.filter { it.category == "LIBRARY_TOPIC" }
        else -> customQuestions
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    FilterChip(
                        selected = filterCategory == "ALL",
                        onClick = { filterCategory = "ALL" },
                        label = { Text("All (${customQuestions.size})") }
                    )
                    FilterChip(
                        selected = filterCategory == "LIBRARY_TOPIC",
                        onClick = { filterCategory = "LIBRARY_TOPIC" },
                        label = { Text("Library") }
                    )
                    FilterChip(
                        selected = filterCategory == "PYQ",
                        onClick = { filterCategory = "PYQ" },
                        label = { Text("PYQs") }
                    )
                }

                if (customQuestions.isNotEmpty()) {
                    IconButton(onClick = { viewModel.clearAllCustomQuestions() }) {
                        Icon(Icons.Default.Delete, contentDescription = "Clear All", tint = MaterialTheme.colorScheme.error)
                    }
                }
            }
        }

        if (filteredList.isEmpty()) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No custom uploaded questions yet.\nUse PDF Extractor tab to upload questions!",
                        fontSize = 12.sp,
                        color = BentoOnSurfaceVariant,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        } else {
            items(filteredList) { q ->
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Surface(
                                    color = if (q.category == "PYQ") Color(0xFFE0F2FE) else Color(0xFFD1FAE5),
                                    shape = RoundedCornerShape(4.dp)
                                ) {
                                    Text(
                                        text = q.category,
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = if (q.category == "PYQ") Color(0xFF0284C7) else Color(0xFF059669),
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                                Text(
                                    text = "${q.subject} • ${q.topicOrYear}",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = BentoOnSurfaceVariant
                                )
                            }
                            Text(
                                text = q.questionText,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = BentoOnSurface
                            )
                        }

                        IconButton(onClick = { viewModel.deleteCustomQuestion(q.id) }) {
                            Icon(Icons.Default.Delete, contentDescription = "Delete", tint = BentoOnSurfaceVariant)
                        }
                    }
                }
            }
        }
    }
}

// --- TAB 3: SUBSCRIPTION & FREE TRIAL MANAGER ---
@Composable
fun SubscriptionManagerTab(
    viewModel: MainViewModel,
    currentM: String,
    current6M: String,
    currentY: String
) {
    val isSubscribed by viewModel.isSubscribed.collectAsState()
    val trialDaysLeft by viewModel.trialDaysRemaining.collectAsState()
    val isServiceLocked by viewModel.isServiceLocked.collectAsState()

    var monthly by remember { mutableStateOf(currentM) }
    var sixMonths by remember { mutableStateOf(current6M) }
    var yearly by remember { mutableStateOf(currentY) }
    var savedNotice by remember { mutableStateOf<String?>(null) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = if (isSubscribed) Color(0xFFD1FAE5) else if (trialDaysLeft > 0) BentoPrimaryContainer else Color(0xFFFEE2E2),
                border = BorderStroke(1.dp, if (isSubscribed) Color(0xFF10B981) else if (trialDaysLeft > 0) BentoPrimary else Color(0xFFEF4444))
            ) {
                Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = if (isSubscribed) "👑 Status: Subscribed (PRO Active)" else if (trialDaysLeft > 0) "🎁 Status: 30-Day Free Trial ($trialDaysLeft Days Remaining)" else "🔒 Status: Trial Expired (Services Blocked)",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 13.sp,
                        color = if (isSubscribed) Color(0xFF047857) else if (trialDaysLeft > 0) BentoPrimary else Color(0xFFB91C1C)
                    )
                    Text(
                        text = "Use controls below to test 30-day trial expiry and service locking behavior.",
                        fontSize = 10.5.sp,
                        color = BentoOnSurfaceVariant
                    )
                }
            }
        }

        item {
            Text(
                text = "⚡ Test Trial & Access Locking Controls",
                fontWeight = FontWeight.Bold,
                fontSize = 13.5.sp,
                color = BentoPrimary
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {
                        viewModel.setTrialOverride(0)
                        viewModel.resetSubscriptionStatus(false)
                        savedNotice = "🔒 Trial set to Expired (0 days left). Services are now LOCKED!"
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF4444)),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Lock (0 Days)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }

                Button(
                    onClick = {
                        viewModel.setTrialOverride(-1)
                        viewModel.resetSubscriptionStatus(false)
                        savedNotice = "🎁 30-Day Free Trial reset successfully."
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Reset 30-Days", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }

                Button(
                    onClick = {
                        viewModel.activateSubscription("admin_test_pro")
                        savedNotice = "👑 PRO Subscription granted for testing."
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Grant PRO", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        item {
            Text(
                text = "💳 Dynamic Subscription Rates",
                fontWeight = FontWeight.Bold,
                fontSize = 13.5.sp,
                color = BentoPrimary
            )

            OutlinedTextField(
                value = monthly,
                onValueChange = { monthly = it },
                label = { Text("Monthly Plan Price (₹)") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(top = 4.dp)
            )

            OutlinedTextField(
                value = sixMonths,
                onValueChange = { sixMonths = it },
                label = { Text("6 Months Plan Price (₹)") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
            )

            OutlinedTextField(
                value = yearly,
                onValueChange = { yearly = it },
                label = { Text("Yearly Plan Price (₹)") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
            )

            Button(
                onClick = {
                    viewModel.updateSubscriptionPrices(monthly, sixMonths, yearly)
                    savedNotice = "✅ Subscription rates updated successfully!"
                },
                colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
            ) {
                Text("Update Pricing Plans", fontWeight = FontWeight.Bold)
            }

            if (savedNotice != null) {
                Text(
                    text = savedNotice!!,
                    color = Color(0xFF10B981),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 6.dp)
                )
            }
        }
    }
}

// --- TAB 4: APP UPDATES & ANNOUNCEMENTS ---
@Composable
fun AppUpdatesTab(
    viewModel: MainViewModel,
    currentNotice: String
) {
    var noticeText by remember { mutableStateOf(currentNotice) }
    var savedStatus by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text(
            text = "📢 App Version & Student Broadcast Banner",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = BentoPrimary
        )

        OutlinedTextField(
            value = noticeText,
            onValueChange = { noticeText = it },
            label = { Text("Announcement Notice / Update Message") },
            placeholder = { Text("e.g. 🎉 Preplexa v1.2.0: Official NTA 2026 PYQs & Updated NCERT Biology Syllabus Unlocked!") },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = {
                    viewModel.updateAppNotice(noticeText)
                    savedStatus = "📢 Broadcast banner published to all students!"
                },
                colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text("Publish Banner", fontWeight = FontWeight.Bold)
            }

            OutlinedButton(
                onClick = {
                    noticeText = ""
                    viewModel.updateAppNotice("")
                    savedStatus = "Banner cleared."
                },
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Clear Notice")
            }
        }

        if (savedStatus != null) {
            Text(
                text = savedStatus!!,
                color = BentoPrimary,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

// --- UTILITY: READ TEXT FROM URI / PDF STREAM ---
fun readTextFromUri(context: android.content.Context, uri: Uri): String {
    return try {
        context.contentResolver.openFileDescriptor(uri, "r")?.use { descriptor ->
            val fileSize = descriptor.statSize
            if (fileSize > 5 * 1024 * 1024) {
                return "ERROR_FILE_TOO_LARGE: The selected PDF is too large (${fileSize / 1024 / 1024} MB). Please use files smaller than 5 MB. For large 33MB files, please extract text on a computer or upload to cloud storage."
            }
        }

        context.contentResolver.openInputStream(uri)?.use { inputStream ->
            val rawBytes = inputStream.readBytes()
            val rawString = String(rawBytes, Charsets.UTF_8)
            
            // If PDF signature detected
            if (rawString.contains("%PDF")) {
                extractTextFromPdfBytes(rawBytes)
            } else {
                rawString
            }
        } ?: ""
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}

fun extractTextFromPdfBytes(bytes: ByteArray): String {
    val fullString = String(bytes, Charsets.ISO_8859_1)
    val sb = StringBuilder()
    
    // PDF text stream string matching (BT ... ET)
    val matcher = java.util.regex.Pattern.compile("\\(.*?\\)|Tj|TJ|T[dD]|BT|ET").matcher(fullString)
    while (matcher.find()) {
        val group = matcher.group()
        if (group.startsWith("(") && group.endsWith(")")) {
            val text = group.substring(1, group.length - 1)
                .replace("\\)", ")")
                .replace("\\(", "(")
                .replace("\\r", "\n")
                .replace("\\n", "\n")
            if (text.length > 1) {
                sb.append(text).append(" ")
            }
        }
    }

    val extracted = sb.toString().trim()
    if (extracted.length > 60) {
        return cleanAndFormatExtractedPdfText(extracted)
    }

    // Fallback: extract printable ASCII text blocks
    val cleanAscii = fullString.lines()
        .filter { line -> line.any { it in 'a'..'z' || it in 'A'..'Z' } && !line.startsWith("%") && !line.startsWith("<<") && !line.startsWith(">>") }
        .joinToString("\n")
    
    return cleanAndFormatExtractedPdfText(cleanAscii)
}

fun cleanAndFormatExtractedPdfText(raw: String): String {
    return raw
        .replace(Regex("\\s+"), " ")
        .replace(Regex("(?i)(Q\\d+[\\:\\.\\)]|Question\\s*\\d+|\\b\\d+\\.\\s+)"), "\n\n$1")
        .replace(Regex("(?i)(\\(A\\)|A\\)|A\\.\\s+)"), "\nA) ")
        .replace(Regex("(?i)(\\(B\\)|B\\)|B\\.\\s+)"), "\nB) ")
        .replace(Regex("(?i)(\\(C\\)|C\\)|C\\.\\s+)"), "\nC) ")
        .replace(Regex("(?i)(\\(D\\)|D\\)|D\\.\\s+)"), "\nD) ")
        .replace(Regex("(?i)(Ans:|Answer:|Correct Option:|Correct:)"), "\nAnswer: ")
        .replace(Regex("(?i)(Expl:|Solution:|Explanation:|Sol:)"), "\nExplanation: ")
        .trim()
}

// --- UTILITY: PARSE RAW QUESTION TEXT FROM PDF ---
fun parseRawQuestionsText(
    text: String,
    category: String,
    subject: String,
    topicOrYear: String
): List<CustomQuestionEntity> {
    val list = mutableListOf<CustomQuestionEntity>()
    
    // Format and normalize text
    val formattedText = cleanAndFormatExtractedPdfText(text)
    val lines = formattedText.split("\n").map { it.trim() }.filter { it.isNotBlank() }

    var currentQText = ""
    var optionA = ""
    var optionB = ""
    var optionC = ""
    var optionD = ""
    var correctIndex = 0
    var explanation = ""

    fun addCurrent() {
        if (currentQText.isNotBlank()) {
            list.add(
                CustomQuestionEntity(
                    id = "custom_${UUID.randomUUID().toString().take(8)}",
                    category = category,
                    subject = subject,
                    topicOrYear = topicOrYear,
                    questionText = currentQText.trim(),
                    optionA = optionA.ifBlank { "Option A" }.trim(),
                    optionB = optionB.ifBlank { "Option B" }.trim(),
                    optionC = optionC.ifBlank { "Option C" }.trim(),
                    optionD = optionD.ifBlank { "Option D" }.trim(),
                    correctOptionIndex = correctIndex,
                    explanation = explanation.ifBlank { "NTA Standard Concept Solution." }.trim()
                )
            )
        }
        currentQText = ""
        optionA = ""
        optionB = ""
        optionC = ""
        optionD = ""
        correctIndex = 0
        explanation = ""
    }

    for (line in lines) {
        val lower = line.lowercase()
        when {
            lower.startsWith("q") || lower.matches(Regex("^\\d+[\\.\\:\\)].*")) -> {
                if (currentQText.isNotBlank()) addCurrent()
                currentQText = line.replaceFirst(Regex("^(q|Q)?\\d+[\\.\\:\\)]\\s*"), "")
            }
            lower.startsWith("a)") || lower.startsWith("(a)") || lower.startsWith("a.") -> {
                optionA = line.replaceFirst(Regex("^(\\(a\\)|a\\)|a\\.)\\s*"), "")
            }
            lower.startsWith("b)") || lower.startsWith("(b)") || lower.startsWith("b.") -> {
                optionB = line.replaceFirst(Regex("^(\\(b\\)|b\\)|b\\.)\\s*"), "")
            }
            lower.startsWith("c)") || lower.startsWith("(c)") || lower.startsWith("c.") -> {
                optionC = line.replaceFirst(Regex("^(\\(c\\)|c\\)|c\\.)\\s*"), "")
            }
            lower.startsWith("d)") || lower.startsWith("(d)") || lower.startsWith("d.") -> {
                optionD = line.replaceFirst(Regex("^(\\(d\\)|d\\)|d\\.)\\s*"), "")
            }
            lower.startsWith("ans") || lower.startsWith("correct") -> {
                when {
                    lower.contains("a") || lower.contains("1") -> correctIndex = 0
                    lower.contains("b") || lower.contains("2") -> correctIndex = 1
                    lower.contains("c") || lower.contains("3") -> correctIndex = 2
                    lower.contains("d") || lower.contains("4") -> correctIndex = 3
                }
            }
            lower.startsWith("expl") || lower.startsWith("sol") -> {
                explanation = line.replaceFirst(Regex("^(expl|sol|solution|explanation)[\\:\\s]*", RegexOption.IGNORE_CASE), "")
            }
            else -> {
                if (optionD.isBlank() && optionA.isBlank()) {
                    currentQText += " $line"
                } else if (optionD.isNotBlank() && explanation.isBlank()) {
                    // Could be part of option D or explanation
                    if (lower.contains("answer") || lower.contains("ans")) {
                        when {
                            lower.contains("a") || lower.contains("1") -> correctIndex = 0
                            lower.contains("b") || lower.contains("2") -> correctIndex = 1
                            lower.contains("c") || lower.contains("3") -> correctIndex = 2
                            lower.contains("d") || lower.contains("4") -> correctIndex = 3
                        }
                    } else {
                        optionD += " $line"
                    }
                } else if (explanation.isNotBlank()) {
                    explanation += " $line"
                }
            }
        }
    }
    if (currentQText.isNotBlank()) addCurrent()

    return list
}

fun getSamplePdfText(category: String, target: String): String {
    return """
        Q1: In $target, what is the primary factor determining cellular ATP synthesis during aerobic respiration?
        A) Ribosomal protein density
        B) Proton gradient across the inner mitochondrial membrane
        C) Sodium-Potassium pump balance
        D) Cytoplasmic DNA transcription rate
        Answer: B
        Explanation: The chemiosmotic hypothesis states that ATP synthesis by ATP synthase is driven by a proton gradient generated across the inner mitochondrial membrane.

        Q2: Which statement is CORRECT regarding $target standard NTA exam pattern?
        A) All questions carry equal negative marking of -5
        B) Numerical value questions require exact unit conversion
        C) Mass is a derived physical dimension
        D) Acceleration is inversely proportional to net force
        Answer: B
        Explanation: Numerical questions in NTA exams require precise physical unit conversions and formula application.

        Q3: Evaluate the magnitude of velocity when displacement s(t) = 3t² + 2t at time t = 2 seconds.
        A) 12 m/s
        B) 14 m/s
        C) 16 m/s
        D) 10 m/s
        Ans: B
        Explanation: Velocity v(t) = ds/dt = 6t + 2. At t = 2 s, v(2) = 6(2) + 2 = 14 m/s.
    """.trimIndent()
}

@Composable
fun NewsPushManagerTab(viewModel: MainViewModel) {
    val adminNewsList by viewModel.adminNewsList.collectAsState()
    var newNews by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Push News & Notifications",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp,
            color = BentoOnSurface
        )

        OutlinedTextField(
            value = newNews,
            onValueChange = { newNews = it },
            label = { Text("Enter News Notification") },
            placeholder = { Text("NTA released new exam dates...") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (newNews.isNotBlank()) {
                    viewModel.addAdminNews(newNews)
                    newNews = ""
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Push News", fontWeight = FontWeight.Bold, color = Color.White)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Pushed News History",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = BentoOnSurfaceVariant
        )

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(adminNewsList) { news ->
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = BentoSurface,
                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp).fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = news,
                            fontSize = 13.sp,
                            color = BentoOnSurface,
                            modifier = Modifier.weight(1f)
                        )
                        IconButton(onClick = { viewModel.removeAdminNews(news) }) {
                            Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.Red)
                        }
                    }
                }
            }
        }
    }
}
