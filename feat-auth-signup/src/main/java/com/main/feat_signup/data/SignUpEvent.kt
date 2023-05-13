package com.main.feat_signup.data

import com.google.firebase.auth.AuthResult

sealed class SignUpEvent {

    object EnterScreen : SignUpEvent()

    object LoadingScreen : SignUpEvent()

    data class ErrorScreen(
        val error: String
    ) : SignUpEvent()

    data class SuccessScreen(
        val result: AuthResult?
    ) : SignUpEvent()
}
