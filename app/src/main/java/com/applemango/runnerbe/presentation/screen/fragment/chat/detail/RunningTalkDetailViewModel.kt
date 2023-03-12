package com.applemango.runnerbe.presentation.screen.fragment.chat.detail

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.data.dto.Messages
import com.applemango.runnerbe.data.dto.RoomInfo
import com.applemango.runnerbe.data.network.response.RunningTalkDetailResponse
import com.applemango.runnerbe.domain.usecase.runningtalk.GetRunningTalkDetailUseCase
import com.applemango.runnerbe.presentation.state.CommonResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RunningTalkDetailViewModel @Inject constructor(
    private val runningTalkDetailUseCase: GetRunningTalkDetailUseCase
) : ViewModel() {

    var roomId : Int? = null
    val roomInfo : MutableStateFlow<RoomInfo> = MutableStateFlow(RoomInfo("출근 전","러닝 제목"))
    val messageList : ObservableArrayList<Messages> = ObservableArrayList()

    fun getDetailData() = viewModelScope.launch {
        roomId?.let {roomId ->
            runningTalkDetailUseCase(roomId).collect {
                if(it is CommonResponse.Success<*> && it.body is RunningTalkDetailResponse) {
                    roomInfo.emit(it.body.result.roomInfo[0])
                    messageList.addAll(it.body.result.messages)
                }
            }
        }

    }

}