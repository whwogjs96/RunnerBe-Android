package com.applemango.runnerbe.presentation.screen.fragment.additionalinfo.terms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class AgreeToTermsViewModel : ViewModel() {

    val serviceTerms : MutableStateFlow<Boolean> = MutableStateFlow(false)
    val privacyTerms : MutableStateFlow<Boolean> = MutableStateFlow(false)
    val locationServiceTerms : MutableStateFlow<Boolean> = MutableStateFlow(false)

    val allCheck  = combine(serviceTerms, privacyTerms, locationServiceTerms) { isServiceCheck, isPrivacyCheck, isLocationServiceCheck ->
        isServiceCheck && isLocationServiceCheck && isPrivacyCheck
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(1000L),
        initialValue = false
    )
}