package com.applemango.runnerbe.data.repositoryimpl

import com.applemango.runnerbe.domain.repository.RunningTalkRepository
import com.applemango.runnerbe.data.network.api.GetRunningTalkMessagesApi
import com.applemango.runnerbe.presentation.state.CommonResponse
import javax.inject.Inject

class RunningTalkRepositoryImpl @Inject constructor(
    private val getRunningTalkMessagesApi: GetRunningTalkMessagesApi
) : RunningTalkRepository {
    override suspend fun getRunningTalks(): CommonResponse {
        return try {
            val response = getRunningTalkMessagesApi.getMessages()
            if(response.isSuccessful && response.body() != null && response.body()!!.isSuccess) {
                CommonResponse.Success(response.body()!!.code, response.body()!!)
            } else {
                CommonResponse.Failed(response.body()?.code?:response.code(),response.body()?.message?:response.message())
            }
        }catch (e: Exception) {
            e.printStackTrace()
            CommonResponse.Failed(999,e.message?:"error")
        }
    }
}