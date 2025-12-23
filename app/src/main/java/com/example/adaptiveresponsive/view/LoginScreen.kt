package com.example.adaptiveresponsive.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.adaptiveresponsive.composable.datePickerTextField
import com.example.adaptiveresponsive.composable.header
import com.example.adaptiveresponsive.model.SignUp
import com.example.adaptiveresponsive.nav.Routes
import com.example.adaptiveresponsive.viewmodel.RegisterViewModel

@Composable
fun LoginScreen(navController: NavController, viewModel: RegisterViewModel)
{
    val email by viewModel.loginEmail.observeAsState("")
    val password by viewModel.loginPassword.observeAsState("")


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            header()

            Text("INICIAR SESSIÓ")
            OutlinedTextField(
                value = email,
                onValueChange = { viewModel.onLoginEmailChange(it) },
                label = { Text("Email") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )


            OutlinedTextField(
                value = password,
                onValueChange = { viewModel.onLoginPasswordChange(it) },
                label = { Text("Contrasenya") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )

            Button(onClick = { }) {
                Text("Iniciar sessió")
            }

            Button(onClick = { navController.navigate(Routes.RegisterScreen.route) }) {
                Text("Registrat")
            }

            Column (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
                    .fillMaxSize()
            )
            {  }
        }
    }
}