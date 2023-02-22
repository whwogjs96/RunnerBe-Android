package com.applemango.runnerbe.presentation.model.listener

import com.applemango.runnerbe.data.dto.Posting

interface MyPostClickListener {
    fun bodyOnClick(post: Posting)
    fun attendanceSeeOnClick(post: Posting)
    fun attendanceManagingOnClick(post: Posting)
}