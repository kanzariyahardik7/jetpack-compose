package com.example.jetpackcomposecource

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.jetpackcomposecource.FundamentalConcepts.AccessStringResource
import com.example.jetpackcomposecource.FundamentalConcepts.Greeting
import com.example.jetpackcomposecource.coreComponants.AnnotatedStringWithListenerSample
import com.example.jetpackcomposecource.templete.SubscriptionScreen
import com.example.jetpackcomposecource.ui.theme.JetpackComposeCourceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCourceTheme { SubscriptionScreen() }
        }
    }
}