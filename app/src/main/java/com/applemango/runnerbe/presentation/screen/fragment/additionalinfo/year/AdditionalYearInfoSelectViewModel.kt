package com.applemango.runnerbe.presentation.screen.fragment.additionalinfo.year

import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.util.getNowYear
import com.applemango.runnerbe.util.getYearListByYear
import kotlinx.coroutines.flow.MutableStateFlow

class AdditionalYearInfoSelectViewModel: ViewModel() {

    val yearList = getYearListByYear(19, 80)
    val isUnder19 : MutableStateFlow<Boolean> = MutableStateFlow(false)

    fun selectYear(year: String) {
        isUnder19.value = try {
            getNowYear().toInt() - year.toInt() <= 19
        }catch (e: java.lang.Exception) {
            e.printStackTrace()
            false
        }
    }
}