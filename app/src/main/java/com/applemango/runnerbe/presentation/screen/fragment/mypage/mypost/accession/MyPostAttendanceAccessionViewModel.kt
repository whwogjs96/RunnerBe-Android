package com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost.accession

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.data.dto.UserInfo
import com.applemango.runnerbe.domain.usecase.post.AttendanceAccessionUseCase
import com.applemango.runnerbe.presentation.model.listener.AttendanceAccessionClickListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyPostAttendanceAccessionViewModel @Inject constructor(
    private val attendanceAccessionUseCase: AttendanceAccessionUseCase
) : ViewModel() {

    val userList : ObservableArrayList<UserInfo> = ObservableArrayList()

    fun userListUpdate(users : List<UserInfo>) {
        userList.clear()
        userList.addAll(users)
    }

    fun getAccessionClickListener() = object : AttendanceAccessionClickListener {
        override fun onAcceptClick(userInfo: UserInfo) {
            Log.e("accept",userInfo.toString())
        }

        override fun onRefuseClick(userInfo: UserInfo) {
            Log.e("refuse", userInfo.toString())
        }
    }
}