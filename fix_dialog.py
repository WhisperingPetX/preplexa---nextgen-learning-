import os

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    lines = f.readlines()

start_idx = -1
for i, line in enumerate(lines):
    if line.startswith("// --- DAILY BADGE DETAIL DIALOG ---"):
        start_idx = i
        break

if start_idx != -1:
    lines = lines[:start_idx]
    with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
        f.writelines(lines)
    print("SUCCESS")
else:
    print("FAILED")
