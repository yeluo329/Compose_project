package com.example.appbase.network

import com.example.appbase.network.bean.UserInfo

object AppUserUtil {
    var userInfo: UserInfo? = null
    fun onLogin(userInfo: UserInfo) {
        this.userInfo = userInfo
    }
}