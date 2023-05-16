package com.main.cryptotracking.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.main.core_datasource.datastore.DataStoreRepository
import com.main.cryptotracking.navigation.root.RootNavigationGraphRoutes
import kotlinx.coroutines.launch

class MainViewModel(
    private val dataStoreRepository: DataStoreRepository,
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {

    private val _startDestination: MutableState<String> = mutableStateOf(RootNavigationGraphRoutes.ON_BOARDING)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            dataStoreRepository.readOnBoardingState().collect { completed ->
                if (completed) {
                    if (
                        firebaseAuth.currentUser != null &&
                        firebaseAuth.currentUser?.isEmailVerified == true
                    ) {
                        _startDestination.value = RootNavigationGraphRoutes.MAIN
                    } else {
                        _startDestination.value = RootNavigationGraphRoutes.AUTHENTICATION
                    }
                } else {
                    _startDestination.value = RootNavigationGraphRoutes.ON_BOARDING
                }
            }
        }
    }
}