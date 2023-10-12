package com.example.module_login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

import com.example.appbase.routeConfig.LoginRouteConfig
import com.example.appbase.theme.ThemeColor

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appbase.routeConfig.MyRouteConfig
import com.example.appbase.routeConfig.SquareRouteConfig
import com.example.appbase.utils.ToastUtil
import com.example.module_login.destinations.LoginScreenDestination


@OptIn(ExperimentalComposeUiApi::class)
@RootNavGraph(start = true)
@Destination(navGraph = LoginRouteConfig.ROOT, route = LoginRouteConfig.MAIN_PAGE)
@Composable
fun LoginScreen(
    navController: DestinationsNavigator,
    viewModel: LoginViewModel = hiltViewModel(),
    error: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val keyboardService = LocalTextInputService.current
    val viewStates = viewModel.viewStates
    LaunchedEffect(Unit) {
        viewModel.viewEvents.collect {
            if (it is LoginViewEvent.SuccessMessage) {
                error.invoke("登录成功")
                navController.navigate(SquareRouteConfig.MAIN_PAGE) {
                    popUpTo(LoginScreenDestination.route) { inclusive = true }
                }
            } else if (it is LoginViewEvent.ErrorMessage) {
                error.invoke(it.message)
            }
        }
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ThemeColor.themeUi)
            .pointerInput(Unit) {
                detectTapGestures(
                    //手指点击其他区域对键盘进行隐藏
                    onPress = {
                        keyboardController?.hide()
                    })
            },
    ) {
        //导航栏
        item {
            Box(
                modifier = Modifier
                    .padding(bottom = 80.dp)
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .align(Alignment.CenterStart)
                        .clickable { navController.popBackStack() })
            }
        }
        item {
            Box(Modifier.fillMaxWidth()) {
                Text(
                    text = "天气之子",
                    modifier = Modifier
                        .padding(bottom = 50.dp)
                        .align(Alignment.Center),
                    fontSize = 24.sp,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        item {

            TextField(
                value = viewStates.account,
                textStyle = TextStyle(lineHeight = 24.sp, fontSize = 16.sp),
                onValueChange = {
                    viewModel.dispatch(LoginViewAction.UpdateAccount(it))
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight()
                    .padding(20.dp)
                    .clickable {
                        keyboardController?.show()
                    },
                placeholder = {
                    Text(text = "请输入账号", fontSize = 16.sp, color = Color(0xFF888888))
                },
                label = {
                    Text(
                        text = "账号",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    placeholderColor = ThemeColor.themeUi,
                    cursorColor = Color.White,
                    textColor = Color.White
                ),
                keyboardActions = KeyboardActions { keyboardService?.hideSoftwareKeyboard() }
            )
        }

        item {

            TextField(
                value = viewStates.password,
                textStyle = TextStyle(lineHeight = 24.sp, fontSize = 16.sp),
                onValueChange = {
                    viewModel.dispatch(LoginViewAction.UpdatePassword(it))
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight()
                    .padding(20.dp)
                    .clickable {
                        keyboardController?.show()
                    },
                placeholder = {
                    Text(text = "请输入密码", fontSize = 16.sp, color = Color(0xFF888888))
                },
                label = {
                    Text(
                        text = "密码",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    placeholderColor = ThemeColor.themeUi,
                    cursorColor = Color.White,
                    textColor = Color.White
                )
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(36.dp)
                    .background(color = Color(0xFFE5E5E5), shape = RoundedCornerShape(10.dp))
                    .clickable {
                        keyboardController?.hide()
//                        viewModel.dispatch(LoginViewAction.Login)
                        navController.navigate(SquareRouteConfig.MAIN_PAGE)
                    }
            ) {
                Text(
                    text = "登录",
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }
    }

}

@Stable
class QueryToImageShape(var hudu: Float = 100f) : Shape {
    override fun createOutline(
        size: Size, layoutDirection: LayoutDirection, density: Density
    ): Outline {
        val path = Path()
        path.moveTo(0f, 0f)
        path.lineTo(0f, size.height - hudu)
        path.quadraticBezierTo(size.width / 2f, size.height, size.width, size.height - hudu)
        path.lineTo(size.width, 0f);
        path.close()
        return Outline.Generic(path)
    }

}
