package com.applemango.runnerbe.presentation.screen.fragment.mypage

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.data.dto.ProfileUrlList
import com.applemango.runnerbe.data.dto.UserInfo
import com.applemango.runnerbe.presentation.model.RunnerDiligence
import com.applemango.runnerbe.presentation.state.UiState
import com.applemango.runnerbe.domain.usecase.GetUserDataUseCase
import com.applemango.runnerbe.domain.usecase.PatchUserImageUseCase
import com.applemango.runnerbe.presentation.state.CommonResponse
import com.applemango.runnerbe.data.network.response.UserDataResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val getUserDataUseCase: GetUserDataUseCase,
    private val patchUserImageUseCase: PatchUserImageUseCase
) : ViewModel() {

    private var _uiUserDataFlow: MutableStateFlow<CommonResponse> =
        MutableStateFlow(CommonResponse.Empty)
    val uiUserDataFlow: StateFlow<CommonResponse> = _uiUserDataFlow
    val userInfo: MutableLiveData<UserInfo> = MutableLiveData()
    val joinPosts: ObservableArrayList<Posting> = ObservableArrayList()
    val myPosts: ObservableArrayList<Posting> = ObservableArrayList()
    val moveTab : MutableSharedFlow<Int> = MutableSharedFlow()

    private var _updateUserImageState : MutableLiveData<UiState> = MutableLiveData()
    val updateUserImageState get() = _updateUserImageState

    fun getUserData(userId: Int) = viewModelScope.launch {
        if (userId > -1) {
            getUserDataUseCase(userId).collect {
                when (it) {
                    is CommonResponse.Success<*> -> {
                        if (it.body is UserDataResponse) {
                            val result = it.body.result
                            userInfo.postValue(result.userInfo)
                            joinPosts.clear()
                            myPosts.clear()
                            joinPosts.addAll(result.myRunning)
                            myPosts.addAll(result.posting)
                        }
                    }
                }
                _uiUserDataFlow.emit(it)
            }
        } else {
            //에러 메시지 뱉자~
        }
    }

    fun getRunnerDiligenceImage(diligence: String?) = when (diligence) {
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

    fun userProfileImageChange(imageUrl : String?) = viewModelScope.launch {
        patchUserImageUseCase(imageUrl).collect {
            _updateUserImageState.postValue(
                when(it) {
                    is CommonResponse.Success<*> -> UiState.Success(it.code)
                    is CommonResponse.Failed -> {
                        if (it.code <= 999) UiState.NetworkError
                        else UiState.Failed(it.message)
                    }
                    is CommonResponse.Loading -> UiState.Loading
                    else -> UiState.Empty
                }
            )
        }
    }

    fun setTab(index : Int) = viewModelScope.launch {
        moveTab.emit(index)
    }
}