package com.example.adaptiveresponsive.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.ui.Alignment


@Composable
fun LoginScreen(navController: NavController, viewModel: RegisterViewModel, windowSize: WindowSizeClass) {
    val email by viewModel.loginEmail.observeAsState("")
    val password by viewModel.loginPassword.observeAsState("")

    var contentModifierBox: Modifier


    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()

    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.6f,
            alignment = Alignment.Center,
        )

        if (windowSize.heightSizeClass != WindowHeightSizeClass.Compact)
        {
            header()
            contentModifierBox = Modifier
                .fillMaxSize()
                .padding(16.dp,80.dp, 16.dp, 16.dp)
        } else {
            contentModifierBox = Modifier
                .fillMaxSize()
                .padding(16.dp,16.dp, 16.dp, 16.dp)
                .align(Alignment.Center)
                .verticalScroll(rememberScrollState())
        }

        Box(
            modifier = contentModifierBox
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "INICIAR SESSIÓ",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = Color.White
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { viewModel.onLoginEmailChange(it) },
                    label = { Text("Email") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),

                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedLabelColor = Color.Transparent,
                        unfocusedLabelColor = Color.Transparent
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
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),

                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedLabelColor = Color.Transparent,
                        unfocusedLabelColor = Color.Transparent
                    )
                )

                val context = LocalContext.current
                Button(
                    onClick = {
                        Toast.makeText(context, viewModel.checkLogin(navController), Toast.LENGTH_SHORT).show()
                    },
                    enabled = password.isNotEmpty() && email.isNotEmpty(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    Text("Iniciar sessió")
                }

                Button(
                    onClick = { navController.navigate(Routes.RegisterScreen.route) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Registra't")
                }
            }
        }
    }
}

