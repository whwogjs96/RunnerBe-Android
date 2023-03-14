package com.applemango.runnerbe.presentation.screen.fragment.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.Room
import com.applemango.runnerbe.databinding.FragmentRunningTalkBinding
import com.applemango.runnerbe.presentation.model.listener.RoomClickListener
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment
import com.applemango.runnerbe.presentation.screen.fragment.main.MainFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RunningTalkFragment: BaseFragment<FragmentRunningTalkBinding>(R.layout.fragment_running_talk) {

    private val viewModel : RunningTalkViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refresh()
        binding.viewModel = viewModel
        binding.fragment = this
    }
    private fun refresh() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getRunningTalkList(true)
        }
    }

    fun getRoomClickListener() = object : RoomClickListener {
        override fun moveToRunningTalkRoom(item: Room) {
            navigate(MainFragmentDirections.actionMainFragmentToRunningTalkDetailFragment(item.roomId))
        }

    }
}