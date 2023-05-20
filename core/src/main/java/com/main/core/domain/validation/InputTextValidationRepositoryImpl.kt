package com.main.core.domain.validation

import com.main.core.data.Resource
import com.main.core.data.SignInData
import com.main.core.domain.validation.email.EmailValidationRepository

class InputTextValidationRepositoryImpl(
    private val emailValidationRepository: EmailValidationRepository
) : InputTextValidationRepository {

    override fun validateSignInData(signInData: SignInData): Resource<Boolean> {
        return emailValidationRepository.isCorrectEmail(email = signInData.email)
    }

    override fun validateSignUpData() {
        TODO("Not yet implemented")
    }
}