package com.applemango.runnerbe.presentation.screen.dialog.postdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.data.dto.Posting

class PostDetailViewModel: ViewModel() {

    val post : MutableLiveData<Posting> = MutableLiveData()
}