package com.example.compose_project.Home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.appbase.routeConfig.MyRouteConfig
import com.example.compose_project.R


sealed class BottomNavRoute(
    var routeName: String,
    @StringRes var stringId: Int,
    var icon: ImageVector
) {
    object Home : BottomNavRoute(MyRouteConfig.MAIN_PAGE, R.string.home, Icons.Default.Home)

    object MENU : BottomNavRoute(MyRouteConfig.MENU, R.string.menu, Icons.Default.Menu)
    object LIKE : BottomNavRoute(MyRouteConfig.LIKE, R.string.like, Icons.Default.Favorite)
    object Profile : BottomNavRoute(MyRouteConfig.PROFILE, R.string.profile, Icons.Default.Person)
}