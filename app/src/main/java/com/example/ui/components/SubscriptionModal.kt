package com.example.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.ui.theme.*
import com.example.ui.viewmodel.MainViewModel

// --- 1. FULL SUBSCRIPTION PLAN MODAL (Accessible from Profile & Banners) ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionPlanModal(viewModel: MainViewModel, onDismiss: () -> Unit) {
    var selectedPlan by remember { mutableStateOf("6months") }

    val isSubscribed by viewModel.isSubscribed.collectAsState()
    val currentPlan by viewModel.subscriptionPlan.collectAsState()
    val trialDaysLeft by viewModel.trialDaysRemaining.collectAsState()

    val mPrice by viewModel.monthlyPrice.collectAsState()
    val sPrice by viewModel.sixMonthPrice.collectAsState()
    val yPrice by viewModel.yearlyPrice.collectAsState()

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("👑", fontSize = 24.sp)
                Column {
                    Text(
                        text = "Preplexa Membership Plans",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 17.sp,
                        color = BentoOnSurface
                    )
                    Text(
                        text = if (isSubscribed) "Current Status: Active PRO Member" else "🎁 30-Day Free Trial Available",
                        fontSize = 11.sp,
                        color = if (isSubscribed) Color(0xFF10B981) else BentoPrimary
                    )
                }
            }
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Select a plan to unlock full unlimited access to Mock Tests, PYQs, AI Tutor & Analytics:",
                    fontSize = 11.5.sp,
                    color = BentoOnSurfaceVariant
                )

                // 0. Free 30-Day Trial Option
                SubscriptionOptionCard(
                    title = "30-Day Free Trial Pass",
                    price = "FREE",
                    duration = " / 30 Days",
                    subtitle = if (trialDaysLeft > 0) "Standard Trial ($trialDaysLeft Days Left)" else "Standard Free Trial (Expired)",
                    isSelected = selectedPlan == "30_day_trial",
                    badgeText = if (trialDaysLeft > 0) "TRIAL ACTIVE" else "EXPIRED",
                    badgeColor = if (trialDaysLeft > 0) Color(0xFF10B981) else Color(0xFFEF4444),
                    onClick = { selectedPlan = "30_day_trial" }
                )

                // 1. Monthly Plan
                SubscriptionOptionCard(
                    title = "Monthly PRO Pass",
                    price = "₹$mPrice",
                    duration = " / month",
                    subtitle = "Standard monthly billing for all exams",
                    isSelected = selectedPlan == "monthly",
                    badgeText = null,
                    badgeColor = BentoPrimary,
                    onClick = { selectedPlan = "monthly" }
                )

                // 2. 6 Months Plan
                SubscriptionOptionCard(
                    title = "6 Months PRO Pass",
                    price = "₹$sPrice",
                    duration = " / 6 months",
                    subtitle = "Save ~16% compared to monthly",
                    isSelected = selectedPlan == "6months",
                    badgeText = "MOST POPULAR",
                    badgeColor = Color(0xFFF59E0B),
                    onClick = { selectedPlan = "6months" }
                )

                // 3. Yearly Plan
                SubscriptionOptionCard(
                    title = "1 Year Unlimited Pass",
                    price = "₹$yPrice",
                    duration = " / year",
                    subtitle = "Full 365 days NTA Exam Prep Pass",
                    isSelected = selectedPlan == "yearly",
                    badgeText = "BEST VALUE",
                    badgeColor = Color(0xFF8B5CF6),
                    onClick = { selectedPlan = "yearly" }
                )

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = BentoPrimaryContainer.copy(alpha = 0.5f),
                    border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.3f))
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        PlanPerkItem("✨ Unlimited AI Tutor Doubts Solver")
                        PlanPerkItem("📜 10 Years NTA NEET & JEE Official PYQs")
                        PlanPerkItem("📊 Real-time Rank & Accuracy Analytics")
                        PlanPerkItem("⚡ 1,000+ Topic Wise Chapter Mock Tests")
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (selectedPlan == "30_day_trial") {
                        if (trialDaysLeft <= 0) {
                            // Trial expired, prompt paid plan
                            viewModel.triggerPaywallModal()
                        } else {
                            onDismiss()
                        }
                    } else {
                        viewModel.activateSubscription(selectedPlan)
                        onDismiss()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("confirm_subscribe_button")
            ) {
                Text(
                    text = if (selectedPlan == "30_day_trial" && trialDaysLeft > 0) "Continue Free Trial" else "Activate Membership Plan",
                    fontWeight = FontWeight.Bold
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Close", color = BentoOnSurfaceVariant)
            }
        }
    )
}

