package com.example.premierleaguefixtures

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.premierleaguefixtures.databinding.FragmentFirstBinding
import com.example.premierleaguefixtures.utilities.APP_ACTIVITY


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToSecondFragment()
    }

    private fun goToSecondFragment() {
        binding.btnGoToSecondFragment.setOnClickListener {
            APP_ACTIVITY.mNavController.navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }
}