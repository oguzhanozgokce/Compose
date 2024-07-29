package com.oguzhanozgokce.composeb2b.di

import com.oguzhanozgokce.composeb2b.data.model.repository.ProductRepository
import com.oguzhanozgokce.composeb2b.data.model.retrofit.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(apiService: ApiService): ProductRepository {
        return ProductRepository(apiService)
    }

}