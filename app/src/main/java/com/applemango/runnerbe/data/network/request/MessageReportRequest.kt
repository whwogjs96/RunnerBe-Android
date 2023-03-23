package com.applemango.runnerbe.data.network.request

import com.google.gson.annotations.SerializedName

data class MessageReportRequest(
    @SerializedName("messageIdList") val messageIdList : String //1,2,3 형태로 작성
)
