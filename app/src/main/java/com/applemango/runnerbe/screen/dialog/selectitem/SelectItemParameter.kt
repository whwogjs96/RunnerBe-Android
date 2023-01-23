package com.applemango.runnerbe.screen.dialog.selectitem

data class SelectItemParameter(
    val itemName: String,
    val event : () -> Unit
)