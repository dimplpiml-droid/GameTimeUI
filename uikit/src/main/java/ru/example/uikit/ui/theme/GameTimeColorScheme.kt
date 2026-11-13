package ru.example.uikit.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class GameTimeColorScheme(
    val accent: List<Color>,
    val accentInActive: Color,
    val onAccent: Color,
    val background: Color,
    val onBackground: Color,
    val error: Color,
    val success: Color,
    val inputBg: Color,
    val inputStoke: Color,
    val inputIcon: Color,
    val placeholder: Color,
    val description: Color,
    val cardStroke: Color,
    )

val LightColorScheme =  GameTimeColorScheme(
    accent = GameTimePalette.Accent,
    accentInActive = GameTimePalette.AccentInactive ,
    onAccent = GameTimePalette.White ,
    background = GameTimePalette.White ,
    onBackground = GameTimePalette.Black ,
    error = GameTimePalette.Error ,
    success = GameTimePalette.Success ,
    inputBg = GameTimePalette.InputBg ,
    inputStoke = GameTimePalette.InputStroke ,
    inputIcon = GameTimePalette.InputIcon ,
    placeholder = GameTimePalette.Placeholder ,
    description = GameTimePalette.Description ,
    cardStroke = GameTimePalette.CardStroke
)
    
internal val LocalGameTimeColorScheme = staticCompositionLocalOf {
    LightColorScheme
}