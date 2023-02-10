package com.applemango.runnerbe.presentation.screen.fragment.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val currentItem : MutableSharedFlow<Int> = MutableSharedFlow()

    fun setTab(index : Int) = viewModelScope.launch {
        currentItem.emit(index)
    }
}