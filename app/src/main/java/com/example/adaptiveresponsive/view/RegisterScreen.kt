package com.example.adaptiveresponsive.view

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.adaptiveresponsive.composable.datePickerTextField
import com.example.adaptiveresponsive.composable.header
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
            header()

            OutlinedTextField(
                value = signUp.name,
                onValueChange = { viewModel.onNameChange(it) },
                label = { Text("Nom complet") },
                singleLine = true,
            )

            OutlinedTextField(
                value = signUp.email,
                onValueChange = { viewModel.onEmailChange(it) },
                label = { Text("Email") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )

            var context = LocalContext.current;
            datePickerTextField(
                value = signUp.birthday,
                onDateSelected = { newDate ->
                    viewModel.onBirthdayChange(newDate)
                },
                label = "Data de naixement"
            )

            OutlinedTextField(
                value = signUp.phone,
                onValueChange = { viewModel.onPhoneChange(it) },
                label = { Text("Número de teléfon") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                )
            )

            OutlinedTextField(
                value = signUp.username,
                onValueChange = { viewModel.onUsernameChange(it) },
                label = { Text("Nom d'usuari") },
                singleLine = true
            )

            OutlinedTextField(
                value = signUp.password,
                onValueChange = { viewModel.onPasswordChange(it) },
                label = { Text("Contrasenya") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )

            OutlinedTextField(
                value = signUp.confirmPassword,
                onValueChange = { viewModel.onConfirmPasswordChange(it) },
                label = { Text("Repeteix contrasenya") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = signUp.acceptedTerms,
                    onCheckedChange = { viewModel.onTermsChange(it) }
                )
                Text("Accepto els termes i condicions")
            }

            Button(
                onClick = { Toast.makeText(context,
                    viewModel.validateRegister(), Toast.LENGTH_SHORT).show() },
                enabled = signUp.acceptedTerms
            ) {
                Text("Registra't!")
            }
        }
    }
}

