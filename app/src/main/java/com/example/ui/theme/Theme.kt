package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.platform.LocalContext

val LocalDarkTheme = compositionLocalOf { false }

private val DarkColorScheme =
    darkColorScheme(
        primary = PreplexaIndigoLight,
        secondary = PreplexaCyanLight,
        tertiary = PreplexaEmeraldLight,
        background = DarkBackground,
        surface = DarkSurface,
        surfaceVariant = DarkSurfaceVariant,
        onPrimary = LightOnSurface,
        onSecondary = LightOnSurface,
        onBackground = DarkOnSurface,
        onSurface = DarkOnSurface,
        onSurfaceVariant = androidx.compose.ui.graphics.Color(0xFF94A3B8)
    )

private val LightColorScheme =
    lightColorScheme(
        primary = PreplexaIndigoPrimary,
        secondary = PreplexaCyanSecondary,
        tertiary = PreplexaEmerald,
        background = LightBackground,
        surface = LightSurface,
        surfaceVariant = LightSurfaceVariant,
        onPrimary = androidx.compose.ui.graphics.Color.White,
        onSecondary = androidx.compose.ui.graphics.Color.White,
        onBackground = LightOnSurface,
        onSurface = LightOnSurface,
        onSurfaceVariant = LightOnSurfaceVariant
    )

@Composable
fun PreplexaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    CompositionLocalProvider(LocalDarkTheme provides darkTheme) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}
