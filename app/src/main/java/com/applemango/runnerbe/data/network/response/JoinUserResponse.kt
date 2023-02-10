package com.applemango.runnerbe.data.network.response

import com.applemango.runnerbe.data.dto.Register
import com.google.gson.annotations.SerializedName

data class JoinUserResponse(
    @SerializedName("result") val result: Register
): BaseResponse()