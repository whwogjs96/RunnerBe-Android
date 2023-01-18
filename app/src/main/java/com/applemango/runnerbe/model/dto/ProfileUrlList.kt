package com.applemango.runnerbe.model.dto

import com.google.gson.annotations.SerializedName

data class ProfileUrlList(
    @SerializedName("userId") val userId: Int,
    @SerializedName("profileImageUrl") val profileImageUrl: String?
)