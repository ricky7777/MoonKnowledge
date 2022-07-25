package com.cathaybk.dbs.beanknowledge.network

import com.cathaybk.dbs.beanknowledge.model.BeanKnowledgeTopicModel
import com.cathaybk.dbs.beanknowledge.model.WaitingNumGetModel
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by HouYi on 2022/7/22.
 */
interface BeanKnowledgeService {
    @GET("waitline")// 設置一個GET連線，路徑為waitline
    fun getWaitingNumber(): Call<WaitingNumGetModel>

    @GET("topics")
    fun getTopics(): Call<List<BeanKnowledgeTopicModel>>
}