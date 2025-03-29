package com.qamar.petshelter.ui.home.state

import com.qamar.petshelter.data.model.AnimalModel

sealed class HomeUiState {
    data object Loading : HomeUiState()
    data class Error(val errorMessage: String) : HomeUiState()
    data class Success(val animalList: List<AnimalModel>) : HomeUiState()
}