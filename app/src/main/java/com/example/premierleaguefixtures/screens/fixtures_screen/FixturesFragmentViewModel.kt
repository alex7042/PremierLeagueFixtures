package com.example.premierleaguefixtures.screens.fixtures_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.premierleaguefixtures.data.Repository

class FixturesFragmentViewModel(repository: Repository) : ViewModel() {
    val fixturesLiveData = repository.getResults().asLiveData()
}