// --- 2. TRIAL EXPIRED PAYWALL MODAL (Popup when 30 days are over) ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrialExpiredPaywallModal(viewModel: MainViewModel, onDismiss: () -> Unit) {
    var selectedPlan by remember { mutableStateOf("6months") }

    val mPrice by viewModel.monthlyPrice.collectAsState()
    val sPrice by viewModel.sixMonthPrice.collectAsState()
    val yPrice by viewModel.yearlyPrice.collectAsState()

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = BentoBackground,
            border = BorderStroke(2.dp, Color(0xFFEF4444)),
            shadowElevation = 12.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Header Lock Icon
                Surface(
                    shape = CircleShape,
                    color = Color(0xFFFEE2E2),
                    modifier = Modifier.size(56.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Services Locked",
                            tint = Color(0xFFDC2626),
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "🔒 30-Day Free Trial Expired!",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp,
                        color = BentoOnSurface,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Aapka 30 dino ka free trial samapt ho gaya hai. Aage ke sabhi Mock Tests, PYQs, AI Doubts & Analytics services ko access karne ke liye kripya membership plan chunein:",
                        fontSize = 11.5.sp,
                        color = BentoOnSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                }

                // Subscription Plan Choices
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    SubscriptionOptionCard(
                        title = "Monthly Plan",
                        price = "₹$mPrice",
                        duration = " / month",
                        subtitle = "Standard monthly pass",
                        isSelected = selectedPlan == "monthly",
                        badgeText = null,
                        badgeColor = BentoPrimary,
                        onClick = { selectedPlan = "monthly" }
                    )

                    SubscriptionOptionCard(
                        title = "6 Months Plan",
                        price = "₹$sPrice",
                        duration = " / 6 months",
                        subtitle = "Best for Exam Season (~16% OFF)",
                        isSelected = selectedPlan == "6months",
                        badgeText = "RECOMMENDED",
                        badgeColor = Color(0xFFF59E0B),
                        onClick = { selectedPlan = "6months" }
                    )

                    SubscriptionOptionCard(
                        title = "1 Year Pass",
                        price = "₹$yPrice",
                        duration = " / year",
                        subtitle = "Unlimited 365 Days Access",
                        isSelected = selectedPlan == "yearly",
                        badgeText = "MAX SAVINGS",
                        badgeColor = Color(0xFF8B5CF6),
                        onClick = { selectedPlan = "yearly" }
                    )
                }

                Button(
                    onClick = {
                        viewModel.activateSubscription(selectedPlan)
                        onDismiss()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("paywall_subscribe_now_button")
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text("✨ Subscribe Now & Unlock All Services", fontWeight = FontWeight.Bold, fontSize = 13.5.sp)
                    }
                }

                TextButton(onClick = onDismiss) {
                    Text("Close for now", fontSize = 11.sp, color = BentoOnSurfaceVariant)
                }
            }
        }
    }
}

@Composable
fun SubscriptionOptionCard(
    title: String,
    price: String,
    duration: String,
    subtitle: String,
    isSelected: Boolean,
    badgeText: String?,
    badgeColor: Color,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        color = if (isSelected) BentoPrimaryContainer else BentoSurfaceVariant.copy(alpha = 0.3f),
        border = BorderStroke(
            width = if (isSelected) 2.dp else 1.dp,
            color = if (isSelected) BentoPrimary else BentoSurfaceVariant
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.5.sp,
                        color = BentoOnSurface,
                        maxLines = 1,
                        softWrap = false,
                        overflow = TextOverflow.Ellipsis
                    )
                    if (badgeText != null) {
                        Surface(
                            color = badgeColor,
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Text(
                                text = badgeText,
                                fontSize = 8.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                maxLines = 1,
                                softWrap = false,
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
                Text(
                    text = subtitle,
                    fontSize = 10.sp,
                    color = BentoOnSurfaceVariant
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = price,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 15.sp,
                        color = BentoPrimary
                    )
                    Text(
                        text = duration,
                        fontSize = 9.5.sp,
                        color = BentoOnSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
fun PlanPerkItem(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Icon(
            imageVector = Icons.Outlined.CheckCircle,
            contentDescription = null,
            tint = BentoPrimary,
            modifier = Modifier.size(14.dp)
        )
        Text(
            text = text,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            color = BentoOnSurface
        )
    }
}
