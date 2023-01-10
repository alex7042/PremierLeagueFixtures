package com.example.premierleaguefixtures.screens.splash_screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.premierleaguefixtures.R
import com.example.premierleaguefixtures.databinding.FragmentSplashScreenBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentSplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        topSplashScreenViewAnimation()
        bottomSplashScreenViewAnimation()
        splashScreenTitleAnimation()
        CoroutineScope(Dispatchers.Main).launch {
            delay(2500)
            Navigation.findNavController(view)
                .navigate(R.id.action_splashScreenFragment_to_fixturesFragment)
        }
    }

    // StartAnimation

    private fun topSplashScreenViewAnimation() {
        val topView = binding.topScreenView
        val topViewAnimation =
            AnimationUtils.loadAnimation(requireContext(), R.anim.top_splash_screen_view_anim)
        topView.startAnimation(topViewAnimation)
    }

    private fun bottomSplashScreenViewAnimation() {
        val bottomView = binding.bottomScreenView
        val bottomViewAnimation =
            AnimationUtils.loadAnimation(requireContext(), R.anim.bottom_splash_sreen_view_anim)
        bottomView.startAnimation(bottomViewAnimation)
    }

    private fun splashScreenTitleAnimation() {
        val splashScreenTitle = binding.splashScreenTitle
        val titleAnimation =
            AnimationUtils.loadAnimation(requireContext(), R.anim.splash_screen_title_alpha_anim)
        splashScreenTitle.startAnimation(titleAnimation)
    }
}