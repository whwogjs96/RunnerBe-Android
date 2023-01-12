package com.applemango.runnerbe.screen.fragment.mypage.setting.creator

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.databinding.ItemCreatorBinding
import com.applemango.runnerbe.model.CreatorImageAndPosition

class CreatorViewHolder(val binding : ItemCreatorBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item : CreatorImageAndPosition) {
        binding.data = item
    }
}