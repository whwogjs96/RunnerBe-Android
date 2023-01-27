package com.applemango.runnerbe.domain.repository

import com.applemango.runnerbe.presentation.state.CommonResponse

interface RunningTalkRepository {
    suspend fun getRunningTalks(): CommonResponse
}