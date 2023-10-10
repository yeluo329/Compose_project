package com.example.compose_project.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.compose_project.R

enum class Tabs(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val tabId: Int
) {

    /**
     * 首页
     */
    HOME_PAGE(R.string.home, R.mipmap.home_dark, TAB_ID_HOME),

    /**
     * 广场
     */

    SQUARER_PAGE(R.string.square, R.mipmap.home_dark, TAB_ID_SQUARE),

    /**
     * 动态
     *
     *
     *
     */
    DISCOVER_PAGE(R.string.discover, R.mipmap.home_dark, TAB_ID_DISCOVER),

    /**
     * 我的
     */
    MINE_PAGE(R.string.mine, R.mipmap.mine_dark, TAB_ID_MY)

}

/**
 * tabId 0
 */
const val TAB_ID_HOME = 0

/**
 * tabId 1
 */
const val TAB_ID_SQUARE = 1
const val TAB_ID_DISCOVER = 2
const val TAB_ID_MY = 3