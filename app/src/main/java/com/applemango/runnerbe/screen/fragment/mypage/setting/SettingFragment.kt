package com.applemango.runnerbe.screen.fragment.mypage.setting

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentSettingsBinding
import com.applemango.runnerbe.screen.activity.SignActivity
import com.applemango.runnerbe.screen.dialog.twobutton.TwoButtonDialog
import com.applemango.runnerbe.screen.fragment.base.BaseFragment
import com.applemango.runnerbe.util.TokenSPreference

class SettingFragment : BaseFragment<FragmentSettingsBinding>(R.layout.fragment_settings), View.OnClickListener {

    private val viewModel : SettingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.logoutBtn.setOnClickListener(this)
        binding.makers.setOnClickListener(this)
        binding.termsOfServiceButton.setOnClickListener(this)
        binding.privacyPolicyButton.setOnClickListener(this)
        binding.instagramButton.setOnClickListener(this)
        binding.backBtn.setOnClickListener(this)
        observeBind()
        binding.versionsTxt.text = getAppVersion()
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
            binding.logoutBtn -> {
                context?.let {
                    TwoButtonDialog.createShow(
                        it,
                        firstButtonText = resources.getString(R.string.no),
                        secondButtonText = resources.getString(R.string.yes),
                        firstEvent = {},
                        secondEvent = {viewModel.logout()},
                        title = resources.getString(R.string.question_logout)
                    )
                }
            }
            binding.termsOfServiceButton -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://runnerbe.xyz/policy/service.txt"))
                startActivity(intent)
            }
            binding.privacyPolicyButton -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://runnerbe.xyz/policy/privacy-deal.txt"))
                startActivity(intent)
            }
            binding.instagramButton -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/runner_be_/"))
                startActivity(intent)
            }
            binding.makers -> {
                navigate(SettingFragmentDirections.actionSettingFragmentToCreatorFragment())
            }
            binding.backBtn -> {
                navPopStack()
            }
        }
    }

    private fun getAppVersion(): String {
        return runCatching {
            val pInfo = requireContext().packageManager.getPackageInfo(
                requireContext().packageName, 0)
            pInfo.versionName
        }.getOrNull()?:""
    }
}