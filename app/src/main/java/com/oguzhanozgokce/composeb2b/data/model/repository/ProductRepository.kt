package com.oguzhanozgokce.composeb2b.data.model.repository

import com.oguzhanozgokce.composeb2b.common.Resource
import com.oguzhanozgokce.composeb2b.data.model.response.GetProductResponse
import com.oguzhanozgokce.composeb2b.data.model.retrofit.ApiService
import javax.inject.Inject


class ProductRepository @Inject constructor(
    private val apiService: ApiService) {

    suspend fun getProducts(): Resource<GetProductResponse> {
        return try {
            val response = apiService.getProduct()
            if (response.isSuccessful) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error("Error: ${response.message()}")
            }
        }catch (e: Exception){
            Resource.Error("Exception: ${e.message}")
        }
    }
}