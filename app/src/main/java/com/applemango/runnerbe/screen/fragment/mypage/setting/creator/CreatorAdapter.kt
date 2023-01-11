package com.applemango.runnerbe.screen.fragment.mypage.setting.creator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.R
import com.applemango.runnerbe.model.CreatorImageAndPosition

class CreatorAdapter(private val dataList: List<CreatorImageAndPosition>) :
    RecyclerView.Adapter<CreatorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatorViewHolder {
        return CreatorViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_creator,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CreatorViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size
}