package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.registration.Registration


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(navController: NavController)
            Registration(navController: NavController)

            // Initialize NavController
            val navController = rememberNavController()

            // Set up NavHost with routes
            NavHost(navController = navController, startDestination = "LoginScreen") {
                composable("LoginScreen") { LoginScreen(navController) }
                composable("Registration") { Registration(navController) }


        }
    }
}
}

@Composable
fun LoginScreen(navController: NavController) {
    // Your LoginScreen composable
}

@Composable
fun Registration(navController: NavController) {
    // Your RegistrationScreen composable
}