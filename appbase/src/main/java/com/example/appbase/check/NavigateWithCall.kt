package com.example.appbase.check

import androidx.navigation.NavOptionsBuilder
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.spec.Direction

fun DestinationsNavigator.navigateWithCall(
    route: String,
    onNavigateFailed: ((IllegalArgumentException) -> Unit)? = null,
    builder: (NavOptionsBuilder.() -> Unit) = {}
) {
    try {
        this.navigate(route, builder = builder)
    } catch (e: IllegalArgumentException) {
        onNavigateFailed?.invoke(e)
    }
}

fun DestinationsNavigator.navigateWithCall(
    direction: Direction,
    onNavigateFailed: ((IllegalArgumentException) -> Unit)? = null,
    builder: (NavOptionsBuilder.() -> Unit) = {}
) {
    try {
        this.navigate(direction = direction, builder = builder)
    } catch (e: IllegalArgumentException) {
        onNavigateFailed?.invoke(e)
    }
}

