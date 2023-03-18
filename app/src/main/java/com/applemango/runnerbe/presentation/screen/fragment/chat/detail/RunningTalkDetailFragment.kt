package com.applemango.runnerbe.presentation.screen.fragment.chat.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.applemango.runnerbe.R
import com.applemango.runnerbe.RunnerBeApplication
import com.applemango.runnerbe.data.dto.Messages
import com.applemango.runnerbe.data.dto.Room
import com.applemango.runnerbe.databinding.FragmentRunningTalkDetailBinding
import com.applemango.runnerbe.presentation.model.listener.RoomClickListener
import com.applemango.runnerbe.presentation.screen.deco.RecyclerViewItemDeco
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment
import com.applemango.runnerbe.presentation.screen.fragment.main.MainFragmentDirections
import com.applemango.runnerbe.presentation.state.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RunningTalkDetailFragment : BaseFragment<FragmentRunningTalkDetailBinding>(R.layout.fragment_running_talk_detail){

    private val viewModel : RunningTalkDetailViewModel by viewModels()
    private val args : RunningTalkDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        binding.fragment = this
        viewModel.roomId = args.roomId
        viewModel.roomRepName = args.roomRepUserName
        context?.let {
            binding.messageRecyclerView.addItemDecoration(RecyclerViewItemDeco(it, 12))
        }
        refresh()
        observeBind()

    }

    private fun observeBind() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            launch {
                viewModel.getMessageListUiState.collect {
                    when(it) {
                        is UiState.Success -> {
//                            binding.messageRecyclerView.scrollToPosition(viewModel.messageList.size - 1)
                        }
                    }
                }
            }
            launch {
                viewModel.messageSendUiState.collect {
                    Log.e("uiState", it.toString())
                    when(it) {
                        is UiState.Success -> {
//                            viewModel.messageList.add(Messages(
//                                messageId = -1,
//                                content = viewModel.message.value,
//                                userId = RunnerBeApplication.mTokenPreference.getUserId(),
//                                nickName = "",
//                                profileImageUrl = null,
//                                from = "Me",
//                                whetherPostUser =
//                            ))
                            refresh()
                            viewModel.message.value = ""
                        }
                        is UiState.Failed -> {

                        }
                    }
                }
            }
        }
    }
    private fun refresh() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getDetailData(true)
        }
    }
}