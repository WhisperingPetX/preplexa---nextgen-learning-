import re

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    content = f.read()

bjmc_old = 'TopCollege("NIMHANS Bangalore", 4, "₹9 LPA", "nimhans.ac.in", Color(0xFFFFF3E0))'
bjmc_new = 'TopCollege("BJ Medical College", 4, "₹10 LPA", "bjmcabd.edu.in", Color(0xFFFFF3E0), "https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/B_J_Medical_College.JPG/800px-B_J_Medical_College.JPG", "B.J. Medical College (BJMC) in Ahmedabad is one of the largest medical institutes in India, affiliated with Gujarat University and the Civil Hospital, Ahmedabad, providing immense clinical exposure.")'

if bjmc_old in content:
    content = content.replace(bjmc_old, bjmc_new)

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
    f.write(content)
