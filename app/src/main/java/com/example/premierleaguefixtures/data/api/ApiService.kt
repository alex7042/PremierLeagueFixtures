package com.example.premierleaguefixtures.data.api

import com.example.premierleaguefixtures.model.FixturesData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("feed/json/epl-2021")
    suspend fun getFixtures(): Response<FixturesData>
}