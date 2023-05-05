package com.main.feat_tracking.di

import com.main.feat_tracking.viewmodel.TrackingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val trackingModule = module {
    viewModel {
        TrackingViewModel()
    }
}