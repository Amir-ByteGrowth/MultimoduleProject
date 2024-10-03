package com.example.merchant.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.core.BaseFragment
import com.example.core.BaseViewModel
import com.example.merchant.SharedViewModel

abstract class MerchantBaseFragment<T : ViewDataBinding, V : BaseViewModel> : BaseFragment<T, V>() {
    lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
    }
}