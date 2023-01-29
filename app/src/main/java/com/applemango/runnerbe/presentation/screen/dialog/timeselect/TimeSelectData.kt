package com.applemango.runnerbe.presentation.screen.dialog.timeselect

data class TimeSelectData(
    val hour: String,
    val minute : String
) {

    fun getFullDisplayTime() = "$hour 시간 ${if(minute.toInt() in 1 .. 9) "0$minute" else minute} 분"
    companion object {
        fun getDefaultTimeData() = TimeSelectData(hour = "0", minute = "00")
    }
}
