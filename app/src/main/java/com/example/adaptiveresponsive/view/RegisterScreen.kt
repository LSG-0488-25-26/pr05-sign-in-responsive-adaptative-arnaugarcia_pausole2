package com.example.adaptiveresponsive.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
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
import com.example.adaptiveresponsive.R
import com.example.adaptiveresponsive.composable.datePickerTextField
import com.example.adaptiveresponsive.composable.header
import com.example.adaptiveresponsive.model.SignUp
import com.example.adaptiveresponsive.viewmodel.RegisterViewModel
import androidx.compose.material3.windowsizeclass.WindowSizeClass

@Composable
fun RegisterScreen(navController: NavController, viewModel: RegisterViewModel, windowSize: WindowSizeClass) {
    val signUp by viewModel.signUp.observeAsState(SignUp("","","","","","","", false))

    var contentModifierBox: Modifier

    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
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
        }

        Box(
            modifier = contentModifierBox
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "REGISTRE",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = Color.White
                )

                OutlinedTextField(
                    value = signUp.name,
                    onValueChange = { viewModel.onNameChange(it) },
                    label = { Text("Nom complet") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.Black
                    )
                )

                OutlinedTextField(
                    value = signUp.email,
                    onValueChange = { viewModel.onEmailChange(it) },
                    label = { Text("Email") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.Black
                    )
                )

                datePickerTextField(
                    value = signUp.birthday,
                    onDateSelected = { newDate -> viewModel.onBirthdayChange(newDate) },
                    label = "Data de naixement",
                )

                OutlinedTextField(
                    value = signUp.phone,
                    onValueChange = { viewModel.onPhoneChange(it) },
                    label = { Text("Número de teléfon") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.Black
                    )
                )

                OutlinedTextField(
                    value = signUp.username,
                    onValueChange = { viewModel.onUsernameChange(it) },
                    label = { Text("Nom d'usuari") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.Black
                    )
                )

                OutlinedTextField(
                    value = signUp.password,
                    onValueChange = { viewModel.onPasswordChange(it) },
                    label = { Text("Contrasenya") },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.Black
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
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.Black
                    )
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(
                        checked = signUp.acceptedTerms,
                        onCheckedChange = { viewModel.onTermsChange(it) }
                    )
                    Text("Accepto els termes i condicions", color = Color.White)
                }

                val context = LocalContext.current
                Button (
                    onClick = {
                        Toast.makeText(context, viewModel.validateRegister(navController), Toast.LENGTH_SHORT).show()
                    },
                    enabled = signUp.acceptedTerms,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text("Registra't!", color = Color.White)
                }
            }
        }
    }
}
