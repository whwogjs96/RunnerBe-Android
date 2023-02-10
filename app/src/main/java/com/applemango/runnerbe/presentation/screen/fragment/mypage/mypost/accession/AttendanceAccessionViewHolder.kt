package com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost.accession

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.data.dto.UserInfo
import com.applemango.runnerbe.databinding.ItemAttendanceAccessionBinding
import com.applemango.runnerbe.presentation.model.listener.AttendanceAccessionClickListener

class AttendanceAccessionViewHolder(
    private val binding: ItemAttendanceAccessionBinding,
    private val accessionClickListener: AttendanceAccessionClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: UserInfo) {
        binding.userInfo = item
        binding.click = accessionClickListener
    }
}