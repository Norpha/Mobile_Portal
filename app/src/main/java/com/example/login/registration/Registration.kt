package com.example.login.registration

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.login.Login.HeaderText
import com.example.login.Login.LoginTextField
import com.example.login.Login.defaultPadding
import com.example.login.Login.itemSpacing


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Registration(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.secondaryVariant) {

        var (firstName, setFirstname) = rememberSaveable { mutableStateOf("") }
        var (lastName, setLastname) = rememberSaveable { mutableStateOf("") }
        var (email, setEmail) = rememberSaveable { mutableStateOf("") }
        var (password, setPassword) = rememberSaveable { mutableStateOf("") }
        var (confirmPassword, setConfirmPassword) = rememberSaveable { mutableStateOf("") }
        var (agree, OnAgreeChange) = rememberSaveable { mutableStateOf(false) }
        var context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            HeaderText(
                text = "Sign Up",
                modifier = Modifier
                    .padding(vertical = defaultPadding)
                    .align(alignment = Alignment.Start)
            )
            LoginTextField(
                value = firstName,
                onValueChange = setFirstname,
                lableText = "First Name",
                leadingIcon = Icons.Default.Person,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(itemSpacing))
            LoginTextField(
                value = lastName,
                onValueChange = setLastname,
                lableText = "Last Name",
                leadingIcon = Icons.Default.Person,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(itemSpacing))
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
                keyboardType = KeyboardType.Password,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(itemSpacing))
            LoginTextField(
                value = confirmPassword,
                onValueChange = setConfirmPassword,
                lableText = "Confirm Password",
                leadingIcon = Icons.Default.Lock,
                keyboardType = KeyboardType.Password,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(itemSpacing))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val privacyText = "Privacy"
                val policyText = "Policy"
                val annotatedString = buildAnnotatedString {
                    withStyle(SpanStyle(color = MaterialTheme.colors.onBackground)) {
                        append("I Agree with")
                    }
                    append("")
                    withStyle(SpanStyle(color = MaterialTheme.colors.primary)) {
                        pushStringAnnotation(tag = privacyText, privacyText)
                        append(privacyText)
                    }


                    append(" And ")
                    withStyle(SpanStyle(color = MaterialTheme.colors.primary)) {
                        pushStringAnnotation(tag = policyText, policyText)
                        append(policyText)

                    }
                }
                Checkbox(checked = agree, onCheckedChange = OnAgreeChange)
                ClickableText(annotatedString,) { offset ->
                    annotatedString.getStringAnnotations(offset, offset).forEach {
                        when (it.tag) {
                            privacyText -> {
                                Toast.makeText(context, "Privacy Text Clicked", Toast.LENGTH_SHORT)
                                    .show()
                            }

                            policyText -> {
                                Toast.makeText(context, "Policy Text Clicked", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }
                }

            }

            Spacer(Modifier.height(defaultPadding + 8.dp))

            Button(onClick = {
                Toast.makeText(context, "Logging in...", Toast.LENGTH_SHORT).show()
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Sign Up")


            }
            Spacer(Modifier.height(defaultPadding))

        }
    }
}



















//        {
//            var email by remember { mutableStateOf(TextFieldValue()) }
//            var firstName by remember { mutableStateOf(TextFieldValue()) }
//            var Surname by remember { mutableStateOf(TextFieldValue()) }
//            var Telephone by remember { mutableStateOf(TextFieldValue()) }
//            val keyboardController = LocalSoftwareKeyboardController.current
//            val context = LocalContext.current
//
//            OutlinedTextField(
//                value = email,
//                onValueChange = { email = it },
//                label = { Text("Email") },
//                keyboardOptions = KeyboardOptions.Default.copy(
//                    imeAction = ImeAction.Next
//                ),
//                keyboardActions = KeyboardActions(onNext = {
//                    keyboardController?.hide()
//                }),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp)
//            )
//
//            OutlinedTextField(
//                value = Telephone,
//                onValueChange = { Telephone = it },
//                label = { Text("Phone") },
//                visualTransformation = PasswordVisualTransformation(),
//                keyboardOptions = KeyboardOptions.Default.copy(
//                    imeAction = ImeAction.Done
//                ), keyboardActions = KeyboardActions(onNext = {
//                    keyboardController?.hide()
//                }),
//
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp)
//            )
//
//            OutlinedTextField(
//                value = firstName,
//                onValueChange = { firstName = it },
//                label = { Text("First Name") },
//                visualTransformation = PasswordVisualTransformation(),
//                keyboardOptions = KeyboardOptions.Default.copy(
//                    imeAction = ImeAction.Done
//                ), keyboardActions = KeyboardActions(onNext = {
//                    keyboardController?.hide()
//                }),
//
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp)
//            )
//
//            OutlinedTextField(
//                value = Surname,
//                onValueChange = { Surname = it },
//                label = { Text("Surname") },
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = Color.Blue, // Change focused border color here
//                    unfocusedBorderColor = Color.Gray, // Change unfocused border color here
//                    cursorColor = Color.Green // Change cursor color here
//                ),
//                visualTransformation = PasswordVisualTransformation(),
//                keyboardOptions = KeyboardOptions.Default.copy(
//                    imeAction = ImeAction.Done
//                ), keyboardActions = KeyboardActions(onNext = {
//                    keyboardController?.hide()
//                }),
//
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp)
//            )
//
//            Button(
//                onClick = {
//                    // Handle login here, for simplicity, just show a toast
//                    //colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
//                    Toast.makeText(context, "Logging in...", Toast.LENGTH_SHORT).show()
//                },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp),
//                colors = ButtonDefaults.buttonColors(backgroundColor =Color.Blue)
//            ) {
//                Text("REGISTER")
//            }
//        }

