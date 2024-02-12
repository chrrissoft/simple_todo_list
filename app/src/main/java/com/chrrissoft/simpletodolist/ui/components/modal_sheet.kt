package com.chrrissoft.simpletodolist.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyModalBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberModalBottomSheetState(),
    shape: Shape = BottomSheetDefaults.ExpandedShape,
    containerColor: Color = BottomSheetDefaults.ContainerColor,
    contentColor: Color = contentColorFor(containerColor),
    tonalElevation: Dp = BottomSheetDefaults.Elevation,
    scrimColor: Color = BottomSheetDefaults.ScrimColor,
    dragHandle: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    windowInsets: WindowInsets = BottomSheetDefaults.windowInsets,
    content: @Composable ColumnScope.() -> Unit,
    trainingIcon: (@Composable () -> Unit)? = null,
    title: String? = null,
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        sheetState = sheetState,
        shape = shape,
        containerColor = containerColor,
        contentColor = contentColor,
        tonalElevation = tonalElevation,
        scrimColor = scrimColor,
        dragHandle = dragHandle,
        windowInsets = windowInsets,
        content = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                content = {
                    Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                        trainingIcon?.let { it() }
                    }
                }
            )
            Column(
                Modifier
                    .padding(top = 10.dp)
                    .padding(horizontal = 10.dp)
            ) {
                title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.secondary,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
                content()
                Spacer(modifier = Modifier.fillMaxHeight())
            }
        },
    )
}
