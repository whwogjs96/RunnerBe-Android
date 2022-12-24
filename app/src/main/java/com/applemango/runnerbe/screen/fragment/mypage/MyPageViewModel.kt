package com.applemango.runnerbe.screen.fragment.mypage

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.R
import com.applemango.runnerbe.RunnerBeApplication
import com.applemango.runnerbe.dto.UserInfo
import com.applemango.runnerbe.model.RunnerDiligence
import com.applemango.runnerbe.model.usecase.GetUserDataUseCase
import com.applemango.runnerbe.network.response.CommonResponse
import com.applemango.runnerbe.network.response.UserDataResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val getUserDataUseCase : GetUserDataUseCase
): ViewModel() {

    private var _uiUserDataFlow : MutableStateFlow<CommonResponse> = MutableStateFlow(CommonResponse.Empty)
    val uiUserDataFlow : StateFlow<CommonResponse> = _uiUserDataFlow
    val userInfo : MutableLiveData<UserInfo> = MutableLiveData()

    fun getUserData(userId: Int) = viewModelScope.launch {
        if(userId > -1) {
            getUserDataUseCase(userId).collect {
                when(it) {
                    is CommonResponse.Success<*> -> {
                        if(it.body is UserDataResponse) {
                            val result = it.body.result
                            userInfo.postValue(result.userInfo)
                        }
                    }
                }
                _uiUserDataFlow.emit(it)
            }
        } else {
            //에러 메시지 뱉자~
        }
    }

    fun getRunnerDiligenceImage(diligence: String?) = when(diligence) {
            RunnerDiligence.EFFORT_RUNNER.value -> {
                R.drawable.ic_effort_runner_face
            }
            RunnerDiligence.ERROR_RUNNER.value -> {
                R.drawable.ic_error_runner_face
            }
            RunnerDiligence.SINCERITY_RUNNER.value -> {
                R.drawable.ic_sincerity_runner_face
            }
            else -> {
                R.drawable.ic_effort_runner_face
            }
        }

}