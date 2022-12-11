package com.applemango.runnerbe.screen.compose.login

import com.applemango.runnerbe.network.request.SocialLoginRequest
import com.applemango.runnerbe.network.response.SocialLoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface NaverLoginAPI {
    @POST("/users/naver-login")
    suspend fun naverLogin(@Body body: SocialLoginRequest) : SocialLoginResponse
}