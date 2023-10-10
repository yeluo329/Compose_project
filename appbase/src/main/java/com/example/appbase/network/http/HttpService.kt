package com.example.appbase.network.http

import com.example.appbase.network.bean.BasicBean
import com.example.appbase.network.bean.UserInfo
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface HttpService {

    companion object {
        const val url = "https://www.wanandroid.com"
    }

    //登录
    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(
        @Field("username") userName: String,
        @Field("password") password: String,
    ): BasicBean<UserInfo>

    @FormUrlEncoded
    @POST("/user/register")
    suspend fun register(
        @Field("username") userName: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String,
    ): BasicBean<UserInfo>


}