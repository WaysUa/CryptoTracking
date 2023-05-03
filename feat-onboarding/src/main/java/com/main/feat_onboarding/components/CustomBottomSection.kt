package com.main.feat_onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.core.ui.theme.MalibuLightColor
import com.main.feat_onboarding.R

@Preview
@Composable
fun CustomBottomSection(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(9.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onButtonClick,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MalibuLightColor
            ),
            modifier = Modifier.height(48.dp).width(200.dp),
            elevation = ButtonDefaults.elevation(0.dp),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(
                text = "Next",
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}