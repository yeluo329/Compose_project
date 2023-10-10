package com.example.module_square

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.appbase.check.navigateWithCall
import com.example.appbase.routeConfig.ProjectRouterConfig
import com.example.appbase.routeConfig.SquareRouteConfig
import com.example.appbase.utils.ToastUtil
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination(navGraph = SquareRouteConfig.ROOT, route = SquareRouteConfig.MAIN_PAGE)
@Composable
fun SquareScreen(navController: DestinationsNavigator) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text("square", modifier = Modifier.clickable {
            navController.navigateWithCall(ProjectRouterConfig.MAIN_PAGE, onNavigateFailed = {
                ToastUtil.debugShow("找不到${ProjectRouterConfig.MAIN_PAGE}")
            })
        })
    }
}


