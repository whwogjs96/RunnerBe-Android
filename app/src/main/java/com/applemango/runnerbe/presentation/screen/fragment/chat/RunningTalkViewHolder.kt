package com.applemango.runnerbe.presentation.screen.fragment.chat

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.databinding.ItemRunningTalkBinding
import com.applemango.runnerbe.data.dto.Room

class RunningTalkViewHolder(val binding : ItemRunningTalkBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Room) {
        binding.item = item
    }
}