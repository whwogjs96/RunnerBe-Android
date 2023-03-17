package com.applemango.runnerbe.presentation.screen.fragment.chat.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.Messages

//걍 뷰타입으로 ViewHolder 생성한 다음, holder를 스마트캐스트해서 사용...
class RunningTalkDetailAdapter(
    private val dataList: ObservableArrayList<Messages>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == RunningTalkViewType.Me.type) RunningTalkDetailMyViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_my_talk,
                parent,
                false
            )
        ) else RunningTalkDetailOtherViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_other_talk,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is RunningTalkDetailMyViewHolder) {
            holder.bind(dataList[position])
        } else if(holder is RunningTalkDetailOtherViewHolder) {
            holder.bind(dataList[position])
        }
    }

    override fun getItemViewType(position: Int): Int =
        if (dataList[position].from == "Me") RunningTalkViewType.Me.type
        else RunningTalkViewType.Other.type

}

enum class RunningTalkViewType(val type: Int) {
    Me(0),
    Other(1);
}