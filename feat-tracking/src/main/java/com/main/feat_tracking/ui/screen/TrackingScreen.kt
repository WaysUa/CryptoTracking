package com.main.feat_tracking.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
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
    val viewState = trackingViewModel.trackingViewState.observeAsState()

    when (val state = viewState.value) {
        TrackingViewState.Display -> TrackingViewDisplay {
            trackingViewModel.obtainEvent(TrackingEvent.SearchScreen)
        }
        TrackingViewState.Searching -> TrackingViewSearch {
            trackingViewModel.obtainEvent(TrackingEvent.EnterScreen)
        }
        else -> throw NotImplementedError("Unexpected recording state")
    }

    LaunchedEffect(key1 = viewState, block = {
        trackingViewModel.obtainEvent(TrackingEvent.EnterScreen)
    })
}