package com.example.compose_project.Screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import com.example.compose_project.theme.Blue
import com.example.compose_project.theme.Dark
import com.example.compose_project.ui.TAB_ID_HOME
import com.example.compose_project.ui.TAB_ID_SQUARE
import com.example.compose_project.ui.TAB_ID_DISCOVER
import com.example.compose_project.ui.TAB_ID_MY
import com.example.compose_project.ui.Tabs

//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun MainUi(myAction: MyAction, homeAction: IntentAction) {
//    var currentIndex by remember {
//        mutableStateOf(TAB_ID_HOME)
//    }
//    val tabs = Tabs.values()
//    Scaffold(bottomBar = {
//        BottomNavigation{
//            tabs.forEachIndexed { index, tabs ->
//                BottomNavigationItem(selected = currentIndex == index,
//                    onClick = { currentIndex = index },
//                    icon = {
//                        Icon(
//                            painter = painterResource(id = tabs.icon),
//                            contentDescription = null,
//                            modifier = Modifier
//                                .height(30.dp)
//                                .width(30.dp)
//                        )
//                    }, label = {
//                        Text(text = stringResource(tabs.title))
//                    }, selectedContentColor = Blue,
//                    unselectedContentColor = Dark
//                )
//            }
//        }
//    }) {
//        when (currentIndex) {
//            TAB_ID_HOME -> {
//                HomeScreen(homeAction)
//            }
//
//            TAB_ID_SQUARE -> {
//
//            }
//
//            TAB_ID_DISCOVER -> {
//
//            }
//
//            TAB_ID_MY -> {
//                MyScreen(myAction = myAction)
//            }
//
//
//        }
//    }
//}