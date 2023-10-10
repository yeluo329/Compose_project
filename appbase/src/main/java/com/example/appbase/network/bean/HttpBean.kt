package com.example.appbase.network.bean




import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class BasicBean<T>(
    var data: T?,
    var errorCode: Int,
    var errorMsg: String
)

@Parcelize
data class UserInfo(
    var id: Int,
    var admin: Boolean,
    var chapterTops: MutableList<Int>,
    var coinCount: Int,
    var collectIds: MutableList<Int>,
    var email: String,
    var icon: String,
    var nickname: String,
    var password: String,
    var token: String,
    var type: Int,
    var username: String,
) : Parcelable