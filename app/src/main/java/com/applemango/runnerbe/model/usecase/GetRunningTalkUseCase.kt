package com.applemango.runnerbe.model.usecase

import com.applemango.runnerbe.network.repository.UserRepository
import com.applemango.runnerbe.network.response.CommonResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRunningTalkUseCase @Inject constructor(private val repo : UserRepository) {
    operator fun invoke() : Flow<CommonResponse> = flow {
        runCatching {
            emit(CommonResponse.Loading)
            repo.getRunningTalks()
        }.onSuccess {
            emit(it)
        }.onFailure {
            it.printStackTrace()
            emit(CommonResponse.Failed(it.message?:"error"))
        }
    }
}