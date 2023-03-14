package com.applemango.runnerbe.presentation.screen.fragment.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.Room
import com.applemango.runnerbe.presentation.model.listener.RoomClickListener

class RunningTalkAdapter(
    private val dataList: ObservableArrayList<Room>,
    private val roomClickListener: RoomClickListener
) : RecyclerView.Adapter<RunningTalkViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunningTalkViewHolder {
        return RunningTalkViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_running_talk,
                parent,
                false
            ), roomClickListener
        )
    }

    override fun onBindViewHolder(holder: RunningTalkViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size
}