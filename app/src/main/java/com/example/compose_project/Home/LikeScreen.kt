package com.example.compose_project.Home

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


@Destination(route = MyRouteConfig.MENU)
@Composable
fun LikeScreen() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text("收藏敬请期待", modifier = Modifier.clickable {

        })
    }
}