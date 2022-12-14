package com.applemango.runnerbe.screen.fragment.bookmark

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BookMarkViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    val fragmentList = listOf<Fragment>(BeforeWorkFragment(), AfterWorkFragment(), HolidayFragment())

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getItemId(position: Int): Long {
        // generate new id
        return fragmentList[position].hashCode().toLong()
    }

    override fun containsItem(itemId: Long): Boolean {
        // false if item is changed
        return fragmentList.find { it.hashCode().toLong() == itemId } != null
    }

}