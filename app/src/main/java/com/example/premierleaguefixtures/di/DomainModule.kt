package com.example.premierleaguefixtures.di

import com.example.premierleaguefixtures.data.Repository
import org.koin.dsl.module

val domainModule = module {
    factory {
        Repository(
            api = get(),
            database = get(),
            mapper = get(),
        )
    }
}