package com.applemango.runnerbe.data.network.response

import com.applemango.runnerbe.data.dto.RoomDetail
import com.google.gson.annotations.SerializedName

data class RunningTalkDetailResponse(
    @SerializedName("result") val result : RoomDetail //테스트 필요, array 인지 그냥인지
) : BaseResponse()
