package com.applemango.runnerbe.presentation.screen.fragment.mypage.setting.creator

import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.presentation.model.CreatorImageAndPosition

class CreatorViewModel : ViewModel() {
    val creatorList : List<CreatorImageAndPosition> = CreatorImageAndPosition.values().toList()
}