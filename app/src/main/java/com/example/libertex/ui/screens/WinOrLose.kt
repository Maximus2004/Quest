package com.example.libertex

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.libertex.ui.theme.LibertexTheme

@Composable
fun Win() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(
            "Ты победил!!!",
            style = MaterialTheme.typography.h1
        )
    }
}

@Composable
fun Lose() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(
            "Ты проиграл!!!",
            style = MaterialTheme.typography.h1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LosePreview() {
    LibertexTheme() {
        Lose()
    }
}