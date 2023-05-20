package com.main.feat_signin.data.repository

import com.main.core.data.Resource
import com.main.core.data.SignInData
import com.main.core.domain.validation.InputTextValidationRepository
import com.main.core_datasource.firebase.auth.FirebaseAuthRepository
import com.main.feat_signin.domain.repository.SignInRepository

class SignInRepositoryImpl(
    private val firebaseAuthRepository: FirebaseAuthRepository,
    private val inputTextValidationRepository: InputTextValidationRepository
) : SignInRepository {
    override suspend fun signIn(signInData: SignInData): Resource<Boolean> {
        TODO("Not yet implemented")
    }
}