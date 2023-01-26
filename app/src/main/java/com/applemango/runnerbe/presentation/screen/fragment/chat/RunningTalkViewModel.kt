package com.applemango.runnerbe.presentation.screen.fragment.chat

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.data.dto.Room
import com.applemango.runnerbe.domain.usecase.GetRunningTalkUseCase
import com.applemango.runnerbe.presentation.state.CommonResponse
import com.applemango.runnerbe.data.network.response.RunningTalksResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RunningTalkViewModel @Inject constructor(
    private val runningTalkUseCase: GetRunningTalkUseCase
): ViewModel() {

    val roomList : ObservableArrayList<Room> = ObservableArrayList()

    fun getRunningTalkList() = viewModelScope.launch {
        runningTalkUseCase().collect {
            if(it is CommonResponse.Success<*> && it.body is RunningTalksResponse) {
                roomList.addAll(it.body.result)
//                roomList.add(Room(
//                    roomId = 1,
//                    profileImageUrl = "",
//                    recentMessage = "러닝 준비 되셨나요",
//                    repUserName = "아라리",
//                    title = "신림 러닝"
//                ))
//                roomList.add(Room(
//                    roomId = 2,
//                    profileImageUrl = "",
//                    recentMessage = "러닝 팟 구합니다.",
//                    repUserName = "맹고",
//                    title = "한강 러닝!"
//                ))
            }
        }
    }
}