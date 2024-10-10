package com.example.merchant

import android.content.Context
import com.example.merhcant.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MainClass  {
    private val name = "Merchant"
    private val attempt = "Hilt Imp Attempt"


    fun getDescription(): String {
        return "$name   $attempt"
    }


}

class MainClassWithContext(private val context: Context){
    fun getString():String{
        return context.getString(R.string.usingContext)
    }
}


// if we want to use this con
class MainClassWithAppContext @Inject constructor(@ApplicationContext private val context: Context){
    fun getString():String{
        return context.getString(R.string.usingContext)
    }
}

class ClassWithStrValue (private val strValue:String){

    fun getStrValue() : String{
        return strValue
    }
}