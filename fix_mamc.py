import re

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    content = f.read()

mamc_old = 'TopCollege("Amrita Vishwa Vidyapeetham", 6, "₹14 LPA", "amrita.edu", Color(0xFFE0F7FA))'
mamc_new = 'TopCollege("MAMC New Delhi", 6, "₹12 LPA", "mamc.ac.in", Color(0xFFE0F7FA), "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/MAMC_Delhi_Main_Building.jpg/800px-MAMC_Delhi_Main_Building.jpg", "Maulana Azad Medical College (MAMC) is a prestigious government medical college in New Delhi. It is affiliated with the University of Delhi and offers excellent clinical exposure, making it highly sought-after by NEET aspirants.")'

if mamc_old in content:
    content = content.replace(mamc_old, mamc_new)

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
    f.write(content)
