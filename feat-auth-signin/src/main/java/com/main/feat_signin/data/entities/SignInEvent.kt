package com.main.feat_signin.data.entities

sealed class SignInEvent {

    object EnterScreen : SignInEvent()

    object LoadingScreen : SignInEvent()

    data class ErrorScreen(
        val error: String
    ) : SignInEvent()
}