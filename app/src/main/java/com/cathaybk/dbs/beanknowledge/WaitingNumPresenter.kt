package com.cathaybk.dbs.beanknowledge

import com.cathaybk.dbs.beanknowledge.model.WaitingNumGetModel
import com.cathaybk.dbs.beanknowledge.model.WaitingNumImageIdModel

/**
 * Created by HouYi on 2022/7/21.
 */
class WaitingNumPresenter(val view: WaitingNumContract.View) : WaitingNumContract.Presenter {

    private var clickCount = 0
    override fun showClickChange() {
        val sourceData = WaitingNumGetModel()
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
        return (sourceData.num + clickCount < 99)
    }

    private fun addCount(sourceData: WaitingNumGetModel) {
        sourceData.num += (clickCount + 1)
    }

    private fun getImageIdModel(sourceData: WaitingNumGetModel): WaitingNumImageIdModel {
//        run let apply with
        return WaitingNumImageIdModel().apply {
            leftImageId = getImgId(sourceData.num / 10)
            rightImageId = getImgId(sourceData.num % 10)
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