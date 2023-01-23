package com.applemango.runnerbe.network.repository

import com.applemango.runnerbe.network.response.CommonResponse
import com.applemango.runnerbe.network.response.UserDataResponse
import retrofit2.Response

interface UserRepository {

    suspend fun getUserData(userId : Int) : Response<UserDataResponse>
    suspend fun getRunningTalks() : CommonResponse
    suspend fun withdrawalUser(userId: Int, secretKey: String) : CommonResponse
    suspend fun patchAlarm(userId: Int, pushOn : Boolean) : CommonResponse
    suspend fun nicknameChange(userId: Int, nickname : String) : CommonResponse
    suspend fun jobChange(userId: Int, job : String) : CommonResponse
}