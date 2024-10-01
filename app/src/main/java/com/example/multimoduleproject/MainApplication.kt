package com.example.multimoduleproject

import android.app.Application
import com.example.featurea.data.nativelib.NativeHooks
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Your custom logic
        System.loadLibrary("main")
    }
}