package com.devcraft.trading.presentation.quiz

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor() : ViewModel(){
    private val _state = MutableStateFlow(QuizState())
    val state: StateFlow<QuizState> = _state

    fun reset(){
        _state.value = _state.value.copy(
            currentQuestion = 0,
            event = QuizEvent.AwaitAnswer,
            correctAnswers = 0,
            isFinished = false
        )
    }

    fun finishQuiz(){
        _state.value = _state.value.copy(
            isFinished = true
        )
    }
    fun nextQuestion(){
        _state.value = _state.value.copy(
            currentQuestion = _state.value.currentQuestion+1,
            event = QuizEvent.AwaitAnswer
        )
        println(_state.value)
    }

    fun onEvent(event: QuizEvent){
        when(event){
            is QuizEvent.CorrectAnswer ->{
                _state.value = _state.value.copy(
                    correctAnswers = _state.value.correctAnswers+1,
                    event = event
                )
            }
            is QuizEvent.IncorrectAnswer ->{
                _state.value = _state.value.copy(
                    event = event
                )
            }
            else -> {

            }
        }
    }
}