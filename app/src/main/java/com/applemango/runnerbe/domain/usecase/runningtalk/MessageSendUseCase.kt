package com.applemango.runnerbe.domain.usecase.runningtalk

import com.applemango.runnerbe.domain.repository.RunningTalkRepository
import com.applemango.runnerbe.presentation.state.CommonResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MessageSendUseCase @Inject constructor(
    private val repo: RunningTalkRepository
) {
    operator fun invoke(roomId: Int, content: String): Flow<CommonResponse> = flow {
        runCatching {
            emit(CommonResponse.Loading)
            repo.sendMessage(roomId, content)
        }.onSuccess {
            emit(it)
        }.onFailure {
            it.printStackTrace()
            emit(CommonResponse.Failed(999, it.message?:"error"))
        }
    }
}