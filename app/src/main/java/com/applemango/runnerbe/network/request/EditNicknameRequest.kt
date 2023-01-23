package com.applemango.runnerbe.network.request

import com.google.gson.annotations.SerializedName

data class EditNicknameRequest(
    @SerializedName("nickName") val nickName: String
)