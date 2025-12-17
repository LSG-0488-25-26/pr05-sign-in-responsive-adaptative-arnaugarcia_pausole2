package com.example.adaptiveresponsive.nav

sealed class Routes(val route: String) {
    object RegisterScreen : Routes("registerScreen")

}