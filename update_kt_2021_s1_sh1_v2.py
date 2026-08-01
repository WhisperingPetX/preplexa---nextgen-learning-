import re

# Read solutions
with open('solutions_2021_s1_sh1.txt', 'r', encoding='utf-8') as f:
    sol_text = f.read()

sol_dict = {}
matches = list(re.finditer(r'(?:^|\n)(\d+)\.\[.*?\](.*?)(?=\n\d+\.\[|\Z)', sol_text, re.DOTALL))
for m in matches:
    q_num = int(m.group(1))
    solution = m.group(2).strip()
    sol_dict[q_num] = solution

# Recover from git to get the original file back
import subprocess
subprocess.run(['git', 'checkout', 'app/src/main/java/com/example/data/repository/JeeMain2021Session1Shift1QuestionsRepository.kt'])

kt_file = 'app/src/main/java/com/example/data/repository/JeeMain2021Session1Shift1QuestionsRepository.kt'
with open(kt_file, 'r', encoding='utf-8') as f:
    kt_content = f.read()

def replace_explanation(match):
    block = match.group(0)
    id_match = re.search(r'id = "\$\{testId\}_s1_sh1_q(\d+)_(phys|chem|math)"', block)
    if not id_match:
        return block
    q_num = int(id_match.group(1))
    
    subj = id_match.group(2)
    actual_q_num = q_num
    if subj == 'chem':
        actual_q_num += 30
    elif subj == 'math':
        actual_q_num += 60
        
    solution_text = sol_dict.get(actual_q_num, "")
    
    ans_match = re.search(r'explanation = "Correct Answer: (\d+).*?"', block, re.DOTALL)
    if ans_match:
        ans_val = ans_match.group(1)
        new_expl = f'Correct Answer: {ans_val}\nSolution:\n{solution_text}'
        # Use kotlin raw string
        new_line = f'explanation = """{new_expl}"""'
        block = re.sub(r'explanation = "Correct Answer: \d+.*?"', new_line, block, flags=re.DOTALL)

    return block

new_kt_content = re.sub(r'Question\(.*?difficulty = "Medium"\n\s*\)', replace_explanation, kt_content, flags=re.DOTALL)

with open(kt_file, 'w', encoding='utf-8') as f:
    f.write(new_kt_content)

print("Updated explanations successfully with raw strings.")
