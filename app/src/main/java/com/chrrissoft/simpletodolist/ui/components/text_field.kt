package com.chrrissoft.simpletodolist.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction.Companion.Next
import androidx.compose.ui.text.input.KeyboardCapitalization.Companion.Sentences
import androidx.compose.ui.text.style.TextDecoration.Companion.LineThrough
import com.chrrissoft.simpletodolist.ui.theme.simpleTextFiledColors
import kotlinx.coroutines.delay

@Composable
fun SimpleTask(
    task: String,
    onTaskChange: (String) -> Unit,
    onDelete: () -> Unit,
    keyboardActions: KeyboardActions,
    onCompleteChange: (Boolean) -> Unit,
    complete: Boolean,
    modifier: Modifier = Modifier,
) {
    var pleaceholder by remember { mutableStateOf("") }

    LaunchedEffect(complete) {
        if (complete) {
            task.forEach {
                pleaceholder += it
                delay(timeMillis = 25)
            }
        } else pleaceholder = ""
    }

    TextField(
        value = if (complete) "" else task,
        enabled = !complete,
        onValueChange = onTaskChange,
        colors = simpleTextFiledColors(),
        placeholder = {
            if (complete) Text(text = pleaceholder, textDecoration = LineThrough)
            else Text(text = "Random")
        },
        trailingIcon = {
            Row {
                val alpha = remember(complete) { if (complete) .4f else 1f }
                IconButton(
                    onClick = { onDelete() },
                    content = { Icon(Rounded.Close, (null), tint = colorScheme.primary.copy(alpha)) },
                )
                IconButton(
                    onClick = { onCompleteChange(!complete) },
                    content = { Icon(Rounded.Check, (null), tint = colorScheme.secondary.copy(alpha)) },
                )
            }
        },
        keyboardOptions = remember { KeyboardOptions(Sentences, imeAction = Next) },
        keyboardActions = keyboardActions,
        modifier = modifier.fillMaxWidth()
    )
}
