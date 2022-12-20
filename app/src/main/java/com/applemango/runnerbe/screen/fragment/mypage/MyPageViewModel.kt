package com.applemango.runnerbe.screen.fragment.mypage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.RunnerBeApplication
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

    fun getUserData(userId: Int) = viewModelScope.launch {
//        val userId = RunnerBeApplication.mTokenPreference.getUserId()
        if(userId > -1) {
            getUserDataUseCase(userId).collect {
                when(it) {
                    is CommonResponse.Success<*> -> {
                        if(it.body is UserDataResponse) {
                            val result = it.body.result
                            Log.e("확인", result.toString())
                        }
                    }
                }
                _uiUserDataFlow.emit(it)
            }
        } else {
            //에러 메시지 뱉자~
        }
    }
}