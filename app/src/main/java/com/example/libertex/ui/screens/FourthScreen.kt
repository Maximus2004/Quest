package com.example.libertex.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.libertex.ButtonSubmit
import com.example.libertex.TopBar
import com.example.libertex.data.Poss

@Composable
fun FourthScreen(
    onClick: () -> Unit,
    posses: List<Poss>,
    balance: Int,
    mood: Int,
    waste: Int,
    onClickItem: (Int, Int) -> Unit
) {
    Scaffold(topBar = { TopBar(waste = waste, balance = balance, mood = mood) }) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp)
        ) {
            items(posses) { poss ->
                PossCard(poss = poss, onClickItem = onClickItem)
            }
            item() {
                ButtonSubmit(text = "Перейти дальше", onClick = onClick)
            }
        }
    }
}

@Composable
fun PossCard(poss: Poss, onClickItem: (Int, Int) -> Unit) {
    Card(elevation = 7.dp) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = poss.title,
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(top = 10.dp)
            )
            Row(modifier = Modifier.padding(10.dp)) {
                Text(text = "Стоимость: ", style = MaterialTheme.typography.h2)
                Text(
                    text = poss.cost.toString(),
                    style = MaterialTheme.typography.h2
                )
            }
            Row() {
                Text(text = "Выручка: ", style = MaterialTheme.typography.h2)
                Text(
                    text = poss.income.toString(),
                    style = MaterialTheme.typography.h2
                )
            }
            Button(
                onClick = { onClickItem(poss.cost, poss.income) }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text("Выбрать", Modifier.padding(vertical = 8.dp))
            }
        }
    }
}