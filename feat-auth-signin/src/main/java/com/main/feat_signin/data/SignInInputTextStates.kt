package com.main.feat_signin.data

import androidx.compose.runtime.MutableState

data class SignInInputTextStates(
    val usernameOrEmail: MutableState<String>,
    val password: MutableState<String>,
    val passwordVisibility: MutableState<Boolean>,
)