package com.applemango.runnerbe.screen.compose.login

import com.applemango.runnerbe.network.request.SocialLoginRequest
import com.applemango.runnerbe.network.response.SocialLoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface KakaoLoginAPI {
    @POST("/users/kakao-login")
    suspend fun kakaoLogin(@Body body: SocialLoginRequest) : SocialLoginResponse
}