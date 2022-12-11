package com.applemango.runnerbe.screen.fragment.bookmark

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.applemango.runnerbe.R
import com.applemango.runnerbe.databinding.FragmentBookMarkBinding
import com.applemango.runnerbe.screen.fragment.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookMarkFragment: BaseFragment<FragmentBookMarkBinding>(R.layout.fragment_book_mark) {

    val bookMarkTabTitles = listOf("출근전", "퇴근후", "휴일")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pageSetting()
    }
    fun pageSetting() {
        val viewPager: ViewPager2 = binding.viewPager
        val viewpagerFragmentAdapter = BookMarkViewPagerAdapter(this)
        viewPager.adapter = viewpagerFragmentAdapter
        TabLayoutMediator(binding.bookMarkTab, viewPager) { tab, position ->
            tab.text = bookMarkTabTitles[position]
        }.attach()
    }
}