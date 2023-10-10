package com.example.compose_project.Login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose_project.model.Man

import com.example.ui.TopBar.CenterTopAppBar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


//@OptIn(ExperimentalComposeUiApi::class)
//
//@Composable
//fun LoginScreen(onBack: () -> Unit, onLoginSuccess: () -> Unit) {
//    LoginScreen(LoginViewModel(), onBack, onLoginSuccess)
//}
//
//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@ExperimentalComposeUiApi
//@Composable
//fun LoginScreen(viewModel: LoginViewModel, onBack: () -> Unit, onLoginSuccess: () -> Unit) {
//    Scaffold(
//        topBar = {
//            CenterTopAppBar(
//                backgroundColor = MaterialTheme.colors.primary,
//                navigationIcon = {
//                    IconButton(onClick = onBack) {
//                        Icon(
//                            imageVector = Icons.Filled.ArrowBack,
//                            contentDescription = "go back",
//                            tint = MaterialTheme.colors.onPrimary,
//                        )
//                    }
//                },
//            ) {
//                Text(
//                    text = "用户登录",
//                    color = MaterialTheme.colors.onPrimary,
//                )
//            }
//        }
//
//    ) {
//
//    }

//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//
//        Text(text = manModel.toString(), fontSize = 20.sp)
////        Text(text = manModel.password, fontSize = 20.sp)
//
//        Button(onClick = {
////            viewModel.changeManValue(Man(manModel.name + "zyx", manModel.password + "456"))
//            viewModel.changeManValue(manModel + 2)
//        }) {
//            Text(text = "改变数据")
//        }
//
//        Button(onClick = { navigator.navigate(HomeScreenDestination()) }) {
//            Text(text = "登录")
//        }
//    }

//}
//
//@Composable
//internal fun LoginScreen() {
//
//}