package com.applemango.runnerbe.dto

import com.google.gson.annotations.SerializedName

// 마이페이지(UserInfo), 게시글 상세(runnerInfo, waitingRunnerInfo)
data class UserInfo(
    @SerializedName("userId") val userId: Int?,
    @SerializedName("nickName") val nickName: String?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("age") val age: String?,
    @SerializedName("diligence") val diligence: String?,
    @SerializedName("job") val job: String?,
    @SerializedName("profileImageUrl") val profileImageUrl: String?,
    // Y : 수신동의, N : 수신거부
    @SerializedName("pushOn") val pushOn: String?,
    // 게시글 상세 Y: 출석체크 실시함, N: 출석체크 아직 안함
    @SerializedName("whetherCheck") val whetherCheck: String?,
    // 1: 출석O, 0: 출석X
    @SerializedName("attendance") val attendance: Int?,
    // 게시글 상세(작성자에서만) N: 대기중인 러너
    @SerializedName("whetherAccept") val whetherAccept: String?,
    // 닉네임 변경되었는지
    @SerializedName("nameChanged") val nameChanged: String?,
    // 직군변경할 수 있는지 Y : 가능 N : 불가능
    @SerializedName("jobChangePossible") val jobChangePossible: String?
)