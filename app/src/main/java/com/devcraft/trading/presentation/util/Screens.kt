package com.devcraft.trading.presentation.util

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object QuizScreen: Screen("quiz_screen")
    object GuideScreen: Screen("guide_screen")
}