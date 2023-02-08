package com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost.accession

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.data.dto.UserInfo
import com.applemango.runnerbe.presentation.model.listener.AttendanceAccessionClickListener

class MyPostAttendanceAccessionViewModel : ViewModel() {

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