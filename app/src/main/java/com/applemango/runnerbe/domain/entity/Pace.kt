package com.applemango.runnerbe.domain.entity

import com.applemango.runnerbe.R
import com.applemango.runnerbe.RunnerBeApplication

enum class Pace(val key: String, val time: String) {
    BEGINNER("beginner","700 ~ 900"),
    AVERAGE("average", "600 ~ 700"),
    HIGH("high", "430 ~ 600"),
    MASTER("master", "430 이하");

    fun getPaceName() : String {
        val context = RunnerBeApplication.ApplicationContext()
        return context.getString(
            when(this.key) {
                BEGINNER.key -> R.string.beginner_pace_runner //입문
                AVERAGE.key -> R.string.general_pace_runner //평균
                HIGH.key -> R.string.master_pace_runner//고수
                else -> R.string.grand_matser_pace_runner //초고수
            }
        )
    }
}

