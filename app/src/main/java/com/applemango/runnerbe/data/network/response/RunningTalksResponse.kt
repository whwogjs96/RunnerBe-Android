package com.applemango.runnerbe.data.network.response

import com.applemango.runnerbe.data.dto.Room
import com.google.gson.annotations.SerializedName

data class RunningTalksResponse(
    @SerializedName("result") val result : List<Room>
) : BaseResponse()