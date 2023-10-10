package com.example.compose_project.Login



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