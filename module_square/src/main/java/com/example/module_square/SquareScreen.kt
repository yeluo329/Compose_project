package com.example.module_square

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.example.appbase.check.navigateWithCall
import com.example.appbase.routeConfig.ProjectRouterConfig
import com.example.appbase.routeConfig.SquareRouteConfig
import com.example.appbase.theme.ThemeColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@RootNavGraph(start = true)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination(navGraph = SquareRouteConfig.ROOT, route = SquareRouteConfig.MAIN_PAGE)
@Composable
fun SquareScreen(
    navController: DestinationsNavigator,
    viewModel: SquareViewModel = hiltViewModel()
) {
    val titles = viewModel.viewStates.titles
    val scopeState = rememberCoroutineScope()
    val tabs = Tabs.values()
    var currentIndex by remember {
        mutableStateOf(TAB_ID_0)
    }
    Scaffold(bottomBar = {
        BottomNavigation {
            tabs.forEachIndexed { index, tabs ->
                BottomNavigationItem(selected = currentIndex == index,
                    onClick = { currentIndex = index },
                    icon = {
                        Icon(
                            painter = painterResource(id = tabs.icon),
                            contentDescription = null,
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                    }, label = {
                        Text(text = tabs.title)
                    }, selectedContentColor = Blue,
                    unselectedContentColor = ThemeColor.themeUi
                )
            }
        }
    }, content = {

        when (currentIndex) {
            TAB_ID_0 -> {
                Column {
                    var pagerState = rememberPagerState(initialPage = 0)
                    TextTabBar(
                        index = pagerState.currentPage,
                        tabTexts = titles, onTabSelected = { index ->
                            scopeState.launch {
                                pagerState.scrollToPage(index)
                            }
                        }
                    )

                    HomeSearchBar(
                        onSearchClick = {
                            navController.navigateWithCall(ProjectRouterConfig.MAIN_PAGE)
                        }
                    )
                    val state = rememberPullRefreshState(
                        refreshing = false,
                        onRefresh = { /*TODO*/ },
                    )
                    Box(
                        Modifier
                            .fillMaxSize()
                            .pullRefresh(state)
                    ) {
                        LazyColumn(modifier = Modifier.fillMaxSize(), viewModel.state) {
                            items(100) {
                                Text(text = "我的数字" + it)
                            }
                        }
                        PullRefreshIndicator(
                            refreshing = true,
                            state = state,
                            Modifier.align(Alignment.TopCenter)
                        )
                    }

                }
            }

            TAB_ID_1 -> {
                navController.navigateWithCall(ProjectRouterConfig.MAIN_PAGE)
            }
        }

    }


    )

}

enum class Tabs(
    val title: String,
    @DrawableRes val icon: Int,
    val tabId: Int
) {

    /**
     * 首页
     */
    HOME_PAGE("广场", R.mipmap.home_dark, TAB_ID_0),


    /**
     * 我的
     */
    MINE_PAGE("我的", R.mipmap.mine_dark, TAB_ID_1)

}

/**
 * tabId 0
 */
const val TAB_ID_0 = 0

/**
 * tabId 1
 */
const val TAB_ID_1 = 1

@Composable
fun TextTabBar(
    index: Int,
    tabTexts: List<TabTitle>,
    modifier: Modifier = Modifier,
    contentAlign: Alignment = Alignment.Center,
    bgColor: Color = ThemeColor.themeUi,
    contentColor: Color = Color.White,
    onTabSelected: ((index: Int) -> Unit)? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp)
            .background(bgColor)
            .horizontalScroll(state = rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .align(contentAlign)
        ) {
            tabTexts.forEachIndexed { i, tabTitle ->
                Text(
                    text = tabTitle.text,
                    fontSize = if (index == i) 20.sp else 15.sp,
                    fontWeight = if (index == i) FontWeight.SemiBold else FontWeight.Normal,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(horizontal = 10.dp)
                        .clickable {
                            onTabSelected?.invoke(i)
                        },
                    color = contentColor
                )
            }
        }
    }
}

data class TabTitle(
    val id: Int,
    val text: String,
    var cachePosition: Int = 0,
    var selected: Boolean = false
)


@Composable
fun HomeSearchBar(
    onSearchClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .background(color = ThemeColor.themeUi)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .height(30.dp)
                .align(alignment = Alignment.Top)
                .weight(1f)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(12.5.dp)
                )
                .clickable { onSearchClick() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "搜索",
                tint = ThemeColor.themeUi,
                modifier = Modifier
                    .size(25.dp)
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = "搜索关键词以空格形式隔开",
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }
        }
    }
}