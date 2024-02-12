package com.chrrissoft.simpletodolist.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.chrrissoft.simpletodolist.utils.Utils.Try
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object ComposeUtils {
    @SuppressLint("ComposableNaming")
    @Composable
    fun <T> RowScope.forEach(list: List<T>, space: Float = .05f, block: @Composable (T) -> Unit) {
        list.forEachIndexed { index, i ->
            block(i)
            if (index < list.lastIndex) Spacer(modifier = Modifier.weight(space))
        }
    }

    fun SnackbarHostState.show(
        scope: CoroutineScope,
        message: String,
        dismiss: Boolean = true,
        actionLabel: String? = null,
        withDismissAction: Boolean = true,
        duration: SnackbarDuration = if (actionLabel == null) SnackbarDuration.Short else SnackbarDuration.Indefinite
    ) {
        scope.launch(Dispatchers.Default) {
            show(message, dismiss, actionLabel, withDismissAction, duration)
        }
    }

    suspend fun SnackbarHostState.show(
        message: String,
        dismiss: Boolean = true,
        actionLabel: String? = null,
        withDismissAction: Boolean = true,
        duration: SnackbarDuration = if (actionLabel == null) SnackbarDuration.Short else SnackbarDuration.Indefinite
    ): SnackbarResult {
        return Try {
            if (dismiss) currentSnackbarData?.dismiss()
            showSnackbar(message, actionLabel, withDismissAction, duration)
        } ?: SnackbarResult.Dismissed
    }

    @SuppressLint("ComposableNaming")
    @Composable
    fun setBarsColors(
        status: Color = MaterialTheme.colorScheme.background,
        bottom: Color = MaterialTheme.colorScheme.background,
    ) {
        val systemUiController = rememberSystemUiController()
        LaunchedEffect(systemUiController) {
            systemUiController.setStatusBarColor(status)
            systemUiController.setNavigationBarColor(bottom)
        }
    }
}
