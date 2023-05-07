package com.main.feat_signin.ui.screen

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
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.core.R
import com.main.core.ui.theme.DarkColor
import com.main.core.ui.theme.MalibuLightColor
import com.main.core.ui.theme.authButtonColors

@Composable
fun SignInScreen(
    onGoToSignUpClicked: () -> Unit,
    onSignInCLicked: () -> Unit
) {
    val usernameOrEmail = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkColor)
            .padding(16.dp)
            .padding(bottom = 15.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Sign In",
            fontSize = 40.sp,
            fontWeight = FontWeight.W700,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 8.dp),
            color = Color.White
        )

        OutlinedTextField(
            value = usernameOrEmail.value,
            onValueChange = { usernameOrEmail.value = it },
            label = { Text("Username or Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            colors = authButtonColors(),
            singleLine = true
        )

        OutlinedTextField(
            value = password.value,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            onValueChange = { password.value = it },
            label = { Text("Password") },
            colors = authButtonColors(),
            singleLine = true,
            visualTransformation = if (passwordVisibility.value) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                val visibilityIcon = if (passwordVisibility.value) {
                    painterResource(id = R.drawable.icon_show_password)
                } else {
                    painterResource(id = R.drawable.icon_hide_password)
                }
                IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }) {
                    Image(
                        painter = visibilityIcon,
                        contentDescription = "Toggle password visibility"
                    )
                }
            }
        )

        Button(
            onClick = { onSignInCLicked.invoke() },
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
            Text(text = "Sign In", fontSize = 22.sp)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Don't have an account?",
                color = Color.Gray
            )
            Spacer(modifier = Modifier.padding(start = 10.dp))
            Text(
                text = "Sign Up",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    onGoToSignUpClicked.invoke()
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewSignInScreen() {
    SignInScreen({}, {})
}