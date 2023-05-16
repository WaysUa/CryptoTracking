package com.main.core_datasource.firebase.auth

import com.google.firebase.auth.AuthResult
import com.main.core.data.Resource

interface FirebaseAuthRepository {

    suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String
    ): Resource<AuthResult>

    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Resource<AuthResult>
}