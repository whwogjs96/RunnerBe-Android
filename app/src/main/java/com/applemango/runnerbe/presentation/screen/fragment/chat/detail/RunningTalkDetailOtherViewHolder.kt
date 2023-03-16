package com.applemango.runnerbe.presentation.screen.fragment.chat.detail

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.data.dto.Messages
import com.applemango.runnerbe.databinding.ItemOtherTalkBinding

class RunningTalkDetailOtherViewHolder(val binding: ItemOtherTalkBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Messages) {
        binding.item = item
    }
}