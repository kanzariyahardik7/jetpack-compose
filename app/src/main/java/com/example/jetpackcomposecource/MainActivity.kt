package com.example.jetpackcomposecource

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.jetpackcomposecource.coreComponants.ButtonSample
import com.example.jetpackcomposecource.coreComponants.PartiallySelectableText
import com.example.jetpackcomposecource.coreComponants.ShowImageFunc
import com.example.jetpackcomposecource.coreComponants.SimpleOutlinedTextFieldSample

import com.example.jetpackcomposecource.ui.theme.JetpackComposeCourceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCourceTheme { ShowImageFunc() }
        }
    }
}