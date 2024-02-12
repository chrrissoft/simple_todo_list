package com.chrrissoft.simpletodolist.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chrrissoft.simpletodolist.ui.theme.SimpleTodoListTheme

@Composable
fun SimpleTodoApp(app: @Composable () -> Unit) {
    SimpleTodoListTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) { app() }
    }
}
