package com.example.login.HomeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.login.Login.itemSpacing
import java.lang.reflect.Modifier

@Composable

fun  HomeScreen(navController: NavHostController,user: User) {

    Surface(color = MaterialTheme.colors.secondaryVariant) {



        Column(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .padding(horizontal = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {

//            Scaffold(
//                topBar = {
//                    TopAppBar(
//                        title = { Text(text = "Home") }
//                    )
//                }
//            )
            
            Text(text = "Welcome,${user.email}!")

            Spacer(androidx.compose.ui.Modifier.height(itemSpacing))
            Text(text = "Email: ${user.email}")

        }


    }
}

