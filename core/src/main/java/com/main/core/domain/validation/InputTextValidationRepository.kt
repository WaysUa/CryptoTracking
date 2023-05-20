package com.main.core.domain.validation

import com.main.core.data.Resource
import com.main.core.data.SignInData

interface InputTextValidationRepository {

    fun validateSignInData(signInData: SignInData): Resource<Boolean>

    fun validateSignUpData()
}