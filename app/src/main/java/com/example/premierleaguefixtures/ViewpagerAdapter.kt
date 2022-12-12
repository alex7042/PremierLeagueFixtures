package com.example.premierleaguefixtures

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.premierleaguefixtures.screens.BaseFragment
import com.example.premierleaguefixtures.screens.FirstFragment
import com.example.premierleaguefixtures.screens.SecondFragment

class ViewpagerAdapter(
    fragment: BaseFragment
) : FragmentStateAdapter(fragment) {

    private val pageAmt = 2

    override fun getItemCount(): Int = pageAmt

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            else -> SecondFragment()
        }
    }

}