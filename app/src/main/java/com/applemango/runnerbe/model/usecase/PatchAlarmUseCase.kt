package com.applemango.runnerbe.model.usecase

import android.util.Log
import com.applemango.runnerbe.network.repository.UserRepository
import com.applemango.runnerbe.network.response.CommonResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PatchAlarmUseCase @Inject constructor(private val repo: UserRepository) {

    operator fun invoke(userId: Int, pushOn : Boolean) : Flow<CommonResponse> = flow {
        runCatching {
            emit(CommonResponse.Loading)
            repo.patchAlarm(userId, pushOn)
        }.onSuccess {
            emit(it)
        }.onFailure { e ->
            e.printStackTrace()
            emit(CommonResponse.Failed(999, e.message?:"error"))
        }
    }
}