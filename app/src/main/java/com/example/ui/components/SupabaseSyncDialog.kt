package com.example.ui.components

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Cloud
import androidx.compose.material.icons.outlined.CloudDone
import androidx.compose.material.icons.outlined.CloudSync
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.R
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.data.supabase.SupabaseConfig
import com.example.data.supabase.SupabaseSyncState
import com.example.ui.theme.*
import com.example.ui.viewmodel.MainViewModel

@Composable
fun SupabaseSyncDialog(
    viewModel: MainViewModel,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current
    val supabaseStatus by viewModel.supabaseStatus.collectAsState()
    val attempts by viewModel.allAttempts.collectAsState()
    val bookmarks by viewModel.bookmarkedQuestions.collectAsState()

    var selectedTab by remember { mutableStateOf(0) } // 0: Sync, 1: Auth, 2: Config, 3: SQL DDL

    // Auth Form State
    var authEmail by remember { mutableStateOf(supabaseStatus.userEmail ?: "") }
    var authPassword by remember { mutableStateOf("") }
    var isSignUpMode by remember { mutableStateOf(false) }
    var authLoading by remember { mutableStateOf(false) }

    // Config Form State
    var customUrl by remember { mutableStateOf(SupabaseConfig.getUrl(context)) }
    var customAnonKey by remember { mutableStateOf(SupabaseConfig.getAnonKey(context)) }

    val sqlSchema = """
-- Run this in Supabase SQL Editor:
CREATE TABLE IF NOT EXISTS public.test_attempts (
    id SERIAL PRIMARY KEY,
    test_id TEXT NOT NULL,
    topic_id TEXT NOT NULL,
    exam_type TEXT NOT NULL,
    score_percent INT NOT NULL,
    correct_count INT NOT NULL,
    incorrect_count INT NOT NULL,
    unattempted_count INT NOT NULL,
    total_questions INT NOT NULL,
    time_spent_seconds INT NOT NULL,
    timestamp BIGINT NOT NULL,
    user_id UUID DEFAULT auth.uid()
);

CREATE TABLE IF NOT EXISTS public.bookmarks (
    id SERIAL PRIMARY KEY,
    question_id TEXT NOT NULL,
    topic_id TEXT NOT NULL,
    question_text TEXT NOT NULL,
    option_a TEXT,
    option_b TEXT,
    option_c TEXT,
    option_d TEXT,
    correct_option_index INT NOT NULL,
    explanation TEXT,
    user_id UUID DEFAULT auth.uid()
);

CREATE TABLE IF NOT EXISTS public.custom_questions (
    id TEXT PRIMARY KEY,
    category TEXT NOT NULL,
    subject TEXT NOT NULL,
    topic_or_year TEXT NOT NULL,
    question_text TEXT NOT NULL,
    option_a TEXT NOT NULL,
    option_b TEXT NOT NULL,
    option_c TEXT NOT NULL,
    option_d TEXT NOT NULL,
    correct_option_index INT NOT NULL,
    explanation TEXT,
    timestamp BIGINT NOT NULL
);
    """.trimIndent()

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .fillMaxHeight(0.85f),
            shape = RoundedCornerShape(28.dp),
            color = BentoSurface,
            border = BorderStroke(1.dp, BentoSurfaceVariant)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Header with Cloud Status
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Surface(
                            color = Color(0xFF0B0F19),
                            shape = CircleShape,
                            border = BorderStroke(1.dp, BentoPrimaryContainer),
                            modifier = Modifier.size(42.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(4.dp)) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_preplexa_logo),
                                    contentDescription = "Supabase",
                                    tint = Color.Unspecified,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        Column {
                            Text(
                                text = "Supabase Backend Cloud",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 18.sp,
                                color = BentoOnSurface
                            )
                            Text(
                                text = if (supabaseStatus.userEmail != null) "User: ${supabaseStatus.userEmail}" else "PostgreSQL Database Sync",
                                fontSize = 11.sp,
                                color = BentoOnSurfaceVariant,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close", tint = BentoOnSurfaceVariant)
                    }
                }

                // Cloud Status Badge
                Surface(
                    color = when (supabaseStatus.syncState) {
                        SupabaseSyncState.SYNCING -> BentoBlueBg
                        SupabaseSyncState.SUCCESS -> BentoGreenBg
                        SupabaseSyncState.ERROR -> BentoPeachBg
                        else -> BentoSurfaceVariant
                    },
                    border = BorderStroke(1.dp, when (supabaseStatus.syncState) {
                        SupabaseSyncState.SYNCING -> BentoBlueBorder
                        SupabaseSyncState.SUCCESS -> BentoGreenBorder
                        SupabaseSyncState.ERROR -> BentoPeachBorder
                        else -> BentoSurfaceVariant
                    }),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        if (supabaseStatus.syncState == SupabaseSyncState.SYNCING) {
                            CircularProgressIndicator(modifier = Modifier.size(16.dp), strokeWidth = 2.dp, color = BentoPrimary)
                        } else {
                            Icon(
                                imageVector = if (supabaseStatus.isConnected) Icons.Outlined.CloudDone else Icons.Outlined.Cloud,
                                contentDescription = null,
                                tint = if (supabaseStatus.isConnected) BentoGreenText else BentoOnSurfaceVariant,
                                modifier = Modifier.size(18.dp)
                            )
                        }

                        Text(
                            text = when (supabaseStatus.syncState) {
                                SupabaseSyncState.SYNCING -> "Syncing data with Supabase..."
                                SupabaseSyncState.SUCCESS -> "Cloud Synchronized Successfully"
                                SupabaseSyncState.ERROR -> "Sync Error: ${supabaseStatus.errorMessage ?: "Check URL/Key"}"
                                else -> if (supabaseStatus.isConnected) "Connected to Supabase PostgreSQL" else "Offline Local Cache Mode"
                            },
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = when (supabaseStatus.syncState) {
                                SupabaseSyncState.SYNCING -> BentoPrimary
                                SupabaseSyncState.SUCCESS -> BentoGreenText
                                SupabaseSyncState.ERROR -> BentoPeachText
                                else -> BentoOnSurface
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                // Tab Row Selector
                ScrollableTabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = BentoSurfaceVariant,
                    contentColor = BentoPrimary,
                    edgePadding = 0.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                ) {
                    Tab(
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 },
                        text = { Text("Cloud Sync", fontWeight = FontWeight.Bold, fontSize = 12.sp) }
                    )
                    Tab(
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 },
                        text = { Text("Supabase Auth", fontWeight = FontWeight.Bold, fontSize = 12.sp) }
                    )
                    Tab(
                        selected = selectedTab == 2,
                        onClick = { selectedTab = 2 },
                        text = { Text("Config", fontWeight = FontWeight.Bold, fontSize = 12.sp) }
                    )
                    Tab(
                        selected = selectedTab == 3,
                        onClick = { selectedTab = 3 },
                        text = { Text("SQL DDL", fontWeight = FontWeight.Bold, fontSize = 12.sp) }
                    )
                }

                // Tab Contents
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    when (selectedTab) {
                        0 -> {
                            // Sync Tab
                            Column(
                                verticalArrangement = Arrangement.spacedBy(14.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "PostgreSQL Local-to-Cloud Sync",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 15.sp,
                                    color = BentoOnSurface
                                )

                                Surface(
                                    color = BentoBackground,
                                    shape = RoundedCornerShape(18.dp),
                                    border = BorderStroke(1.dp, BentoSurfaceVariant),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(
                                        modifier = Modifier.padding(14.dp),
                                        verticalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text("Local Test Attempts:", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface)
                                            Text("${attempts.size} records", fontSize = 13.sp, fontWeight = FontWeight.ExtraBold, color = BentoPurpleBadge)
                                        }
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text("Bookmarked Questions:", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = BentoOnSurface)
                                            Text("${bookmarks.size} items", fontSize = 13.sp, fontWeight = FontWeight.ExtraBold, color = BentoPeachBadge)
                                        }
                                        if (supabaseStatus.lastSyncedTime != null) {
                                            Text(
                                                text = "Last Synced: ${java.text.SimpleDateFormat("hh:mm:ss a, dd MMM", java.util.Locale.getDefault()).format(java.util.Date(supabaseStatus.lastSyncedTime!!))}",
                                                fontSize = 11.sp,
                                                color = BentoOnSurfaceVariant,
                                                fontWeight = FontWeight.Medium
                                            )
                                        }
                                    }
                                }

                                Button(
                                    onClick = { viewModel.syncWithSupabase() },
                                    enabled = supabaseStatus.syncState != SupabaseSyncState.SYNCING,
                                    shape = RoundedCornerShape(16.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(vertical = 4.dp)
                                    ) {
                                        Icon(Icons.Outlined.CloudSync, contentDescription = null)
                                        Text("Push & Sync Data to Supabase", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                                    }
                                }
                            }
                        }

                        1 -> {
                            // Auth Tab
                            Column(
                                verticalArrangement = Arrangement.spacedBy(12.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                if (supabaseStatus.userEmail != null) {
                                    Surface(
                                        color = BentoGreenBg,
                                        border = BorderStroke(1.dp, BentoGreenBorder),
                                        shape = RoundedCornerShape(18.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(16.dp),
                                            verticalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            Text("Authenticated Supabase Account", fontWeight = FontWeight.ExtraBold, fontSize = 14.sp, color = BentoGreenText)
                                            Text("Email: ${supabaseStatus.userEmail}", fontSize = 13.sp, color = BentoOnSurface)
                                            Text("User ID: ${supabaseStatus.userId ?: "N/A"}", fontSize = 11.sp, color = BentoOnSurfaceVariant)

                                            Button(
                                                onClick = { viewModel.signOutSupabase() },
                                                colors = ButtonDefaults.buttonColors(containerColor = BentoPeachBadge),
                                                shape = RoundedCornerShape(12.dp),
                                                modifier = Modifier.padding(top = 8.dp)
                                            ) {
                                                Text("Sign Out", fontWeight = FontWeight.Bold)
                                            }
                                        }
                                    }
                                } else {
                                    Text(
                                        text = if (isSignUpMode) "Create Supabase Student Account" else "Sign In to Supabase Cloud",
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 15.sp,
                                        color = BentoOnSurface
                                    )

                                    OutlinedTextField(
                                        value = authEmail,
                                        onValueChange = { authEmail = it },
                                        label = { Text("Student Email") },
                                        leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                                        shape = RoundedCornerShape(14.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    )

                                    OutlinedTextField(
                                        value = authPassword,
                                        onValueChange = { authPassword = it },
                                        label = { Text("Password") },
                                        leadingIcon = { Icon(Icons.Outlined.Lock, contentDescription = null) },
                                        visualTransformation = PasswordVisualTransformation(),
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                                        shape = RoundedCornerShape(14.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    )

                                    Button(
                                        onClick = {
                                            if (authEmail.isBlank() || authPassword.isBlank()) {
                                                Toast.makeText(context, "Please enter email and password", Toast.LENGTH_SHORT).show()
                                                return@Button
                                            }
                                            authLoading = true
                                            if (isSignUpMode) {
                                                viewModel.signUpSupabase(authEmail, authPassword) { success, err ->
                                                    authLoading = false
                                                    if (success) {
                                                        Toast.makeText(context, "Account created successfully!", Toast.LENGTH_SHORT).show()
                                                    } else {
                                                        Toast.makeText(context, err ?: "Sign up failed", Toast.LENGTH_LONG).show()
                                                    }
                                                }
                                            } else {
                                                viewModel.signInSupabase(authEmail, authPassword) { success, err ->
                                                    authLoading = false
                                                    if (success) {
                                                        Toast.makeText(context, "Signed in successfully!", Toast.LENGTH_SHORT).show()
                                                    } else {
                                                        Toast.makeText(context, err ?: "Sign in failed", Toast.LENGTH_LONG).show()
                                                    }
                                                }
                                            }
                                        },
                                        enabled = !authLoading,
                                        shape = RoundedCornerShape(16.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        if (authLoading) {
                                            CircularProgressIndicator(modifier = Modifier.size(18.dp), color = Color.White, strokeWidth = 2.dp)
                                        } else {
                                            Text(if (isSignUpMode) "Sign Up Account" else "Sign In", fontWeight = FontWeight.Bold)
                                        }
                                    }

                                    TextButton(
                                        onClick = { isSignUpMode = !isSignUpMode },
                                        modifier = Modifier.align(Alignment.CenterHorizontally)
                                    ) {
                                        Text(
                                            text = if (isSignUpMode) "Already have an account? Sign In" else "Don't have an account? Sign Up",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = BentoPrimary
                                        )
                                    }
                                }
                            }
                        }

                        2 -> {
                            // Config Tab
                            Column(
                                verticalArrangement = Arrangement.spacedBy(12.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Custom Supabase Project Config",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 15.sp,
                                    color = BentoOnSurface
                                )

                                OutlinedTextField(
                                    value = customUrl,
                                    onValueChange = { customUrl = it },
                                    label = { Text("Supabase URL (https://xyz.supabase.co)") },
                                    shape = RoundedCornerShape(14.dp),
                                    modifier = Modifier.fillMaxWidth()
                                )

                                OutlinedTextField(
                                    value = customAnonKey,
                                    onValueChange = { customAnonKey = it },
                                    label = { Text("Supabase Anon API Key") },
                                    shape = RoundedCornerShape(14.dp),
                                    modifier = Modifier.fillMaxWidth()
                                )

                                Button(
                                    onClick = {
                                        viewModel.updateSupabaseCredentials(customUrl, customAnonKey)
                                        Toast.makeText(context, "Supabase Configuration Saved!", Toast.LENGTH_SHORT).show()
                                    },
                                    shape = RoundedCornerShape(16.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text("Save Credentials & Test Sync", fontWeight = FontWeight.Bold)
                                }
                            }
                        }

                        3 -> {
                            // SQL DDL Tab
                            Column(
                                verticalArrangement = Arrangement.spacedBy(10.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Supabase PostgreSQL DDL",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 15.sp,
                                    color = BentoOnSurface
                                )

                                Surface(
                                    color = Color(0xFF1E293B),
                                    shape = RoundedCornerShape(14.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f)
                                ) {
                                    Box(modifier = Modifier.padding(12.dp)) {
                                        Text(
                                            text = sqlSchema,
                                            fontFamily = FontFamily.Monospace,
                                            fontSize = 11.sp,
                                            color = Color(0xFF38BDF8)
                                        )
                                    }
                                }

                                Button(
                                    onClick = {
                                        clipboardManager.setText(AnnotatedString(sqlSchema))
                                        Toast.makeText(context, "SQL Schema Copied to Clipboard!", Toast.LENGTH_SHORT).show()
                                    },
                                    shape = RoundedCornerShape(14.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Icon(Icons.Default.ContentCopy, contentDescription = null, modifier = Modifier.size(16.dp))
                                    Spacer(Modifier.width(6.dp))
                                    Text("Copy SQL to Clipboard", fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
