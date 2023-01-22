package com.applemango.runnerbe.screen.fragment.mypage.editprofile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.RunnerBeApplication
import com.applemango.runnerbe.model.UiState
import com.applemango.runnerbe.model.dto.UserInfo
import com.applemango.runnerbe.model.usecase.NicknameChangeUseCase
import com.applemango.runnerbe.network.response.CommonResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(
    private val nicknameChangeUseCase: NicknameChangeUseCase
): ViewModel() {

    val userInfo : MutableLiveData<UserInfo> = MutableLiveData()
    val radioChecked : MutableLiveData<Int> = MutableLiveData()
    var currentJob : String = ""
    private val _nicknameChangeState : MutableLiveData<UiState> = MutableLiveData()
    val nicknameChangeState get() = _nicknameChangeState

    fun nicknameChange(changedNickname : String) = viewModelScope.launch {
        nicknameChangeUseCase(RunnerBeApplication.mTokenPreference.getUserId(), changedNickname).collect {
            _nicknameChangeState.postValue(
                when(it) {
                is CommonResponse.Success<*> -> UiState.Success(it.code)
                is CommonResponse.Failed -> {
                    if (it.code <= 999) UiState.NetworkError
                    else UiState.Failed(it.message)
                }
                is CommonResponse.Loading -> UiState.Loading
                else -> UiState.Empty
            })
        }
    }
}