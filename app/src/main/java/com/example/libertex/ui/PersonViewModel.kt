package com.example.libertex.ui

import androidx.lifecycle.ViewModel
import com.example.libertex.data.PersonUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PersonViewModel : ViewModel() {

    // требуется для того, чтобы uiState был редактируем только из ViewModel
    // StateFlow - горячий поток, который сразу триггерит UI, если меняется его значение
    private val _uiState = MutableStateFlow(PersonUiState())
    val uiState: StateFlow<PersonUiState> = _uiState.asStateFlow()
    var preventRest = 0
    var preventPoss = 0
    var preventSleep = 0
    var preventWork = 0

    fun updateRestChips(chipsRest: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                chips = _uiState.value.chips + preventRest - chipsRest, chipsRest = chipsRest
            )
        }
        preventRest = chipsRest
    }

    fun checkWinOrLose(): Int {
        if (_uiState.value.balance >= 0 && _uiState.value.waste <= 0)
            return 1
        else if (_uiState.value.balance < 0 || _uiState.value.mood < 0 || _uiState.value.chips < 0)
            return 0
        else
            return -1
    }

    fun updatePossChips(chipsPoss: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                chipsPoss = chipsPoss, chips = _uiState.value.chips + preventPoss - chipsPoss
            )
        }
        preventPoss = chipsPoss
    }

    fun updateSleepChips(chipsSleep: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                chipsSleep = chipsSleep, chips = _uiState.value.chips + preventSleep - chipsSleep
            )
        }
        preventSleep = chipsSleep
    }

    fun updateWorkChips(chipsWork: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                chipsWork = chipsWork, chips = _uiState.value.chips + preventWork - chipsWork
            )
        }
        preventWork = chipsWork
    }

    // не стал выносить настроение и баланс в отдеьный ViewModel, потому что они совсм не объёмные
    fun countBalance() {
        _uiState.update { currentState ->
            currentState.copy(balance = _uiState.value.balance + _uiState.value.chipsWork * 1000 - 5000)
        }
    }

    fun decreaseBalance(value: Int) {
        _uiState.update { currentState ->
            currentState.copy(balance = _uiState.value.balance - value)
        }
    }

    fun decreaseWaste(value: Int) {
        _uiState.update { currentState ->
            currentState.copy(waste = _uiState.value.waste - value)
        }
    }

    fun countMood() {
        _uiState.update { currentState ->
            currentState.copy(mood = _uiState.value.mood - _uiState.value.chipsPoss +
                    _uiState.value.chipsSleep * 2 + _uiState.value.chipsRest * 4 - _uiState.value.chipsWork * 2)
        }
    }
}