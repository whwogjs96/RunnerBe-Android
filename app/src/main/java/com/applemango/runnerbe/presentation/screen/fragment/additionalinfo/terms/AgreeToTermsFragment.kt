package com.applemango.runnerbe.presentation.screen.fragment.additionalinfo.terms

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentAgreeToTermsBinding
import com.applemango.runnerbe.presentation.screen.fragment.additionalinfo.terms.AgreeToTermsViewModel
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment
import com.applemango.runnerbe.presentation.screen.fragment.mypage.setting.SettingFragmentDirections
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AgreeToTermsFragment :BaseFragment<FragmentAgreeToTermsBinding>(R.layout.fragment_agree_to_terms) {

    private val viewModel : AgreeToTermsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        binding.fragment = this
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.allCheck.collect {
                binding.termsAllCheckBox.isChecked = it
            }
        }
        binding.termsAllCheckBox.setOnClickListener {
            viewModel.serviceTerms.value = binding.termsAllCheckBox.isChecked
            viewModel.privacyTerms.value = binding.termsAllCheckBox.isChecked
            viewModel.locationServiceTerms.value = binding.termsAllCheckBox.isChecked
        }
    }

    fun moveToServiceUseTerms() {
        navigate(
            AgreeToTermsFragmentDirections.actionAgreeToTermsFragmentToWebViewFragment(
                title = resources.getString(R.string.terms_of_service),
                url = "https://raw.githubusercontent.com/runner-be/runner-be.github.io/main/Policy_Service.txt"
            )
        )
    }

    fun moveToPrivacyTerms() {
        navigate(
            AgreeToTermsFragmentDirections.actionAgreeToTermsFragmentToWebViewFragment(
                title = resources.getString(R.string.privacy_policy),
                url = "https://raw.githubusercontent.com/runner-be/runner-be.github.io/main/Policy_Privacy_Collect.txt"
            )
        )
    }

    fun moveToLocationServiceUseTerms() {
        navigate(
            AgreeToTermsFragmentDirections.actionAgreeToTermsFragmentToWebViewFragment(
                title = resources.getString(R.string.use_a_location_service),
                url = "https://raw.githubusercontent.com/runner-be/runner-be.github.io/main/Policy_Location.txt"
            )
        )
    }

    fun moveToNext() {
        navigate(AgreeToTermsFragmentDirections.actionAgreeToTermsFragmentToYearInfoFragment())
    }
}