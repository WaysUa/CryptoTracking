package com.main.feat_signup.ui.views

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.core.R
import com.main.core.ui.theme.DarkColor
import com.main.core.ui.theme.MalibuLightColor
import com.main.core.ui.theme.OrangeColor
import com.main.core.ui.theme.authButtonColors
import com.main.feat_signup.data.SignUpInputTextStates
import com.main.feat_signup.viewmodel.SignUpViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpViewLoading(
    onGoToSignInClicked: () -> Unit,
    signUpInputTextStates: SignUpInputTextStates,
    signUpViewModel: SignUpViewModel = koinViewModel(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkColor)
            .padding(16.dp)
            .padding(bottom = 25.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Sign Up",
            fontSize = 40.sp,
            fontWeight = FontWeight.W700,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 8.dp),
            color = Color.White
        )

        OutlinedTextField(
            value = signUpInputTextStates.username.value,
            onValueChange = { signUpInputTextStates.username.value = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            colors = authButtonColors(),
            singleLine = true
        )

        OutlinedTextField(
            value = signUpInputTextStates.email.value,
            onValueChange = { signUpInputTextStates.email.value = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = authButtonColors(),
            singleLine = true
        )

        OutlinedTextField(
            value = signUpInputTextStates.password.value,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            onValueChange = { signUpInputTextStates.password.value = it },
            label = { Text("Password") },
            colors = authButtonColors(),
            singleLine = true,
            visualTransformation = if (signUpInputTextStates.passwordVisibility.value) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                val visibilityIcon = if (signUpInputTextStates.passwordVisibility.value) {
                    painterResource(id = R.drawable.icon_show_password)
                } else {
                    painterResource(id = R.drawable.icon_hide_password)
                }
                IconButton(
                    onClick = {
                        signUpInputTextStates.passwordVisibility.value =
                            !signUpInputTextStates.passwordVisibility.value
                    }
                ) {
                    Image(
                        painter = visibilityIcon,
                        contentDescription = "Toggle password visibility"
                    )
                }
            }
        )

        OutlinedTextField(
            value = signUpInputTextStates.confirmPassword.value,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            onValueChange = { signUpInputTextStates.confirmPassword.value = it },
            label = { Text("Confirm Password") },
            colors = authButtonColors(),
            singleLine = true,
            visualTransformation = if (signUpInputTextStates.confirmPasswordVisibility.value) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                val visibilityIcon = if (signUpInputTextStates.confirmPasswordVisibility.value) {
                    painterResource(id = R.drawable.icon_show_password)
                } else {
                    painterResource(id = R.drawable.icon_hide_password)
                }
                IconButton(
                    onClick = {
                        signUpInputTextStates.confirmPasswordVisibility.value =
                            !signUpInputTextStates.confirmPasswordVisibility.value
                    }) {
                    Image(
                        painter = visibilityIcon,
                        contentDescription = "Toggle password visibility"
                    )
                }
            }
        )

        Button(
            onClick = {
                signUpViewModel.signUp(
                    signUpInputTextStates.email.value,
                    signUpInputTextStates.password.value
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 22.dp)
                .height(55.dp)
                .clip(RoundedCornerShape(18.dp)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MalibuLightColor,
                contentColor = Color.White,
            )
        ) {
            CircularProgressIndicator(
                color = Color.White
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Already have an account?",
                color = Color.Gray
            )
            Spacer(modifier = Modifier.padding(start = 7.dp))
            Text(
                text = "Sign In",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    onGoToSignInClicked.invoke()
                }
            )
        }
    }
}