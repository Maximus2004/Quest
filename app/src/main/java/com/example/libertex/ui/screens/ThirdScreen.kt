package com.example.libertex.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.libertex.ButtonSubmit
import com.example.libertex.TopBar
import com.example.libertex.data.Rest
import com.example.libertex.data.restRepo
import com.example.libertex.ui.theme.LibertexTheme

@Composable
fun ThirdScreen(
    rests: List<Rest>,
    onClick: () -> Unit,
    balance: Int,
    mood: Int,
    waste: Int,
) {
    Scaffold(topBar = { TopBar(balance = balance, mood = mood, waste = waste) }) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp)
        ) {
            items(rests) { rest ->
                ItemCard(rest = rest)
            }
            item {
                ButtonSubmit(text = "Перейти далее", onClick = onClick)
            }
        }
    }
}

@Composable
fun ItemCard(rest: Rest) {
    Card(elevation = 7.dp) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.padding(top = 10.dp)) {
                Text(text = "Стоимость ", style = MaterialTheme.typography.h1)
                Text(text = rest.cost.toString(), style = MaterialTheme.typography.h1)
            }
            Text(
                text = rest.description,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThirdScreenPreview() {
    LibertexTheme() {
        ThirdScreen(
            rests = restRepo,
            onClick = {},
            mood = 0,
            waste = 0,
            balance = 0
        )
    }
}