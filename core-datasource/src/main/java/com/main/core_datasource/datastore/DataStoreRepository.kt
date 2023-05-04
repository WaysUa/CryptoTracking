package com.main.core_datasource.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    fun readOnBoardingState(): Flow<Boolean>

    suspend fun saveOnBoardingState(completed: Boolean)

    companion object {
        val Context.dataStorePreferences: DataStore<Preferences> by preferencesDataStore("crypto_tracking_pref")
        val onBoardingKey = booleanPreferencesKey("on_boarding_completed")
    }
}