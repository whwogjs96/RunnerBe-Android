package com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.databinding.ItemMyPostBinding
import com.applemango.runnerbe.data.dto.Posting

class MyPostViewHolder(val binding : ItemMyPostBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Posting) {
        binding.holderModel = item
    }
}