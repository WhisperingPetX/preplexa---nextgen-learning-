import re

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    content = f.read()

mmc_old = 'TopCollege("KMC Manipal", 9, "₹15 LPA", "manipal.edu", Color(0xFFF1F8E9))'
mmc_new = 'TopCollege("Madras Medical College", 9, "₹12 LPA", "mmc.ac.in", Color(0xFFF1F8E9), "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Madras_Medical_College_Chennai_1.jpg/800px-Madras_Medical_College_Chennai_1.jpg", "Madras Medical College (MMC) is a prestigious medical college located in Chennai, Tamil Nadu. Established in 1835, it is one of the oldest medical colleges in India.")'

if mmc_old in content:
    content = content.replace(mmc_old, mmc_new)

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
    f.write(content)
