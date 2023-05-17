package com.main.feat_signup.data

import com.google.firebase.auth.AuthResult
import com.main.core.exceptions.ApplicationException

sealed class SignUpViewState {

    object Display : SignUpViewState()

    object Loading : SignUpViewState()

    data class Error(
        val exception: ApplicationException
    ) : SignUpViewState()

    data class Success(
        val result: AuthResult?
    ) : SignUpViewState()
}