package com.applemango.runnerbe.presentation.screen.fragment.bookmark

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.databinding.ItemPostingBinding

class BookMarkViewHolder(private val binding: ItemPostingBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item : Posting) {
        binding.item = item
    }
}