package com.main.cryptotracking.di

import com.main.cryptotracking.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    viewModel {
        MainViewModel(dataStoreRepository = get(), firebaseAuth = get())
    }
}