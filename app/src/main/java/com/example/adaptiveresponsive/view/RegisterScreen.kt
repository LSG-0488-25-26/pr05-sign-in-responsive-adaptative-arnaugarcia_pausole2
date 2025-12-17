package com.example.adaptiveresponsive.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.adaptiveresponsive.model.SignUp
import com.example.adaptiveresponsive.viewmodel.RegisterViewModel

@Composable
fun RegisterScreen(navController: NavController, viewModel: RegisterViewModel) {
    val signUp by viewModel.signUp.observeAsState(SignUp("","","","","","","", false))

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = signUp.name,
                onValueChange = { viewModel.chanegName(it) },
                label = { Text("Nom complet") },
                singleLine = true,
            )

            OutlinedTextField(
                value = signUp.email,
                onValueChange = { signUp.email = it },
                label = { Text("Email") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )

            OutlinedTextField(
                value = signUp.phone,
                onValueChange = { signUp.phone = it },
                label = { Text("Número de teléfon") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                )
            )

            OutlinedTextField(
                value = signUp.username,
                onValueChange = { signUp.username = it },
                label = { Text("Nom d'usuari") },
                singleLine = true
            )

            OutlinedTextField(
                value = signUp.password,
                onValueChange = { signUp.password = it },
                label = { Text("Contrasenya") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )

            OutlinedTextField(
                value = signUp.confirmPassword,
                onValueChange = { signUp.confirmPassword = it },
                label = { Text("Repeteix contrasenya") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                isError = signUp.password != signUp.confirmPassword
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = signUp.acceptedTerms,
                    onCheckedChange = { signUp.acceptedTerms = it }
                )
                Text("Accepto els termes i condicions")
            }

            Button(
                onClick = {  },
                enabled = signUp.acceptedTerms
            ) {
                Text("Registra't!")
            }
        }
    }
}

