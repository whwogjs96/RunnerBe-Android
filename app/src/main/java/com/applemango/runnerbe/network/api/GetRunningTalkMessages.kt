package com.applemango.runnerbe.network.api

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET

interface GetRunningTalkMessages {

    @GET("messages")
    suspend fun getMessages(): Response<JsonObject>
}