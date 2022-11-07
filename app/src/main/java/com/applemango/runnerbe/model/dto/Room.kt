package com.applemango.runnerbe.dto

import com.google.gson.annotations.SerializedName

data class Room(
    @SerializedName("roomId") val roomId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("repUserName") val repUserName: String,
    @SerializedName("profileImageUrl") val profileImageUrl: String,
    @SerializedName("recentMessage") val recentMessage: String
)