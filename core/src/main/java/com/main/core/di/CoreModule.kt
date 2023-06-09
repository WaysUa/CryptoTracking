package com.main.core.di

import com.main.core.domain.DispatchersList
import com.main.core.domain.validation.InputTextValidationRepository
import com.main.core.domain.validation.InputTextValidationRepositoryImpl
import com.main.core.domain.validation.email.EmailValidationRepository
import com.main.core.domain.validation.email.EmailValidationRepositoryImpl
import org.koin.dsl.module

val coreModule = module {
    single<EmailValidationRepository> { EmailValidationRepositoryImpl() }
    single<InputTextValidationRepository> { InputTextValidationRepositoryImpl(get()) }
    single<DispatchersList> { DispatchersList.Base() }
}