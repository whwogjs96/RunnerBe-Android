package com.applemango.runnerbe.presentation.model.listener

import com.applemango.runnerbe.data.dto.UserInfo

interface AttendanceAccessionClickListener {
    fun onAcceptClick(userInfo: UserInfo)
    fun onRefuseClick(userInfo: UserInfo)
}