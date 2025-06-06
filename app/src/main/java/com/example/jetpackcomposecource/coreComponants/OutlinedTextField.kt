package com.example.jetpackcomposecource.coreComponants

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SimpeOutlinedTextFieldSample() {

    var text by remember { mutableStateOf("") }

    val rainbowColros =
        listOf(Color.Red, Color.Cyan, Color.Yellow, Color.Green, Color.Blue)

    val brush = remember { Brush.linearGradient(colors = rainbowColros) }


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        TextField(value = text, onValueChange = { text = it }, textStyle = TextStyle(brush = brush))

//        OutlinedTextField(
//            value = text,
//            onValueChange = { text = it },
//            label = { Text(text = "Lable") })
    }

}


@Composable
fun PasswordTextField() {
    var password by rememberSaveable {
        mutableStateOf("")
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        TextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(
                    "Enter Password"
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }

}


@Preview(showSystemUi = true)
@Composable
fun SimpeOutlinedTextFieldSamplePreview() {
    PasswordTextField()
}