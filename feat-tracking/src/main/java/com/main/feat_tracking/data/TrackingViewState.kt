package com.main.feat_tracking.data

sealed class TrackingViewState {

    object Display : TrackingViewState()

    object Searching : TrackingViewState()
}