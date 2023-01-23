package com.applemango.runnerbe.model.usecase

import com.applemango.runnerbe.network.repository.UserRepository
import com.applemango.runnerbe.network.response.CommonResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NicknameChangeUseCase @Inject constructor(private val repo : UserRepository) {

    operator fun invoke(userId: Int, nickname : String) : Flow<CommonResponse> = flow  {
        runCatching {
            emit(CommonResponse.Loading)
            repo.nicknameChange(userId, nickname)
        }.onSuccess {
            emit(it)
        }.onFailure { e->
            e.printStackTrace()
            emit(CommonResponse.Failed(999, e.message?:"error"))
        }
    }
}