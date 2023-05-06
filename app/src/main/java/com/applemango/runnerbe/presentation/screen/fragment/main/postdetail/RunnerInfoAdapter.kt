package com.applemango.runnerbe.presentation.screen.fragment.main.postdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.UserInfo

class RunnerInfoAdapter(private val dataList : ObservableArrayList<UserInfo>) :RecyclerView.Adapter<RunnerInfoViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunnerInfoViewHolder {
        return RunnerInfoViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_runner_info,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: RunnerInfoViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}