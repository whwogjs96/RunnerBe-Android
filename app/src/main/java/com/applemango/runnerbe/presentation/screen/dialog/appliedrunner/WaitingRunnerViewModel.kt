package com.applemango.runnerbe.presentation.screen.dialog.appliedrunner

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.data.dto.UserInfo

class WaitingRunnerViewModel : ViewModel() {
    val waitingInfo : ObservableArrayList<UserInfo> = ObservableArrayList()

}