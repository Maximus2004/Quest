package com.example.libertex.data

data class PossUiState(
    val cost: Int = 0,
    val income: Int = 0,
    val posses: List<Poss> = listOf()
)