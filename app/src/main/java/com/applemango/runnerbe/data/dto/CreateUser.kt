package com.applemango.runnerbe.data.dto

import com.google.gson.annotations.SerializedName

data class CreateUser(
    @SerializedName("uuid") val uuid: String,
    @SerializedName("nickName") val nickName: String,
    @SerializedName("birthday") val birthday: Int,
    @SerializedName("gender") val gender: String,
    @SerializedName("job") val job: String,
    @SerializedName("deviceToken") val deviceToken: String
)