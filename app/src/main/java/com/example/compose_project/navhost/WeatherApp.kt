package com.example.appbase.navhost

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.compose_project.R
import com.example.compose_project.navhost.AppNavigation

import com.example.compose_project.theme.WeatherComposeTheme

import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.DestinationsNavHost


@Composable
fun WeatherApp() {
    WeatherComposeTheme {
        //导航栏   theme的含义
        val rememberSystemUiController = rememberSystemUiController()
        SideEffect {
            rememberSystemUiController.setSystemBarsColor(
                color = Color.White
            )
        }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            AppNavigation(navController)
        }


    }
//    val navController = rememberNavController()
//    NavHost(
//        navController = navController,
//        startDestination = WeatherScreenDestination.route
//    ) {
//        welcomeNavHost(navController)
//        composable(LoginScreenDestination) {
//            LoginScreen(onBack = { destinationsNavigator(navController).popBackStack() }) {
//                navController.navigate(HomeScreenDestination.route)
//            }
//        }
//
//        composable(HomeScreenDestination) {
//            HomeScreen(
//                navigator = destinationsNavigator(navController),
//                resultRecipient = resultRecipient()
//            )
//        }
//
//
//    }
    //父级的Composable,内部放置Navigation相关内容
    //NavController是导航的管理者,内部维护着页面跳转过程的回退栈
    //NavHost提供容器供内部页面的切换
//    NavHost(navController = navController, startDestination = AppRouteConfig.ROOT) {
//        //app模块
//        appNavHost(navController)
//
//        //我的模块
//        myNavHost(navController)
//    }


//    NavHost(navController = navController, startDestination = "Welcome") {
//        composable("Welcome") {
//            WelcomeScreen(navController)
//        }
//
//        composable("Login") {
//            LoginScreen(LoginAction(navController))
//        }
//
//        composable("Home") {
////            HomeScreen()
//        }
//
//
//        composable("shop") {
//            ShopScreen(navController)
//        }
//    }


}


@Composable
fun ShopScreen(navController: NavController) {
    Column {
        Image(
            painter = painterResource(id = R.mipmap.img_enter),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp, 40.dp)

                .clickable {
                    navController.navigate("Home") {
                        launchSingleTop = true
                    }
                }
        )
    }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "欢迎来到商城")


    }
}

@Composable
fun LoginScreen() {
    Column(verticalArrangement = Arrangement.Center) {
        Box(contentAlignment = Alignment.Center) {
            //背景
            Image(
                painter = painterResource(id = R.mipmap.beautiful_girl),
                contentScale = ContentScale.FillHeight,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .clip(QueryToImageShape(120f))
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
        ) {
            Button(onClick = {

            }) {
                Text("登录")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { }) {
                Text(text = "注册")
            }
        }

    }
}


//@Destination
//@Composable
//fun WelcomeScreen(navController: DestinationsNavigator) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "欢迎进入天气之子APP", fontSize = 20.sp)
//        Spacer(modifier = Modifier.height(10.dp))
//        Button(onClick = {
//            navController.navigate("Login") {
//                popUpTo("Welcome") { inclusive = true }
//            }
//        }) {
//            Text(text = "Go to Login")
//        }
//    }
//}

@Stable
class QueryToImageShape(var hudu: Float = 100f) : Shape {
    override fun createOutline(
        size: Size, layoutDirection: LayoutDirection, density: Density
    ): Outline {
        val path = Path()
        path.moveTo(0f, 0f)
        path.lineTo(0f, size.height - hudu)
        path.quadraticBezierTo(size.width / 2f, size.height, size.width, size.height - hudu)
        path.lineTo(size.width, 0f);
        path.close()
        return Outline.Generic(path)
    }

}


//enum class WeatherTabs(
//    @StringRes val title: Int, @DrawableRes val icon: Int,
//    val direction: Direction
//) {
//    TAB_ONE(R.string.tab_one, R.drawable.ic_tab_one_black_24dp, TabOneScreenDestination),
//    SQUARE(R.string.square, R.drawable.ic_square_black_24dp, SquareScreenDestination),
//    WECHAT(R.string.wechat, R.drawable.ic_wechat_black_24dp, WxListsScreenDestination),
//    KNOWLEDGE_SYSTEM(
//        R.string.knowledge_system,
//        R.drawable.ic_knowledge_system_black_24dp,
//        SystemScreenDestination
//    ),
//    PROJECT(R.string.project, R.drawable.ic_project_black_24dp, ProjectScreenDestination),
//
//}

