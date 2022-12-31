package com.applemango.runnerbe.screen.fragment.mypage.joinpost

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.R
import com.applemango.runnerbe.dto.Posting

class JoinPostAdapter(private val dataList: ObservableArrayList<Posting>) :
    RecyclerView.Adapter<JoinPostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JoinPostViewHolder {
        return JoinPostViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_join_post,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: JoinPostViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size
}