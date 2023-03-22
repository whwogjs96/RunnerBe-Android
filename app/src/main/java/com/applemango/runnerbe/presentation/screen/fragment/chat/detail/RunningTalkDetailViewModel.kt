package com.applemango.runnerbe.presentation.screen.fragment.chat.detail

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.data.dto.Messages
import com.applemango.runnerbe.data.dto.RoomInfo
import com.applemango.runnerbe.data.network.response.RunningTalkDetailResponse
import com.applemango.runnerbe.domain.usecase.runningtalk.GetRunningTalkDetailUseCase
import com.applemango.runnerbe.domain.usecase.runningtalk.MessageReportUseCase
import com.applemango.runnerbe.domain.usecase.runningtalk.MessageSendUseCase
import com.applemango.runnerbe.presentation.state.CommonResponse
import com.applemango.runnerbe.presentation.state.UiState
import com.google.gson.annotations.SerializedName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RunningTalkDetailViewModel @Inject constructor(
    private val runningTalkDetailUseCase: GetRunningTalkDetailUseCase,
    private val messageSendUseCase: MessageSendUseCase,
    private val messageReportUseCase: MessageReportUseCase
) : ViewModel() {

    var roomId : Int? = null
    var roomRepName : String = ""
    val roomInfo : MutableStateFlow<RoomInfo> = MutableStateFlow(RoomInfo("출근 전","러닝 제목"))
    val messageList : ObservableArrayList<Messages> = ObservableArrayList()
    val message : MutableStateFlow<String> = MutableStateFlow("")
    val isDeclaration: MutableStateFlow<Boolean> = MutableStateFlow(false)
    private val _messageSendUiState: MutableSharedFlow<UiState> = MutableSharedFlow()
    val messageSendUiState get() = _messageSendUiState
    private val _messageReportUiState: MutableSharedFlow<UiState> = MutableSharedFlow()
    val messageReportUiState get() = _messageReportUiState

    fun getDetailData(isRefresh : Boolean) = viewModelScope.launch {
        roomId?.let {roomId ->
            runningTalkDetailUseCase(roomId).collect {
                if(it is CommonResponse.Success<*> && it.body is RunningTalkDetailResponse) {
                    if(isRefresh) messageList.clear()
                    roomInfo.emit(it.body.result.roomInfo[0])
                    messageList.addAll(it.body.result.messages)
                }
            }
        }
    }

    fun messageSend(content : String) = viewModelScope.launch {
        roomId?.let {
            messageSendUseCase(it, content).collect { response ->
                when(response) {
                    is CommonResponse.Success<*> -> {
                        _messageSendUiState.emit(UiState.Success(response.code))
                    }
                    is CommonResponse.Failed -> {
                        _messageSendUiState.emit(UiState.Failed(response.message))
                    }
                }
            }
        }
    }

    fun messageReport() = viewModelScope.launch {
        _messageReportUiState.emit(UiState.Loading)
        val messageIdList = messageList.filter { it.isChecked }.map { it.messageId }
        if(messageIdList.isNotEmpty()) {
            messageReportUseCase(messageIdList).collect {
                when(it) {
                    is CommonResponse.Success<*> -> {
                        _messageReportUiState.emit(UiState.Success(it.code))
                    }
                    is CommonResponse.Failed -> {
                        _messageReportUiState.emit(UiState.Failed(it.message))
                    }
                }
            }
        } else _messageReportUiState.emit(UiState.Empty)
    }

    fun setDeclaration(set: Boolean) { isDeclaration.value = set }
}