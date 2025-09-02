package com.example.jetpackcomposecource.coreComponants

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri

@Composable
fun PartiallySelectableText() {
    val context = LocalContext.current

    val uriHandler = LocalUriHandler.current

    val text = buildAnnotatedString {
        withStyle(SpanStyle(color = Color.Black)) {
            append("Text before ")   // ❌ not clickable
        }

        pushStringAnnotation("url", "https://www.youtube.com")
        withStyle(SpanStyle(color = Color.Blue)) {
            append("First clickable ")   // ✅ clickable
            append("Second clickable ")  // ✅ clickable
            append("Third clickable")    // ✅ clickable
        }
        pop()

        withStyle(SpanStyle(color = Color.Gray)) {
            append(" Not clickable")     // ❌ not clickable
        }
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        SelectionContainer(
            Modifier.background(color = Color.Transparent),
        ) {


            Column {

                Text("Helloo")
                Text(text = "Text hello")
                DisableSelection {
                    Text("Disable text")
                    Spacer(modifier = Modifier.height(25.dp)) // adds 8dp vertical space

                    Text(
                        text = "Open Google",
                        modifier = Modifier.clickable {
                            val intent =
                                Intent(Intent.ACTION_VIEW, "https://www.google.com".toUri())
                            context.startActivity(intent)
                        }
                    )
                    Spacer(modifier = Modifier.height(25.dp)) //
                    ClickableText(
                        text = text,
                        onClick = { offset ->
                            print("-----??click")
                            text.getStringAnnotations("url", offset, offset)
                                .firstOrNull()?.let { annotation ->
                                    uriHandler.openUri(annotation.item)
                                }
                        }
                    )
                }


            }
        }


    }
}



@Preview(showSystemUi = true)
@Composable
fun PartiallySelectableTextPreview() {
    PartiallySelectableText()
}