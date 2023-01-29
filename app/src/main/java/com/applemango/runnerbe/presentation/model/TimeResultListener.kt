package com.applemango.runnerbe.presentation.model

import com.applemango.runnerbe.presentation.screen.dialog.timeselect.TimeSelectData

interface TimeResultListener {
    fun getDate(displayTime : TimeSelectData) {

    }
}