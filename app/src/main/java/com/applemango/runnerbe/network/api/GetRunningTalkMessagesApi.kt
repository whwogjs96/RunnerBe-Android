package com.applemango.runnerbe.network.api

import com.applemango.runnerbe.network.response.RunningTalksResponse
import retrofit2.Response
import retrofit2.http.GET

interface GetRunningTalkMessagesApi {

    @GET("messages")
    suspend fun getMessages(): Response<RunningTalksResponse>
}