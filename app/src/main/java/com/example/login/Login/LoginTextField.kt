package com.example.login.Login

import android.graphics.drawable.Icon
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun  LoginTextField(
    modifier: Modifier = Modifier,
    value:String,
    onValueChange:(String) -> Unit,
    lableText:String,
    leadingIcon:ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None
){
  
    OutlinedTextField(
        modifier = modifier,
        value =value,
        onValueChange =onValueChange,
        label = { Text(lableText)},
        leadingIcon = {if (leadingIcon !=null) Icon(imageVector = leadingIcon,null)},
        shape = RoundedCornerShape(30)
    )
    
}