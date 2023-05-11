package com.main.feat_signup.data

import androidx.compose.runtime.MutableState

data class SignUpInputTextStates(
    val username: MutableState<String>,
    val email: MutableState<String>,
    val password: MutableState<String>,
    val confirmPassword: MutableState<String>,
    val passwordVisibility: MutableState<Boolean>,
    val confirmPasswordVisibility: MutableState<Boolean>,
)