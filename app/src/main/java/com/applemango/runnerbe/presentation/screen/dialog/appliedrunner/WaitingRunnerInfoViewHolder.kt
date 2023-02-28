package com.applemango.runnerbe.presentation.screen.dialog.appliedrunner

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.applemango.runnerbe.data.dto.UserInfo
import com.applemango.runnerbe.databinding.ItemWaitingRunnerInfoBinding

class WaitingRunnerInfoViewHolder(val binding: ItemWaitingRunnerInfoBinding) : ViewHolder(binding.root) {

    fun bind(userInfo: UserInfo) {
        binding.userInfo = userInfo
    }
}