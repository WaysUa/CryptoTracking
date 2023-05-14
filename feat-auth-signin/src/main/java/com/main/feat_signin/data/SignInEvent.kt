package com.main.feat_signin.data

sealed class SignInEvent {

    object EnterScreen : SignInEvent()

    object LoadingScreen : SignInEvent()

    data class ErrorScreen(
        val error: String
    ) : SignInEvent()
}