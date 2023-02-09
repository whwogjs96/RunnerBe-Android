package com.applemango.runnerbe.presentation.screen.fragment.additionalinfo.gender

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentAdditionalGenderSelectBinding
import com.applemango.runnerbe.presentation.screen.fragment.additionalinfo.AdditionalInfoViewModel
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment

class AdditionalGenderSelectFragment : BaseFragment<FragmentAdditionalGenderSelectBinding>(R.layout.fragment_additional_gender_select){

    private val viewModel : AdditionalInfoViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this
    }
}