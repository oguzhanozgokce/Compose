package com.oguzhanozgokce.composeb2b.data.model.response

import com.oguzhanozgokce.composeb2b.data.model.source.Product

class GetProductResponse(
    val products: List<Product>,
) : BaseResponse() {
}