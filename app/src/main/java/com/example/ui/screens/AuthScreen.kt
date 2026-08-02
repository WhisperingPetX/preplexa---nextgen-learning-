package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.model.ExamType
import com.example.ui.theme.*
import com.example.ui.viewmodel.MainViewModel
import com.example.ui.viewmodel.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(viewModel: MainViewModel) {
    val supabaseStatus by viewModel.supabaseStatus.collectAsState()
    val isDarkMode by viewModel.isDarkMode.collectAsState()
    val selectedExam by viewModel.selectedExam.collectAsState()

    var isSignUpMode by remember { mutableStateOf(false) }
    var emailInput by remember { mutableStateOf(supabaseStatus.userEmail ?: "") }
    var passwordInput by remember { mutableStateOf("") }
    var nameInput by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var successMessage by remember { mutableStateOf<String?>(null) }

    Scaffold(
        containerColor = BentoBackground,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (supabaseStatus.isLoggedIn) "Account Settings" else "Sign In / Register",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = BentoOnSurface
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateToScreen(Screen.HOME) },
                        modifier = Modifier.testTag("auth_back_button")
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = BentoOnSurface)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BentoBackground)
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { Spacer(modifier = Modifier.height(8.dp)) }

            // --- APP ICON & BRANDING HEADER ---
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Surface(
                        shape = CircleShape,
                        color = BentoPrimaryContainer,
                        border = BorderStroke(2.dp, Brush.sweepGradient(listOf(BentoPrimary, Color(0xFFEC4899), Color(0xFFF59E0B), BentoPrimary))),
                        shadowElevation = 8.dp,
                        modifier = Modifier.size(88.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(12.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_preplexa_logo),
                                contentDescription = "Preplexa App Icon",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }

                    Text(
                        text = "PREPLEXA LIVE ARENA",
                        fontWeight = FontWeight.Black,
                        fontSize = 20.sp,
                        color = BentoOnSurface,
                        letterSpacing = 1.sp
                    )

                    Text(
                        text = "NEET & JEE Rank Accelerator",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = BentoOnSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                }
            }

            // --- IF ALREADY LOGGED IN: DISPLAY USER PROFILE CARD & LOGOUT ---
            if (supabaseStatus.isLoggedIn) {
                item {
                    Surface(
                        shape = RoundedCornerShape(24.dp),
                        color = BentoSurface,
                        border = BorderStroke(1.5.dp, BentoPrimary.copy(alpha = 0.5f)),
                        shadowElevation = 4.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(20.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = BentoPrimaryContainer,
                                modifier = Modifier.size(64.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text("👤", fontSize = 32.sp)
                                }
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "Signed In",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 16.sp,
                                    color = BentoPrimary
                                )
                                Text(
                                    text = supabaseStatus.userEmail ?: "user@preplexa.com",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = BentoOnSurface
                                )
                            }

                            Divider(color = BentoSurfaceVariant)

                            Button(
                                onClick = {
                                    viewModel.signOutSupabase()
                                    successMessage = "Signed out successfully"
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF4444)),
                                shape = RoundedCornerShape(16.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("sign_out_button")
                            ) {
                                Icon(Icons.Default.ExitToApp, contentDescription = null, tint = Color.White)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Log Out", fontWeight = FontWeight.Bold, color = Color.White)
                            }
                        }
                    }
                }
            } else {
                // --- AUTH FORM CARD (LOGIN / SIGN UP TOGGLE) ---
                item {
                    Surface(
                        shape = RoundedCornerShape(28.dp),
                        color = BentoSurface,
                        border = BorderStroke(1.dp, BentoSurfaceVariant),
                        shadowElevation = 6.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(20.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            // TOGGLE TAB (SIGN IN / CREATE ACCOUNT)
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(BentoSurfaceVariant.copy(alpha = 0.5f))
                                    .padding(4.dp)
                            ) {
                                Surface(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(12.dp))
                                        .clickable {
                                            isSignUpMode = false
                                            errorMessage = null
                                            successMessage = null
                                        }
                                        .testTag("tab_sign_in"),
                                    color = if (!isSignUpMode) BentoPrimary else Color.Transparent,
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    Box(
                                        contentAlignment = Alignment.Center,
                                        modifier = Modifier.padding(vertical = 10.dp)
                                    ) {
                                        Text(
                                            text = "Sign In",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.5.sp,
                                            color = if (!isSignUpMode) Color.White else BentoOnSurfaceVariant
                                        )
                                    }
                                }

                                Surface(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(12.dp))
                                        .clickable {
                                            isSignUpMode = true
                                            errorMessage = null
                                            successMessage = null
                                        }
                                        .testTag("tab_sign_up"),
                                    color = if (isSignUpMode) BentoPrimary else Color.Transparent,
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    Box(
                                        contentAlignment = Alignment.Center,
                                        modifier = Modifier.padding(vertical = 10.dp)
                                    ) {
                                        Text(
                                            text = "Create Account",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.5.sp,
                                            color = if (isSignUpMode) Color.White else BentoOnSurfaceVariant
                                        )
                                    }
                                }
                            }

                            // ERROR OR SUCCESS BANNERS
                            errorMessage?.let { err ->
                                Surface(
                                    color = Color(0xFFEF4444).copy(alpha = 0.12f),
                                    border = BorderStroke(1.dp, Color(0xFFEF4444)),
                                    shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(
                                        modifier = Modifier.padding(12.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Icon(Icons.Default.ErrorOutline, contentDescription = null, tint = Color(0xFFEF4444))
                                        Text(
                                            text = err,
                                            fontSize = 12.sp,
                                            color = Color(0xFFEF4444),
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    }
                                }
                            }

                            successMessage?.let { msg ->
                                Surface(
                                    color = Color(0xFF10B981).copy(alpha = 0.12f),
                                    border = BorderStroke(1.dp, Color(0xFF10B981)),
                                    shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(
                                        modifier = Modifier.padding(12.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Icon(Icons.Default.CheckCircleOutline, contentDescription = null, tint = Color(0xFF10B981))
                                        Text(
                                            text = msg,
                                            fontSize = 12.sp,
                                            color = Color(0xFF10B981),
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    }
                                }
                            }

                            // NAME INPUT FIELD (For Sign Up)
                            AnimatedVisibility(visible = isSignUpMode) {
                                OutlinedTextField(
                                    value = nameInput,
                                    onValueChange = { nameInput = it },
                                    label = { Text("Full Name") },
                                    leadingIcon = { Icon(Icons.Outlined.Person, contentDescription = null) },
                                    singleLine = true,
                                    shape = RoundedCornerShape(14.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .testTag("auth_name_field")
                                )
                            }

                            // EMAIL INPUT FIELD
                            OutlinedTextField(
                                value = emailInput,
                                onValueChange = { emailInput = it },
                                label = { Text("Email Address") },
                                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                                singleLine = true,
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Email,
                                    imeAction = ImeAction.Next
                                ),
                                shape = RoundedCornerShape(14.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("auth_email_field")
                            )

                            // PASSWORD INPUT FIELD
                            OutlinedTextField(
                                value = passwordInput,
                                onValueChange = { passwordInput = it },
                                label = { Text("Password") },
                                leadingIcon = { Icon(Icons.Outlined.Lock, contentDescription = null) },
                                trailingIcon = {
                                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                                        Icon(
                                            imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                            contentDescription = "Toggle Password Visibility"
                                        )
                                    }
                                },
                                singleLine = true,
                                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Password,
                                    imeAction = ImeAction.Done
                                ),
                                shape = RoundedCornerShape(14.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("auth_password_field")
                            )

                            // TARGET EXAM SELECTION (For Sign Up)
                            AnimatedVisibility(visible = isSignUpMode) {
                                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                    Text(
                                        text = "Target Exam Goal",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = BentoOnSurfaceVariant
                                    )
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        val isNeet = selectedExam == ExamType.NEET_UG
                                        FilterChip(
                                            selected = isNeet,
                                            onClick = { viewModel.selectExam(ExamType.NEET_UG) },
                                            label = { Text("🩺 NEET UG") },
                                            modifier = Modifier.weight(1f)
                                        )
                                        val isJee = selectedExam == ExamType.JEE_MAINS
                                        FilterChip(
                                            selected = isJee,
                                            onClick = { viewModel.selectExam(ExamType.JEE_MAINS) },
                                            label = { Text("🚀 JEE Main") },
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                }
                            }

                            // SUBMIT BUTTON
                            Button(
                                onClick = {
                                    if (emailInput.isBlank() || passwordInput.isBlank()) {
                                        errorMessage = "Please enter both email and password."
                                        return@Button
                                    }
                                    if (passwordInput.length < 6) {
                                        errorMessage = "Password must be at least 6 characters."
                                        return@Button
                                    }

                                    isLoading = true
                                    errorMessage = null
                                    successMessage = null

                                    if (isSignUpMode) {
                                        viewModel.signUpSupabase(emailInput.trim(), passwordInput) { success, err ->
                                            isLoading = false
                                            if (success) {
                                                if (nameInput.isNotBlank()) {
                                                    viewModel.updateStudentProfile(nameInput.trim(), "🎓")
                                                }
                                                successMessage = "Account created successfully! Welcome aboard."
                                                viewModel.navigateToScreen(Screen.HOME)
                                            } else {
                                                errorMessage = err ?: "Sign up failed"
                                            }
                                        }
                                    } else {
                                        viewModel.signInSupabase(emailInput.trim(), passwordInput) { success, err ->
                                            isLoading = false
                                            if (success) {
                                                successMessage = "Logged in successfully!"
                                                viewModel.navigateToScreen(Screen.HOME)
                                            } else {
                                                errorMessage = err ?: "Login failed. Check email or password."
                                            }
                                        }
                                    }
                                },
                                enabled = !isLoading,
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .testTag("auth_submit_button")
                            ) {
                                if (isLoading) {
                                    CircularProgressIndicator(
                                        modifier = Modifier.size(24.dp),
                                        color = Color.White,
                                        strokeWidth = 2.dp
                                    )
                                } else {
                                    Icon(
                                        imageVector = if (isSignUpMode) Icons.Default.PersonAdd else Icons.Default.Login,
                                        contentDescription = null
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = if (isSignUpMode) "Create Account" else "Log In",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }

                            // GOOGLE LOGIN OPTION
                            OutlinedButton(
                                onClick = {
                                    val promptEmail = emailInput.ifBlank { "aspirant${(1000..9999).random()}@gmail.com" }
                                    viewModel.signInWithGoogle(promptEmail, nameInput.ifBlank { "Aspirant User" }) { success, err ->
                                        if (success) {
                                            successMessage = "Google Sign-In successful!"
                                            viewModel.navigateToScreen(Screen.HOME)
                                        } else {
                                            errorMessage = err
                                        }
                                    }
                                },
                                shape = RoundedCornerShape(16.dp),
                                border = BorderStroke(1.dp, BentoSurfaceVariant),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp)
                                    .testTag("auth_google_button")
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_google_logo),
                                        contentDescription = "Google Logo",
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(
                                        text = "Continue with Google",
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 14.sp,
                                        color = BentoOnSurface
                                    )
                                }
                            }
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}
