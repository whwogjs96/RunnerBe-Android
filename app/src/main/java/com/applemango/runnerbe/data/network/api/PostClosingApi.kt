package com.applemango.runnerbe.data.network.api

import com.applemango.runnerbe.data.network.response.BaseResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Path

interface PostClosingApi {
    @POST("postings/{postId}/closing")
    suspend fun postClose(@Path("postId") postId: Int) : Response<BaseResponse>
}