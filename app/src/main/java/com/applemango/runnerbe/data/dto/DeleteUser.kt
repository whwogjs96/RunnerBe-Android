package com.applemango.runnerbe.data.dto

import com.google.gson.annotations.SerializedName

// 회원탈퇴
data class DeleteUser(
    @SerializedName("deleted userId") val deletedUserId: Int
)