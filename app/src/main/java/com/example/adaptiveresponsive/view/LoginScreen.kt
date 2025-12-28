package com.example.adaptiveresponsive.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.adaptiveresponsive.composable.header
import com.example.adaptiveresponsive.model.SignUp
import com.example.adaptiveresponsive.nav.Routes
import com.example.adaptiveresponsive.viewmodel.RegisterViewModel
import com.example.adaptiveresponsive.R


@Composable
fun LoginScreen(navController: NavController, viewModel: RegisterViewModel) {
    val email by viewModel.loginEmail.observeAsState("")
    val password by viewModel.loginPassword.observeAsState("")


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 20.dp, 0.dp, 0.dp)
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.6f,
            alignment = Alignment.Center,
        )

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

            val context = LocalContext.current
            Button(onClick = { Toast.makeText(context,
                viewModel.checkLogin(navController), Toast.LENGTH_SHORT).show()},
                enabled = password.isNotEmpty() && email.isNotEmpty()) {
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