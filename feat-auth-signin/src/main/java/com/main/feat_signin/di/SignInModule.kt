package com.main.feat_signin.di

import com.main.feat_signin.viewmodel.SignInViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val signInModule = module {
    viewModel {
        SignInViewModel(firebaseAuthRepository = get(), inputTextValidationRepository = get())
    }
}