package com.example.appbase.network

import com.example.appbase.network.http.HttpService
import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiCall {
    /**
     * 请求超时时间
     */
    private const val DEFAULT_TIMEOUT = 30000
    private lateinit var SERVICE: HttpService
    val retrofit: HttpService
        get() {
            if (!ApiCall::SERVICE.isInitialized) {
                SERVICE = Retrofit.Builder()
                    .client(okHttp)
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(HttpService.url)
                    .build()
                    .create(HttpService::class.java)

            }
            return SERVICE

        }

    val okHttp: OkHttpClient
        get() {
            return OkHttpClient.Builder().run {
                connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
                readTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
                writeTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
                build()
            }
        }

}