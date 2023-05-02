package com.applemango.runnerbe.presentation.screen.fragment.main.postdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentPostDetailBinding
import com.applemango.runnerbe.presentation.model.listener.PostDialogListener
import com.applemango.runnerbe.presentation.screen.dialog.appliedrunner.WaitingRunnerListDialog
import com.applemango.runnerbe.presentation.screen.dialog.postdetail.PostDetailViewModel
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment

class PostDetailFragment : BaseFragment<FragmentPostDetailBinding>(R.layout.fragment_post_detail) {

    private val viewModel: PostDetailViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        binding.fragment = this
    }

    fun showAppliedRunnerListDialog() {
        WaitingRunnerListDialog(viewModel.waitingInfo, viewModel, object : PostDialogListener {
            override fun moveToMessage(roomId: Int, repUserName: String?) {

            }
            override fun dismiss() {}
        }, viewModel.roomId).show(
            childFragmentManager,
            "appliedRunner"
        )
    }
}