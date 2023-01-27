package com.applemango.runnerbe.domain.usecase

import com.applemango.runnerbe.domain.repository.UserRepository
import com.applemango.runnerbe.presentation.state.CommonResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PatchUserImageUseCase @Inject constructor(
    private val repo: UserRepository
) {
    operator fun invoke(imageUrl : String?) : Flow<CommonResponse> = flow {
        runCatching {
            emit(CommonResponse.Loading)
            repo.patchUserImage(imageUrl)
        }.onSuccess {
            emit(it)
        }.onFailure { e ->
            e.printStackTrace()
            emit(CommonResponse.Failed(999, e.message?:"error"))
        }
    }
}