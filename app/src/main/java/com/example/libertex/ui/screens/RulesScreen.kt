package com.example.libertex.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.libertex.ButtonSubmit
import com.example.libertex.ui.theme.LibertexTheme

@Composable
fun RulesScreen(onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(10.dp)) {
        Text(text = "Правила", style = MaterialTheme.typography.caption)
        Text(text = "Фишки - это твоё время. Всего 20 фишек, которые ты можешь распределить на сон, работу, отдых и возможности", textAlign = TextAlign.Center)
        Text(text = "Настроение - показатель, который не должен падать ниже 0, иначе вы впадёте в депрессию и програете. Вы должны сами рассчитывать настроение и баланс, их актуальная цифра будет отображаться только после нажатия на кнопку", textAlign = TextAlign.Center)
        Text(text = "Цель игры - обрести финансовую независимость, то есть уменьшить ваш ежемесечный расход до 0 за счёт покупки возможностей (или бизнесов), которые будут приносить пассивный ежемесечный доход", textAlign = TextAlign.Center)
        Text(text = "Распределяй своё время, экспериментируй и хорошей тебе игры!", textAlign = TextAlign.Center)
        ButtonSubmit(text = "Поехали!", onClick = onClick)
    }
}

@Preview
@Composable
fun RulesPreview() {
    LibertexTheme {
        RulesScreen(onClick = {})
    }
}