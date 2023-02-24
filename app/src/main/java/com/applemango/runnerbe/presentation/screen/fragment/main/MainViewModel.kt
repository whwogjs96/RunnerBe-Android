package com.applemango.runnerbe.presentation.screen.fragment.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.presentation.model.listener.BookMarkClickListener
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val currentItem : MutableSharedFlow<Int> = MutableSharedFlow()
    val clickedPost : MutableStateFlow<Posting?> = MutableStateFlow(null)

    fun setTab(index : Int) = viewModelScope.launch {
        currentItem.emit(index)
    }
    fun clickPost(posting: Posting?) {
        clickedPost.value = posting
    }
    fun getChangeBookMarkStatusListener() = object : BookMarkClickListener {
        override fun onBookMarkClick(post: Posting) {
            //TODO
            //여기에 북마크 옵션 달아줘야 함
        }

        override fun onClick(post: Posting) {
            clickedPost.value = if(clickedPost.value == post) null else post
        }
    }
}