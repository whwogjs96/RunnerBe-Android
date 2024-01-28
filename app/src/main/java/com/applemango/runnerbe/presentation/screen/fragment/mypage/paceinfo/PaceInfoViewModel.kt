package com.applemango.runnerbe.presentation.screen.fragment.mypage.paceinfo

import androidx.lifecycle.ViewModel
import com.applemango.runnerbe.R
import com.applemango.runnerbe.RunnerBeApplication
import com.applemango.runnerbe.domain.usecase.myinfo.PatchUserPaceUseCase
import com.applemango.runnerbe.presentation.model.listener.PaceSelectListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class PaceInfoViewModel @Inject constructor(val patchUserPaceUseCase: PatchUserPaceUseCase): ViewModel() {
    val paceInfoList: MutableStateFlow<List<PaceSelectItem>> = MutableStateFlow(initPaceInfoList())
    val isConfirmButtonEnabled: MutableStateFlow<Boolean> = MutableStateFlow(false)

    fun getPaceInfoSelectListener() : PaceSelectListener = object : PaceSelectListener {
        override fun itemClick(paceSelectItem: PaceSelectItem) {

        }

    }
    private fun initPaceInfoList() : List<PaceSelectItem> {
        val context = RunnerBeApplication.ApplicationContext()
        return listOf(
            PaceSelectItem(
                paceTitle = context.getString(R.string.beginner_pace_runner),
                paceImageResource = R.drawable.ic_beginner_pace,
                paceDescription = context.getString(R.string.beginner_pace_runner_description),
                isSelected = false
            ),
            PaceSelectItem(
                paceTitle = context.getString(R.string.general_pace_runner),
                paceImageResource = R.drawable.ic_general_pace,
                paceDescription = context.getString(R.string.general_pace_runner_description),
                isSelected = false
            ),
            PaceSelectItem(
                paceTitle = context.getString(R.string.master_pace_runner),
                paceImageResource = R.drawable.ic_master_pace,
                paceDescription = context.getString(R.string.master_pace_runner_description),
                isSelected = false
            ),
            PaceSelectItem(
                paceTitle = context.getString(R.string.grand_matser_pace_runner),
                paceImageResource = R.drawable.ic_grand_matser_pace,
                paceDescription = context.getString(R.string.grand_matser_pace_runner_description),
                isSelected = false
            )
        )
    }

    fun backClicked() {

    }
    fun confirmClicked() {

    }
}