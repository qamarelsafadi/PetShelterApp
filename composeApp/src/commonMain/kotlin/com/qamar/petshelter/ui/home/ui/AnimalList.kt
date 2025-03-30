package com.qamar.petshelter.ui.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.qamar.petshelter.data.model.Animal
import com.qamar.petshelter.data.model.AnimalModel
import com.qamar.petshelter.theme.categoryTextColor
import com.qamar.petshelter.theme.rounded16
import io.kamel.core.ExperimentalKamelApi
import io.kamel.image.KamelImage
import io.kamel.image.KamelImageBox
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import petshelterap.composeapp.generated.resources.Res
import petshelterap.composeapp.generated.resources.animal1
import petshelterap.composeapp.generated.resources.star
import petshelterap.composeapp.generated.resources.star_default


@Composable
fun AnimalList(animalList: List<AnimalModel>?) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        items(animalList ?: listOf()) {
            AnimalCard(it)
        }
    }
}

@Composable
fun AnimalCard(animal: AnimalModel) {
    Card(
        shape = rounded16,
        backgroundColor = Color.White,
        elevation = 4.dp,
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            AnimalImage(animal)
            AnimalInfo(animal)
        }
    }
}

@Composable
fun AnimalInfo(animal: AnimalModel) {
    Column(
        Modifier.padding(horizontal = 10.dp).padding(bottom = 30.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                animal.name ?: "",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = categoryTextColor
                ),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Start,
                maxLines = 2
            )
            Text(
                "${animal.heightCm} CM",
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = categoryTextColor.copy(alpha = 0.70f)
                ),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End

            )
        }
        Text(
            animal.family ?: "",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = categoryTextColor.copy(alpha = 0.70f)
            )
        )
    }
}

@Composable
fun AnimalImage(animal: AnimalModel) {
    var iconValue by remember {
        mutableStateOf(Res.drawable.star_default)
    }


    Box(
        Modifier.fillMaxWidth()
            .height(116.dp)
    ) {
        KamelImage(
            resource = { asyncPainterResource(animal.image ?: "") },
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            onFailure = { println(it) },
            contentScale = ContentScale.Crop
        )
        Icon(
            painter = painterResource(iconValue),
            modifier = Modifier
                .padding(top = 8.dp, end = 7.dp)
                .clip(CircleShape)
                .background(color = Color.White.copy(0.25f), CircleShape)
                .padding(5.dp)
                .align(Alignment.TopEnd)
                .clickable {
                    iconValue = iconValue.getStarIcon()
                },
            contentDescription = "Star",
            tint = Color.Unspecified
        )
    }
}

private fun DrawableResource.getStarIcon() =
    if (this == Res.drawable.star_default)
        Res.drawable.star
    else Res.drawable.star_default

