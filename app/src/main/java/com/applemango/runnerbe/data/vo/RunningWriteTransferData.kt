package com.applemango.runnerbe.data.vo

import android.os.Parcelable
import com.applemango.runnerbe.presentation.model.RunningTag
import com.applemango.runnerbe.presentation.screen.dialog.dateselect.DateSelectData
import com.applemango.runnerbe.presentation.screen.dialog.timeselect.TimeSelectData
import com.naver.maps.geometry.LatLng
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class RunningWriteTransferData(
    val runningTitle: String,
    val runningDate : Date,
    val runningDisplayDate : DateSelectData,
    val runningDisplayTime : TimeSelectData,
    val coordinate : LatLng,
    val runningTag : RunningTag
): Parcelable
