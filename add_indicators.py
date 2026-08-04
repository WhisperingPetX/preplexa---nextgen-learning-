import re

with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'r') as f:
    content = f.read()

pager_block = """        androidx.compose.foundation.pager.HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 32.dp),
            pageSpacing = 16.dp
        ) { page ->"""

if 'Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center)' not in content and pager_block in content:
    # Add indicators after the pager
    
    old_code = """                    }
                }
            }
        }
    }

    if (selectedCollegeForDialog != null) {"""

    new_code = """                    }
                }
            }
        }
        
        // Pager indicators
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(colleges.size) { iteration ->
                val color = if (pagerState.currentPage == iteration) BentoPrimary else BentoSurfaceVariant
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
    }

    if (selectedCollegeForDialog != null) {"""
    
    content = content.replace(old_code, new_code)
    
    with open('app/src/main/java/com/example/ui/screens/HomeScreen.kt', 'w') as f:
        f.write(content)
