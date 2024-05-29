package com.applemango.runnerbe.presentation.screen.fragment.chat.detail.image.detail

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface ImageDetailViewModel {

    val title: StateFlow<String>
    val imageList: StateFlow<List<String>>
    val currentImageUrl: StateFlow<String>
    val currentPageNumber: StateFlow<Int>
    val actions: SharedFlow<ImageDetailAction>


    fun backClicked()
    fun leftMoveClicked()
    fun rightMoveClicked()
}

sealed class ImageDetailAction {
    object MoveToBack : ImageDetailAction()
}