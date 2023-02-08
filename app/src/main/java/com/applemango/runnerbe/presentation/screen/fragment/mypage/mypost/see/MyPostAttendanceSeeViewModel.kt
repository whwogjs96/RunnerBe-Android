package com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost.see

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.data.dto.UserInfo

class MyPostAttendanceSeeViewModel : ViewModel() {

    val userList : ObservableArrayList<UserInfo> = ObservableArrayList()
    fun userListUpdate(users : List<UserInfo>) {
        userList.clear()
        userList.addAll(users)
    }
}