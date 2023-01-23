package com.applemango.runnerbe.network.request

import com.google.gson.annotations.SerializedName

data class EditJobRequest(
    @SerializedName("job") val job: String
)