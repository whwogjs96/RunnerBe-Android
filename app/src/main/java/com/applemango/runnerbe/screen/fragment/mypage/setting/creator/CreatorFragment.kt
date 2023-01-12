package com.applemango.runnerbe.screen.fragment.mypage.setting.creator

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentCreatorsBinding
import com.applemango.runnerbe.screen.deco.RecyclerViewGridItemDeco
import com.applemango.runnerbe.screen.fragment.base.BaseFragment

class CreatorFragment: BaseFragment<FragmentCreatorsBinding>(R.layout.fragment_creators) {

    private val viewModel : CreatorViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.creatorRecyclerView.layoutManager = GridLayoutManager(context, 2)
        context?.let {
            binding.creatorRecyclerView.addItemDecoration(RecyclerViewGridItemDeco(
                it,
                58,
                41,
                false,
                2
            ))
        }

    }
}