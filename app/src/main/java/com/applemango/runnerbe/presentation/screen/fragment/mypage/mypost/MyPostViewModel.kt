package com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.presentation.model.listener.PostClickListener
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class MyPostViewModel: ViewModel() {
    val action: MutableSharedFlow<MyPostActions> = MutableSharedFlow()

    fun writeClickEvent() = viewModelScope.launch {
        action.emit(MyPostActions.MoveToWrite)
    }

    fun getMyPostClickListener() = object : PostClickListener {

        override fun logWriteClick(post: Posting) {}

        override fun attendanceSeeClick(post: Posting) {
            viewModelScope.launch { action.emit(MyPostActions.MoveToMyPostAttendanceSee(post)) }
        }

        override fun attendanceManageClick(post: Posting) {
            viewModelScope.launch { action.emit(MyPostActions.MoveToAttendanceManage(post)) }
        }

        override fun bookMarkClick(post: Posting) {

        }

        override fun postClick(post: Posting) {
        }
    }
}

sealed class MyPostActions {
    object MoveToWrite : MyPostActions()
    data class MoveToMyPostAttendanceSee(val post: Posting): MyPostActions()
    data class MoveToAttendanceManage(val post: Posting): MyPostActions()
}