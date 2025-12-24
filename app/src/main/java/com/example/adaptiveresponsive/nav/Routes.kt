package com.example.adaptiveresponsive.nav

sealed class Routes(val route: String) {
    object RegisterScreen : Routes("registerScreen")
    object LoginScreen : Routes("loginScreen")
    object WelcomeScreen : Routes("welcomeScreen")

}