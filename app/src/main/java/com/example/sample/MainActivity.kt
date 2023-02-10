package com.example.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sample.ui.theme.SampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleTheme {
                Sample()
            }
        }
    }
}


@Composable
fun Sample(fiyat : Int) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {



        Image(
            painter = painterResource(id = R.drawable.spiderman),
            contentDescription = null,
            Modifier
                .padding(0.dp)
                .fillMaxWidth()
                .height(200.dp)
        )

        Column() {
            Text(text ="En ucuz oyun $fiyat")
            Text(text ="En ucuz oyun")
            Text(text ="En ucuz oyun")
            Text(text ="En ucuz oyun")
            Text(text ="En ucuz oyun")
            Text(text ="En ucuz oyun")
            Text(text ="En ucuz oyun")

            Image(
                painter = painterResource(id = R.drawable.spiderman),
                contentDescription = null,
                Modifier
                    .padding(0.dp)
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }





    }
}

@Preview(showBackground = true)
@Preview("Article screen navrail PİXEL XL", device = Devices.PIXEL_XL)
@Composable
fun DefaultPreview() {
    SampleTheme {

    }
}