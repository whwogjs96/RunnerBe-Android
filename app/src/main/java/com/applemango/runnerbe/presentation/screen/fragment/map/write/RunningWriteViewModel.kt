package com.applemango.runnerbe.presentation.screen.fragment.map.write

import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.R
import kotlinx.coroutines.flow.MutableStateFlow

class RunningWriteViewModel : ViewModel() {

    val radioChecked : MutableStateFlow<Int> = MutableStateFlow(R.id.beforeTab)

}