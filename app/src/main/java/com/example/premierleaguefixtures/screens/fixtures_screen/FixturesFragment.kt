package com.example.premierleaguefixtures.screens.fixtures_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.premierleaguefixtures.databinding.FragmentFixturesBinding
import com.example.premierleaguefixtures.utilities.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel


class FixturesFragment : Fragment() {

    private lateinit var binding: FragmentFixturesBinding
    private var fixturesAdapter: FixturesAdapter = FixturesAdapter()
    private val viewModel by viewModel<FixturesFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFixturesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization() {
        binding.firstFragmentRecyclerView.adapter = fixturesAdapter
        viewModel.fixturesLiveData.observe(viewLifecycleOwner){
            fixturesAdapter.submitList(it.data)
            binding.progress.isVisible = it is Resource.Loading<*> && it.data.isNullOrEmpty()
            binding.error.isVisible = it is Resource.Error<*> && it.data.isNullOrEmpty()
            binding.error.text = it.error?.localizedMessage
        }
    }
}