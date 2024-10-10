package com.example.merchant.modules

import android.content.Context
import com.example.merchant.ClassWithStrValue
import com.example.merchant.MainClass
import com.example.merchant.MainClassWithAppContext
import com.example.merchant.MainClassWithContext
import com.example.merhcant.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideDao():MainClass{
        return MainClass()
    }

//

//    @Provides
//    @Singleton
//    fun provideSomeDependency(@ApplicationContext context: Context): MainClassWithContext {
//        return MainClassWithContext(context)
//    }

    @Provides
    @Singleton
    fun getContext(@ApplicationContext context: Context):Context{
        return  context
    }

    @Provides
    @Singleton
    fun provideSomeDependency(context: Context): MainClassWithContext {
        return MainClassWithContext(context)
    }


    @Provides
    @Singleton
    fun provideStrVal(mainClassWithAppContext: MainClassWithAppContext): ClassWithStrValue {
        return ClassWithStrValue(mainClassWithAppContext.getString())
    }
}