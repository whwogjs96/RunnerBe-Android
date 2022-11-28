package com.applemango.runnerbe.screen.fragment.base

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
import com.applemango.runnerbe.model.viewmodel.NavigationViewModel

/**
 * 프래그먼트의 공통 명세는 여기에 작성해주세요.
 */
open class BaseFragment<T : ViewDataBinding>(@LayoutRes private val layoutId: Int) :
    Fragment() {

    private var _binding: T? = null
    protected val binding: T get() = _binding!!

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


}