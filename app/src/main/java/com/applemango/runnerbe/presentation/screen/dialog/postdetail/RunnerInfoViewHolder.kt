package com.applemango.runnerbe.presentation.screen.dialog.postdetail

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.data.dto.UserInfo
import com.applemango.runnerbe.databinding.ItemRunnerInfoBinding

class RunnerInfoViewHolder(val binding: ItemRunnerInfoBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: UserInfo) {
        binding.userInfo = item
    }
}