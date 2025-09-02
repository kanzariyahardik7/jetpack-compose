@file:OptIn(ExperimentalFoundationApi::class)

package com.example.jetpackcomposecource.coreComponants

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp


@Composable
fun SimpleText() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(
                text = "Hello Jetpack Compose",
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                style = TextStyle(shadow = Shadow(color = Color.Red, blurRadius = 10f))
            )

            val rainbowColors =
                listOf(Color.Blue, Color.Cyan, Color.Yellow, Color.Green, Color.Cyan, Color.Magenta)


            Text(text = buildAnnotatedString {
                append("Do not Allow people to dim your shine ")
                withStyle(SpanStyle(brush = Brush.linearGradient(colors = rainbowColors))) {
                    append(
                        "because they are blinded."
                    )
                }
                append(" tell them to put some sunglasses on")

            })
            Text(
                text = "Hardik Kanzariya experimenting with jetpack compose".repeat(12),
                maxLines = 2,
//modifier = Modifier.basicMarquee(),
                fontSize = 25.sp, overflow = TextOverflow.Ellipsis
            )
        }
    }

}





