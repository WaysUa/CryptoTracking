package com.main.feat_signup.data

import com.google.firebase.auth.AuthResult

sealed class SignUpViewState {

    object Display : SignUpViewState()

    object Loading : SignUpViewState()

    data class Error(
        val error: String
    ) : SignUpViewState()

    data class Success(
        val result: AuthResult?
    ) : SignUpViewState()
}