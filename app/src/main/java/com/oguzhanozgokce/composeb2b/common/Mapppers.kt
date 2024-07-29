package com.oguzhanozgokce.composeb2b.common

import com.oguzhanozgokce.composeb2b.data.model.source.Product
import com.oguzhanozgokce.composeb2b.data.model.source.SmallProduct

fun Product.toCartItem(quantity: Int) = SmallProduct(
    id = id ?: 1,
    title = title.orEmpty(),
    price = price ?: 0.0,
    imageUrl = imageOne.orEmpty(),
    description = description.orEmpty(),
    category = category.orEmpty(),
    saleState = saleState ?: false,
    salePrice = salePrice ?: 0.0,
    rate = rate ?: 0.0,
    quantity = quantity
)