package com.applemango.runnerbe.presentation.screen.fragment.chat.detail

import androidx.fragment.app.viewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentRunningTalkDetailBinding
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RunningTalkDetailFragment : BaseFragment<FragmentRunningTalkDetailBinding>(R.layout.fragment_running_talk_detail){

    private val viewModel : RunningTalkDetailViewModel by viewModels()
}