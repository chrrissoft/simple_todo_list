package com.chrrissoft.simpletodolist.ui.theme

import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun simpleTextFiledColors(
    errorIndicatorColor: Color = Color.Transparent,
    focusedIndicatorColor: Color = Color.Transparent,
    disabledIndicatorColor: Color = Color.Transparent,
    unfocusedIndicatorColor: Color = Color.Transparent,
    focusedContainerColor: Color = Color.Transparent,
    unfocusedContainerColor: Color = Color.Transparent,
    disabledContainerColor: Color = Color.Transparent,
    focusedTextColor: Color = colorScheme.onBackground,
    unfocusedTextColor: Color = colorScheme.onBackground,
    disabledPlaceholderColor: Color = colorScheme.onBackground.copy(.4f),
    focusedPlaceholderColor: Color = colorScheme.onBackground.copy(.4f),
    unfocusedPlaceholderColor: Color = colorScheme.onBackground.copy(.4f),
): TextFieldColors {
    return TextFieldDefaults.colors(
        errorIndicatorColor = errorIndicatorColor,
        focusedIndicatorColor = focusedIndicatorColor,
        disabledIndicatorColor = disabledIndicatorColor,
        unfocusedIndicatorColor = unfocusedIndicatorColor,
        unfocusedContainerColor = unfocusedContainerColor,
        focusedContainerColor = focusedContainerColor,
        unfocusedTextColor = unfocusedTextColor,
        disabledContainerColor = disabledContainerColor,
        focusedTextColor = focusedTextColor,
        disabledPlaceholderColor = disabledPlaceholderColor,
        focusedPlaceholderColor = focusedPlaceholderColor,
        unfocusedPlaceholderColor = unfocusedPlaceholderColor
    )
}