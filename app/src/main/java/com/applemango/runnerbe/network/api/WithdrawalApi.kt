package com.applemango.runnerbe.network.api

import com.applemango.runnerbe.network.request.WithdrawalUserRequest
import com.applemango.runnerbe.network.response.BaseResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.HTTP
import retrofit2.http.Path

interface WithdrawalApi {
    @HTTP(method = "DELETE", path="users/{userId}",hasBody = true)
    suspend fun withdrawalUser(@Path("userId") userId: Int, @Body request: WithdrawalUserRequest) : Response<BaseResponse>
}