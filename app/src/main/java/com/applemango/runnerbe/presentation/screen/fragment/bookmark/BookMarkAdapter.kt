package com.applemango.runnerbe.presentation.screen.fragment.bookmark

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.Posting

class BookMarkAdapter(private val dataList : ObservableArrayList<Posting>): RecyclerView.Adapter<BookMarkViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookMarkViewHolder {
        return BookMarkViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_posting,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: BookMarkViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size
}