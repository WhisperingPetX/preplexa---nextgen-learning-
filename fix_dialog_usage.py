import os

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    text = f.read()

text = text.replace('''    if (selectedMonthlyBadgeDetail != null) {
        DailyBadgeDetailDialog(
            badge = selectedMonthlyBadgeDetail!!,
            onDismiss = { selectedMonthlyBadgeDetail = null }
        )
    }''', "")
text = text.replace('''    var selectedMonthlyBadgeDetail by remember { mutableStateOf<com.example.model.MonthlyDailyBadge?>(null) }''', "")
text = text.replace('''onSelectBadge = { selectedMonthlyBadgeDetail = it }''', "onSelectBadge = { }")

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
    f.write(text)
print("SUCCESS")
