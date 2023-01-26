package com.applemango.runnerbe.data.dto

import com.google.gson.annotations.SerializedName
import java.util.*

data class Alarm(
    @SerializedName("alarmId") val alarmId: Int,
    @SerializedName("userId") val userId: Int,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("whetherRead") val whetherRead: String
){
    fun readCheck(): Boolean {
        return this.whetherRead == "Y"
    }
}