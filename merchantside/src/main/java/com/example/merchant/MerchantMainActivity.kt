package com.example.merchant

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.core.BaseActivity
import com.example.merhcant.BR
import com.example.merhcant.BuildConfig
import com.example.merhcant.R
import com.example.merhcant.databinding.LayoutMerchantMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MerchantMainActivity : BaseActivity<LayoutMerchantMainBinding, MerchantViewModel>() {

    override val viewModel: Class<MerchantViewModel>
        get() = MerchantViewModel::class.java

    override val layoutId: Int
        get() = R.layout.layout_merchant_main

    override val bindingVariable: Int
        get() = BR.viewModel

    @Inject
    lateinit var  mainClass: MainClass


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        setContentView(R.layout.layout_merchant_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        mViewDataBinding.tv.text =
            "${mainClass.getDescription()} \nProduct flavor is b  "+ BuildConfig.BASE_URL
    }
}