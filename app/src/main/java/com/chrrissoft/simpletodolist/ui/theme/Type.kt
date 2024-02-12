package com.chrrissoft.simpletodolist.ui.theme

import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.chrrissoft.simpletodolist.R

val generalFont = FontFamily(Font(R.font.varela_round_regular))


val Typography @Composable get() = Typography(
    displayLarge = typography.displayLarge.copy(fontFamily = generalFont, fontWeight = FontWeight.Bold),
    displayMedium = typography.displayMedium.copy(fontFamily = generalFont, fontWeight = FontWeight.Bold),
    displaySmall = typography.displaySmall.copy(fontFamily = generalFont, fontWeight = FontWeight.Bold),
    headlineLarge = typography.headlineLarge.copy(fontFamily = generalFont, fontWeight = FontWeight.Bold),
    headlineMedium = typography.headlineMedium.copy(fontFamily = generalFont, fontWeight = FontWeight.Bold),
    headlineSmall = typography.headlineSmall.copy(fontFamily = generalFont, fontWeight = FontWeight.Bold),
    titleLarge = typography.titleLarge.copy(fontFamily = generalFont, fontWeight = FontWeight.Bold),
    titleMedium = typography.titleMedium.copy(fontFamily = generalFont, fontWeight = FontWeight.SemiBold),
    titleSmall = typography.titleSmall.copy(fontFamily = generalFont, fontWeight = FontWeight.SemiBold),
    bodyLarge = typography.bodyLarge.copy(fontFamily = generalFont, fontWeight = FontWeight.SemiBold),
    bodyMedium = typography.bodyMedium.copy(fontFamily = generalFont, fontWeight = FontWeight.SemiBold),
    bodySmall = typography.bodySmall.copy(fontFamily = generalFont, fontWeight = FontWeight.SemiBold),
    labelLarge = typography.labelLarge.copy(fontFamily = generalFont, fontWeight = FontWeight.SemiBold),
    labelMedium = typography.labelMedium.copy(fontFamily = generalFont, fontWeight = FontWeight.SemiBold),
    labelSmall = typography.labelSmall.copy(fontFamily = generalFont, fontWeight = FontWeight.Bold),
)
