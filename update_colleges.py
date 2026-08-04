import re

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    content = f.read()

# Add imports
if 'import coil.compose.AsyncImage' not in content:
    content = content.replace('import androidx.compose.ui.Alignment', 'import coil.compose.AsyncImage\nimport androidx.compose.ui.layout.ContentScale\nimport androidx.compose.ui.Alignment')

# Find TopCollege and TopCollegesGallerySection
# TopCollege data class
old_top_college = 'data class TopCollege(val name: String, val nirfRank: Int, val topPackage: String, val website: String, val bgColor: Color)'
new_top_college = 'data class TopCollege(val name: String, val nirfRank: Int, val topPackage: String, val website: String, val bgColor: Color, val imageUrl: String = "", val info: String = "")'

if old_top_college in content:
    content = content.replace(old_top_college, new_top_college)

old_section = """fun TopCollegesGallerySection(selectedExam: ExamType) {
    val context = LocalContext.current
    val colleges = remember(selectedExam) {
        if (selectedExam == ExamType.NEET_UG) {
            listOf(
                TopCollege("AIIMS New Delhi", 1, "₹24 LPA (Stipend)", "aiims.edu", Color(0xFFE3F2FD)),
                TopCollege("PGIMER Chandigarh", 2, "₹12 LPA (Stipend)", "pgimer.edu.in", Color(0xFFF3E5F5)),
                TopCollege("CMC Vellore", 3, "₹10 LPA", "cmch-vellore.edu", Color(0xFFE8F5E9)),
                TopCollege("NIMHANS Bangalore", 4, "₹9 LPA", "nimhans.ac.in", Color(0xFFFFF3E0)),
                TopCollege("JIPMER Puducherry", 5, "₹12 LPA", "jipmer.edu.in", Color(0xFFFFEBEE)),
                TopCollege("Amrita Vishwa Vidyapeetham", 6, "₹14 LPA", "amrita.edu", Color(0xFFE0F7FA)),
                TopCollege("Sanjay Gandhi PGIMS", 7, "₹11 LPA", "sgpgims.org.in", Color(0xFFFCE4EC)),
                TopCollege("BHU Varanasi", 8, "₹12 LPA", "bhu.ac.in", Color(0xFFFFF8E1)),
                TopCollege("KMC Manipal", 9, "₹15 LPA", "manipal.edu", Color(0xFFF1F8E9)),
                TopCollege("Sree Chitra Tirunal", 10, "₹10 LPA", "sctimst.ac.in", Color(0xFFEFEBE9))
            )
        } else {
            listOf(
                TopCollege("IIT Madras", 1, "₹1.98 Cr PA", "iitm.ac.in", Color(0xFFFFF3E0)),
                TopCollege("IIT Delhi", 2, "₹2.05 Cr PA", "iitd.ac.in", Color(0xFFE3F2FD)),
                TopCollege("IIT Bombay", 3, "₹3.67 Cr PA", "iitb.ac.in", Color(0xFFF3E5F5)),
                TopCollege("IIT Kanpur", 4, "₹1.90 Cr PA", "iitk.ac.in", Color(0xFFE8F5E9)),
                TopCollege("IIT Roorkee", 5, "₹1.30 Cr PA", "iitr.ac.in", Color(0xFFFFEBEE)),
                TopCollege("IIT Kharagpur", 6, "₹2.60 Cr PA", "iitkgp.ac.in", Color(0xFFE0F7FA)),
                TopCollege("IIT Guwahati", 7, "₹1.20 Cr PA", "iitg.ac.in", Color(0xFFFCE4EC)),
                TopCollege("IIT Hyderabad", 8, "₹65 LPA", "iith.ac.in", Color(0xFFFFF8E1)),
                TopCollege("NIT Trichy", 9, "₹40 LPA", "nitt.edu", Color(0xFFF1F8E9)),
                TopCollege("Jadavpur University", 10, "₹85 LPA", "jaduniv.edu.in", Color(0xFFEFEBE9))
            )
        }
    }"""

