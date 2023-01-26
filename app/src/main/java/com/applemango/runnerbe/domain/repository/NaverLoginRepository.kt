package com.applemango.runnerbe.domain.repository

import com.applemango.runnerbe.data.network.api.NaverLoginAPI
import com.applemango.runnerbe.data.network.request.SocialLoginRequest
import com.applemango.runnerbe.data.network.response.SocialLoginResponse
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