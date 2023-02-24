package com.applemango.runnerbe.presentation.screen.dialog.postdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.databinding.DialogPostDetailBinding
import com.applemango.runnerbe.presentation.model.listener.DialogCloseListener
import com.applemango.runnerbe.presentation.screen.dialog.CustomBottomSheetDialog

class PostDetailSheetDialog(var posting: Posting, val closeListener : DialogCloseListener) :
    CustomBottomSheetDialog<DialogPostDetailBinding>(R.layout.dialog_post_detail) {

        private val viewModel: PostDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.post.value = posting
        binding.vm = viewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        closeListener.dismiss()
    }

    fun setPost(changePosting: Posting) {
        viewModel.post.value = changePosting
    }
}