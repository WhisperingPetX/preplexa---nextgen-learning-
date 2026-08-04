import re

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    content = f.read()

cmc_old = 'TopCollege("CMC Vellore", 3, "₹10 LPA", "cmch-vellore.edu", Color(0xFFE8F5E9))'
cmc_new = 'TopCollege("CMC Vellore", 3, "₹10 LPA", "cmch-vellore.edu", Color(0xFFE8F5E9), "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Cmc_vellore_1.jpg/800px-Cmc_vellore_1.jpg", "Christian Medical College (CMC) Vellore is one of the most prominent medical institutes in India, known for its strong emphasis on serving the community and producing top-tier medical professionals.")'

if cmc_old in content:
    content = content.replace(cmc_old, cmc_new)

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
    f.write(content)
