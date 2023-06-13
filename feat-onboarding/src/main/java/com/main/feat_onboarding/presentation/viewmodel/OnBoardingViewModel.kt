package com.main.feat_onboarding.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.core_datasource.datastore.DataStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OnBoardingViewModel(
    private val dataStoreRepository: DataStoreRepository
): ViewModel() {

    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreRepository.saveOnBoardingState(completed)
        }
    }
}