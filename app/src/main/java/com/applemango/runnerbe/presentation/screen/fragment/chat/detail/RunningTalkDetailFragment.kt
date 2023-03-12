package com.applemango.runnerbe.presentation.screen.fragment.chat.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.Room
import com.applemango.runnerbe.databinding.FragmentRunningTalkDetailBinding
import com.applemango.runnerbe.presentation.model.listener.RoomClickListener
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment
import com.applemango.runnerbe.presentation.screen.fragment.main.MainFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RunningTalkDetailFragment : BaseFragment<FragmentRunningTalkDetailBinding>(R.layout.fragment_running_talk_detail){

    private val viewModel : RunningTalkDetailViewModel by viewModels()
    private val args : RunningTalkDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        binding.fragment = this
        viewModel.roomId = args.roomId
        refresh()
    }

    private fun refresh() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getDetailData()
        }
    }
}