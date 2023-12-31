package com.example.module_my.ui.screen.mine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import com.example.module_my.enum.MineMenu
import com.example.module_my.ui.theme.lightGray
import com.example.module_my.R

/**
 * @author：HuangLinqing
 * @date ：2022/4/13
 * @desc：item 菜单
 */

@Preview
@Composable
fun ItemMenu(mineMenu: MineMenu, onClick: () -> Unit) {
    Column(modifier = Modifier.clickable {
        onClick()
    }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp)
        ) {

            Image(
                painter = painterResource(id = mineMenu.icon),
                contentDescription = null,
                Modifier.size(30.dp, 30.dp)
            )
            Text(
                text = stringResource(id = mineMenu.title),
                Modifier
                    .padding(start = 15.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )

            Image(
                painter = painterResource(id = R.mipmap.img_enter), contentDescription = null,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

        }
        Spacer(
            modifier = Modifier
                .height(0.5.dp)
                .background(lightGray)
                .fillMaxWidth()
        )
    }

}





