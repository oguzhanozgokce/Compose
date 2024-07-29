package com.oguzhanozgokce.composeb2b.data.model.retrofit

import com.oguzhanozgokce.composeb2b.common.Constants.USER
import com.oguzhanozgokce.composeb2b.data.model.response.GetProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    @GET("get_products")
    suspend fun getProduct(
        @Header("store") store: String = USER
    ) : Response<GetProductResponse>
}