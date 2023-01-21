package com.applemango.runnerbe.screen.fragment.mypage.editprofile

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton.OnCheckedChangeListener
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentEditProfileBinding
import com.applemango.runnerbe.model.JobButtonId
import com.applemango.runnerbe.screen.dialog.twobutton.TwoButtonDialog
import com.applemango.runnerbe.screen.fragment.base.BaseFragment
import com.applemango.runnerbe.util.bindDate

class EditProfileFragment :
    BaseFragment<FragmentEditProfileBinding>(R.layout.fragment_edit_profile) {

    private var currentRadioButton : Int? = null
    private val viewModel: EditProfileViewModel by viewModels()
    private val args: EditProfileFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        binding.buttonClick = jobButtonClick()
        viewModel.userInfo.value = args.userData
        observeBind()
    }

    private fun observeBind() {
        viewModel.userInfo.observe(viewLifecycleOwner) {
            binding.userNameEdit.isEnabled = it.nameChanged == "Y"
            binding.nameChangeBtn.isEnabled = it.nameChanged == "Y"
            if (it.nameChanged == "Y") {
                binding.nameChangeBtn.text = resources.getString(R.string.double_check)
                binding.nameDetailTxt.text =
                    resources.getString(R.string.msg_possible_nickname_change)
            } else {
                binding.userNameEdit.setText("${it.nickName} (disabled)")
                binding.nameChangeBtn.text = resources.getString(R.string.finished_enrollment)
                binding.nameDetailTxt.text =
                    resources.getString(R.string.msg_impossible_nickname_change)
            }
            initJob()
        }
    }

    private fun initJob() {
        val currentJob = JobButtonId.findByName(viewModel.userInfo.value?.job ?: "")
        viewModel.radioChecked.value = currentJob?.id
        viewModel.currentJob = currentJob?.job ?: ""
        currentRadioButton = currentJob?.id
    }

    private fun jobButtonClick() = OnCheckedChangeListener { btn, isCheck ->
        if(viewModel.userInfo.value?.job != JobButtonId.findById(btn.id)?.koreanName && isCheck) {
            context?.let {
                TwoButtonDialog.createShow(
                    context = it,
                    title = resources.getString(R.string.question_job_change),
                    firstButtonText = resources.getString(R.string.no),
                    secondButtonText = resources.getString(R.string.yes),
                    firstEvent = {
                        initJob()
                    },
                    secondEvent = {
                        viewModel.currentJob = JobButtonId.findById(id)?.job ?: ""
                        //여기에 서버와 통신 추가
                    }
                )
            }
        }
    }

}