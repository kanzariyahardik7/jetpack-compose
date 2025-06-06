@file:OptIn(ExperimentalFoundationApi::class)

package com.example.jetpackcomposecource.coreComponants

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp


@Composable
fun SimpleText() {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Text(
            text = "Hello World",
            color = Color.Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            style = TextStyle(shadow = Shadow(color = Color.Red, blurRadius = 10f))
        )
    }

}

@Composable
fun ColorfulText() {

    val rainbowColros =
        listOf(Color.Blue, Color.Cyan, Color.Yellow, Color.Green, Color.Cyan, Color.Magenta)
    Text(text = buildAnnotatedString {
        append("Do not Allow people to dim your shine \n")
        withStyle(SpanStyle(brush = Brush.linearGradient(colors = rainbowColros))) { append("because they are blinded.") }
        append("\n tell them to put some sunglasses on")

    })
}


@Composable
fun ScrollableText() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Navigate to the file in which we have to format our code and then click on the shortcut key as Ctrl+Shift+Alt+L after clicking this key you will get to see the below dialog on your screen.".repeat(
                50
            ),
            maxLines = 2,
//            modifier = Modifier.basicMarquee(),
            fontSize = 50.sp, overflow = TextOverflow.Ellipsis
        )

    }

}


@Preview(showSystemUi = true)
@Composable
fun SimpleTextPreview() {
    ScrollableText()
}

