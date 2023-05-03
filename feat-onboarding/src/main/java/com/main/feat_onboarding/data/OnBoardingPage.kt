package com.main.feat_onboarding.data

import androidx.annotation.DrawableRes
import com.main.feat_onboarding.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String,
) {
    object FirstScreen : OnBoardingPage(
        image = R.drawable.icon_onboarding_first,
        title = "Track Your Crypto",
        description = "Track and buy cryptocurrencies at real value, trade with ease and confidence\n" +
                "in one safe and fast application."
    )

    object SecondScreen : OnBoardingPage(
        image = R.drawable.icon_onboarding_second,
        title = "Explore Best Coins",
        description = "All cryptos go through a rigorous evaluation process and are compared to " +
                "thousands of other crypto projects."
    )

    object ThirdScreen : OnBoardingPage(
        image = R.drawable.icon_onboarding_third,
        title = "Fast Optimization",
        description = "Ongoing optimization of portfolios to market conditions and adjustment of " +
                "cryptocurrency selection."
    )
}
