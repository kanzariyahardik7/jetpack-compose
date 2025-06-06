package com.example.jetpackcomposecource.FundamentalConcepts

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecource.R

@Composable
fun AccessStringResource() {

    Column {
        Box(

            modifier = Modifier.height(100.dp),

            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.app_name),
                color = colorResource(R.color.purple_500)
            )

        }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(painter = painterResource(R.drawable.doctor), contentDescription = "Doctor Image")
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewAccessStringResource() {
    AccessStringResource()
}