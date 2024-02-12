package com.applemango.runnerbe.presentation.screen.fragment.map

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.databinding.ItemPostBinding
import com.applemango.runnerbe.presentation.model.PostIncomingType
import com.applemango.runnerbe.presentation.model.listener.BookMarkClickListener

class HomePostViewHolder(
    private val binding: ItemPostBinding,
    private val listener: BookMarkClickListener
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Posting) {
        binding.item = item
        binding.bookMarkClickListener = listener
        binding.incomingType = PostIncomingType.HOME
    }
}