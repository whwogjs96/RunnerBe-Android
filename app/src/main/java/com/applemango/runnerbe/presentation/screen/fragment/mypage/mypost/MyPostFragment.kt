package com.applemango.runnerbe.presentation.screen.fragment.mypage.mypost

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.data.dto.Posting
import com.applemango.runnerbe.databinding.FragmentMyPostBinding
import com.applemango.runnerbe.presentation.model.listener.BookMarkClickListener
import com.applemango.runnerbe.presentation.model.listener.MyPostClickListener
import com.applemango.runnerbe.presentation.screen.deco.RecyclerViewItemDeco
import com.applemango.runnerbe.presentation.screen.fragment.base.BaseFragment
import com.applemango.runnerbe.presentation.screen.fragment.main.MainFragmentDirections
import com.applemango.runnerbe.presentation.screen.fragment.mypage.MyPageViewModel

class MyPostFragment : BaseFragment<FragmentMyPostBinding>(R.layout.fragment_my_post){

    private val viewModel: MyPageViewModel by viewModels(
        ownerProducer = { requireParentFragment() }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        binding.fragment = this
        context?.let {
            binding.postRecycler.addItemDecoration(RecyclerViewItemDeco(it, 12))
        }
    }

    fun getMyPostClickListener() = object : MyPostClickListener {
        override fun attendanceSeeOnClick(post: Posting) {
            navigate(MainFragmentDirections.actionMainFragmentToMyPostAttendanceSeeFragment(post.runnerList?.toTypedArray()?: arrayOf()))
        }

        override fun attendanceManagingOnClick(post: Posting) {
            navigate(MainFragmentDirections.actionMainFragmentToMyPostAttendanceAccessionFragment(post.postId, post.runnerList?.toTypedArray()?: arrayOf()))
        }

    }
}