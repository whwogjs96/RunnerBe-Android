package com.applemango.runnerbe.screen.fragment.mypage.setting

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentSettingsBinding
import com.applemango.runnerbe.screen.activity.SignActivity
import com.applemango.runnerbe.screen.fragment.base.BaseFragment
import com.applemango.runnerbe.util.TokenSPreference

class SettingFragment : BaseFragment<FragmentSettingsBinding>(R.layout.fragment_settings), View.OnClickListener {

    private val viewModel : SettingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.logoutBtn.setOnClickListener(this)
        observeBind()
    }

    private fun observeBind() {
        viewModel.logoutState.observe(viewLifecycleOwner) {
            if(it) {
                activity?.startActivity(Intent(context, SignActivity::class.java))
                activity?.finish()
            }
        }
    }

    override fun onClick(v: View?) {
        when(v) {
            binding.logoutBtn -> viewModel.logout()
        }
    }
}