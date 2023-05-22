package com.main.core.domain.validation

import com.main.core.data.Resource
import com.main.core.data.SignInData
import com.main.core.data.exceptions.EmailException
import com.main.core.data.exceptions.Exceptions
import junit.framework.TestCase
import org.junit.Test
import junit.framework.TestCase.assertEquals
import org.mockito.Mockito
import org.mockito.Mockito.mock

class InputTextValidationRepositoryTest {

    private val inputTextValidationRepository = mock(InputTextValidationRepository::class.java)

    @Test
    fun testValidationSuccessSignInData() {
        val signInData = SignInData(
            email = "correctemail@gmail.com",
            password = "password4j3k91"
        )

        Mockito.`when`(inputTextValidationRepository.validateSignInData(signInData)).thenReturn(Resource.Success(true))
        val result = inputTextValidationRepository.validateSignInData(signInData).data
        assertEquals(true, result)
    }

    @Test
    fun testValidationSignInDataButEmailIsEmpty() {
        val signInData = SignInData(
            email = "",
            password = "password4j3k91"
        )
        Mockito.`when`(inputTextValidationRepository.validateSignInData(signInData)).thenReturn(
            Resource.Error(false, EmailException(Exceptions.EMAIL_IS_EMPTY_EXCEPTION))
        )

        val dataResult = inputTextValidationRepository.validateSignInData(signInData).data == false
        val exceptionResult = inputTextValidationRepository.validateSignInData(signInData).exception
        val messagesResult = exceptionResult?.message == Exceptions.EMAIL_IS_EMPTY_EXCEPTION
        val result = dataResult && exceptionResult is EmailException && messagesResult

        assertEquals(true, result)
    }

    @Test
    fun testValidationSignInDataButEmailIsWrong() {
        val signInData = SignInData(
            email = "incorrectemail.gmail.com\"",
            password = "password4j3k91"
        )
        Mockito.`when`(inputTextValidationRepository.validateSignInData(signInData)).thenReturn(
            Resource.Error(false, EmailException(Exceptions.EMAIL_IS_WRONG_EXCEPTION))
        )

        val dataResult = inputTextValidationRepository.validateSignInData(signInData).data == false
        val exceptionResult = inputTextValidationRepository.validateSignInData(signInData).exception
        val messagesResult = exceptionResult?.message == Exceptions.EMAIL_IS_WRONG_EXCEPTION
        val result = dataResult && exceptionResult is EmailException && messagesResult

        assertEquals(true, result)
    }
}