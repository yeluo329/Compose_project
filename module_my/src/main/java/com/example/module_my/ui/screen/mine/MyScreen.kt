package com.example.module_my.ui.screen.mine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.module_my.R
import com.example.module_my.enum.MineMenu
import com.example.module_my.intent.MyAction
import com.example.module_my.ui.theme.lightGray


@Composable
fun MyScreen(myAction: MyAction) {
    Column(Modifier.fillMaxWidth()) {
        Image(painter = painterResource(id = R.mipmap.round_icon),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp, 24.dp)
                .clickable { myAction.back() })
        Row(
            modifier = Modifier
                .background(color = Color.White)
                .height(200.dp)
                .padding(10.dp)
        ) {
            val headImg =
                rememberImagePainter(data = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202002%2F26%2F20200226204448_sZSun.thumb.1000_0.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1699167551&t=7bb482f616302f5b902b874e45b45640")
            Image(
                painter = headImg,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp, 60.dp)
                    .align(Alignment.CenterVertically)
                    .clip(shape = RoundedCornerShape(50))
            )
            Text(
                text = "雷晶湛",
                Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(
                modifier = Modifier
                    .height(0.5.dp)
                    .background(lightGray)
                    .fillMaxWidth()
            )

        }
        val mineMenu = MineMenu.values()
        //            var showDialog by remember {
//                mutableStateOf(false)
//            }
        LazyColumn(content = {
            item {
                mineMenu.forEachIndexed { _, mineMenu ->
                    ItemMenu(mineMenu = mineMenu) {
                        when (mineMenu.menuId) {
                            MineMenu.BLOG.menuId -> {
                                myAction.toMyBlog()
                            }

                            MineMenu.THEME.menuId -> {

                            }
                        }
                    }
                }
            }
        })
    }
}