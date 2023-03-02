package com.applemango.runnerbe.data.dto

import com.google.gson.annotations.SerializedName

data class PostDetail(
    @SerializedName("postingInfo") val postList : List<Posting>,
    @SerializedName("runnerInfo") val runnerInfo : List<UserInfo>?,
    @SerializedName("waitingRunnerInfo") val waitingRunnerInfo : List<UserInfo>?
)
