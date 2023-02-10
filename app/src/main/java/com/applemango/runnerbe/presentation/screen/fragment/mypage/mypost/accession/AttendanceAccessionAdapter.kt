package com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost.accession

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.UserInfo
import com.applemango.runnerbe.presentation.model.listener.AttendanceAccessionClickListener

class AttendanceAccessionAdapter(
    private val dataList: ObservableArrayList<UserInfo>,
    private val accessionClickListener: AttendanceAccessionClickListener
) : RecyclerView.Adapter<AttendanceAccessionViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AttendanceAccessionViewHolder {
        return AttendanceAccessionViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_attendance_accession,
                parent,
                false
            ), accessionClickListener
        )
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: AttendanceAccessionViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}