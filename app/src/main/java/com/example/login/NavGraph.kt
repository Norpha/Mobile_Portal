package com.example.login

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.registration.Registration

@Composable
fun Nav(navController: NavHostController) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "LoginScreen" ){
        composable("LoginScreen"){
            LoginScreen(navController)
        }
        composable("Registration"){
            Registration(navController)
        }


    }
}