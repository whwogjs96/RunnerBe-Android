package com.applemango.runnerbe.network.repository

import com.applemango.runnerbe.network.api.GetUserDataApi
import com.applemango.runnerbe.network.response.UserDataResponse
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val getUserDataApi: GetUserDataApi)
    : UserRepository {
    override suspend fun getUserData(userId: Int): Response<UserDataResponse> =
        getUserDataApi.getUserData(userId)
}