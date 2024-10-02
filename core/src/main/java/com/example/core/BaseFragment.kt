package com.example.core

import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
//import androidx.navigation.fragment.findNavController
//import com.app.alainpayapp.data.remote.sumsub.PrefManager
//import com.uae.myvaultspay.R
//import com.uae.myvaultspay.SharedViewModel
//import com.uae.myvaultspay.constants.AppConstants
//import com.uae.myvaultspay.data.local.datastore.DataStoreProvider
//import com.uae.myvaultspay.data.local.session.AppSession
//import com.uae.myvaultspay.data.local.session.UserSessionModel
//import com.uae.myvaultspay.data.remote.Resource
//import com.uae.myvaultspay.databinding.LayoutEmptyListBinding
//import com.uae.myvaultspay.ui.activity.MainActivity
//import com.uae.myvaultspay.utils.DialogClass
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment() {

//    lateinit var sharedViewModel: SharedViewModel

    private var mActivity: BaseActivity<*, *>? = null
    protected lateinit var mViewDataBinding: T
    protected lateinit var mViewModel: V

    abstract val layoutId: Int
    abstract val viewModel: Class<V>
    abstract val bindingVariable: Int

//    lateinit var dataStoreProvider: DataStoreProvider

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        mViewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return mViewDataBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewDataBinding.setVariable(bindingVariable, mViewModel)
        mViewDataBinding.lifecycleOwner = this
        mViewDataBinding.executePendingBindings()

        subscribeToShareLiveData()
        subscribeToNavigationLiveData()
        subscribeToViewLiveData()


    }

    open fun subscribeToViewLiveData() {

        //observe view data

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) this.mActivity = context
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this)[viewModel]
//        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
//
//        dataStoreProvider = DataStoreProvider(requireContext())

        subscribeToNetworkLiveData()
    }


    open fun subscribeToShareLiveData() {

    }

    open fun subscribeToNetworkLiveData() {
        //All Network Tasks
    }

    open fun subscribeToNavigationLiveData() {

    }


//    fun clearSessionData() {
//        UserSessionModel.setUserObj(null)
//        GlobalScope.launch {
//            dataStoreProvider.clearUserObj()
//        }
//    }

    //block ui
    fun blockUi() {
        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
    }


    //unblock ui
    fun unBlockUi() {
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }


