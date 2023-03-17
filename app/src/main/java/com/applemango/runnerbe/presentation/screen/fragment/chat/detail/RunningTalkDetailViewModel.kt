package com.applemango.runnerbe.presentation.screen.fragment.chat.detail

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.data.dto.Messages
import com.applemango.runnerbe.data.dto.RoomInfo
import com.applemango.runnerbe.data.network.response.RunningTalkDetailResponse
import com.applemango.runnerbe.domain.usecase.runningtalk.GetRunningTalkDetailUseCase
import com.applemango.runnerbe.presentation.state.CommonResponse
import com.google.gson.annotations.SerializedName
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
    val message : MutableStateFlow<String> = MutableStateFlow("")

    fun getDetailData() = viewModelScope.launch {
        roomId?.let {roomId ->
            runningTalkDetailUseCase(roomId).collect {
                if(it is CommonResponse.Success<*> && it.body is RunningTalkDetailResponse) {
                    roomInfo.emit(it.body.result.roomInfo[0])
                    messageList.addAll(it.body.result.messages)
                    messageList.addAll(getTestData())
                }
            }
        }
    }

    fun getTestData() : List<Messages> {
        return listOf(
            Messages(
                messageId = 0,
                content = "이번건 테스트니까 즐겨주세요",
                createAt = "2023-03-17T14:28:15.000Z",
                userId = 200,
                nickName = "나이아카",
                profileImageUrl = null,
                from = "Me", // Me or Others
                whetherPostUser = "Y"// Y or N
            ),
            Messages(
                messageId = 1,
                content = "이번건 테스트니까 즐겨주세요",
                createAt = "2023-03-17T14:29:44.000Z",
                userId = 200,
                nickName = "나이아카",
                profileImageUrl = null,
                from = "Me", // Me or Others
                whetherPostUser = "N"// Y or N
            ),
            Messages(
                messageId = 2,
                content = "좀 더 다양한 방법의 테스트가 필요하니 글을 좀 길게 써 보겠습니다. 잘 부탁드려요",
                createAt = "2023-03-17T14:30:15.000Z",
                userId = 220,
                nickName = "또 다른 나",
                profileImageUrl = null,
                from = "Others", // Me or Others
                whetherPostUser = "Y"// Y or N
            ),
            Messages(
                messageId = 3,
                content = "좀 더 다양한 방법의 테스트가 필요하니 글을 좀 길게 써 보겠습니다. 잘 부탁드려요22222222",
                createAt = "2023-03-17T14:32:22.000Z",
                userId = 220,
                nickName = "또 다른 나",
                profileImageUrl = null,
                from = "Others", // Me or Others
                whetherPostUser = "N"// Y or N
            )
        )
    }

}