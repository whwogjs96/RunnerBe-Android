package com.applemango.runnerbe.network.response

import com.applemango.runnerbe.dto.Login
import com.google.gson.annotations.SerializedName

data class SocialLoginResponse(
    @SerializedName("result") val result: Login
): BaseResponse()