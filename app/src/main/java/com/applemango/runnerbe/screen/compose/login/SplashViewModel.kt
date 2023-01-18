package com.applemango.runnerbe.screen.compose.login

import android.accounts.NetworkErrorException
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.RunnerBeApplication
import com.applemango.runnerbe.model.LoginType
import com.applemango.runnerbe.network.request.SocialLoginRequest
import com.applemango.runnerbe.network.response.CommonResponse
import com.applemango.runnerbe.network.response.SocialLoginResponse
import com.applemango.runnerbe.util.TokenSPreference
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

    private var _isSocialLogin: MutableStateFlow<CommonResponse> =
        MutableStateFlow(CommonResponse.Empty)
    val isSocialLogin : StateFlow<CommonResponse> = _isSocialLogin


    //UI 동작 확인용 테스트 코드
    fun isTokenCheck() {
        viewModelScope.launch {
            // userId = -1, uuid = ""
            var userId = RunnerBeApplication.mTokenPreference.getUserId()
            var uuid = RunnerBeApplication.mTokenPreference.getUuid()

            if (userId == -1 && uuid.isNullOrEmpty()) {
                _isTokenLogin.postValue(false)
            } else {
                _isTokenLogin.postValue(true)
            }
        }
    }

    fun login(type : LoginType, body: SocialLoginRequest) = viewModelScope.launch  {
        runCatching {
            when(type) {
                LoginType.KAKAO -> kakaoRepo.getData(body)
                LoginType.NAVER -> naverRepo.getData(body)
            }
        }.onSuccess { repo ->
            repo.catch {
                _isSocialLogin.value = CommonResponse.Failed(it.message?:"error")
                it.printStackTrace()
            }.collect {
                if(it.isSuccess) {
                    val result = it.result
                    RunnerBeApplication.mTokenPreference.setLoginType(type)
                    if(result.jwt != null) RunnerBeApplication.mTokenPreference.setToken(result.jwt)
                    // 추가정보 입력시
                    result.userId?.let { it1 -> RunnerBeApplication.mTokenPreference.setUserId(it1) }
                    // 추가정보 미입력시
                    result.uuid?.let { it1 -> RunnerBeApplication.mTokenPreference.setUuid(it1) }
                    Log.e("uuid", result.uuid.toString())
                    _isSocialLogin.value = CommonResponse.Success(it)
                } else _isSocialLogin.value = CommonResponse.Failed(it.message?:"error")
            }
        }
    }
}