//    fun handleNetworkResponse(
//        response: Resource<*>,
//        showLoading: Boolean = true,
//        showShimmer: Boolean = false,
//        callback: (position: Int) -> Unit
//    ) {
//
//        when (response) {
//            is Resource.Loading -> {
//                if (showLoading) DialogClass.showLoadingDialog(requireContext())
//                if (showShimmer) {
//                    callback.invoke(AppConstants.CallBackType.SHOW_SHIMMER)
//                }
//            }
//
//            is Resource.Error -> {
//                DialogClass.hideLoadingDialog()
//
//                callback.invoke(AppConstants.CallBackType.HIDE_SHIMMER)
//                if (response.responseError != null) {
//
//                    response.responseError.accessToken?.let { accessToken ->
//                        lifecycleScope.launch {
//                            if (accessToken.isNotEmpty()) {
//                                AppSession.setToken(accessToken)
//                            }
//                        }
//                    }
//
//                    response.responseError.code?.let { code ->
//                        when (code) {
//                            400 -> {
//                                response.responseError.message?.let { errorMsg ->
//                                    DialogClass.buildGeneralDialog(
//                                        context = requireContext(),
//                                        type = AppConstants.GenericPopupType.ERROR,
//                                        errorDescription = errorMsg,
//                                        onClick =
//                                        {
//                                            callback.invoke(AppConstants.CallBackType.FOUR_HUNDRED)
//                                        })
//                                }
//                            }
//
//                            401 -> {
//                                response.responseError.message?.let { errorMsg ->
//                                    DialogClass.buildGeneralDialog(
//                                        context = requireContext(),
//                                        type = AppConstants.GenericPopupType.SESSION_TIMEOUT,
//                                        errorDescription = errorMsg,
//                                        onClick =
//                                        {
//                                            callback.invoke(AppConstants.CallBackType.FOUR_HUNDRED_ONE)
//                                            sharedViewModel.clearSharedViewModel()
//                                            if (UserSessionModel.getUserObj() == null) {
//                                                findNavController().navigate(R.id.action_to_getStartedLoginFragment)
//                                            } else {
//                                                findNavController().navigate(R.id.action_onBoardingParentFragment_to_passcodeFragment)
//                                            }
//                                        })
//                                }
//                            }
//
//                            403 -> {
//                                response.responseError.message?.let { errorMsg ->
//                                    DialogClass.buildGeneralDialog(
//                                        context = requireContext(),
//                                        type = AppConstants.GenericPopupType.NEW_UPDATE,
//                                        errorDescription = errorMsg,
//                                        onClick =
//                                        {
//                                            goToPlayStore() // ids to be changed
//                                        })
//
//                                }
//                            }
//
//                            402 -> {
//                                DialogClass.buildGeneralDialog(
//                                    context = requireContext(),
//                                    type = AppConstants.GenericPopupType.SYSTEM_UNDER_MAINTENANCE,
//                                    errorDescription = null
//                                ) {
//
//                                }
//                            }
//
//                            else -> {
//                                response.responseError.message?.let { errorMsg ->
//                                    DialogClass.buildGeneralDialog(
//                                        context = requireContext(),
//                                        type = AppConstants.GenericPopupType.ERROR,
//                                        errorDescription = errorMsg,
//                                        onClick =
//                                        {
//                                            callback.invoke(AppConstants.CallBackType.ERROR)
//                                        })
//                                }
//                            }
//                        }
//                    }
//
//                } else {
//                    DialogClass.buildGeneralDialog(
//                        context = requireContext(),
//                        type = AppConstants.GenericPopupType.ERROR,
//                        errorDescription = response.message.toString(),
//                        onClick =
//                        {
//
//                            if (response.message.toString() == requireContext().getString(R.string.no_internet_connection)) callback.invoke(
//                                AppConstants.CallBackType.NETWORK_ERROR
//                            )
//                        })
//                }
//            }
//
//            else -> {
//                return
//            }
//
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()

//        GlobalScope.launch {
//            dataStoreProvider.saveToken(AppSession.getToken())
//        }
    }

    open fun goToPlayStore() {
        val playStoreMarketUrl = "market://details?id="
        val playStoreWebUrl = "https://play.google.com/store/apps/details?id="
        try {
            var intent =
                requireActivity().packageManager.getLaunchIntentForPackage("com.android.vending")
            if (intent != null) {
                val androidComponent = ComponentName(
                    "com.android.vending",
                    "com.google.android.finsky.activities.LaunchUrlHandlerActivity"
                )
                intent.component = androidComponent
                intent.data = Uri.parse(playStoreMarketUrl + "")
            } else {
                intent = Intent(
                    Intent.ACTION_VIEW, Uri.parse(playStoreMarketUrl + requireContext().packageName)
                )
            }
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            val intent = Intent(
                Intent.ACTION_VIEW, Uri.parse(playStoreWebUrl + requireContext().packageName)
            )
            startActivity(intent)
        }
    }

//    fun setEmptyListData(
//        imgIcon: Int,
//        titleString: String,
//        detailString: String,
//        layoutEmptyListBinding: LayoutEmptyListBinding
//    ) {
//        layoutEmptyListBinding.let {
//            it.imgIcon.setBackgroundResource(imgIcon)
//            it.tvTitle.text = titleString
//            it.tvDetail.text = detailString
//        }
//    }
//
//    fun changeLanguage(language: String) {
//        if (AppSession.getLanguage() != language) {
//            PrefManager(requireContext()).setLanguage(language)
//            AppSession.setLanguage(language)
//            // Pop the back stack up to the splash screen fragment
//            findNavController().popBackStack(R.id.splashFragment, false)
//
//            // Restart the main activity
//            val intent = Intent(context, MainActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//            requireContext().startActivity(intent)
//        }
//    }
}