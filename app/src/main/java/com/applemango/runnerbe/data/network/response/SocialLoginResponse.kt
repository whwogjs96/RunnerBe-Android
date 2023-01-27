package com.applemango.runnerbe.data.network.response

import com.applemango.runnerbe.data.dto.Login
import com.google.gson.annotations.SerializedName

data class SocialLoginResponse(
    @SerializedName("result") val result: Login
): BaseResponse()