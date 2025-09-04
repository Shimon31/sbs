package com.bcsbattle.sbsecommerce.di

import com.bcsbattle.sbsecommerce.api.ProductsService
import com.bcsbattle.sbsecommerce.utils.base_url
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    @Singleton
    fun provideProductService(retrofit: Retrofit.Builder) : ProductsService{
        return retrofit.build().create(ProductsService::class.java)
    }

}