new_section = """fun TopCollegesGallerySection(selectedExam: ExamType) {
    val context = LocalContext.current
    var selectedCollegeForDialog by remember { mutableStateOf<TopCollege?>(null) }

    val colleges = remember(selectedExam) {
        if (selectedExam == ExamType.NEET_UG) {
            listOf(
                TopCollege("AIIMS New Delhi", 1, "₹24 LPA (Stipend)", "aiims.edu", Color(0xFFE3F2FD), "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/AIIMS_New_Delhi.jpg/800px-AIIMS_New_Delhi.jpg", "All India Institute of Medical Sciences (AIIMS) New Delhi is the premier medical college and hospital in India, globally recognized for its excellence in medical research and education. Securing a seat here is the ultimate dream of every NEET aspirant!"),
                TopCollege("PGIMER Chandigarh", 2, "₹12 LPA (Stipend)", "pgimer.edu.in", Color(0xFFF3E5F5)),
                TopCollege("CMC Vellore", 3, "₹10 LPA", "cmch-vellore.edu", Color(0xFFE8F5E9)),
                TopCollege("NIMHANS Bangalore", 4, "₹9 LPA", "nimhans.ac.in", Color(0xFFFFF3E0)),
                TopCollege("JIPMER Puducherry", 5, "₹12 LPA", "jipmer.edu.in", Color(0xFFFFEBEE)),
                TopCollege("Amrita Vishwa Vidyapeetham", 6, "₹14 LPA", "amrita.edu", Color(0xFFE0F7FA)),
                TopCollege("Sanjay Gandhi PGIMS", 7, "₹11 LPA", "sgpgims.org.in", Color(0xFFFCE4EC)),
                TopCollege("BHU Varanasi", 8, "₹12 LPA", "bhu.ac.in", Color(0xFFFFF8E1)),
                TopCollege("KMC Manipal", 9, "₹15 LPA", "manipal.edu", Color(0xFFF1F8E9)),
                TopCollege("Sree Chitra Tirunal", 10, "₹10 LPA", "sctimst.ac.in", Color(0xFFEFEBE9))
            )
        } else {
            listOf(
                TopCollege("IIT Madras", 1, "₹1.98 Cr PA", "iitm.ac.in", Color(0xFFFFF3E0), "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/IIT_Madras_Main_Building.jpg/800px-IIT_Madras_Main_Building.jpg", "Indian Institute of Technology (IIT) Madras is the top-ranked engineering institute in India. Known for its lush green campus and cutting-edge research facilities, it is the ultimate destination for JEE Advanced toppers!"),
                TopCollege("IIT Delhi", 2, "₹2.05 Cr PA", "iitd.ac.in", Color(0xFFE3F2FD), "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/IIT_Delhi_Main_Building.jpg/800px-IIT_Delhi_Main_Building.jpg", "IIT Delhi is located in the heart of the national capital. It offers unparalleled opportunities in research, startups, and placements."),
                TopCollege("IIT Bombay", 3, "₹3.67 Cr PA", "iitb.ac.in", Color(0xFFF3E5F5)),
                TopCollege("IIT Kanpur", 4, "₹1.90 Cr PA", "iitk.ac.in", Color(0xFFE8F5E9)),
                TopCollege("IIT Roorkee", 5, "₹1.30 Cr PA", "iitr.ac.in", Color(0xFFFFEBEE)),
                TopCollege("IIT Kharagpur", 6, "₹2.60 Cr PA", "iitkgp.ac.in", Color(0xFFE0F7FA)),
                TopCollege("IIT Guwahati", 7, "₹1.20 Cr PA", "iitg.ac.in", Color(0xFFFCE4EC)),
                TopCollege("IIT Hyderabad", 8, "₹65 LPA", "iith.ac.in", Color(0xFFFFF8E1)),
                TopCollege("NIT Trichy", 9, "₹40 LPA", "nitt.edu", Color(0xFFF1F8E9)),
                TopCollege("Jadavpur University", 10, "₹85 LPA", "jaduniv.edu.in", Color(0xFFEFEBE9))
            )
        }
    }
"""
if old_section in content:
    content = content.replace(old_section, new_section)

# Find the Surface that renders the Gallery
old_gallery = """    Surface(
        shape = RoundedCornerShape(16.dp),
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Top 10 Dream Colleges",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 15.sp,
                    color = BentoOnSurface
                )
            }

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(colleges) { college ->
                    Surface(
                        modifier = Modifier
                            .width(220.dp)
                            .clickable {
                                val intent = android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse("https://${college.website}"))
                                context.startActivity(intent)
                            },
                        shape = RoundedCornerShape(12.dp),
                        color = college.bgColor.copy(alpha = 0.15f),
                        border = BorderStroke(1.dp, college.bgColor.copy(alpha = 0.6f))
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = college.name,
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 14.sp,
                                color = BentoOnSurface,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = BentoPrimaryContainer,
                                    modifier = Modifier.padding(vertical = 4.dp)
                                ) {
                                    Text(
                                        text = "NIRF Rank: ${college.nirfRank}",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = BentoPrimary,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                                Text(
                                    text = "🏆 ${college.topPackage}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFF00C853)
                                )
                            }
                            Text(
                                text = "🌐 ${college.website}",
                                fontSize = 10.sp,
                                color = BentoOnSurfaceVariant,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }"""

