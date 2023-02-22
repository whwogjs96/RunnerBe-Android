package com.applemango.runnerbe.presentation.screen.fragment.map

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.data.network.request.GetRunningListRequest
import com.applemango.runnerbe.data.network.response.GetRunningListResponse
import com.applemango.runnerbe.data.vo.MapFilterData
import com.applemango.runnerbe.domain.usecase.post.GetRunningListUseCase
import com.applemango.runnerbe.presentation.model.PriorityFilterTag
import com.applemango.runnerbe.presentation.model.RunningTag
import com.applemango.runnerbe.presentation.model.listener.BookMarkClickListener
import com.applemango.runnerbe.presentation.state.CommonResponse
import com.applemango.runnerbe.presentation.state.UiState
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.overlay.Marker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RunnerMapViewModel @Inject constructor(
    private val getRunningListUseCase: GetRunningListUseCase
): ViewModel() {

    val postList : ObservableArrayList<Posting> = ObservableArrayList()
    var coordinator : LatLng = LatLng(37.5666805, 126.9784147) //서울시청 디폴트

    private val _listUpdateUiState : MutableStateFlow<UiState> = MutableStateFlow(UiState.Empty)
    val listUpdateUiState get() : MutableStateFlow<UiState> = _listUpdateUiState

    val refreshThisLocation : MutableStateFlow<Boolean> = MutableStateFlow(false)

    //stateFlow는 같은 값인 경우 변경이 일어나지 않네...
    var refresh = false

    val filterRunningTag : MutableStateFlow<RunningTag> = MutableStateFlow(RunningTag.Before)
    val filterPriorityTag: MutableStateFlow<PriorityFilterTag> = MutableStateFlow(PriorityFilterTag.BY_DISTANCE)
    val includeFinish : MutableStateFlow<Boolean> = MutableStateFlow(true)
    val filterData : MutableStateFlow<MapFilterData> = MutableStateFlow(MapFilterData("A", "N", 0, 100))
    val isRefresh : StateFlow<Boolean> = combine(filterRunningTag, filterPriorityTag, includeFinish, filterData) { _: RunningTag, _: PriorityFilterTag, _: Boolean, _: MapFilterData ->
        refresh = !refresh
        refresh
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(1000L),
        initialValue = false
    )

    fun setFilter(gender: String?, jobTag: String?, minAge: Int? = 0, maxAge : Int?) {
        filterData.value = MapFilterData(gender?:"A", jobTag?:"N", minAge?:0, maxAge?:100)
    }

    fun getRunningList(userId : Int?) = viewModelScope.launch{
        val request = GetRunningListRequest(
            userLat = coordinator.latitude,
            userLng = coordinator.longitude,
            jobFilter = filterData.value.jobTag,
            gender = filterData.value.genderTag,
            distanceFilter = "N",
            minAge = if(filterData.value.minAge ==0)"N" else filterData.value.minAge.toString(),
            maxAge = if(filterData.value.maxAge > 65) "N" else filterData.value.maxAge.toString(),
            priorityFilter = filterPriorityTag.value.tag,
            userId = userId,
            whetherEnd = if(includeFinish.value) "Y" else "N"
        )
        getRunningListUseCase(filterRunningTag.value, request).collect {
            if(it is CommonResponse.Success<*> && it.body is GetRunningListResponse) {
                postList.addAll(it.body.runningList)
            }
            _listUpdateUiState.emit(
                when(it) {
                    is CommonResponse.Success<*> -> UiState.Success(it.code)
                    is CommonResponse.Failed -> {
                        if (it.code <= 999) UiState.NetworkError
                        else UiState.Failed(it.message)
                    }
                    is CommonResponse.Loading -> UiState.Loading
                    else -> UiState.Empty
                }
            )
        }
    }

}