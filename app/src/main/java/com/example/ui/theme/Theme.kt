package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme =
  darkColorScheme(
    primary = KannadaYellow,
    onPrimary = Color.Black,
    primaryContainer = KannadaOrange,
    secondary = KannadaPink,
    tertiary = KannadaBlue,
    background = DarkBg,
    surface = DarkSurface,
    surfaceVariant = DarkSurfaceVariant
  )

private val LightColorScheme =
  lightColorScheme(
    primary = VibrantHeaderPink,
    onPrimary = Color.White,
    primaryContainer = VibrantRoseBadgeBg,
    onPrimaryContainer = VibrantRoseBadgeText,
    secondary = VibrantEmerald,
    secondaryContainer = SoftGreenBg,
    tertiary = VibrantBlue,
    tertiaryContainer = SoftBlueBg,
    background = VibrantBg,
    surface = VibrantSurface,
    surfaceVariant = Color(0xFFF8FAFC),
    onBackground = VibrantTextDark,
    onSurface = VibrantTextDark,
    onSurfaceVariant = VibrantTextMuted
  )

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false, // Keep branded Kannada theme consistent
  content: @Composable () -> Unit,
) {
  val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
