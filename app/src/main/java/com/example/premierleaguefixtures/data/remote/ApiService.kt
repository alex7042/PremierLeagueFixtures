package com.example.premierleaguefixtures.data.remote

import com.example.premierleaguefixtures.data.model.ApiFixtures
import com.example.premierleaguefixtures.utilities.API_KEY
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(API_KEY)
    suspend fun getFixtures(): Response<List<ApiFixtures>>
}