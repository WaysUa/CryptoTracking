package com.main.core.domain.validation.email

import com.main.core.data.Resource
import com.main.core.data.exceptions.EmailException
import com.main.core.data.exceptions.Exceptions
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import junit.framework.TestCase.assertEquals

class EmailValidationRepositoryTest {

    private val emailValidationRepository = mock(EmailValidationRepository::class.java)

    @Test
    fun testSuccessEmail() {
        val email = "correctemail@gmail.com"
        Mockito.`when`(emailValidationRepository.isCorrectEmail(email)).thenReturn(Resource.Success(true))

        val result = emailValidationRepository.isCorrectEmail(email)
        assertEquals(true, result.data)
    }

    @Test
    fun testEmailButEmailIsEmpty() {
        val email = ""
        Mockito.`when`(emailValidationRepository.isCorrectEmail(email)).thenReturn(
            Resource.Error(false, EmailException(Exceptions.EMAIL_IS_EMPTY_EXCEPTION))
        )

        val dataResult = emailValidationRepository.isCorrectEmail(email).data == false
        val exceptionResult = emailValidationRepository.isCorrectEmail(email).exception
        val messagesResult = exceptionResult?.message == Exceptions.EMAIL_IS_EMPTY_EXCEPTION
        val result = dataResult && exceptionResult is EmailException && messagesResult

        assertEquals(true, result)
    }

    @Test
    fun testEmailButEmailIsWrong() {
        val email = "incorrectemail.gmail.com"
        Mockito.`when`(emailValidationRepository.isCorrectEmail(email)).thenReturn(
            Resource.Error(false, EmailException(Exceptions.EMAIL_IS_WRONG_EXCEPTION))
        )

        val dataResult = emailValidationRepository.isCorrectEmail(email).data == false
        val exceptionResult = emailValidationRepository.isCorrectEmail(email).exception
        val messagesResult = exceptionResult?.message == Exceptions.EMAIL_IS_WRONG_EXCEPTION
        val result = dataResult && exceptionResult is EmailException && messagesResult

        assertEquals(true, result)
    }
}