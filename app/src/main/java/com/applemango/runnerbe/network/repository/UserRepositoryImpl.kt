package com.applemango.runnerbe.network.repository

import android.accounts.NetworkErrorException
import com.applemango.runnerbe.network.api.GetRunningTalkMessagesApi
import com.applemango.runnerbe.network.api.GetUserDataApi
import com.applemango.runnerbe.network.response.CommonResponse
import com.applemango.runnerbe.network.response.RunningTalksResponse
import com.applemango.runnerbe.network.response.UserDataResponse
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val getUserDataApi: GetUserDataApi,
    private val getRunningTalkMessagesApi: GetRunningTalkMessagesApi
    )
    : UserRepository {
    override suspend fun getUserData(userId: Int): Response<UserDataResponse> =
        getUserDataApi.getUserData(userId)

    override suspend fun getRunningTalks(): CommonResponse {
        return try {
            val response = getRunningTalkMessagesApi.getMessages()
            if(response.isSuccessful && response.body() != null && response.body()!!.isSuccess) {
                CommonResponse.Success(response.body()!!)
            } else {
                CommonResponse.Failed(response.body()?.message?:response.message())
            }
        }catch (e: Exception){
            e.printStackTrace()
            CommonResponse.Failed(e.message?:"errora")
        }
    }
}