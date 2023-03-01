package com.applemango.runnerbe.presentation.screen.dialog.postdetail

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.R
import com.applemango.runnerbe.RunnerBeApplication
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.data.dto.UserInfo
import com.applemango.runnerbe.domain.usecase.post.GetPostDetailUseCase
import com.applemango.runnerbe.domain.usecase.post.PostClosingUseCase
import com.applemango.runnerbe.domain.usecase.post.PostDetailManufacture
import com.applemango.runnerbe.presentation.state.CommonResponse
import com.applemango.runnerbe.presentation.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(
    private val getPostDetailUseCase: GetPostDetailUseCase,
    private val postClosingUseCase: PostClosingUseCase
    ) :
    ViewModel() {

    val post: MutableLiveData<Posting> = MutableLiveData()
    val waitingInfo: ObservableArrayList<UserInfo> = ObservableArrayList()
    val runnerInfo: ObservableArrayList<UserInfo> = ObservableArrayList()
    val _processUiState : MutableStateFlow<UiState> = MutableStateFlow(UiState.Empty)
    val processUiState get() = _processUiState

    fun getJoinRunnerCount(joinRunnerCount: Int, maxRunnerCount: Int) =
        "(${joinRunnerCount}/${maxRunnerCount})"

    fun getPostDetail(postId: Int, userId: Int) = viewModelScope.launch {
        getPostDetailUseCase(postId, userId).collect {
            if (it is CommonResponse.Success<*> && it.body is PostDetailManufacture) {
                post.value = it.body.post
                runnerInfo.clear()
                runnerInfo.addAll(it.body.runnerInfo)
                waitingInfo.clear()
                waitingInfo.addAll(it.body.waitingInfo)
            }
        }
    }

    fun bottomProcess() = viewModelScope.launch {
        val postId = post.value?.postId
        if(postId != null) {
            if(isMyPost()) {
                postClosingUseCase(postId).collect {
                    _processUiState.emit(
                        when(it) {
                            is CommonResponse.Success<*> -> UiState.Success(it.code)
                            is CommonResponse.Failed -> {
                                if (it.code >= 999) UiState.NetworkError
                                else UiState.Failed(it.message)
                            }
                            is CommonResponse.Loading -> UiState.Loading
                            else -> UiState.Empty
                        }
                    )
                }
            } else {
                //TODO
                //여기는 신청
            }
        } else _processUiState.emit(UiState.AnonymousFailed())
    }

    fun setBottomButtonText(posting: Posting): Int {
        return if (isMyPost()) {
            if (isPostClose()) R.string.post_close_complete
            else R.string.do_post_close
        } else {
            if (isPostClose()) R.string.do_post_apply
            else R.string.apply_complete
        }
    }

    fun isPostClose(): Boolean = post.value?.whetherEnd == "Y"
    fun isMyPost(): Boolean =
        RunnerBeApplication.mTokenPreference.getUserId() == post.value?.postUserId

    fun isWaitingUserExist(): Boolean = isMyPost() && waitingInfo.size > 0
}