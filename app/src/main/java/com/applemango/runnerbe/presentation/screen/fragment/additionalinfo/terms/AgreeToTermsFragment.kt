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
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/runner-be/runner-be.github.io/blob/main/Policy_Service.txt"))
        startActivity(intent)
    }

    fun moveToPrivacyTerms() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/runner-be/runner-be.github.io/blob/main/Policy_Privacy_Collect.txt"))
        startActivity(intent)
    }

    fun moveToLocationServiceUseTerms() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/runner-be/runner-be.github.io/blob/main/Policy_Location.txt"))
        startActivity(intent)
    }

    fun moveToNext() {
        navigate(AgreeToTermsFragmentDirections.actionAgreeToTermsFragmentToYearInfoFragment())
    }
}