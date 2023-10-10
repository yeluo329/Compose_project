package com.example.compose_project.Home.shop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.rememberNavHostEngine
import com.ramcosta.composedestinations.result.ResultBackNavigator


@Destination
@Composable
fun ShopScreen(resultNavigator: ResultBackNavigator<String>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        var text by remember { mutableStateOf("") }
        Text(text = "当前页面 Screen02", fontSize = 16.sp)
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.width(300.dp)
        )

        Button(onClick = {
            resultNavigator.navigateBack(result = text)
        }) {
            Text(text = "Go Back")
        }
    }

}