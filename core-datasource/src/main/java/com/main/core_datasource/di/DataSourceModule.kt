package com.main.core_datasource.di

import com.main.core_datasource.datastore.DataStoreRepository
import com.main.core_datasource.datastore.DataStoreRepositoryImpl
import org.koin.dsl.module

val dataStoreModule = module {
    single<DataStoreRepository> {
        DataStoreRepositoryImpl(context = get())
    }
}