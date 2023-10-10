package com.example.module_my.navhost

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.appbase.routeConfig.MyRouteConfig
import com.example.module_my.intent.MyAction
import com.example.module_my.ui.screen.mine.MyScreen


fun NavGraphBuilder.myNavHost(navController: NavController) {
    val action = MyAction(navController = navController)

    navigation(startDestination = MyRouteConfig.MAIN_PAGE, route = MyRouteConfig.ROOT) {
        composable(MyRouteConfig.BLOG) {

        }

        composable(MyRouteConfig.MAIN_PAGE) {
            MyScreen(myAction = action)
        }
    }
}