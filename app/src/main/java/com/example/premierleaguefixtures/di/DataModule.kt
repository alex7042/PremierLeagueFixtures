package com.example.premierleaguefixtures.di

import com.example.premierleaguefixtures.data.remote.ApiService
import com.example.premierleaguefixtures.data.remote.RetrofitInstance
import com.example.premierleaguefixtures.data.storage.FixturesDatabase
import org.koin.dsl.module

val dataModule = module {

    single<FixturesDatabase> {
        FixturesDatabase.createDatabase(get())
    }

    single<ApiService> {
        RetrofitInstance.api
    }
}