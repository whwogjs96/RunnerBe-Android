package com.applemango.runnerbe.network.api

import retrofit2.http.DELETE

interface WithdrawalApi {
    @DELETE("users/{userId}")
    suspend fun withdrawalUser()
}