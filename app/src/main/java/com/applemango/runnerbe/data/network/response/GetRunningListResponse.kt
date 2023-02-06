package com.applemango.runnerbe.data.network.response

import com.applemango.runnerbe.data.dto.Posting
import com.google.gson.annotations.SerializedName

data class GetRunningListResponse(
    @SerializedName("result") val runningList: List<Posting>
) : BaseResponse()

data class RunningList(
    @SerializedName("postingResult") var runningList: List<Posting>
)