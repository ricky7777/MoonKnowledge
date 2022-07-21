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
        val imageData = WaitingNumImageIdModel()
        if (checkValid(sourceData)) {
            changeNum()
        }
        numToImage(sourceData, imageData)
        view.showNum(imageData)
    }

    private fun checkValid(sourceData: WaitingNumGetModel): Boolean {
        return (sourceData.Num + clickCount < 99)
    }

    private fun changeNum() {
        clickCount += 1
    }

    private fun numToImage(sourceData: WaitingNumGetModel, imageData: WaitingNumImageIdModel) {
        sourceData.Num += clickCount
        when (sourceData.Num / 10) {
            0 -> imageData.leftImageId = R.drawable.num0
            1 -> imageData.leftImageId = R.drawable.num1
            2 -> imageData.leftImageId = R.drawable.num2
            3 -> imageData.leftImageId = R.drawable.num3
            4 -> imageData.leftImageId = R.drawable.num4
            5 -> imageData.leftImageId = R.drawable.num5
            6 -> imageData.leftImageId = R.drawable.num6
            7 -> imageData.leftImageId = R.drawable.num7
            8 -> imageData.leftImageId = R.drawable.num8
            9 -> imageData.leftImageId = R.drawable.num9
        }
        when (sourceData.Num % 10) {
            0 -> imageData.rightImageId = R.drawable.num0
            1 -> imageData.rightImageId = R.drawable.num1
            2 -> imageData.rightImageId = R.drawable.num2
            3 -> imageData.rightImageId = R.drawable.num3
            4 -> imageData.rightImageId = R.drawable.num4
            5 -> imageData.rightImageId = R.drawable.num5
            6 -> imageData.rightImageId = R.drawable.num6
            7 -> imageData.rightImageId = R.drawable.num7
            8 -> imageData.rightImageId = R.drawable.num8
            9 -> imageData.rightImageId = R.drawable.num9
        }
    }
}