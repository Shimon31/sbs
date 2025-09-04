package com.bcsbattle.sbsecommerce.ui.Home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bcsbattle.sbsecommerce.R
import com.bcsbattle.sbsecommerce.base.BaseFragment
import com.bcsbattle.sbsecommerce.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    val viewModel : HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.allProductResponse.observe(viewLifecycleOwner){
            it.forEach { item ->
                Log.d("TAG", "onViewCreated: ${item.title}")
            }
        }
    }

}