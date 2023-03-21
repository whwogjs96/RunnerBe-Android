package com.applemango.runnerbe.data.network.request

import com.google.gson.annotations.SerializedName

data class MessageReportRequest(
    @SerializedName("messageIdList") val messageIdList : List<String>
)
