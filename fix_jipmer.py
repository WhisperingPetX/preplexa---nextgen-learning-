import re

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    content = f.read()

jipmer_old = 'TopCollege("JIPMER Puducherry", 5, "₹12 LPA", "jipmer.edu.in", Color(0xFFFFEBEE))'
jipmer_new = 'TopCollege("JIPMER Puducherry", 5, "₹12 LPA", "jipmer.edu.in", Color(0xFFFFEBEE), "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/JIPMER_Main_Block.jpg/800px-JIPMER_Main_Block.jpg", "The Jawaharlal Institute of Postgraduate Medical Education & Research (JIPMER) is a medical school located at Pondicherry, India. It is an Institute of National Importance (INI).")'

if jipmer_old in content:
    content = content.replace(jipmer_old, jipmer_new)

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
    f.write(content)
