package com.applemango.runnerbe.screen.fragment.mypage.mypost

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.databinding.ItemMyPostBinding
import com.applemango.runnerbe.dto.Posting

class MyPostViewHolder(val binding : ItemMyPostBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Posting) {
        binding.holderModel = item
    }
}