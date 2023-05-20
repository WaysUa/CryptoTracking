package com.main.core.domain.validation.email

import com.main.core.data.Resource

interface EmailValidationRepository {

    fun isCorrectEmail(email: String): Resource<Boolean>
}