package com.main.core_datasource.firebase.auth

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.main.core.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
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
            Resource.Error(result.exception?.message.toString())
        }
    }

    override fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())

            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.message ?: "Unexpected Message"))
        }
    }
}