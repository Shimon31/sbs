package com.bcsbattle.sbsecommerce.ui.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bcsbattle.sbsecommerce.data.Product.ResponseProductItem
import com.bcsbattle.sbsecommerce.repo.GetProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: GetProductRepo) : ViewModel() {

    private var _allProductResponse = MutableLiveData<List<ResponseProductItem>>()
    val allProductResponse: LiveData<List<ResponseProductItem>>
        get() = _allProductResponse

    init {
        getAllProduct()
    }

    fun getAllProduct() {

        viewModelScope.launch {

            val response = repo.getAllProduct()
            if (response.isSuccessful) {
                _allProductResponse.postValue(response.body())
            }
        }

    }

}