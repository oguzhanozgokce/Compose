package com.oguzhanozgokce.composeb2b.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

@Composable
fun <T> LiveData<T>.observeAsState(initial: T): State<T> {
    val state = remember { mutableStateOf(initial) }
    DisposableEffect(this) {
        val observer = Observer<T> { newValue ->
            state.value = newValue
        }
        observeForever(observer)
        onDispose {
            removeObserver(observer)
        }
    }
    return state
}