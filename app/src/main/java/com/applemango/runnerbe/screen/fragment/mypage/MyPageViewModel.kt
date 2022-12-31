package com.applemango.runnerbe.screen.fragment.mypage

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applemango.runnerbe.R
import com.applemango.runnerbe.RunnerBeApplication
import com.applemango.runnerbe.dto.Posting
import com.applemango.runnerbe.dto.ProfileUrlList
import com.applemango.runnerbe.dto.UserInfo
import com.applemango.runnerbe.model.RunnerDiligence
import com.applemango.runnerbe.model.usecase.GetUserDataUseCase
import com.applemango.runnerbe.network.response.CommonResponse
import com.applemango.runnerbe.network.response.UserDataResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val getUserDataUseCase: GetUserDataUseCase
) : ViewModel() {

    private var _uiUserDataFlow: MutableStateFlow<CommonResponse> =
        MutableStateFlow(CommonResponse.Empty)
    val uiUserDataFlow: StateFlow<CommonResponse> = _uiUserDataFlow
    val userInfo: MutableLiveData<UserInfo> = MutableLiveData()
    val joinPosts: ObservableArrayList<Posting> = ObservableArrayList()
    val myPosts: ObservableArrayList<Posting> = ObservableArrayList()

    fun getUserData(userId: Int) = viewModelScope.launch {
        if (userId > -1) {
            getUserDataUseCase(userId).collect {
                when (it) {
                    is CommonResponse.Success<*> -> {
                        if (it.body is UserDataResponse) {
                            val result = it.body.result
                            userInfo.postValue(result.userInfo)
                            joinPosts.addAll(result.myRunning)
                            myPosts.addAll(result.posting)
                            joinPosts.add(
                                Posting(
                                    postId = 9,
                                    postingTime = "2022-02-11T03:25:58:000Z",
                                    postUserId = 2,
                                    nickName = "niaka",
                                    profileImageUrl = null,
                                    title = "테스트 제목",
                                    runningTime = "01:30:00",
                                    gatheringTime = "2022-02-11T03:25:58:000Z",
                                    gatherLongitude = "127.8343000000",
                                    gatherLatitude = "37.0231231230",
                                    locationInfo = "지금 어디 어디 어디",
                                    runningTag = "A",
                                    age = "20-65",
                                    gender = "남성",
                                    whetherEnd = "N",
                                    job = "DEV",
                                    peopleNum = 4,
                                    contents = "여기는 모임 내용",
                                    userId = 2,
                                    bookMark = 0,
                                    DISTANCE = null,
                                    attandance = 1,
                                    profileUrlList = listOf(
                                        ProfileUrlList(23, null),
                                        ProfileUrlList(2, null),
                                        ProfileUrlList(20, null),
                                        ProfileUrlList(63, null)
                                    ),
                                    runnerList = listOf(
                                        UserInfo(
                                            userId = 23,
                                            nickName = "test",
                                            gender = "남성",
                                            age = "30대 초반",
                                            diligence = "불량 러너",
                                            job = "교육",
                                            profileImageUrl = null,
                                            whetherCheck = "N",
                                            attendance = 0,
                                            whetherAccept = null,
                                            nameChanged = null,
                                            jobChangePossible = null,
                                            pushOn = null
                                        )
                                    ),
                                    whetherPostUser = null,
                                    whetherCheck = "Y"
                                )
                            )
                            myPosts.add(
                                Posting(
                                    postId = 9,
                                    postingTime = "2022-02-11T03:25:58:000Z",
                                    postUserId = 2,
                                    nickName = "niaka",
                                    profileImageUrl = null,
                                    title = "테스트 제목",
                                    runningTime = "01:30:00",
                                    gatheringTime = "2022-02-11T03:25:58:000Z",
                                    gatherLongitude = "127.8343000000",
                                    gatherLatitude = "37.0231231230",
                                    locationInfo = "지금 어디 어디 어디",
                                    runningTag = "A",
                                    age = "20-65",
                                    gender = "남성",
                                    whetherEnd = "N",
                                    job = "DEV",
                                    peopleNum = 4,
                                    contents = "여기는 모임 내용",
                                    userId = 2,
                                    bookMark = 0,
                                    DISTANCE = null,
                                    attandance = 0,
                                    profileUrlList = listOf(
                                        ProfileUrlList(23, null),
                                        ProfileUrlList(2, null),
                                        ProfileUrlList(20, null),
                                        ProfileUrlList(63, null)
                                    ),
                                    runnerList = listOf(
                                        UserInfo(
                                            userId = 23,
                                            nickName = "test",
                                            gender = "남성",
                                            age = "30대 초반",
                                            diligence = "불량 러너",
                                            job = "교육",
                                            profileImageUrl = null,
                                            whetherCheck = "N",
                                            attendance = 0,
                                            whetherAccept = null,
                                            nameChanged = null,
                                            jobChangePossible = null,
                                            pushOn = null
                                        )
                                    ),
                                    whetherPostUser = null,
                                    whetherCheck = null
                                )
                            )
                        }
                    }
                }
                _uiUserDataFlow.emit(it)
            }
        } else {
            //에러 메시지 뱉자~
        }
    }

    fun getRunnerDiligenceImage(diligence: String?) = when (diligence) {
        RunnerDiligence.EFFORT_RUNNER.value -> {
            R.drawable.ic_effort_runner_face
        }
        RunnerDiligence.ERROR_RUNNER.value -> {
            R.drawable.ic_error_runner_face
        }
        RunnerDiligence.SINCERITY_RUNNER.value -> {
            R.drawable.ic_sincerity_runner_face
        }
        else -> {
            R.drawable.ic_effort_runner_face
        }
    }

}