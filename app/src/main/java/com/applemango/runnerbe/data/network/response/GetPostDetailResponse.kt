package com.applemango.runnerbe.data.network.response

import com.applemango.runnerbe.data.dto.PostDetail
import com.google.gson.annotations.SerializedName

data class GetPostDetailResponse(
    @SerializedName("result") val result : PostDetail
) : BaseResponse()
