package com.example.adaptiveresponsive.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.adaptiveresponsive.model.SignUp
import com.example.adaptiveresponsive.nav.Routes
import com.example.adaptiveresponsive.viewmodel.RegisterViewModel

@Composable
fun WelcomeScreen(navController: NavController, viewModel: RegisterViewModel) {
    val signUp by viewModel.signUp.observeAsState(SignUp("","","","","","","", false))


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            Text("Benvingut/da " + signUp.name)
            Button(onClick = { navController.navigate(Routes.LoginScreen.route)})
            {
                Text("Tornar Enrere")
            }

        }

    }
}
