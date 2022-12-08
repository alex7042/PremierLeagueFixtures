package com.example.premierleaguefixtures

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.premierleaguefixtures.databinding.FragmentSecondBinding
import com.example.premierleaguefixtures.utilities.APP_ACTIVITY

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToSecondFragment()
    }

    private fun goToSecondFragment(){
        binding.btnGoToFirstFragment.setOnClickListener {
            APP_ACTIVITY.mNavController.navigate(R.id.action_secondFragment_to_firstFragment)
        }
    }
}