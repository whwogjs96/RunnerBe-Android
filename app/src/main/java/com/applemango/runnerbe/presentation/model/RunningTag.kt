package com.applemango.runnerbe.presentation.model

enum class RunningTag(val tag: String) {
    After("A"),
    Before("B"),
    Holiday("H");

    companion object {
        fun getByTag(tag: String) : RunningTag? = values().find { it.tag == tag }
    }
}