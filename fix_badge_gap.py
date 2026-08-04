import os

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    text = f.read()

text = text.replace("Arrangement.spacedBy(10.dp)", "Arrangement.spacedBy(8.dp)")
text = text.replace("Modifier.width(96.dp)", "Modifier.width(86.dp)")

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
    f.write(text)
print("SUCCESS")
