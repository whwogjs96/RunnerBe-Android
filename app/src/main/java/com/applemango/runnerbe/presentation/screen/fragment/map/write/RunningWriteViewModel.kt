package com.applemango.runnerbe.presentation.screen.fragment.map.write

import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.R
import com.applemango.runnerbe.presentation.screen.dialog.dateselect.DateSelectData
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.*

class RunningWriteViewModel : ViewModel() {

    val radioChecked : MutableStateFlow<Int> = MutableStateFlow(R.id.beforeTab)
    val runningTitle : MutableStateFlow<String> = MutableStateFlow("")
    var runningDate : Date = Calendar.getInstance().time
    var runningDisplayDate : MutableStateFlow<DateSelectData> = MutableStateFlow(DateSelectData.defaultNowDisplayDate())

}