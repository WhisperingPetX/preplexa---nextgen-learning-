import os

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    text = f.read()

# I will just replace `onSelectBadge = { }` to empty where it is called if possible, 
# but it's easier to just remove it from `Monthly30DayBadgeSection`

text = text.replace("onSelectBadge: (com.example.model.MonthlyDailyBadge) -> Unit", "")
text = text.replace("onSelectBadge = { }", "")

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
    f.write(text)
print("SUCCESS")
