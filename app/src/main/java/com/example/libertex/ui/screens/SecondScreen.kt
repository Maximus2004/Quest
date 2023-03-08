package com.example.libertex.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.libertex.ButtonSubmit
import com.example.libertex.TopBar
import com.example.libertex.ui.theme.LibertexTheme

@Composable
fun SecondScreen(
    balance: Int,
    mood: Int,
    waste: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(topBar = { TopBar(balance = balance, mood = mood, waste = waste) }, modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 0.dp)
        ) {
            Text(
                text = "Вы хорошо поработали сегодня!",
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center
            )
            Text(
                text = "К сожалению, придётся потратить 5000 на повседневные расходы и баланс составит:",
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center
            )
            Text(
                text = balance.toString(),
                style = MaterialTheme.typography.h2,
            )
            ButtonSubmit(text = "Получить бабки", onClick = onClick)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SecondScreenPreview() {
    LibertexTheme() {
        SecondScreen(onClick = {}, balance = 0, mood = 0, waste = 0)
    }
}