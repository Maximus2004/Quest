package com.example.libertex.ui

import androidx.lifecycle.ViewModel
import com.example.libertex.data.RestUiState
import com.example.libertex.data.Rest
import com.example.libertex.data.restRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RestViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(RestUiState())
    val uiState: StateFlow<RestUiState> = _uiState.asStateFlow()

    fun generateRandomRests(amountChips: Int) {
        val temp = mutableListOf<Rest>()
        for (i in 1..amountChips) {
            temp.add(restRepo[(0..9).random()])
        }
        _uiState.update { currentState ->
            currentState.copy(rests = temp)
        }
    }

    fun countWaste(): Int {
        var temp = 0
        for (rest in _uiState.value.rests) {
            temp += rest.cost
        }
        return temp
    }
}