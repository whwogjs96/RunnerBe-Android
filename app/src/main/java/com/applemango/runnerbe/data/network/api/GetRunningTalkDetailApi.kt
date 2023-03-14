package com.applemango.runnerbe.data.network.api

import com.applemango.runnerbe.data.network.response.RunningTalkDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GetRunningTalkDetailApi {

    @GET("/messages/rooms/{roomId}")
    suspend fun getRunningTalkDetail(@Path("roomId") roomId : Int):Response<RunningTalkDetailResponse>
}