package com.example.premierleaguefixtures.screens.fixtures_screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.premierleaguefixtures.data.repository.Repository
import com.example.premierleaguefixtures.model.FixturesData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class FixturesFragmentViewModel(application: Application) : AndroidViewModel(application) {
    var repository = Repository()
    val fixturesDataList: MutableLiveData<Response<FixturesData>> = MutableLiveData()

    fun getFixturesData() {
        viewModelScope.launch {
            fixturesDataList.value = repository.getResult()
        }
    }
}