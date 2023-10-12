package com.example.appbase.utils

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.example.appbase.BaseApplication
import com.ramcosta.composedestinations.BuildConfig

object ToastUtil {


    fun shortShow(message: String) {
        Toast.makeText(BaseApplication.instance.applicationContext, message, Toast.LENGTH_SHORT)
            .show()
    }


    fun debugShow(message: String) {
        if (BuildConfig.DEBUG) {
            shortShow(message)
        }
    }


    fun shortShow(message: String, context: Context?) {
        if (context == null) {
            shortShow(message)
        } else {
            Toast.makeText(context, message, Toast.LENGTH_SHORT)
                .show()
        }
    }

    fun longShow(message: String) {
        Toast.makeText(
            BaseApplication.instance.applicationContext,
            message, Toast.LENGTH_LONG
        ).show()
    }
}