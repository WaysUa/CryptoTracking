package com.main.feat_tracking.ui.views

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.main.feat_tracking.ui.components.SearchAppBar
import com.main.feat_tracking.viewmodel.TrackingViewModel
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NewApi")
@Composable
fun TrackingViewSearch(
    trackingViewModel: TrackingViewModel = koinViewModel(),
    onClickedIconBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            SearchAppBar(
                text = trackingViewModel.searchTextState.value,
                onTextChange = { trackingViewModel.updateSearchTextState(it) },
                onCloseClicked = { onClickedIconBack.invoke() },
                onSearchClicked = { /* todo some */ }
            )
        }
    ) {

    }
}