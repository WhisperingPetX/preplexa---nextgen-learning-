package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Light Theme Base Colors
val LightBackground = Color(0xFFF8FAFC)
val LightSurface = Color(0xFFFFFFFF)
val LightSurfaceVariant = Color(0xFFE2E8F0)
val LightOnSurface = Color(0xFF0F172A)
val LightOnSurfaceVariant = Color(0xFF475569)

// Dark Theme Base Palette
val DarkBackground = Color(0xFF0B0F19)
val DarkSurface = Color(0xFF121829)
val DarkSurfaceVariant = Color(0xFF1E293B)
val DarkOnSurface = Color(0xFFF8FAFC)

// Dynamic Bento System Palette
val BentoBackground: Color
    @Composable get() = MaterialTheme.colorScheme.background

val BentoSurface: Color
    @Composable get() = MaterialTheme.colorScheme.surface

val BentoSurfaceVariant: Color
    @Composable get() = MaterialTheme.colorScheme.surfaceVariant

val BentoOnSurface: Color
    @Composable get() = MaterialTheme.colorScheme.onSurface

val BentoOnSurfaceVariant: Color
    @Composable get() = MaterialTheme.colorScheme.onSurfaceVariant

val BentoPrimary = Color(0xFF651FFF) // Radiant Deep Violet

val BentoPrimaryContainer: Color
    @Composable get() = if (LocalDarkTheme.current) Color(0xFF1E1B4B) else Color(0xFFEDE7F6)

val BentoOnPrimaryContainer: Color
    @Composable get() = if (LocalDarkTheme.current) Color(0xFFC7D2FE) else Color(0xFF311B92)

// Bento Color Block Cards matched to Logo Accents with Dark Mode support
val BentoBlueBg: Color
    @Composable get() = if (LocalDarkTheme.current) Color(0xFF0F2B36) else Color(0xFFE0F7FA)

val BentoBlueBorder: Color
    @Composable get() = if (LocalDarkTheme.current) Color(0xFF006064) else Color(0xFF80DEEA)

val BentoBlueText: Color
    @Composable get() = if (LocalDarkTheme.current) Color(0xFF80DEEA) else Color(0xFF004D40)

val BentoBlueBadge = Color(0xFF00B0FF) // Electric Blue

val BentoPurpleBg: Color
    @Composable get() = if (LocalDarkTheme.current) Color(0xFF231238) else Color(0xFFF3E5F5)

val BentoPurpleBorder: Color
    @Composable get() = if (LocalDarkTheme.current) Color(0xFF4A148C) else Color(0xFFCE93D8)

val BentoPurpleText: Color
    @Composable get() = if (LocalDarkTheme.current) Color(0xFFE1BEE7) else Color(0xFF4A148C)

val BentoPurpleBadge = Color(0xFF7C4DFF) // Radiant Purple

val BentoGreenBg: Color
    @Composable get() = if (LocalDarkTheme.current) Color(0xFF0D2818) else Color(0xFFE8F5E9)

val BentoGreenBorder: Color
    @Composable get() = if (LocalDarkTheme.current) Color(0xFF1B5E20) else Color(0xFFA5D6A7)

val BentoGreenText: Color
    @Composable get() = if (LocalDarkTheme.current) Color(0xFFA5D6A7) else Color(0xFF1B5E20)

val BentoGreenBadge = Color(0xFF00C853) // Vibrant Mint

val BentoPeachBg: Color
    @Composable get() = if (LocalDarkTheme.current) Color(0xFF2E1218) else Color(0xFFFFEBEE)

val BentoPeachBorder: Color
    @Composable get() = if (LocalDarkTheme.current) Color(0xFF880E4F) else Color(0xFFFFCDD2)

val BentoPeachText: Color
    @Composable get() = if (LocalDarkTheme.current) Color(0xFFFFCDD2) else Color(0xFF880E4F)

val BentoPeachBadge = Color(0xFFFF4081) // Radiant Pink/Coral

// Legacy Theme Aliases mapped to Radiant Palette
val PreplexaIndigoPrimary = BentoPrimary
val PreplexaIndigoLight = Color(0xFFB388FF)
val PreplexaCyanSecondary = Color(0xFF00B0FF)
val PreplexaCyanLight = Color(0xFF80D8FF)
val PreplexaEmerald = Color(0xFF00C853)
val PreplexaEmeraldLight = Color(0xFFB9F6CA)
val PreplexaRose = Color(0xFFFF4081)
val PreplexaRoseLight = Color(0xFFFF80AB)
val PreplexaAmber = Color(0xFFFFAB00)

// Bento Color Set Helper
data class BentoColorSet(
    val bg: Color,
    val border: Color,
    val text: Color,
    val badge: Color
)




