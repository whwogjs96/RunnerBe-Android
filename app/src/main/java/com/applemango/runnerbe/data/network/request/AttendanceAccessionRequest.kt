package com.applemango.runnerbe.data.network.request

import com.google.gson.annotations.SerializedName

data class AttendanceAccessionRequest(
    @SerializedName("userIdList") val userIds: List<String>,
    @SerializedName("whetherAttendList") val attendList : List<String>
)
