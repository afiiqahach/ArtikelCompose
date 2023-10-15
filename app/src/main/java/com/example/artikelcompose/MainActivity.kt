package com.example.artikelcompose

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artikelcompose.ui.theme.ArtikelComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtikelComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtikelCompose()
                }
            }
        }
    }
}

@Composable
fun ArtikelCompose() {
    ArtikelCard (
        title = stringResource(R.string.title_jetpack_compose_tutorial),
        shortDesc = stringResource(R.string.compose_short_desc),
        longDesc = stringResource(R.string.compose_long_desc),
        imagePainter = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
private fun ArtikelCard(
    title: String,
    shortDesc: String,
    longDesc: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier
) {
    Column {
        Image(painter = imagePainter, contentDescription = null)
        Text(
            text = title,
            modifier = Modifier.padding(15.dp),
            fontSize = 24.sp
        )
        Text(
            text = shortDesc,
            modifier = Modifier.padding(start = 15.dp, end = 15.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = longDesc,
            modifier = Modifier.padding(15.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)

@Composable
fun ArtikelComposePreview() {
    ArtikelComposeTheme {
        ArtikelCompose()
    }
}