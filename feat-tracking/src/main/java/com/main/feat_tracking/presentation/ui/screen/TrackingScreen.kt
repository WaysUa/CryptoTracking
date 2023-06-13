package com.main.feat_tracking.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.main.feat_tracking.data.TrackingEvent
import com.main.feat_tracking.data.TrackingViewState
import com.main.feat_tracking.presentation.ui.views.TrackingViewDisplay
import com.main.feat_tracking.presentation.ui.views.TrackingViewSearch
import com.main.feat_tracking.presentation.viewmodel.TrackingViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun TrackingScreen(
    modifier: Modifier,
    trackingViewModel: TrackingViewModel = koinViewModel()
) {
    val viewState = trackingViewModel.trackingViewState.collectAsState()

    when (val state = viewState.value) {
        TrackingViewState.Display -> TrackingViewDisplay(
            modifier = modifier,
            onClickedIconSearch = {
                trackingViewModel.obtainEvent(TrackingEvent.SearchScreen)
            }
        )
        TrackingViewState.Searching -> TrackingViewSearch (
            modifier = modifier,
            onClickedIconBack = {
                trackingViewModel.obtainEvent(TrackingEvent.EnterScreen)
            }
        )
    }

    LaunchedEffect(key1 = Unit, block = {
        trackingViewModel.obtainEvent(TrackingEvent.EnterScreen)
    })
}