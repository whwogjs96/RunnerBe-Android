package com.applemango.runnerbe.presentation.screen.fragment.chat.detail.image.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentImageDetailBinding
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment

class ImageDetailFragment: BaseFragment<FragmentImageDetailBinding>(R.layout.fragment_image_detail) {

    private val viewModel: ImageDetailViewModel by viewModels<ImageDetailViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }
}