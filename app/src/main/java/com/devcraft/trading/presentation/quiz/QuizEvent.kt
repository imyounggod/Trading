package com.devcraft.trading.presentation.quiz

sealed class QuizEvent {
    object CorrectAnswer : QuizEvent()
    object IncorrectAnswer : QuizEvent()
    object AwaitAnswer : QuizEvent()
}