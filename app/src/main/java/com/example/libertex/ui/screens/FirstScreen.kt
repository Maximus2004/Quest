package com.example.libertex.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.libertex.ButtonSubmit
import com.example.libertex.R
import com.example.libertex.TopBar
import com.example.libertex.ui.theme.LibertexTheme

@Composable
fun FillText(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.size(70.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        textStyle = MaterialTheme.typography.button,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun FirstScreen(
    onChangeWork: (String) -> Unit,
    onChangePoss: (String) -> Unit,
    onChangeSleep: (String) -> Unit,
    onChangeRest: (String) -> Unit,
    workValue: String,
    possValue: String,
    sleepValue: String,
    restValue: String,
    onClick: () -> Unit,
    chips: String,
    balance: Int,
    mood: Int,
    waste: Int,
    modifier: Modifier = Modifier
) {
    Scaffold(topBar = { TopBar(balance = balance, mood = mood, waste = waste) }, modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(bottom = 10.dp)
            ) {
                Text(text = "Оставшиеся фишки: ")
                Text(text = chips)
            }
            Box(contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = null
                )
                Column() {
                    Row() {
                        Spacer(modifier = Modifier.weight(1f))
                        FillText(workValue, onValueChange = onChangeWork)
                        FillText(restValue, onValueChange = onChangeRest)
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    Row() {
                        Spacer(modifier = Modifier.weight(1f))
                        FillText(possValue, onValueChange = onChangePoss)
                        FillText(sleepValue, onValueChange = onChangeSleep)
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
            Text(text = "Синий - фишки на работу (-2 настроения)", color = Color.Blue)
            Text(text = "Красный - фишки на отдых (+4 настроения)", color = Color.Red)
            Text(text = "Зеленый - фишки на сон (+2 настроения)", color = Color.Green)
            Text(text = "Фиол - фишки на возможности (-1 настроение)", color = Color.Magenta)
            ButtonSubmit(text = "Начать игру", onClick = onClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LibertexTheme {
        FirstScreen(
            onClick = {},
            onChangePoss = {},
            onChangeRest = {},
            onChangeSleep = {},
            onChangeWork = {},
            possValue = "",
            sleepValue = "",
            restValue = "",
            workValue = "",
            chips = "20",
            waste = 0,
            mood = 0,
            balance = 0
        )
    }
}