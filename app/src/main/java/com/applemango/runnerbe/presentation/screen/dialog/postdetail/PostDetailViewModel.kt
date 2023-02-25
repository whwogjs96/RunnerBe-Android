package com.applemango.runnerbe.presentation.screen.dialog.postdetail

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.RunnerBeApplication
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.data.dto.UserInfo
import com.applemango.runnerbe.data.network.response.GetRunningListResponse
import com.applemango.runnerbe.domain.usecase.post.GetPostDetailUseCase
import com.applemango.runnerbe.domain.usecase.post.PostDetailManufacture
import com.applemango.runnerbe.presentation.model.RunningTag
import com.applemango.runnerbe.presentation.state.CommonResponse
import com.applemango.runnerbe.presentation.state.UiState
import com.kakao.usermgmt.response.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(private val getPostDetailUseCase: GetPostDetailUseCase): ViewModel() {

    val post : MutableLiveData<Posting> = MutableLiveData()
    val waitingInfo : ObservableArrayList<UserInfo> = ObservableArrayList()
    val runnerInfo : ObservableArrayList<UserInfo> = ObservableArrayList()

    fun getJoinRunnerCount(joinRunnerCount : Int, maxRunnerCount : Int) = "(${joinRunnerCount}/${maxRunnerCount})"

    fun getPostDetail(postId: Int, userId : Int) = viewModelScope.launch {
        getPostDetailUseCase(postId, userId).collect {
            if(it is CommonResponse.Success<*> && it.body is PostDetailManufacture) {
                post.value = it.body.post
                runnerInfo.clear()
                runnerInfo.addAll(it.body.runnerInfo)
                waitingInfo.clear()
                waitingInfo.addAll(it.body.waitingInfo)
            }
        }
    }
    fun isWaitingButtonVisible() : Boolean = RunnerBeApplication.mTokenPreference.getUserId() == post.value?.postUserId
    fun isWaitingUserExist() : Boolean = isWaitingButtonVisible() && waitingInfo.size > 0
}