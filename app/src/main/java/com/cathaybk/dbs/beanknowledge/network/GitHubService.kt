package com.cathaybk.dbs.beanknowledge.network

import com.cathaybk.dbs.beanknowledge.model.GitHubUserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Ricky on 2022/7/25.
 */
interface GitHubService {
    @GET("users")
    fun getUserList(): Call<List<GitHubUserModel>>

    @GET("users/{id}")
    fun getUserById(@Path("id") Id:Int): Call<GitHubUserModel>
}