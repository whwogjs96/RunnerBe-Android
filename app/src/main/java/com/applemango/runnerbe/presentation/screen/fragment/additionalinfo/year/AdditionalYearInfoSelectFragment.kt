package com.applemango.runnerbe.presentation.screen.fragment.additionalinfo.year

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentAdditionalYearInfoSelectBinding
import com.applemango.runnerbe.presentation.screen.fragment.additionalinfo.AdditionalInfoViewModel
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment
import com.applemango.runnerbe.util.getYearListByYear
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdditionalYearInfoSelectFragment: BaseFragment<FragmentAdditionalYearInfoSelectBinding>(R.layout.fragment_additional_year_info_select) {

    private val viewModel : AdditionalInfoViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this
        setWheelYear()
    }

    private fun setWheelYear() {
        val yearList = getYearListByYear(19, 80)
        binding.yearWheelView.setData(yearList, yearList.indexOf(viewModel.yearOfBrith))
    }

    fun moveToNext() {
        viewModel.yearOfBrith = binding.yearWheelView.getCurrentItem()
        viewModel.yearOfBrith?.let {
            navigate(AdditionalYearInfoSelectFragmentDirections.actionYearInfoFragmentToAdditionalGenderSelectFragment())
        }
    }
}