package com.example.jetpackcomposecource.coreComponants

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext


@Composable

fun ButtonSample() {
    val context = LocalContext.current


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {

            //Filled button
            Button(
                onClick = {
                    Toast.makeText(context, "Button is clicked", Toast.LENGTH_SHORT).show()
                },

                ) { Text(text = "Button") }

            //Tonal Button
            FilledTonalButton(onClick = {
                Toast.makeText(
                    context,
                    "FilledTonalButton is clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }) { Text(text = "FilledTonalButton") }

            //Outlined Button
            OutlinedButton(onClick = {
                Toast.makeText(
                    context,
                    "OutlinedButton is clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }) { Text(text = "OutlinedButton") }

            //ElevatedButton
            ElevatedButton (onClick = {
                Toast.makeText(
                    context,
                    "ElevatedButton is clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }) { Text(text = "ElevatedButton") }

            //TextButton
            TextButton (onClick = {
                Toast.makeText(
                    context,
                    "TextButton is clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }) { Text(text = "TextButton") }
        }

    }
}