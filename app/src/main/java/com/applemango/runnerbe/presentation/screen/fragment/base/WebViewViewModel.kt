package com.applemango.runnerbe.presentation.screen.fragment.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class WebViewViewModel: ViewModel() {

    val title: MutableStateFlow<String> = MutableStateFlow("")
}