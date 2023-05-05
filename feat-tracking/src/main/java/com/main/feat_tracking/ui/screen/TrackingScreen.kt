package com.main.feat_tracking.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import com.main.feat_tracking.data.TrackingEvent
import com.main.feat_tracking.data.TrackingViewState
import com.main.feat_tracking.ui.views.TrackingViewDisplay
import com.main.feat_tracking.viewmodel.TrackingViewModel
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun TrackingScreen(
    trackingViewModel: TrackingViewModel = koinViewModel()
) {
    val viewState = trackingViewModel.trackingViewState.observeAsState()

    when (val state = viewState.value) {
        TrackingViewState.Display -> TrackingViewDisplay()
        //todo change Unit to any screen
        TrackingViewState.Searching -> Unit
        else -> throw NotImplementedError("Unexpected recording state")
    }

    LaunchedEffect(key1 = viewState, block = {
        trackingViewModel.obtainEvent(TrackingEvent.EnterScreen)
    })
}