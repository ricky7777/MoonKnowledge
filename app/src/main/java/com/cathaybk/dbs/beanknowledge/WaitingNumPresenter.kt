package com.cathaybk.dbs.beanknowledge

import com.cathaybk.dbs.beanknowledge.model.WaitingNumModel

/**
 * Created by HouYi on 2022/7/21.
 */
class WaitingNumPresenter(val view: WaitingNumContract.View) : WaitingNumContract.Presenter {
    var data = WaitingNumModel()
    var rightNumber = data.rightNum
    var leftNumber = data.leftNum

    override fun showNumContent() {
        view.showNum(data)
    }

    override fun showClickChange() {
        cancelTrading()
        view.showNum(data)
    }

    private fun cancelTrading() {
        if (rightNumber == 9 && leftNumber == 9) {
            return
        }

        if (rightNumber == 9) {
            calculCarryNum()
        } else {
            calculNum()
        }
        updateVariable()
    }

    private fun updateVariable() {
        data.rightNum = rightNumber
        data.leftNum = leftNumber
    }

    private fun calculCarryNum() {
        rightNumber = 0
        leftNumber += 1
    }

    private fun calculNum() {
        rightNumber += 1
    }
}