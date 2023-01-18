package com.applemango.runnerbe.model.dto

import com.google.gson.annotations.SerializedName

// 메인페이지(postingResult), 찜목록 조회(bookMarkList), 마이페이지(myPosting, myRunning)
// 게시글 상세(postingInfo)
data class Posting(
    @SerializedName("postId") val postId: Int?,
    @SerializedName("postingTime") val postingTime: String?,
    @SerializedName("postUserId") val postUserId: Int?,
    @SerializedName("nickName") val nickName: String?,
    @SerializedName("profileImageUrl") val profileImageUrl: String??,
    @SerializedName("title") val title: String?,
    @SerializedName("runningTime") val runningTime: String?,
    @SerializedName("gatheringTime") val gatheringTime: String?,
    @SerializedName("gatherLongitude") val gatherLongitude: String?,
    @SerializedName("gatherLatitude") val gatherLatitude: String?,
    @SerializedName("locationInfo") val locationInfo: String?,
    @SerializedName("runningTag") val runningTag: String?,
    @SerializedName("age") val age: String?,
    @SerializedName("DISTANCE") val DISTANCE: String?,
    @SerializedName("gender") val gender: String?,
    // N: 마감X, Y: 마감O
    @SerializedName("whetherEnd") val whetherEnd: String?,
    @SerializedName("job") val job: String?,
    @SerializedName("peopleNum") val peopleNum: Int?,
    @SerializedName("contents") val contents: String?,
    @SerializedName("userId") val userId: Int?,
    // 0이면 찜X, 1이면 찜O
    @SerializedName("bookMark") val bookMark: Int?,
    @SerializedName("attandance") val attandance: Int,
    // 출석처리 여부 Y: 반장이 출석체크O, N: 반장이 출석체크X
    @SerializedName("whetherCheck") val whetherCheck: String?,
    @SerializedName("profileUrlList") val profileUrlList: List<ProfileUrlList>?,
    @SerializedName("runnerList") val runnerList: List<UserInfo>?,
    @SerializedName("whetherPostUser") val whetherPostUser: String?
){
    fun endCheck(): String = if(this.whetherEnd == "Y"){
            "마감된 게시글"
        } else "모집중"

    fun bookmarkCheck(): Boolean {
        return this.bookMark == 1
    }

    fun attentionString(): String {
        return if(this.whetherCheck == "Y") {
            if(this.attandance == 1)"출석을 완료했어요 \uD83D\uDE0E"
            else "불참했어요 \uD83D\uDE2D"
        } else "리더의 체크를 기다리고 있어요 \uD83E\uDD7A"
    }

    fun attentionCheck(): Boolean {
        return this.whetherCheck == "Y" && this.attandance == 1
    }

    fun writerCheck(): Boolean {
        return this.whetherPostUser == "Y"
    }

    fun groupString(): String {
        return this.gender+" "+this.age
    }
}