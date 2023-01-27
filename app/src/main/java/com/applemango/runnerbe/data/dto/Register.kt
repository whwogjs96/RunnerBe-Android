package com.applemango.runnerbe.data.dto

import com.google.gson.annotations.SerializedName

// 회원가입
data class Register(
    @SerializedName("insertedUserId") val insertedUserId: Int,
    @SerializedName("token") val token: String
)