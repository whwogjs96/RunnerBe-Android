package com.applemango.runnerbe.screen.fragment.mypage.mypost

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentMyPostBinding
import com.applemango.runnerbe.screen.deco.RecyclerViewItemDeco
import com.applemango.runnerbe.screen.fragment.base.BaseFragment
import com.applemango.runnerbe.screen.fragment.mypage.MyPageViewModel

class MyPostFragment : BaseFragment<FragmentMyPostBinding>(R.layout.fragment_my_post){

    private val viewModel: MyPageViewModel by viewModels(
        ownerProducer = { requireParentFragment() }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        context?.let {
            binding.postRecycler.addItemDecoration(RecyclerViewItemDeco(it, 12))
        }
    }
}