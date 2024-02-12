package com.chrrissoft.simpletodolist.ui.entities

import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class SnackbarData(
    val type: MessageType = MessageType.Success,
    val state: SnackbarHostState = SnackbarHostState(),
    val time: Long = 1000,
) {
    sealed interface MessageType {
        val containerColor: Color @Composable get() = run {
            when (this) {
                Error -> colorScheme.errorContainer
                Success -> colorScheme.primaryContainer
            }
        }

        val contentColor: Color @Composable get() = run {
            when (this) {
                Error -> colorScheme.onErrorContainer
                Success -> colorScheme.onPrimaryContainer
            }
        }

        val actionColor: Color @Composable get() = run {
            when (this) {
                Success -> colorScheme.onPrimaryContainer
                Error -> colorScheme.onErrorContainer
            }
        }

        val actionContentColor: Color @Composable get() = run {
            when (this) {
                Success -> colorScheme.onPrimaryContainer
                Error -> colorScheme.onErrorContainer
            }
        }

        val dismissActionContentColor: Color @Composable get() = run {
            when (this) {
                Success -> colorScheme.onPrimaryContainer
                Error -> colorScheme.onErrorContainer
            }
        }

        object Error : MessageType
        object Success : MessageType
    }
}
