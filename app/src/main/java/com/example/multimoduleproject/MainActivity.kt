package com.example.multimoduleproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.featurea.FeatureAMainActivity
import com.example.merchant.MerchantMainActivity
import com.example.featurec.FeatureCMainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        System.loadLibrary("main")

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // feature a
        findViewById<Button>(R.id.btnFeatureScreen).setOnClickListener {
            startActivity(Intent(this, FeatureAMainActivity::class.java))
        }

        //feature b
        findViewById<Button>(R.id.btnFeatureBScreen).setOnClickListener {
            startActivity(Intent(this, MerchantMainActivity::class.java))
        }

        //feature c
        findViewById<Button>(R.id.btnFeatureCScreen).setOnClickListener {
            startActivity(Intent(this, FeatureCMainActivity::class.java))
        }
    }
}