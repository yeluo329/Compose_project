package com.example.module_my.enum

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.module_my.R

enum class MineMenu(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val menuId: Int
) {
    /**
     * 更换主题
     */
    THEME(R.string.change_theme, R.mipmap.img_theme, MINE_MENU_ID_THEME),

    /**
     * 博客菜单
     */
    BLOG(R.string.blog, R.mipmap.img_blog, MINE_MENU_ID_BLOG),

    /**
     * 微信公众号
     */
    WECHAT(R.string.weachat, R.mipmap.img_weachat, MINE_MENU_ID_WE_CHAT)
}


const val MINE_MENU_ID_THEME = 1
const val MINE_MENU_ID_BLOG = 2
const val MINE_MENU_ID_WE_CHAT = 3