package com.applemango.runnerbe.network.repository

import com.applemango.runnerbe.network.response.UserDataResponse
import retrofit2.Response

interface UserRepository {

    suspend fun getUserData(userId : Int) : Response<UserDataResponse>
}