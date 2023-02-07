package com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.ItemMyPostBinding
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.presentation.model.listener.MyPostClickListener
import com.applemango.runnerbe.util.dateStringToLongTime
import com.applemango.runnerbe.util.timeStringToLongTime
import java.util.*

class MyPostViewHolder(
    val binding: ItemMyPostBinding,
    private val myPostClickListener: MyPostClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Posting) {
        binding.holderModel = item
        val now = Calendar.getInstance().time
        binding.checkButton.isEnabled = item.gatheringTime != null && item.runningTime != null && now.time - dateStringToLongTime(item.gatheringTime) > 0
        binding.checkButton.setOnClickListener {
            if(item.gatheringTime != null && item.runningTime != null) {
                if(isPassedAttendanceAccessionPeriod(item.gatheringTime, item.runningTime)) {
                    myPostClickListener.attendanceSeeOnClick(item)
                } else myPostClickListener.attendanceManagingOnClick(item)
            }

        }
    }

    private fun isPassedAttendanceAccessionPeriod(gatheringTime : String, runningTime : String) : Boolean {
        val now = Calendar.getInstance().time
        val threeHour = 3 * 60 * 60
        val startTime = dateStringToLongTime(gatheringTime)
        val runningTimeLong = timeStringToLongTime(runningTime)
        return if(now.time - startTime > 0) {
            startTime + threeHour + runningTimeLong - now.time <= 0
        } else false
    }
}