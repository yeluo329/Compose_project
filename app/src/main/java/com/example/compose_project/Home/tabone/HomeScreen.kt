package com.example.compose_project.Home.tabone

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.appbase.routeConfig.MyRouteConfig
import com.example.module_square.destinations.SquareScreenDestination

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination(navGraph = MyRouteConfig.ROOT, route = MyRouteConfig.MAIN_PAGE)
@Composable
fun HomeScreen(navigator: DestinationsNavigator) {


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text("tab one", modifier = Modifier.clickable {
            navigator.navigate(SquareScreenDestination)
        })
    }
}