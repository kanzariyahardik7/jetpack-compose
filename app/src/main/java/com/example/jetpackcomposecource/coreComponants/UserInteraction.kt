package com.example.jetpackcomposecource.coreComponants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview

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

    Text(buildAnnotatedString {
        append("Build Better apps faster with")
        val link = pushStringAnnotation(
            tag = "URL",
            annotation = "https://www.youtube.com"
        )

    })
}


@Preview
@Composable
fun PartiallySelectableTextPreview() {
    PartiallySelectableText()
}