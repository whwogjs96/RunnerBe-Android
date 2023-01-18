package com.applemango.runnerbe.model.dto

import com.google.gson.annotations.SerializedName

// 카카오 로그인, 네이버 로그인
data class Login(
    // 비회원
    @SerializedName("uuid") val uuid: String?,
    // 회원
    @SerializedName("userId") val userId: Int?,
    @SerializedName("jwt") val jwt: String?,
    @SerializedName("message") val message: String
)