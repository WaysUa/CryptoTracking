package com.main.feat_tracking.data

sealed class TrackingEvent {

    object EnterScreen : TrackingEvent()

    object SearchScreen : TrackingEvent()
}