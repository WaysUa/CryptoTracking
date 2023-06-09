package com.main.feat_signup.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.core.domain.EventHandler
import com.main.core.data.exceptions.UndefinedException
import com.main.core_datasource.firebase.auth.FirebaseAuthRepository
import com.main.feat_signup.data.SignUpEvent
import com.main.feat_signup.data.SignUpViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val firebaseAuthRepository: FirebaseAuthRepository
) : ViewModel(), EventHandler<SignUpEvent> {

    private val _signUpViewState: MutableStateFlow<SignUpViewState> = MutableStateFlow(SignUpViewState.Display)
    val signUpViewState: StateFlow<SignUpViewState> = _signUpViewState

    fun signUp(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _signUpViewState.emit(SignUpViewState.Loading)
            val result = firebaseAuthRepository.signUpWithEmailAndPassword(email, password)
            if (result.data != null) {
                _signUpViewState.emit(SignUpViewState.Success(result.data))
            } else {
                _signUpViewState.emit(
                    SignUpViewState.Error(
                        UndefinedException(result.exception?.message.toString())
                    )
                )
            }
        }
    }

    override fun obtainEvent(event: SignUpEvent) {
        viewModelScope.launch(Dispatchers.IO) {
            when (event) {
                is SignUpEvent.EnterScreen -> {
                    _signUpViewState.emit(SignUpViewState.Display)
                }
                is SignUpEvent.ErrorScreen -> {
                    _signUpViewState.emit(SignUpViewState.Error(
                        UndefinedException(event.error)
                    ))
                }
                is SignUpEvent.LoadingScreen -> {
                    _signUpViewState.emit(SignUpViewState.Loading)
                }
                is SignUpEvent.SuccessScreen -> {
                    _signUpViewState.emit(SignUpViewState.Success(event.result))
                }
            }
        }
    }
}