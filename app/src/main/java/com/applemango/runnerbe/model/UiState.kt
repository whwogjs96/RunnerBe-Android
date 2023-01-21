package com.applemango.runnerbe.model

import com.applemango.runnerbe.network.response.CommonResponse

sealed class UiState {
    data class Success(val code :Int) : UiState()
    data class Failed(val message : String) : UiState()
    object NetworkError : UiState()
    object Loading : UiState()
    object Empty : UiState()
}