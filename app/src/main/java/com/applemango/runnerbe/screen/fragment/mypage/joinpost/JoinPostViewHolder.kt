package com.applemango.runnerbe.screen.fragment.mypage.joinpost

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.databinding.ItemJoinPostBinding
import com.applemango.runnerbe.dto.Posting

class JoinPostViewHolder(val binding : ItemJoinPostBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Posting) {
        binding.holderModel = item
    }
}