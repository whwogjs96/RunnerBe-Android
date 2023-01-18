package com.applemango.runnerbe.screen.fragment.chat

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.databinding.ItemRunningTalkBinding
import com.applemango.runnerbe.model.dto.Room

class RunningTalkViewHolder(val binding : ItemRunningTalkBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Room) {
        binding.item = item
    }
}