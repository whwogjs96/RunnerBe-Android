package com.applemango.runnerbe.presentation.screen.fragment.chat.detail.image.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ImageDetailViewModelImpl: ViewModel(), ImageDetailViewModel {

    private val _title = MutableStateFlow("")
    override val title: StateFlow<String> = _title.asStateFlow()

    private val _imageList = MutableStateFlow<List<String>>(listOf())
    override val imageList: StateFlow<List<String>> = _imageList.asStateFlow()

    private val _currentImageUrl = MutableStateFlow("")
    override val currentImageUrl: StateFlow<String> = _currentImageUrl.asStateFlow()

    private val _currentPageNumber = MutableStateFlow(0)
    override val currentPageNumber: StateFlow<Int> =_currentPageNumber.asStateFlow()

    private val _actions = MutableSharedFlow<ImageDetailAction>()
    override val actions: SharedFlow<ImageDetailAction> = _actions.asSharedFlow()

    override fun backClicked() {
        viewModelScope.launch {
            _actions.emit(ImageDetailAction.MoveToBack)
        }
    }

    override fun leftMoveClicked() {
        val page = currentPageNumber.value
        val listSize = imageList.value.size
        viewModelScope.launch {
            _currentPageNumber.emit(if(page == 0) listSize else page - 1)
        }
    }

    override fun rightMoveClicked() {
        val page = currentPageNumber.value
        val listSize = imageList.value.size
        viewModelScope.launch {
            _currentPageNumber.emit(if(page == listSize -1) 0 else page + 1)
        }
    }
}