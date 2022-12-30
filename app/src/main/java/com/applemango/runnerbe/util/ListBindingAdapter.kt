package com.applemango.runnerbe.util

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.dto.Posting
import com.applemango.runnerbe.dto.ProfileUrlList
import com.applemango.runnerbe.screen.fragment.mypage.mypost.MyPostAdapter

@BindingAdapter("myPostAdapter")
fun setMyPostAdapter(recyclerView: RecyclerView, dataList : ObservableArrayList<Posting>) {
    recyclerView.adapter = MyPostAdapter(dataList)
    if(recyclerView.adapter == null) {
        recyclerView.adapter = MyPostAdapter(dataList)
    }
    recyclerView.adapter?.notifyDataSetChanged()
}

@BindingAdapter("joinPostAdapter")
fun setJoinPostAdapter(recyclerView: RecyclerView, dataList : ObservableArrayList<Posting>) {
    if(recyclerView.adapter == null) {

    }
    recyclerView.adapter?.notifyDataSetChanged()
}