package com.applemango.runnerbe.network.api

import com.applemango.runnerbe.network.request.EditNicknameRequest
import com.applemango.runnerbe.network.response.BaseResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.Path

interface NicknameChangeApi {
    @PATCH("/users/{userId}/name")
    suspend fun editNickname(@Path("userId") userId: Int, @Body body: EditNicknameRequest) : Response<BaseResponse>
}