package com.main.feat_tracking.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.core.EventHandler
import com.main.feat_tracking.data.TrackingEvent
import com.main.feat_tracking.data.TrackingViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TrackingViewModel(

) : ViewModel(), EventHandler<TrackingEvent> {

    private val _trackingViewState: MutableStateFlow<TrackingViewState> = MutableStateFlow(TrackingViewState.Display)
    val trackingViewState: StateFlow<TrackingViewState> = _trackingViewState

    private val _searchTextState: MutableState<String> = mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchTextState(text: String) {
        _searchTextState.value = text
    }

    override fun obtainEvent(event: TrackingEvent) {
        viewModelScope.launch(Dispatchers.IO) {
            when(event) {
                is TrackingEvent.EnterScreen -> {
                    _trackingViewState.emit(TrackingViewState.Display)
                }
                is TrackingEvent.SearchScreen -> {
                    _trackingViewState.emit(TrackingViewState.Searching)
                }
            }
        }
    }
}