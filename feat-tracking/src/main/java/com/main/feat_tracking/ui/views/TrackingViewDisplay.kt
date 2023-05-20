package com.main.feat_tracking.ui.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.main.core.res.theme.DarkColor
import com.main.feat_tracking.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TrackingViewDisplay(
    onClickedIconSearch: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.navigation_icon_toolbar),
                        contentDescription = "Navigation Icon"
                    )
                },
                title = {
                    Text(text = "CryptoTracking")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = DarkColor,
                    titleContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = { onClickedIconSearch.invoke() }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search Coins",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) {

    }
}