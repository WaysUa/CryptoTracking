package com.main.core.domain.validation.email

import com.main.core.data.Resource
import com.main.core.data.exceptions.EmailException
import com.main.core.data.exceptions.Exceptions
import java.util.regex.Pattern

class EmailValidationRepositoryImpl : EmailValidationRepository {

    override fun isCorrectEmail(email: String): Resource<Boolean> {
        val isEmailEmpty = email.isNotBlank() && email.isNotEmpty()
        val isEmailRight = Pattern.compile(EMAIL_REGEX).matcher(email).matches()

        return if (!isEmailEmpty) {
            Resource.Error(
                data = false,
                exception = EmailException(Exceptions.EMAIL_IS_EMPTY_EXCEPTION)
            )
        } else if (!isEmailRight) {
            Resource.Error(
                data = false,
                exception = EmailException(Exceptions.EMAIL_IS_WRONG_EXCEPTION)
            )
        } else {
            Resource.Success(true)
        }
    }

    companion object {
        const val EMAIL_REGEX = "^[^\\s;]+@[^\\s;]+\\.[^\\s;]+(?:;[^\\s;]+@[^\\s;]+\\.[^\\s;]+)*\$"
    }
}