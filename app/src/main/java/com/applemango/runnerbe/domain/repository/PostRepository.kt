package com.applemango.runnerbe.domain.repository

import com.applemango.runnerbe.presentation.state.CommonResponse

interface PostRepository {

    suspend fun getBookmarkList(userId: Int) : CommonResponse
}