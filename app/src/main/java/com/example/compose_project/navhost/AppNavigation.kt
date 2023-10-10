package com.example.compose_project.navhost

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.example.appbase.routeConfig.LoginRouteConfig
import com.example.appbase.utils.ToastUtil
import com.example.compose_project.Home.tabone.TabOneScreen
import com.example.compose_project.MyApp
import com.example.compose_project.NavGraphs
import com.example.compose_project.definable.Def
import com.example.compose_project.destinations.TabOneScreenDestination
import com.example.compose_project.destinations.WeatherScreenDestination
import com.example.compose_project.welcome.WeatherScreen
import com.example.module_login.LoginScreen
import com.example.module_project.ProjectScreen
import com.example.module_project.destinations.ProjectScreenDestination
import com.example.module_square.SquareScreen
import com.example.module_square.destinations.SquareScreenDestination
import com.ramcosta.composedestinations.scope.resultBackNavigator
import com.ramcosta.composedestinations.utils.composable
import com.example.module_login.destinations.LoginScreenDestination

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = LoginRouteConfig.MAIN_PAGE) {
        navigation(route = Def.GRAPH_HOME, startDestination = TabOneScreenDestination.route) {
            addHomeGraph(navController)
        }
        //开始界面
        composable(WeatherScreenDestination) {
            WeatherScreen(
                navigator = destinationsNavigator(navController),
                resultNavigator = resultBackNavigator(navController)
            )
        }
        //登录界面
        composable(LoginScreenDestination) {
            LoginScreen(navController = destinationsNavigator(navController)) {
                ToastUtil.shortShow(it, MyApp.CONTEXT)
            }
        }

    }
}


fun NavGraphBuilder.addHomeGraph(navController: NavHostController) {
    composable(TabOneScreenDestination) {
        TabOneScreen(destinationsNavigator(navController))
    }

    composable(SquareScreenDestination) {
        SquareScreen(destinationsNavigator(navController))
    }

    composable(ProjectScreenDestination) {
        ProjectScreen()
    }

}