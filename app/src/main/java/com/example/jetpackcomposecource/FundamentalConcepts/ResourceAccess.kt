package com.example.jetpackcomposecource.FundamentalConcepts


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecource.R

@Composable
fun AccessStringResource() {

    Box(

        modifier = Modifier.fillMaxSize(),

        contentAlignment = Alignment.Center


    ) {

        Column {
            Text(
                style = TextStyle(color = colorResource(R.color.orange)),
                text = stringResource(R.string.fruit),
            )
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp),
                    contentScale = ContentScale.None,
                    painter = painterResource(R.drawable.puma), contentDescription = "Doctor Image"
                )
            }
        }


    }


}


@Preview(showSystemUi = true)
@Composable
fun PreviewAccessStringResource() {
    AccessStringResource()
}