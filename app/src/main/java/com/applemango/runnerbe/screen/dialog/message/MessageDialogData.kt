package com.applemango.runnerbe.screen.dialog.message

import android.view.View

data class MessageDialogData(
    var event: View.OnClickListener,
    var message: String,
    var buttonText: String
)
