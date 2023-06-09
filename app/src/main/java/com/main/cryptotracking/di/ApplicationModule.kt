package com.main.cryptotracking.di

import com.main.cryptotracking.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    viewModel {
        MainViewModel(
            dataStoreRepository = get(),
            firebaseAuth = get(),
            dispatchers = get()
        )
    }
}
