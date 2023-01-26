package com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.Posting

class MyPostAdapter(private val dataList: ObservableArrayList<Posting>) :
    RecyclerView.Adapter<MyPostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPostViewHolder {
        return MyPostViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_my_post,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyPostViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size
}