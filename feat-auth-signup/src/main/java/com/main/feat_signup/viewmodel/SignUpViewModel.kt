package com.main.feat_signup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.core.EventHandler
import com.main.core.Resource
import com.main.core_datasource.firebase.auth.FirebaseAuthRepository
import com.main.feat_signup.data.SignUpEvent
import com.main.feat_signup.data.SignUpViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val firebaseAuthRepository: FirebaseAuthRepository,
) : ViewModel(), EventHandler<SignUpEvent> {

    private val _signUpViewState: MutableStateFlow<SignUpViewState> = MutableStateFlow(SignUpViewState.Display)
    val signUpViewState: StateFlow<SignUpViewState> = _signUpViewState

    fun signUp(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            firebaseAuthRepository.signUpWithEmailAndPassword(email, password).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _signUpViewState.emit(SignUpViewState.Success(result = result.data))
                    }

                    is Resource.Error -> {
                        _signUpViewState.emit(
                            SignUpViewState.Error(result.message.toString())
                        )
                    }

                    is Resource.Loading -> {
                        _signUpViewState.emit(SignUpViewState.Loading)
                    }
                }
            }
        }
    }

    override fun obtainEvent(event: SignUpEvent) {
        viewModelScope.launch(Dispatchers.IO) {
            when (event) {
                is SignUpEvent.EnterScreen -> {
                    _signUpViewState.emit(SignUpViewState.Display)
                }
            }
        }
    }
}