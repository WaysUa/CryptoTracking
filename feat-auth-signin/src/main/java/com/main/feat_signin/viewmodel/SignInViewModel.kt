package com.main.feat_signin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.main.core.data.SignInData
import com.main.core.domain.EventHandler
import com.main.core.data.exceptions.EmailException
import com.main.core.data.exceptions.PasswordException
import com.main.feat_signin.data.entities.SignInEvent
import com.main.feat_signin.data.entities.SignInViewState
import com.main.feat_signin.domain.usecases.SignInUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignInViewModel(
    private val signInUseCase: SignInUseCase
) : ViewModel(), EventHandler<SignInEvent> {

    private val _signInViewState: MutableStateFlow<SignInViewState> = MutableStateFlow(SignInViewState.Display)
    val signInViewState: StateFlow<SignInViewState> = _signInViewState

    fun signIn(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _signInViewState.emit(SignInViewState.Loading)
            val result = signInUseCase.execute(SignInData(email, password))
            if (Firebase.auth.currentUser?.isEmailVerified == false) {
//                _signInViewState.emit(SignInViewState.Error(
//                    //todo show toast
//                ))
                return@launch
            }
            if (result.data == true) {
                _signInViewState.emit(SignInViewState.Success)
                return@launch
            }
            when (result.exception) {
                is EmailException -> {
                    _signInViewState.emit(SignInViewState.Error(
                        EmailException(result.exception?.message.toString())
                    ))
                }
                is PasswordException -> {
                    _signInViewState.emit(SignInViewState.Error(
                        PasswordException(result.exception?.message.toString())
                    ))
                }
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
                   _signInViewState.emit(SignInViewState.Error(event.exception))
               }
               is SignInEvent.LoadingScreen -> {
                    _signInViewState.emit(SignInViewState.Loading)
               }
           }
       }
    }
}