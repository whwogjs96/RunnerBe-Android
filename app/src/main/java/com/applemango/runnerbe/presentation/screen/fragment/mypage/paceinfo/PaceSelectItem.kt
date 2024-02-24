package com.applemango.runnerbe.presentation.screen.fragment.mypage.paceinfo

import com.applemango.runnerbe.R
import com.applemango.runnerbe.RunnerBeApplication
import com.applemango.runnerbe.domain.entity.Pace

data class PaceSelectItem(
    val pace: Pace,
    val paceImageResource: Int,
    val paceDescription : String,
    var isSelected: Boolean
)

fun initPaceInfoList() : List<PaceSelectItem> {
    val context = RunnerBeApplication.ApplicationContext()
    return listOf(
        PaceSelectItem(
            pace = Pace.BEGINNER,
            paceImageResource = R.drawable.ic_beginner_pace,
            paceDescription = context.getString(R.string.beginner_pace_runner_description),
            isSelected = false
        ),
        PaceSelectItem(
            pace = Pace.AVERAGE,
            paceImageResource = R.drawable.ic_general_pace,
            paceDescription = context.getString(R.string.general_pace_runner_description),
            isSelected = false
        ),
        PaceSelectItem(
            pace = Pace.HIGH,
            paceImageResource = R.drawable.ic_master_pace,
            paceDescription = context.getString(R.string.master_pace_runner_description),
            isSelected = false
        ),
        PaceSelectItem(
            pace = Pace.MASTER,
            paceImageResource = R.drawable.ic_grand_matser_pace,
            paceDescription = context.getString(R.string.grand_matser_pace_runner_description),
            isSelected = false
        )
    )
}