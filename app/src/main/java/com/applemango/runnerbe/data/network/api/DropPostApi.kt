package com.applemango.runnerbe.data.network.api

import com.applemango.runnerbe.data.network.response.BaseResponse
import retrofit2.Response
import retrofit2.http.PATCH
import retrofit2.http.Path

interface DropPostApi {

    @PATCH("/postings/{postId}/{userId}/drop")
    suspend fun dropPost(@Path("postId") postId: Int, @Path("userId") userId: Int) : Response<BaseResponse>
}