@file:OptIn(ExperimentalComposeUiApi::class, ExperimentalComposeUiApi::class)

package com.example.login.Login

import android.content.res.Resources.Theme
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.login.Login.HeaderText
import com.example.login.MyTheme
val  defaultPadding = 16.dp
val  itemSpacing = 8.dp
@Composable
fun LoginScreen(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.secondaryVariant) {
        var (email,setEmail) = rememberSaveable  { mutableStateOf("") }
        var (password,setPassword) = rememberSaveable { mutableStateOf("") }
        var (checked,onCheckedChange) = rememberSaveable { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HeaderText(
                text = "EQUISURE",
                modifier = Modifier
                    .padding(vertical = defaultPadding)
                    .align(alignment = Alignment.Start)
            )
            LoginTextField(
                value = email,
                onValueChange = setEmail,
                lableText = "Email",
                leadingIcon = Icons.Default.Email,
                modifier = Modifier.fillMaxWidth()
                )
            
            Spacer(Modifier.height(itemSpacing))

            LoginTextField(
                value = password,
                onValueChange = setPassword,
                lableText = "Password",
                leadingIcon = Icons.Default.Lock,
                modifier = Modifier.fillMaxWidth(),
                keyboardType = KeyboardType.Password,
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(Modifier.height(itemSpacing))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
               Row(
                   horizontalArrangement = Arrangement.Center,
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   Checkbox(checked =checked, onCheckedChange =onCheckedChange )
                   Text(text = "Remember Me") 
               }
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Forgot Password?")
                    
                }
            }
            Spacer(Modifier.height(itemSpacing))

            Button(onClick = {
                navController.navigate("HomeScreen")
                             }, modifier = Modifier.fillMaxWidth()) {
                Text("LOGIN" )




            }
            Spacer(Modifier.height(itemSpacing))

            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment =Alignment.CenterVertically ) {
                
                Text(text = "Don't Have an Account?")
                Spacer(Modifier.width(itemSpacing))
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Register")
                    
                }
                  
            }





//            val keyboardController = LocalSoftwareKeyboardController.current
//            val context = LocalContext.current
//
//
//                keyboardActions = KeyboardActions(onNext = {
//                    keyboardController?.hide()
//                }),
//                shape = RoundedCornerShape(30),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp)
//            )
//
//            OutlinedTextField(
//                value = password,
//                onValueChange = { password = it },
//                label = { Text("Password") },
//                leadingIcon = Icons.Default.Lock,
//                visualTransformation = PasswordVisualTransformation(),
//                keyboardOptions = KeyboardOptions.Default.copy(
//                    imeAction = ImeAction.Done
//                ),
//                shape = RoundedCornerShape(30),
//                keyboardActions = KeyboardActions(onDone = {
//                    keyboardController?.hide()
//                    // Handle login here, for simplicity, just show a toast
//                    Toast.makeText(context, "Logging in...", Toast.LENGTH_SHORT).show()
//                }),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp)
//            )
//
//            Button(
//                onClick = {
//                    // Handle login here, for simplicity, just show a toast
//
//                    navController.navigate("Registration")
//                }) {
//                Text("LOGIN")
//            }
        }
    }
}





