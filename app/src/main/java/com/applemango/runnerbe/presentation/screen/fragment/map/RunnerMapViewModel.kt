package com.applemango.runnerbe.presentation.screen.fragment.map

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.data.vo.MapFilterData
import com.applemango.runnerbe.presentation.model.GenderTag
import com.applemango.runnerbe.presentation.model.PriorityFilterTag
import com.applemango.runnerbe.presentation.model.RunningTag
import com.naver.maps.geometry.LatLng
import kotlinx.coroutines.flow.MutableStateFlow

class RunnerMapViewModel: ViewModel() {

    val postList : ObservableArrayList<Posting> = ObservableArrayList()
    var coordinator : LatLng = LatLng(37.5666805, 126.9784147) //서울시청 디폴트

    val filterRunningTag : MutableStateFlow<RunningTag> = MutableStateFlow(RunningTag.Before)
    val filterPriorityTag: MutableStateFlow<PriorityFilterTag> = MutableStateFlow(PriorityFilterTag.BY_DISTANCE)
    val includeFinish : MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isFilterApply : MutableStateFlow<Boolean> = MutableStateFlow(false)
    val filterData : MutableStateFlow<MapFilterData> = MutableStateFlow(MapFilterData("A", "N", 0, 100))

    fun setFilter(gender: String?, jobTag: String?, minAge: Int? = 0, maxAge : Int?) {
        filterData.value = MapFilterData(gender?:"A", jobTag?:"N", minAge?:0, maxAge?:100)
    }
}