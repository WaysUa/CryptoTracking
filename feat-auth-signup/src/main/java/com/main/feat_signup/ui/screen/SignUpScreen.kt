package com.main.feat_signup.ui.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.main.feat_signup.data.SignUpEvent
import com.main.feat_signup.data.SignUpInputTextStates
import com.main.feat_signup.data.SignUpViewState
import com.main.feat_signup.ui.views.SignUpViewDisplay
import com.main.feat_signup.ui.views.SignUpViewLoading
import com.main.feat_signup.viewmodel.SignUpViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    onGoToSignInClicked: () -> Unit,
    signUpViewModel: SignUpViewModel = koinViewModel()
) {
    val viewState = signUpViewModel.signUpViewState.collectAsState()

    val username = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }

    val signUpInputTextStates = SignUpInputTextStates(
        username, email, password, confirmPassword,
        passwordVisibility, confirmPasswordVisibility
    )

    when (val state = viewState.value) {
        is SignUpViewState.Display -> {
            Log.d("MyLog", "Display")
            SignUpViewDisplay(
                onGoToSignInClicked = { onGoToSignInClicked.invoke() },
                signUpInputTextStates = signUpInputTextStates
            )
        }
        is SignUpViewState.Loading -> {
            Log.d("MyLog", "Loading")
            SignUpViewLoading(
                onGoToSignInClicked = { onGoToSignInClicked.invoke() },
                signUpInputTextStates = signUpInputTextStates
            )
        }
        is SignUpViewState.Error -> {
            Log.d("MyLog", "Error")
        }
        is SignUpViewState.Success -> {
            Log.d("MyLog", "Success")
        }
    }

    LaunchedEffect(key1 = Unit, block = {
        signUpViewModel.obtainEvent(SignUpEvent.EnterScreen)
    })
}

@Composable
@Preview(showBackground = true)
fun PreviewSignUpScreen() {
    SignUpScreen({})
}