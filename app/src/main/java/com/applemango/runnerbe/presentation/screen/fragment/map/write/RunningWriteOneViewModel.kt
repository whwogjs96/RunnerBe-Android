package com.applemango.runnerbe.presentation.screen.fragment.map.write

import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.R
import com.applemango.runnerbe.presentation.screen.dialog.dateselect.DateSelectData
import com.applemango.runnerbe.presentation.screen.dialog.timeselect.TimeSelectData
import com.naver.maps.geometry.LatLng
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.*

class RunningWriteOneViewModel : ViewModel() {

    val radioChecked : MutableStateFlow<Int> = MutableStateFlow(R.id.beforeTab)
    val runningTitle : MutableStateFlow<String> = MutableStateFlow("")
    var runningDate : Date = Calendar.getInstance().time
    val runningDisplayDate : MutableStateFlow<DateSelectData> = MutableStateFlow(DateSelectData.defaultNowDisplayDate())
    val runningDisplayTime : MutableStateFlow<TimeSelectData> = MutableStateFlow(TimeSelectData.getDefaultTimeData())

//    val coordinate : MutableStateFlow<LatLng> = MutableStateFlow(LatLng(0.0, 0.0))
    var coordinate = LatLng(0.0, 0.0)
}