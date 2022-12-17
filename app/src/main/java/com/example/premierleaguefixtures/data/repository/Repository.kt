package com.example.premierleaguefixtures.data.repository

import com.example.premierleaguefixtures.data.api.RetrofitInstance
import com.example.premierleaguefixtures.model.FixturesData
import retrofit2.Response

class Repository {
    suspend fun getResult(): Response<FixturesData> {
        return RetrofitInstance.api.getFixtures()
    }
}