package com.applemango.runnerbe.presentation.screen.fragment.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.applemango.runnerbe.presentation.NavigationViewModel
import com.applemango.runnerbe.presentation.screen.dialog.LoadingDialog

/**
 * 프래그먼트의 공통 명세는 여기에 작성해주세요.
 */
open class BaseFragment<T : ViewDataBinding>(@LayoutRes private val layoutId: Int) :
    Fragment() {

    private var _binding: T? = null
    protected val binding: T get() = _binding!!

    var mLoadingDialog: LoadingDialog? = null

    protected val navController: NavController get() = findNavController()

    private val navigationViewModel : NavigationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            layoutInflater,
            layoutId,
            null,
            false
        )
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationAction()
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
        navigationClear()
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun navigationAction() {
        navigationViewModel.apply {
            navDirectionAction.observe(viewLifecycleOwner) {
                if (it != null) navController.navigate(it)
            }
            popBackStack.observe(viewLifecycleOwner) {
                if (it) navController.popBackStack()
            }
        }
    }

    private fun navigationClear() {
        navigationViewModel.apply {
            navDirectionAction.value = null
        }
    }

    fun navPopStack() { navigationViewModel.popBackStack.postValue(true) }

    fun navigate(direction: NavDirections) { navigationViewModel.navDirectionAction.postValue(direction) }

    // 로딩 다이얼로그, 즉 로딩창을 띄워줌.
    // 네트워크가 시작될 때 사용자가 무작정 기다리게 하지 않기 위해 작성.
    fun showLoadingDialog(context: Context) {
        if(mLoadingDialog == null) mLoadingDialog = LoadingDialog(context)
        mLoadingDialog?.show()
    }
    // 띄워 놓은 로딩 다이얼로그를 없앰.
    fun dismissLoadingDialog() {
        if (mLoadingDialog?.isShowing == true) {
            mLoadingDialog?.dismiss()
        }
    }


}