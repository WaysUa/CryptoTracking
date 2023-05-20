package com.main.feat_signin.data.entities

import com.main.core.data.exceptions.ApplicationException

sealed class SignInViewState {

    object Display : SignInViewState()

    object Loading : SignInViewState()

    data class Error(
        val exception: ApplicationException
    ) : SignInViewState()

    object Success : SignInViewState()
}