package com.applemango.runnerbe.network.response

sealed class CommonResponse {
    data class Success<T>(val code :Int, val body : T) : CommonResponse()
    data class Failed(val code : Int, val message : String) : CommonResponse()
    object Loading : CommonResponse()
    object Empty : CommonResponse()
}