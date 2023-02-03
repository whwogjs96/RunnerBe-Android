package com.applemango.runnerbe.presentation.screen.fragment.map.filter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.R
import com.applemango.runnerbe.RunnerBeApplication
import com.applemango.runnerbe.presentation.model.GenderTag
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class RunningFilterViewModel: ViewModel() {

    val genderRadioChecked : MutableStateFlow<Int> = MutableStateFlow(R.id.allTab)
    val jobRadioChecked : MutableStateFlow<Int> = MutableStateFlow(-1)
    val isAllAgeChecked : MutableStateFlow<Boolean> = MutableStateFlow(false)
    val recruitmentStartAge : MutableStateFlow<Int> = MutableStateFlow(20)
    val recruitmentEndAge : MutableStateFlow<Int> = MutableStateFlow(40)
    val recruitmentAge = combine(recruitmentStartAge, recruitmentEndAge) { start, end ->
        RunnerBeApplication.ApplicationContext().resources.getString(R.string.display_recruitment_age_setting, start.toString(), end.toString())
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(1000L),
        initialValue = ""
    )

    fun getGenderTag() = when (genderRadioChecked.value) {
        R.id.maleTab -> GenderTag.MALE
        R.id.femaleTab -> GenderTag.FEMALE
        else -> GenderTag.ALL
    }
}