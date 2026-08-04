import os

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    text = f.read()

text = text.replace("onClick = { onSelectBadge(badge) },\n", "")

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
    f.write(text)
print("SUCCESS")
