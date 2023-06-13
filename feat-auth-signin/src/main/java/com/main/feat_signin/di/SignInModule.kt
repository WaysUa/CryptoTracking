package com.main.feat_signin.di

import com.main.feat_signin.data.repository.SignInRepositoryImpl
import com.main.feat_signin.domain.repository.SignInRepository
import com.main.feat_signin.domain.usecases.SignInUseCase
import com.main.feat_signin.presentation.viewmodel.SignInViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val signInModule = module {
    viewModel {
        SignInViewModel(signInUseCase = get())
    }
    single {
        SignInUseCase(
            signInRepository = get()
        )
    }
    single<SignInRepository> {
        SignInRepositoryImpl(
            firebaseAuthRepository = get(),
            inputTextValidationRepository = get()
        )
    }
}