package com.bcsbattle.sbsecommerce.api

import com.bcsbattle.sbsecommerce.data.Product.ResponseProductItem
import retrofit2.Response
import retrofit2.http.GET

interface ProductsService {

    @GET("products")
    suspend fun getAllProducts() : Response<List<ResponseProductItem>>

    @GET("products")
    suspend fun getProductById() : Response<ResponseProductItem>

}