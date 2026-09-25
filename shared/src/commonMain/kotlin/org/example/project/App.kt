package org.example.project

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val newsCount = remember {NewsCount()}
        val read by newsCount.readCount.collectAsState()

        var platform = getPlatform().name
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Halo, Fadilla")
            Text("NIM : 124140136")
            Text("Platform : $platform")
            Text("Berita dibaca: $read")
        }

        LaunchedEffect(Unit){
            showNews(newsCount)
        }
    }
}