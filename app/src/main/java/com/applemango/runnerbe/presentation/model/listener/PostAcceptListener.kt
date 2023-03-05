package com.applemango.runnerbe.presentation.model.listener

import com.applemango.runnerbe.data.dto.UserInfo

interface PostAcceptListener {
    fun onAcceptClick(userInfo: UserInfo)
    fun onRefuseClick(userInfo: UserInfo)
}