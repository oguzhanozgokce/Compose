package com.oguzhanozgokce.composeb2b.data.model.source

data class SmallProduct(
    val id: Int,
    val title: String,
    val price: Double,
    val imageUrl: String,
    val description: String,
    val category: String,
    val saleState: Boolean,
    val salePrice: Double,
    val rate: Double,
    val quantity: Int
)