package com.applemango.runnerbe.presentation.screen.fragment.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.R
import com.applemango.runnerbe.RunnerBeApplication
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.data.network.response.BaseResponse
import com.applemango.runnerbe.data.network.response.JoinUserResponse
import com.applemango.runnerbe.domain.usecase.bookmark.BookMarkStatusChangeUseCase
import com.applemango.runnerbe.presentation.model.listener.BookMarkClickListener
import com.applemango.runnerbe.presentation.screen.dialog.message.MessageDialog
import com.applemango.runnerbe.presentation.state.CommonResponse
import com.applemango.runnerbe.presentation.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val bookMarkStatusChangeUseCase: BookMarkStatusChangeUseCase
) : ViewModel() {

    val currentItem: MutableSharedFlow<Int> = MutableSharedFlow()
    val clickedPost: MutableStateFlow<Posting?> = MutableStateFlow(null)

    private val _bookmarkPost : MutableSharedFlow<Posting> = MutableSharedFlow()
    val bookmarkPost get() = _bookmarkPost

    fun setTab(index: Int) = viewModelScope.launch {
        currentItem.emit(index)
    }

    fun clickPost(posting: Posting?) {
        clickedPost.value = posting
    }

    fun getChangeBookMarkStatusListener() = object : BookMarkClickListener {
        override fun onBookMarkClick(post: Posting) {
            //TODO
            bookmarkStatusChange(post)
        }

        override fun onClick(post: Posting) {
            clickedPost.value = if (clickedPost.value == post) null else post
        }
    }

    fun bookmarkStatusChange(post: Posting) = viewModelScope.launch {
        bookMarkStatusChangeUseCase(
            RunnerBeApplication.mTokenPreference.getUserId(),
            post.postId,
            if (!post.bookmarkCheck()) "Y" else "N"
        ).collect {
            when(it) {
                is CommonResponse.Success<*> -> {
                    if(it.body is BaseResponse && it.body.isSuccess) {
                        post.bookMark = if(post.bookmarkCheck()) 0 else 1
                        _bookmarkPost.emit(post)
                    }
                }
            }
        }
    }
}