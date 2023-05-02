package com.main.feat_onboarding.data

import androidx.annotation.DrawableRes
import com.main.core.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String,
) {
    object FirstScreen : OnBoardingPage(
        image = R.drawable.first,
        title = "Top Coins",
        description = "get access to all information's about the top coins in the market"
    )

    object SecondScreen : OnBoardingPage(
        image = R.drawable.second,
        title = "Be Borderless",
        description = "tracking your favorite coins allows you to get custom notifications about the coin and a lot more"
    )

    object ThirdScreen : OnBoardingPage(
        image = R.drawable.third,
        title = "Hottest News",
        description = "You have access to the hottest and newest news about the crypto market"
    )
}
