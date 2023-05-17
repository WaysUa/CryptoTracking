package com.main.feat_signin.domain.usecases

import com.main.core.data.Resource
import com.main.core.data.SignInData
import com.main.feat_signin.domain.repository.SignInRepository

class SignInUseCase(
    private val signInRepository: SignInRepository
) {

    suspend fun execute(signInData: SignInData): Resource<Boolean> {
        return signInRepository.signIn(signInData)
    }
}