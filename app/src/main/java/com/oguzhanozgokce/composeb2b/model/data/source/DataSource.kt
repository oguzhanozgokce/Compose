package com.oguzhanozgokce.composeb2b.model.data.source

import com.oguzhanozgokce.composeb2b.model.Item

class DataSource {

    fun loadItems(): List<Item> {
        return listOf(
            Item(
                title = "Item 1",
                description = "Description 1"
            ),
            Item(
                title = "Item 2",
                description = "Description 2"
            ),
            Item(
                title = "Item 3",
                description = "Description 3"
            ),
            Item(
                title = "Item 4",
                description = "Description 4"
            ),
            Item(
                title = "Item 5",
                description = "Description 5"
            ),
            Item(
                title = "Item 6",
                description = "Description 6"
            ),
            Item(
                title = "Item 7",
                description = "Description 7"
            ),
            Item(
                title = "Item 8",
                description = "Description 8"
            ),
            Item(
                title = "Item 9",
                description = "Description 9"
            ),
            Item(
                title = "Item 10",
                description = "Description 10"
            )
        )
    }
}