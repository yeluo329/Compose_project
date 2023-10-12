package com.example.compose_project.Home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.appbase.routeConfig.MyRouteConfig
import com.ramcosta.composedestinations.annotation.Destination


@Destination(route = MyRouteConfig.PROFILE)
@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text("profile", modifier = Modifier.clickable {

        })
    }
}