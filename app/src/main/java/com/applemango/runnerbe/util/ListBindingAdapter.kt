package com.applemango.runnerbe.util

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.dto.Posting

@BindingAdapter("myPostAdapter")
fun setMyPostAdapter(recyclerView: RecyclerView, dataList : ObservableArrayList<Posting>) {
    if(recyclerView.adapter == null) {

    }
    recyclerView.adapter?.notifyDataSetChanged()
}

@BindingAdapter("joinPostAdapter")
fun setJoinPostAdapter(recyclerView: RecyclerView, dataList : ObservableArrayList<Posting>) {
    if(recyclerView.adapter == null) {

    }
    recyclerView.adapter?.notifyDataSetChanged()
}