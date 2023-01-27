package com.applemango.runnerbe.data.network.request

import com.google.gson.annotations.SerializedName

data class PatchUserImgRequest(
    @SerializedName("profileImageUrl") val profileImageUrl: String?
)