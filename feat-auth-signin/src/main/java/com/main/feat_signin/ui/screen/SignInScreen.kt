package com.main.feat_signin.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.main.feat_signin.data.SignInEvent
import com.main.feat_signin.data.SignInInputTextStates
import com.main.feat_signin.data.SignInViewState
import com.main.feat_signin.ui.views.SignInViewDisplay
import com.main.feat_signin.viewmodel.SignInViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignInScreen(
    onGoToSignUpClicked: () -> Unit,
    signInViewModel: SignInViewModel = koinViewModel()
) {
    val viewState = signInViewModel.signInViewState.collectAsState()

    val usernameOrEmail = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    val signInInputTextStates = SignInInputTextStates(
        usernameOrEmail, password, passwordVisibility
    )

    when (viewState.value) {
        is SignInViewState.Display -> {
            SignInViewDisplay(signInInputTextStates = signInInputTextStates) {
                onGoToSignUpClicked.invoke()
            }
        }
        is SignInViewState.Error -> {

        }
        is SignInViewState.Loading -> {

        }
        is SignInViewState.Success -> {

        }
    }

    LaunchedEffect(key1 = Unit, block = {
        signInViewModel.obtainEvent(SignInEvent.EnterScreen)
    })
}

@Composable
@Preview(showBackground = true)
fun PreviewSignInScreen() {
    SignInScreen({})
}