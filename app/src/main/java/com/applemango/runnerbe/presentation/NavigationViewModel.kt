package com.applemango.runnerbe.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections

class NavigationViewModel : ViewModel() {
    val popBackStack = MutableLiveData<Boolean>()

    val navDirectionAction = MutableLiveData<NavDirections?>()
}