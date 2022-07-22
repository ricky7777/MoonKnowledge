package com.cathaybk.dbs.beanknowledge.network

import com.cathaybk.dbs.beanknowledge.model.WaitingNumGetModel
import retrofit2.Call

/**
 * Created by HouYi on 2022/7/22.
 */
class WaitingNumRepository {
    private val NumApi: WaitingNumApi by lazy {
        //打api
        RetrofitManager().getRetrofit().create(NumApi::class.java)
    }

    fun getAllNum(): Call<WaitingNumGetModel> {
        return NumApi.getNum()
    }

    fun getNumByIdFromPath(id: Int): Call<WaitingNumGetModel> {
        return NumApi.getNumByIdFromPath(id)
    }

    fun getNumById(id: Int): Call<List<WaitingNumGetModel>> {
        return NumApi.getNumById(id)
    }

    fun postNum(numData: WaitingNumGetModel): Call<WaitingNumGetModel> {
        return NumApi.postNum(numData)
    }

}
