package com.applemango.runnerbe.presentation.screen.fragment.mypage.paceinfo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentRegistPaceInfoBinding
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaceInfoRegistFragment: BaseFragment<FragmentRegistPaceInfoBinding>(R.layout.fragment_regist_pace_info) {

    private val viewModel: PaceInfoViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }
}