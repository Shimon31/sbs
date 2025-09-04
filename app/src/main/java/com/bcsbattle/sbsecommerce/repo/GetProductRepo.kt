package com.bcsbattle.sbsecommerce.repo

import com.bcsbattle.sbsecommerce.api.ProductsService
import com.bcsbattle.sbsecommerce.data.Product.ResponseProductItem
import retrofit2.Response
import javax.inject.Inject

class GetProductRepo @Inject constructor(private val service: ProductsService) {

    suspend fun getAllProduct(): Response<List<ResponseProductItem>>{

        return service.getAllProducts()
    }
}