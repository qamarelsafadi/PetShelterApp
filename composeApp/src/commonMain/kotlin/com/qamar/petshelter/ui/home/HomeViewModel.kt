package com.qamar.petshelter.ui.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qamar.petshelter.data.model.Animal
import com.qamar.petshelter.data.model.AnimalModel
import com.qamar.petshelter.data.model.Category
import com.qamar.petshelter.data.remote.Ktor
import com.qamar.petshelter.data.remote.Ktor.getAnimalList
import com.qamar.petshelter.ui.home.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import petshelterap.composeapp.generated.resources.Res
import petshelterap.composeapp.generated.resources.cat1
import petshelterap.composeapp.generated.resources.cat2
import petshelterap.composeapp.generated.resources.cat3

class HomeViewModel() : ViewModel() {

    private val _categoriesState: MutableStateFlow<List<Category?>?> = MutableStateFlow(null)
    val categoriesState: StateFlow<List<Category?>?> = _categoriesState.asStateFlow()
    var selectedItem = mutableStateOf("All")
    private val _animalState: MutableStateFlow<List<Animal>?> = MutableStateFlow(null)
    val animalState: StateFlow<List<Animal>?> = _animalState.asStateFlow()

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private var myAnimalList = listOf<AnimalModel>()

    init {
        fetchAnimalList()
        selectCategory("All")
    }

    fun getCategoryList() = viewModelScope.launch {
        val categoryImagesList = listOf(Res.drawable.cat1, Res.drawable.cat2, Res.drawable.cat3)
        val categoryList = myAnimalList.distinctBy { it.placeOfFound }.map {
            it.placeOfFound?.let { placeOfFound ->
                Category(name = placeOfFound, image = categoryImagesList.random())
            }
        }.toMutableList()
        categoryList.add(0, Category(name = "All", image = Res.drawable.cat3))
        _categoriesState.emit(categoryList)
    }

    private fun getAnimalList(categoryName: String) = viewModelScope.launch {
        val animalList = if (categoryName != "All") {
            myAnimalList.filter {
                it.placeOfFound == categoryName
            }
        } else myAnimalList
        _uiState.emit(HomeUiState.Success(animalList))
    }

    fun selectCategory(name: String) {
        selectedItem.value = name
        getAnimalList(categoryName = name)
    }

    private fun fetchAnimalList() {
        viewModelScope.launch {
            try {
                val animalList = Ktor.client.getAnimalList()
                myAnimalList = animalList
                getCategoryList()
                _uiState.emit(HomeUiState.Success(myAnimalList))
            } catch (e: Exception) {
                _uiState.emit(HomeUiState.Error(errorMessage = e.message ?: ""))
            }
        }
    }
}