new_gallery = """    val topTarget = colleges.first()

    Surface(
        shape = RoundedCornerShape(16.dp),
        color = BentoSurface,
        border = BorderStroke(1.dp, BentoSurfaceVariant),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Your Dream College",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 16.sp,
                    color = BentoOnSurface
                )
            }
            
            // Highlighted Target College Card
            Surface(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .clickable { selectedCollegeForDialog = topTarget },
                shape = RoundedCornerShape(16.dp),
                color = topTarget.bgColor.copy(alpha = 0.3f),
                border = BorderStroke(1.dp, topTarget.bgColor.copy(alpha = 0.8f))
            ) {
                Column {
                    if (topTarget.imageUrl.isNotEmpty()) {
                        AsyncImage(
                            model = topTarget.imageUrl,
                            contentDescription = topTarget.name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                        )
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                                .background(Color.LightGray),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Filled.School, contentDescription = null, modifier = Modifier.size(48.dp), tint = Color.White)
                        }
                    }
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = topTarget.name,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            color = BentoOnSurface
                        )
                        Text(
                            text = "Explore Now",
                            color = Color(0xFF9C27B0), // Purple color requested
                            fontSize = 14.sp,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }

            Text(
                text = "Other Top Colleges",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = BentoOnSurfaceVariant,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(colleges.drop(1)) { college ->
                    Surface(
                        modifier = Modifier
                            .width(220.dp)
                            .clickable {
                                selectedCollegeForDialog = college
                            },
                        shape = RoundedCornerShape(12.dp),
                        color = college.bgColor.copy(alpha = 0.15f),
                        border = BorderStroke(1.dp, college.bgColor.copy(alpha = 0.6f))
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = college.name,
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 14.sp,
                                color = BentoOnSurface,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = BentoPrimaryContainer,
                                    modifier = Modifier.padding(vertical = 4.dp)
                                ) {
                                    Text(
                                        text = "NIRF: ${college.nirfRank}",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = BentoPrimary,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                                Text(
                                    text = "🏆 ${college.topPackage}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFF00C853)
                                )
                            }
                            Text(
                                text = "🌐 ${college.website}",
                                fontSize = 10.sp,
                                color = BentoOnSurfaceVariant,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }

    if (selectedCollegeForDialog != null) {
        CollegeDetailsDialog(college = selectedCollegeForDialog!!, onDismiss = { selectedCollegeForDialog = null }, context = context)
    }"""
if old_gallery in content:
    content = content.replace(old_gallery, new_gallery)
    
# Append CollegeDetailsDialog at the end
dialog_code = """
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollegeDetailsDialog(college: TopCollege, onDismiss: () -> Unit, context: Context) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = BentoSurface,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (college.imageUrl.isNotEmpty()) {
                AsyncImage(
                    model = college.imageUrl,
                    contentDescription = college.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(college.bgColor.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Filled.School, contentDescription = null, modifier = Modifier.size(64.dp), tint = BentoPrimary)
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = college.name,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                color = BentoOnSurface,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("NIRF Rank", fontSize = 12.sp, color = BentoOnSurfaceVariant)
                    Text("#${college.nirfRank}", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = BentoPrimary)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Top Package", fontSize = 12.sp, color = BentoOnSurfaceVariant)
                    Text(college.topPackage, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF00C853))
                }
            }
            
            if (college.info.isNotEmpty()) {
                Spacer(modifier = Modifier.height(16.dp))
                Surface(
                    color = BentoSurfaceVariant.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.padding(horizontal = 24.dp).fillMaxWidth()
                ) {
                    Text(
                        text = college.info,
                        fontSize = 14.sp,
                        color = BentoOnSurfaceVariant,
                        lineHeight = 20.sp,
                        modifier = Modifier.padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Button(
                onClick = {
                    val intent = android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse("https://${college.website}"))
                    context.startActivity(intent)
                    onDismiss()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9C27B0)), // Purple color
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Explore Now", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}
"""
if "fun CollegeDetailsDialog" not in content:
    content += dialog_code

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
    f.write(content)

