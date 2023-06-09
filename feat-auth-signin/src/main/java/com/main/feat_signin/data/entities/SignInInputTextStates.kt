package com.main.feat_signin.data.entities

import androidx.compose.runtime.MutableState

data class SignInInputTextStates(
    val email: MutableState<String>,
    val password: MutableState<String>,
    val passwordVisibility: MutableState<Boolean>,
    val isErrorEmail: Boolean,
    val isErrorPassword: Boolean
)