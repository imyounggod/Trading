package com.devcraft.trading.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun ViewModel.coroutineRepeat(durationMillis: Long,action: ()-> Unit){
    viewModelScope.launch(Dispatchers.IO) {
        while (true){
            action()
            delay(durationMillis)
        }
    }
}
