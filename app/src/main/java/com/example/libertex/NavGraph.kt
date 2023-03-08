package com.example.libertex

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import  androidx.lifecycle.viewmodel.compose.viewModel
import com.example.libertex.ui.PersonViewModel
import com.example.libertex.ui.PossViewModel
import com.example.libertex.ui.RestViewModel
import com.example.libertex.ui.screens.*

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModelPerson: PersonViewModel = viewModel(),
    viewModelRest: RestViewModel = viewModel(),
    viewModelPoss: PossViewModel = viewModel()
) {
    // условно вытаскиеваем uiState из ViewModel и присваиваем её новой переменной
    val uiStatePerson by viewModelPerson.uiState.collectAsState()
    val uiStateRest by viewModelRest.uiState.collectAsState()
    val uiStatePoss by viewModelPoss.uiState.collectAsState()
    NavHost(
        navController = navController,
        startDestination = "RulesScreen",
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = "FirstScreen") {
            FirstScreen(
                onClick = {
                    viewModelPerson.countMood()
                    viewModelPerson.countBalance()
                    navController.navigate("SecondScreen")
                },
                onChangeWork = {
                    viewModelPerson.updateWorkChips(
                        if (it.isEmpty())
                            0
                        else
                            it.toInt()
                    )
                },
                onChangeRest = {
                    viewModelPerson.updateRestChips(
                        if (it.isEmpty())
                            0
                        else
                            it.toInt()
                    )
                },
                onChangeSleep = {
                    viewModelPerson.updateSleepChips(
                        if (it.isEmpty())
                            0
                        else
                            it.toInt()
                    )
                },
                onChangePoss = {
                    viewModelPerson.updatePossChips(
                        if (it.isEmpty())
                            0
                        else
                            it.toInt()
                    )
                },
                possValue = uiStatePerson.chipsPoss.toString(),
                sleepValue = uiStatePerson.chipsSleep.toString(),
                restValue = uiStatePerson.chipsRest.toString(),
                workValue = uiStatePerson.chipsWork.toString(),
                chips = uiStatePerson.chips.toString(),
                balance = uiStatePerson.balance,
                mood = uiStatePerson.mood,
                waste = uiStatePerson.waste
            )
        }
        composable(route = "SecondScreen") {
            SecondScreen(
                onClick = {
                    viewModelRest.generateRandomRests(uiStatePerson.chipsRest)
                    navController.navigate("ThirdScreen")
                },
                balance = uiStatePerson.balance,
                mood = uiStatePerson.mood,
                waste = uiStatePerson.waste
            )
        }
        composable(route = "ThirdScreen") {
            ThirdScreen(
                rests = uiStateRest.rests,
                onClick = {
                    viewModelPerson.decreaseBalance(viewModelRest.countWaste())
                    viewModelPoss.generateRandomPosts(uiStatePerson.chipsPoss)
                    navController.navigate("FourthScreen")
                },
                balance = uiStatePerson.balance,
                mood = uiStatePerson.mood,
                waste = uiStatePerson.waste
            )
        }
        composable(route = "FourthScreen") {
            FourthScreen(
                onClick = {
                    if (viewModelPerson.checkWinOrLose() == 1)
                        navController.navigate("WinScreen")
                    else if (viewModelPerson.checkWinOrLose() == 0)
                        navController.navigate("LoseScreen")
                    else
                        navController.navigate("FirstScreen")
                },
                posses = uiStatePoss.posses,
                balance = uiStatePerson.balance,
                mood = uiStatePerson.mood,
                waste = uiStatePerson.waste,
                onClickItem = { cost, income ->
                    viewModelPerson.decreaseBalance(cost)
                    viewModelPerson.decreaseWaste(income)
                    if (viewModelPerson.checkWinOrLose() == 1)
                        navController.navigate("WinScreen")
                    else if (viewModelPerson.checkWinOrLose() == 0)
                        navController.navigate("LoseScreen")
                    else
                        navController.navigate("FirstScreen")
                }
            )
        }
        composable(route = "WinScreen") {
            Win()
        }
        composable(route = "LoseScreen") {
            Lose()
        }
        composable(route = "RulesScreen") {
            RulesScreen(onClick = { navController.navigate("FirstScreen") })
        }
    }
}