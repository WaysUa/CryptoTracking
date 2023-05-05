package com.main.feat_tracking.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.main.core.EventHandler
import com.main.feat_tracking.data.TrackingEvent
import com.main.feat_tracking.data.TrackingViewState

class TrackingViewModel(

) : ViewModel(), EventHandler<TrackingEvent> {

    private val _trackingViewState: MutableLiveData<TrackingViewState> = MutableLiveData(TrackingViewState.Display)
    val trackingViewState: LiveData<TrackingViewState> = _trackingViewState

    private val _searchTextState: MutableState<String> = mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchTextState(text: String) {
        _searchTextState.value = text
    }

    override fun obtainEvent(event: TrackingEvent) {
        when(event) {
            is TrackingEvent.EnterScreen -> {
                _trackingViewState.value = TrackingViewState.Display
            }
            is TrackingEvent.SearchScreen -> {
                _trackingViewState.value = TrackingViewState.Searching
            }
        }
    }
}