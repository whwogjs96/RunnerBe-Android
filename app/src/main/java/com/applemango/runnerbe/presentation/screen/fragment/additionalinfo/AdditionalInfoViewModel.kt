package com.applemango.runnerbe.presentation.screen.fragment.additionalinfo

import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.R
import com.applemango.runnerbe.presentation.model.JobButtonId
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine

class AdditionalInfoViewModel: ViewModel() {

    var yearOfBrith : String? = null
    val genderRadioChecked : MutableStateFlow<Int> = MutableStateFlow(-1)
    val jobRadioChecked : MutableStateFlow<Int> = MutableStateFlow(-1)

    private fun getJobTag(): String? = JobButtonId.findById(jobRadioChecked.value)?.job

    fun setJobTag(jobTag : String) {
        jobRadioChecked.value = JobButtonId.findByJob(jobTag)?.id?:-1
    }
}