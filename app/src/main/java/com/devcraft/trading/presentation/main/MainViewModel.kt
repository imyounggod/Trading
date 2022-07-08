package com.devcraft.trading.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devcraft.trading.domain.model.CurrencyPair
import com.devcraft.trading.domain.use_case.TradingUseCases
import com.devcraft.trading.domain.util.Action
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.math.floor
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor(private val useCases: TradingUseCases) : ViewModel() {
    private val _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState> = _state
  private var generatePairJob: Job? = null

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value.guides.forEach{guide ->
                useCases.insertGuide(guide)
            }
        }
    }

    fun getCurrencyList() {
        generatePairJob?.cancel()
        generatePairJob = viewModelScope.launch {
            while (true) {
                val copy = _state.value
                val newState = MainState()
                copy.pairs.forEach {
                    delay(30L)
                    it.prev_price = it.price
                    var addValue =
                        floor((Random(Date().time).nextDouble(-0.15, 0.15)) * 100000.0) / 100000.0
                    if (addValue < 0 && it.countEqualAction >= 3 && it.prev_action == Action.MinusValue.action) {
                        addValue = -addValue
                    } else if (addValue >= 0 && it.countEqualAction >= 3 && it.prev_action == Action.PlusValue.action) {
                        addValue = -addValue
                    }
                    it.price += addValue
                    it.percent = if ((it.price < 0 && it.price < it.prev_price)||(it.price<0 && it.price> it.prev_price)) {
                        -CurrencyPair.percent(it.price, it.prev_price)
                    } else{
                        CurrencyPair.percent(it.price, it.prev_price)
                    }

                    if (addValue >= 0) {
                        if (it.prev_action == Action.PlusValue.action) {
                            it.countEqualAction += 1
                        } else {
                            it.countEqualAction = 0
                            it.prev_action = Action.PlusValue.action
                        }
                    } else {
                        if (it.prev_action == Action.MinusValue.action) {
                            it.countEqualAction += 1
                        } else {
                            it.countEqualAction = 0
                            it.prev_action = Action.MinusValue.action
                        }
                    }
                }
                newState.text = Random(Date().time).nextInt()
                newState.pairs = copy.pairs
                _state.emit(newState)
                delay(30000L)
            }
        }
    }
}
