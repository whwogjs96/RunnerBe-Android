package com.applemango.runnerbe.network.response

import com.applemango.runnerbe.dto.Posting
import com.applemango.runnerbe.dto.UserInfo
import com.google.gson.annotations.SerializedName

data class UserDataResponse(
    @SerializedName("result") val result : GetMyPageResult
) : BaseResponse()

data class GetMyPageResult(
    @SerializedName("myInfo") val userInfo: List<UserInfo>,
    @SerializedName("myPosting") val posting: List<Posting>,
    @SerializedName("myRunning") val myRunning: List<Posting>
)