package com.main.feat_signin.data.entities

import com.main.core.exceptions.ApplicationException

sealed class SignInEvent {

    object EnterScreen : SignInEvent()

    object LoadingScreen : SignInEvent()

    data class ErrorScreen(
        val exception: ApplicationException
    ) : SignInEvent()
}