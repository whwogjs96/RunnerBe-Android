package com.applemango.runnerbe.data.repositoryimpl

import com.applemango.runnerbe.data.network.api.GetBookmarkApi
import com.applemango.runnerbe.domain.repository.PostRepository
import com.applemango.runnerbe.presentation.state.CommonResponse
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val getBookmarkApi: GetBookmarkApi
) : PostRepository {
    override suspend fun getBookmarkList(userId: Int): CommonResponse {
        return try {
            val response = getBookmarkApi.postBookmark(userId)
            if(response.isSuccessful && response.body() != null && response.body()!!.isSuccess) {
                CommonResponse.Success(response.body()!!.code, response.body()!!)
            } else {
                CommonResponse.Failed(response.body()?.code?:response.code(),response.body()?.message?:response.message())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            CommonResponse.Failed(999,e.message?:"error")
        }
    }
}