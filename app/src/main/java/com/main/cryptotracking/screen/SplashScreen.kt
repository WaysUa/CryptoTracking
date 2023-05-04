package com.main.cryptotracking.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.main.core.ui.theme.DarkColor
import com.main.voicevortex.R

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(id = R.drawable.app_icon_splash),
            contentDescription = "Splash Screen Icon",
            modifier = Modifier
                .fillMaxWidth(0.73f)
                .fillMaxHeight(0.73f)
                .padding(top = 23.dp)
        )
    }
}