package com.devcraft.trading.presentation.guide

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devcraft.trading.domain.use_case.TradingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class GuideViewModel @Inject constructor(private val useCases: TradingUseCases,
                                         private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _state = mutableStateOf(GuideState())
    val state: State<GuideState> = _state

    fun getGuide(){
        savedStateHandle.get<Int>("id")!!.also {
            viewModelScope.launch(Dispatchers.IO) {
                useCases.getGuide(it).also {
                    _state.value = _state.value.copy(
                        title = it.title,
                        content = it.content
                    )
                }
            } }
    }

}



