package com.example.premierleaguefixtures.screens.fixtures_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.premierleaguefixtures.R
import com.example.premierleaguefixtures.databinding.FragmentFixturesBinding
import com.example.premierleaguefixtures.screens.model.Fixtures
import com.example.premierleaguefixtures.utilities.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class FixturesFragment : Fragment(){

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

        val toolbar: Toolbar = binding.toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.action_search, menu)

                val searchItem: MenuItem = menu.findItem(R.id.actionSearch)
                val searchView: SearchView = searchItem.actionView as SearchView

                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return false
                    }

                    override fun onQueryTextChange(enterText: String): Boolean {
                        filer(enterText)
                        return false
                    }
                })
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun initialization() = with(binding) {
        fixturesFragmentRecyclerView.adapter = fixturesAdapter
        viewModel.fixturesLiveData.observe(viewLifecycleOwner) {
            fixturesAdapter.submitList(it.data)
            progress.isVisible = it is Resource.Loading<*> && it.data.isNullOrEmpty()
            error.isVisible = it is Resource.Error<*> && it.data.isNullOrEmpty()
            error.text = it.error?.localizedMessage
        }
    }


    private fun filer(text: String) {
        viewModel.fixturesLiveData.observe(viewLifecycleOwner) {
            val sortedList: ArrayList<Fixtures> = ArrayList()
            for (item in it.data!!)
                if (item.awayTeam.lowercase()
                        .contains(text.lowercase()) || item.homeTeam.lowercase()
                        .contains(text.lowercase())
                ) {
                    sortedList.add(item)
                }
            fixturesAdapter.submitList(sortedList)
        }
    }
}