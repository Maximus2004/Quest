package com.example.libertex

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(waste: Int, balance: Int, mood: Int) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            Text("расход: ", style = MaterialTheme.typography.h2)
            Text(waste.toString(), style = MaterialTheme.typography.h2)
        }
        Row() {
            Text("баланс: ", style = MaterialTheme.typography.h2)
            Text(balance.toString(), style = MaterialTheme.typography.h2)
        }
        Row() {
            Text("настроение: ", style = MaterialTheme.typography.h2)
            Text(mood.toString(), style = MaterialTheme.typography.h2)
        }
    }
}

@Composable
fun ButtonSubmit(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick, modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(text, Modifier.padding(vertical = 8.dp))
    }
}