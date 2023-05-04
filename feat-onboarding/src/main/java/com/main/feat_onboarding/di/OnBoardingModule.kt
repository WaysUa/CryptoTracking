package com.main.feat_onboarding.di

import com.main.feat_onboarding.viewmodel.OnBoardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val onBoardingModule = module {
    viewModel {
        OnBoardingViewModel(dataStoreRepository = get())
    }
}