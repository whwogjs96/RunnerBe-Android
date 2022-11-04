package com.applemango.runnerbe.model.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val _isTokenLogin : MutableLiveData<Boolean> = MutableLiveData()
    val isTokenLogin : LiveData<Boolean> = _isTokenLogin

    //UI 동작 확인용 테스트 코드
    //추후에 여기에 토근 확인하는 기능 넣읍시
    fun isTokenCheck() {
        viewModelScope.launch {
            delay(1000)
            _isTokenLogin.postValue(false)
        }
    }
}