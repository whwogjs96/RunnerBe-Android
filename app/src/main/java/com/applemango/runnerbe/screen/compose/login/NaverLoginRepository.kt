package com.applemango.runnerbe.screen.compose.login

import com.applemango.runnerbe.network.request.SocialLoginRequest
import com.applemango.runnerbe.network.response.SocialLoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NaverLoginRepository @Inject constructor(private val service: NaverLoginAPI) {
    fun getData(body: SocialLoginRequest): Flow<SocialLoginResponse> = flow {
        emit(service.naverLogin(body))
    }.flowOn(Dispatchers.IO)
}