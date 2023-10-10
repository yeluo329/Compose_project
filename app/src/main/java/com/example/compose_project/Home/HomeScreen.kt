package com.example.compose_project.Home

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.compose_project.destinations.ShopScreenDestination

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.result.NavResult
import com.ramcosta.composedestinations.result.ResultRecipient
import com.ramcosta.composedestinations.spec.DestinationStyle
import kotlinx.coroutines.MainScope
import java.util.logging.Handler


@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    resultRecipient: ResultRecipient<ShopScreenDestination, String>
) {
    var word = ""
    resultRecipient.onNavResult(listener = {
        if (it is NavResult.Value) {
            word = it.value
        }
    })

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        //最多只能创建16个引用
        val (text, button, backText) = createRefs()
        Text(text = "欢迎进入首页", modifier = Modifier.constrainAs(text) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        })
        Button(onClick = { navigator.navigate(ShopScreenDestination) },
            modifier = Modifier
                .constrainAs(button) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(text.bottom, margin = 10.dp)
                    width = Dimension.value(200.dp)
                    height = Dimension.value(40.dp)
                }) {
            Text(text = "商城")
        }

        Text(text = word, modifier = Modifier.constrainAs(backText) {
            top.linkTo(button.bottom)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }, fontSize = 20.sp)


    }


}

object NonDismissableDialog : DestinationStyle.Dialog {
    override val properties = DialogProperties(
        dismissOnClickOutside = true,
        dismissOnBackPress = false,
    )
}