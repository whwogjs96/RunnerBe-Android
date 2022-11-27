package com.applemango.runnerbe.screen.compose.login

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.RunnerBeApplication
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
    private val kakaoRepo: KakaoLoginRepository,
    private val naverRepo: NaverLoginRepository
) : ViewModel() {

    private val _isTokenLogin: MutableLiveData<Boolean> = MutableLiveData()
    val isTokenLogin: LiveData<Boolean> = _isTokenLogin

    private var _kakaoFlow: MutableStateFlow<CommonResponse> =
        MutableStateFlow(CommonResponse.Empty)
    val kakaoFlow: StateFlow<CommonResponse> = _kakaoFlow
    private var _naverFlow: MutableStateFlow<CommonResponse> =
        MutableStateFlow(CommonResponse.Empty)
    val naverFlow: StateFlow<CommonResponse> = _naverFlow


    //UI 동작 확인용 테스트 코드
    fun isTokenCheck() {
        viewModelScope.launch {
            delay(1000)

            // userId = -1, uuid = ""
            var userId = RunnerBeApplication.sSharedPreferences.getInt("userId", -1)
            var uuid = RunnerBeApplication.sSharedPreferences.getString("uuid", "")

            if (userId == -1 && uuid == "") {
                _isTokenLogin.postValue(false)
            } else {
                _isTokenLogin.postValue(true)
            }

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

    fun naverLogin(body: SocialLoginRequest) = viewModelScope.launch {
        _naverFlow.value = CommonResponse.Loading
        naverRepo.getData(body).catch {
            _naverFlow.value = CommonResponse.Failed(it)
            it.printStackTrace()
        }.collect {
            _naverFlow.value = CommonResponse.Success(it)
        }
    }
}