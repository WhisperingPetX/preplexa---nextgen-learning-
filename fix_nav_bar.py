import os

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    text = f.read()

# Restore the old string-based iconEmoji
old_nav_bar = '''fun ModernBottomNavigationBar(
    currentScreen: Screen,
    onNavigate: (Screen) -> Unit
) {
    Surface(
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        shadowElevation = 8.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(horizontal = 4.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavBottomItem(
                title = "Home",
                iconEmoji = "⚡",
                isSelected = currentScreen == Screen.HOME,
                onClick = { onNavigate(Screen.HOME) }
            )
            NavBottomItem(
                title = "Syllabus",
                iconEmoji = "📚",
                isSelected = currentScreen == Screen.TOPIC_LIST,
                onClick = { onNavigate(Screen.TOPIC_LIST) }
            )
            NavBottomItem(
                title = "Analytics",
                iconEmoji = "📊",
                isSelected = currentScreen == Screen.ANALYTICS,
                onClick = { onNavigate(Screen.ANALYTICS) }
            )
            NavBottomItem(
                title = "PYQs",
                iconEmoji = "📜",
                isSelected = currentScreen == Screen.PYQ_PAPERS,
                onClick = { onNavigate(Screen.PYQ_PAPERS) }
            )
            NavBottomItem(
                title = "Profile",
                iconEmoji = "👤",
                isSelected = currentScreen == Screen.PROFILE,
                onClick = { onNavigate(Screen.PROFILE) }
            )
        }
    }
}

@Composable
private fun NavBottomItem(
    title: String,
    iconEmoji: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val activeColor = BentoPrimary
    val inactiveColor = BentoOnSurfaceVariant

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .testTag("nav_bottom_${title.lowercase()}")
    ) {
        Surface(
            shape = CircleShape,
            color = if (isSelected) activeColor.copy(alpha = 0.16f) else Color.Transparent,
            modifier = Modifier.size(32.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = iconEmoji,
                    fontSize = 17.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = title,
            fontSize = 10.5.sp,
            fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Bold,
            color = if (isSelected) activeColor else inactiveColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}'''

# Find the start of ModernBottomNavigationBar and replace it to the end
start_idx = text.find("fun ModernBottomNavigationBar")
if start_idx != -1:
    text = text[:start_idx] + old_nav_bar + "\n"

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
    f.write(text)
print("SUCCESS")
