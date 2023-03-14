package com.applemango.runnerbe.presentation.model.listener

import com.applemango.runnerbe.data.dto.Room

interface RoomClickListener {

    fun moveToRunningTalkRoom(item : Room)
}