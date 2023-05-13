package com.main.feat_signup.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.core.ui.theme.GreenDarkColor
import com.main.core.ui.theme.TurquoiseColor
import com.main.feat_signup.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuccessAlertDialog(
    onOkayClicked: () -> Unit
) {
    AlertDialog(
        onDismissRequest = {},
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.66f)
                .background(Color.Black)
                .clip(RoundedCornerShape(10.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(GreenDarkColor)
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_success),
                    contentDescription = "image success",
                    modifier = Modifier
                        .height(90.dp)
                        .width(90.dp)
                )
            }

            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight(0.54f)
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Verify your email address",
                        color = Color.Black,
                        fontWeight = FontWeight.W500,
                    )
                    Text(
                        text = "We have sent the mail to your email\ncheck it, and sign in",
                        color = Color.DarkGray,
                        fontSize = 16.sp
                    )
                }

                Button(
                    onClick = { onOkayClicked.invoke() },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(bottom = 4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = TurquoiseColor
                    )
                ) {
                    Text(text = "Okay")
                }
            }
        }
    }
}