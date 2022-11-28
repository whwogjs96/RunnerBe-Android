package com.applemango.runnerbe.screen.fragment.mypage

import androidx.fragment.app.viewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentMypageBinding
import com.applemango.runnerbe.screen.fragment.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    val viewModel: MyPageViewModel by viewModels()

}