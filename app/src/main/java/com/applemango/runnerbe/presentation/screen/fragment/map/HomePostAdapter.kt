package com.applemango.runnerbe.presentation.screen.fragment.map

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.presentation.model.listener.PostClickListener

class HomePostAdapter(
    private val dataList: ObservableArrayList<Posting>,
    private val clickListener: PostClickListener
    ) : RecyclerView.Adapter<HomePostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePostViewHolder {
        return HomePostViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_post, parent, false
            ), clickListener
        )
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: HomePostViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

}