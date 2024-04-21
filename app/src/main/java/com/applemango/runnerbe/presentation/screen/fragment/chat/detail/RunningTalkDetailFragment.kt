package com.applemango.runnerbe.presentation.screen.fragment.chat.detail

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentRunningTalkDetailBinding
import com.applemango.runnerbe.domain.entity.Pace
import com.applemango.runnerbe.presentation.component.PaceComponentMini
import com.applemango.runnerbe.presentation.screen.deco.RecyclerViewItemDeco
import com.applemango.runnerbe.presentation.screen.dialog.message.MessageDialog
import com.applemango.runnerbe.presentation.screen.dialog.twobutton.TwoButtonDialog
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment
import com.applemango.runnerbe.presentation.state.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class RunningTalkDetailFragment :
    BaseFragment<FragmentRunningTalkDetailBinding>(R.layout.fragment_running_talk_detail) {

    private val viewModel: RunningTalkDetailViewModel by viewModels()
    private val args: RunningTalkDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        binding.fragment = this
        viewModel.roomId = args.roomId
        viewModel.roomRepName = args.roomRepUserName
        context?.let {
            binding.messageRecyclerView.addItemDecoration(RecyclerViewItemDeco(it, 12))
        }
        refresh()
        observeBind()

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (viewModel.isDeclaration.value) viewModel.isDeclaration.value = false
                else navPopStack()
            }
        })

        binding.topMessageLayout.setOnClickListener { hideKeyBoard() }
    }

    private fun observeBind() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            launch {
                viewModel.messageSendUiState.collect {
                    context?.let { context ->
                        if (it is UiState.Loading) showLoadingDialog(context)
                        else dismissLoadingDialog()
                    }
                    when (it) {
                        is UiState.Success -> refresh()
                    }
                }
            }
            launch {
                viewModel.roomInfo.collect {
                    binding.paceView.setContent {
                        PaceComponentMini(pace = Pace.getPaceByName(viewModel.roomInfo.value.pace)?:Pace.BEGINNER)
                    }
                }
            }
            launch {
                viewModel.messageReportUiState.collect {
                    context?.let { context ->
                        if (it is UiState.Loading) showLoadingDialog(context)
                        else dismissLoadingDialog()
                    }
                    when (it) {
                        is UiState.Success -> {
                            viewModel.isDeclaration.value = false
                            Toast.makeText(
                                context,
                                resources.getString(R.string.report_complete),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        is UiState.Failed -> {
                            context?.let { context ->
                                MessageDialog.createShow(
                                    context = context,
                                    message = it.message,
                                    buttonText = resources.getString(R.string.confirm)
                                )
                            }
                        }
                    }
                }
            }
            launch {
                viewModel.isDeclaration.collect {
                    runCatching {
                        val adapter = binding.messageRecyclerView.adapter
                        if (adapter is RunningTalkDetailAdapter) {
                            adapter.isDeclarationMode = it
                            adapter.notifyDataSetChanged()
                        }
                    }.onFailure {
                        it.printStackTrace()
                    }
                }
            }
        }
    }

    private fun refresh() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getDetailData(true)
        }
    }

    fun showReportDialog() {
        context?.let {
            TwoButtonDialog.createShow(
                it,
                title = resources.getString(R.string.msg_warning_report),
                firstButtonText = resources.getString(R.string.yes),
                secondButtonText = resources.getString(R.string.no),
                firstEvent = {
                    viewModel.messageReport()
                },
                secondEvent = {}
            )
        }
    }
}