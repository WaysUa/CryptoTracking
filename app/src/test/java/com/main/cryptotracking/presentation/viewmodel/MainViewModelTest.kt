package com.main.cryptotracking.presentation.viewmodel

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.main.core_datasource.datastore.DataStoreRepository
import com.main.cryptotracking.BaseAppTest
import com.main.cryptotracking.domain.navigation.root.RootNavigationGraphRoutes
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import kotlinx.coroutines.test.setMain
import org.mockito.Mockito.`when`

class MainViewModelTest : BaseAppTest() {

    private val dataStoreRepository = mock(DataStoreRepository::class.java)
    private val firebaseAuth = mock(FirebaseAuth::class.java)
    private val mainViewModel = MainViewModel(
        dataStoreRepository = dataStoreRepository,
        firebaseAuth = firebaseAuth,
        dispatchers = TestDispatchersList()
    )

    @Test
    fun `test if onboarding isn't completed`() = runBlocking {
        `when`(dataStoreRepository.readOnBoardingState()).thenReturn(flowOf(false))

        mainViewModel.init()
        assertEquals(RootNavigationGraphRoutes.ON_BOARDING, mainViewModel.startDestination.value)
    }

    @Test
    fun `test if onboarding completed and user data is correct`() = runBlocking {
        `when`(dataStoreRepository.readOnBoardingState()).thenReturn(flowOf(true))
        `when`(firebaseAuth.currentUser).thenReturn(mock(FirebaseUser::class.java))
        `when`(firebaseAuth.currentUser?.isEmailVerified).thenReturn(true)

        mainViewModel.init()
        assertEquals(RootNavigationGraphRoutes.MAIN, mainViewModel.startDestination.value)
    }

    @Test
    fun `test if onboarding completed and user exists but email isn't confirmed`() = runBlocking {
        `when`(dataStoreRepository.readOnBoardingState()).thenReturn(flowOf(true))
        `when`(firebaseAuth.currentUser).thenReturn(mock(FirebaseUser::class.java))
        `when`(firebaseAuth.currentUser?.isEmailVerified).thenReturn(false)

        assertEquals(RootNavigationGraphRoutes.AUTHENTICATION, mainViewModel.startDestination.value)
    }

    @Test
    fun `test if onboarding completed and user data is wrong`() = runBlocking {
        `when`(dataStoreRepository.readOnBoardingState()).thenReturn(flowOf(true))
        `when`(firebaseAuth.currentUser).thenReturn(null)

        assertEquals(RootNavigationGraphRoutes.AUTHENTICATION, mainViewModel.startDestination.value)
    }
}