package com.applemango.runnerbe.presentation.screen.fragment.map

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.presentation.model.PriorityFilterTag
import com.applemango.runnerbe.presentation.model.RunningTag
import com.naver.maps.geometry.LatLng
import kotlinx.coroutines.flow.MutableStateFlow

class RunnerMapViewModel: ViewModel() {

    val postList : ObservableArrayList<Posting> = ObservableArrayList()
    var coordinator : LatLng = LatLng(37.5666805, 126.9784147) //서울시청 디폴트

    val filterRunningTag : MutableStateFlow<RunningTag> = MutableStateFlow(RunningTag.Before)
    val filterPriorityTag: MutableStateFlow<PriorityFilterTag> = MutableStateFlow(PriorityFilterTag.BY_DISTANCE)
}