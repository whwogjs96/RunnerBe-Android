package com.applemango.runnerbe.model.dto

import com.google.gson.annotations.SerializedName

data class Reports(
    @SerializedName("messageId") val messageId: Int,
    @SerializedName("content") val content: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("userId") val userId: Int,
    @SerializedName("nickName") val nickName: String,
    @SerializedName("profileImageUrl") val profileImageUrl: String,
    // me 이면 내가 보낸것, other 이면 다른사람이 보낸것
    @SerializedName("messageFrom") val messageFrom: String,
    // Y이면 글쓴이, 아니먄 N
    @SerializedName("whetherPostUser") val whetherPostUser: String,
    var reportCheck: Boolean = false
) {
    fun meCheck(): Boolean {
        return if (this.messageFrom == "me") return true
        else false
    }
    fun writerCheck() : Boolean {
        return if(this.whetherPostUser == "Y") return true
        else false
    }
}

fun mapperMessageToReports(item: Message): Reports {
    return Reports(
        messageId = item.messageId,
        content = item.content,
        createdAt = item.createdAt,
        userId = item.userId,
        nickName = item.nickName,
        profileImageUrl = item.profileImageUrl,
        messageFrom = item.messageFrom,
        whetherPostUser = item.whetherPostUser,
        reportCheck = false
    )
}
