package com.main.feat_signin.data

import com.google.firebase.auth.AuthResult

sealed class SignInViewState {

    object Display : SignInViewState()

    object Loading : SignInViewState()

    data class Error(
        val error: String
    ) : SignInViewState()

    data class Success(
        val result: AuthResult?
    ) : SignInViewState()
}