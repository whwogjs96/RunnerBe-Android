package com.applemango.runnerbe.domain.entity

enum class Pace(val key: String, val time: String) {
    BEGINNER("beginner","700 ~ 900"),
    AVERAGE("average", "600 ~ 700"),
    HIGH("high", "430 ~ 600"),
    MASTER("master", "430 이하");
}