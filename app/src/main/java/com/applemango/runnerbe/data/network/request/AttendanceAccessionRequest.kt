package com.applemango.runnerbe.data.network.request

import com.google.gson.annotations.SerializedName

data class AttendanceAccessionRequest(
    @SerializedName("userIdList") val userIds: String, //"1,2,3" 형태의 String으로 서버에서 받음
    @SerializedName("whetherAttendList") val attendList : String // "Y,N" 형태의 String으로 서버에서 받음
)
