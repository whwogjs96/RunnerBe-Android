package com.applemango.runnerbe.presentation.screen.fragment.map.write.paceselect

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.databinding.ItemPaceRadioBinding
import com.applemango.runnerbe.presentation.model.listener.PaceSelectListener
import com.applemango.runnerbe.presentation.screen.fragment.mypage.paceinfo.PaceSelectItem

class PaceSimpleSelectListViewHolder(
    val binding: ItemPaceRadioBinding,
    val listener: PaceSelectListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PaceSelectItem) {
        binding.item = item
        binding.root.setOnClickListener {
            listener.itemClick(item)
        }
    }
}