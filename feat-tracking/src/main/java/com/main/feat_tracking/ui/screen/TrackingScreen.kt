package com.main.feat_tracking.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.main.feat_tracking.data.TrackingEvent
import com.main.feat_tracking.data.TrackingViewState
import com.main.feat_tracking.ui.views.TrackingViewDisplay
import com.main.feat_tracking.ui.views.TrackingViewSearch
import com.main.feat_tracking.viewmodel.TrackingViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun TrackingScreen(
    trackingViewModel: TrackingViewModel = koinViewModel()
) {
    val viewState = trackingViewModel.trackingViewState.collectAsState()

    when (val state = viewState.value) {
        TrackingViewState.Display -> TrackingViewDisplay {
            trackingViewModel.obtainEvent(TrackingEvent.SearchScreen)
        }
        TrackingViewState.Searching -> TrackingViewSearch {
            trackingViewModel.obtainEvent(TrackingEvent.EnterScreen)
        }
    }

    LaunchedEffect(key1 = Unit, block = {
        trackingViewModel.obtainEvent(TrackingEvent.EnterScreen)
    })
}