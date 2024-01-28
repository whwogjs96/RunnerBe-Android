package com.applemango.runnerbe.presentation.screen.fragment.mypage.paceinfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.R
import com.applemango.runnerbe.presentation.model.listener.PaceSelectListener

class PaceInfoListAdapter(
    private val itemList: List<PaceSelectItem>,
    private val listener: PaceSelectListener
) : RecyclerView.Adapter<PaceInfoListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaceInfoListViewHolder {
        return PaceInfoListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_pace_select,
                parent,
                false
            ),
            listener
        )
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: PaceInfoListViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

}