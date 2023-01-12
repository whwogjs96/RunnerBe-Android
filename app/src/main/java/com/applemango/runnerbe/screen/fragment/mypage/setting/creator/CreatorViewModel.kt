package com.applemango.runnerbe.screen.fragment.mypage.setting.creator

import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.model.CreatorImageAndPosition

class CreatorViewModel : ViewModel() {
    val creatorList : List<CreatorImageAndPosition> = CreatorImageAndPosition.values().toList()
}