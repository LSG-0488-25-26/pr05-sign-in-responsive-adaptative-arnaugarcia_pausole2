package com.example.adaptiveresponsive.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.adaptiveresponsive.nav.Routes
import com.example.adaptiveresponsive.view.RegisterScreen
import com.example.adaptiveresponsive.view.LoginScreen
import com.example.adaptiveresponsive.view.WelcomeScreen
import com.example.adaptiveresponsive.viewmodel.RegisterViewModel

@Composable
fun EntryPoint(navigationController: NavController, viewModel: RegisterViewModel)
{
    NavHost(
        navController = navigationController as NavHostController,
        startDestination = Routes.LoginScreen.route
    ) {
        composable(Routes.LoginScreen.route) { LoginScreen(navigationController, viewModel) }
        composable(Routes.RegisterScreen.route) { RegisterScreen(navigationController, viewModel) }
        composable(Routes.WelcomeScreen.route) { WelcomeScreen(navigationController, viewModel) }

    }
}
