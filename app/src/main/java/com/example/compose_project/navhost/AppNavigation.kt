package com.example.compose_project.navhost

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navigation
import com.example.appbase.routeConfig.LoginRouteConfig
import com.example.appbase.routeConfig.MyRouteConfig
import com.example.appbase.theme.ThemeColor
import com.example.appbase.utils.ToastUtil
import com.example.compose_project.Home.BottomNavRoute
import com.example.compose_project.Home.ProfileScreen
import com.example.compose_project.Home.tabone.HomeScreen
import com.example.compose_project.MyApp
import com.example.compose_project.NavGraph
import com.example.compose_project.destinations.HomeScreenDestination
import com.example.compose_project.destinations.ProfileScreenDestination
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
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.navigate

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppNavigation(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(modifier = Modifier
        .statusBarsPadding()
        .navigationBarsPadding(),
        bottomBar = {
            when (currentDestination?.route) {
                BottomNavRoute.Home.routeName -> BottomNavBarView(navController)
                BottomNavRoute.Profile.routeName -> BottomNavBarView(navController)

            }

        },
        content = {
            NavHost(navController = navController, startDestination = MyRouteConfig.ROOT) {
                navigation(
                    route = MyRouteConfig.ROOT,
                    startDestination = HomeScreenDestination.route
                ) {
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
    )

}

fun NavGraphBuilder.addHomeGraph(navController: NavHostController) {
    composable(HomeScreenDestination) {
        HomeScreen(destinationsNavigator(navController))
    }

    composable(SquareScreenDestination) {
        SquareScreen(destinationsNavigator(navController))
    }

    composable(ProjectScreenDestination) {
        ProjectScreen()
    }

    composable(ProfileScreenDestination) {
        ProfileScreen()
    }

}

@Composable
fun BottomNavBarView(navController: NavController) {
    val bottomNavList = listOf(
        BottomNavRoute.Home,
        BottomNavRoute.Profile
    )
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        bottomNavList.forEach { screen ->
            BottomNavigationItem(
                modifier = Modifier.background(ThemeColor.themeUi),
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = null
                    )
                },
                label = { Text(text = stringResource(screen.stringId)) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.routeName } == true,
                onClick = {
                    if (currentDestination?.route != screen.routeName) {
                        navController.navigate(screen.routeName) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                })
        }
    }
}