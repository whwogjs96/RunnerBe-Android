package com.applemango.runnerbe.network.api

import com.applemango.runnerbe.network.request.EditJobRequest
import com.applemango.runnerbe.network.response.BaseResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.Path

interface EditJobApi {
    @PATCH("/users/{userId}/job")
    suspend fun editJob(@Path("userId") userId: Int, @Body body: EditJobRequest) : Response<BaseResponse>
}