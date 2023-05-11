package com.main.core_datasource.di

import com.google.firebase.auth.FirebaseAuth
import com.main.core_datasource.firebase.auth.FirebaseAuthRepository
import com.main.core_datasource.firebase.auth.FirebaseAuthRepositoryImpl
import org.koin.dsl.module

val firebaseModule = module {
    single<FirebaseAuthRepository> { FirebaseAuthRepositoryImpl(firebaseAuth = get()) }
    single { FirebaseAuth.getInstance() }
}