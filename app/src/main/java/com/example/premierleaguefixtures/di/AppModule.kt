package com.example.premierleaguefixtures.di

import com.example.premierleaguefixtures.screens.fixtures_screen.FixturesFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        FixturesFragmentViewModel(
            repository = get()
        )
    }
}