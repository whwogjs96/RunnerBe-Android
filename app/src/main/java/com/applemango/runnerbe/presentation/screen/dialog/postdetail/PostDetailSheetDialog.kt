package com.applemango.runnerbe.presentation.screen.dialog.postdetail

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.applemango.runnerbe.R
import com.applemango.runnerbe.RunnerBeApplication
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.databinding.DialogPostDetailBinding
import com.applemango.runnerbe.presentation.model.listener.PostDialogListener
import com.applemango.runnerbe.presentation.screen.dialog.CustomBottomSheetDialog
import com.applemango.runnerbe.presentation.screen.dialog.appliedrunner.WaitingRunnerListDialog
import com.applemango.runnerbe.presentation.screen.dialog.message.MessageDialog
import com.applemango.runnerbe.presentation.screen.dialog.twobutton.TwoButtonDialog
import com.applemango.runnerbe.presentation.state.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostDetailSheetDialog(var posting: Posting, private val postListener: PostDialogListener) :
    CustomBottomSheetDialog<DialogPostDetailBinding>(R.layout.dialog_post_detail) {

    private val viewModel: PostDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.post.value = posting
        binding.vm = viewModel
        binding.dialog = this
        observeBind()
    }

    override fun onResume() {
        super.onResume()
        refresh()
    }

    fun refresh() {
        viewModel.getPostDetail(posting.postId, RunnerBeApplication.mTokenPreference.getUserId())
    }

    fun moveToMessage() {
        viewModel.roomId?.let {
            postListener.moveToMessage(it, viewModel.post.value?.nickName)
        }
    }

    fun observeBind() {
        viewLifecycleOwner.lifecycleScope.launch {
            launch {
                viewModel.processUiState.collect {
                    context?.let { context ->
                        if (it is UiState.Loading) showLoadingDialog(context)
                        else dismissLoadingDialog()
                    }
                    when (it) {
                        is UiState.Success -> {
                            Toast.makeText(
                                context,
                                resources.getString(if (viewModel.isMyPost()) R.string.msg_post_close else R.string.msg_post_apply),
                                Toast.LENGTH_SHORT
                            ).show()
                            refresh()
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
        }
    }

    fun clickBottomButton() {
        context?.let {
            TwoButtonDialog.createShow(
                context = it,
                title = resources.getString(if (viewModel.isMyPost()) R.string.question_post_close else R.string.question_post_apply),
                firstButtonText = resources.getString(R.string.no),
                secondButtonText = resources.getString(R.string.yes),
                firstEvent = {},
                secondEvent = {
                    viewModel.bottomProcess()
                }
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        postListener.dismiss()
    }

    fun setPost(changePosting: Posting) {
        viewModel.post.value = changePosting
    }

    fun ageString(posting: Posting) : String {
        val age = viewModel.post.value?.age
        var result = resources.getString(R.string.all_age)
        age?.let {
            runCatching {
                val ageSplit = age.split("-")
                if(!(ageSplit[0].toInt() < 20 || ageSplit[1].toInt() > 65)) result = it
            }
        }
        return result
    }

    fun showAppliedRunnerListDialog() {
        WaitingRunnerListDialog(viewModel.waitingInfo, viewModel, postListener, viewModel.roomId).show(
            childFragmentManager,
            "appliedRunner"
        )
    }
}