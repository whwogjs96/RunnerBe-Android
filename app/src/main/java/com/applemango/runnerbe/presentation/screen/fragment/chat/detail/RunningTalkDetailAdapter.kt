package com.applemango.runnerbe.presentation.screen.fragment.chat.detail

import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.data.dto.Messages

//걍 뷰타입으로 ViewHolder 생성한 다음, holder를 스마트캐스트해서 사용...
class RunningTalkDetailAdapter(
    private val dataList: ObservableArrayList<Messages>
    ) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}