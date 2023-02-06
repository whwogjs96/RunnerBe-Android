package com.applemango.runnerbe.presentation.screen.fragment.bookmark

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.databinding.ItemPostingBinding
import com.applemango.runnerbe.presentation.model.listener.BookMarkClickListener

class BookMarkViewHolder(
    private val binding: ItemPostingBinding,
    private val bookMarkEvent: BookMarkClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Posting) {
        binding.item = item
        binding.bookMarkClickListener = bookMarkEvent
    }
}