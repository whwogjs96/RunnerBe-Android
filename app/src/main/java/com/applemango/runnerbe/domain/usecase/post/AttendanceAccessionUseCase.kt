package com.applemango.runnerbe.domain.usecase.post

import com.applemango.runnerbe.data.network.request.AttendanceAccessionRequest
import com.applemango.runnerbe.domain.repository.PostRepository
import com.applemango.runnerbe.presentation.state.CommonResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AttendanceAccessionUseCase @Inject constructor(private val repo: PostRepository) {

    operator fun invoke(postId : Int, userIds: List<String>, whetherAttendList : List<String>) : Flow<CommonResponse> = flow {
        runCatching {
            emit(CommonResponse.Loading)
            repo.attendanceAccession(postId, request = AttendanceAccessionRequest(userIds, whetherAttendList))
        }.onSuccess {
            emit(it)
        }.onFailure {
            it.printStackTrace()
            emit(CommonResponse.Failed(999, it.message ?: "error"))
        }
    }
}