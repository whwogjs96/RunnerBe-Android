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
import com.applemango.runnerbe.screen.fragment.MainFragmentDirections
import com.applemango.runnerbe.screen.fragment.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MyPageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage), View.OnClickListener {

    private val viewModel: MyPageViewModel by viewModels()


    lateinit var viewpagerFragmentAdapter: MyPageAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.myPageViewModel = viewModel
        tabInit()
        val userId = RunnerBeApplication.mTokenPreference.getUserId()
        if(userId > -1) {
            viewModel.getUserData(userId)
        }
        observeBinding()
        binding.settingButton.setOnClickListener(this)
    }

    private fun tabInit() {
        val tabTitles = listOf(resources.getString(R.string.written_post), resources.getString(R.string.join_running))
        viewpagerFragmentAdapter = MyPageAdapter(this)
        binding.viewPager.adapter = viewpagerFragmentAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    private fun observeBinding() {
        viewModel.userInfo.observe(viewLifecycleOwner) {
            if(it.profileImageUrl != null) {

            } else {

                binding.profileImageView
            }
        }
    }

    override fun onClick(v: View?) {
        when(v) {
            binding.settingButton -> {
                navigate(MainFragmentDirections.actionMainFragmentToSettingFragment())
            }
        }
    }
}