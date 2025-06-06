package com.example.jetpackcomposecource.FundamentalConcepts

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposecource.ui.theme.Purple40


@Composable
fun Greeting() {
    Column {

        Text(text = "Hello Jetpack Compose", color = Purple40)
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    Greeting()
}


