package com.example.core

import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider


abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

    lateinit var mViewDataBinding: T
    protected lateinit var mViewModel: V

    /**
     * viewModel variable that will get value from activity which it will implement this
     * we will use this variable viewModel to bind with view through databinding
     */
    abstract val viewModel: Class<V>

    /**
     * layoutId variable to get layout value from activity which will implement this layoutId
     * we will use this layoutId for databinding
     */
    @get:LayoutRes
    abstract val layoutId: Int

    /**
     * bindingVariable which will bind with view
     */

    abstract val bindingVariable: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!BuildConfig.DEBUG) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE
            )
        }

        databindingWithViewModel()

        subscribeToNetworkLiveData()
        subscribeToShareLiveData()
        subscribeToNavigationLiveData()
        subscribeToViewLiveData()
    }


    /**
     * Function to perform databinding and attaching viewmodel with view
     */
    private fun databindingWithViewModel() {
        mViewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        mViewModel = ViewModelProvider(this)[viewModel]
        mViewDataBinding.setVariable(bindingVariable, mViewModel)
        mViewDataBinding.executePendingBindings()

    }

//    override fun attachBaseContext(newBase: Context) {
    // get language from shared preference/app session
//        val localeToSwitchTo = PrefManager(newBase).getLanguage()
//        AppSession.setLanguage(PrefManager(newBase).getLanguage().toString())
//        //val locale= Locale(AppSession.getLanguage())
//        val locale = Locale(localeToSwitchTo.toString())
//        val localeUpdatedContext: ContextWrapper =
//            LanguageManagerUtils.updateLocale(newBase, locale)
//        super.attachBaseContext(localeUpdatedContext)
//    }

    open fun subscribeToShareLiveData() {

    }

    open fun subscribeToNetworkLiveData() {
        //All Network Tasks
    }

    open fun subscribeToNavigationLiveData() {

    }

    open fun subscribeToViewLiveData() {

        //observe view data

    }


    open fun goToPlayStore() {
        val playStoreMarketUrl = "market://details?id="
        val playStoreWebUrl = "https://play.google.com/store/apps/details?id="
        try {
            var intent = packageManager
                .getLaunchIntentForPackage("com.android.vending")
            if (intent != null) {
                val androidComponent = ComponentName(
                    "com.android.vending",
                    "com.google.android.finsky.activities.LaunchUrlHandlerActivity"
                )
                intent.component = androidComponent
                intent.data = Uri.parse(playStoreMarketUrl + "")
            } else {
                intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(playStoreMarketUrl + packageName)
                )
            }
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(playStoreWebUrl + packageName)
            )
            startActivity(intent)
        }
    }

}