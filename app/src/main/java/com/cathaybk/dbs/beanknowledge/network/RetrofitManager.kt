package com.cathaybk.dbs.beanknowledge.network

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by HouYi on 2022/7/22.
 */
class RetrofitManager {

    val URL = "http://localhost:8080/"
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
