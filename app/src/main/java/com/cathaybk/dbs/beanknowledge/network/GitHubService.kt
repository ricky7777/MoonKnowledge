package com.cathaybk.dbs.beanknowledge.network

import com.cathaybk.dbs.beanknowledge.model.GitHubUser
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Ricky on 2022/7/25.
 */
interface GitHubService {
    @GET("users")
    fun getUserList(): Call<List<GitHubUser>>
}