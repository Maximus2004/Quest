package com.example.libertex.ui

import androidx.lifecycle.ViewModel
import com.example.libertex.data.PossUiState
import com.example.libertex.data.Poss
import com.example.libertex.data.possRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PossViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(PossUiState())
    val uiState: StateFlow<PossUiState> = _uiState.asStateFlow()

    fun generateRandomPosts(amountChips: Int) {
        val temp = mutableListOf<Poss>()
        for (i in 1..amountChips) {
            temp.add(possRepo[(0..9).random()])
        }
        _uiState.update { currentState ->
            currentState.copy(posses = temp)
        }
    }
}