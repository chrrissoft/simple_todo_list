package com.chrrissoft.simpletodolist.ui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(
    modifier: Modifier = Modifier,
    padding: Boolean = true,
    title: String? = null,
    info: String? = null,
    onNavigation: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    containerColor: Color = colorScheme.background,
    contentColor: Color = contentColorFor(containerColor),
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
    scrollableState: ScrollState? = null,
    content: @Composable ColumnScope.(PaddingValues) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = if (title == null) {
            {}
        } else {
            {
                CenterAlignedTopAppBar(
                    title = title,
                    onNavigation = onNavigation,
                    actions = actions,
                )
            }
        },
        bottomBar = bottomBar,
        snackbarHost = snackbarHost,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = floatingActionButtonPosition,
        containerColor = containerColor,
        contentColor = contentColor,
        contentWindowInsets = contentWindowInsets,
        content = { paddingValues ->
            Column(
                Modifier
                    .padding(paddingValues)
                    .let {
                        if (padding) it
                            .padding(horizontal = 10.dp)
                            .padding(top = 10.dp)
                        else it
                    }
                    .let { if (scrollableState != null) it.verticalScroll(scrollableState) else it }
            ) { content(paddingValues) }
        },
    )
}
