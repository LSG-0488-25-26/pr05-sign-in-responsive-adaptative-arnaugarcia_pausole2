package com.example.adaptiveresponsive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowSize
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.adaptiveresponsive.nav.EntryPoint
import com.example.adaptiveresponsive.ui.theme.AdaptiveResponsiveTheme
import com.example.adaptiveresponsive.viewmodel.RegisterViewModel
import kotlin.getValue

class MainActivity : ComponentActivity() {
    val registerViewModel: RegisterViewModel by viewModels<RegisterViewModel>()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdaptiveResponsiveTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navigationController = rememberNavController()
                    val windowSizeClass = calculateWindowSizeClass(this)

                    // Crida a la vista EntryPoint i passa el controlador de navegació
                    EntryPoint(navigationController, registerViewModel, windowSizeClass)
                }
            }
        }
    }
}
