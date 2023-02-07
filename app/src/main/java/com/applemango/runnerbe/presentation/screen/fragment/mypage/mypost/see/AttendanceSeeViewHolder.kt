package com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost.see

import androidx.recyclerview.widget.RecyclerView
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.UserInfo
import com.applemango.runnerbe.databinding.ItemAttendanceSeeBinding
import com.applemango.runnerbe.presentation.model.RunnerDiligence

class AttendanceSeeViewHolder(private val binding : ItemAttendanceSeeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: UserInfo) {
        binding.userInfo = item
        binding.vh = this
    }

    fun getRunnerDiligenceImage(diligence: String?) = when (diligence) {
        RunnerDiligence.EFFORT_RUNNER.value -> {
            R.drawable.ic_effort_runner_face
        }
        RunnerDiligence.ERROR_RUNNER.value -> {
            R.drawable.ic_error_runner_face
        }
        RunnerDiligence.SINCERITY_RUNNER.value -> {
            R.drawable.ic_sincerity_runner_face
        }
        else -> {
            R.drawable.ic_effort_runner_face
        }
    }

    fun getAttendanceMessageResource(userInfo: UserInfo) : Int {
        return if(userInfo.whetherCheck == "Y") {
            if(userInfo.attendance == 1) R.string.msg_attendance_complete
            else R.string.msg_not_attendance_complete
        } else R.string.msg_not_attendance_check
    }

    fun isAttendanceComplete(userInfo: UserInfo) : Boolean {
        return userInfo.whetherCheck == "Y" && userInfo.attendance == 1
    }
}