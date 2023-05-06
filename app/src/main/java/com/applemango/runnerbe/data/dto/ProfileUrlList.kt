package com.applemango.runnerbe.data.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileUrlList(
    @SerializedName("userId") val userId: Int,
    @SerializedName("profileImageUrl") val profileImageUrl: String?
): Parcelable