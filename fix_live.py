import os

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    lines = f.readlines()

new_content = """@Composable
fun LiveCompetitionCard(
    viewModel: MainViewModel,
    studentName: String
) {
    val liveArenaStats by viewModel.liveArenaStats.collectAsState()
    val formattedTotal = remember(liveArenaStats.totalActiveAspirants) {
        java.text.NumberFormat.getInstance().format(liveArenaStats.totalActiveAspirants)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable { viewModel.navigateToScreen(Screen.MOCK_TEST_SERIES_LIST) },
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFF0F172A), // Dark Midnight Competition Canvas
        border = BorderStroke(1.dp, Color(0xFF334155))
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Header Row with Live Pulse Indicator & Toggle Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("⚡", fontSize = 18.sp)
                    Text(
                        text = "NTA Live Arena",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 13.5.sp,
                        color = Color.White
                    )
                    Surface(
                        color = Color(0xFF991B1B),
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            text = "LIVE",
                            fontSize = 8.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp),
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }

                Surface(
                    color = Color(0xFF1E293B),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color(0xFF38BDF8))
                ) {
                    Text(
                        text = "🔴 $formattedTotal Active ⚔️",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF38BDF8),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        maxLines = 1,
                        softWrap = false
                    )
                }
            }
        }
    }
}
"""

start_idx = -1
end_idx = -1

for i, line in enumerate(lines):
    if line.startswith("@Composable") and "fun LiveCompetitionCard" in lines[i+1]:
        start_idx = i
        break

for i in range(start_idx, len(lines)):
    if "// --- 30-DAY MONTHLY BADGE SECTION ON DASHBOARD ---" in lines[i]:
        end_idx = i - 1
        break

if start_idx != -1 and end_idx != -1:
    with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
        f.writelines(lines[:start_idx])
        f.write(new_content)
        f.write("\n")
        f.writelines(lines[end_idx:])
    print("SUCCESS")
else:
    print(f"FAILED: start={start_idx}, end={end_idx}")

