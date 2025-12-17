package com.example.adaptiveresponsive.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.adaptiveresponsive.nav.Routes
import com.example.adaptiveresponsive.view.RegisterScreen
import com.example.adaptiveresponsive.viewmodel.RegisterViewModel

@Composable
fun EntryPoint(navigationController: NavController, viewModel: RegisterViewModel)
{
    NavHost(
        navController = navigationController as NavHostController,
        startDestination = Routes.RegisterScreen.route
    ) {
        composable(Routes.RegisterScreen.route) { RegisterScreen(navigationController, viewModel) }

    }
}
