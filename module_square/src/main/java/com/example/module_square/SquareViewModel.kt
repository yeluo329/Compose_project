package com.example.module_square

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SquareViewModel @Inject constructor() : ViewModel() {
    var viewStates by mutableStateOf(HomeViewState())
        private set

    val state: LazyListState = LazyListState(0)

    init {
        viewStates = viewStates.copy(
            titles = listOf(
                TabTitle(101, "广场"),
                TabTitle(102, "推荐"),
                TabTitle(103, "问答")
            )
        )
    }

}


data class HomeViewState(val titles: List<TabTitle> = emptyList())

