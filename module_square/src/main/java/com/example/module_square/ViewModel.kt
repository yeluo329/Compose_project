package com.example.module_square

import android.view.View
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appbase.network.bean.Article
import com.example.appbase.network.http.HttpService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private var service: HttpService) : ViewModel() {



}


data class SquareViewState(
    val isRefreshing: Boolean = false,
    val listState: LazyListState = LazyListState(),

)

sealed class SquareViewAction {
    object Refresh : SquareViewAction()
}


