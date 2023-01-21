package com.applemango.runnerbe.screen.fragment.mypage.editprofile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.model.dto.UserInfo

class EditProfileViewModel: ViewModel() {

    val userInfo : MutableLiveData<UserInfo> = MutableLiveData()
    val radioChecked : MutableLiveData<Int> = MutableLiveData()
    var currentJob : String = ""
}