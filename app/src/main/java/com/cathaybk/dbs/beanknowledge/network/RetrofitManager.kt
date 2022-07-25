package com.cathaybk.dbs.beanknowledge.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by HouYi on 2022/7/22.
 */
object RetrofitManager {
    private val URL = "http://localhost:8080/"
    private val URL_GITHUB_TEST = "https://api.github.com/"
    fun getBeanRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getGitHubRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_GITHUB_TEST)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
