package com.example.compose_project.Screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appbase.utils.ToastUtil

import com.example.compose_project.R
import com.example.compose_project.ui.MENU_ID_1
import com.example.compose_project.ui.MENU_ID_2
import com.example.compose_project.ui.MENU_ID_3
import com.example.compose_project.ui.MainMenu

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            text = stringResource(id = R.string.main_string_head),
            fontSize = 14.sp,
            modifier = Modifier.padding(vertical = 20.dp)
        )
        val mainMenu = MainMenu.values()
        mainMenu.forEachIndexed { _, mainMenu ->
            MainMenuUi(title = mainMenu.title, icon = mainMenu.icon, menuId = mainMenu.menuId) {
                when (it) {
                    MENU_ID_1 -> {
                        ToastUtil.shortShow("当前天气")
                    }

                    MENU_ID_2 -> {

                    }

                    MENU_ID_3 -> {

                    }
                }
            }

        }
    }
}