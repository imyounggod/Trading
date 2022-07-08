package com.devcraft.trading.domain.model

data class Question(
    val question: String,
    val answers: List<String>,
    val correct: Int
)