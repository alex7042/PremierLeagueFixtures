package com.example.premierleaguefixtures.screens.fixtures_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.premierleaguefixtures.data.Repository
import com.example.premierleaguefixtures.data.remote.RetrofitInstance
import com.example.premierleaguefixtures.data.storage.FixturesDatabase

class FixturesViewModelFactory : ViewModelProvider.Factory {

    private val repository by lazy(LazyThreadSafetyMode.NONE) {
        Repository(api = RetrofitInstance.api, database = FixturesDatabase.getDatabase()!!)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FixturesFragmentViewModel(repository = repository) as T
    }
}