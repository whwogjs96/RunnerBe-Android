package com.applemango.runnerbe.domain.repository

import com.applemango.runnerbe.data.network.response.CommonResponse

interface RunningTalkRepository {
    suspend fun getRunningTalks(): CommonResponse
}