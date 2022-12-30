package com.applemango.runnerbe.screen.fragment.mypage.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.RunnerBeApplication
import com.applemango.runnerbe.util.TokenSPreference
import kotlinx.coroutines.launch

class SettingViewModel: ViewModel() {

    private val _logoutState : MutableLiveData<Boolean> = MutableLiveData()
    val logoutState : LiveData<Boolean> = _logoutState

    fun logout() = viewModelScope.launch {
        try {
            RunnerBeApplication.mTokenPreference.logoutSet()
            _logoutState.value = true
        } catch (e: Exception) {
            e.printStackTrace()
            _logoutState.value = false
        }
    }
}