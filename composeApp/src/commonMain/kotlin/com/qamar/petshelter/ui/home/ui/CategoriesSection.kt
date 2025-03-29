package com.qamar.petshelter.ui.home.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qamar.petshelter.data.model.Category
import com.qamar.petshelter.theme.buttonBG
import com.qamar.petshelter.theme.categoryTextColor
import com.qamar.petshelter.theme.rounded100
import org.jetbrains.compose.resources.painterResource
import petshelterap.composeapp.generated.resources.Res
import petshelterap.composeapp.generated.resources.cat2

@Composable
fun CategoriesSection(
    selectedItem: String,
    categoryList: List<Category?>?,
    onClick: (String) -> Unit
) {

    LazyRow(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
    ) {
        itemsIndexed(categoryList ?: listOf()) { index, item ->
            item?.let {
                CategoryItem(
                    item = item,
                    isSelected = item.name == selectedItem,
                    onClick = {
                        onClick(item.name)
                    }
                )
            }
        }
    }
}

@Composable
fun CategoryItem(item: Category, isSelected: Boolean, onClick: () -> Unit) {

    val backgroundColor = animateColorAsState(
        if (isSelected)
            buttonBG
        else Color.White
    )
    val borderColor = animateColorAsState(
        if (isSelected)
            buttonBG
        else Color.Black.copy(alpha = 0.08f)
    )
    val textColor = animateColorAsState(
        if (isSelected)
            Color.White
        else categoryTextColor
    )

    Row(
        Modifier.height(52.dp)
            .background(color = backgroundColor.value, rounded100)
            .border(width = 1.dp, color = borderColor.value, rounded100)
            .clip(rounded100)
            .padding(10.dp)
            .padding(end = 14.dp)
            .clickable {
                onClick()
            },
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(item.image),
            modifier = Modifier.clip(CircleShape)
                .size(32.dp),
            contentDescription = "Category1"
        )

        Text(
            item.name, style = TextStyle(
                fontSize = 16.sp,
                color = textColor.value
            )
        )
    }
}
