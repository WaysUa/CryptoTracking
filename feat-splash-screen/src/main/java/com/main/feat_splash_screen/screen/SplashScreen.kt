package com.main.feat_splash_screen.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.main.core.ui.theme.DarkBackgroundAppIcon
import com.main.feat_splash_screen.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    systemUiController: SystemUiController = rememberSystemUiController(),
    onFinished: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackgroundAppIcon),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(170.dp),
            contentDescription = "Logo",
            painter = painterResource(id = R.drawable.app_icon)
        )
    }

    SideEffect {
        systemUiController.setSystemBarsColor(DarkBackgroundAppIcon)
    }

    LaunchedEffect(key1 = Unit, block = {
        delay(2500)
        onFinished.invoke()
    })
}