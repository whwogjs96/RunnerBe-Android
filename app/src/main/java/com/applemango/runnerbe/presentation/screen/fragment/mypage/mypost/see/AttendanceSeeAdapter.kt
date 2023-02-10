package com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost.see

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.UserInfo

class AttendanceSeeAdapter(private val dataList : ObservableArrayList<UserInfo>) : RecyclerView.Adapter<AttendanceSeeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceSeeViewHolder {
        return AttendanceSeeViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_attendance_see,
            parent,
            false
        ))
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: AttendanceSeeViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}