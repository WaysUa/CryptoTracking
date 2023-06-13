package com.main.feat_signin.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.main.core.data.exceptions.EmailException
import com.main.core.data.exceptions.UndefinedException
import com.main.feat_signin.data.entities.SignInEvent
import com.main.feat_signin.data.entities.SignInInputTextStates
import com.main.feat_signin.data.entities.SignInViewState
import com.main.feat_signin.presentation.ui.views.SignInViewDisplay
import com.main.feat_signin.presentation.ui.views.SignInViewError
import com.main.feat_signin.presentation.ui.views.SignInViewLoading
import com.main.feat_signin.presentation.viewmodel.SignInViewModel
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
        email, password, passwordVisibility, isErrorEmail = false, isErrorPassword = true
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
            SignInViewError(
                signInInputTextStates = signInInputTextStates,
                onGoToSignUpClicked = { onGoToSignUpClicked.invoke() },
                exception = EmailException("Email exception")
            )
        }
    }

    LaunchedEffect(key1 = Unit, block = {
        //todo correct it
        signInViewModel.obtainEvent(SignInEvent.ErrorScreen(UndefinedException("Hello World")))
    })
}

@Composable
@Preview(showBackground = true)
fun PreviewSignInScreen() {
    SignInScreen({}, {})
}