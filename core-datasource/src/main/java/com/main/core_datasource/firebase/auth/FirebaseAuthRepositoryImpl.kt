package com.main.core_datasource.firebase.auth

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.main.core.data.Resource
import com.main.core.exceptions.FirebaseException
import kotlinx.coroutines.tasks.await

class FirebaseAuthRepositoryImpl(
    private val firebaseAuth: FirebaseAuth,
) : FirebaseAuthRepository {

    override suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String,
    ): Resource<AuthResult> {
        val result = firebaseAuth.createUserWithEmailAndPassword(email, password)

        return try {
            result.await()
            firebaseAuth.currentUser?.sendEmailVerification()
            Resource.Success(result.result)
        } catch (e: Exception) {
            Resource.Error(
                data = null,
                FirebaseException(result.exception?.message.toString())
            )
        }
    }

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ): Resource<AuthResult> {
        val result = firebaseAuth.signInWithEmailAndPassword(email, password)

        return try {
            result.await()
            Resource.Success(result.result)
        } catch (e: Exception) {
            Resource.Error(
                data = null,
                FirebaseException(result.exception?.message.toString())
            )
        }
    }
}