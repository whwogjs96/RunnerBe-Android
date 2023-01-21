package com.applemango.runnerbe.network.request

import com.google.gson.annotations.SerializedName

data class WithdrawalUserRequest(
    @SerializedName("secret_key") val secretKey: String
)