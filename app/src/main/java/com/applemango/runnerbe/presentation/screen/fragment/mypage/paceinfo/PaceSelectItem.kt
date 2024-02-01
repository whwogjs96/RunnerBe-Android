package com.applemango.runnerbe.presentation.screen.fragment.mypage.paceinfo

import com.applemango.runnerbe.domain.entity.Pace

data class PaceSelectItem(
    val pace: Pace,
    val paceImageResource: Int,
    val paceDescription : String,
    var isSelected: Boolean
)
