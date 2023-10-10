package com.example.compose_project.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.compose_project.model.Person
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

// 该注解表示根路由页面


@Composable
fun HomeScreen(navigator: DestinationsNavigator) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        //最多只能创建16个引用
        val (text, button) = createRefs()
        Text(text = "欢迎进入首页", modifier = Modifier.constrainAs(text) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        })
        Button(onClick = { },
            modifier = Modifier
                .constrainAs(button) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(text.bottom, margin = 10.dp)
                    width = Dimension.value(200.dp)
                    height = Dimension.value(40.dp)
                }) {
            Text(text = "商城")
        }
    }
}





@Composable
fun ThirdScreen(
    navigator: DestinationsNavigator,
    person: Person
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("ThirdScreen", fontSize = 20.sp)
        Text("$person ", fontSize = 20.sp)
    }
}


