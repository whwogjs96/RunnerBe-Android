package com.applemango.runnerbe.network.response

import com.applemango.runnerbe.model.dto.Room
import com.google.gson.annotations.SerializedName

data class RunningTalksResponse(
    @SerializedName("result") val result : List<Room>
) : BaseResponse()