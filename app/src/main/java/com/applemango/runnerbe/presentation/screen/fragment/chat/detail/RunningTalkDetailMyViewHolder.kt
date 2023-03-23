package com.applemango.runnerbe.presentation.screen.fragment.chat.detail

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.data.dto.Messages
import com.applemango.runnerbe.databinding.ItemMyTalkBinding

class RunningTalkDetailMyViewHolder(val binding : ItemMyTalkBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Messages) {
        binding.item = item
    }
}