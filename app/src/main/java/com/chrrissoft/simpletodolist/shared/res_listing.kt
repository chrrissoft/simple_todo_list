package com.chrrissoft.simpletodolist.shared

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.chrrissoft.simpletodolist.R

@Composable
fun<K, V> ResStateListMap(
    state: ResState<Map<K, V>>,
    modifier: Modifier = Modifier,
    onSuccess: LazyListScope.(Map<K, V>) -> Unit,
) {
    LazyColumn(modifier = modifier) {
        when (state) {
            ResState.None -> {}
            ResState.Loading -> {}
            is ResState.Success -> onSuccess(state.data)
            is ResState.Error -> item { Text(text = "Error: ${state.message}") }
        }
    }
}

@Composable
fun<T> ResStateList(
    state: ResState<List<T>>,
    modifier: Modifier = Modifier,
    onSuccess: LazyListScope.(List<T>) -> Unit,
) {
    LazyColumn(modifier = modifier) {
        when (state) {
            ResState.None -> item { Text(text = "None") }
            ResState.Loading -> item { Text(text = stringResource(id = R.string.loading)) }
            is ResState.Error -> item { Text(text = "Error: ${state.message}") }
            is ResState.Success -> onSuccess(state.data)
        }
    }
}
