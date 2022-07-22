package com.cathaybk.dbs.beanknowledge.network

import com.cathaybk.dbs.beanknowledge.model.WaitingNumGetModel
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by HouYi on 2022/7/22.
 */
interface WaitingNumApi {

    @GET("num/1")// 設置一個GET連線，路徑為num/1
    fun getNum(): Call<WaitingNumGetModel>// 取得的回傳資料用aitingNumGetModel物件接收

    //https://jsonplaceholder.typicode.com/albums/{id}
    @GET("num/{id}")// 用{}表示路徑參數，@Path會將參數帶入至該位置
    fun getNumByIdFromPath(@Path("id") Id: Int): Call<WaitingNumGetModel>

    //https://jsonplaceholder.typicode.com/albums?postId={Id}
    @GET("num")
    fun getNumById(@Query("postId") Id: Int): Call<List<WaitingNumGetModel>>

    //post albumsData to https://jsonplaceholder.typicode.com
    @POST("num")// 用@Body表示要傳送Body資料
    fun postNum(@Body numData: WaitingNumGetModel): Call<WaitingNumGetModel>
}