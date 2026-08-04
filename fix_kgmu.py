import re

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    content = f.read()

kgmu_old = 'TopCollege("Sanjay Gandhi PGIMS", 7, "₹11 LPA", "sgpgims.org.in", Color(0xFFFCE4EC))'
kgmu_new = 'TopCollege("KGMU Lucknow", 6, "₹12 LPA", "kgmu.org", Color(0xFFFCE4EC), "https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/King_George%27s_Medical_University%2C_Lucknow.jpg/800px-King_George%27s_Medical_University%2C_Lucknow.jpg", "King George\'s Medical University (KGMU) is one of the most prestigious medical institutes in Northern India, located in Lucknow. It is known for its majestic architecture and excellent clinical exposure.")'

if kgmu_old in content:
    content = content.replace(kgmu_old, kgmu_new)

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
    f.write(content)
