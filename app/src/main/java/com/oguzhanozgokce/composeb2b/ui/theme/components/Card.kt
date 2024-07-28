package com.oguzhanozgokce.composeb2b.ui.theme.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.oguzhanozgokce.composeb2b.model.Item

@Composable
fun ItemCard(
    item: Item,
    modifier: Modifier = Modifier
) {
    var isClicked by remember { mutableStateOf(false) }

    val backgroundColor = if (isClicked) Color.Red else Color.Green

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { isClicked = !isClicked },
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = item.title,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
            Text(text =item.description,
                style = MaterialTheme.typography.bodyMedium,
//                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun ItemList( modifier: Modifier = Modifier, items: List<Item>) {
    LazyColumn(modifier = modifier) {
        items(items) { item ->
            ItemCard(item = item)
        }
    }
}

