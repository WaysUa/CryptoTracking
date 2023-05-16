package com.main.feat_signin.ui.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.main.core.data.SignInData
import com.main.feat_signin.data.SignInEvent
import com.main.feat_signin.data.SignInInputTextStates
import com.main.feat_signin.data.SignInViewState
import com.main.feat_signin.ui.views.SignInViewDisplay
import com.main.feat_signin.ui.views.SignInViewLoading
import com.main.feat_signin.viewmodel.SignInViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignInScreen(
    onGoToSignUpClicked: () -> Unit,
    onSuccessfulSignIn: () -> Unit,
    signInViewModel: SignInViewModel = koinViewModel()
) {
    val viewState = signInViewModel.signInViewState.collectAsState()

    val email = remember { mutableStateOf("sds@gmail.com") }
    val password = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    val signInInputTextStates = SignInInputTextStates(
        email, password, passwordVisibility
    )

    when (val state = viewState.value) {
        is SignInViewState.Display -> {
            SignInViewDisplay(
                signInInputTextStates = signInInputTextStates,
                onGoToSignUpClicked = { onGoToSignUpClicked.invoke() }
            )
        }
        is SignInViewState.Loading -> {
            SignInViewLoading(
                signInInputTextStates = signInInputTextStates,
                onGoToSignUpClicked = { onGoToSignUpClicked.invoke() }
            )
        }
        is SignInViewState.Success -> {
            onSuccessfulSignIn.invoke()
        }
        is SignInViewState.Error -> {
            SignInViewLoading(
                signInInputTextStates = signInInputTextStates,
                onGoToSignUpClicked = { onGoToSignUpClicked.invoke() }
            )
            Log.d("MyLog", "SignInScreen, error: ${state.error}")
        }
    }

    LaunchedEffect(key1 = Unit, block = {
        signInViewModel.obtainEvent(SignInEvent.EnterScreen)
    })
}

@Composable
@Preview(showBackground = true)
fun PreviewSignInScreen() {
    SignInScreen({}, {})
}