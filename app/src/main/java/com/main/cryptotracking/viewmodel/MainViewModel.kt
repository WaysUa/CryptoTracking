package com.main.cryptotracking.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.core_datasource.datastore.DataStoreRepository
import com.main.cryptotracking.navigation.root.RootNavigationGraphRoutes
import kotlinx.coroutines.launch

class MainViewModel(
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    private val _startDestination: MutableState<String> = mutableStateOf(RootNavigationGraphRoutes.START)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            dataStoreRepository.readOnBoardingState().collect { completed ->
                if (completed) {
                    _startDestination.value = RootNavigationGraphRoutes.MAIN
                } else {
                    _startDestination.value = RootNavigationGraphRoutes.ON_BOARDING
                }
            }
        }
    }
}