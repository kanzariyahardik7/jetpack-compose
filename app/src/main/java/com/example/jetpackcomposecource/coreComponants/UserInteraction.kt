package com.example.jetpackcomposecource.coreComponants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun PartiallySelectableText() {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        SelectionContainer(
            Modifier.background(color = Color.Cyan),
        ) {


            Column {

                Text("Helloo")
                Text(text = "Text hello")
                DisableSelection {
                    Text("Disable text")
                }
            }
        }
    }
}


@Composable
fun AnnotatedStringWithListenerSample() {

    val uriHandler = LocalUriHandler.current
    val link = "https://www.youtube.com"


    val annotatedDescription = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Black)) {
            append("Build better apps faster with")
        }
        pushStringAnnotation(tag = "Clickable", annotation = link)
        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        ) {
            append(" Jetpack Compose")
        }
        pop()
    }

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        ClickableText(
            text = annotatedDescription,
            onClick = { offset ->
                annotatedDescription.getStringAnnotations(
                    tag = "Clickable",
                    start = offset,
                    end = offset
                )
                    .firstOrNull()?.let { annotation ->
                        uriHandler.openUri(annotation.item)
                    }
            }
        )
    }

}


@Preview
@Composable
fun PartiallySelectableTextPreview() {
    AnnotatedStringWithListenerSample()
}