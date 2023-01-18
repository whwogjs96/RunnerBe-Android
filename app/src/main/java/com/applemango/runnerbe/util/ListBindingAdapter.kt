package com.applemango.runnerbe.util

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.model.dto.Posting
import com.applemango.runnerbe.model.CreatorImageAndPosition
import com.applemango.runnerbe.model.dto.Room
import com.applemango.runnerbe.screen.fragment.chat.RunningTalkAdapter
import com.applemango.runnerbe.screen.fragment.mypage.joinpost.JoinPostAdapter
import com.applemango.runnerbe.screen.fragment.mypage.mypost.MyPostAdapter
import com.applemango.runnerbe.screen.fragment.mypage.setting.creator.CreatorAdapter

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
        recyclerView.adapter = JoinPostAdapter(dataList)
    }
    recyclerView.adapter?.notifyDataSetChanged()
}

@BindingAdapter("creatorAdapter")
fun setCreatorAdapter(recyclerView: RecyclerView, dataList: List<CreatorImageAndPosition>) {
    if(recyclerView.adapter == null) {
        recyclerView.adapter = CreatorAdapter(dataList)
    }
    recyclerView.adapter?.notifyDataSetChanged()
}

@BindingAdapter("runningTalkListAdapter")
fun setRunningTalkListAdapter(recyclerView: RecyclerView, dataList: ObservableArrayList<Room>) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = RunningTalkAdapter(dataList)
    }
    recyclerView.adapter?.notifyDataSetChanged()
}