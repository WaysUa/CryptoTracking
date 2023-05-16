package com.main.core.validation.email

import com.main.core.data.Resource

interface EmailValidationRepository {

    fun isCorrectEmail(email: String): Resource<Boolean>
}