package com.applemango.runnerbe.screen.fragment.mypage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.applemango.runnerbe.R
import com.applemango.runnerbe.RunnerBeApplication
import com.applemango.runnerbe.databinding.FragmentMypageBinding
import com.applemango.runnerbe.model.RunnerDiligence
import com.applemango.runnerbe.network.response.CommonResponse
import com.applemango.runnerbe.screen.fragment.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MyPageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    private val viewModel: MyPageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.myPageViewModel = viewModel
        val userId = RunnerBeApplication.mTokenPreference.getUserId()
        if(userId > -1) {
            viewModel.getUserData(userId)
        }
        observeBinding()
    }

    private fun observeBinding() {
        viewModel.userInfo.observe(viewLifecycleOwner) {
            if(it.profileImageUrl != null) {

            } else {

                binding.profileImageView
            }
        }
    }
}