package com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost.accession

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentMyPostAttendanceAccessionBinding
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPostAttendanceAccessionFragment : BaseFragment<FragmentMyPostAttendanceAccessionBinding>(R.layout.fragment_my_post_attendance_accession) {

    private val viewModel : MyPostAttendanceAccessionViewModel by viewModels()
    private val args : MyPostAttendanceAccessionFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        viewModel.userListUpdate(args.users.toList())
    }
}