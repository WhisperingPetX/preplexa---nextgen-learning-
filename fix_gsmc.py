import re

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    content = f.read()

gsmc_old = 'TopCollege("Sree Chitra Tirunal", 10, "₹10 LPA", "sctimst.ac.in", Color(0xFFEFEBE9))'
gsmc_new = 'TopCollege("Seth GS Medical College", 10, "₹12 LPA", "kem.edu", Color(0xFFEFEBE9), "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Seth_G.S._Medical_College.jpg/800px-Seth_G.S._Medical_College.jpg", "Seth Gordhandas Sunderdas Medical College (GSMC) is a premier medical institution located in Mumbai. Affiliated with KEM Hospital, it offers exceptional clinical training and is a top choice for medical students in Maharashtra and across India.")'

if gsmc_old in content:
    content = content.replace(gsmc_old, gsmc_new)

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
    f.write(content)
