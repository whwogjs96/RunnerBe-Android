package com.applemango.runnerbe.data.network.response

import com.applemango.runnerbe.data.dto.Posting
import com.google.gson.annotations.SerializedName

data class GetBookmarkResponse(
    @SerializedName("result") val result : BookmarkList
) : BaseResponse()

data class BookmarkList(
    @SerializedName("bookMarkList") var bookMarkList: List<Posting>?
)