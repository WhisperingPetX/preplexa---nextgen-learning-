import os

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    text = f.read()

start_idx = text.find("fun Monthly30DayBadgeSection(")
end_idx = text.find("// --- STUDENT ANALYTICS CARD WITH PIE CHART & HISTOGRAM ---")

if start_idx != -1 and end_idx != -1:
    old_section = text[start_idx:end_idx]
    
    new_section = """fun Monthly30DayBadgeSection(
    monthlyBadges: List<com.example.model.MonthlyDailyBadge>,
    todayBadge: com.example.model.MonthlyDailyBadge,
    isTodayBadgeClaimed: Boolean,
    onClaimTodayBadge: () -> Unit,
) {
    val currentMonthName = monthlyBadges.firstOrNull()?.monthName ?: "Current Month"
    val unlockedCount = monthlyBadges.count { it.isUnlocked }

    Surface(
        shape = RoundedCornerShape(16.dp),
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header & Claim Button in one line
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "📅 $currentMonthName Badges",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 14.sp,
                        color = BentoOnSurface
                    )
                    Text(
                        text = "$unlockedCount / 30 Days Unlocked",
                        fontSize = 11.sp,
                        color = BentoOnSurfaceVariant
                    )
                }

                if (!isTodayBadgeClaimed) {
                    val infiniteTransition = rememberInfiniteTransition(label = "today_badge_pulse")
                    val pulseScale by infiniteTransition.animateFloat(
                        initialValue = 0.95f,
                        targetValue = 1.05f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(800, easing = FastOutSlowInEasing),
                            repeatMode = RepeatMode.Reverse
                        ),
                        label = "pulse"
                    )

                    Button(
                        onClick = onClaimTodayBadge,
                        colors = ButtonDefaults.buttonColors(containerColor = BentoPrimary),
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                        modifier = Modifier.graphicsLayer {
                            scaleX = pulseScale
                            scaleY = pulseScale
                        }
                    ) {
                        Text(
                            text = "Claim Day ${todayBadge.dayOfMonth} ✨",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                    }
                } else {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = BentoPrimaryContainer,
                        border = BorderStroke(1.dp, BentoPrimary.copy(alpha = 0.3f))
                    ) {
                        Text(
                            text = "$unlockedCount Earned 🔥",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = BentoPrimary,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            // Badges Row
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 0.dp)
            ) {
                items(monthlyBadges) { badge ->
                    val badgeColor = parseHexColor(badge.badgeColorHex)

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (badge.isUnlocked) badgeColor.copy(alpha = 0.12f) else BentoSurfaceVariant.copy(alpha = 0.25f),
                        border = BorderStroke(
                            if (badge.isToday) 2.dp else 1.dp,
                            if (badge.isToday) badgeColor else if (badge.isUnlocked) badgeColor.copy(alpha = 0.6f) else BentoSurfaceVariant
                        ),
                        modifier = Modifier.width(76.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = badge.emojiIcon,
                                    fontSize = 24.sp,
                                    modifier = Modifier.then(
                                        if (!badge.isUnlocked) Modifier.graphicsLayer { alpha = 0.35f } else Modifier
                                    )
                                )

                                if (!badge.isUnlocked) {
                                    Surface(
                                        color = Color.Black.copy(alpha = 0.65f),
                                        shape = CircleShape,
                                        modifier = Modifier.size(20.dp)
                                    ) {
                                        Box(contentAlignment = Alignment.Center) {
                                            Icon(
                                                Icons.Default.Lock,
                                                contentDescription = "Locked",
                                                tint = Color.White,
                                                modifier = Modifier.size(11.dp)
                                            )
                                        }
                                    }
                                }
                            }

                            Text(
                                text = "Day ${badge.dayOfMonth}",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 10.5.sp,
                                color = if (badge.isUnlocked) BentoOnSurface else BentoOnSurfaceVariant
                            )

                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = if (badge.isToday) Color(0xFFFF6D00) else if (badge.isUnlocked) badgeColor else BentoSurfaceVariant
                            ) {
                                Text(
                                    text = if (badge.isToday) "TODAY 🔥" else if (badge.isUnlocked) "UNLOCKED" else "LOCKED 🔒",
                                    fontSize = 7.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
"""
    
    text = text.replace(old_section, new_section)
    with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
        f.write(text)
    print("SUCCESS")
else:
    print("FAILED TO FIND SECTION")

