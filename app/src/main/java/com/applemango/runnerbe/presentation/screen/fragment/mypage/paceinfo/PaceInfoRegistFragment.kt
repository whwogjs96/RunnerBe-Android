package com.applemango.runnerbe.presentation.screen.fragment.mypage.paceinfo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentRegistPaceInfoBinding
import com.applemango.runnerbe.presentation.screen.dialog.message.MessageDialog
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment
import com.applemango.runnerbe.presentation.state.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaceInfoRegistFragment: BaseFragment<FragmentRegistPaceInfoBinding>(R.layout.fragment_regist_pace_info) {

    private val viewModel: PaceInfoViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        viewModel.paceInfoUiState.observe(viewLifecycleOwner) {
            context?.let { context ->
                if (it is UiState.Loading) showLoadingDialog(context)
                else dismissLoadingDialog()
            }
            when(it) {
                is UiState.Failed -> {
                    context?.let { context ->
                        MessageDialog.createShow(
                            context = context,
                            message = it.message,
                            buttonText = resources.getString(R.string.confirm)
                        )
                    }
                }
                is UiState.Success -> {
                    //TODO 다이얼로그 생성 후 종료 기능 추가
                }
            }
        }
    }
}