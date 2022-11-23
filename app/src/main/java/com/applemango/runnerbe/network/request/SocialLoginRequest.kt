package com.applemango.runnerbe.network.request

import com.google.gson.annotations.SerializedName

data class SocialLoginRequest(
    @SerializedName("accessToken") val accessToken: String
)