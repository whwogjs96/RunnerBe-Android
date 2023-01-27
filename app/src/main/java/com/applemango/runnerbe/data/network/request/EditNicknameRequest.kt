package com.applemango.runnerbe.data.network.request

import com.google.gson.annotations.SerializedName

data class EditNicknameRequest(
    @SerializedName("nickName") val nickName: String
)