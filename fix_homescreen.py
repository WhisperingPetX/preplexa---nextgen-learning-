import re

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    lines = f.read().split('\n')

texts = [
    'text = "Examination News",',
    'text = "No new notifications yet.",',
    'text = news,',
    'text = "Preplexa",',
    'text = "NTA Exam Prep",',
    'text = appUpdateNotice,',
    'text = greetingText,',
    'text = "${selectedExam.displayName}",',
    'text = "${currentStreakDays}d Streak",',
    'text = "Select Your Target Exam",',
    'text = "$currentStreakDays Days Streak",',
    'text = "ACTIVE",',
    'text = "Calendar",',
    'text = dayName,',
    'text = title,',
    'text = subtitle,',
    'text = exam.displayName,',
    'text = exam.description,',
    'text = "DAY ${badge.dayMilestone}",',
    'text = badge.title,',
    'text = badge.description,',
    'text = if (badge.isUnlocked) "UNLOCKED" else "PROGRESS",',
    'text = badge.progressText,',
    'text = "365-Day Badges Roadmap",',
    'text = "36 Milestones • $unlockedCount/36 Unlocked",',
    'text = label,',
    'text = "30-Day Streak Journey",',
    'text = "Keep going! You have $currentStreak days active.",',
    'text = "Day $dayNumber",',
    'text = "Day $dayNumber",',
    'text = "NTA Live Arena",',
    'text = "LIVE",',
    'text = "$formattedTotal Active",',
    'text = "$currentMonthName Badges",',
    'text = "$unlockedCount / 30 Days Unlocked • Tap badge to set avatar",',
    'text = "Claim Day ${todayBadge.dayOfMonth}",',
    'text = "$unlockedCount Earned",',
    'text = badge.emojiIcon,',
    'text = "Day ${badge.dayOfMonth}",',
    'text = if (badge.isToday) "TODAY" else if (badge.isUnlocked) "UNLOCKED" else "LOCKED",',
    'text = "Student Study Analytics",',
    'text = "Real-time activity & time tracking",',
    'text = "42.5 hrs Total",',
    'text = "Subject Split",',
    'text = "Daily Activity",',
    'text = "${hours}h",',
    'text = day,',
    'text = "42.5h",',
    'text = "Total Time",',
    'text = pair.first,',
    'text = "${(pair.second * 100).toInt()}%",',
    'text = value,',
    'text = label,',
    'text = iconEmoji,',
    'text = title,',
    'text = "Perplexa AI Solver",',
    'text = "Instant 24/7 AI Mentor for ${selectedExam.displayName}",',
    'text = "GEMINI PRO",',
    'text = "Stuck on a problem? Upload a photo or PDF of any question for a step-by-step clear solution!",',
    'text = "Launch AI Mentor",'
]

new_lines = []
text_idx = 0

def is_dangling_text_arg(line):
    s = line.strip()
    return s.startswith('fontSize =') or s.startswith('fontWeight =') or s.startswith('color =') or s.startswith('maxLines =') or s.startswith('textAlign =') or s.startswith('overflow =') or s.startswith('lineHeight =') or s.startswith('modifier =')

for i, line in enumerate(lines):
    # If this line is a dangling argument, and the previous line wasn't a text argument (meaning we didn't just insert one)
    if is_dangling_text_arg(line):
        # check if we already inserted Text(
        if len(new_lines) > 0 and 'Text(' not in new_lines[-1] and 'text =' not in new_lines[-1]:
            # we need to insert Text(
            # try to match indentation
            indent = line[:len(line) - len(line.lstrip())]
            
            if text_idx < len(texts):
                t = texts[text_idx]
                text_idx += 1
            else:
                t = 'text = "Missing Text",'
                
            new_lines.append(indent + 'Text(')
            new_lines.append(indent + '    ' + t)
            
    new_lines.append(line)

with open('HomeScreen_fixed.kt', 'w') as f:
    f.write('\n'.join(new_lines))

print(f"Inserted {text_idx} texts")
