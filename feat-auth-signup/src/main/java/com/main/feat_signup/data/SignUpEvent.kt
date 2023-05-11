package com.main.feat_signup.data

sealed class SignUpEvent {
    object EnterScreen : SignUpEvent()
}
