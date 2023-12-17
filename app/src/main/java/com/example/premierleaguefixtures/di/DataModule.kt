package com.example.premierleaguefixtures.di

import com.example.premierleaguefixtures.data.mappers.FixturesMapper
import com.example.premierleaguefixtures.data.remote.ApiService
import com.example.premierleaguefixtures.data.storage.FixturesDatabase
import com.example.premierleaguefixtures.utilities.BASE_URL
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single {
        FixturesDatabase.createDatabase(context = get())
    }

    single {
        FixturesMapper()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ApiService> {
        get<Retrofit>().create(ApiService::class.java)
    }
}