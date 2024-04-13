package com.applemango.runnerbe.presentation.screen.fragment.chat.detail.uistate

sealed class RunningTalkItem(val messageId: String) {
    data class MessageTalkItem(val id: String, val message: String) : RunningTalkItem(id)
    data class ImageTalkItem(val id: String, val imgUrl: String): RunningTalkItem(id)
}