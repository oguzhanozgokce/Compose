package com.oguzhanozgokce.composeb2b

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oguzhanozgokce.composeb2b.common.Resource
import com.oguzhanozgokce.composeb2b.data.model.repository.ProductRepository
import com.oguzhanozgokce.composeb2b.data.model.response.GetProductResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _products = MutableLiveData<Resource<GetProductResponse>>()
    val products: LiveData<Resource<GetProductResponse>> = _products

    init {
        getProducts()
    }

    private fun getProducts() = viewModelScope.launch {
        _products.postValue(Resource.Loading())
        _products.postValue(productRepository.getProducts())
    }
}

