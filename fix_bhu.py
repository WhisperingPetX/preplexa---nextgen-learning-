import re

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    content = f.read()

bhu_old = 'TopCollege("BHU Varanasi", 8, "₹12 LPA", "bhu.ac.in", Color(0xFFFFF8E1))'
bhu_new = 'TopCollege("IMS BHU Varanasi", 8, "₹12 LPA", "bhu.ac.in", Color(0xFFFFF8E1), "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Banaras_Hindu_University_Main_Gate.jpg/800px-Banaras_Hindu_University_Main_Gate.jpg", "Institute of Medical Sciences (IMS-BHU) is one of the three institutes of Banaras Hindu University in Varanasi. It is a prestigious medical college known for its rich heritage and academic excellence.")'

if bhu_old in content:
    content = content.replace(bhu_old, bhu_new)

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
    f.write(content)
