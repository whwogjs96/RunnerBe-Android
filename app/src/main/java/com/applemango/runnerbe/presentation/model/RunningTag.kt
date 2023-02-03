package com.applemango.runnerbe.presentation.model

import com.applemango.runnerbe.R
import com.applemango.runnerbe.RunnerBeApplication

enum class RunningTag(val tag: String) {
    After("A"),
    Before("B"),
    Holiday("H");

    companion object {
        fun getByTag(tag: String) : RunningTag? = values().find { it.tag == tag }
    }

    fun getTagNameResource() : Int {
        return when(tag) {
            After.tag -> R.string.after_work
            Holiday.tag -> R.string.holiday
            else -> R.string.before_work
        }
    }
}