package com.applemango.runnerbe.presentation.screen.dialog.appliedrunner

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.applemango.runnerbe.data.dto.UserInfo
import com.applemango.runnerbe.databinding.ItemWaitingRunnerInfoBinding
import com.applemango.runnerbe.presentation.model.listener.PostAcceptListener

class WaitingRunnerInfoViewHolder(
    val binding: ItemWaitingRunnerInfoBinding,
    private val listener: PostAcceptListener
) : ViewHolder(binding.root) {

    fun bind(userInfo: UserInfo) {
        binding.userInfo = userInfo
        binding.listener = listener
    }
}