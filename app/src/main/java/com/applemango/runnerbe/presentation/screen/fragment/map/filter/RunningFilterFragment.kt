package com.applemango.runnerbe.presentation.screen.fragment.map.filter

import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentRunningFilterBinding
import com.applemango.runnerbe.presentation.model.JobButtonId
import com.applemango.runnerbe.presentation.screen.dialog.twobutton.TwoButtonDialog
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment
import com.google.android.material.slider.RangeSlider

class RunningFilterFragment :
    BaseFragment<FragmentRunningFilterBinding>(R.layout.fragment_running_filter) {

    private val viewModel: RunningFilterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        filterSetting()
        sliderSetting()
    }

    private fun sliderSetting() {
        binding.ageSlider.addOnChangeListener(RangeSlider.OnChangeListener { slider, _, _ ->
            val ages = slider.values
            viewModel.recruitmentStartAge.value = ages[0].toInt()
            viewModel.recruitmentEndAge.value = ages[1].toInt()
        })
    }

    private fun filterSetting() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    setFragmentResult("filter", bundleOf(
                        "gender" to viewModel.getGenderTag()
                    ))
                    navPopStack()
                }
            })
    }
}