package com.applemango.runnerbe.screen.compose.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.network.request.SocialLoginRequest
import com.applemango.runnerbe.network.response.CommonResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val kakaoRepo: KakaoLoginRepository
) : ViewModel() {

    private val _isTokenLogin: MutableLiveData<Boolean> = MutableLiveData()
    val isTokenLogin: LiveData<Boolean> = _isTokenLogin
    private var _kakaoFlow: MutableStateFlow<CommonResponse> =
        MutableStateFlow(CommonResponse.Empty)
    val kakaoFlow: StateFlow<CommonResponse> = _kakaoFlow


    //UI 동작 확인용 테스트 코드
    //추후에 여기에 토근 확인하는 기능 넣읍시
    fun isTokenCheck() {
        viewModelScope.launch {
            delay(1000)
            _isTokenLogin.postValue(false)
        }
    }

    fun kakaoLogin(body: SocialLoginRequest) = viewModelScope.launch {
        _kakaoFlow.value = CommonResponse.Loading
        kakaoRepo.getData(body).catch {
            _kakaoFlow.value = CommonResponse.Failed(it)
            it.printStackTrace()
        }.collect {
            _kakaoFlow.value = CommonResponse.Success(it)
        }
    }
}