package com.applemango.runnerbe.presentation.screen.fragment.chat.detail

import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.domain.usecase.runningtalk.GetRunningTalkDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RunningTalkDetailViewModel @Inject constructor(
    private val runningTalkDetailUseCase: GetRunningTalkDetailUseCase
) : ViewModel() {
}