package com.example.compose_project.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberImagePainter
import com.example.appbase.check.navigateWithCall

import com.example.appbase.navhost.QueryToImageShape
import com.example.compose_project.destinations.WeatherScreenDestination

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.result.ResultBackNavigator
import com.example.module_login.destinations.LoginScreenDestination

//开始界面
@RootNavGraph(start = true)
@Destination
@Composable
fun WeatherScreen(
    navigator: DestinationsNavigator, resultNavigator: ResultBackNavigator<String>
) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (bgIv, btn) = createRefs()
        val rememberImagePainter =
            rememberImagePainter(data = "https://img1.baidu.com/it/u=174314668,4200091718&fm=253&fmt=auto&app=138&f=JPEG?w=1080&h=1920")
        Image(
            painter = rememberImagePainter,
            contentDescription = null,
            modifier = Modifier
                .clip(QueryToImageShape(120f))
                .constrainAs(bgIv) {
                    width = Dimension.matchParent
                },
            contentScale = ContentScale.FillWidth
        )
        Button(onClick = {
            //进入登录界面,并且弹出自己
            navigator.navigateWithCall(LoginScreenDestination, builder = {
                popUpTo(WeatherScreenDestination.route) { inclusive = true }
            })
        }, modifier = Modifier.constrainAs(btn) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            Text(text = "进入登录界面")
        }
    }

}



