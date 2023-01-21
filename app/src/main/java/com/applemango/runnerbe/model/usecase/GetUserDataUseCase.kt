package com.applemango.runnerbe.model.usecase

import android.accounts.NetworkErrorException
import android.util.Log
import com.applemango.runnerbe.network.repository.UserRepository
import com.applemango.runnerbe.network.response.CommonResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUserDataUseCase @Inject constructor(private val repo : UserRepository) {

    operator fun invoke(userId: Int) :Flow<CommonResponse> = flow {
        try {
            repo.getUserData(userId).run {
                if(this.body() != null) {
                    emit(CommonResponse.Success(this.body()!!.code, this.body()))
                } else {
                    emit(CommonResponse.Failed(this.body()?.code?:this.code(), this.body()?.message?:this.message()))
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emit(CommonResponse.Failed(999, e.message?:"error"))
        }
    }
}