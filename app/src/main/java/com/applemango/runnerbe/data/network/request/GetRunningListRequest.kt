package com.applemango.runnerbe.data.network.request

import retrofit2.http.Query

data class GetRunningListRequest(
    val whetherEnd: String,
    val priorityFilter : String,
    val distanceFilter : String,
    val gender : String,
    val maxAge : String,
    val minAge : String,
    val jobFilter : String,
    val userLng : Double,
    val userLat : Double,
    val keyword : String = "N",
    val userId : Int?
)
