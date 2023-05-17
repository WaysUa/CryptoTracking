package com.main.feat_signin.domain.repository

import com.main.core.data.Resource
import com.main.core.data.SignInData

interface SignInRepository {

    suspend fun signIn(signInData: SignInData): Resource<Boolean>

}