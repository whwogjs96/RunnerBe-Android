package com.applemango.runnerbe.presentation.model

import com.applemango.runnerbe.R

enum class GenderTag(val tag: String) {
    ALL("A"),
    MALE("M"),
    FEMALE("F");

    companion object {
        fun findByTag(tag : String) : GenderTag? = values().find { it.tag == tag }
    }

    fun getTagNameResource() : Int {
        return when(tag) {
            MALE.tag -> R.string.male
            FEMALE.tag -> R.string.female
            else -> R.string.all
        }
    }

}