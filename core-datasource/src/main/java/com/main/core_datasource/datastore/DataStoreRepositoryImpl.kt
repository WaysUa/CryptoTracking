package com.main.core_datasource.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.main.core_datasource.datastore.DataStoreRepository.Companion.dataStorePreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class DataStoreRepositoryImpl(
    private val context: Context,
) : DataStoreRepository {

    override fun readOnBoardingState(): Flow<Boolean> {
        return context.dataStorePreferences.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val onBoardingState = preferences[DataStoreRepository.onBoardingKey] ?: false
                onBoardingState
            }
    }

    override suspend fun saveOnBoardingState(completed: Boolean) {
        context.dataStorePreferences.edit {
            it[DataStoreRepository.onBoardingKey] = completed
        }
    }
}