import re
block = 'explanation = "Correct Answer: 4\\nSolution:\\n",'
ans_match = re.search(r'explanation = "Correct Answer: (\d+)\\\\nSolution:\\\\n.*?"', block, re.DOTALL)
print(ans_match.group(1) if ans_match else "None")
