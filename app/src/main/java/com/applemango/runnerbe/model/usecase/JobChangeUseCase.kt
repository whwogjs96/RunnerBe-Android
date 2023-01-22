package com.applemango.runnerbe.model.usecase

import com.applemango.runnerbe.network.repository.UserRepository
import com.applemango.runnerbe.network.response.CommonResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JobChangeUseCase @Inject constructor(
    private val repo : UserRepository
) {

    operator fun invoke(userId: Int, job: String) : Flow<CommonResponse> = flow  {
        runCatching {
            emit(CommonResponse.Loading)
            repo.jobChange(userId, job)
        }.onSuccess {
            emit(it)
        }.onFailure { e ->
            emit(CommonResponse.Failed(999, e.message?:"error"))
        }
    }
}