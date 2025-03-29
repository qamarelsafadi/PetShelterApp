package com.qamar.petshelter.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.qamar.petshelter.data.model.Animal
import com.qamar.petshelter.data.model.AnimalModel
import com.qamar.petshelter.data.model.Category
import com.qamar.petshelter.ui.home.state.HomeUiState
import com.qamar.petshelter.ui.home.ui.AnimalList
import com.qamar.petshelter.ui.home.ui.CategoriesSection
import com.qamar.petshelter.ui.home.ui.HeaderSection

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel { HomeViewModel() }
) {
    val categoryList by viewModel.categoriesState.collectAsStateWithLifecycle()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val state = uiState) {
        is HomeUiState.Loading -> {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is HomeUiState.Success -> {
            HomeScreenUi(viewModel, categoryList, state.animalList)
        }

        is HomeUiState.Error -> {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(state.errorMessage)
            }
        }
    }
}

@Composable
private fun HomeScreenUi(
    viewModel: HomeViewModel,
    categoryList: List<Category?>?,
    animalList: List<AnimalModel>?
) {
    Column(
        Modifier.fillMaxSize()
            .background(Color.White)
            .statusBarsPadding()
            .padding(horizontal = 16.dp)
    ) {
        HeaderSection()
        Spacer(Modifier.height(38.dp))
        CategoriesSection(
            selectedItem = viewModel.selectedItem.value,
            categoryList = categoryList,
            onClick = viewModel::selectCategory
        )
        Spacer(Modifier.height(28.dp))
        AnimalList(animalList)
    }
}
