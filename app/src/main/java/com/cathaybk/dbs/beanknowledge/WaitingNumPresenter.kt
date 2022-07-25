package com.cathaybk.dbs.beanknowledge

import android.util.Log
import com.cathaybk.dbs.beanknowledge.model.GitHubUserModel
import com.cathaybk.dbs.beanknowledge.model.WaitingNumResponseModel
import com.cathaybk.dbs.beanknowledge.model.WaitingNumImageIdModel
import com.cathaybk.dbs.beanknowledge.network.BeanKnowledgeService
import com.cathaybk.dbs.beanknowledge.network.GitHubService
import com.cathaybk.dbs.beanknowledge.network.RetrofitManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by HouYi on 2022/7/21.
 */
class WaitingNumPresenter(val view: WaitingNumContract.View) : WaitingNumContract.Presenter {

    private var clickCount = 0
    private var sourceId = " "
    private var sourceNum = 0

    override fun updateWaitingNum() {
        val service = RetrofitManager.getBeanRetrofit().create(BeanKnowledgeService::class.java)
        service.getWaitingNumber().enqueue(object : Callback<WaitingNumResponseModel> {
            override fun onResponse(
                call: Call<WaitingNumResponseModel>,
                response: Response<WaitingNumResponseModel>
            ) {
                Log.d("", "")
                sourceNum = response.body()!!.waitingNum
                clickCount = 0
                val imageData = getImageIdModel(sourceNum)
                view.showNum(imageData)
            }

            override fun onFailure(call: Call<WaitingNumResponseModel>, t: Throwable) {
                Log.d("", "")
            }
        })
    }

    override fun showClickChange() {
        if (isValid(sourceNum)) {
            val imageData = getImageIdModel(addCount(sourceNum))
            view.showNum(imageData)
        } else {
            errorFlow()
        }
    }

    override fun showGitHubUsers() {
        val service = RetrofitManager.getGitHubRetrofit().create(GitHubService::class.java)
        service.getUserById(24).enqueue(object : Callback<GitHubUserModel> {
            override fun onResponse(
                call: Call<GitHubUserModel>,
                response: Response<GitHubUserModel>
            ) {
                //Log.d("", "")
                sourceId = response.body()!!.login
                Log.d("TESTID", sourceId)
            }

            override fun onFailure(call: Call<GitHubUserModel>, t: Throwable) {
                Log.d("", "")
            }
        })
    }

    private fun isValid(sourceData: Int): Boolean {
        return (sourceData + clickCount < 99)
    }

    private fun errorFlow() {
        // show dialog
    }

    private fun addCount(sourceData: Int): Int {
        return sourceData + (++clickCount)
    }

    private fun getImageIdModel(sourceData: Int): WaitingNumImageIdModel {
//        run let apply with
        return WaitingNumImageIdModel().apply {
            leftImageId = getImgId(sourceData / 10)
            rightImageId = getImgId(sourceData % 10)
        }
    }

    private fun getImgId(num: Int): Int {
        when (num) {
            0 -> return R.drawable.num0
            1 -> return R.drawable.num1
            2 -> return R.drawable.num2
            3 -> return R.drawable.num3
            4 -> return R.drawable.num4
            5 -> return R.drawable.num5
            6 -> return R.drawable.num6
            7 -> return R.drawable.num7
            8 -> return R.drawable.num8
            9 -> return R.drawable.num9
        }
        return R.drawable.num0
    }
}