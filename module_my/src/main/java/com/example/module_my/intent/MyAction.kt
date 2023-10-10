package com.example.module_my.intent

import android.widget.Toast
import androidx.navigation.NavController
import com.example.appbase.routeConfig.MyRouteConfig
import com.example.appbase.utils.ToastUtil

class MyAction(navController: NavController) {

    /**
     *  返回
     */
    val back: () -> Unit = {
        navController.popBackStack()
    }

    /**
     *  跳转博客界面
     */

    val toMyBlog: () -> Unit = {
        navController.navigate(MyRouteConfig.BLOG)
    }

    /**
     * 更改主题
     */
    val changeTheme: () -> Unit = {
        ToastUtil.longShow("敬请期待")
    }
}