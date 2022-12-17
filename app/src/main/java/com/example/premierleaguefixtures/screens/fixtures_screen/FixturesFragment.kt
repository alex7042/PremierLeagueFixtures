package com.example.premierleaguefixtures.screens.fixtures_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.premierleaguefixtures.databinding.FragmentFixturesBinding
import kotlinx.coroutines.*


class FixturesFragment : Fragment() {

    private lateinit var binding: FragmentFixturesBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FixturesAdapter

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
        recyclerView = binding.firstFragmentRecyclerView
        adapter = FixturesAdapter()
        recyclerView.adapter = adapter
        val viewModel = ViewModelProvider(this)[FixturesFragmentViewModel::class.java]
        viewModel.getFixturesData()
        viewModel.fixturesDataList.observe(viewLifecycleOwner) { list ->
            list.body()?.let { adapter.setFixturesList(it) }
        }
    }


}