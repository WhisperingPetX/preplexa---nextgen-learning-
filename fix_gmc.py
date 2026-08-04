import re

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    content = f.read()

gmc_old = 'TopCollege("PGIMER Chandigarh", 2, "₹12 LPA (Stipend)", "pgimer.edu.in", Color(0xFFF3E5F5), "https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/Pgimer_chandigarh.jpg/800px-Pgimer_chandigarh.jpg", "A premier medical and research institution in Chandigarh.")'
gmc_new = 'TopCollege("Grant Medical College", 2, "₹10 LPA", "gmcjjh.org", Color(0xFFF3E5F5), "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Grant_Medical_College.jpg/800px-Grant_Medical_College.jpg", "Grant Government Medical College, Mumbai, affiliated with Sir J. J. Group of Hospitals, is one of the premier medical institutions in India and among the oldest medical colleges in Asia.")'

if gmc_old in content:
    content = content.replace(gmc_old, gmc_new)

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
    f.write(content)
