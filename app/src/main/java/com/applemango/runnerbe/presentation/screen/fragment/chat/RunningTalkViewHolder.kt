package com.applemango.runnerbe.presentation.screen.fragment.chat

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.databinding.ItemRunningTalkBinding
import com.applemango.runnerbe.data.dto.Room
import com.applemango.runnerbe.presentation.model.listener.RoomClickListener

class RunningTalkViewHolder(
    val binding: ItemRunningTalkBinding,
    private val roomClickListener: RoomClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Room) {
        binding.item = item
        binding.clickListener = roomClickListener
    }
}