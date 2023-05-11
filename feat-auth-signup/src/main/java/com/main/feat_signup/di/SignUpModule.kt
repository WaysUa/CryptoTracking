package com.main.feat_signup.di

import com.main.feat_signup.viewmodel.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val signUpModule = module {
    viewModel {
        SignUpViewModel(firebaseAuthRepository = get())
    }
}