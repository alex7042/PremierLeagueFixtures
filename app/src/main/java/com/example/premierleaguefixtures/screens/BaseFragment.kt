package com.example.premierleaguefixtures.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.premierleaguefixtures.ViewpagerAdapter
import com.example.premierleaguefixtures.databinding.FragmentBaseBinding
import com.google.android.material.tabs.TabLayoutMediator

class BaseFragment : Fragment() {

    private lateinit var binding: FragmentBaseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentBaseBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpTabLayoutWithViewPager()
    }

    private fun setUpTabLayoutWithViewPager() {
        binding.viewPager.adapter = ViewpagerAdapter(this)
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        tabLayout.tabIconTint = null
        TabLayoutMediator(tabLayout, viewPager) { _, position ->
            when (position) {
                0 -> {}
                1 -> {}
            }
        }.attach()
    }
}