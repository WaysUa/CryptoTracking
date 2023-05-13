package com.main.core_datasource.firebase.auth

import com.google.firebase.auth.AuthResult
import com.main.core.Resource
import kotlinx.coroutines.flow.Flow

interface FirebaseAuthRepository {

    suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String
    ): Resource<AuthResult>

    fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<Resource<AuthResult>>
}