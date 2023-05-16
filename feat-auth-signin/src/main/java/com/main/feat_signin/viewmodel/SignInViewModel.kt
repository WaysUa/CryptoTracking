package com.main.feat_signin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.core.data.SignInData
import com.main.core.domain.EventHandler
import com.main.core.validation.InputTextValidationRepository
import com.main.core_datasource.firebase.auth.FirebaseAuthRepository
import com.main.feat_signin.data.SignInEvent
import com.main.feat_signin.data.SignInViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignInViewModel(
    private val firebaseAuthRepository: FirebaseAuthRepository,
    private val inputTextValidationRepository: InputTextValidationRepository
) : ViewModel(), EventHandler<SignInEvent> {

    private val _signInViewState: MutableStateFlow<SignInViewState> = MutableStateFlow(SignInViewState.Display)
    val signInViewState: StateFlow<SignInViewState> = _signInViewState

    fun signIn(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val validationResult = inputTextValidationRepository.validateSignInData(SignInData(email, password))
            if (validationResult.data == false || validationResult.data == null) {
                return@launch
            }
            _signInViewState.emit(SignInViewState.Loading)

            val result = firebaseAuthRepository.signInWithEmailAndPassword(email, password)
            if (result.data != null) {
                _signInViewState.emit(SignInViewState.Success)
            } else {
                _signInViewState.emit(SignInViewState.Error(result.message.toString()))
            }
        }
    }

    override fun obtainEvent(event: SignInEvent) {
       viewModelScope.launch(Dispatchers.IO) {
           when (event) {
               is SignInEvent.EnterScreen -> {
                   _signInViewState.emit(SignInViewState.Display)
               }

               is SignInEvent.ErrorScreen -> {

               }
               is SignInEvent.LoadingScreen -> {
                    _signInViewState.emit(SignInViewState.Loading)
               }
           }
       }
    }
}