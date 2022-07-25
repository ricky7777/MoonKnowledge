package com.cathaybk.dbs.beanknowledge

import com.cathaybk.dbs.beanknowledge.model.WaitingNumGetModel
import com.cathaybk.dbs.beanknowledge.model.WaitingNumImageIdModel
import com.cathaybk.dbs.beanknowledge.network.BeanknowledgeService
import com.cathaybk.dbs.beanknowledge.network.RetrofitManager

/**
 * Created by HouYi on 2022/7/21.
 */
class WaitingNumPresenter(val view: WaitingNumContract.View) : WaitingNumContract.Presenter {

    private var clickCount = 0
    override fun showClickChange() {

        val service = RetrofitManager().getRetrofit().create(BeanknowledgeService::class.java)
        val result = service.getWaitingNumber().execute().body()

        val sourceData = result
        if (isValid(sourceData)) {
            addCount(sourceData)
            val imageData = getImageIdModel(sourceData)
            view.showNum(imageData)
        } else {
            errorFlow()
        }
    }

    private fun errorFlow() {
        // show dialog
    }

    private fun isValid(sourceData: WaitingNumGetModel): Boolean {
        return (sourceData.waitingNum + clickCount < 99)
    }

    private fun addCount(sourceData: WaitingNumGetModel) {
        sourceData.waitingNum += (++clickCount)
    }

    private fun getImageIdModel(sourceData: WaitingNumGetModel): WaitingNumImageIdModel {
//        run let apply with
        return WaitingNumImageIdModel().apply {
            leftImageId = getImgId(sourceData.waitingNum / 10)
            rightImageId = getImgId(sourceData.waitingNum % 10)
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