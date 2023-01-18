package com.applemango.runnerbe.model.dto

import com.google.gson.annotations.SerializedName

// 회원탈퇴
data class DeleteUser(
    @SerializedName("deleted userId") val deletedUserId: Int
)