package com.example.aplikacja_sieciowa.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb



private val DiscordColorScheme = darkColorScheme(
    primary = DiscordBlurple,
    onPrimary = DiscordTextPrimary,
    secondary = DiscordGreen,
    onSecondary = DiscordTextPrimary,
    tertiary = DiscordYellow,
    background = DiscordDarkBackground,
    onBackground = DiscordTextPrimary,
    surface = DiscordDarkerBackground,
    onSurface = DiscordTextPrimary,
    surfaceVariant = DiscordDarkestBackground,
    onSurfaceVariant = DiscordTextSecondary,
    error = DiscordRed,
    onError = DiscordTextPrimary
)

@Composable
fun Aplikacja_SieciowaTheme(
    darkTheme: Boolean = true, // Always dark for Discord style
    content: @Composable () -> Unit
) {
    val colorScheme = DiscordColorScheme



    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}