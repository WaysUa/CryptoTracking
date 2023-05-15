package com.main.feat_signin.data

sealed class SignInViewState {

    object Display : SignInViewState()

    object Loading : SignInViewState()

    data class Error(
        val error: String
    ) : SignInViewState()

    object Success : SignInViewState()
}