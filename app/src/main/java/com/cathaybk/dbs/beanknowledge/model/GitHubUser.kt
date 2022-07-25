package com.cathaybk.dbs.beanknowledge.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Ricky on 2022/7/25.
 */
data class GitHubUser(
    val login: String,

    @SerializedName("avatar_url")
    val avatarURL: String,

    @SerializedName("html_url")
    val htmlURL: String
)