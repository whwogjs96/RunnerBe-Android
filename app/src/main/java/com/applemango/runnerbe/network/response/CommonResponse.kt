package com.applemango.runnerbe.network.response

sealed class CommonResponse {
    data class Success<T>(val body : T) : CommonResponse()
    data class Failed(val message : String) : CommonResponse()
    object Loading : CommonResponse()
    object Empty : CommonResponse()
}