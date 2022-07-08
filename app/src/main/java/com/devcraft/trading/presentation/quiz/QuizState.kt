package com.devcraft.trading.presentation.quiz

import com.devcraft.trading.domain.model.Question

data class QuizState(
    val questions: List<Question> = listOf(
        Question(
            "A Call option of strike price Rs. 150 was bought by paying a premium of Rs. 10 and the share price upon expiry is Rs. 172. The total profit made is:",
            listOf(
                "10",
                "12",
                "22"
            ),
            1,
        ),
        Question(
            "The other name for Put option buyer is:",
            listOf(
                "Option holder",
                "Someone who is short",
                "Someone who is bullish on the market",
                "Option keeper"
            ),
            0,
        ),
        Question(
            "The Minimum and Maximum Intrinsic value for an option buyer is:",
            listOf(
                "Unlimited and unlimited",
                "None of these",
                "0 and Unlimited",
                "Unlimited and 0"
            ),
            2,
        ),
        Question(
            "The strike price is decided:",
            listOf(
                "anytime during the duration of the contract",
                "at the time of entering the contract",
                "at the time of expiry",
                "never agreed upon"
            ),
            1,
        ),
        Question(
            "What is an option?",
            listOf(
                "The right to buy or sell an asset within a stipulated time",
                "The right to question the management of the company",
                "The right to own the stock of other similar business company",
                "The right to buy a futures contract"
            ),
            0,
        ),
        Question(
            "An Out of Money Put option contract is:",
            listOf(
                "one where the spot price is above the strike price",
                "one where the strike price is above the spot price",
                "None of these",
                "one where the spot price and strike price are one and the same"
            ),
            1,
        ),
        Question(
            "One can obtain Option price from",
            listOf(
                "Any of these",
                "Option chain",
                "Option news letters",
                "Stock quotes"
            ),
            1,
        ),
        Question(
            "From sellers/writers perspective, the Intrinsic value of call option cannot be negative",
            listOf(
                "False",
                "True"
            ),
            1,
        ),
        Question(
            "What is a Put option?",
            listOf(

                "All of these",
                "The right to buy the underlying asset on or before maturity",
                "The right to sell the underlying asset on or before maturity",
                "The right to have the voting right in the company board meetings"
            ),
            2,
        ),
        Question(
            "The monthly expires on last working Thursday of every month, but if the last working day is a holiday then the option expires on:",
            listOf(
                "expires on next Thursday",
                "the monthly contract does not expire",
                "The previous working day i.e., Wednesday",
                "The next working day i.e., Friday"
            ),
            2,
        )
    ),
    val countQuestion : Int = questions.count(),
    var currentQuestion: Int = 0,
    var correctAnswers: Int = 0,
    var event : QuizEvent = QuizEvent.AwaitAnswer,
    var isFinished : Boolean = false
)
