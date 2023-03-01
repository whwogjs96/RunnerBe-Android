package com.applemango.runnerbe.domain.repository

import com.applemango.runnerbe.data.network.request.AttendanceAccessionRequest
import com.applemango.runnerbe.data.network.request.GetRunningListRequest
import com.applemango.runnerbe.data.network.request.WriteRunningRequest
import com.applemango.runnerbe.presentation.state.CommonResponse

interface PostRepository {

    suspend fun getBookmarkList(userId: Int) : CommonResponse
    suspend fun writeRunning(userId: Int, request : WriteRunningRequest) : CommonResponse
    suspend fun getRunningList(runningTag: String, request: GetRunningListRequest) : CommonResponse
    suspend fun attendanceAccession(postId: Int, request: AttendanceAccessionRequest) : CommonResponse
    suspend fun getPostDetail(postId : Int, userId: Int) : CommonResponse
    suspend fun postClosing(postId: Int) : CommonResponse
}