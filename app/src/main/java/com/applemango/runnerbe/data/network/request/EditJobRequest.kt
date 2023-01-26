package com.applemango.runnerbe.data.network.request

import com.google.gson.annotations.SerializedName

data class EditJobRequest(
    @SerializedName("job") val job: String
)