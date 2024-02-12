package com.applemango.runnerbe.presentation.screen.fragment.map

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.presentation.model.listener.BookMarkClickListener

class HomePostAdapter(private val bookMarkClickListener: BookMarkClickListener) :
    ListAdapter<Posting, HomePostViewHolder>(PostCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePostViewHolder {
        return HomePostViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_post, parent, false
            ), bookMarkClickListener
        )
    }

    override fun onBindViewHolder(holder: HomePostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class PostCallback : DiffUtil.ItemCallback<Posting>() {
    override fun areItemsTheSame(oldItem: Posting, newItem: Posting): Boolean = oldItem == newItem


    override fun areContentsTheSame(oldItem: Posting, newItem: Posting): Boolean {
        return oldItem.postId == newItem.postId
    }

}